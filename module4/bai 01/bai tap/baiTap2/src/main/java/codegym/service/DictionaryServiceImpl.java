package codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService{
    @Override
    public String find(String word) {
        Map<String,String > wordList=new HashMap<>();
        wordList.put("hello","xin chao");
        wordList.put("dog","cho");
        wordList.put("cat","meo");
        wordList.put("mouse","chuot");
        wordList.put("bird","chim");
        wordList.put("leg","chan");
        wordList.put("hand","ban tay");
        wordList.put("head"," dau");
        for (Map.Entry<String,String> entry:wordList.entrySet()){
            if(word.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;

    }
}
