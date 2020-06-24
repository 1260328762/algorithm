package com.cl.algorithm.stringmatching;

import java.util.*;

/**
 * @author chenliang
 * @date 2020-06-23
 * Trie 树，字符串匹配的一种数据结构
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(String text) {
        assert text != null;
        char[] chars = text.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            TrieNode nextNode = cur.children.get(c);
            if (nextNode == null) {
                TrieNode newNode = new TrieNode(c);
                cur.children.put(c, newNode);
                nextNode = newNode;
            }
            cur = nextNode;
        }
        cur.isEnding = true;
    }


    public boolean search(String text) {
        assert text != null;
        char[] chars = text.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            TrieNode nextNode = cur.children.get(c);
            if (nextNode == null) return false;
            cur = nextNode;
        }
        return cur.isEnding;
    }

    public boolean startsWith(String prefix) {
        assert prefix != null;
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            TrieNode nextNode = cur.children.get(c);
            if (nextNode == null) return false;
            cur = nextNode;
        }
        return true;
    }


    /**
     * 查找以某个前缀开头的所有字符串
     * @param prefix
     * @return
     */
    public List<String> find(String prefix) {
        assert prefix != null;
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        List<String> result = new ArrayList<>();

        for (char c : chars) {
            TrieNode nextNode = cur.children.get(c);
            if (nextNode == null) return result;
            cur = nextNode;
        }

        Map<Character, TrieNode> children = cur.children;
        Collection<TrieNode> values = children.values();
        values.forEach(trieNode -> {

        });


        return result;
    }


    private static class TrieNode {
        private char data;
        private Map<Character, TrieNode> children = new HashMap<>();
        private boolean isEnding = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
