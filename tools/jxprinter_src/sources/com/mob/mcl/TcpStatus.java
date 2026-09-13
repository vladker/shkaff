package com.mob.mcl;

import A3.AbstractC0157z;
import com.mob.tools.proguard.EverythingKeeper;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class TcpStatus implements EverythingKeeper {
    public static final int TYPE_FORCE_CLOSE = 22;
    public static final int TYPE_INIT_FLOW_END = 20;
    public static final int TYPE_INIT_FLOW_EXCEPTION = 23;
    public static final int TYPE_REGISTER_FAILED = 24;
    public static final int TYPE_REGISTER_SUCCESS = 10;
    public static final int TYPE_TCP_UNAVAILABLE = 21;
    public int code;
    public String detailedMsg;
    public String msg;

    private TcpStatus(int i5, String str) {
        this.code = i5;
        this.msg = str;
    }

    public static TcpStatus obtain(int i5) {
        String str;
        if (i5 != 10) {
            switch (i5) {
                case 20:
                    str = "20:tcp init flow end(rare status)";
                    break;
                case 21:
                    str = "21:tcp unavailable";
                    break;
                case 22:
                    str = "22:tcp force close(rare status)";
                    break;
                case 23:
                    str = "23:tcp init flow exception(rare status)";
                    break;
                case 24:
                    str = "24:register failed";
                    break;
                default:
                    str = "0:unknown(rare status)";
                    break;
            }
        } else {
            str = "10:tcp register success";
        }
        String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        return new TcpStatus(Integer.parseInt(strArrSplit[0]), strArrSplit[1]);
    }

    public TcpStatus setDetailedMsg(String str) {
        this.detailedMsg = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TcpStatus[code: ");
        sb.append(this.code);
        sb.append(", msg: ");
        sb.append(this.msg);
        sb.append(", detailedMsg: ");
        return AbstractC0157z.s(sb, this.detailedMsg, "]");
    }
}
