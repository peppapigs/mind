package com.xg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class StringRelatedTest {

    @Test
    public void allCharsCountFromString(){

        String str = "GmgMtfeegeghttvbpwqgdsgr5";
        char[] chars = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch: chars) {
            map.put(ch, map.getOrDefault(ch,0)+1);
//           if(!map.containsKey(ch))
//               map.put(ch, 1);
//           else
//               map.computeIfPresent(ch,(key, value)-> value+1);
        }

        System.out.println(map.toString());

    }
}
