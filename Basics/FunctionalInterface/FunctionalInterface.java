interface A {
    public abstract void show() ;
}


class FunctionalInterface{
    public static void main(String[] args) {
        A obj = new A(){
           public void show(){
            System.out.println("IN The Anonymous Show ");
           }
        };

        obj.show(); 
     
    }
}