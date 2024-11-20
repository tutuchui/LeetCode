package graduate;

import java.util.HashMap;
import java.util.Map;

//Leetcode 138
public class CopyLinkedListWithRondomPointer {
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
// https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }

        Node cur = head;
//将复制的新节点接到原节点的后面 e.g 1 -> 2 -> 3 ==> 1 -> 1' -> 2 -> 2' -> 3 -> 3'
        while(cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        Node result = new Node(-1);
        cur = head;
        Node p = result;

        while(cur != null){
            p.next = cur.next;
            p = p.next;
            cur.next = p.next;
            cur = cur.next;;
        }

        return result.next;

    }
    // 🐂啊
    public Node copyRandomListWithHashMap(Node head){
        if(head == null){
            return null;
        }

        Map<Node, Node> nodeMap = new HashMap<>();
        Node cur = head;

        while(cur != null){
            Node newNode = new Node(cur.val);
            nodeMap.put(cur, newNode);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node newNode = nodeMap.get(cur);
            if(cur.next != null){
                newNode.next = nodeMap.get(cur.next);
            }

            if(cur.random != null){
                newNode.random = nodeMap.get(cur.random);
            }
            cur = cur.next;
        }

        return nodeMap.get(head);
    }
}
