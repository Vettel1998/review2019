### 三元运算

- boolean表达式 ？ 表达式1 ：表达式２；

- ```java
  int x=4;
  System.out.println(“value is “+((x>4)?99.9:9));　　　　　　　　
  //value is 9.0
  ```

### byte

- ```java
  byte b1=1,b2=2,b3,b6;
  final byte b4=4,b5=6;
  b6=b4+b5;
  b3=(b1+b2);
  System.out.println(b3+b6);                   
  //b3=b1+b2  编译出错
  ```



### 运算优先级

- 1>4+2



### &&  ||

- 

### JVM  重载实现

- 方法签名

- 重载方法的匹配策略

  ```java
  sum(1,2);     //调用错误
  //public static int sum(int a.int b){return a+b}
  //public static double sum(double a,double b){return a+b}
  public static double sum(int a,double b){return a+b}
  public static double sum(double a,int b){return a+b} 
  ```



### 构造方法

- 如果一个类定义了任意形式的构造方法JVM就不会再创建无参构造方法

- #### 构造方法之间的调用必须在方法的第一行



### String.split

```
关于点的问题是用 : String.split("[.]");   String..split("\\.") ;
关于竖线的问题用 : String.split("\\|");
关于星号的问题用 : String.split("\\*");
关于斜线的问题用 : Sring.split("\\\\");
关于中括号的问题用 sring.split("\\[\\]");
```



### 重写原则

- 方法签名一致

- 如果父类的方法的返回类型是基本数据类型或者void,那么子类的方法返回值要和父类一致

- 如果父类的方法返回值类型是引用数据类型，那么子类的方法返回值类型要么是父类返回值类型的子类要么相等

- 子类的方法的访问权限修饰符要么和父类一致要么比父类的范围更大

- ### 父类的私有化信息(属性和方法)、构造方法以及构造代码块



### 访问权限修饰符

#### protected

- 如果父子类是其他类关系，父类含有protected信息，要保证子类的对象只能在本类中访问

- object.clone() 是 protected 方法

- #### 在不同包的子类中创建了父类对象，通过父类对象去调用protected方法　　会报错

- #### 正确的访问方式： 

     1. super.method() //protected 
  2. 创建子类对象instance,通过instance.method()访问

### Super

- 关键字－－代表父类对象（在子类中可以调用父类属性和方法）

### Super语句

- 所有子类的构造方法都会默认添加一个无参super语句用于调用父类无参构造方法
- 通过super语句在子类的构造方法中可以调用父类任意形式的构造方法
- 如果父类没有提供无参构造，子类需要通过super语句去调用父类其他形式的构造方法
- 要在首行(this和super语句不能同时手写出现)



### 静态变量与静态变量

- 可以直接通过类也可以通过对象访问

- 静态变量不可以定义在构造方法中　Modifier 'static ' not allowed here

- 静态方法也不可以定义静态变量

- 静态方法不可以使用this

- #### 静态方法可以继承没有重写

  - #### 父子相同签名方法要么都为静态方法要么都是非静态方法

  - Thinking in java: 只有普通的方法调用才是多态的
  - 重写是运行时多态的体现形式

- #### 非静态代码块、方法直接可以调用静态的代码块、属性、方法



### 静态代码块、构造代码块

- 静态代码块可以对静态属性进行初始化，只加载一次

- static修饰的所有信息都只加载一次

- #### static代码块和static属性的赋值的执行顺序与位置先后有关

  ```java
  static {
          a =1;
      }
  
      static int a =10;
  ```

- #### 构造代码块和成员变量的初始化和代码位置有关(**只能赋值**)  构造方法总是最后执行

  ```java
  
      {
          i=2;
      }
  
      int i =1;
  //代码从上往下执行，检测到了一个变量i但是没有这个i的定义，先把这个i标记成成员变量，这个标记就不能进行除赋值外的的任何操作，接着往下查找有没有和i同名的变量定义
  
  {
          i+=2;　　　　　　　//Illegal forward reference
      }
  
     int i = 1;
  ```

- #### 父类static --> 子类static -->  父类初始化 -->　子类初始化

- ```java
  public class STDemo {
      public static void main(String[] args) {
          System.out.println(Test1.x+","+Test1.y);
          
          // 1,1
          
          // 加载 -> new Test1()执行构造方法 -> x=1 -> y  
      }
  }
  
  
  
  class Test1{
      static Test1 t = new Test1();
      static int x = 1;
      static int y;
      public Test1(){
          x++;
          y++;
      }
  }
  
  ```
  
