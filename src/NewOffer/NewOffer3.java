import java.util.ArrayList;

public class NewOffer3 {
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         ArrayList<Integer> result = new ArrayList<>();
         while(listNode!=null){
             result.add(0,listNode.val);
             listNode = listNode.next;
         }
         return result;
     }




}
