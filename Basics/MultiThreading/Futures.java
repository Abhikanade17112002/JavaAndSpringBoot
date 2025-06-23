
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CallableTask task1 = new CallableTask("Abhishek");
        CallableTask task2 = new CallableTask("Rangnath");
        CallableTask task3 = new CallableTask("Suman");
        CallableTask task4 = new CallableTask("Dipti");

        Future<String> name1 = service.submit(task1);
        Future<String> name2 = service.submit(task2);
        Future<String> name3 = service.submit(task3);
        Future<String> name4 = service.submit(task4);

        System.out.println(name1.get());
        System.out.println(name2.get());
        System.out.println(name3.get());
        System.out.println(name4.get());

        service.shutdown();
    }
    

}
