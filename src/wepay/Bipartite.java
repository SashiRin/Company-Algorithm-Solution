package wepay;

import java.util.LinkedList;
import java.util.Queue;

class Bipartite {

    /*
    Time Complexity of the above approach is same as that Breadth First Search. In above
    implementation is O(V^2) where V is number of vertices.
     If graph is represented using adjacency list, then the complexity becomes O(V+E).
    */
    boolean isBipartite(int graph[][])
    {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        color[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neib = 0; neib < graph.length; neib++) {
                if (graph[cur][neib] == 1 && color[neib] == -1) {
                    color[neib] = 1 - color[cur];
                    queue.offer(neib);
                } else if (graph[cur][neib] == 1 && color[neib] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
 
    // Driver program to test above function
    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G))
           System.out.println("Yes");
        else
           System.out.println("No");
    }
}