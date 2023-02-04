package org.example;


import java.util.Collections;

class Main {
    public static void main(String[] args) {

        ex2();
        ex1();

    }

    /*1. Реализовать консольное приложение, которое:
  Принимает от пользователя и “запоминает” строки.
  Если введено print, выводит строки так, чтобы последняя введенная была первой в списке,
     а первая - последней.
  Если введено revert, удаляет предыдущую введенную строку из памяти.*/
    private void ex1() {
        LinkedList l = new LinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.println(l);
        l.swapFirstAndLast();
        System.out.println(l);


    }


    class LinkedList {

        private Node head;

        public LinkedList(int[] startValues) {
            head = new Node(startValues[0]);

            Node current = head;

            for (int i = 1; i < startValues.length; i++) {
                current.next = new Node(startValues[i]);
                current = current.next;
            }
        }

        public void swapFirstAndLast() {
            Node current = head;
            Node beforeLast = null;

            while (current.next != null) {
                beforeLast = current;
                current = current.next;
            }

            current.next = head.next;
            head.next = null;
            assert beforeLast != null;
            beforeLast.next = head;
            head = current;
        }

        public String toString() {
            StringBuilder stb = new StringBuilder();
            Node current = head;

            while (current != null) {
                stb.append(current.key);
                stb.append("   ");
                current = current.next;
            }

            return stb.toString();
        }
    }

    class Node {
        public Node next;
        public int key;

        public Node(Node next, int key) {
            this.next = next;
            this.key = key;
        }

        public Node(int key) {
            this.key = key;
        }


    }


    /*2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод,
    который вернет “перевернутый” список.
*/
    private static void ex2() {
        java.util.LinkedList<String> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, "1", "2", "3", "4");
        System.out.println(linkedList);

        linkedList = reverseLinkedList(linkedList);
        System.out.print(linkedList);
    }


    public static java.util.LinkedList<String> reverseLinkedList(java.util.LinkedList<String> llist) {
        java.util.LinkedList<String> revLinkedList = new java.util.LinkedList<String>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            revLinkedList.add(llist.get(i));
        }
        return revLinkedList;
    }
}



