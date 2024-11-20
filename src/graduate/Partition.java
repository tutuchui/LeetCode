package graduate;

import java.util.Scanner;

public class Partition {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode partition(ListNode head,int m) {
        ListNode cur = head;
        ListNode newNode = null;
        ListNode newHead = null;
        while(cur!=null){
            if(cur.val <= m){
                if(newNode == null){
                    newNode = new ListNode(cur.val);
                    newHead = newNode;
                }else{
                    newNode.next = new ListNode(cur.val);
                    newNode = newNode.next;
                }
            }
            cur = cur.next;
        }
        cur = head;
        while(cur.next!=null){
            if(cur.next.val <= m){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        if(head.val <= m){
            head = head.next;
        }
        if(newNode != null){
            newNode.next = head;
            return newHead;
        }else{
            return head;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }

        head= Partition.partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
