package baekjoon.string;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 전화번호 목록
public class B5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            Trie trie = new Trie();

            for (int i = 0; i < n; ++i) {
                numbers[i] = br.readLine();
                trie.insert(numbers[i]);
            }

            String answer = "YES";
            for (String number : numbers) {
                if (trie.isPrefix(number)) {
                    answer = "NO";
                    break;
                }
            }

            bw.write(answer);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode node = this.root;

        for (char c : key.toCharArray()) {
            node = node.getChildNodes().computeIfAbsent(String.valueOf(c), s -> new TrieNode());
        }

        node.setLastNode(true);
    }

    public boolean isPrefix(String key) {
        TrieNode node = this.root;

        for (char c : key.toCharArray()) {
            if (!node.getChildNodes().containsKey(String.valueOf(c))) return false;
            node = node.getChildNodes().get(String.valueOf(c));
        }

        return node.isLastNode() && node.getChildNodes().size() != 0;
    }
}

class TrieNode {
    private Map<String, TrieNode> childNodes = new HashMap<>();
    private boolean isLastNode;

    public Map<String, TrieNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Map<String, TrieNode> childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isLastNode() {
        return this.isLastNode;
    }

    public void setLastNode(boolean isLastNode) {
        this.isLastNode = isLastNode;
    }
}