
/*
 * Given the head of a linked list, determine whether the list contains a loop. 
 * If a loop is present, return the number of nodes in the loop, otherwise return 0.

Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. 
If c is 0, then there is no loop.

Example:
Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
Output: 7
Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
The number 33 is connected to the last node of the linkedlist to form the loop because according
to the input the 4th node from the beginning(1 based indexing) 
 */
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class FindLengthOfLoop {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0)
            return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            makeLoop(head, tail, k);

            Solution ob = new Solution();
            System.out.println(ob.countNodesinLoop(head));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

/*
 * 
 * class Node
 * {
 * int data;
 * Node next;
 * Node(int d) {data = d; next = null; }
 * }
 * 
 */

// Function should return the length of the loop in LL.

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        // Detecting the loop using Floyd's Cycle-Finding Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow pointer one step
            fast = fast.next.next; // move fast pointer two steps
            // If slow and fast meet, there is a loop
            if (slow == fast) {
                return countLoopNodes(slow); // Count the nodes in the loop
            }
        }
        // No loop found
        return 0;
    }

    // Helper function to count the number of nodes in the loop
    private int countLoopNodes(Node loopNode) {
        Node temp = loopNode;
        int count = 1;
        while (temp.next != loopNode) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
