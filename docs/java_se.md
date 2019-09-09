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



### JVM内存区域划分

### Java内存模型JMM





### Guava



### Curator



### CAS  compare and swap



### 异步与同步



### Executor



