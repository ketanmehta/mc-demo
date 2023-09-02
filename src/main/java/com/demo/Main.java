package com.demo;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Test> list = new ArrayList<>();
        while (true) {
            if (list.size() == 10000) {
                continue;
            }
            list.add(new Test());
        }

    }
}

class Test {
    public Map<String, String> map = new HashMap<>(32);

    public Test() {
        map.put("kuch", "kuch");
    }
}
