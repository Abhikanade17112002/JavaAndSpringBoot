
import java.util.concurrent.Callable;



class CallableTask implements Callable<String>{

    private final String name ;

    public CallableTask(String name ){
        this.name = name ;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Fetching Full Name From The Server ==> "+this.name);
        Thread.sleep(3000);
        System.out.println("Fetch Succesfull ...");
        return this.name + "Last Name";
    }


    
    
}
