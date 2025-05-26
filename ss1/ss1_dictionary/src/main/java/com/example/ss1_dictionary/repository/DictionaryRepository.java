package com.example.ss1_dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DictionaryRepository {
    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello", "chào");
        dictionary.put("car", "xe ô tô");
        dictionary.put("key", "chìa khoá");
        dictionary.put("computer", "máy tính");
        dictionary.put("student", "học sinh");
        dictionary.put("teacher", "giáo viên");
        dictionary.put("class", "lớp học");
    }

    public String translate(String word) {
        return dictionary.getOrDefault(word.toLowerCase(), "No word found");
    }
}
