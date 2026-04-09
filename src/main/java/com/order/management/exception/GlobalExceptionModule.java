package com.order.management.exception;

import com.order.management.dto.ResponseDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionModule {


    public Map<String, String> eachMsg(Exception ex){
        Map<String,String> map = new HashMap<>();
        map.put("error",ex.getMessage());
        return map;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> generalExceptionHandler(Exception ex) {
        ResponseDTO responseDTO = new ResponseDTO(500L, "Server Error",null,eachMsg(ex));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseDTO);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> userNotFoundException(UserNotFoundException ex){
        ResponseDTO responseDTO = new ResponseDTO(404L,"Given object Not found",null,eachMsg(ex));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(responseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO>  methodArgsNotValid(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(err -> {
                    errorMap.put(err.getField(), err.getDefaultMessage());
                });

        ResponseDTO responseDTO = new ResponseDTO(402L,"Null Values in Request",null,errorMap);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(responseDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDTO> dbRelatedIssue(DataIntegrityViolationException ex){
       ResponseDTO  responseDTO = new ResponseDTO(500L,"DB INTEGRITY ERROR",null,eachMsg(ex));
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ResponseDTO> dbAccess(DataAccessException ex){
        ResponseDTO  responseDTO = new ResponseDTO(500L,"DB Access ERROR",null,eachMsg(ex));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
    }

}
