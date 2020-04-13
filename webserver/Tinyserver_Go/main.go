package main

import (
	"log"
	"net/http"
	"time"
)

func main() {
	server := &http.Server{
		Addr: ":4000",
		WriteTimeout: 2 * time.Second,
	}

	//Costomize Mux
	mux := http.NewServeMux()
	mux.Handle("/", &myHandler{})
	server.Handler = mux

	log.Println("Server starts")
	log.Println("=============")
	log.Fatal(server.ListenAndServe())
}

type myHandler struct{}

func (*myHandler)ServeHTTP(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("This is a Webpage from Go TinyServer"))
}
