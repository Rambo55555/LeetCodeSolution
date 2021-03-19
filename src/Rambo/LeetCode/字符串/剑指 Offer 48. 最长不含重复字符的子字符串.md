## 

### 题目链接：



### 答案

#### 解法一

```Java
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        while (i < chs.length) {
            if(map.containsKey(chs[i])) {
                int index = map.get(chs[i]);
                max = Math.max(max, map.size());
                i = index + 1;
                map.clear();
            } else {
                map.put(chs[i], i);
                i++;
            }
        }
        max = Math.max(map.size(), max);
        return max;
    }
}
```
#### 解法二

```Java
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, j = -1;
        for(int i = 0; i < chs.length; ++i) {
            if(map.containsKey(chs[i])) {
                j = Math.max(j, map.get(chs[i]));
            }
            max = Math.max(max, i - j);
            map.put(chs[i], i);
        }
        return max;
    }
}
```

#### 解法三

```Java

```
