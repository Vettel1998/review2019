# Java Collection Framework

- 集合框架是用于表示和操作集合的统一体系结构，使它们可以独立于其表示的细节进行操作。 它减少了编程工作，同时提高了性能。 它实现了不相关的API之间的互操作性，减少了设计和学习新API的工作量，并促进了软件重用。 该框架基于十几个集合接口。 它包括这些接口的实现和用于操纵它们的算法。

# fail-fast

- 我们通常说的Java中的fail-fast机制，默认是指的是Java集合中的一种错误检测机制。当多个线程对部分集合进行结构上的改变的操作时，有可能会产生fail-fast机制，这时候会抛出ConcurrentModificationException
- 在foreach循环中对非fail-safe集合进行元素的remove/add操作时候

# fail-safe

# Iterable

- Implementing this interface allows an object to be the target of the "for-each loop" statement

- ```java
  Iterator<T> iterator();
  default void forEach(Consumer<? super T> action) {
          Objects.requireNonNull(action);
          for (T t : this) {
              action.accept(t);
          }
   }
  ```

# Iterator

- An iterator over a collection. `Iterator` takes the place of [`Enumeration`](https://docs.oracle.com/javase/8/docs/api/java/util/Enumeration.html) in the Java Collections Framework. Iterators differ from enumerations in two ways:

  - Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.

  - Method names have been improved.

- This interface is a member of the [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/index.html).

- ```java
  boolean hasNext();
  E next();
  default void remove() {
          throw new UnsupportedOperationException("remove");
  }
  default void forEachRemaining(Consumer<? super E> action) {
          Objects.requireNonNull(action);
          while (hasNext())
              action.accept(next());
  }
  ```

# Spliterator

# Stream

# Collection

- ```java
  default boolean removeIf(Predicate<? super E> filter) {
          Objects.requireNonNull(filter);
          boolean removed = false;
          final Iterator<E> each = iterator();
          while (each.hasNext()) {
              if (filter.test(each.next())) {
                  each.remove();
                  removed = true;
              }
          }
          return removed;
      }
  ```

- ```java
  default Stream<E> stream() {
          return StreamSupport.stream(spliterator(), false);
  }
  default Stream<E> parallelStream() {
          return StreamSupport.stream(spliterator(), true);
  }
  ```

# List

# ArrayList

- 线程不安全

- #### c.toArray might not return Object

  ```java
  public ArrayList(Collection<? extends E> c) {
          elementData = c.toArray();
          if ((size = elementData.length) != 0) {
              // c.toArray might (incorrectly) not return Object[] (see 6260652)
              if (elementData.getClass() != Object[].class)
                  elementData = Arrays.copyOf(elementData, size, Object[].class);
          } else {
              // replace with empty array.
              this.elementData = EMPTY_ELEMENTDATA;
          }
      }
  ```

- 默认的初始化数组大小为10，扩容1.5倍

- ArrayList的Iterator的remove方法通过expectedModCount = modCount使得可以删除元素

  直接在遍历的时候删除原数组会导致(ConcurrentModificationException)

  ```java
  public void remove() {
              if (lastRet < 0)
                  throw new IllegalStateException();
              checkForComodification();
  
              try {
                  ArrayList.this.remove(lastRet);
                  cursor = lastRet;
                  lastRet = -1;
                  expectedModCount = modCount;
              } catch (IndexOutOfBoundsException ex) {
                  throw new ConcurrentModificationException();
              }
          }
  ```

# Vector

- 线程安全，synchronized

- 默认容量为10，默认扩容为扩容成两倍，也可以设置增长系数capacityIncrement

  ```java
  int newCapacity = oldCapacity + ((capacityIncrement > 0) ?capacityIncrement : oldCapacity);
  ```

- ```
  public Enumeration<E> elements()
  ```

# fail fast / fail safe

- modCount  checkForComodification
- 当Iterator这个迭代器被创建后，除了迭代器本身的方法(remove)可以改变集合的结构外，其他的因素如若改变了集合的结构，都被抛出ConcurrentModificationException异常
- 为了避免触发fail-fast机制，导致异常，我们可以使用Java中提供的一些采用了fail-safe机制的集合类。这样的集合容器在遍历时不是直接在集合内容上访问的，而是先复制原有集合内容，在拷贝的集合上进行遍历。java.util.concurrent包下的容器都是fail-safe的，可以在多线程下并发使用，并发修改。同时也可以在foreach中进行add/remove 。

# LinkedList

- 双向链表

# Stack

- Vector的子类
- search(Object o)  从栈顶往下依次查找是否有相等的元素,返回的是从1开始计数的位置值 

# HashSet

- 底层基于HashMap

- Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75)

- ```java
   // Dummy value to associate with an Object in the backing Map
  private static final Object PRESENT = new Object();
  public boolean add(E e) {
          return map.put(e, PRESENT)==null;
      }
  ```

# LinkedHashSet

# TreeSet

# HashMap

- The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.

- 底层基于数组+链表

- 已经存储数据的桶数/总桶数如果这个结果值大于加载因子(默认为0.75)，进行扩容，扩容一倍

- 每次扩容之后所有元素对象重新存储--- rehash

