
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static void main( String [] args ){

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,0,10) ;

        Optional<Integer> maxNum = numbers.stream()
                                  .max(Integer::compareTo);
        System.out.println("THe Maximum Nunber Is. :: => ");
        maxNum.ifPresent(System.out::println);



        Optional<Integer> minNum = numbers.stream()
                                  .min(Integer::compareTo);
        System.out.println("THe Minimum Number Is. :: => ");
        minNum.ifPresent(System.out::println);

        List<Integer> oddNumbers = numbers.stream()
                                       .filter((num)->num%2==1)
                                       .collect(Collectors.toList());
        System.out.println("The List Of The Odd Integers Is ");
        oddNumbers.forEach((num)->System.out.println(num));
    }
    
}
