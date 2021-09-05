package com.streams;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Class24 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        Book b1 = new Book("bangala", "amara boi", "kz", 2000);
        Book b2 = new Book("english", "english for today", "kz1", 200);
        Book b3 = new Book("english", "English 2", "kz2", 5000);
        Book b4 = new Book("english", "english 3", "kz3", 600);
        Book b5 = new Book("accounting", "book of acc", "kz5", 100);
        Book b6 = new Book("physics", "st", "kz4", 250);

        books.add(b1); books.add(b2); books.add(b3); books.add(b4); books.add(b5); books.add(b6);

        /*List<Book> englishBook = new ArrayList<>();

        books.forEach(book -> {
            if (book.getSubject().equals("english") && book.getPrice() >= 500) {
                englishBook.add(book);
            }
        });

        Collections.sort(englishBook, (Book o1, Book o2) -> Integer.compare(o1.getPrice(), o2.getPrice()));

        StringBuilder booksNames = new StringBuilder();

        englishBook.forEach(b->{
            booksNames.append(b.getName()).append(", ").append(b.getPrice()).append(", ");
        });
        System.out.println(booksNames);*/

        /*String line = books.stream()
                .filter(book -> book.getSubject().equals("english"))
                .filter(book -> book.getPrice() >= 500)
                .sorted(Comparator.comparingInt(Book::getPrice))
                .map(b-> b.getName()+ " , " + b.getPrice())
                .collect(Collectors.joining(", "));

        System.out.println(line);*/

        //IntStream.range(0, 10).forEach(System.out::println);

        String[] town = {"dhaka", "chittagong", "sylhet", "rajsahi", "khulna"};

        /*String[] townCap = new String[5];

        for (int i = 0; i < town.length; i++) {
            townCap[i] = town[i].toUpperCase();
        }

        for (String s : townCap) {
            System.out.println(s);
        }*/

        Set<String> townCap =
                Stream.of(town).map(s -> s.toUpperCase() + " 1 ").collect(Collectors.toSet());

        for (Object s : townCap) {
            System.out.println(s);
        }


    }
}

class Book {
    private String subject;
    private String name;
    private String author;
    private int price;

    public Book(String subject, String name, String author, int price) {
        this.subject = subject;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
