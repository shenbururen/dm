package cn.sanenen.dm.common;

/**
 * @author sun
 **/
public enum GameStatus {
    no_run(0, "未运行"),
    one(1, "第一场景"),
    grpc_error(-98, "连接断开"),
    error(-99, "异常"),
    ;

    public final int code;
    public final String desc;
    GameStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
