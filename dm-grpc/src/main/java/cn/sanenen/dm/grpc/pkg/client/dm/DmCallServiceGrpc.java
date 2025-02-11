package cn.sanenen.dm.grpc.pkg.client.dm;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.1)",
    comments = "Source: client/DmCall.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DmCallServiceGrpc {

  private DmCallServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "DmCallService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest,
      cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Call",
      requestType = cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest.class,
      responseType = cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest,
      cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> getCallMethod() {
    io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest, cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> getCallMethod;
    if ((getCallMethod = DmCallServiceGrpc.getCallMethod) == null) {
      synchronized (DmCallServiceGrpc.class) {
        if ((getCallMethod = DmCallServiceGrpc.getCallMethod) == null) {
          DmCallServiceGrpc.getCallMethod = getCallMethod =
              io.grpc.MethodDescriptor.<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest, cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DmCallServiceMethodDescriptorSupplier("Call"))
              .build();
        }
      }
    }
    return getCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DmCallServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DmCallServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DmCallServiceStub>() {
        @java.lang.Override
        public DmCallServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DmCallServiceStub(channel, callOptions);
        }
      };
    return DmCallServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DmCallServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DmCallServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DmCallServiceBlockingStub>() {
        @java.lang.Override
        public DmCallServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DmCallServiceBlockingStub(channel, callOptions);
        }
      };
    return DmCallServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DmCallServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DmCallServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DmCallServiceFutureStub>() {
        @java.lang.Override
        public DmCallServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DmCallServiceFutureStub(channel, callOptions);
        }
      };
    return DmCallServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void call(cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCallMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DmCallService.
   */
  public static abstract class DmCallServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DmCallServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DmCallService.
   */
  public static final class DmCallServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DmCallServiceStub> {
    private DmCallServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DmCallServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DmCallServiceStub(channel, callOptions);
    }

    /**
     */
    public void call(cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DmCallService.
   */
  public static final class DmCallServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DmCallServiceBlockingStub> {
    private DmCallServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DmCallServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DmCallServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse call(cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DmCallService.
   */
  public static final class DmCallServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DmCallServiceFutureStub> {
    private DmCallServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DmCallServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DmCallServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse> call(
        cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALL = 0;

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
        case METHODID_CALL:
          serviceImpl.call((cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest) request,
              (io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse>) responseObserver);
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
          getCallMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallRequest,
              cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.DmCallResponse>(
                service, METHODID_CALL)))
        .build();
  }

  private static abstract class DmCallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DmCallServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DmCallService");
    }
  }

  private static final class DmCallServiceFileDescriptorSupplier
      extends DmCallServiceBaseDescriptorSupplier {
    DmCallServiceFileDescriptorSupplier() {}
  }

  private static final class DmCallServiceMethodDescriptorSupplier
      extends DmCallServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DmCallServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DmCallServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DmCallServiceFileDescriptorSupplier())
              .addMethod(getCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
