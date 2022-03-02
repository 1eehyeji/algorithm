package leetCode;

// Merge Nodes in Between Zeros
public class Solution2181 {

    public class ListNode {
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

    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode answer = new ListNode();
            ListNode pointer = answer;

            head = head.next;

            while (head != null) {
                if (head.val != 0) {
                    pointer.val += head.val;
                } else {
                    pointer.next = head.next != null ? new ListNode() : null;
                    pointer = pointer.next;
                }

                head = head.next;
            }

            return answer;
        }
    }
}
