/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr!=null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while(curr!=null) {
            Node copiedNode = map.get(curr);
            copiedNode.next = map.get(curr.next);
            copiedNode.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);

    }
}