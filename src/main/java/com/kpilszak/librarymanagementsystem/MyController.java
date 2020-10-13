package com.kpilszak.librarymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET, produces = "application/json")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/getBookingDetails", method = RequestMethod.GET, produces = "application/json")
    public List<Order> getBookingDetails() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = "application/json")
    public long countNoofBooks() {
        return bookRepository.count();
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
    public void addBooks(@RequestBody List<Book> books) {
        System.out.println(books);
        bookRepository.saveAll(books);
    }

    @RequestMapping(value = "/delBook", method = RequestMethod.POST, produces = "application/json")
    public void delBooks(@RequestBody List<Book> books) {
        System.out.println(books);
        bookRepository.deleteAll(books);
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST, produces = "application/json")
    public void makeBooking(@RequestBody Order orderDetails) {
        orderRepository.save(orderDetails);
    }

    @RequestMapping(value = "/cancelBooking", method = RequestMethod.POST, produces = "application/json")
    public void cancelBooking(@RequestBody String orderDetails) {
        System.out.println(orderDetails.split(":")[0]);
        orderRepository.deleteByOrderId(orderDetails);
    }
}
