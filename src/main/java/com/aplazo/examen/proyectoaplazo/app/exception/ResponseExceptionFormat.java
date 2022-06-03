package com.aplazo.examen.proyectoaplazo.app.exception;

import com.aplazo.examen.proyectoaplazo.util.TypeErrors;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
@Builder
@Getter
public class ResponseExceptionFormat {

    private LocalDateTime timestamp;
    private String uri;
    private TypeErrors message;
    private Map<Object,Object> detail;
}
