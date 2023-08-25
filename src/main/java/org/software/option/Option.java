package org.software.option;

import java.util.Scanner;

public class Option {
            int option;
            public int option(){

                System.err.println("PLEASE CLICK THE ANY OPTION:: ");
                System.err.println("INSERT DATA CLICK:: 1 :: ");
                System.err.println("SELECT ALL DATA CLICK:: 2 :: ");
                System.err.println("UPDATE DATA CLICK :: 3 :: ");
                System.err.println("DELETE DATA CLICK :: 4 ::");
                System.err.println("ENTER CLASS NAME AND CHECK TOTAL BOY AND GIRLS :: 5 ::");
                System.err.println("ENTER CLASS ROOM NUMBER AND CHECK TOTAL STUDENT :: 6 ::");
                System.err.println("FIND THE MAX AND MIN STUDENT WHICH CLASS :: 7 ::");
                System.err.println("YOU WANT TO EXIT CLICK :: 8 ::");
                System.out.print("Click Now:: ");
                try{
                    Scanner sc = new Scanner(System.in);
                    option = sc.nextInt();
                }catch(Exception e){
                    System.err.println("Exception Occur in the Option class option method::"+e);
                }
                return option;
            }
}
