package org.example.learning.components.glyph;

public class DoublyLinkedList {
    ListNode curNode;
    ListNode head;
    ListNode tail;
    int size = 0;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        curNode = null;
    }

    public DoublyLinkedList(ListNode node) {
        this.head = node;
        this.tail = node;
        curNode = node;
        size++;
    }

    public void insertStart(ListNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        this.head = node;
        if (tail == null) {
            tail = node;
            curNode = node;
        }

        size++;
    }


    public void insertEnd(ListNode node) {
        node.next = null;
        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
            curNode = node;
        }
        size++;
    }


    /**
     * Returns the node from list based on index.
     * Can be improved to find node from second half by starting at tail.
     * This would be a speed increase if they request a node near the end.
     *
     * @param index the index of the node to return
     * @return the requested node based on index or null if otu of bounds
     */
    public ListNode get(int index) {
        // out of bounds
        if (index + 1 > size || index < 0) {
            return null;
        }

        // iterate over list to get node
        int i = 0;
        ListNode curNode = head;
        while (curNode.hasNext() && i < index) {
            curNode = curNode.next;
            i++;
        }


        return curNode;
    }

    public void remove(ListNode node) {
        ListNode nextNode = node.next;
        ListNode prevNode = node.prev;
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        if (prevNode != null) {
            prevNode.next = nextNode;
        }

        if (node == curNode) {
            curNode = prevNode;
        }

        if (node == head) {
            head = nextNode;
        }
        if (node == tail) {
            tail = prevNode;
        }

        size--;
    }

    /**
     * Remove a node based on index.
     * Can be improved to return a boolean based on if the node was successfully removed.
     * Main use case would be if an invalid index was provided, such as below 0 or above the list length
     * This one would also be improved to traverse backwards based on if the requested index
     * is on the second half of the list
     *
     * @param index
     */
    public void remove(int index) {
        // cancel function if out of bounds
        if (index + 1 > size || index < 0) {
            return;
        }

        int i = 0;
        ListNode curNode = head;
        while (curNode.hasNext() && i < index) {
            curNode = curNode.next;
            i++;
        }

        ListNode nextNode = curNode.next;
        ListNode prevNode = curNode.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        if (this.curNode == curNode) {
            this.curNode = prevNode;
        }

        if (index == 0) {
            head = nextNode;
        } else if (index == size - 1) {
            tail = prevNode;
        }
        size--;
        if (size == 0) {
            head = null;
            tail = null;
            curNode = null;
        }
    }

    public ListNode getFirst() {
        return head;
    }

    public ListNode getLast() {
        return tail;
    }

    public ListNode getCurrent() {
        return curNode;
    }

    public void setCurrent(ListNode node) {
        curNode = node;
    }

    public void setCurrent(int index) {
        ListNode newNode = get(index);
        if (newNode != null) {
            curNode = newNode;
        }

    }

    public void increaseCurrent() {
        if (curNode.hasNext()) {
            curNode = curNode.next;
        }
    }

    public void decreaseCurrent() {
        if (curNode.hasPrev()) {
            curNode = curNode.prev;
        }
    }

    public int size() {
        return size;
    }

}
