import java.nio.channels.Pipe;

class Calculator{
    static double PI = 3.14;
    int left,right;
    public Calculator(int left,int right){
        this.left = left;
        this.right = right;
    }
    static public void sum(){
        System.out.println("a");
    }
    public void avg(){
        System.out.println((this.left + this.right)/2);
    }
    public static void sum1(int a,int b){
        System.out.println(a+b);
    }
    
}

public class java{
    public static void main (String[] args){
        Calculator c1 = new Calculator(10,20);
        System.out.println(Calculator.PI);
        c1.sum();
        Calculator.sum();

    }
}