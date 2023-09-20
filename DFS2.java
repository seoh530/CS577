import java.util.*;

public class DFS {
    // Create a graph using a HashMap where the key is a String and the value is an array of Strings
    private static Map<String, String[]> adjacencyList = new HashMap<>();

    // Create a map to keep track of visited nodes during DFS
    private static Map<String, Boolean> visitedNodes = new HashMap<>();
    
    public static String DFSHelper(Map<String, String[]> adjacencyList, String currentNode) {
        // Mark the current node as visited
        visitedNodes.put(currentNode, true);

        // Initialize the output string with the current node
        StringBuilder result = new StringBuilder(currentNode + " ");

        // Loop through all the neighbors of the current node
        for (String neighbor : adjacencyList.get(currentNode)) {
            // If the neighbor has not been visited, visit it recursively
            if (!visitedNodes.get(neighbor)) {
                visitedNodes.put(neighbor, true);
                result.append(DFSHelper(adjacencyList, neighbor));
            }
        }

        // Return the output string
        return result.toString();
    }

    public static void main(String[] args) {
        // Create a scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int testCaseCount = scanner.nextInt();

        // Loop through all the test cases
        for (int i = 0; i < testCaseCount; i++) {
            // Read the number of nodes in the current test case
            int nodeCount = scanner.nextInt();

            // Initialize the output string
            StringBuilder output = new StringBuilder();

            // Create a list to store the nodes
            List<String> nodes = new LinkedList<>();

            // Counter to keep track of the number of nodes read so far
            int count = 0;

            // Move to the next line
            scanner.nextLine();

            // Read the nodes and build the graph
            while (count != nodeCount) {
                // Read a line and split it into an array of strings
                String[] inputLine = scanner.nextLine().trim().split(" ");

                // Get the first string as the node
                String node = inputLine[0];

                // If the node is not already in the list, add it to the list and the graph
                if (!nodes.contains(node)) {
                    nodes.add(node);
                    adjacencyList.put(node, inputLine);
                    visitedNodes.put(node, false);
                    count++;
                }
            }

            // Perform DFS on each node that has not been visited yet
            for (String rootNode : nodes) {
                if (!visitedNodes.get(rootNode)) {
                    output.append(DFSHelper(adjacencyList, rootNode));
                }
            }

            // Print the output string
            System.out.println(output.toString().trim());
        }
    }
}
