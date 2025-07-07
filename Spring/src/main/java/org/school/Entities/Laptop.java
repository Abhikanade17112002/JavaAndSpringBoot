package org.school.Entities;

public class Laptop  implements  Computer{

    @Override
    public void compile() {
        System.out.println("The Code Is Compiling Using A Laptop");
    }
}
