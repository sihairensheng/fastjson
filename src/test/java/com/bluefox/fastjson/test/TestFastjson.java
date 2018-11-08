package com.bluefox.fastjson.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bluefox.fastjson.entity.Book;
import com.bluefox.fastjson.entity.Student;
import com.bluefox.fastjson.entity.Teacher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFastjson {

    //简单对象
    //@Test
    public void simpleObject() {
        String objectString = "{\"bookId\":1,\"bookName\":\"json技术\"}";
        Book book = JSON.parseObject(objectString, Book.class);
        System.err.println(book.toString());
        System.err.println(JSON.toJSONString(book));
    }

    //纯数组
    //@Test
    public void simpleList() {
        String listString = "[{\"bookId\":1,\"bookName\":\"json技术\"},{\"bookId\":2,\"bookName\":\"深入实践Spring Boot\"}]";
        List<Book> books = JSON.parseObject(listString, new TypeReference<ArrayList<Book>>() {
        });
        for (Book book : books) {
            System.err.println(book.toString());
        }
        /*JSONArray jsonArray = JSONArray.parseArray(listString);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Book book = new Book();
            book.setBookId(jsonObject.getInteger("bookId"));
            book.setBookName(jsonObject.getString("bookName"));
            System.err.println(book.toString());
        }*/
        System.err.println(JSON.toJSONString(books));
    }

    //复杂数据
    @Test
    public void complexData() {
        String compleString = "{\"teacherName\":\"bluefox\",\"teacherAge\":28,\"course\":{\"courseName\":\"english\",\"courseCode\":1270},\"students\":[{\"studentName\":\"zhagnsan\",\"studentAge\":15},{\"studentName\":\"lisi\",\"studentAge\":16}]}";
        Teacher teacher = JSON.parseObject(compleString,new TypeReference<Teacher>(){});
        System.err.println("\"teacherName\":\""+teacher.getTeacherName()+"\"");
        System.err.println("\"teacherAge\":"+teacher.getTeacherAge());
        System.err.println(teacher.getCourse().toString());
        for (Student student:teacher.getStudents()){
            System.err.println(student.toString());
        }
        System.err.println("\"teacherJSONString\":"+JSON.toJSONString(teacher));
    }

}
