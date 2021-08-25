package com.wen;

import onLineCode.struct.ListNode;



/**
 * @author ：wenbo
 * @date ：Created in 2021/7/21 7:25 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        ListNode newHead = sortList(head);

        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public static ListNode sortList(ListNode head){
        return sortList(head, null);
    }
    public static ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return null;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode m = slow;
        ListNode l1 = sortList(head, m);
        ListNode l2 = sortList(m, tail);
        ListNode ans = merge(l1, l2);
        return ans;
    }
    public static ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy, t1 = head1, t2 = head2;
        while(t1 != null && t2 != null){
            if (t1.val <= t2.val){
                temp.next = t1;
                t1 = t1.next;
            }else {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        temp.next = t1 != null ? t1 : t2;
        return dummy.next;
    }




}
