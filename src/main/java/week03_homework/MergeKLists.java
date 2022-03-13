package week03_homework;


/**
 * 第一题 leetcode 23. 合并K个升序链表
 *
 * @author HuChao
 * @date 2022/3/13/0013 11:11
 */
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        if(lists.length == 2) return mergeTwo(lists[0], lists[1]);
        int mid = lists.length / 2;
        ListNode[] pre = new ListNode[mid];
        ListNode[] suf = new ListNode[mid + 1];
        for(int i = 0; i < lists.length; i++) {
            if(i < mid) pre[i] = lists[i];
            else suf[i - mid] = lists[i];
        }
        ListNode left = mergeKLists(pre);
        ListNode right = mergeKLists(suf);
        return mergeTwo(left, right);
    }

    /**
     * 合并两个有序链表
     */
    ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode head = new ListNode(-10001);
        ListNode pro = head;
        while(a != null && b != null) {
            if(a.val >= b.val) {
                head.next = b;
                b = b.next;
            } else {
                head.next = a;
                a = a.next;
            }
            head = head.next;
        }
        head.next = a == null ? b : a;
        return pro.next;
    }
}
