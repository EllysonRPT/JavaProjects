

package com.example;
import javax.annotation.processing.Generated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
class Produto {

    private int id;
    private String nome;
    private double preco;
 @Override
 public String toString() {
     return "Produto{" +
             ", nome='" + nome + '\'' +
             ", preco=" + preco +
             '}';
 }
}