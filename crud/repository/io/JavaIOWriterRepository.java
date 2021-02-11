package main.java.com.timon1983.javacore.crud.repository.io;

import main.java.com.timon1983.javacore.crud.model.Label;
import main.java.com.timon1983.javacore.crud.model.Post;
import main.java.com.timon1983.javacore.crud.model.Writer;
import main.java.com.timon1983.javacore.crud.repository.WriterRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaIOWriterRepository implements WriterRepository {
    private File file = new File("Writer.txt");
    private JavaIOPostRepository javaIOPostRepository = new JavaIOPostRepository();

    @Override
    public Writer getByld(Long id) {
        List<String> lines = new ArrayList<>();
        String name = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) { break; }
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        String myStream = lines.stream().filter((n)->(n.startsWith(Long.toString(id)))).
                map((n) ->(n.substring(3))).findFirst().orElse("Нет записи с таким id");
        String[] lineSplit = myStream.split(", ");
        String firstNameGet = lineSplit[0];
        String lastNameGet = lineSplit[1];
        List<Post> postsGet = javaIOPostRepository.getAll();
        return  new Writer(id , firstNameGet,lastNameGet,postsGet);
    }

    @Override
    public List<Writer> getAll() {

        List<Writer> writers = new ArrayList<>();
        Long idGet;
        String firstNameGet;
        String lastNameGet;
        List<Post> postsGet;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {break;}
                String[] lineSplit = line.split(", ");
                idGet = Long.parseLong(lineSplit[0]);
                firstNameGet = lineSplit[1];
                lastNameGet = lineSplit[2];
                postsGet = javaIOPostRepository.getAll();
                writers.add(new Writer(idGet , firstNameGet,lastNameGet,postsGet));
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return writers;
    }

    @Override
    public Writer save(Writer writer) {
        long newID;
        List<String> lines = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) { break; }
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        if(lines.size() == 0){
            newID = 1;
        } else{
            newID = Long.parseLong(lines.get(lines.size() - 1).substring(0, lines.get(lines.size() - 1).
                    indexOf(',',0))) + 1;
        }

        writer.setId(newID);

        try(FileWriter fw = new FileWriter(file,true))
        {
            fw.write(convertWritertoString(writer) + "\n");
        }catch(IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        String linesStream = lines.stream().filter((n) -> (n.startsWith(Long.toString(writer.getId())))).
                findFirst().orElse("Нет такого  id");
        String[] splitLineStream = linesStream.split(",");
        if(!linesStream.equals("Нет такого  id")){
            lines.set(lines.indexOf(linesStream), splitLineStream[0] + ", " +
                    writer.getFirstName() + ", " + writer.getLastName() + ", " + writer.getPosts());
        }else {
            System.out.println("Нет такого  id");
        }

        try (FileWriter fw = new FileWriter(file,false)) {
            for (String s : lines)
                fw.write(s + "\n");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return writer;
    }

    @Override
    public void deleteByld(Long id) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {break;}
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        boolean remove = lines.removeIf((n)->(n.startsWith(Long.toString(id))));
        if (!remove) {
            System.out.println("Нет записи с таким ID");
        } else {
            System.out.println("Запись с ID " + id + " удалено");
        }

        try (FileWriter fw = new FileWriter(file,false)) {
            for (String s : lines){
                fw.write(s + "\n");}
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }

    }
    private String convertWritertoString(Writer writer){
        String line = writer.getId() + ", " + writer.getFirstName() + ", " + writer.getLastName() + ", " + writer.getPosts();
        return line;
    }
}
