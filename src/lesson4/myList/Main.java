package lesson4.myList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        System.err.println("test all add methods");
//        System.out.println();

        SimpleLinkedList sll = new SimpleLinkedList();
        sll.addFirst("test 1");
        sll.addFirst("test 2");
        sll.addFirst("test 3");

        System.out.print(sll.getSize() + " ");
        sll.printList();

        String mark = new String("mark");

        sll.addLast(mark);
        sll.addLast("test 0");
        System.out.print(sll.getSize() + " ");
        sll.printList();

        String middle = new String("middle");
        sll.addAfter(middle, mark);
        System.out.print(sll.getSize() + " ");
        sll.printList();

        sll.addAfter("middle (-1)", mark);
        System.out.print(sll.getSize() + " ");
        sll.printList();

        System.out.println();
        System.err.println("test addAfter, list size == 1");
        System.out.println();

        sll = new SimpleLinkedList();
        sll.addLast(mark);
        System.out.print(sll.getSize() + " ");
        sll.printList();

        sll.addAfter("last", mark);
        System.out.print(sll.getSize() + " ");
        sll.printList();

        System.out.println();
        System.err.println("test addAfter, no prev element exception");
        System.out.println();

        sll = new SimpleLinkedList();
        sll.addLast("test");
        System.out.print(sll.getSize() + " ");
        sll.printList();
        System.out.println();

        sll.addAfter("last", mark);
        System.out.print(sll.getSize() + " ");
        sll.printList();

        System.err.println("Test iterator");
        System.out.println();

//        for (Iterator<Object> it = sll.iterator(); it.hasNext();) {
//            it.next();
//            it.remove();
//            break;
//        }
//
//        sll.printList();
    }
}
