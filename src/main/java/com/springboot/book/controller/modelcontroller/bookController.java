package com.springboot.book.controller.modelcontroller;

import com.springboot.book.dao.BookDao;
import com.springboot.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/book")
   public String queryAll(Model model){
        List<Book> books =bookDao.selectAll();
        model.addAttribute("books" ,books);
        return "booklist";
    }

    @GetMapping("/book/del/{id}")
    public String deleteBook(@PathVariable("id") Integer Id,Model model){
       bookDao.deleteBookById(Id);
        List<Book> books =bookDao.selectAll();
        model.addAttribute("books" ,books);
        return "redirect:/book";
    }

    @GetMapping("/book/predit/{id}")
    public String preUpdateBook(@PathVariable("id") Integer Id,Model model){
        Book book =bookDao.selectBookById(Id);
        model.addAttribute("book" ,book);
        return "editbook";
    }

    @PostMapping("/book/editok/{id}")
    public String UpdateBook(@PathVariable("id") Integer Id,
                             @RequestParam("name") String name,
                             @RequestParam("author") String author,
                             @RequestParam("price")String price,
                             @RequestParam("image") String image,
                             @RequestParam("description") String description){
        System.out.println(Id+name+author+price+image+description);
        Double Price = Double.parseDouble(price);
        bookDao.updateBookById(Id,name,author,Price,image,description);
        return "updatesuccess";
    }
    @RequestMapping("/book/look/return")
    public String reBack()
    {
        return "redirect:/book";
    }

    @RequestMapping("/book/addbook")
    public String openAddBook(){
        return "newbook";
    }

    @PostMapping("/book/newbook")
    public String addBook(
            @RequestParam("name") String name,
            @RequestParam("author") String author,
            @RequestParam("price") String price,
            @RequestParam("image") String image,
            @RequestParam("description") String description)
    {
        Double Price =Double.parseDouble(price);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(Price);
        book.setImage(image);
        book.setDescription(description);
        bookDao.addBook(book);
        return "addsuccess";
    }

}
