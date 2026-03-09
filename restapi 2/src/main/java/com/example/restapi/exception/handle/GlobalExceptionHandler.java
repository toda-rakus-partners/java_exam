package com.example.restapi.exception.handle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.exception.dto.ErrorResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @RequestBodyと@ModelAttribute利用時の入力チェックエラーをハンドリング
     * 
     * @param ex MethodArgumentNotValidException
     * @return 400エラー
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // どの入力項目でどの入力エラーが発生しているかを取得
        Map<String, String> details = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.put(error.getField(), error.getDefaultMessage());
        }
        ErrorResponse body = new ErrorResponse(400, "Validation Error", details);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * @RequestParamと@PathVariable利用時の入力チェックエラーをハンドリング
     * 
     * @param ex ConstraintViolationException
     * @return 400エラー
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        // MethodArgumentNotValidExceptionとデータの持ち方が違うので
        // エラーメッセージを直接messageに格納する
        ErrorResponse body = new ErrorResponse(400, ex.getMessage(), null);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    /**
     * ユーザーが見つからない場合の例外をハンドリング
     * 
     * @param ex UserNotFoundException
     * @return 404エラー
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(404, ex.getMessage(), null); 
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    /**
     * その他の例外をハンドリング
     * 
     * @param ex Exception
     * @return 500エラー
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse body = new ErrorResponse(500, "Internal Server Error", null);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
