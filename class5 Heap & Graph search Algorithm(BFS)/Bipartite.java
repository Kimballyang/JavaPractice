package laiofferClass5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {
	public boolean isBipartite(List<GraphNode> graph){
		// use 0 and 1 to denote two different groups
		// the map maintains for each node which group it belongs to 
		HashMap<GraphNode,Integer> visited = new HashMap<GrapNode, Integer>();
		// the graph can be represented by a list of nodes(if it is not guaranteed
		// to be connected). we have to do BFS from each of the nodes
		for (GraphNode node: graph){
			if (!BFS(node, visited)){
				return false;
			}
		}
		return true;
	}
	
	private boolean BFS(GraphNode node, HashMao<GraphNode, Integer> visited){
		// if this node has been traversed, no need to do BFS again
		if (visited.containsKey(node)){
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		//start breadth-first-search from the node, since the node has not been
		// visited, we can assign it to any of the groups, for example, group 0.
		visited.put(node,0);
		while(!queue.isEmpty())	{
			GraphNode cur = queue.pill();
			// the group assigned for cur node.
			int curGroup = visited.get(cur);
			// the group assigned for any neighbor of cur node.
			int neiGroup = curGroup == 0?1 :0;
			for (GroupNode nei : cur.neighbors){
				//if the neighbor has not been visited, just put it in the queue
				// and choose the correct group
				if (!visited.containKey(nei)){
					visited.put(nei, neiGroup);
					queue.offer(nei);
				}else if (visited.get(nei) != neiGroup){
					//only if the neighbor has been traversed and the group does not
					// match to the desired one, return false
					return false;
				}
				// if the neighbor has been traversed and the group matches the 
				// desired one, we do not need to do anything
			}
		}
		return true;
	}

}
