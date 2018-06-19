package com.enseitankado;



public class UserInterface {


    public void performAction(Datasource datasource) {

        boolean quit = false;
        ScannerInput scannerInput = new ScannerInput();


        while (!quit) {

            printMenu();
            int action = scannerInput.getInputInt();

            switch (action) {

                case 0:
                    quit=true;
                    break;
                case 1:
                    System.out.println("Choose : 1");


                    System.out.println("Please type artist name ");
                    String artistToQuery = scannerInput.getInputString();
                    datasource.queryEverything(artistToQuery);
                    quit = false;
                    break;

                case 2:
                    System.out.println("Choose : 2");
                    System.out.println("Please type song title");
                    String songToCheck = scannerInput.getInputString();

                    datasource.findAristForSong(songToCheck);
                    break;




            }

        }

    }

    public void printMenu() {

        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - To find all songs for specified artist\n" +
                "2 - To find artists for a specified song\n");

    }


}
