package com.xg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xg.entity.User;
import com.xg.service.domain.DstTimeMount;
import com.xg.service.domain.TimeMount;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class JsonTest {

    @Test
    public void jsonNodeTest(){
        String jsonStr = "{\"2024-06-25\": {\"13688\": 0.0}}";  // 注意格式正确

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonStr);

            // 输出 JsonNode 内容
            System.out.println(jsonNode);

            // 访问节点
            JsonNode dateNode = jsonNode.get("2024-06-25");
            System.out.println(dateNode);
            JsonNode valueNode = dateNode.get("13688");
            System.out.println(valueNode.asDouble());  // 输出 0.0
            System.out.println(jsonNode.fieldNames().next());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dataTransferThroughJsonNodeTest() throws JsonProcessingException, ParseException {
        /**
         * {
         *     key1(时间): value1(供销商+出货量)
         * }
         */
        String jsonStr = "{" +
                "\"2024-07-08\":{\"13681\":12}," +
                "\"2024-06-26\":{\"13686\":13}," +
                "\"2024-06-27\":{\"13688\":12}," +
                "\"2024-06-28\":{\"13687\":11}," +
                "\"2024-06-29\":{\"13687\":10}," +
                "\"2024-06-30\":{\"13688\":11}," +
                "\"2024-07-01\":{\"13686\":14}," +
                "\"2024-07-02\":{\"13688\":13}," +
                "\"2024-07-03\":{\"13686\":16}," +
                "\"2024-07-04\":{\"13683\":12}," +
                "\"2024-07-05\":{\"13683\":21}," +
                "\"2024-07-06\":{\"13688\":10}" +
                "}";

        //先要将str中的三个属性对应数据取出来形成对象来存储
        ArrayList<DstTimeMount> r_list = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonStr);

        //System.out.println(jsonNode);  //{数据,数据...}
        Iterator<String> stringIterator = jsonNode.fieldNames();
        //
        HashSet<String> dst_set = new HashSet<>();

        while(stringIterator.hasNext()){
            DstTimeMount dstTimeMount = new DstTimeMount();
            String date = stringIterator.next();
            //System.out.println(next); //2024-06-25
            dstTimeMount.setDate((new SimpleDateFormat("yyyy-MM-dd").parse(date)));
            JsonNode jsonNodeIn = jsonNode.get(date);
            //System.out.println(jsonNodeIn); //{"13688":12}

            String key_in = jsonNodeIn.fieldNames().next();
            dst_set.add(key_in);

            dstTimeMount.setDistributor(Long.parseLong(key_in));
            long mount = jsonNodeIn.get(key_in).asLong();
            dstTimeMount.setMount(mount);
            r_list.add(dstTimeMount);
        }

        System.out.println("front_dst_set:" + dst_set.toString());
        ArrayList<String> dst_list = new ArrayList<>(dst_set);
        dst_list.sort((o1, o2)->{
            return Long.compare(Long.parseLong(o1), Long.parseLong(o2));
        });

        System.out.println("back_dst_list:" + dst_list.toString());

        //按照分销商id大小排序
        r_list.sort((o1, o2) -> {
            long distributor1 = o1.getDistributor();
            long distributor2 = o2.getDistributor();
            return Long.compare(distributor1, distributor2);
        });
        //r_list.stream().forEach(one -> System.out.println(one.toString()));

        ArrayList<HashMap<Long, ArrayList<TimeMount>>> list = new ArrayList<HashMap<Long, ArrayList<TimeMount>>>();
        //按照dst_set内的存入的distributor id顺序来将r_list的数据映射成ArrayList<HashMap<Long, TimeMount>>对象


        HashMap<Long, ArrayList<TimeMount>> map = new HashMap<>();
        for (String dst: dst_list) {
            ArrayList<TimeMount> timeMounts = new ArrayList<TimeMount>();
            r_list.stream()
                    .filter(tm -> tm.getDistributor() == Long.parseLong(dst))
                    .forEach(tm -> {
                        timeMounts.add(new TimeMount(tm.getDate(),tm.getMount()));
                        map.put(tm.getDistributor(), timeMounts);
                    });
            ArrayList<TimeMount> tms = map.get(Long.parseLong(dst));
            tms.sort((o1, o2)->o1.getDate().compareTo(o2.getDate()));
        }

        //时间排序

        System.out.println(map.toString());


        ArrayList<ArrayList<String>> arrayLists = new ArrayList<ArrayList<String>>();
        //将map内的value转为[[时间,出货额],.....]
        Collection<ArrayList<TimeMount>> values = map.values();
        Iterator<ArrayList<TimeMount>> iterator = values.iterator();

        while(iterator.hasNext()){
            ArrayList<TimeMount> next = iterator.next();
            ArrayList<String> strings = new ArrayList<>();
            next.stream().forEach(tm -> {
                strings.add(tm.getDate().toString());
                strings.add(String.valueOf(tm.getMount()));
            });

            arrayLists.add(strings);
        }

//
        System.out.println("@:" + arrayLists.toString());
    }

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
