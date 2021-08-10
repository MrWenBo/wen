package onLineCode.wangyi;

import onLineCode.struct.ListNode;

/**
 * @author ：wenbo
 * @date ：Created in 2021/3/5 5:39 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    public static ListNode deleteNode(ListNode head){

        if (head == null || head.next == null){
            return  head;
        }
        ListNode res = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        while (head.next != null){
            if (head.val == head.next.val){
                pre.next = head.next.next;

            }
            head = head.next;
        }
        return  res;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while(cur != null){
            boolean flag = false;
            ListNode difNode = cur.next;
            while(difNode != null && difNode.val == cur.val){
                flag = true;
                difNode = difNode.next;
            }
            if(flag){
                pre.next = difNode;
            }else{
                pre = cur;
            }
            cur = difNode;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode res =  deleteNode(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
