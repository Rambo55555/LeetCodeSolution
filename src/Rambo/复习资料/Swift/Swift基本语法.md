# 基本运算符

### 空合运算符

Nil Coalescing Operator）

*空合运算符*（`a ?? b`）将对可选类型 `a` 进行空判断，如果 `a` 包含一个值就进行解包，否则就返回一个默认值 `b`。表达式 `a` 必须是 Optional 类型。默认值 `b` 的类型必须要和 `a` 存储值的类型保持一致。

空合运算符是对以下代码的简短表达方法：

```swift
a != nil ? a! : b
```

### 区间运算符（Range Operators）

Swift 提供了几种方便表达一个区间的值的*区间运算符*。

```swift
//闭区间
a...b
//半开区间
a..<b
//单侧区间
let range = ...5
range.contains(-1) // true
range.contains(8) // false
```

