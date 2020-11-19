package list;

import list.impl.DoublyLinkedList;
import list.impl.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");

        //GBIterator iterator = list.iterator();
        //while (iterator.hasNext()) {
         //   String next = iterator.next();
           // System.out.println(next);
        //}
        //System.out.println("Size before remove " + list.size());

        //boolean isToyotaRemoved = list.remove("TOYOTA");
        //System.out.println("Is toyota removed? " + isToyotaRemoved);
        //System.out.println("Size after remove " + list.size());

        //System.out.println(list.get(-1));
        GBList list1 = new DoublyLinkedList();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        System.out.println(list1.toString());
        GBIterator iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
          String next = iterator1.next();
            System.out.println(next);
        }
        System.out.println(list1.get(0));
        list1.remove("3");
        System.out.println(list1.toString());
        GBIterator iterator2 = list1.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            System.out.println(next);
        }
    }
}
