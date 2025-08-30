enum Day{
 MONDAY("YES") ,
    TUESDAY("YES") ,
    WEDNESDAY("YES") ,
    THURDAY("YES") ,
    FRIDAY("YES") ,
    SATURDAY("NO") ,
    SUNDAY("NO") ;
    private final String weekDayOrNot ;

    public String  getDay(){
        return this.weekDayOrNot ;
    }

    private Day(String weekDayOrNot){
        this.weekDayOrNot = weekDayOrNot ;
    }
    
}
public class DayEnum {

    public static void main(String [] args ){

       Day d = Day.MONDAY ;


       for( Day day : d.values()){
        System.out.println(day+" "+day.getDay());
       }

    }
    
}
