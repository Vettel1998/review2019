package Heap;




import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode973
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 */
public class Leetcode973 {

    public static int[][] kClosest(int[][] points, int K) {
        //TODO
        PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<>(K, Comparator.comparingInt(p -> getDistance(p)));
        int[][] res = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            Pair<Integer,Integer> pair = new Pair<>(points[i][0],points[i][1]);
            maxHeap.add(pair);
        }
        for (int i = 0; i < K; i++) {
            Pair<Integer,Integer> pair = maxHeap.poll();
            res[i][0] = pair.getKey();
            res[i][1] = pair.getValue();
        }
        return res;
    }

    private static Integer getDistance(Pair<Integer,Integer> p ){
        if (p==null) return 0;
        return p.getKey()*p.getKey()+p.getKey()*p.getValue();
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{2,2}};
        int K = 1;
        kClosest(points,1);
    }

}
