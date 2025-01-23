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

class Add1ToLL {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

/*
 * class Node{
 * int data;
 * Node next;
 * 
 * Node(int x){
 * data = x;
 * next = null;
 * }
 * }
 */

class Solution {
    // Helper function to reverse the linked list
    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // Reverse the input list to make addition easier
        head = reverse(head);
        Node curr = head;
        Node prev = null;
        // Initialize carry with 1 since we need to add 1 to the number
        int carry = 1;

        // Traverse the list and add carry to each node
        while (curr != null) {
            int sum = curr.data + carry;
            carry = sum / 10;
            curr.data = sum % 10;
            prev = curr;
            curr = curr.next;
        }
        // If there's still a carry left, we need to add a new node at the end
        if (carry > 0) {
            prev.next = new Node(carry);
        }
        // Reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }
}
