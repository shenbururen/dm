package cn.sanenen.dm.common;

/**
 * @author sun
 **/
public enum TerminalStatus {
    init(0, "初始化"),
    no_run(1, "未运行"),
    one(2, "第一场景"),
    error(-90, "异常"),
    restart(-91, "重新启动"),
    grpc_error(-92, "连接断开"),
    ;

    public final int code;
    public final String desc;
    TerminalStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public static TerminalStatus getByCode(int code) {
        for (TerminalStatus status : TerminalStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }
        return null;
    }
    public static TerminalStatus getByDesc(String desc) {
        for (TerminalStatus status : TerminalStatus.values()) {
            if (status.desc.equals(desc)) {
                return status;
            }
        }
        return null;
    }
}
