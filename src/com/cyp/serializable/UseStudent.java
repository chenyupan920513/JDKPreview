package com.cyp.serializable;

import java.io.*;
import java.util.Scanner;

/**
 *Title:应用学生类
 *Description:实现学生类实例的序列化与反序列化
 *Copyright: copyright(c) 2012
 *Filename: UseStudent.java
 *@author Wang Luqing
 *@version 1.0
 */

public class UseStudent
{
    public static void useStudent()
    {
        Student st = new Student("Tom",'M',20,3.6);
        File file = new File("D:\\Java\\com\\jieke\\io\\student.txt");
        try
        {
            file.createNewFile();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            //Student对象序列化过程
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(st);
            oos.flush();
            oos.close();
            fos.close();

            //Student对象反序列化过程
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student st1 = (Student) ois.readObject();
            System.out.println("name = " + st1.getName());
            System.out.println("sex = " + st1.getSex());
            System.out.println("year = " + st1.getYear());
            System.out.println("gpa = " + st1.getGpa());
            ois.close();
            fis.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        for(;;){
        System.out.println("输入");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        Reader in = new CharArrayReader(read.toCharArray());
        int c =0;
        StringBuffer s1 = new StringBuffer();
        try {
            while (c!=-1){
                s1.append((char)c);
                c = in.read();
                System.out.println(c);
                System.out.println((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s1);
    }
    }
}
