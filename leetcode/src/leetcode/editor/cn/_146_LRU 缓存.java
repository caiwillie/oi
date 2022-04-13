package leetcode.editor.cn;

////请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
////
//// 实现 LRUCache 类： 
////
//// 
//// 
//// 
//// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
//// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
//// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//
////key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
//// 
////
//// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//// 
//// 
////
//// 
////
//// 示例： 
////
//// 
////输入
////["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
////[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
////输出
////[null, null, null, 1, null, -1, null, -1, 3, 4]
////
////解释
////LRUCache lRUCache = new LRUCache(2);
////lRUCache.put(1, 1); // 缓存是 {1=1}
////lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
////lRUCache.get(1); // 返回 1
////lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
////lRUCache.get(2); // 返回 -1 (未找到)
////lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
////lRUCache.get(1); // 返回 -1 (未找到)
////lRUCache.get(3); // 返回 3
////lRUCache.get(4); // 返回 4
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= capacity <= 3000 
//// 0 <= key <= 10000 
//// 0 <= value <= 10⁵ 
//// 最多调用 2 * 10⁵ 次 get 和 put 
//// 
//// Related Topics 设计 哈希表 链表 双向链表 👍 2097 👎 0
//

import java.util.HashMap;
import java.util.Map;

class _146_LRU缓存{
    public static void main(String[] args) {
        LRUCache cache = new _146_LRU缓存().new LRUCache(2);
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        //      put","put","get","put","get","put","get","get","get"


        /*
        * 解答失败: 测试用例:["LRUCache","put","put","get","put","get","put","get","get","get"]
        * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        *         "put","put","get","put","get","put","get","get","get"
        *         [1,1],[2,2],[1],  [3,3],[2],  [4,4],[1],  [3],    [4]
        * 测试结果:[null,null,null,1,null,2,null,1,3,4]
        * 期望结果:[null,null,null,1,null,-1,null,-1,3,4]
         * */
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    // 双向链表的结点构造
    class Node {
        int k, v;
        Node l, r;
        Node (int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    int n;
    // 作为双向链表中的哨兵标记头和尾
    Node head, tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        n = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }
    // 不管是插入还是访问，如果这个node就是最近被访问过的，内存满时被删除优先级最低，需更新到双向链表的头部
    void refresh(Node node) {
        // refresh 可能node是新的，也可能是旧的，所以delete中需要判断node.l是否为空来确定是否新节点
        delete(node);
        node.r = head.r;
        head.r.l = node;
        head.r = node;
        node.l = head;
    }
    // node.l不为空 说明node在链表中 才进行删除
    void delete(Node node) {
        if (node.l != null) {
            // 说明是新节点
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 被访问了 更新到链表表头
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        } else {
            // 内存满时，最近最少使用的结点(这里指链表表尾)就会被删除
            if (map.size() == n) {
                Node del = tail.l;
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        // 访问/插入了 更新到链表表头
        refresh(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}