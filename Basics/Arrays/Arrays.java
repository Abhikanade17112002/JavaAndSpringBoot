package Arrays;

class Student{
   int age ;
   String name ;

   public void getInfo(){
       System.out.println(this.name + " " + this.age  );
   }
} ;
public class Arrays {

    public static void main(String[] args) {
        System.out.println("This IS A Single Dimension Array ::  ==> ");

        int numbers[] = new int[5] ;

        for( int i  = 0 ; i < numbers.length ; i++ ){

            numbers[i] = i + 1 ;
        }
        System.out.println("The Values Of Single Dimension Array Are :: ==> ");

        for (int i = 0; i < numbers.length ; i++) {

            System.out.print(numbers[i]+" ");
        }

        System.out.println();

        System.out.println("This IS A Multi Dimension Array ::  ==> ");

        int numbers2[][] = new int[3][4] ;

        for( int i  = 0 ; i < numbers2.length ; i++ ){

            for( int j = 0 ; j < numbers2[i].length ; j++ ){

                numbers2[i][j] = i + 1 + j ;


            }

        }
        System.out.println("The Values Of Multi Dimension Array Are :: ==> ");

        for (int i = 0; i < numbers2.length ; i++) {


            for( int j = 0 ; j < numbers2[i].length ; j++ ){
                System.out.println(numbers2[i][j]+" ");
            }

            System.out.println();
        }

        System.out.println();


        Student students[] = new Student[5] ;
        students[0].age = 1 ;
        students[0].name = "Abhishek" ;


        System.out.println("This Is The Object Array :: ==>");

        for( int i = 0 ; i < students.length ; i++ ){
            students[0].getInfo();
        }






    }

}
