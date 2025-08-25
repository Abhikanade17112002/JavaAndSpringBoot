// package InnerClass ;

class Outer{

    public int age ;
    
    public void myFunc(){
        
        System.out.println("In MyFunc");
    }

    class inner{

    }

    static class staticinner{

    }

}


public class InnerClass{
    public static void main( String [] args ){

        Outer obj1 = new Outer(){

            public void myFunc(){
                System.out.println("In My Anonomous Func");
            }
        } ;


        obj1.myFunc();

        // Outer.inner obj2 = obj1.new inner() ;
        // Outer.staticinner obj3 = new Outer.staticinner() ;
    }
}