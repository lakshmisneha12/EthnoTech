     // factorial without Recursion
/*import java.util.*;
class factorial{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        for(int i=n;i>=1;i--)
        {
            fact*=i;
        }
        System.out.println(fact);
    }
}*/


//factorial using Recursion
public class factorial {
   public static int factorial(int n) {
       if (n == 0 || n == 1) { 
           return 1;
       }
       return n * factorial(n - 1); 
   }
   public static void main(String[] args) {
       int number = 6; 
       int result = factorial(number);
       System.out.println("Factorial of " + number + " is: " + result);
   }
}