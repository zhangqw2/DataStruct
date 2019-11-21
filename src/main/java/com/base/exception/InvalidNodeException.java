package com.base.exception;

/**
 *  无效异常
 */
public class InvalidNodeException extends RuntimeException {
    public InvalidNodeException(String err){
        super(err);
    }
}
