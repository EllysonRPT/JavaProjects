package com.example;

public class Main {
    public static void main(String[] args) {
 UsuarioController uc = new UsuarioController();
//  uc.createUser(new Usuario(
//     "",
//      "pedro",
//      25,
//      "Rua 1, 2345-678"
//  ));
//  uc.updateUser(
//      new Usuario(
//         "",
//          "pedro",
//          26,
//          "Rua 2, 3456-789"
//      )
//  );
 uc.deleteUser("45b1");
 uc.read();

    }
    
}