import java.util.List;
import java.util.Scanner ;

class LambdaFunctions{
    
    public static void ImpplementingLambda(){

        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter First Number => ");
        int first = sc.nextInt();
        System.out.println("Enter Second Number => ");
        int second = sc.nextInt() ;
        
        List<Integer> myList = List.of(first,second) ;
        
        int Sum = myList.stream()
                  .reduce(1, (x,y)->x*y) ;
                  
                  
        System.out.println("THe Product Is :: "+ Sum);          

    }


    public static void printStream(){

        List<String> myLIst = List.of("Orange" , "Mango" , "Bannana" , "Apple") ;

        myLIst.stream()
        .forEach((fruit)->System.out.println(fruit));
    }
    public static void filterOddAndAdd(){
        List<Integer> myList = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        int oddSum = myList.stream()
                     .filter((num)-> num%2==1)
                     .reduce(0, (x,y)->x+y) ;

        System.out.println("The Odd Sum IS => "+oddSum);
    }
    public static void main( String [] args ){

    //   ImpplementingLambda();
    // printStream();

    filterOddAndAdd();


    }
}