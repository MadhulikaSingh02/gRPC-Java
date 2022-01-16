package org.example.service;

import io.grpc.stub.StreamObserver;
import org.example.grpc.Login;
import org.example.grpc.UserLoginGrpc;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UserLoginService extends UserLoginGrpc.UserLoginImplBase {
    @Override
    public void insertUser(Login.LoginRequest request,
                           StreamObserver<Login.LoginResponse> responseObserver) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String emailId = request.getEmailId();
        System.out.println("Calling Microservice insertUser ::>>" + firstName+ lastName+emailId);
        Login.LoginResponse.Builder response = Login.LoginResponse.newBuilder();
        if(emailId != null && !emailId.equals("")
        && firstName != null && !firstName.equals("")
        && lastName != null && !lastName.equals("")) {
            System.out.println("Email Entered ::>>" + emailId);
            System.out.println("FirstName Entered ::>>" + firstName);
            System.out.println("LastName Entered ::>>" + lastName);
            String emailIdFromDB = null;

            //before insertion, check the user exists or not.
            try {
                emailIdFromDB = checkIfUserExists(emailId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (emailIdFromDB != null) {
                System.out.println("Email Address already in use. Try again with a different id>>");
                response.setResponseCode(100).setResponseMessage("Email Id already used. Re-try with a new id!!!");
            } else {
                System.out.println("No Email id found.User can be created >>");
                try {
                    PreparedStatement st = insertUserRow(request);
                    st.executeUpdate();
                    response.setResponseCode(200).setResponseMessage("User details inserted");
                    System.out.println("values inserted");
                } catch (Exception e) {
                    response.setResponseCode(100).setResponseMessage("User details not inserted");
                    e.printStackTrace();
                }
            }
        }
        else{
                response.setResponseCode(100).setResponseMessage("Incorrect Values.User details not inserted");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private static PreparedStatement insertUserRow(Login.LoginRequest request) throws SQLException {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String emailId = request.getEmailId();

        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement st = null;

        String url = "jdbc:mysql://localhost:3306/backend_test?useSSL=false";
        String user = "root";
        String password = "password";

        String sql = "INSERT INTO User_Details(FirstName, LastName, EmailId) VALUES(?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection is successful >>> " + url);

            st = (PreparedStatement) connection.prepareStatement(sql);
            st.setString(1, firstName);
            st.setString(2, lastName);
            st.setString(3, emailId);
            return st;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void isUserExists(Login.LoginRequest request,
                             StreamObserver<Login.LoginResponse> responseObserver) {

        String emailId = request.getEmailId();
        System.out.println("Calling Microservice isUserExists ::>>" + emailId);
        Login.LoginResponse.Builder response = Login.LoginResponse.newBuilder();

        if(emailId != null && !emailId.equals("")) {
            System.out.println("Email Entered ::>>" + emailId);

            String emailIdFromDB = null;
            try {
                emailIdFromDB = checkIfUserExists(emailId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (emailIdFromDB != null) {
                System.out.println("Email id found.User already exists ::>>");
                response.setResponseCode(200).setResponseMessage("User exists!!!");
            } else {
                System.out.println("No Email id found.User does not exist ::>>");
                response.setResponseCode(100).setResponseMessage("User does not exist!!!");
            }
        }else{
            response.setResponseCode(100).setResponseMessage("Incorrect input entered!!!");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private static String checkIfUserExists(String emailId) throws SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;

        String email = null;
        String url="jdbc:mysql://localhost:3306/backend_test?useSSL=false";
        String user = "root";
        String password = "password";
        String sql = "select EmailId from User_Details where EmailId='"+emailId+"'";
        //select * from User_Details where EmailId='msingh@gmail.com'
        System.out.println(sql);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection( url,user, password);
            System.out.println("connection is successful >>> "+url);

            statement=connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Printing result...");

                // Now we can fetch the data by column name, save and use them!
                email = resultSet.getString("EmailId");
                System.out.println("email: " + email);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return email;
    }

    @Override
    public void listUsers(Login.Empty request, StreamObserver<Login.MultipleUserResponse> responseObserver) {
        List<Login.UserRecord> userRecordList = new ArrayList<>();
        Login.MultipleUserResponse.Builder response = Login.MultipleUserResponse.newBuilder();
        //Login.MultipleUserResponse response= Login.MultipleUserResponse.newBuilder().build();

        //get all users from DB
        ResultSet resultSet = null;
        Connection connection = null;
        Statement statement = null;
        String url="jdbc:mysql://localhost:3306/backend_test?useSSL=false";
        String user = "root";
        String password = "password";
        String sql = "select * from User_Details";
        System.out.println(sql);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection( url,user, password);
            System.out.println("connection is successful >>> "+url);

            statement=connection.createStatement();
            resultSet = statement.executeQuery(sql);

            // b.addPoint(Point.newBuilder().setX(x).setY(y).build());
            while (resultSet.next()) {
                System.out.println("Printing result...");
                response.addUserRow(Login.UserRecord.newBuilder().
                        setFirstName(resultSet.getString("FirstName")).
                        setLastName(resultSet.getString("LastName")).
                        setEmailId(resultSet.getString("EmailId")));
                //List<Point> points = ...;
                //response.addAllPoint(points);

               /* userRecordList.add(Login.UserRecord.newBuilder().
                        setFirstName(resultSet.getString("FirstName")).
                        setLastName(resultSet.getString("LastName")).
                        setEmailId(resultSet.getString("EmailId")).build());*/

            }
            System.out.println("List size"+userRecordList.size());
            //response.addAllUserRow(userRecordList);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //responseObserver.onNext(response.addAllUserRow(userRecordList).build());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
