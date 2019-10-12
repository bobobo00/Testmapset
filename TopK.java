package test;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * @ClassName TopK
 * @Description TODO
 * @Auther danni
 * @Date 2019/10/11 23:28]
 * @Version 1.0
 **/

public class TopK {
    public static class KV {
        String str;
        int num;

        public KV(String str, int num) {
            this.str = str;
            this.num = num;
        }

        public KV() {
        }
    }
    class Strcompare implements Comparator<KV>{
        @Override
        public int compare(KV o1, KV o2) {
            if(o1.num-o2.num>0){
                return -1;
            }else if(o1.num-o2.num<0){
                return 1;
            }else{
                return  o1.str.compareTo(o2.str);
            }
        }
    }
    public  List<String> topKFrequent(String[] words, int k){
        Map<String ,Integer> map=new HashMap<>();
        Set<KV> ss=new TreeSet<>(new Strcompare());
        for(String str:words){
            int r=map.getOrDefault(str,0);
            map.put(str,r+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String str=entry.getKey();
            int num=entry.getValue();
            KV node=new KV(str,num);
            ss.add(node);
        }
        List<String> list=new ArrayList<>();
        while(k>0){
            KV kv=((TreeSet<KV>) ss).first();
            list.add(kv.str);
            ss.remove(kv);
            k--;
        }
        return list;
    }
    public static void main(String[] args) {
        TopK topK=new TopK();
       String[] words={"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topK.topKFrequent(words,2));
    }
}
