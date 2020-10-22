package com.denis.kisina.practice;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String search_string, String t){
        int n = search_string.length();
        int min_window_length_seen_so_far = Integer.MAX_VALUE;
        String min_window = "";

        for(int left = 0; left < n; left++){
            for(int right = left; right < n; right++){
                String window_snippet =  search_string.substring(left, right + 1);
                boolean window_contains_all_chars = stringContainsAllCharacters(window_snippet, t);

                if(window_contains_all_chars && window_snippet.length() < min_window_length_seen_so_far){
                    min_window = window_snippet;
                    min_window_length_seen_so_far = window_snippet.length();
                }
            }
        }

        return min_window;
    }

    private boolean stringContainsAllCharacters(String window_snippet, String t) {
        Map<Character, Integer> required_characters = new HashMap<>();

        for(int i = 0; i < t.length(); i++){
            int occurrence_of_character = required_characters.getOrDefault(t.charAt(i), 0);
            required_characters.put(t.charAt(i), occurrence_of_character + 1);
        }

        for(int i = 0; i < window_snippet.length(); i++){
            char cur_char = window_snippet.charAt(i);
            if(required_characters.containsKey(cur_char)){
                int new_occurrence_count = required_characters.get(cur_char) - 1;

                if(new_occurrence_count == 0){
                    required_characters.remove(cur_char);
                }else{
                    required_characters.put(cur_char, new_occurrence_count);
                }

            }
        }
        return required_characters.isEmpty();
    }
}
