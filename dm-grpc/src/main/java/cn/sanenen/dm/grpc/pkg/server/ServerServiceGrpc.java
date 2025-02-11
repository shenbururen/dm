package cn.sanenen.dm.grpc.pkg.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.1)",
    comments = "Source: server/Server.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServerServiceGrpc {

  private ServerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest,
      cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> getRegisterDmTerminalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDmTerminal",
      requestType = cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest.class,
      responseType = cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest,
      cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> getRegisterDmTerminalMethod() {
    io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest, cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> getRegisterDmTerminalMethod;
    if ((getRegisterDmTerminalMethod = ServerServiceGrpc.getRegisterDmTerminalMethod) == null) {
      synchronized (ServerServiceGrpc.class) {
        if ((getRegisterDmTerminalMethod = ServerServiceGrpc.getRegisterDmTerminalMethod) == null) {
          ServerServiceGrpc.getRegisterDmTerminalMethod = getRegisterDmTerminalMethod =
              io.grpc.MethodDescriptor.<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest, cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDmTerminal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServerServiceMethodDescriptorSupplier("RegisterDmTerminal"))
              .build();
        }
      }
    }
    return getRegisterDmTerminalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerServiceStub>() {
        @java.lang.Override
        public ServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerServiceStub(channel, callOptions);
        }
      };
    return ServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerServiceBlockingStub>() {
        @java.lang.Override
        public ServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerServiceBlockingStub(channel, callOptions);
        }
      };
    return ServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerServiceFutureStub>() {
        @java.lang.Override
        public ServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerServiceFutureStub(channel, callOptions);
        }
      };
    return ServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void registerDmTerminal(cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterDmTerminalMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class ServerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ServerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ServerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ServerServiceStub> {
    private ServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerDmTerminal(cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterDmTerminalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ServerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServerServiceBlockingStub> {
    private ServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse registerDmTerminal(cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterDmTerminalMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ServerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServerServiceFutureStub> {
    private ServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse> registerDmTerminal(
        cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterDmTerminalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_DM_TERMINAL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_DM_TERMINAL:
          serviceImpl.registerDmTerminal((cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest) request,
              (io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterDmTerminalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalRequest,
              cn.sanenen.dm.grpc.pkg.server.ServerPg.RegisterDmTerminalResponse>(
                service, METHODID_REGISTER_DM_TERMINAL)))
        .build();
  }

  private static abstract class ServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.sanenen.dm.grpc.pkg.server.ServerPg.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerService");
    }
  }

  private static final class ServerServiceFileDescriptorSupplier
      extends ServerServiceBaseDescriptorSupplier {
    ServerServiceFileDescriptorSupplier() {}
  }

  private static final class ServerServiceMethodDescriptorSupplier
      extends ServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ServerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerServiceFileDescriptorSupplier())
              .addMethod(getRegisterDmTerminalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
