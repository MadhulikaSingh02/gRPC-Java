package org.example.service;

import io.grpc.stub.StreamObserver;
import org.example.grpc.Login;
import org.example.grpc.UserLoginGrpc;

import java.sql.*;

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
            try {
                //before insertion, check if the user exists or not.
                emailIdFromDB = checkIfUserExists(emailId);
                if (emailIdFromDB != null) {
                    System.out.println("Email Address already in use. Try again with a different id>>");
                    response.setResponseCode(100).setResponseMessage("Email Id already used. Re-try with a new id!!!");
                } else {
                    System.out.println("No Email id found.User can be created >>");
                    PreparedStatement st = insertUserRow(request);
                    st.executeUpdate();
                    response.setResponseCode(200).setResponseMessage("User details inserted");
                    System.out.println("Values inserted");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
                response.setResponseCode(100).setResponseMessage("Incorrect Values.User details not inserted");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private static PreparedStatement insertUserRow(Login.LoginRequest request)  {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String emailId = request.getEmailId();

        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO User_Details(FirstName, LastName, EmailId) VALUES(?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend_test?useSSL=false",
                    "test","test");
            System.out.println("connection is successful >>> ");

            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, emailId);
            return statement;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void isUserExists(Login.LoginRequest request,
                             StreamObserver<Login.LoginResponse> responseObserver) {

        String emailId = request.getEmailId();
        System.out.println("Calling Microservice isUserExists for::>>" + emailId);
        Login.LoginResponse.Builder response = Login.LoginResponse.newBuilder();

        if(emailId != null && !emailId.equals("")) {
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
        Connection connection = null;
        Statement statement = null;
        String eId = null;
        String sql = "select EmailId from User_Details where EmailId='"+emailId+"'";
        System.out.println(sql);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/backend_test?useSSL=false","test", "test");
            System.out.println("connection is successful>>");

            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // Now we can fetch the data by column name, save and use them!
                eId = resultSet.getString("EmailId");
                System.out.println("Email Fetched : " + eId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                if(statement != null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return eId;
    }

    @Override
    public void listUsers(Login.Empty request, StreamObserver<Login.MultipleUserResponse> responseObserver) {
        System.out.println("Calling Microservice listUsers >>::");

        Login.MultipleUserResponse.Builder response = Login.MultipleUserResponse.newBuilder();

        //get all users from DB
        Connection connection = null;
        Statement statement = null;
        String sql = "select * from User_Details";
        System.out.println(sql);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend_test?useSSL=false",
                    "test","test");
            System.out.println("Connection is successful >>> ");

            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                response.addUserRow(Login.UserRecord.newBuilder().
                        setFirstName(resultSet.getString("FirstName")).
                        setLastName(resultSet.getString("LastName")).
                        setEmailId(resultSet.getString("EmailId")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                if(statement != null) statement.close();
                if(connection!=null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
