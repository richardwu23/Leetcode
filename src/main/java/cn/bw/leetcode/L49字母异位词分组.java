package cn.bw.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class L49字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);

            String key = new String(cstr);

            List<String> vals = map.computeIfAbsent(key, i -> new LinkedList<>());
            vals.add(str);
            map.put(key, vals);
        }

        return new ArrayList<>(map.values());

    }
}
