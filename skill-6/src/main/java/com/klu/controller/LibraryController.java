package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Library service is running successfully!";
    }

    @GetMapping("/count")
    public int totalBooks() {
        return 120;
    }

    @GetMapping("/price")
    public double samplePrice() {
        return 350.75;
    }

    @GetMapping("/books")
    public List<String> availableBooks() {
        List<String> titles = new ArrayList<>();
        titles.add("Operating Systems");
        titles.add("Computer Networks");
        titles.add("Spring Framework Basics");
        return titles;
    }

    @GetMapping("/books/{id}")
    public String bookInfo(@PathVariable int id) {
        return "Requested details for book ID : " + id;
    }

    @GetMapping("/search")
    public String findBook(@RequestParam String title) {
        return "Search request received for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String authorBooks(@PathVariable String name) {
        return "Displaying books written by " + name;
    }

    @PostMapping("/addbook")
    public String saveBook(@RequestBody Book book) {
        books.add(book);
        return "New book stored in library list.";
    }

    @GetMapping("/viewbooks")
    public List<Book> getAllBooks() {
        return books;
    }
}