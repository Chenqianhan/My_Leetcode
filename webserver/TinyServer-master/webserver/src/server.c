#include <sys/socket.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <ctype.h>
#include <pthread.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <thread.h>

#include "variable.h"
#include "socket_wrap.h"
#include "unix_wrap.h"
#include "http_request.h"
#include "http_response.h"
#include "server_config.h"
#include "thread.h"

struct configItem configList[] = {
        {"ROOTDIR", 0},
        {"PORT", 0},
        {"METHOD", 0}
};

bool running = true;
char* dispatch_method = CONCURRENT;
char* root_dir = ROOTDIR;


int main(int argc, char* argv[]) {

    signal(SIGCHLD, SIG_IGN);

    /* Declare variable */
    int port_number = DEFAULT_PORT;
    int serv_fd, cli_fd;
    char serv_ip[BUFSIZE], cli_ip[BUFSIZE];
    struct sockaddr_in serv_addr, cli_addr;
    int reuse_on = 1, daemon_on = 0;
    int config_num = sizeof(configList)/sizeof(struct configItem);
    int option, i;

    // Get server configuration from config file
    get_config(".lab3-config", configList, config_num);

    for(i = 0; i < config_num; i++)
    {
        if (!strcmp(configList[i].key, "PORT"))
            port_number = atoi(configList[i].value);
        else if (!strcmp(configList[i].key, "ROOTDIR"))
            root_dir = configList[i].value;
        else if (!strcmp(configList[i].key, "METHOD"))
            dispatch_method = configList[i].value;
    }

    printf("[Server configuration]  Port:%d  Dir:%s  Method:%s\n", port_number, root_dir, dispatch_method);

    // Handle Command Line Options
    while((option=getopt(argc,argv,"hp:ds:")) != -1)
    {
        switch(option)
        {
            case 'h':
                printf("Usage: %s -p <port> -h(help) -d(daemon process) -s (fork|thread)\n", argv[0]);
                exit(0);
            case 'p':
                port_number = atoi(optarg);
                break;
            case 'd':
                daemon_on = 1;
                break;
            case 's':
                if (strcmp(optarg, "fork") == 0){
                    dispatch_method = "fork";
                }
                else if (strcmp(optarg, "thread") == 0){
                    dispatch_method = "thread";
                }
                else{
                    printf("Usage: %s -p <port> -h(help) -d(daemon process) -s (fork|thread)\n", argv[0]);
                    exit(3);
                }
                break;
            default:
                printf("Usage: %s -p <port> -h(help) -d(daemon process) -s (fork|thread)\n", argv[0]);
                exit(3);
        }
    }

    // Start daemon process
    if (daemon_on)
        init_daemon("TinyServer");

    // Declare the server socket
    serv_fd = Socket(AF_INET, SOCK_STREAM, 0);

    // Reuse same port
    setsockopt(serv_fd, SOL_SOCKET, SO_REUSEADDR, &reuse_on, sizeof(int));

    socklen_t serv_len = sizeof(serv_addr);
    socklen_t cli_len = sizeof(cli_addr);

    memset(&serv_addr, 0, serv_len);
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(port_number);

    //Bind address family
    Bind(serv_fd, (struct sockaddr *) &serv_addr, serv_len);

    //Listen to the socket
    Listen(serv_fd, 10);

    // Print the server information
    inet_ntop(AF_INET, &serv_addr.sin_addr.s_addr, serv_ip, sizeof(serv_ip));
    printf("TinyServer %s:%d is working!!!\n",
           inet_ntop(AF_INET, &serv_addr.sin_addr.s_addr, cli_ip, sizeof(cli_ip)),
           ntohs(serv_addr.sin_port));

    printf("==========waiting for client's request=========\n");

    pid_t parent_pid = getpid();

    while (running){
        cli_fd = Accept(serv_fd, (struct sockaddr *) &cli_addr, &cli_len);
        dispatch_connection(cli_fd, cli_addr);
    }
    if (getpid() == parent_pid)
        close(serv_fd);

    exit(0);


//    pid_t pid;

//    while (1) {
//
//        cli_fd = Accept(serv_fd, (struct sockaddr *) &cli_addr, &cli_len);
//
//        pid = Fork();
//
//        if (pid == 0) {
//            close(serv_fd);
//
//            // Print the client connection information
//            inet_ntop(AF_INET, &cli_addr.sin_addr.s_addr, cli_ip, sizeof(cli_ip));
//            printf("client IP:%s\tport:%d\t%d\n",
//                   inet_ntop(AF_INET, &cli_addr.sin_addr.s_addr, cli_ip, sizeof(cli_ip)),
//                   ntohs(cli_addr.sin_port), cli_fd);
//
//            // Handle the http request.
//            handle_http_request(cli_fd, root_dir);
//
//            close(cli_fd);
//
//            exit(0);
//        }
//
//        close(cli_fd);
//    }
//
//    close(serv_fd);
//    return 0;
}


