package org.example.learning.components.glyph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList generateList() {
        TestListNode node1 = new TestListNode("node 1");
        TestListNode node2 = new TestListNode("node 2");
        TestListNode node3 = new TestListNode("node 3");
        TestListNode node4 = new TestListNode("node 4");
        TestListNode node5 = new TestListNode("node 5");
        TestListNode node6 = new TestListNode("node 6");

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(node1);
        doublyLinkedList.insertEnd(node1);
        doublyLinkedList.insertEnd(node2);
        doublyLinkedList.insertEnd(node3);
        doublyLinkedList.insertEnd(node4);
        doublyLinkedList.insertEnd(node5);
        doublyLinkedList.insertEnd(node6);
        return doublyLinkedList;
    }

    @Test
    void insertStart() {
        generateList();
    }

    @Test
    void insertEnd() {
        DoublyLinkedList doublyLinkedList = generateList();
        doublyLinkedList.insertEnd(new TestListNode("node 7"));
        doublyLinkedList.insertEnd(new TestListNode("node 8"));
        TestListNode lastNode = (TestListNode) doublyLinkedList.getLast();
        assertEquals("node 8", lastNode.getValue(), "Last node value should equal 'node 8'");
    }

    @Test
    void remove() {
        // test the remove by index method
        DoublyLinkedList doublyLinkedList = generateList();
        doublyLinkedList.remove(0);
        TestListNode firstNode = (TestListNode) doublyLinkedList.getFirst();
        assertEquals("node 2", firstNode.getValue(), "First node value should equal 'node 2'");

        // test the remove by node method
        TestListNode fourthNode = (TestListNode) doublyLinkedList.get(2);
        assertEquals("node 4", fourthNode.getValue(), "list.get(2) should equal 'node 4'");

        doublyLinkedList.remove(fourthNode);
        TestListNode fifthNode = (TestListNode) doublyLinkedList.get(2);
        assertEquals("node 5", fifthNode.getValue(), "list.get(2) should equal `node 5`");

    }

    @Test
    void setCurrent() {
        DoublyLinkedList doublyLinkedList = generateList();
        TestListNode node3 = (TestListNode) doublyLinkedList.get(2);
        assertEquals("node 3", node3.getValue(), "list.get(2) should equal 'node 3'");

        doublyLinkedList.setCurrent(2);
        node3 = (TestListNode) doublyLinkedList.getCurrent();
        assertEquals("node 3", node3.getValue(), "list.getCurrent() should equal 'node 3'");

        TestListNode node4 = (TestListNode) doublyLinkedList.get(3);
        doublyLinkedList.setCurrent(node4);
        assertEquals("node 4", ((TestListNode) doublyLinkedList.getCurrent()).getValue(), "list.getCurrent() should equal 'node 4'");

    }

    @Test
    void getCurrent() {
        DoublyLinkedList doublyLinkedList = generateList();
        TestListNode node1 = (TestListNode) doublyLinkedList.getCurrent();
        assertEquals("node 1", node1.getValue(), "list.getCurrent() should equal 'node 1'");


    }

    @Test
    void get() {
        DoublyLinkedList doublyLinkedList = generateList();
        TestListNode node1 = (TestListNode) doublyLinkedList.get(0);
        TestListNode node4 = (TestListNode) doublyLinkedList.get(3);
        assertEquals("node 1", node1.getValue(), "Node 1 value should equal 'node 1'");
        assertEquals("node 4", node4.getValue(), "Node 4 value should equal 'node 4'");
        System.out.println("node 4");
        System.out.println(node4.getValue());
    }

    @Test
    void testRemove() {
        DoublyLinkedList doublyLinkedList = generateList();
    }

    @Test
    void getFirst() {
        DoublyLinkedList doublyLinkedList = generateList();
        TestListNode node1 = (TestListNode) doublyLinkedList.get(0);
        assertEquals("node 1", node1.getValue(), "Node 1 value should equal 'node 1'");
    }

    @Test
    void getLast() {
        DoublyLinkedList doublyLinkedList = generateList();
        TestListNode lastNode = (TestListNode) doublyLinkedList.getLast();
        assertEquals("node 6", lastNode.getValue(), "Last node value should equal 'node 6'");
    }
}