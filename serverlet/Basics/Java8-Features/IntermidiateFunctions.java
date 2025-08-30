
import java.util.List;
import java.util.stream.Collectors;

public class IntermidiateFunctions {

    public static void main( String [] args ){
         
         List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

         List<Integer> sortedList = numbers.stream()
                                    .sorted()
                                    .collect(Collectors.toList());

        System.out.println("The Sorted Order Od List Is");
        for (Integer num : sortedList) {

            System.out.printf("%d ",num) ;
            
        }




        List<Integer> distinctList = numbers.stream()
                                    .distinct()
                                    .collect(Collectors.toList());

        System.out.println("The Distinct List Of List Is");
        for (Integer num : distinctList) {

            System.out.printf("%d ",num) ;
            
        }


          List<Integer> MappedList = numbers.stream()
                                    .map((num)->( num*10) + 1)
                                    .collect(Collectors.toList());

        System.out.println("The Mapped List  Is");
        for (Integer num : MappedList) {

            System.out.printf("%d ",num) ;
            
        }
         


    }
    
}
