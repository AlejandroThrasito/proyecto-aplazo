package com.aplazo.examen.proyectoaplazo.app.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.aplazo.examen.proyectoaplazo.util.TypeErrors.FORMAT_ERROR;

@ControllerAdvice
public class HadlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseExceptionFormat> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        // get spring errors
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        // convert errors to standard string
        Map<Object,Object> detail = new HashMap<>();
        fieldErrors.forEach(f -> detail.put(f.getField(),f.getDefaultMessage()));

        // return error info object with standard json
        return ResponseEntity.badRequest()
                .body(ResponseExceptionFormat.builder()
                        .message(FORMAT_ERROR)
                        .detail(detail)
                        .timestamp(LocalDateTime.now())
                        .uri(request.getRequestURI())
                        .build());
    }
}
