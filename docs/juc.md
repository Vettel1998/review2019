### Thread

- Thread.activeCount()
- Thread.yield()

### JMM

- Java内存模型

### volatile

  - jvm提供的轻量级同步机制
  - 可见性
  - 不保证原子性
  - 禁止指令重排



### AtomicInteger

- Unsafe

- #### CAS   compare and swap  

  - CPU并发原语
  - unsafe.cpp  Atomic::cmpxchg(x,addr,e)
  
- CAS缺点

  - 循环时间长开销大

  - 只能保证一个共享变量的原子操作

  - #### ABA问题

### AtomicReference

- 原子引用

### AtomicStampedReference

- 时间戳原子引用



### 集合类不安全问题

#### ArrayList线程不安全

- java.util.ConcurrentModificationException

- 解决方法

  - ```java
  new Vector<>();   //jdk1.0  早于jdk1.2的ArrayList
    Collections.synchronizedList(new ArrayList<>());
    new CopyOnWriteArrayList<>();
    ```
  
- 写时复制  读写分离

  ```java
  // CopyOnWriteArraylist 
  public boolean add(E e) {
          final ReentrantLock lock = this.lock;
          lock.lock();
          try {
              Object[] elements = getArray();
              int len = elements.length;
              Object[] newElements = Arrays.copyOf(elements, len + 1);
              newElements[len] = e;
              setArray(newElements);
              return true;
          } finally {
              lock.unlock();
          }
      }
  ```



### HashSet

- 线程不安全

- CopyOnWriteSet

  ```java
   private final CopyOnWriteArrayList<E> al;
  ```

  

- Collections.synchronizedSet

- 底层是HashMap

  ```java
  private transient HashMap<E,Object> map;
  private static final Object PRESENT = new Object(); 
  public boolean add(E e) {
          return map.put(e, PRESENT)==null;
      }
  ```

### HashMap

- ConcurrentHashMap



### 公平锁、非公平锁

- 公平锁是指多个线程按照申请锁的顺序来获取锁

- 非公平锁是指多个线程获取锁的顺序并不是按照申请锁的顺序，有可能会造成优先级反转或饥饿现象、

- ```java
  
      public ReentrantLock() {
          sync = new NonfairSync();
      }
  
     
      public ReentrantLock(boolean fair) {
          sync = fair ? new FairSync() : new NonfairSync();
      }
  ```

- 非公平锁的优点在于吞吐量大

- Synchronized也是一种非公平锁

### 可重入锁/递归锁

- 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
-  上锁解锁次数要想等

### 自旋锁spinlock

- 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式尝试去获取锁，这样的好处是减少线程上下文切换的消耗，缺点是会消耗CPU

### 独占锁(写锁) /共享锁(读锁)

- #### ReentrantReadWriteLock



///

## 单例模式

- #### 懒汉式单例

- Double Check Lock 不一定线程安全，因为存在指令重排序的存在，读取到的instane不为null时，instance的引用对象可能没有完成初始化

- ```
  instance = new SingletonDemo();可以分为以下三步
  memory = allocate();  //1.分配对象内存空间
  instance(memory);     //2.初始化对象
  instance = memory;    //3.设置instance指向刚分配的内存地址，此时instance ！=null;
  ```

- 步骤2和步骤3不存在数据依赖关系，无论重排前还是重排后程序的执行结果在单线程中并没有改变，因此这种重排优化是允许的

- 加volatile

- #### 静态内部类

  ```java
  public class Singleton {    
      private static class LazyHolder {    
         private static final Singleton INSTANCE = new Singleton();    
      }    
      private Singleton (){}    
      public static final Singleton getInstance() {    
         return LazyHolder.INSTANCE;    
      }    
  } 
  ```

  

- #### 饿汉式单例

  - ```java
    public class Singleton1 {  
        private Singleton1() {}  
        private static final Singleton1 single = new Singleton1();  
        //静态工厂方法   
        public static Singleton1 getInstance() {  
            return single;  
        }  
    }
    ```

    