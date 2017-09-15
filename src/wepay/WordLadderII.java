package wepay;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : WordLadderII
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class WordLadderII {
    //O(n^n)
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(dict==null) return res;
        Map<String,Integer> distance = new HashMap<String,Integer>();
        dict.add(end);
        distance.put(start,1);

        Map<String,Set<String>> neighbours =new HashMap<String,Set<String>>();
        LinkedList<String> queue= new LinkedList<String>();

        queue.add(start);
        boolean foundIt= false;
        //BFS
        while(!queue.isEmpty()){
            int qsize=queue.size();
            for(int i=0;i<qsize;i++){
                String curword= queue.poll();

                Set<String> curneighbours = gettheNeibours(curword, dict);
                Iterator<String> iterator= curneighbours.iterator();
                for (; iterator.hasNext();) {
                    String nb = iterator.next();
                    if(curword.equals(end)){
                        foundIt=true;
                    }
                    if (!distance.containsKey(nb)  ) { // visited
                        distance.put(nb, distance.get(curword) + 1);
                        queue.add(nb);
                    } else {
                        if( distance.get(nb)!=distance.get(curword)+1)//if not shortest
                            iterator.remove(); //remove since not shortest
                    }

                }
                neighbours.put(curword,curneighbours);
            }//end for(int i=0;i<qsize;i++){
            if(foundIt)
                break;
        }//end while(!queue.isEmpty()){
        //DFS
        List<String> worklist= new ArrayList<String>();
        dfs(start,end,dict,neighbours,worklist,res);
        return res;
    }

    public void dfs(String curword,String end,Set<String> dict,Map<String,Set<String>> neighbours,List<String> worklist,List<List<String>> res){

        if(curword.equals(end)){
            worklist.add(curword);
            res.add(new ArrayList<>(worklist));
            worklist.remove(worklist.size()-1);
            return;
        }
        worklist.add(curword);
        if(neighbours.containsKey(curword)) {
            for (String nb : neighbours.get(curword)) {
                dfs(nb, end, dict, neighbours, worklist, res);
            }
        }
        worklist.remove(worklist.size()-1);
    }

    public Set<String> gettheNeibours(String curword,Set<String> dict){
        Set<String> res=  new HashSet<String>();

        int len= curword.length();
        char[] chs= curword.toCharArray();
        for(int i=0;i<len;i++){
            char old = chs[i];
            for(char c='a';c<='z';c++){
                chs[i]=c;
                String composStr= String.valueOf(chs);
                if(!composStr.equals(curword) && dict.contains(composStr))
                    res.add(composStr);
            }
            chs[i]= old;
        }
        return res;
    }
}
