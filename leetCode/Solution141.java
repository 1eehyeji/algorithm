package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {

  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    Set<ListNode> set = new HashSet<>();

    ListNode next = head;
    while (next != null) {
      if (set.contains(next)) {
        return true;
      }
      set.add(next);
      next = next.next;
    }

    return false;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
