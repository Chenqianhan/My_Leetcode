package TreeAndBinarySearchTree;

import dataStructure.TreeNode;

import java.util.*;

/**
 * Important problem that helps understanding TreeMap and TreeSet。
 * It can be further improved by claiming x, y, cal all in new data structure rather than using TreeMap.
 * This is a example:
 * @Override
 *        public int compareTo(Location that) {
 * 		if (this.x != that.x) // left to right, x increases
 * 			return Integer.compare(this.x, that.x);
 * 		if (this.y != that.y) // top to bottom, y increases
 * 			return Integer.compare(this.y, that.y);
 * 		return Integer.compare(this.val, that.val);
 *    }
 *
 * //Using ordered data structure such as TreeMap and TreeSet can be replaced by below if we don't need multiple sort.
 * List<Location> locations = new ArrayList<>();
 * Collections.sort(locations);
 */
public class NineEightySeven_VerticalOrderTraversalOfBinaryTree {
    TreeMap<Integer, Set<HorizontalNode>> column;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        column = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        //column.values() output in key order.
        for(Set<HorizontalNode> set:column.values()){
            List<Integer> list = new LinkedList<>();
            /*
            Iterator<HorizontalNode> itSet = set.iterator();
            while(itSet.hasNext()){
                list.add(itSet.next().val);
            }
            */
            //Not using iterator can drastically level up the performance.
            for (HorizontalNode horizontalNode : set) {
                list.add(horizontalNode.val);
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode node, int x, int y){
        if(node == null)
            return;

        column.putIfAbsent(x, new TreeSet<>());
        column.get(x).add(new HorizontalNode(y,node.val));
        dfs(node.left, x-1, y-1);
        dfs(node.right, x+1, y-1);
    }

    class HorizontalNode implements Comparable{
        public int y;
        public int val;

        public HorizontalNode(int y, int val){
            this.y = y;
            this.val = val;
        }

        public int compareTo(Object o) {
            HorizontalNode ss = (HorizontalNode) o;
            //if y==ss.y, compare val in ascending order.
            //else y!==ss.y, compare y in descending order Cuz we need to put the higher y first.
            return y==ss.y?(val>ss.val?1:-1):(y>ss.y?-1:1);
        }
    }
}
