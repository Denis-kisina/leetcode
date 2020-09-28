package com.denis.kisina.practice.amazon;

import java.util.*;

public class LargestItemAssociation {


    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        Map<String, List<String>> assocMap = new HashMap<>();

        for(PairString p: itemAssociation){
            if(!assocMap.containsKey(p.first)){
                assocMap.put(p.first, new ArrayList());
            }
            assocMap.get(p.first).add(p.second);

            if(!assocMap.containsKey(p.second)){
                assocMap.put(p.second, new ArrayList());
            }
        }

        Map<Integer, List<List<String>>> sizeMap = new HashMap<>();
        int maxAssoc = Integer.MIN_VALUE;

        for(String key: assocMap.keySet()){
            Queue<String> q = new LinkedList<>();
            TreeSet<String> temp = new TreeSet<>();

            q.offer(key);

            while(!q.isEmpty()){
                String head = q.poll();
                temp.add(head);
                List<String> tail = assocMap.get(head);

                for(String t: tail){
                    q.offer(t);
                }
            }

            maxAssoc = Math.max(maxAssoc, temp.size());

            if(!sizeMap.containsKey(maxAssoc)){
                sizeMap.put(maxAssoc, new ArrayList());
            }
            sizeMap.get(sizeMap).add(new ArrayList<>(temp));
        }
        List<List<String>> maxAssocList = sizeMap.get(maxAssoc);

        Collections.sort(maxAssocList, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;
                for(int i = 0; i < o1.size() && result == 0; i++){
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });

        return maxAssocList.get(0);
    }

}
