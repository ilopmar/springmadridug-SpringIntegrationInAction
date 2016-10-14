package com.example;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public boolean integerFilter(Integer i) {
        return i % 3 == 0;
    }

    public String convertToString(Object o) {
        return o.toString();
    }

}
