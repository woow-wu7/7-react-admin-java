package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ArrayListTest {
    @Test
    public void arrList() {
        ArrayList<String> addressList = new ArrayList<>();
        addressList.add("beijing");
        addressList.add("shanghai");
        addressList.set(1, "shanghai2");
        addressList.remove(1);
        int beijing = addressList.indexOf("beijing");
        int size = addressList.size();
    }
}
