package com.enseitankado;

public class Main {

    static Datasource datasource = new Datasource();

    public static void main(String[] args) {


        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        UserInterface userInterface = new UserInterface();
        userInterface.performAction(datasource);



    }


}

