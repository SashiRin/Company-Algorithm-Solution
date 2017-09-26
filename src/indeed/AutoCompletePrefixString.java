package indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : PrefixString
 * Creator : Edward
 * Date : Sep, 2017
 * Description : Question Description
 Say I'm typing on a phone. Given a prefix String,and a dictionary.
 Find all auto-complete word for the given prefix string
 自动补全，输入是个前缀字符串，另一个输入是个一堆单词。

 所以思路就非常简单，用个trie就行。用前缀找到子树，然后DFS一遍把所有的单词输出即可。

 */
class TrieNode{
    boolean hasWord;
    TrieNode[] children;
    //constructor忘了写括号了
    public TrieNode(){
        this.hasWord = false;
        this.children = new TrieNode[26];
    }
    public void insert(String word, int index){
        if (index == word.length()){
            hasWord = true;
            return;
        }
        //这里居然忘了写 -'a' 太不应该了
        int pos = word.charAt(index)-'a';
        if (children[pos] == null){
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index+1);
    }
    public TrieNode find(String prefix, int index){
        if (index == prefix.length()){
            return this;
        }
        int pos = prefix.charAt(index)-'a';
        if (children[pos] == null){
            return null;
        }
        return children[pos].find(prefix, index+1);
    }
}

public class AutoCompletePrefixString {
    /**
     其他解法：hashmap     bst？
     */
    TrieNode root;
    public AutoCompletePrefixString(List<String> words){
        this.root = new TrieNode();
        for (String word: words) {
            root.insert(word, 0);
        }
    }
    public List<String> find(String prefix){
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        TrieNode pRoot = cur.find(prefix, 0);
        helper(res, pRoot, prefix);
        return res;
    }
    public void helper(List<String> res, TrieNode pRoot, String curS){
        if (pRoot == null){
            return;
        }
        if (pRoot.hasWord){
            res.add(curS);
        }

        String tempS = curS;
        for (int i = 0; i < 26; i++){
            char c = (char)('a'+i);
            helper(res, pRoot.children[i], tempS + c);
        }
    }
    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("ab");
        words.add("a");
        words.add("de");
        words.add("abde");

        AutoCompletePrefixString test = new AutoCompletePrefixString(words);
        String prefix = "ab";
        List<String> res = test.find(prefix);
        System.out.println(res);
    }
}
