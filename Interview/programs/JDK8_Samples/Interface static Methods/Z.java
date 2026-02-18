package demo;

interface X
{
   static void foo()
   {
      System.out.println("foo");
   }
}

class Y implements X
{
}

public class Z 
{
   public static void main(String[] args)
   {
      X.foo();
      // Y.foo(); // won't compile
   }
}