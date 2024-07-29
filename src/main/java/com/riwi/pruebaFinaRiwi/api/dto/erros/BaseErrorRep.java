package com.riwi.pruebaFinaRiwi.api.dto.erros;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorRep implements Serializable{
    private String status; 
    private Integer code;
}
