### 53个关键字



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



