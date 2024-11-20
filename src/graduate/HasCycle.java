package graduate;

import java.util.HashSet;

public class HasCycle {
    private class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            this.val = x;
            this.next = null;
        }

    }
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;

        if(head == null || head.next == null){
            return false;
        }while(p1 != p2){
            if(p2 == null || p2.next == null){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next.next;

        }
        return true;
    }
    public boolean hasCycleBySet(ListNode head) {
        HashSet<ListNode> hasSeen = new HashSet<>();
        while(head != null){
            if(hasSeen.contains(head)){
                return true;
            }else{
                hasSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }


}
