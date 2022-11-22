package com.johndeere.tms.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class InvalidSessionException extends Exception {

    private HttpStatus httpStatus;
    private String errorString;
}
