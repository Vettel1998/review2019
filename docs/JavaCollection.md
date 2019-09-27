# Java Collection Framework

- 集合框架是用于表示和操作集合的统一体系结构，使它们可以独立于其表示的细节进行操作。 它减少了编程工作，同时提高了性能。 它实现了不相关的API之间的互操作性，减少了设计和学习新API的工作量，并促进了软件重用。 该框架基于十几个集合接口。 它包括这些接口的实现和用于操纵它们的算法。

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

# Stack

- Vector的子类
- search(Object o)  从栈顶往下依次查找是否有相等的元素,返回的是从1开始计数的位置值 

# HashSet

# LinkedHashSet

# TreeSet



