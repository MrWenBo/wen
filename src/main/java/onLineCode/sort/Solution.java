package onLineCode.sort;

import onLineCode.struct.ListNode;

import java.util.HashMap;
import java.util.Random;

/**
 * @author ：wenbo
 * @date ：Created in 2021/2/3 1:15 下午
 * @description：常用排序算法
 * @modified By：
 * @version: 1.0.0$
 */
public class Solution {

    public int[] selectionSort(int[] arr){
        //选择排序
        int n = arr.length;
        int minIndex, temp;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

     public int[] insertionSort(int[] arr){
        int n = arr.length;
        int preIndex, cur;
         for (int i = 1; i < n; i++) {
             preIndex =  i - 1;
             cur = arr[i];
             while (preIndex >= 0 && arr[preIndex] > cur){
                 arr[preIndex + 1] = arr[preIndex];
                 preIndex--;
             }
             arr[preIndex + 1] = cur;
         }
         return arr;
     }



     public void quickSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int low = left, high = right;
        int key = arr[left];
        while (low < high){
            while (low < high && arr[high] >= key){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        quickSort(arr,left,low - 1);
        quickSort(arr,right + 1,right);
     }




    /**
     * create by: Bo.W
     * description: 快排
     * create time: 2021/3/23 2:30 下午
     *
     * params:
     * @return
     */
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * create by: Bo.W
     * description: 归并
     * create time: 2021/3/23 2:31 下午
     *
     * params:
     * @return
     */
    int[] tmp;

    public int[] sortArray1(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }





    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        return quickSort(newHead,null);
    }
    // 带头结点的链表快速排序
    private ListNode quickSort(ListNode head,ListNode end){
        if (head==end||head.next==end||head.next.next==end) {
            return head;
        }
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead=new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition=head.next,p=partition,tp=tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next!=end){
            if (p.next.val<partition.val){
                tp.next=p.next;
                tp=tp.next;
                p.next=p.next.next;
            }else {
                p=p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next=head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next=tmpHead.next;
        quickSort(head,partition);
        quickSort(partition,end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }



    public static void main(String[] args) {

        ListNode head4 = new ListNode(3);
        ListNode head3 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        Solution s = new Solution();
        ListNode node = s.sortList(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }


}
