# Graph

## Three Representations
- Edge List Representation
- Adjacency Matrix Representation
- Adjacency List Representation

## Graph Traversal
- BFS
- DFS

## Topological Sort

## Connected Components

## Minimum Spanning Tree
- A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted (un)directed graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. That is, it is a spanning tree whose sum of edge weights is as small as possible.

### Kruskal's Algorithm
Special case of **greedy** MST algorithm.

1. Consider the edges in ascending order of weight.
2. Add the edge to tree T unless doing so will create a cycle.

> How do we know whether adding a new edge will create a cycle?
Union Find will do it in Log * V time.

Running time: `E Log E` (in worst case). Since all the edges (E) needs to be added to the priority queue and later find min and each of these operations take Log `E time`.

### Prim's Algorithms
1. Start with vertex 0 and greedily grow the tree.
2. Add to T the min weight edge with exactly one endpoint in T.
3. Repeat until `V - 1` edges.

> How to find the minimum weight edge with exactly one endpoint in T?
Maintain a PQ of edges with (at least) on endpoint in T.

Running time:

*Lazy Implementation:* ` E Log E` (in worst case). Since all the edges (E) needs to be added to the priority queue and later find min and each of these operations take Log `E time`.

*Eager Implementation:* `E Log V`. In lazy implementation we store vertices so we have V inserts and V delete min and E decrease keys operations.

## Shortest Path
Finding the shortest path from a given vertex 'v' to every other vertex or a particular vertex.

### Dijkstra's Algorithm
1. Consider vertices in increasing order of distance from s
(non-tree vertex with the lowest distTo[] value).
2. Add vertex to tree and relax all edges pointing from that vertex.

#### Dijkstra's and Prim's Algorithm
***Main distinction:*** Rule used to choose next vertex for the tree.

- Prim’s: Closest vertex to the tree (via an undirected edge).
- Dijkstra’s: Closest vertex to the source (via a directed path)

Complexity : E Log V (V insert, V delete-min, E decrease-key).

### Acyclic shortest paths
1. Consider vertices in topological order.
2. Relax all edges pointing from that vertex.
Time Complexity: E + V. As it processes V vertices in topological order and relaxes E edges exactly once.

### Negative Weights
Finding shortest path with Dijikstra is not possible in this case.
#### Bellman-Ford Algorithm

1. Initialize distTo[s] = 0 and distTo[v] = ∞ for all other vertices.
2. Repeat V times: Relax each edge.

Complexity: EV
- [Arbitrage](http://blog.csdn.net/freezhanacmore/article/details/9722607)

### Ford - Warshall
-  all-pairs shortest path algorithm





## Graph Question:
- [ ] Implement all three kind of graph representation
- [ ] Implement BFS
- [ ] Implement DFS
- [ ] Implement Kruskal Algorithm
- [ ] Implement Prim's Algorithm
- [ ] Implement Dijikstra
- [ ] Implement Ford Washall
- [ ] Implement Bellman-Ford Algorithm
- [ ] Implement Acyclic shortest paths
- [ ] Is the graph Bipartite?
- [ ] Does the graph has cycle? (Union Find)
