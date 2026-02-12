import java.util.LinkedList;
import java.util.Scanner;
/**

 Program description:problem1

 Author: BUSE BERFİN HALEFOĞLU

 E-mail address:210401020@ogr.ikc.edu.tr

 Homework Number:2

 Last Changed:22.03.24

 */
public class Main {

    public static void main(String[] args) {
        LinkedList<String> straightList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        for (int i = 0; i < input.length(); i++) {
            straightList.add(String.valueOf(input.charAt(i)));
        }

        System.out.print("Before reversed: " + straightList + " ");

        reverseList(straightList);


    }
    static void reverseList(LinkedList<String> list) {
        Node head = null;
        for (String s :list) {
            Node node2 = new Node(s);
            node2.next = head;
            head = node2;
        }


        Node now = head;
        System.out.println("\nReversed list:: ");
        while (now != null) {
            System.out.print("" + now.input + " ");
            now = now.next;
        }
    }
}

