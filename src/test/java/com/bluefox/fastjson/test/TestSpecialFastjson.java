package com.bluefox.fastjson.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bluefox.fastjson.entity.Book;
import com.bluefox.fastjson.entity.Teacher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSpecialFastjson {

    //属性值为null照常输出
    //@Test
    public void nullPropertyString(){
        Map<String,Object>  map = new HashMap<String,Object>();
        String a = null;
        Integer b = 1;
        map.put("a",a);
        map.put("b",b);
        //序列化属性WriteMapNullValue输出map中属性值为null的属性
        System.err.println(JSON.toJSONString(map, SerializerFeature.WriteMapNullValue));
    }

    //list和String等属性为空,先设置输出空属性,再设置输出格式
    @Test
    public void nullPropertyNumber(){
        Teacher teacher = new Teacher();
        teacher.setCourse(null);
        teacher.setStudents(null);
        teacher.setTeacherAge(18);
        teacher.setTeacherName(null);
        SerializerFeature serializerFeatures [] = new SerializerFeature[3];
        serializerFeatures[0]= SerializerFeature.WriteNullListAsEmpty;
        serializerFeatures[1]= SerializerFeature.WriteMapNullValue;
        serializerFeatures[2]= SerializerFeature.WriteNullStringAsEmpty;
        System.err.println(JSON.toJSONString(teacher,serializerFeatures));
    }
}
