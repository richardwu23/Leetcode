package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L332重新安排行程 {



    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> rs = new ArrayList<>();
        Map<String,List<String>> graph = new HashMap<>();
        for(List<String> ticket:tickets){
            String key = ticket.get(0);
            List<String> stops  = graph.computeIfAbsent(key,
                    i->new ArrayList<>());

            stops.add(ticket.get(1));
        }

        graph.values().forEach(i->i.sort(String::compareTo));

        backtrack(rs,graph,"JFK");

        return rs;

    }

    private void backtrack(List<String> rs,
                           Map<String,List<String>> graph,
                           String start){
        List<String> stops = graph.get(start);

        while (stops!=null && stops.size()>0){
            String end = stops.remove(0);
            backtrack(rs,graph,end);
        }
        rs.add(0,start);
    }

}
