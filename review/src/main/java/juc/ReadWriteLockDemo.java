package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycache{
    private volatile Map<String,Object> map = new HashMap<>();
    private Lock lock = (Lock) new ReentrantReadWriteLock();
}
/**
 * @author vettelx
 *
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {

    }
}
