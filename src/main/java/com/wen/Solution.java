package com.wen;

import onLineCode.struct.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        ListNode res = reverseList(head);

        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode cur = head, pre = null, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
