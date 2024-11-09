package monoCept;

public class Test {
static int total = 10;
int I[] = {0};
         public static void main(String args[]){
                 StringBuffer sb1 = new StringBuffer("Amit");
StringBuffer sb2 = new StringBuffer("Amit");
String ss1 = "Amit";
System.out.println(sb1==sb2);
System.out.println(sb1.equals(sb2));
System.out.println(sb1.equals(ss1));
System.out.println("Poddar".substring(3)); 
   } 
   public static void change_i(int i[]) {
        int j[] ={2};
        i=j; 
   }

public Test ( ){
System.out.println("In test");
System.out.println(this);
int temp = this. total;
if (temp > 5) {
System.out.println( temp);
}
}
}