# gRPC-Java -User Login #
**gRPC** is a high performance, open source RPC framework initially developed by Google. The framework is based on a client-server model of remote procedure calls. A client application can directly call methods on a server application as if it was a local object.

## Problem Statement ##

- To register into the system with first name, last name and email of a user.
- To get the list of all the users in the system.
- To search a user by email and confirm if the user exists.

This demo illustrates the following steps to create a typical gRPC application for the problem:
- Define a service "UserLoginService" in a .proto file
- Generate gRPC stub code using the protocol buffer compiler
- Create the server application, implementing the generated service interfaces.

### Tool Used: ##
- IntelliJ IDEA with Maven 
- Plugins - Protocol Buffer--> "protoc-jar-maven-plugin"
- MySQL Database server
- BloomRPC - https://github.com/bloomrpc/bloomrpc/releases

Maven Dependencies: Add grpc-netty, grpc-protobuf and grpc-stub dependencies

### MySQL Database server: ###
- Login to MySQL workbench  with crendentials : test/test
- Run the commands:
    1. create database backend_test;
    2. use backend_test;
    3. create table User_Details(FirstName varchar(255),LastName varchar(255),EmailId varchar(255));

### Steps to start services: ###
1. Import the project into workspace.
2. Ensure that all the dependencies and necessary plugins are present.
3. Maven Clean project
4. Maven Build project
5. Run GRPCServer
6. Install BloomRPC Tool and then open this tool. Add "login.proto" file and the three services are ready to test.

### Files created/modified: ###
1. pom.xml
2. login.proto
3. UserLoginService.java
4. GRPCServer.java