- 加载因子越小，会频繁的扩容，会频繁的rehash;加载因子越大，导致大量的数据存放到某几个桶里，让链式栈结构变得很长，查询效率降低

- /** * The default initial capacity - MUST be a power of two. */

- 默认容量为16

  ```java
   /**
       * The default initial capacity - MUST be a power of two.
       */
      static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
  ```

- 默认的加载因子

  ```java
   /**
       * The load factor used when none specified in constructor.
       */
      static final float DEFAULT_LOAD_FACTOR = 0.75f;
  ```

- 桶中数量大于8，并且桶的数量大于64时，链表转换为红黑树；链表长度小于６时，

  ```java
  /**
       * The bin count threshold for using a tree rather than list for a
       * bin.  Bins are converted to trees when adding an element to a
       * bin with at least this many nodes. The value must be greater
       * than 2 and should be at least 8 to mesh with assumptions in
       * tree removal about conversion back to plain bins upon
       * shrinkage.
       */
      static final int TREEIFY_THRESHOLD = 8;
      /**
       * The bin count threshold for untreeifying a (split) bin during a
       * resize operation. Should be less than TREEIFY_THRESHOLD, and at
       * most 6 to mesh with shrinkage detection under removal.
       */
      static final int UNTREEIFY_THRESHOLD = 6;
  
      /**
       * The smallest table capacity for which bins may be treeified.
       * (Otherwise the table is resized if too many nodes in a bin.)
       * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
       * between resizing and treeification thresholds.
       */
      static final int MIN_TREEIFY_CAPACITY = 64;
  ```

  

- ```java
  //保证capacity是2的n次方
  static final int tableSizeFor(int cap) {
          int n = cap - 1;
          n |= n >>> 1;
          n |= n >>> 2;
          n |= n >>> 4;
          n |= n >>> 8;
          n |= n >>> 16;
          return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
      }
  ```

- hash()  高16位和低16位异或，如果只取余的话会使得hashcode的高位没有发挥作用

  ```
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
  ```

- 查询操作
  
  - hash&(n-1) 取代取余操作，这也是容量要求2的n次方的原因
- 遍历
- 插入

# HashTable

- 不允许null
- 初始容量为11 默认扩容为１倍再加１

# LinkedHashMap

- LinkedHashMap是HashMap的子类，但是内部还有一个双向链表维护键值对的顺序，每个键值对既位于哈希表中，也位于双向链表中。LinkedHashMap支持两种顺序插入顺序 、 访问顺序

  插入顺序：先添加的在前面，后添加的在后面。修改操作不影响顺序
  访问顺序：所谓访问指的是get/put操作，对一个键执行get/put操作后，其对应的键值对会移动到链表末尾，所以最末尾的是最近访问的，最开始的是最久没有被访问的，这就是访问顺序。

- LinkedHashMap并没有重写任何put方法。但是其重写了构建新节点的newNode()方法.
  newNode()会在HashMap的putVal()方法里被调用，putVal()方法会在批量插入数据putMapEntries(Map<? extends K, ? extends V> m, boolean evict)或者插入单个数据public V put(K key, V value)时被调用。

  LinkedHashMap重写了newNode(),在每次构建新节点时，通过linkNodeLast(p);将新节点链接在内部双向链表的尾部。
  
- ```java
    /**
       * The head (eldest) of the doubly linked list.
       */
      transient LinkedHashMap.Entry<K,V> head;
    
      /**
       * The tail (youngest) of the doubly linked list.
       */
      transient LinkedHashMap.Entry<K,V> tail;
    
      /**
       * The iteration ordering method for this linked hash map: <tt>true</tt>
       * for access-order, <tt>false</tt> for insertion-order.
       *
       * @serial
       */
      final boolean accessOrder;
  ```

- HashMap中预留了三个方法让LinkedHashMap来重写

  ```java
  
      // Callbacks to allow LinkedHashMap post-actions
      void afterNodeAccess(Node<K,V> p) { }
      void afterNodeInsertion(boolean evict) { }
      void afterNodeRemoval(Node<K,V> p) { }
  ```

- removeEldest默认返回false,即不会删除最老的节点。

  ```
  void afterNodeInsertion(boolean evict) { // possibly remove eldest
          LinkedHashMap.Entry<K,V> first;
          if (evict && (first = head) != null && removeEldestEntry(first)) {
              K key = first.key;
              removeNode(hash(key), key, null, false, true);
          }
      }
     
      protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
          return false;
      }
  ```

- 可以通过重写removeEldestEntry实现LRUCache(com.mysql.jdbc.util)

  ```java
  package com.mysql.jdbc.util;
  
  import java.util.LinkedHashMap;
  import java.util.Map.Entry;
  
  public class LRUCache extends LinkedHashMap<Object, Object> {
      private static final long serialVersionUID = 1L;
      protected int maxElements;
  
      public LRUCache(int maxSize) {
          super(maxSize, 0.75F, true);
          this.maxElements = maxSize;
      }
  
      /*
       * (non-Javadoc)
       * 
       * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
       */
      @Override
      protected boolean removeEldestEntry(Entry<Object, Object> eldest) {
          return (size() > this.maxElements);
      }
  }
  ```

- 重写了containsValue方法，但没有重写containsKey方法

# TreeMap



