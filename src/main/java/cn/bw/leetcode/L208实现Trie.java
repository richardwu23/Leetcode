package cn.bw.leetcode;

public class L208实现Trie {

    /**
     * Trie 26 多叉树
     * O(len(word))
     */
    class Trie {

        // Trie 树的根节点
        Node root;

        public Trie() {
            // 初始化根节点
            root = new Node();
        }

        // 插入单词到 Trie 树中
        public void insert(String word) {
            int len = word.length();
            Node node = root; // 从根节点开始
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                // 如果当前字符不存在于子节点中，创建新节点
                if (!node.isContain(c)) {
                    node.add(c, new Node());
                }
                // 移动到字符对应的子节点
                node = node.get(c);
            }
            // 标记最后一个字符节点为单词的结束
            node.setEnd(true);
        }

        // 搜索单词是否存在于 Trie 中
        public boolean search(String word) {
            // 使用 dfs 找到最后一个字符对应的节点
            Node node = dfs(word);
            // 如果节点不为空并且是单词结束节点，则返回 true
            return node != null && node.isEnd();
        }

        // 判断是否存在以指定前缀开头的单词
        public boolean startsWith(String prefix) {
            // 使用 dfs 找到前缀最后一个字符对应的节点
            Node node = dfs(prefix);
            // 如果节点存在，返回 true；否则返回 false
            return node != null;
        }

        // 深度优先搜索，查找字符串对应的最后一个节点
        private Node dfs(String prefix) {
            Node node = root; // 从根节点开始
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                // 如果字符不存在于当前节点的子节点中，返回 null
                if (!node.isContain(c)) {
                    return null;
                }
                // 移动到字符对应的子节点
                node = node.get(c);
            }
            // 返回字符串对应的最后一个节点
            return node;
        }

        // Trie 树节点的定义
        class Node {
            Node[] links; // 子节点数组，每个索引对应一个小写字母
            boolean isEnd; // 表示当前节点是否是一个单词的结束节点

            public Node() {
                // 初始化子节点数组，大小为 26（对应 'a' - 'z'）
                links = new Node[26];
                isEnd = false; // 默认当前节点不是单词的结束节点
            }

            // 获取当前节点是否是单词结束节点
            public boolean isEnd() {
                return isEnd;
            }

            // 添加子节点，将字符 c 对应的子节点设置为 node
            public void add(char c, Node node) {
                links[c - 'a'] = node;
            }

            // 判断当前节点是否包含字符 c 对应的子节点
            public boolean isContain(char c) {
                return links[c - 'a'] != null;
            }

            // 获取所有子节点数组
            public Node[] getLinks() {
                return links;
            }

            // 设置当前节点为单词的结束节点
            public void setEnd(boolean end) {
                isEnd = end;
            }

            // 获取字符 c 对应的子节点
            public Node get(char c) {
                return links[c - 'a'];
            }
        }
    }



}
