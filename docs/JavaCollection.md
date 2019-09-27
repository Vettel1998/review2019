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

# Vector

