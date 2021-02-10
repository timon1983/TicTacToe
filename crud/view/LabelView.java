package crud.view;

import crud.controller.LabelController;

import java.util.Scanner;

public class LabelView {
    private Scanner in = new Scanner(System.in);
    private LabelController lc = new LabelController();


    public void dataIN(){
        long idIn;
        String nameIn;
        System.out.println("1-Создать запись\n2-Получить запись по id\n3-Получить все записи\n" +
                "4-Изменить запись\n5-Удалить запись\n6-Выход из программы");
        do {
            int run = in.nextInt();
            switch (run) {
                case 1:
                    System.out.println("Создать запись");
                    System.out.println("Ввести имя");
                    nameIn = in.next();
                    System.out.println(lc.checkSave(nameIn));
                    dataIN();

                case 2:
                    System.out.println("Получить запись по id\nВвести id:");
                    idIn = in.nextLong();
                    System.out.println(lc.checkGetByld(idIn));
                    dataIN();
                case 3:
                    System.out.println("Получить все записи");
                    lc.checkGetAll();
                    dataIN();
                case 4:
                    System.out.println("Изменить запись");
                    System.out.println("Ввести ID изменяемой записи");
                    idIn = in.nextLong();
                    System.out.println("Ввести новое имя");
                    nameIn = in.next();
                    System.out.println(lc.checkUpdate(idIn, nameIn));
                    dataIN();
                case 5:
                    System.out.println("Удалить запись\nВведите id записи для удаления");
                    idIn = in.nextLong();
                    lc.checkDeleteByld(idIn);
                    dataIN();
                case 6:
                    System.out.println("Выход из программы");
                    System.exit(0);

            }
        }while (true);
    }
}
