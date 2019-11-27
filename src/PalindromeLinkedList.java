public class PalindromeLinkedList {
    public boolean[] solution(ListNode head, int k){
        boolean[] result = new boolean[2];
        result[0] = isPalindromeLinkedList(head);
        head = deleteKthElement(head,k);
        result[1] = isPalindromeLinkedList(head);
        return result;
    }
    public boolean isPalindromeLinkedList(ListNode head){
        //Assume the empty linked list is palindrome
        if(head == null || head.next == null){
            return true;
        }
        int[] nums = new int[getListLength(head)];
        ListNode cur = head;
        for(int i = 0; i < nums.length; i++){
            nums[i] = cur.val;
            cur = cur.next;
        }
        int i = 0; int j = nums.length - 1;
        while(i < j){
            if(nums[i]!=nums[j]){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;

    }

    public ListNode deleteKthElement(ListNode head, int k){
        int length = getListLength(head);
        ListNode cur = head;
        if(k == 1){
            return head.next;
        }
        else if(k == length){
            for(int i = 1; i < k - 1; i++){
                cur = cur.next;
            }
            cur.next = null;
        }
        else{
            for(int i = 1; i < k - 1; i++){
                cur = cur.next;
            }
            ListNode next = cur.next.next;
            cur.next = next;
        }
        return head;
    }

    public int getListLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur!=null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
