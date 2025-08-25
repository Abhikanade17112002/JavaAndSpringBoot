class MultiThreading{
    public static void main(String[]args ) throws InterruptedException{
        Counter counter = new Counter() ;

        IncrementalThread t1 = new IncrementalThread(counter) ;
        IncrementalThread t2 = new IncrementalThread(counter) ;


        t1.start();
        t2.start();
  
        t1.join();
        t2.join();
        System.out.println("Final Value "+ counter.getCount());


    }
}