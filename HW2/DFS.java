import java.util.*;

public class DFS {

    private static Map<String, List<String>> adjacencyList = new HashMap<>();
    private static Set<String> visitedNodes = new HashSet<>();

    public static String DFSHelper(String currentNode) {
        visitedNodes.add(currentNode);

        StringBuilder result = new StringBuilder(currentNode + " ");

        for (String neighbor : adjacencyList.get(currentNode)) {
            if (!visitedNodes.contains(neighbor)) {
                result.append(DFSHelper(neighbor));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int instanceCount = scanner.nextInt();

        for (int i = 0; i < instanceCount; i++) {
            int nodeCount = scanner.nextInt();

            // Clear the adjacency list and visited nodes set for each test case
            adjacencyList.clear();
            visitedNodes.clear();

            scanner.nextLine();
            
            // Create a list to store nodes as they are read
			List<String> nodesOrderedList=new ArrayList<>();

			for (int j=0;j<nodeCount;j++){
				String[] inputLine=scanner.nextLine().trim().split(" ");
				
				// Store node separately in ordered list
				nodesOrderedList.add(inputLine[0]);
				
				// Add neighbors to our map.
				adjacencyList.put(inputLine[0],Arrays.asList(Arrays.copyOfRange(inputLine,1,inputLine.length)));
			}

			StringBuilder output=new StringBuilder();
			
			// Perform DFS on each node that has not been visited yet using ordered list of nodes
			for(String rootNode:nodesOrderedList){
			    if(!visitedNodes.contains(rootNode)){
			        output.append(DFSHelper(rootNode));
			    }
			}
			
		    System.out.println(output.toString().trim());
            
         }
     }
}
