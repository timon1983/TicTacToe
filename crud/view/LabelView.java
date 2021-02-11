package main.java.com.timon1983.javacore.crud.view;

import main.java.com.timon1983.javacore.crud.controller.LabelController;

import java.util.Scanner;

public class LabelView {
    private Scanner in = new Scanner(System.in);
    private LabelController lc = new LabelController();
    private StartView startView = new StartView();


    void dataIN(){
        long idIn;
        String nameIn;
        System.out.println("1-Создать метку\n2-Получить метку по id\n3-Получить все метки\n" +
                "4-Изменить метку\n5-Удалить метку\n6-Выход из программы");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Создать метку");
                    System.out.println("Ввести имя");
                    nameIn = in.next();
                    System.out.println(lc.checkSave(nameIn));
                    dataIN();

                case 2:
                    System.out.println("Получить метку по id\nВвести id:");
                    idIn = in.nextLong();
                    System.out.println(lc.checkGetByld(idIn));
                    dataIN();
                case 3:
                    System.out.println("Получить все метки");
                    lc.checkGetAll();
                    dataIN();
                case 4:
                    System.out.println("Изменить метку");
                    System.out.println("Ввести ID изменяемой метки");
                    idIn = in.nextLong();
                    System.out.println("Ввести новое имя");
                    nameIn = in.next();
                    System.out.println(lc.checkUpdate(idIn, nameIn));
                    dataIN();
                case 5:
                    System.out.println("Удалить метку\nВведите id метки для удаления");
                    idIn = in.nextLong();
                    lc.checkDeleteByld(idIn);
                    dataIN();
                case 6:
                    System.out.println("Выход из программы");
                    startView.start();

            }
        }while (true);
    }
}
