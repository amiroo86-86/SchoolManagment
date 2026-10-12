package org.example;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogingForTeachers implements Loging {
    private boolean logStatus = true;
    private final Logger logger = Logger.getLogger(LogingForTeachers.class.getName());

    @Override
    public void SignUp(String username, String password, String realname, String url, String dbuser, String dbpass) {
        if (username != null && (!username.isEmpty()) && password != null && (!password.isEmpty()) && realname != null && (!realname.isEmpty())) {
            try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
                Statement stmt = conn.createStatement();
                String signUpStatus = "SELECT `username`FROM `teachers_info`";
                ResultSet rset = stmt.executeQuery(signUpStatus);
                while (rset.next()) {
                    if (Objects.equals(rset.getString(1), username)){
                        logStatus = false;
                        break;
                    }
                    else logStatus = true;
                }
                if (logStatus){
                    String signUp = "INSERT INTO teachers_info (username ,password ,realname) VALUES (? ,? ,?)";
                    PreparedStatement stmt2 = conn.prepareStatement(signUp);
                    stmt2.setString(1, username);
                    stmt2.setString(2, password);
                    stmt2.setString(3, realname);
                    stmt2.executeUpdate();
                    System.out.println("ثبت نام شما با موفقیت انجام شد.");
                }
                else System.out.println("این نام کاربری قبلا ثبت شده است.");



            } catch (SQLException e) {
                System.out.println("exeption message is :" + e.getMessage());
            }
        } else {
            System.out.println("بعضی از فیلد ها مقدار دهی نشده.");
        }
        try {
            String LogPath = "H:SignUpMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath, true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);
            logger.fine("You Call SignUp Method");

        } catch (IOException e) {
            System.out.println("exeption message is : " + e.getMessage());
        }

    }

    @Override
    public void SignIn(String username, String password, String url, String dbuser, String dbpass) {
        if (username != null && (!username.isEmpty()) && password != null && (!password.isEmpty())) {
            try (Connection conn = DriverManager.getConnection(url, dbuser, dbpass)) {
                Statement stmt = conn.createStatement();
                String signIn = "SELECT `username`, `password` FROM `teachers_info`";
                ResultSet rset = stmt.executeQuery(signIn);
                while (rset.next()) {
                    if (Objects.equals(rset.getString(1), username) && Objects.equals(rset.getString(2), password)) {
                        logStatus = true;
                        break;
                    } else logStatus = false;

                }
                if (logStatus)
                    System.out.println("نام کاربری و رمز عبور صحیح میباشد.");
                else
                    System.out.println("نام کاربری یا رمز عبور صحیح نمی باشد.");

            } catch (SQLException e) {
                System.out.println("exeption message is :" + e.getMessage());
            }

        } else System.out.println("بعضی از فیلد ها مقدار دهی نشده اند.");
        try {
            String LogPath = "H:SignInMethod.log";
            logger.setLevel(Level.FINE);
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(LogPath, true);
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.FINE);
            logger.fine("You Call SignIn Method");

        } catch (IOException e) {
            System.out.println("exeption message is : " + e.getMessage());
        }

    }
}

