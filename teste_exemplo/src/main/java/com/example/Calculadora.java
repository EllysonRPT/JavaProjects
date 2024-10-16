package com.example;

import javax.swing.JFrame;

public class Calculadora  {
    
    public double soma(double a,double b){
        return a+b;
    };
    //subtrai
    public double subtrair(double a,double b){
        return a-b;
    }
    public double multiplica(double a,double b){
        return a*b;
    }
    public double divide(double a,double b){
        if (b == 0) {
            throw new IllegalArgumentException("Nao diviras por zero");
            
        }
        return a/b;
    }

}
