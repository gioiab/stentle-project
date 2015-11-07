package com.stentle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gioiaballin on 08/11/15.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Argument not valid")  // 400
public class ArgumentNotValidException extends RuntimeException  {

    public ArgumentNotValidException() {
        super();
    }

    public ArgumentNotValidException(String reason) {
        super(reason);
    }
}
