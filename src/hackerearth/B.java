package hackerearth;

 class A
{
    private int a;
    protected A(int a)
    {
        this.a = a;
    }
}
public class B extends A
{
    public B(int a)
    {
        super(a);
    }
    public B()
    {super(5);
       // this.a = 5;//Line1
}
}