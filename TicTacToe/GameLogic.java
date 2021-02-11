package main.java.com.timon1983.javacore.TicTacToe;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 class GameLogic {

     private Field field = new Field();
     private Scanner scanner = new Scanner(System.in);
     private Random random = new Random();
     private ArrayList<Integer> playeer1 = new ArrayList<>();//значения введенные игроком
     private ArrayList<Integer> playeer2 = new ArrayList<>();//значения введенные копьютером
     private boolean start = true;
     private boolean stop = true;

     //Выводим исходное игровое поле в консоль и вызываем метод inputValue() для ввода значений
     void startGame() {
         System.out.println("Start game");
         field.showField();
         System.out.println();
         getInput();
     }

     // Вводим значение через консоль
     private void getInput() {
         while (start) {
             if(start == false) break;
              int x = scanner.nextInt();//считываем с консоли
             while (playeer1.contains(x) || playeer2.contains(x) || x < 1 || x > 9) { //проверка на неккорктный ввод
                 System.out.println("Incorrect input , try again");
                 x = scanner.nextInt();
             }
             validateInput(x);
         }
     }

         //заносим значение в поле и проверяем выигрыш
         private void validateInput(int x) {
             playeer1.add(x);//добавляем в список
             changeField(x, "X");//записываем в игровое поле положение Х
             field.showField();//выводим обновленное игровое поле в консоль
             stop = chekWin(playeer1, Players.PLAYER);//проверяем выигрыш
             if (playeer1.size() >= 5 || stop == false) {
                 System.out.println("Game Over");
                 start = false;
             }
             else
                 generatePCInput();
     }

         //генерация рандомного значения компьютером
         private void generatePCInput() {
             int y = random.nextInt(9) + 1;//компьютер рандомно вводит значение от 1-9
             while (playeer1.contains(y) || playeer2.contains(y)) {   //проверка на неккорктный ввод
                 y = random.nextInt(9) + 1;
             }
             System.out.println(y);//показываем значение введенное компьютером
             validatePCInput(y);
         }

         //заносим значение в поле и проверяем выигрыш
         private void validatePCInput(int y) {
             playeer2.add(y);//добавляем в список
             changeField(y, "O");//записываем в игровое поле положение Y
             field.showField();//выводим обновленное игровое поле в консоль
             stop = chekWin(playeer2, Players.CPU);//проверяем выигрыш
             if (stop == false) {
                 System.out.println("Game Over");
                 start = false;
             }
                 else
                     getInput();
     }

     // проверка выигрыша с помощью сравнения введенных значений с выигрышными комбинациями
     private boolean chekWin(ArrayList<Integer> array , Players players) {
             ArrayList<Integer> row1 = new ArrayList<Integer>();
             ArrayList<Integer> row2 = new ArrayList<Integer>();
             ArrayList<Integer> row3 = new ArrayList<Integer>();
             ArrayList<Integer> column1 = new ArrayList<Integer>();
             ArrayList<Integer> column2 = new ArrayList<Integer>();
             ArrayList<Integer> column3 = new ArrayList<Integer>();
             ArrayList<Integer> diagonal1 = new ArrayList<Integer>();
             ArrayList<Integer> diagonal2 = new ArrayList<Integer>();
             row1.add(1);
             row1.add(2);
             row1.add(3);
             row2.add(4);
             row2.add(5);
             row2.add(6);
             row3.add(7);
             row3.add(8);
             row3.add(9);
             column1.add(1);
             column1.add(4);
             column1.add(7);
             column2.add(2);
             column2.add(5);
             column2.add(8);
             column3.add(3);
             column3.add(6);
             column3.add(9);
             diagonal1.add(1);
             diagonal1.add(5);
             diagonal1.add(9);
             diagonal2.add(3);
             diagonal2.add(5);
             diagonal2.add(7);
             if(array.containsAll(row1) || array.containsAll(row2) || array.containsAll(row3) ||
                     array.containsAll(column1) || array.containsAll(column2) || array.containsAll(column3) ||
                     array.containsAll(diagonal1) || array.containsAll(diagonal2)) {
                 System.out.println(players + " is win!!!");
                 return false;
             }
                 else
                     return true;
             }

             //изменения значения элементов игрового поля
             void changeField(int c, String b){
         switch (c){
             case 1:
                 field.a[0] = b;
                 break;
             case 2:
                 field.a[1] = b;
                 break;
             case 3:
                 field.a[2] = b;
                 break;
             case 4:
                 field.a[3] = b;
                 break;
             case 5:
                 field.a[4] = b;
                 break;
             case 6:
                 field.a[5] = b;
                 break;
             case 7:
                 field.a[6] = b;
                 break;
             case 8:
                 field.a[7] = b;
                 break;
             case 9:
                 field.a[8] = b;
                 break;
             default:
                 break;
         }
     }
 }





