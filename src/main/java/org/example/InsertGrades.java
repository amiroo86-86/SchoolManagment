package org.example;
import com.mysql.cj.log.Log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class InsertGrades {

    private static final Logger logger = Logger.getLogger(InsertGrades.class.getName());


    public void InsertSStudentGrades( String url,String dbuser,String dbpass){
        Scanner scanner = new Scanner(System.in);
        System.out.println("نام دانش آموز را وارد کنید:");
        String name = scanner.nextLine().trim();
        System.out.println();
        System.out.println("نام خانوادگی دانش آموز را وارد کنید:");
        String FamilyName = scanner.nextLine().trim();
        System.out.println();
        System.out.println("نمره درس دانش فنی دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int DanehFaniMark = scanner.nextInt();
        System.out.println();
        System.out.println("نمره درس ریاضی دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int RiaziMark = scanner.nextInt();
        System.out.println();
        System.out.println("نمره درس فیزیک دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int FizikMArk = scanner.nextInt();
        System.out.println();
        System.out.println("نمره درس شیمی دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int ShimiMark = scanner.nextInt();
        System.out.println();
        System.out.println("نمره درس تجارت دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int TejaratMark = scanner.nextInt();
        System.out.println();
        System.out.println("نمره درس شبکه دانش آموز " + name +"  "+ FamilyName + "  را وارد کنید");
        int ShabakeMark = scanner.nextInt();


        try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
            String insert = "INSERT INTO mew (name ,FamilyName ,DaneshfaniMark ,RiaziMark ,FizikMark ,ShimiMark ,TejaratMark ,ShabakeMark) VALUES (? ,? ,? ,? ,? ,? ,? ,?)";
            PreparedStatement stmt = conn.prepareStatement(insert);

            stmt.setString(1,name);
            stmt.setString(2,FamilyName);
            stmt.setInt(3, DanehFaniMark);
            stmt.setInt(4,RiaziMark);
            stmt.setInt(5,FizikMArk);
            stmt.setInt(6,ShimiMark);
            stmt.setInt(7,TejaratMark);
            stmt.setInt(8,ShabakeMark);

            int rows = stmt.executeUpdate();
            if (rows > 0){
                System.out.println("مشخصات دانش آموز با موفقیت ثبت شد.");
            }
            else {
                System.out.println("مشکلی به وجود آمده است.");
            }
        }

        catch (SQLException e) {

            String MsgForError = e.getMessage().toLowerCase();

            if (MsgForError.contains("duplicate") || MsgForError.contains("unique")){
                System.out.println("اطلاعات وارد شده تکراری است.");
                System.out.println(MsgForError);
            }
            else {
                System.out.println("  اتصال نا موفق بوده اسست  ");
                System.out.println("|");
                System.out.println("|");
                System.out.println("v");
                System.out.println(e.getMessage());
            }

        }
        try {
            String LogPath = "H:InsertGradesMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath,true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);


            logger.info("this is a info messsage");
            logger.fine("this is a fine messsage");
        }
        catch (IOException e){
            System.out.println("exeption message is : " + e.getMessage());
        }

    }




}
