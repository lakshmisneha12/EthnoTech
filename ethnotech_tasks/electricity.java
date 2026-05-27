// electricity bill using bitwise operator
import java.util.*;
public class electricity{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int units=sc.nextInt();
int bill=0;
if((units>0)&(units<=250))
{
bill=0;
}
else if((units>=250)&(units<=300))
{
bill=50;
}
else if(units>1000)
{
bill=500;
}
else
{
bill=200;
}
System.out.println("Bill:"+bill);
}
}