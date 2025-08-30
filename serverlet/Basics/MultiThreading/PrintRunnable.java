
class PrintRunnable implements Runnable {

    private final char targetCharacter ;

    public PrintRunnable( char targetCharacter ){
        this.targetCharacter = targetCharacter ;
    }

    @Override
    public void run() {
        System.out.println("Starting The Execution With Thread :: "+ Thread.currentThread().getName());
        
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
            System.out.print(" "+this.targetCharacter +" ");
            
        }
        System.out.println("Ending The Execution With Thread :: "+ Thread.currentThread().getName());

    }

    

}