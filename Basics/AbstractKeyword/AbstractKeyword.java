package AbstractKeyword ;

abstract class Car{
     
    public abstract void playMusic() ;

    public void startEngine(){

        System.out.println("Starting The Engine ....... Vrummmmm !");

    }

} ;


class WagonR extends Car{

    public void playMusic(){
        System.out.println("PLaying Music In WagonR");
    }

}


public class AbstractKeyword{
    public static void main( String [] args ){

        WagonR myCar = new WagonR() ;
        myCar.playMusic();
        myCar.startEngine(); 

    }
}


