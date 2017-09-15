package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : BINfilevalidation
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class BINfilevalidation {
    /*
    BIN file validation.. from: 1point3acres.com/bbs
    Assume a BIN file to contain partial credit card numbers (from the front/prefixes) and an
     associated value true or false indicating whether the matching cards are debit cards or
    credit cards. The type of the card is determined by the longest matching prefix.-google 1point3acres
    e.g.
     If the binfile contains an entry ("4321", true) then a card beginning with "4321" is a debit
     card.. 1point3acres.com/bbs
    e.g.
    If there is another entry ("432143", false) then a card beginning with "432143" is not a debit
     card because it matches a longer pattern.
     */
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];//new TrieNode[26], not new TrieNode() !!!!
            isWord = false;
        }
    }
    TrieNode root;

    public BINfilevalidation() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) {//word found
            return node.isWord;//return node.isWord, not true !!!!
        }
        if (word.charAt(index) == '.') {//if whatever char can be matched
            for (TrieNode temp : node.children) {
                if (temp != null && find(word, temp, index + 1)) {//if word found, return true
                    return true;
                }
            }
            return false;
        } else {
            int j = word.charAt(index) - 'a';
            TrieNode temp = node.children[j];
            return temp != null && find(word, temp, index + 1);
        }
    }
}
