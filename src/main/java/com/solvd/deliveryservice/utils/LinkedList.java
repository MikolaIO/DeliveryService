package com.solvd.deliveryservice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<T> {
    private final static Logger logger = LogManager.getLogger(LinkedList.class.getName());
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T get(Integer index) {
        Node<T> current = head;
        int i = 0;

        while (current != null && i < index) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Index out of bounds");
            return null;
        }
        else
            return current.data;
    }

    public void remove(T data) {
        if (head == null) {
            logger.info("List is empty");
        }
        if (head.data.equals(data)) {
            head = head.next;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data))
            current = current.next;
        if (current.next != null && current.next.data.equals(data))
            current.next = current.next.next;
        else
            logger.info("Element doesn't exist");
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            logger.info("{} ", current.data);
            current = current.next;
        }
    }
}
