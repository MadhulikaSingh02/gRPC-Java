package org.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: login.proto")
public final class UserLoginGrpc {

  private UserLoginGrpc() {}

  public static final String SERVICE_NAME = "UserLogin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest,
      org.example.grpc.Login.LoginResponse> getInsertUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertUser",
      requestType = org.example.grpc.Login.LoginRequest.class,
      responseType = org.example.grpc.Login.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest,
      org.example.grpc.Login.LoginResponse> getInsertUserMethod() {
    io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest, org.example.grpc.Login.LoginResponse> getInsertUserMethod;
    if ((getInsertUserMethod = UserLoginGrpc.getInsertUserMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getInsertUserMethod = UserLoginGrpc.getInsertUserMethod) == null) {
          UserLoginGrpc.getInsertUserMethod = getInsertUserMethod = 
              io.grpc.MethodDescriptor.<org.example.grpc.Login.LoginRequest, org.example.grpc.Login.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserLogin", "insertUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("insertUser"))
                  .build();
          }
        }
     }
     return getInsertUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest,
      org.example.grpc.Login.LoginResponse> getIsUserExistsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isUserExists",
      requestType = org.example.grpc.Login.LoginRequest.class,
      responseType = org.example.grpc.Login.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest,
      org.example.grpc.Login.LoginResponse> getIsUserExistsMethod() {
    io.grpc.MethodDescriptor<org.example.grpc.Login.LoginRequest, org.example.grpc.Login.LoginResponse> getIsUserExistsMethod;
    if ((getIsUserExistsMethod = UserLoginGrpc.getIsUserExistsMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getIsUserExistsMethod = UserLoginGrpc.getIsUserExistsMethod) == null) {
          UserLoginGrpc.getIsUserExistsMethod = getIsUserExistsMethod = 
              io.grpc.MethodDescriptor.<org.example.grpc.Login.LoginRequest, org.example.grpc.Login.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserLogin", "isUserExists"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("isUserExists"))
                  .build();
          }
        }
     }
     return getIsUserExistsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.grpc.Login.Empty,
      org.example.grpc.Login.MultipleUserResponse> getListUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listUsers",
      requestType = org.example.grpc.Login.Empty.class,
      responseType = org.example.grpc.Login.MultipleUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.grpc.Login.Empty,
      org.example.grpc.Login.MultipleUserResponse> getListUsersMethod() {
    io.grpc.MethodDescriptor<org.example.grpc.Login.Empty, org.example.grpc.Login.MultipleUserResponse> getListUsersMethod;
    if ((getListUsersMethod = UserLoginGrpc.getListUsersMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getListUsersMethod = UserLoginGrpc.getListUsersMethod) == null) {
          UserLoginGrpc.getListUsersMethod = getListUsersMethod = 
              io.grpc.MethodDescriptor.<org.example.grpc.Login.Empty, org.example.grpc.Login.MultipleUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserLogin", "listUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.grpc.Login.MultipleUserResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("listUsers"))
                  .build();
          }
        }
     }
     return getListUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserLoginStub newStub(io.grpc.Channel channel) {
    return new UserLoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserLoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserLoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserLoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserLoginFutureStub(channel);
  }

  /**
   */
  public static abstract class UserLoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void insertUser(org.example.grpc.Login.LoginRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertUserMethod(), responseObserver);
    }

    /**
     */
    public void isUserExists(org.example.grpc.Login.LoginRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIsUserExistsMethod(), responseObserver);
    }

    /**
     */
    public void listUsers(org.example.grpc.Login.Empty request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.MultipleUserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListUsersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.grpc.Login.LoginRequest,
                org.example.grpc.Login.LoginResponse>(
                  this, METHODID_INSERT_USER)))
          .addMethod(
            getIsUserExistsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.grpc.Login.LoginRequest,
                org.example.grpc.Login.LoginResponse>(
                  this, METHODID_IS_USER_EXISTS)))
          .addMethod(
            getListUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.grpc.Login.Empty,
                org.example.grpc.Login.MultipleUserResponse>(
                  this, METHODID_LIST_USERS)))
          .build();
    }
  }

  /**
   */
  public static final class UserLoginStub extends io.grpc.stub.AbstractStub<UserLoginStub> {
    private UserLoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginStub(channel, callOptions);
    }

    /**
     */
    public void insertUser(org.example.grpc.Login.LoginRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isUserExists(org.example.grpc.Login.LoginRequest request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIsUserExistsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsers(org.example.grpc.Login.Empty request,
        io.grpc.stub.StreamObserver<org.example.grpc.Login.MultipleUserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserLoginBlockingStub extends io.grpc.stub.AbstractStub<UserLoginBlockingStub> {
    private UserLoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.grpc.Login.LoginResponse insertUser(org.example.grpc.Login.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getInsertUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.grpc.Login.LoginResponse isUserExists(org.example.grpc.Login.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getIsUserExistsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.grpc.Login.MultipleUserResponse listUsers(org.example.grpc.Login.Empty request) {
      return blockingUnaryCall(
          getChannel(), getListUsersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserLoginFutureStub extends io.grpc.stub.AbstractStub<UserLoginFutureStub> {
    private UserLoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.grpc.Login.LoginResponse> insertUser(
        org.example.grpc.Login.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.grpc.Login.LoginResponse> isUserExists(
        org.example.grpc.Login.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIsUserExistsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.grpc.Login.MultipleUserResponse> listUsers(
        org.example.grpc.Login.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getListUsersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_USER = 0;
  private static final int METHODID_IS_USER_EXISTS = 1;
  private static final int METHODID_LIST_USERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserLoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserLoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT_USER:
          serviceImpl.insertUser((org.example.grpc.Login.LoginRequest) request,
              (io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse>) responseObserver);
          break;
        case METHODID_IS_USER_EXISTS:
          serviceImpl.isUserExists((org.example.grpc.Login.LoginRequest) request,
              (io.grpc.stub.StreamObserver<org.example.grpc.Login.LoginResponse>) responseObserver);
          break;
        case METHODID_LIST_USERS:
          serviceImpl.listUsers((org.example.grpc.Login.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.grpc.Login.MultipleUserResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserLoginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.grpc.Login.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserLogin");
    }
  }

  private static final class UserLoginFileDescriptorSupplier
      extends UserLoginBaseDescriptorSupplier {
    UserLoginFileDescriptorSupplier() {}
  }

  private static final class UserLoginMethodDescriptorSupplier
      extends UserLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserLoginMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserLoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserLoginFileDescriptorSupplier())
              .addMethod(getInsertUserMethod())
              .addMethod(getIsUserExistsMethod())
              .addMethod(getListUsersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
