package com.stentle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gioiaballin on 08/11/15.
 */
@ResponseStatus(value= HttpStatus.NO_CONTENT, reason="No content found")  // 204
public class NoContentException extends RuntimeException {

    public NoContentException() { super(); }

    public NoContentException(String reason) { super(reason); }
}
