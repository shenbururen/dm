package cn.sanenen.dm.grpc.pkg.control;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.1)",
    comments = "Source: control/ControlServer.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ControlServerServiceGrpc {

  private ControlServerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ControlServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage,
      cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage> getRegisterDmTerminalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterDmTerminal",
      requestType = cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage.class,
      responseType = cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage,
      cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage> getRegisterDmTerminalMethod() {
    io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage, cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage> getRegisterDmTerminalMethod;
    if ((getRegisterDmTerminalMethod = ControlServerServiceGrpc.getRegisterDmTerminalMethod) == null) {
      synchronized (ControlServerServiceGrpc.class) {
        if ((getRegisterDmTerminalMethod = ControlServerServiceGrpc.getRegisterDmTerminalMethod) == null) {
          ControlServerServiceGrpc.getRegisterDmTerminalMethod = getRegisterDmTerminalMethod =
              io.grpc.MethodDescriptor.<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage, cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterDmTerminal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ControlServerServiceMethodDescriptorSupplier("RegisterDmTerminal"))
              .build();
        }
      }
    }
    return getRegisterDmTerminalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ControlServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceStub>() {
        @java.lang.Override
        public ControlServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServerServiceStub(channel, callOptions);
        }
      };
    return ControlServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ControlServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceBlockingStub>() {
        @java.lang.Override
        public ControlServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServerServiceBlockingStub(channel, callOptions);
        }
      };
    return ControlServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ControlServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ControlServerServiceFutureStub>() {
        @java.lang.Override
        public ControlServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ControlServerServiceFutureStub(channel, callOptions);
        }
      };
    return ControlServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage> registerDmTerminal(
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getRegisterDmTerminalMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ControlServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class ControlServerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ControlServerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ControlServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ControlServerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ControlServerServiceStub> {
    private ControlServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServerServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage> registerDmTerminal(
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getRegisterDmTerminalMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ControlServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ControlServerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ControlServerServiceBlockingStub> {
    private ControlServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServerServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ControlServerService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class ControlServerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ControlServerServiceFutureStub> {
    private ControlServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ControlServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ControlServerServiceFutureStub(channel, callOptions);
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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_DM_TERMINAL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.registerDmTerminal(
              (io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getRegisterDmTerminalMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ClientMessage,
              cn.sanenen.dm.grpc.pkg.control.ControlServerPg.ServerMessage>(
                service, METHODID_REGISTER_DM_TERMINAL)))
        .build();
  }

  private static abstract class ControlServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ControlServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.sanenen.dm.grpc.pkg.control.ControlServerPg.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ControlServerService");
    }
  }

  private static final class ControlServerServiceFileDescriptorSupplier
      extends ControlServerServiceBaseDescriptorSupplier {
    ControlServerServiceFileDescriptorSupplier() {}
  }

  private static final class ControlServerServiceMethodDescriptorSupplier
      extends ControlServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ControlServerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ControlServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ControlServerServiceFileDescriptorSupplier())
              .addMethod(getRegisterDmTerminalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
