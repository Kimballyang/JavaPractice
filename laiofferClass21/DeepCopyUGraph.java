package laiofferClass21;

import java.util.HashMap;
import java.util.List;

public class DeepCopyUGraph {
	public List<GraphNode> copy(List<GraphNode> graph){
		if (graph == null){
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
		for (GraphNode node : graph){
			if(!map.containsKey(node)){
				map.put(node,new GraphNode(node.key));
				DFS(node,map);
			}
		}
		return new ArrayList<GraphNode>(map.value());
	}
	
	private void DFS(GraphNode seed, HashMap<GraphNode, GraphNode> map){
		GraphNode copy = map.get(seed);
		for (GraphNode nei : seed.neighbors){
			if (!map.containsKey(nei)){
				map.put(nei, new GraphNode(nei.key));
				DFS(nei,map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}

}
