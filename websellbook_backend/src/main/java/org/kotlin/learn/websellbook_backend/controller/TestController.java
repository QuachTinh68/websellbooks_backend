package org.kotlin.learn.websellbook_backend.controller;

import org.kotlin.learn.websellbook_backend.entity.Book;
import org.kotlin.learn.websellbook_backend.entity.OrderDetail;
import org.kotlin.learn.websellbook_backend.repository.BookRepository;
import org.kotlin.learn.websellbook_backend.repository.OrderDetailRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    OrderDetailRepository orderDetailRepository;
    BookRepository bookRepository;

    public TestController(OrderDetailRepository orderDetailRepository, BookRepository bookRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.bookRepository = bookRepository;
    }


    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }


    @GetMapping("/")
    public void test(){
        //orderDetailRepository.
    }
}
