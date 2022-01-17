package org.example.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.grpc.Login;
import org.example.grpc.UserLoginGrpc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserLoginServiceTest {

    @Mock
    Login.LoginResponse responseMock;

    @Test
    void insertUser() {
        insertUser1();
        insertUser2();
    }

    void insertUser1() {
        System.out.println("insertUser1");
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("msingh@gmail.com").
                setFirstName("Madhulika").
                setLastName("Singh").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);
        Login.LoginResponse response = userLoginStub.insertUser(request);

        assertEquals(100,response.getResponseCode());
        assertEquals("Email Id already used. Re-try with a new id!!!", response.getResponseMessage());
        System.out.println(response);
    }

    void insertUser2() {
        System.out.println("insertUser2");
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("msingh@hotmail.com").
                setFirstName("Madhulika").
                setLastName("Singh").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);

        Login.LoginResponse response = userLoginStub.insertUser(request);

        assertEquals(200,response.getResponseCode());
        assertEquals("User details inserted", response.getResponseMessage());
        System.out.println(response);
    }


    @Test
    void isUserExists(){
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("msingh@gmail.com").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);

        assertNotNull(responseMock);
        when(responseMock.getResponseCode()).thenReturn(150);

        responseMock = userLoginStub.isUserExists(request);
        isUserExists1();
        isUserExists2();
        isUserExists3();
    }
    void isUserExists1() {
        System.out.println("isUserExists1");
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("msingh@gmail.com").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);
        Login.LoginResponse response = userLoginStub.isUserExists(request);
        assertEquals(200,response.getResponseCode());
        assertEquals("User exists!!!", response.getResponseMessage());
        System.out.println(response);
        }

    void isUserExists2() {
        System.out.println("isUserExists2");
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("msingghh@gmail.com").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);
        Login.LoginResponse response = userLoginStub.isUserExists(request);
        assertEquals(100,response.getResponseCode());
        assertEquals("User does not exist!!!", response.getResponseMessage());
        System.out.println(response);
    }
    void isUserExists3() {
        System.out.println("isUserExists3");
        Login.LoginRequest request = Login.LoginRequest.newBuilder().
                setEmailId("").build();
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);
        Login.LoginResponse response = userLoginStub.isUserExists(request);
        assertEquals(100,response.getResponseCode());
        assertEquals("Incorrect input entered!!!", response.getResponseMessage());
        System.out.println(response);
    }
    @Test
    void listUsers() {
        System.out.println("listUsers");
        Login.Empty request = Login.Empty.newBuilder().build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085).usePlaintext().build();
        UserLoginGrpc.UserLoginBlockingStub userLoginStub = UserLoginGrpc.newBlockingStub(channel);
        Login.MultipleUserResponse response = userLoginStub.listUsers(request);
        System.out.println(response);


    }
}