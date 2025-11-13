public class Leetcode_2 {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode generateListNode(int[] list) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        for (int i = 0; i < list.length; i++) {
            l.val = list[i];
            if (i != list.length - 1) {
                l.next = new ListNode();
                l = l.next;
            }
        }

        return head;
    }

    public void printListNode(ListNode l) {
        System.out.print("[");
        while (l != null) {
            System.out.print(l.val);
            if (l.next != null) {
                System.out.print(", ");
            }
            l = l.next;
        }
        System.out.println("]");
    }

    public void handleCarry(ListNode l, int carry) {
        if (l.next == null) {
            l.next = new ListNode(1);
            return;
        }
        l.next.val += carry;
        if (l.next.val > 9) {
            l.next.val = l.next.val % 10;
            handleCarry(l.next, carry);
        }
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;

        while (l1 != null || l2 != null) {
            if (carry == 0) {
                l1.val = l1.val + l2.val;
            }
            if (carry != 0) {
                l1.val = l1.val + l2.val + 1;
                carry = 0;
            }
            if (l1.val > 9) {
                carry = 1;
                l1.val = l1.val % 10;
            }
            if (l1.next == null && l2.next != null) {
                handleCarry(l2, carry);
                l1.next = l2.next;
                return head;
            }
            if (l2.next == null && l1.next != null) {
                handleCarry(l1, carry);
                return head;
            }
            if (l2.next == null && l1.next == null && carry != 0) {
                handleCarry(l1, carry);
                return head;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    void main() {
        ListNode l1 = generateListNode(new int[]{5});
        ListNode l2 = generateListNode(new int[]{5});

        ListNode result = addTwoNumbers(l1, l2);

        printListNode(result);
    }
}

