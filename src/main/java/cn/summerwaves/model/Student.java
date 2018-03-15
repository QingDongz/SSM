package cn.summerwaves.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Student {
    public static String number;
    public static Integer age;
    public static String name="fuck";


    private Student() {}

    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\main\\resources\\student.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        number = properties.getProperty("number") ;
        age = Integer.valueOf(properties.getProperty("age"));
        name = properties.getProperty("name");
    }

}
