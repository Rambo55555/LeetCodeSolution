## 

### 题目链接：



### 答案

#### 解法一

```Java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        //1. clone
        Node cur = head;
        while(cur != null) {
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        // 2. random
        cur = head;
        while(cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 3. split
        Node clone = head.next;
        cur = head;
        while(cur.next != null) {
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return clone;
    }
}
```
#### 解法二

```Java

```

#### 解法三

```Java

```
