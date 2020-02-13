
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 798419
 */
public class Person implements  Serializable{

    public final static long serialVersionID = 46223464664L;
    
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    
    public static ArrayList<Person> loadList(HttpServletRequest request) throws FileNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        BufferedReader br = null;
        String temp;
        String path = request.getServletContext().getRealPath("/WEB-INF/list.txt");
        br = new BufferedReader(new FileReader(new File(path)));
        try {
            while ((temp = br.readLine()) != null) {
                String[] splitedLine = temp.split(",");
                Person p = new Person(splitedLine[0], Integer.parseInt(splitedLine[1]));
                list.add(p);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Not found list.txt");
            return null;
        }
        return list;
    }
}
