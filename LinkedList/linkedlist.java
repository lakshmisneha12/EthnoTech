import java.util.*;
class linkedlist{
    public static void main(String[] args){
    LinkedList<String> list=new LinkedList<String>();
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<5;i++)
    {
        list.add(sc.next());
    }
    for(String str:list)
    {
    System.out.print(str+" ");
    }

}
}


