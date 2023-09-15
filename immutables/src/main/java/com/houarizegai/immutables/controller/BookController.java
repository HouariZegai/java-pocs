package com.houarizegai.immutables.controller;

import com.houarizegai.immutables.dto.ImmutableBook;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    String getBook() {
        ImmutableBook book = ImmutableBook.builder()
                .title("The Lord of the Rings")
                .author("J. R. R. Tolkien")
                .build();

        return book.toString();
    }
}
