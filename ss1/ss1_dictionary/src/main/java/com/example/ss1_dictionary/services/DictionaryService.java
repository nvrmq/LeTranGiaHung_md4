package com.example.ss1_dictionary.services;

import com.example.ss1_dictionary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    public String translate(String word){
        return dictionaryRepository.translate(word);
    }
}
