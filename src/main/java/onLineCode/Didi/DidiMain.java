package onLineCode.Didi;

import onLineCode.struct.ListNode;
import onLineCode.struct.TreeNode;

import java.util.*;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/18 8:03 下午
 * @description：滴滴面试
 * @modified By：
 * @version: 1$
 */
public class DidiMain {
    //输入: intervals = [[1,4],[2,7],[8,10],[13,20]]
    //输出: [[1,7],[8,10],[13,20]]
    //解释: 区间 [1,4] 和 [2,7] 重叠, 将它们合并为 [1,7]
    //if(l1<l2 && r1>l2 && r1<r2) -> [l1,r2]

    private TreeNode ans;



    public DidiMain(){
        this.ans = null;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        if ((left && right) || ((root.val == q.val || root.val == p.val) && (left || right))) {
            ans = root;
        }
        return left || right || (root.val == q.val || root.val == p.val);
    }



    public static void main(String[] args) {
        int[][] intervals = {{15,18},{1,3},{2,6},{8,10}};

        System.out.println(merge(intervals));
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }
        List<int []> list = new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int []>(){
            @Override
            public int compare(int[] a, int[] b ){
                return a[0] - b[0];
            }
        });
        int i = 0;
        int n = intervals.length;
        while(i < n){
            int l = intervals[i][0];
            int r = intervals[i][1];
            while(i < n-1 && r >= intervals[i+1][0]){
                r = Math.max(r,intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{l,r});
            i++;
        }
        return list.toArray(new int[list.size()][2]);

    }

    public static ListNode reverseList(ListNode head){
        ListNode pre = null, cur = head, next = null;
        while (cur != null){
            // 保存要反转到头的那个节点
            next = cur.next;
            // 要反转的那个节点指向已经反转的上⼀个节点(备注:第⼀次反转的时候会指向null)
            cur.next = pre;
            // 上⼀个已经反转到头部的节点
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);
        res.next.next = head;
        res.next = null;
        return res;
    }
}