- ```java
  public class STDemo {
      public static void main(String[] args) {
          System.out.println(new.Test1().x+","+new.Test1().y);
          
          
      }
  }
  
  
  
  class Test1{
      Test1 t = new Test1();
      static int x = 1;
      static int y;
      public Test1(){
          x++;
          y++;
      }
  }
  
  ```

  



### final

- 自定义常量、字面值常量

- 字面量(直接量)

- ```java
  final int[] arr = {1,2,3,4};
  arr[0] = 5;
  
  //不能改变的是arr的地址值
  ```

- #### final方法　不能重写可以重载

- #### final类　　不能被继承



### abstarct

- 抽象方法不可以被private/static/final分别修饰
- 抽象类不可以被final修饰



### 接口和抽象类的区别

- jdk1.8中接口的改变？？？？
- 接口中的变量默认　static final　　　方法默认修饰符为public abstract
- 抽象类中可以有实体方法
- 抽象类是为了继承，接口主要是为了注入特性



### class只能被public 和默认修饰

### 内部类

#### 方法内部类

- 只能定义非静态的属性和方法

- 可以继承和实现接口

- 没有访问权限修饰符但是可以被abstract 和　final分别修饰

- 方法内部类可以获取外部类所有的属性和方法

- 方法内部类只能拿到当前方法的常量

- #### 隐式常量？？？

- 只能在本方法中创建内部类的对象

#### 成员内部类

- 可以定义所有非静态的属性和方法以及静态常量

- 可以被四种访问权限修饰符和final,abstract 修饰

- 可以获取内部类的的所有属性和方法

- ```java
  Outer2.inner2 in2 = new Outer2().new inner();
  ```

#### 静态内部类

- 可以定义所有的属性和方法以及静态常量
- 可以继承和实现

#### 匿名内部类

- 匿名内部类继承类/实现接口并进行重写

- 普通类/抽象类/接口
- 匿名内部类出现的位置在方法内就和方法内部类使用一样，在成员位置就按成员内部类使用



### 接口中的内部类

### PrintStream

- ```java
  char[] ch ={'a','b','c'};
  System.out.println(ch);
  System.out.println("ch"+ch);
  ```

  

### Object类

- **protected** Object clone()
  - CloneNotSupportedException
  - Clonable 接口
  - clone的实现
  
- **protected** void finalize()

- public **final** Class<?> getClass()

- public int hashCode()

  - Java hashcode算法
  - 哈希码值来表示内存地址

- ```java
  public String toString() {    
  return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
  ```

- public boolean equals(Object obj)

  - ```java
    //String类重写的equals
    public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof String) {
                String anotherString = (String)anObject;
                int n = value.length;
                if (n == anotherString.value.length) {
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) {
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }
    ```

  - **IDEA  提供的equals重写的逻辑**
  
  - ##### 为什么需要同时重写equals()和hashcode()

### Objects类

- java.util.Objects类     （effective java）

- Object.equals(Object a,Object b)

  ```java
  public static boolean equals(Object a, Object b) {
          return (a == b) || (a != null && a.equals(b));
      }
  ```

- Objects.hashcode(Object... values)



### String

- ```java
  public final class String
  extends Object
  implements Serializable, Comparable<String>, CharSequence
  ```

- 所有的字符串直接量都是String的实例

- 如果在常量池中已经定义了字符串直接量，后续的

- ```java
  String str = "ab";
  str = str + "c";  //new StringBuilder("ab").apend("c").toString()    
  // 5个对象
  ```

- ```java
  String ss = "123456";
  		
  System.out.println("ss = " + ss);
  		
  ss.replace('1', '0');
  		
  System.out.println("ss = " + ss);
  ```

- ```java
  public int compareTo(String anotherString) {
          int len1 = value.length;
          int len2 = anotherString.value.length;
          int lim = Math.min(len1, len2);
          char v1[] = value;
          char v2[] = anotherString.value;
  
          int k = 0;
          while (k < lim) {
              char c1 = v1[k];
              char c2 = v2[k];
              if (c1 != c2) {
                  return c1 - c2;
              }
              k++;
          }
          return len1 - len2;
      }
  ```

