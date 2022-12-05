import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //TODO: The main method runs tests that report back whether each search found the target node or not.

        //TODO: Edit the value of targetData below to adjust what node is being searched for.
        //TODO: Changing it to something not A-I (like Z) will result in a full graph traversal.
        //TODO: Outside of doing that for testing purposes, do not modify the main method.
        String targetData = "C";
        Node E = buildGraph();

        System.out.println("BFS (Iterative)\n---------------");
        boolean bfsFound = bfs(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Iterative)\n---------------");
        boolean dfsIterFound = dfsIterative(E, targetData);

        E = buildGraph();
        System.out.println("\n\nDFS (Recursive)\n---------------");
        boolean dfsRecurFound = dfsRecursive(E, targetData);

        String output = bfsFound ? "\nBFS found " + targetData + ".\n" : "\nBFS didn't find " + targetData + ".\n";
        output += dfsIterFound ? "DFS (iterative) found " + targetData + ".\n" : "DFS (iterative) didn't find " + targetData + ".\n";
        output += dfsRecurFound ? "DFS (recursive) found " + targetData + ".\n" : "DFS (recursive) didn't find " + targetData + ".\n";

        System.out.println("\n\nRESULTS\n-------" + output);
    }

    public static boolean bfs(Node start, String targetData) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        
        while (queue.isEmpty() == false){ // while queue is not empty
            Node removedData = queue.remove();
            if (removedData.data == targetData) {
                    System.out.println("found target");
                    return true; 
            } else {
                removedData.visit();
                for (Node removeNode : removedData.neighbors) {
                     
                    if(removeNode.visited == false && queue.contains(removeNode.data) == false){
                        queue.add(removeNode);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsIterative(Node start, String targetData) {
        Stack<Node> stack = new Stack<>();
        stack.push(start);
        
        while (stack.isEmpty() == false){ // while queue is not empty
            Node removedData = stack.pop();
            if (removedData.data == targetData) {
                    System.out.println("found target");
                    return true; 
            } else {
                removedData.visit();
                for (Node neigbhorNode : removedData.neighbors) {
                     
                    if(neigbhorNode.visited == false && stack.contains(neigbhorNode.data) == false){
                        stack.push(neigbhorNode);
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfsRecursive(Node current, String targetData) {
        return false; //TODO: remove this before starting step 3, it's only here to let the code compile before then
    }

    public static Node buildGraph() {
        //TODO: This method builds the graph shown in Graph Image.png in the project download. Do not modify.
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        A.neighbors = new Node[]{E};
        B.neighbors = new Node[]{C, E, F, I};
        C.neighbors = new Node[]{B};
        D.neighbors = new Node[]{F};
        E.neighbors = new Node[]{A, B, G};
        F.neighbors = new Node[]{B, D, H};
        G.neighbors = new Node[]{E};
        H.neighbors = new Node[]{F, I};
        I.neighbors = new Node[]{B, H};
        return E;
    }
}