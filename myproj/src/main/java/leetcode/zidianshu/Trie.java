package leetcode.zidianshu;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-28
 **/
public class Trie {
    class TrieNode {
        boolean end;
        TrieNode []nodes;

        TrieNode() {
            end = false;
            nodes = new TrieNode[26];
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        TrieNode next;
        char []arr = word.toCharArray();
        for (char c : arr) {
            next = node.nodes[c - 'a'];
            if (next == null) {
                next = new TrieNode();
                node.nodes[c - 'a'] = next;
            }
            node = next;
        }
        node.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        TrieNode next;
        char []arr = word.toCharArray();
        for (char c : arr) {
            next = node.nodes[c - 'a'];
            if (next == null) {
                return false;
            }
            node = next;
        }
        return node.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        TrieNode next;
        char []arr = prefix.toCharArray();
        for (char c : arr) {
            next = node.nodes[c - 'a'];
            if (next == null) {
                return false;
            }
            node = next;
        }
        return true;
    }
}
