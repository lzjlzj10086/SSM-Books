package com.controller;

import com.pojo.Books;
import com.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("book")
public class BooksController {

    @Resource
    private BooksService booksService;

    @RequestMapping("allBooks")
    public String allBooks(Model model){
        List<Books> books = booksService.queryAllBook();
        model.addAttribute("list",books);
        return "AllBooks";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "AddBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        int i = booksService.addBook(books);
        System.out.println(i);
        return "redirect:/book/allBooks";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = booksService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        booksService.updateBook(book);
        Books books = booksService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBooks";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        booksService.deleteBookById(id);
        return "redirect:/book/allBooks";
    }
}
