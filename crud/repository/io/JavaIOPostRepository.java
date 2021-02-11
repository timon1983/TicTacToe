package main.java.com.timon1983.javacore.crud.repository.io;

import main.java.com.timon1983.javacore.crud.model.Label;
import main.java.com.timon1983.javacore.crud.model.Post;
import main.java.com.timon1983.javacore.crud.model.Writer;
import main.java.com.timon1983.javacore.crud.repository.PostRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaIOPostRepository implements PostRepository {
    private File file = new File("Post.txt");
    private JavaIOLableRepositoryImpl javaIOLableRepository = new JavaIOLableRepositoryImpl();

    @Override
    public Post getByld(Long id) {
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
        String getContent = lineSplit[1];
        long getCreated = Long.parseLong(lineSplit[2]);
        long getUpdated = Long.parseLong(lineSplit[3]);
        List<Label> getLables = javaIOLableRepository.getAll();

        return  new Post(id , getContent,getCreated,getUpdated,getLables);
    }

    @Override
    public List<Post> getAll() {

        List<Post> posts = new ArrayList<>();
        Long idGet;
        String getContent;
        long getCreated;
        long getUpdated;
        List<Label> getLables;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (true) {
                String line = br.readLine();
                if (line == null) {break;}
                String[] lineSplit = line.split(", ");
                idGet = Long.parseLong(lineSplit[0]);
                getContent = lineSplit[1];
                getCreated = Long.parseLong(lineSplit[2]);
                getUpdated = Long.parseLong(lineSplit[3]);
                getLables = javaIOLableRepository.getAll();
                posts.add(new Post(idGet , getContent, getCreated, getUpdated, getLables));
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return posts;
    }

    @Override
    public Post save(Post post) {
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

        post.setId(newID);

        try(FileWriter fw = new FileWriter(file,true))
        {
            fw.write(convertWritertoString(post) + "\n");
        }catch(IOException e){
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return post;
    }

    @Override
    public Post update(Post post) {
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

        String linesStream = lines.stream().filter((n) -> (n.startsWith(Long.toString(post.getId())))).findFirst().orElse("Нет такого  id");
        String[] splitLineStream = linesStream.split(",");
        if(!linesStream.equals("Нет такого  id")){
            lines.set(lines.indexOf(linesStream), splitLineStream[0] + ", " +
                    post.getContent() + ", " +post.getCreated() + ", " + post.getUpdated() + ", " +
                    post.getLables());
        }else {
            System.out.println("Нет такого  id");
        }

        try (FileWriter fw = new FileWriter(file,false)) {
            for (String s : lines)
                fw.write(s + "\n");
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return post;
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
    private String convertWritertoString(Post post){
        String line = post.getId() + ", " + post.getContent() + ", " +post.getCreated() + ", " + post.getUpdated() + ", " +
                post.getLables();
        return line;
    }
}
