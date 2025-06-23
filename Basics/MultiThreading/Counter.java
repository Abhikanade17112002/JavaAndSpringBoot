class Counter{
    private int count = 0 ;

    public synchronized  void incrementCount(){
        this.count++ ;
    }

    public int getCount(){
        return this.count ;
    }
}