package NewOffer;

public class NewOffer15 {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode reHead = new ListNode(head.val);
        ListNode cur = head.next;
        while(cur!=null){
            ListNode temp = new ListNode(cur.val);
            temp.next = reHead;
            reHead = temp;
            cur = cur.next;
        }
        return reHead;
    }
}
