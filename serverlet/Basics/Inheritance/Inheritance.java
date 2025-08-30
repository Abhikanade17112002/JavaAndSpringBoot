package  Inheritance;


class Student{
    int age ;
    String name ;
    int rollNo ;
    public Student(int age, String name, int rollNo) {
        this.age = age;
        this.name = name;
        this.rollNo = rollNo;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    
    public void getInfo(){
        System.out.println("This is "+this.name+" "+this.age+" "+this.rollNo);
    }
    
}
public class Inheritance{
    public static void main( String[] args){

        Student Abhishek = new Student(22, "Abhishek Rangnath Kanade", 48) ;
        Abhishek.getInfo();

    }
}

