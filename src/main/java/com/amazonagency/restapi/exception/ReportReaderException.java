package com.amazonagency.restapi.exception;

public class ReportReaderException extends RuntimeException {
    public ReportReaderException(String message, Throwable e) {
        super(message, e);
    }
}
