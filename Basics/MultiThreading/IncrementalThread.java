class IncrementalThread extends Thread {

    private final Counter counter ;

    public IncrementalThread( Counter counter){
        this.counter = counter ;
    }

    @Override
    public void run(){

        System.out.println("Starting Execution");

        for (int i = 0; i < 1000; i++) {
            counter.incrementCount();
            
        }
        System.out.println("Finished Execution");

    }

    
}
