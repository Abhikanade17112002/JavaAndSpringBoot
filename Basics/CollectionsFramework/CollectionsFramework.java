
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


class CollectionsFramework{


    public static void mapImplementation(){
        Map<String,Integer> map = new HashMap<>() ;

        map.put("Apple", 10);
        map.put("Watermelon", 15);
        map.put("Orange", 3);
        map.put("Guva", 5);
        map.put("Lemon", 17);

        if( map.containsKey("Apple")){
            System.out.println("The Apple Key Is Present");
        }

        System.out.println("Remnoving watermelone "+ map.remove("Watermelon"));

        System.out.println("Getting Value Of Lemone  "+map.get("Lemon"));

        System.out.println("Getting The Size "+map.size());

        System.out.println("Printing The Key Values Pair");
        for (Object key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }
    public static void implementArrayList(){
        List <String> myList = new ArrayList<>() ;

        myList.add("Abhishek");
        myList.add("Rangnath");
        myList.add("Kanade");

        if( myList.contains("Abhishek") ){
            System.out.println("Abhishek IS Present");
        }

        myList.remove(0);
        myList.remove("Kanade");
        myList.add(0,"Abhishek") ;
        myList.add("Kanade");


        for( int i = 0 ; i < myList.size() ; i++ ){

            System.out.println(myList.get(i));
        }
    }


    public static void implementQueue( ){
        Queue<String> myQ = new LinkedList<>() ;

        myQ.add("Abhishek");
        myQ.offer("Rangnath");
        myQ.offer("Kanade") ;



        System.out.println(myQ.element());
        System.out.println(myQ.peek());


        while (!myQ.isEmpty()) {
            
            System.out.println(myQ.remove());
            
        }
    }
    public static void main( String [] args ){
        
        // implementArrayList();

        // implementQueue();
        mapImplementation();
    }
}