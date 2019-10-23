package NewOffer;

public class NewOffer14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        int nodeLength = 0;
        ListNode cur = head;
        while(cur!=null){
            nodeLength++;
            cur = cur.next;
        }
        if(k > nodeLength){
            return null;
        }
        int i = nodeLength - k + 1;
        cur = head;
        while(i!=1){
            cur = cur.next;
            i--;
        }
        return cur;
    }
}
