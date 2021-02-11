package main.java.com.timon1983.javacore.crud.view;

import java.util.Scanner;

public class StartView {
    private Scanner in = new Scanner(System.in);

    public void start(){
        System.out.println("1 - Метка\n2 - Запись\n3 - Пользователь\n4 - Завершить программу");
        do{
           int numb = in.nextInt();
            switch (numb){
                case 1:
                    LabelView labelView = new LabelView();
                    labelView.dataIN();
                case 2:
                    PostView postView = new PostView();
                    postView.dataPostIN();
                case 3:
                    WriterView writerView = new WriterView();
                    writerView.dataWriterIN();
                case 4:
                    System.exit(0);
            }
        }while (true);
    }
}
