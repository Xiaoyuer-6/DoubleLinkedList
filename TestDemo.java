import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Arrays;
import java.util.LinkedList;

public class TestDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(12);
        doubleLinkedList.addLast(32);
        doubleLinkedList.addLast(12);
        doubleLinkedList.addLast(52);
        doubleLinkedList.addLast(12);
        doubleLinkedList.display();
        System.out.println("===============");
        doubleLinkedList.clear();
        doubleLinkedList.display();
        //doubleLinkedList.removeAllKey(12);
        //doubleLinkedList.display();


        //doubleLinkedList.remove(32);
        //doubleLinkedList.display();

        // doubleLinkedList.remove(12);
        //doubleLinkedList.display();

        //doubleLinkedList.addIndex(3,45);

        //System.out.println(doubleLinkedList.contains(12));

    }
  }