- ```java
  /**
       * Concatenates the specified string to the end of this string.
       * <p>
       * If the length of the argument string is {@code 0}, then this
       * {@code String} object is returned. Otherwise, a
       * {@code String} object is returned that represents a character
       * sequence that is the concatenation of the character sequence
       * represented by this {@code String} object and the character
       * sequence represented by the argument string.<p>
       * Examples:
       * <blockquote><pre>
       * "cares".concat("s") returns "caress"
       * "to".concat("get").concat("her") returns "together"
       * </pre></blockquote>
       *
       * @param   str   the {@code String} that is concatenated to the end
       *                of this {@code String}.
       * @return  a string that represents the concatenation of this object's
       *          characters followed by the string argument's characters.
       */
      public String concat(String str) {
          int otherLen = str.length();
          if (otherLen == 0) {
              return this;
          }
          int len = value.length;
          char buf[] = Arrays.copyOf(value, len + otherLen);
          str.getChars(buf, len);
          return new String(buf, true);
      }
  
  ```

- ##### indexOf(String)

  - 子串第一个字符在原串第一次出现的下标

- ##### getBytes()

- ##### intern()

  - 把指向堆内存的指针转向方法区的常量池中
  
- ##### matches(String regex)

  - Pattern 

- ##### replace   replaceAll

- ##### split

  - 切割符在末尾就随着切掉

  - ```java
    String s1 = "x1dh78dh89";
    String[] strings = s1.split("\\d");
    System.out.println(Arrays.toString(strings));  
    ```

- ##### substring

- ##### trim

### 编码

- 把文字转换成数字的过程，转换的规则就是码表
- **所有的完整码表默认兼容西欧码表(ISO8859-1)**
- GBK  
  - char c= '中' 用GBK编码，占用底层两个字节
  - char c ='a' 用GBK编码，占用底层一个字节
- Unicode编码体系
  - UTF-8  三个字节　.java文件用的
  - UTF-16 2个字节　Java 以 UTF-16 作为内存的字符存储格式
  - 平台码



### 包装类

- **自动装箱/拆箱**　jdk1.5新特性　

- ```java
  Integer i = 1;   
  Integer integer = Integer.valueOf(1);
  int i1 = integer;
  int i1 = integer.intValue();
  ```

- Integer.valueOf(int i)

  ```java
   /**
       * Returns an {@code Integer} instance representing the specified
       * {@code int} value.  If a new {@code Integer} instance is not
       * required, this method should generally be used in preference to
       * the constructor {@link #Integer(int)}, as this method is likely
       * to yield significantly better space and time performance by
       * caching frequently requested values.
       *
       * This method will always cache values in the range -128 to 127,
       * inclusive, and may cache other values outside of this range.
       *
       * @param  i an {@code int} value.
       * @return an {@code Integer} instance representing {@code i}.
       * @since  1.5
       */
      public static Integer valueOf(int i) {
          if (i >= IntegerCache.low && i <= IntegerCache.high)
              return IntegerCache.cache[i + (-IntegerCache.low)];
          return new Integer(i);
      }
  ```

- ```java
  Double d = 3;  //报错
  public static Double valueOf(String s) throws NumberFormatException {
          return new Double(parseDouble(s));
  }
      public static Double valueOf(double d) {
          return new Double(d);
  }
  　
  ```

- #### Byte   (cache  -128-127 )

  - ```java
     /**
         * Returns a {@code Byte} instance representing the specified
         * {@code byte} value.
         * If a new {@code Byte} instance is not required, this method
         * should generally be used in preference to the constructor
         * {@link #Byte(byte)}, as this method is likely to yield
         * significantly better space and time performance since
         * all byte values are cached.
         *
         * @param  b a byte value.
         * @return a {@code Byte} instance representing {@code b}.
         * @since  1.5
         */
        public static Byte valueOf(byte b) {
            final int offset = 128;
            return ByteCache.cache[(int)b + offset];
        }
    
    ```

- #### Short (cache -128-127)

- #### Long  (cache -128-127)

- #### Character (cache 0-127)

- #### Double 和 Float 没有 



### (Double.NaN == Double.NaN)  == false

### 直接量

- 数值直接量、字符直接量、布尔直接量、字符串直接量、空直接量
- 等式右边参与计算的全是直接量的时候，先运算后赋值
  - byte  b = 128 - 1;
  - String s = "a"+"b";

### StringBuilder

- \+ 和 StringBuilder的效率

  ```
  String s = "";
  for(int i =0;i<10000;i++)
  	s+="a";
  
  StringBuilder sb = new StringBuilder();
  for(int i =0;i<10000;i++)
  	s.append("a");	
  
  ```

  

















### JVM内存区域划分

#### jdk1.7/1.8 区别

#### 方法区

- 对于静态变量的理解
- 静态常量池
- 静态区

#### 类的加载







### Java内存模型JMM





### Guava



### Curator



### CAS  compare and swap



### 异步与同步



### Executor



