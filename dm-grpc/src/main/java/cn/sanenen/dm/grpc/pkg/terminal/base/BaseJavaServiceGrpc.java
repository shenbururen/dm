package cn.sanenen.dm.grpc.pkg.terminal.base;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.69.1)",
    comments = "Source: terminal/Base.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BaseJavaServiceGrpc {

  private BaseJavaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "BaseJavaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> getGetCurrentPIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentPID",
      requestType = com.google.protobuf.Empty.class,
      responseType = cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> getGetCurrentPIDMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> getGetCurrentPIDMethod;
    if ((getGetCurrentPIDMethod = BaseJavaServiceGrpc.getGetCurrentPIDMethod) == null) {
      synchronized (BaseJavaServiceGrpc.class) {
        if ((getGetCurrentPIDMethod = BaseJavaServiceGrpc.getGetCurrentPIDMethod) == null) {
          BaseJavaServiceGrpc.getGetCurrentPIDMethod = getGetCurrentPIDMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentPID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BaseJavaServiceMethodDescriptorSupplier("getCurrentPID"))
              .build();
        }
      }
    }
    return getGetCurrentPIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> getGetHasFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getHasFiles",
      requestType = com.google.protobuf.Empty.class,
      responseType = cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> getGetHasFilesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> getGetHasFilesMethod;
    if ((getGetHasFilesMethod = BaseJavaServiceGrpc.getGetHasFilesMethod) == null) {
      synchronized (BaseJavaServiceGrpc.class) {
        if ((getGetHasFilesMethod = BaseJavaServiceGrpc.getGetHasFilesMethod) == null) {
          BaseJavaServiceGrpc.getGetHasFilesMethod = getGetHasFilesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getHasFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BaseJavaServiceMethodDescriptorSupplier("getHasFiles"))
              .build();
        }
      }
    }
    return getGetHasFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getDelAllFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delAllFiles",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getDelAllFilesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getDelAllFilesMethod;
    if ((getDelAllFilesMethod = BaseJavaServiceGrpc.getDelAllFilesMethod) == null) {
      synchronized (BaseJavaServiceGrpc.class) {
        if ((getDelAllFilesMethod = BaseJavaServiceGrpc.getDelAllFilesMethod) == null) {
          BaseJavaServiceGrpc.getDelAllFilesMethod = getDelAllFilesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delAllFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BaseJavaServiceMethodDescriptorSupplier("delAllFiles"))
              .build();
        }
      }
    }
    return getDelAllFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest,
      com.google.protobuf.Empty> getUploadFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadFile",
      requestType = cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest,
      com.google.protobuf.Empty> getUploadFileMethod() {
    io.grpc.MethodDescriptor<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest, com.google.protobuf.Empty> getUploadFileMethod;
    if ((getUploadFileMethod = BaseJavaServiceGrpc.getUploadFileMethod) == null) {
      synchronized (BaseJavaServiceGrpc.class) {
        if ((getUploadFileMethod = BaseJavaServiceGrpc.getUploadFileMethod) == null) {
          BaseJavaServiceGrpc.getUploadFileMethod = getUploadFileMethod =
              io.grpc.MethodDescriptor.<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "uploadFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BaseJavaServiceMethodDescriptorSupplier("uploadFile"))
              .build();
        }
      }
    }
    return getUploadFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRestartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "restart",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.google.protobuf.Empty> getRestartMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getRestartMethod;
    if ((getRestartMethod = BaseJavaServiceGrpc.getRestartMethod) == null) {
      synchronized (BaseJavaServiceGrpc.class) {
        if ((getRestartMethod = BaseJavaServiceGrpc.getRestartMethod) == null) {
          BaseJavaServiceGrpc.getRestartMethod = getRestartMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "restart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BaseJavaServiceMethodDescriptorSupplier("restart"))
              .build();
        }
      }
    }
    return getRestartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BaseJavaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceStub>() {
        @java.lang.Override
        public BaseJavaServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseJavaServiceStub(channel, callOptions);
        }
      };
    return BaseJavaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BaseJavaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceBlockingStub>() {
        @java.lang.Override
        public BaseJavaServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseJavaServiceBlockingStub(channel, callOptions);
        }
      };
    return BaseJavaServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BaseJavaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BaseJavaServiceFutureStub>() {
        @java.lang.Override
        public BaseJavaServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BaseJavaServiceFutureStub(channel, callOptions);
        }
      };
    return BaseJavaServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义服务
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void getCurrentPID(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentPIDMethod(), responseObserver);
    }

    /**
     * <pre>
     *获取已有的资源文件
     * </pre>
     */
    default void getHasFiles(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHasFilesMethod(), responseObserver);
    }

    /**
     * <pre>
     *删除所有资源文件
     * </pre>
     */
    default void delAllFiles(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDelAllFilesMethod(), responseObserver);
    }

    /**
     * <pre>
     *上传资源文件
     * </pre>
     */
    default void uploadFile(cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUploadFileMethod(), responseObserver);
    }

    /**
     * <pre>
     *重启终端
     * </pre>
     */
    default void restart(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestartMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BaseJavaService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static abstract class BaseJavaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BaseJavaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BaseJavaService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class BaseJavaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BaseJavaServiceStub> {
    private BaseJavaServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseJavaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseJavaServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCurrentPID(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentPIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *获取已有的资源文件
     * </pre>
     */
    public void getHasFiles(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHasFilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *删除所有资源文件
     * </pre>
     */
    public void delAllFiles(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDelAllFilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *上传资源文件
     * </pre>
     */
    public void uploadFile(cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *重启终端
     * </pre>
     */
    public void restart(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BaseJavaService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class BaseJavaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BaseJavaServiceBlockingStub> {
    private BaseJavaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseJavaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseJavaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse getCurrentPID(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentPIDMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *获取已有的资源文件
     * </pre>
     */
    public cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse getHasFiles(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHasFilesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *删除所有资源文件
     * </pre>
     */
    public com.google.protobuf.Empty delAllFiles(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDelAllFilesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *上传资源文件
     * </pre>
     */
    public com.google.protobuf.Empty uploadFile(cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadFileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *重启终端
     * </pre>
     */
    public com.google.protobuf.Empty restart(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BaseJavaService.
   * <pre>
   * 定义服务
   * </pre>
   */
  public static final class BaseJavaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BaseJavaServiceFutureStub> {
    private BaseJavaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BaseJavaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BaseJavaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse> getCurrentPID(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentPIDMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *获取已有的资源文件
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse> getHasFiles(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHasFilesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *删除所有资源文件
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> delAllFiles(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDelAllFilesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *上传资源文件
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> uploadFile(
        cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadFileMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *重启终端
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> restart(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_PID = 0;
  private static final int METHODID_GET_HAS_FILES = 1;
  private static final int METHODID_DEL_ALL_FILES = 2;
  private static final int METHODID_UPLOAD_FILE = 3;
  private static final int METHODID_RESTART = 4;

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
        case METHODID_GET_CURRENT_PID:
          serviceImpl.getCurrentPID((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse>) responseObserver);
          break;
        case METHODID_GET_HAS_FILES:
          serviceImpl.getHasFiles((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse>) responseObserver);
          break;
        case METHODID_DEL_ALL_FILES:
          serviceImpl.delAllFiles((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPLOAD_FILE:
          serviceImpl.uploadFile((cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTART:
          serviceImpl.restart((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
          getGetCurrentPIDMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getCurrentPIDResponse>(
                service, METHODID_GET_CURRENT_PID)))
        .addMethod(
          getGetHasFilesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getHasFilesResponse>(
                service, METHODID_GET_HAS_FILES)))
        .addMethod(
          getDelAllFilesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.google.protobuf.Empty>(
                service, METHODID_DEL_ALL_FILES)))
        .addMethod(
          getUploadFileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.uploadFileRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPLOAD_FILE)))
        .addMethod(
          getRestartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.google.protobuf.Empty>(
                service, METHODID_RESTART)))
        .build();
  }

  private static abstract class BaseJavaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BaseJavaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BaseJavaService");
    }
  }

  private static final class BaseJavaServiceFileDescriptorSupplier
      extends BaseJavaServiceBaseDescriptorSupplier {
    BaseJavaServiceFileDescriptorSupplier() {}
  }

  private static final class BaseJavaServiceMethodDescriptorSupplier
      extends BaseJavaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BaseJavaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BaseJavaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BaseJavaServiceFileDescriptorSupplier())
              .addMethod(getGetCurrentPIDMethod())
              .addMethod(getGetHasFilesMethod())
              .addMethod(getDelAllFilesMethod())
              .addMethod(getUploadFileMethod())
              .addMethod(getRestartMethod())
              .build();
        }
      }
    }
    return result;
  }
}
