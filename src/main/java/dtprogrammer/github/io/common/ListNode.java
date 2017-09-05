package dtprogrammer.github.io.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static ListNode createList(int... values) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        for (int value : values) {
            curNode.next = new ListNode(value);
            curNode = curNode.next;
        }
        curNode.next = null;
        return dummyHead.next;
    }

    public static boolean isEqual(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            if (expected.val != actual.val) {
                return false;
            }
            expected = expected.next;
            actual = actual.next;
        }
        if (expected != null || actual != null) {
            return false;
        }
        return true;
    }
}
