package leetcode.zidianshu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-28
 **/

public class FindWords {
    class Trie {
        class TrieNode {
            boolean end;
            TrieNode[]nodes;

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

    public List<String> findWords(char[][] board, String[] words) {
        Trie tree = new Trie();
        for (String s : words) {
            tree.insert(s);
        }
        Set<String> res = new HashSet<String>();
        int m = board.length;
        if (m < 1) {
            return new ArrayList<String>(res);
        }
        int n = board[0].length;
        if (n < 1) {
            new ArrayList<String>(res);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, m, n, i, j, "", res, tree);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(char[][]board, int m, int n, int i, int j, String word, Set<String>res, Trie tree) {
        if (board[i][j] == '#') {
            return;
        }
        word += board[i][j];
        char tmp = board[i][j];
        board[i][j] = '#';
        if (tree.search(word)) {
            res.add(word);
        }
        if (!tree.startsWith(word)) {
            board[i][j] = tmp;
            return;
        }
        if (i > 0) {
            dfs(board, m, n, i-1, j, word, res, tree);
        }
        if (i < m - 1) {
            dfs(board, m, n, i + 1, j, word, res, tree);
        }
        if (j > 0) {
            dfs(board, m, n, i, j - 1, word, res, tree);
        }
        if (j < n - 1) {
            dfs(board, m, n, i, j + 1, word, res, tree);
        }
        board[i][j] = tmp;
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        char[][] board = {{'a', 'a'}};
        String[] words = {"aa"};
        List<String> res = findWords.findWords(board, words);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
