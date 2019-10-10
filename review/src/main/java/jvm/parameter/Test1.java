package jvm.parameter;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
      /*  System.out.println("----Hello----------");
        Thread.sleep(Integer.MAX_VALUE);*/
      long totalMemeory = Runtime.getRuntime().totalMemory();
      long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(totalMemeory/(1024.0*1024));
        System.out.println(maxMemory/(1024.0*1024));
    }
}
