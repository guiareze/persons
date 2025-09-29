package br.com.guiareze.persons.infrastructure.controller.handler;

import br.com.guiareze.persons.infrastructure.exception.BusinessException;
import br.com.guiareze.persons.infrastructure.exception.DatabaseException;
import br.com.guiareze.persons.infrastructure.exception.GatewayException;
import br.com.guiareze.persons.infrastructure.exception.dto.ErrorResponse;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    private final String uriExplanation = "https://guiareze.persons.com/docs/errors/";

    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<ProblemDetail> handleException(GatewayException ex) {
        var status = HttpStatus.BAD_REQUEST;
        var problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problemDetail.setTitle("Gateway/Integration Error");
        problemDetail.setType(URI.create(uriExplanation + "gateway-integration-error"));
        return ResponseEntity.status(status).body(problemDetail);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ProblemDetail> handleException(DatabaseException ex) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problemDetail.setTitle("Database Error");
        problemDetail.setType(URI.create(uriExplanation + "database-error"));
        return ResponseEntity.status(status).body(problemDetail);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetail> handleException(BusinessException ex) {
        var status = HttpStatus.UNPROCESSABLE_ENTITY;
        var problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problemDetail.setTitle("Business Validations Error");
        problemDetail.setType(URI.create(uriExplanation + "business-validations-error"));
        return ResponseEntity.status(status).body(problemDetail);
    }

    @ExceptionHandler(CallNotPermittedException.class)
    public ResponseEntity<ProblemDetail> handleException(CallNotPermittedException ex) {
        var status = HttpStatus.SERVICE_UNAVAILABLE;
        var problemDetail = ProblemDetail.forStatusAndDetail(status, "Service temporarily unavailable due to high load. Please try again later.");
        problemDetail.setTitle("Service Unavailable");
        problemDetail.setType(URI.create(uriExplanation + "service-unavailable"));
        return ResponseEntity.status(status).body(problemDetail);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception ex) {
        log.error("Unexpected error occurred", ex);
        var status = HttpStatus.INTERNAL_SERVER_ERROR;
        var problemDetail = ProblemDetail.forStatusAndDetail(status, "An unexpected error occurred. Please try again later.");
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setType(URI.create(uriExplanation + "internal-server-error"));
        return ResponseEntity.status(status).body(problemDetail);
    }
}
