package com.example.linkedinsamarakkody.jakarta.dto;

import com.example.linkedinsamarakkody.jakarta.entities.Address;
import com.example.linkedinsamarakkody.jakarta.entities.Author;
import com.example.linkedinsamarakkody.jakarta.entities.Book;

public record BooksAndAuthors (
    Book book,
    Author author,
    Address address){

}
