package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ManageSystem {
    public static void main(String[] args) {
        String dbuser = "root";
        String dbpass = "";


        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false &allowPublicKeyRetrieval=true&serverTimezone=UTC";

        Scanner scanner = new Scanner(System.in);

//
//        System.out.println("1.وارد کردن نمره دانش آموزان");
//        System.out.println("2.دیدن نمرات دانش آموزان مردودی");
//        System.out.println("3.دیدن نمرات دانش آموزان قبول شده");
//        System.out.println("4.دیدن تمام نمرات دانش آموزان");
//        int MenuInput = scanner.nextInt();


        String Username = scanner.nextLine();
        String Password = scanner.nextLine();
        String Realname = scanner.nextLine();


//        if (MenuInput == 1) {
//            InsertGrades insertgrades = new InsertGrades();
//            insertgrades.InsertSStudentGrades(url,dbuser,dbpass);
//        }
//        if (MenuInput == 2) {
//            ShowGrades showbadgrades = new ShowGrades();
//            showbadgrades.ShowBadGrades(url, dbuser, dbpass);
//        }
//        if (MenuInput == 3) {
//            ShowGrades showgoodgrades = new ShowGrades();
//            showgoodgrades.ShowGoodGrades(url, dbuser, dbpass);
//        }
//        if (MenuInput == 4) {
//            ShowGrades showallgrades = new ShowGrades();
//            showallgrades.ShowAllgrades(url, dbuser, dbpass);
//        }

        LogingForTeachers lft1 = new LogingForTeachers();
        lft1.SignUp(Username, Password, Realname, url, dbuser, dbpass);


    }
}