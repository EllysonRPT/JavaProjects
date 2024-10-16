package com.example.models;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Falha {

 
    
   
        private String id;
        private long maquinaId;
        private LocalDate data;
        private String problema;
        private String prioridade;
        private String operador;
    
      
    }
     
