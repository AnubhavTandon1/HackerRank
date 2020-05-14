import java.io.*;
import java.util.*;

public class Solution {
    static class Graph {
        HashMap<Integer, ArrayList<Integer>> nodes;
        Graph (int n) {
            nodes = new HashMap<>();
            for (int i = 1; i <= 2*n; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                nodes.put(i, list);
            }
        }
        
        void set_edge(int n1, int n2) {
            ArrayList<Integer> list1 = nodes.get(n1);
            ArrayList<Integer> list2 = nodes.get(n2);
            if (list1 != list2) {
                list1.addAll(list2);
                list2.forEach(i -> nodes.put(i, list1));
            }
        }
        
        void print_answer() {
            ArrayList<Integer> vertices = new ArrayList<Integer>();
            
            for (ArrayList<Integer> list : nodes.values()) {
                if (list.size() > 1)
                    vertices.add(list.size());
                list.clear();
            }
            System.out.print(Collections.min(vertices) + " ");
            System.out.println(Collections.max(vertices));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Graph G = new Graph(N);
        for (int i = 0; i < N; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();
            G.set_edge(n1, n2);
        }
        
        G.print_answer();
    }
}
