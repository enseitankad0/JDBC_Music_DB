package com.enseitankado;

import java.util.Scanner;

public class ScannerInput {

    Scanner scanner = new Scanner(System.in);

    public int getInputInt() {
        int action = scanner.nextInt();
        scanner.nextLine();
        return action;
    }

    public String getInputString() {
        String action = scanner.next();
        scanner.nextLine();
        return action;
    }


}
