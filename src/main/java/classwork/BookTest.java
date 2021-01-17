package classwork;

import java.util.Scanner;

public class BookTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first book");
        System.out.println("Title");
        String title = scanner.nextLine();
        System.out.println("authorName");
        String authorName = scanner.nextLine();
        System.out.println("price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("count");
        int count = Integer.parseInt(scanner.nextLine());
        Book book = new Book(title,authorName,price,count);
        System.out.println(book);
        Book book1 = new Book();
        book1.setTitle(title);
        book1.setAuthorName(authorName);
        book1.setPrice(price);
        book1.setCount(count);
        System.out.println(book1);

    }
}
