package algorithm;




public class Multiply {

    //两个数相乘
    public static String multiply(int[] a,int[] b){
        StringBuilder as = new StringBuilder();
        StringBuilder bs = new StringBuilder();
        for (int num:a){
            as.append(num);
        }
        for (int num:b){
            bs.append(num);
        }

        String strA = as.reverse().toString();
        String strB = bs.reverse().toString();

        int[] res = new int[strA.length()*strB.length()*2];

        for (int i = 0; i < strB.length(); i++) {
            for (int j = 0; j < strA.length(); j++) {
                res[i+j]+=(strA.charAt(j)-'0')*(strB.charAt(i)-'0');
            }

        }
        for (int i = 0; i <res.length-1; i++) {
            int tmp = res[i];
            res[i] = tmp%10;
            res[i+1]+= tmp/10;
        }

        StringBuilder sb =new StringBuilder();
        for (int num:res)
            sb.append(num);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,5};
        int[] b = {7,8,9,1};
        //multiply(a,b);
        System.out.println(multiply(a,b));
    }

}
