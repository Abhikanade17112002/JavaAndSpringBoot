import java.util.Scanner ;
class Exceptions{
    public static void main( String [] args ) {
        
        Scanner sc = new Scanner(System.in) ;

        System.out.println("Enter the divisor");
        int divisor = sc.nextInt() ;

        try {
            if( divisor ==  0){
                throw new ArithmeticException("Division By ZEro") ;
            }
            int result = (15/divisor) ;
            System.out.println("The Result Is :: " + result);
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}