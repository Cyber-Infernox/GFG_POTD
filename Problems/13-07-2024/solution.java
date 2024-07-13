class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public void Dijkstra(int n, int m, List<List<int[]>> adj, int dist[], PriorityQueue<Pair> pq, int parent[]) {
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            int currNode = curr.node;
            int currDist = curr.dist;

            for (int[] a : adj.get(currNode)) {
                int newDest = a[0];
                int newDist = a[1];

                if ((dist[currNode] + newDist) < dist[newDest]) {
                    parent[newDest] = currNode;
                    dist[newDest] = dist[currNode] + newDist;
                    pq.add(new Pair(newDest, dist[newDest]));
                }
            }
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Code Here.
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[] { e[1], e[2] });
            adj.get(e[1]).add(new int[] { e[0], e[2] });
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        int parent[] = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Pair(1, 0));

        Dijkstra(n, m, adj, dist, pq, parent);

        List<Integer> ans = new ArrayList<>();

        if (dist[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }

        int val = n;

        while (val != -1) {
            ans.add(val);
            val = parent[val];
        }

        ans.add(dist[n]);
        Collections.reverse(ans);
        return ans;
    }
}