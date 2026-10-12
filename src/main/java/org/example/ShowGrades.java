package org.example;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ShowGrades {

    private static final Logger logger = Logger.getLogger(ShowGrades.class.getName());


    public void ShowAllgrades(String url, String dbuser, String dbpass) {
        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {

            Statement stmt = conn.createStatement();
            String allGrades = "SELECT * FROM mew ";
            ResultSet rset = stmt.executeQuery(allGrades);
            String[] NameOfBook = {"دانش فنی", "ریاضی", "فیزیک", "شیمی", "تجارت", "شبکه"};
            while (rset.next()) {



                System.out.println("نام:" + rset.getString(1));
                System.out.println("نام خانوادگی:" + rset.getString(2));
                System.out.println("دانش فنی:" + rset.getString(3));
                System.out.println("ریاضی:" + rset.getString(4));
                System.out.println("فیزیک:" + rset.getString(5));
                System.out.println("شیمی:" + rset.getString(6));
                System.out.println("تجارت:" + rset.getString(7));
                System.out.println("شبکه:" + rset.getString(8));
                System.out.println("کد دانش آموزی:" + rset.getString(9));
                System.out.println("------دانش آموز بعدی------");
            }

        } catch (SQLException e) {
            System.out.println("نمیتواندید نمره دانش آموز را ببینید.");
            System.out.println("خطا به شرج زیر میباشد.");
            System.out.println(e.getMessage());
        }
        try {
            String LogPath = "H:ShowAllGradesMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath, true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);


            logger.info("this is a info messsage");
            logger.fine("this is a fine messsage");
        } catch (IOException e) {
            System.out.println("exeption message is : " + e.getMessage());
        }
    }

    public void ShowBadGrades(String url, String dbuser, String dbpass) {

        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {

            Statement stmt = conn.createStatement();
            String badGrades = "SELECT * FROM mew WHERE RiaziMark < 12 OR DaneshfaniMark < 12 OR FizikMark < 12 OR ShimiMark < 12 OR TejaratMark < 12 OR ShabakeMark < 12;";
            ResultSet rset = stmt.executeQuery(badGrades);
            while (rset.next()) {
                System.out.println("نام:" + rset.getString(1));
                System.out.println("نام خانوادگی:" + rset.getString(2));
                System.out.println("دانش فنی:" + rset.getString(3));
                System.out.println("ریاضی:" + rset.getString(4));
                System.out.println("فیزیک:" + rset.getString(5));
                System.out.println("شیمی:" + rset.getString(6));
                System.out.println("تجارت:" + rset.getString(7));
                System.out.println("شبکه:" + rset.getString(8));
                System.out.println("کد دانش آموزی:" + rset.getString(9));
                System.out.println("------دانش آموز بعدی------");
            }

        } catch (SQLException e) {
            System.out.println("نمیتواندید نمره دانش آموز را ببینید.");
            System.out.println("خطا به شرج زیر میباشد.");
            System.out.println(e.getMessage());
        }
        try {
            String LogPath = "H:ShowBadGradesMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath, true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);


            logger.info("this is a info messsage");
            logger.fine("this is a fine messsage");
        } catch (IOException e) {
            System.out.println("exeption message is : " + e.getMessage());
        }

    }

    public void ShowGoodGrades(String url, String dbuser, String dbpass) {
        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {

            Statement stmt = conn.createStatement();
            String goodGrades = "SELECT * FROM mew WHERE RiaziMark >= 12 OR DaneshfaniMark >= 12 OR FizikMark >= 12 OR ShimiMark >= 12 OR TejaratMark >= 12 OR ShabakeMark >= 12;";
            ResultSet rset = stmt.executeQuery(goodGrades);
            while (rset.next()) {
                System.out.println("نام:" + rset.getString(1));
                System.out.println("نام خانوادگی:" + rset.getString(2));
                System.out.println("دانش فنی:" + rset.getString(3));
                System.out.println("ریاضی:" + rset.getString(4));
                System.out.println("فیزیک:" + rset.getString(5));
                System.out.println("شیمی:" + rset.getString(6));
                System.out.println("تجارت:" + rset.getString(7));
                System.out.println("شبکه:" + rset.getString(8));
                System.out.println("کد دانش آموزی:" + rset.getString(9));
                System.out.println("------دانش آموز بعدی------");
            }

        } catch (SQLException e) {
            System.out.println("نمیتواندید نمره دانش آموز را ببینید.");
            System.out.println("خطا به شرج زیر میباشد.");
            System.out.println(e.getMessage());
        }
        try {
            String LogPath = "H:ShowGoodGradesMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath, true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);


            logger.info("this is a info messsage");
            logger.fine("this is a fine messsage");
        } catch (IOException e) {
            System.out.println("exeption message is : " + e.getMessage());
        }
    }


}
