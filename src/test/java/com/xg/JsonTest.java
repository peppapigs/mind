package com.xg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xg.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SpringBootTest
public class JsonTest {

    @Test
    public void objectMapperTest() throws JsonProcessingException {
        System.out.println("------------------array to string----------------------");
        String s = new ObjectMapper().writeValueAsString(Arrays.asList(1, 2, 3));
        System.out.println(s);

        System.out.println("------------------list to string----------------------");
        ArrayList<Object> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        String s_list = new ObjectMapper().writeValueAsString(list);
        System.out.println(s_list);

        System.out.println("------------------obj to string----------------------");
        String so = new ObjectMapper().writeValueAsString(new User(1111,"u1", "123", "" ));
        System.out.println(so);

        System.out.println("------------------map to string----------------------");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("alice", 12);
        stringObjectHashMap.put("lice", 12);
        stringObjectHashMap.put("lic", 12);
        String smap = new ObjectMapper().writeValueAsString(stringObjectHashMap);
        System.out.println(smap);


        System.out.println("------------------set to string----------------------");
        HashSet<Object> sets = new HashSet<>();
        sets.add(new User());
        sets.add(new User());
        sets.add(new User());
        String s_set = new ObjectMapper().writeValueAsString(sets);
        System.out.println(s_set);


    }
}
