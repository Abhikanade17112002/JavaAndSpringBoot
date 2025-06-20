
enum Status{
    RUNNING(400) ,
    PENDING(300) ,
    FAILED(500) ,;


    private int status ;

    private Status( int status ){
        this.status = status ;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
public class Enums {
    public static void main( String [] args ){
        //  Enums Are The Named Constants 

        Status a = Status.RUNNING ;
        Status b = Status.PENDING ;
        Status c = Status.FAILED ;
    
        System.out.println(a + " "+ b + " "+  c + " " );
        Status s = Status.RUNNING ;
        

        
        switch ( s ) {
            case RUNNING : System.out.println("Running");
                break;
            case PENDING : System.out.println("Pending");
                break;
            case FAILED : System.out.println("Failed");
                break;        
            default:
                throw new AssertionError();
        }

        // for (Status ss : s) {

        //     System.out.println(ss +" "+ss.ordinal());
        // }

    }
}