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

### Super

- 关键字－－代表父类对象（在子类中可以调用父类属性和方法）

### Super语句

- 所有子类的构造方法都会默认添加一个无参super语句用于调用父类无参构造方法
- 通过super语句在子类的构造方法中可以调用父类任意形式的构造方法
- 如果父类没有提供无参构造，子类需要通过super语句去调用父类其他形式的构造方法
- 要在首行(this和super语句不能同时手写出现)

### JVM内存区域划分

### Java内存模型JMM





### Guava



### Curator



### CAS  compare and swap



### 异步与同步



### Executor



