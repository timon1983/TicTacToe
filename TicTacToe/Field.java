package main.java.com.timon1983.javacore.TicTacToe;

import javax.swing.*;

 class Field {
//исходное игровое поле ввиде двумерного массива
         String [] a = {"_","_","_","_","_","_","_","_","_"};
//вывод игрового поля на консоль
      void showField() {
         for (int i = 0; i < a.length; i++) {
             System.out.print(a[i] + " ");
             if(i == 2 || i == 5)
             System.out.println();
         }
          System.out.println();
     }
 }
