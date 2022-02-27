/**
 * @author HuChao
 * @date 2022/2/27/0027 18:24
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        ListNode po = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                po.next = list1;
                list1 = list1.next;
            } else {
                po.next = list2;
                list2 = list2.next;
            }
            po = po.next;
        }
        po.next = list1 == null ? list2 : list1;
        return head.next;
    }

}
