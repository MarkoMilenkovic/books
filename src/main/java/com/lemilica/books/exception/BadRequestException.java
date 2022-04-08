package com.lemilica.books.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BadRequestException extends RuntimeException {

    private String message;
}
