package com.example.memedroid.classes;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class KeyValueStore {
	
	private HashMap<String, Object> KeyValueMap;
	
	public KeyValueStore() {
        this.KeyValueMap = new HashMap<>();
        //value default true
    	KeyValueMap.put("classification", false);
    	//value default true
    	KeyValueMap.put("play-off", false);

    }
	
    public Object getValue(String key) {
        return KeyValueMap.get(key);
    }

    public void setValue(String key, Boolean value) {
    	KeyValueMap.put(key, value);
    }

    public void removeValue(String key) {
    	KeyValueMap.remove(key);
    }
    
}
