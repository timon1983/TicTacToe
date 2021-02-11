package main.java.com.timon1983.javacore.crud.view;


import main.java.com.timon1983.javacore.crud.controller.PostController;

import java.util.Scanner;

public class PostView {
    private Scanner in = new Scanner(System.in);
    private PostController pc = new PostController();
    private StartView startView = new StartView();


    void dataPostIN(){
        long idIn;
        String contentIn;
        long createdIn;
        long updatedIn;
        System.out.println("1-Создать запись\n2-Получить запись по id\n3-Получить все записи\n" +
                "4-Изменить запись\n5-Удалить запись\n6-Выход из программы");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Создать запись");
                    System.out.println("Ввести имя");
                    contentIn = in.next();
                    System.out.println("Ввести created");
                    createdIn = in.nextLong();
                    System.out.println("Ввести updated");
                    updatedIn = in.nextLong();
                    System.out.println(pc.checkSave(contentIn,createdIn,updatedIn));
                    dataPostIN();

                case 2:
                    System.out.println("Получить запись по id\nВвести id:");
                    idIn = in.nextLong();
                    System.out.println(pc.checkGetByld(idIn));
                    dataPostIN();
                case 3:
                    System.out.println("Получить все записи");
                    pc.checkGetAll();
                    dataPostIN();
                case 4:
                    System.out.println("Изменить запись");
                    System.out.println("Ввести ID изменяемой записи");
                    idIn = in.nextLong();
                    System.out.println("Ввести новый контент");
                    contentIn = in.next();
                    System.out.println("Вести created");
                    createdIn = in.nextLong();
                    System.out.println("Ввести updated");
                    updatedIn = in.nextLong();
                    System.out.println(pc.checkUpdate(idIn, contentIn,createdIn,updatedIn));
                    dataPostIN();
                case 5:
                    System.out.println("Удалить запись\nВведите id записи для удаления");
                    idIn = in.nextLong();
                    pc.checkDeleteByld(idIn);
                    dataPostIN();
                case 6:
                    System.out.println("Выход из программы");
                    startView.start();

            }
        }while (true);
    }
}
