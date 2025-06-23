import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ExecutorServiceDemo {
    public static void main( String [] args ) throws InterruptedException{
    ExecutorService service = Executors.newFixedThreadPool(1) ;
    PrintRunnable task1 = new PrintRunnable('#');
    PrintRunnable task2 = new PrintRunnable('@');
    PrintRunnable task3 = new PrintRunnable('!');

    service.submit(task1);
    service.submit(task2);
    service.submit(task3);
    


    service.shutdown();


    if( !service.awaitTermination(2, TimeUnit.SECONDS)){
        System.out.println("Force Full");
        service.shutdownNow();
    }


    }
}