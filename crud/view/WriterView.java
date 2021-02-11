package main.java.com.timon1983.javacore.crud.view;

import main.java.com.timon1983.javacore.crud.controller.PostController;

import java.util.Scanner;

public class WriterView {
    private Scanner in = new Scanner(System.in);
    private WriterController wc = new WriterController();
    private StartView startView = new StartView();


    void dataWriterIN(){
        long idIn;
        String firstNameIn;
        String lastNameIn;
        System.out.println("1-Создать пользователя\n2-Получить пользователя по id\n3-Получить все пользователей\n" +
                "4-Изменить пользователя\n5-Удалить пользователя\n6-Выход из программы");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Создать запись");
                    System.out.println("Ввести имя");
                    firstNameIn = in.next();
                    System.out.println("Ввести фамилию");
                    lastNameIn = in.next();
                    System.out.println(wc.checkSave(firstNameIn,lastNameIn));
                    dataWriterIN();

                case 2:
                    System.out.println("Получить запись по id\nВвести id:");
                    idIn = in.nextLong();
                    System.out.println(wc.checkGetByld(idIn));
                    dataWriterIN();
                case 3:
                    System.out.println("Получить все записи");
                    wc.checkGetAll();
                    dataWriterIN();
                case 4:
                    System.out.println("Изменить запись");
                    System.out.println("Ввести ID пользователя");
                    idIn = in.nextLong();
                    System.out.println("Ввести новое имя пользователя");
                    firstNameIn = in.next();
                    System.out.println("Вести новую фамилию пользователя");
                    lastNameIn = in.next();
                    System.out.println(wc.checkUpdate(idIn, firstNameIn,lastNameIn));
                    dataWriterIN();
                case 5:
                    System.out.println("Удалить запись\nВведите id записи для удаления");
                    idIn = in.nextLong();
                    wc.checkDeleteByld(idIn);
                    dataWriterIN();
                case 6:
                    System.out.println("Выход из программы");
                    startView.start();

            }
        }while (true);
    }
}
