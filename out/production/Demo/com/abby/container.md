### java集合的四大接口
|  接口名称   | 接口描述  |
|  ----  | ----  |
| Collection  | 集合框架的顶层接口，定义了集合类的通用方法。需要注意的是要跟`Collections`区分开，Collections是一个工具类，提供了对集合元素排序，反转以及线程安全等操作 |
| List  | 存储不唯一的数据 |
| Set  | 存储唯一的数据 |
| Map  | 以键值对的形式存储数据 |

### List接口
List接口下的实现类有ArrayList，LinkedList和Vector。
* ArrayList: 
（1）ArrayList实现了List接口，RandomAccess接口，Cloneable接口以及Serializable接口。因为实现了RamdomAccess接口，所以ArrayList是支持随机访问的。Cloneable接口允许在堆上克隆一个和原对象一样的对象，且克隆出来的对象地址是不同的。（2）ArrayList的底层实现是数组，所以ArrayList查询的速度比较快而删除的速度比较慢。（3）ArrayList是非线程安全的。（4）当ArrayList中的元素超过初始容量10时，将进行扩容，扩容后容量为原来的1.5倍。ArrayList的适用场景为(a)需要频繁访问随机数据。(b)插入顺序与读取顺序相同。(c)删除的情况很少。ArrayList部分源码如下：
&nbsp;
* LinkedList:
（1）LinkedList实现了List接口，Dequeue接口，Cloneable接口，Serializable接口。LinkedList提供了双向队列的方法。（2）LinkedList底层实现是双链表，所以LinkedList适用于需要快速插入以及快速删除的场景。（3）LinkList是非线程安全的。
&nbsp;
* Vector:
(1)Vector实现了List接口，RandomAccess，Cloneable，Serializable。所以Vector是支持快速访问的。（2）Vector的底层数据结构也是数组，与ArrayList不同的是，Vector的方法都用synchronized修饰，所以Vector是线程安全的。（3）Vector的默认初始容量也是10,当元素超过初始容量时，扩容为原来的两倍。


### Set接口
Set接口下的实现类有HashSet，LinkedHashSet以及TreeSet。
* HashSet：
（1）HashSet实现了Set接口，Cloneable接口，Serializable接口。（1） HashSet存储的元素是唯一的。（2）HashSet允许空值。（3）HashSet的底层实现为Hashmap。（4）HashSet是非线程安全的。（5）因为底层的实现是HashMap，所以HashSet的初始容量也是哈16，当超过加载因子*初始容量后会扩容，扩容为原来的两倍。（6）HashSet不保证有序。
* LinkedHashSet：
LinkedHashSet和HashSet类似，区别在于其底层实现是LinkedHashMap，LinkedHashMap保证有序。
* TreeSet：
（1）TreeSet实现了NavigableSet接口，Cloneable接口，Serializable接口。（3）TreeSet存储的元素是唯一的。（2）TreeSet底层基于TreeMap实现。

### Map接口
Map接口下的实现类有HashTable，LinkedHashMap，HashMap，TreeMap。
* HashMap：
（1）HashMap实现了Map接口，Cloneable接口，Serializable接口。（2）HashMap是非线程安全的。（3）HashMap初始化容量为16，默认加载因子是0.75,当达到默认容量*加载因子后，进行扩容，扩容后的容量为原来的两倍。（4）HashMap底层数据机构为数组+链表，JDK1.8之后，当链表长度超过8后，链表会转成红黑树。（5）HashMap可以设置null键值。
* HashTable：
（1）HashTable实现了Map接口，Cloneable接口，Serializable接口。（2）HashTable是线程安全的。（3）HashTable不允许null键值。（4）HashTable的默认容量是11，默认负载因子是0.75。元素达到默认容量*负载因子后，进行扩容，扩容后容量是原来的2n+2
* LinkedHashMap：
（1）LinkedHashMap实现了Map接口。（2）LinkedHashMap是有序的。（3）LinkedHashMap底层基于HashMap实现。