package org.example.learning.components.glyph;

public class ListNode {
    ListNode next = null;
    ListNode prev = null;

    public ListNode getNext() {
        return next;
    }

    public ListNode getPrev() {
        return prev;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() {
        return prev != null;
    }

}
