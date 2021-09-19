package os;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-06-05
 **/

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        System.out.println("in TrieNode()");
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

public class TrieTest {
    public static void main(String[] args) {
    //    TrieNode trieNode = new TrieNode();
        TrieNode []trieNode = new TrieNode[26];
    }
}
