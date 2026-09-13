package com.zlylib.fileselectorlib.utils;

import A3.AbstractC0157z;
import android.util.Log;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class LogUtils {
    private static final int MAX_STACK_TRACE_SIZE = 131071;
    private static final int METHOD_COUNT = 2;
    private static final int MIN_STACK_OFFSET = 3;
    private static String debugTag = "FilePicker";
    private static boolean isDebug = false;

    private static String _getSimpleClassName(String str) {
        return str.substring(str.lastIndexOf(Consts.DOT) + 1);
    }

    private static int _getStackOffset(StackTraceElement[] stackTraceElementArr) {
        for (int i5 = 3; i5 < stackTraceElementArr.length; i5++) {
            if (!stackTraceElementArr[i5].getClassName().equals(LogUtils.class.getName())) {
                return i5 - 1;
            }
        }
        return -1;
    }

    public static void debug(String str) {
        debug("", str);
    }

    public static void error(Throwable th) {
        error(toStackTraceString(th));
    }

    public static String getDebugTag() {
        return debugTag;
    }

    private static String getTraceElement() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i_getStackOffset = _getStackOffset(stackTrace);
            StringBuilder sb = new StringBuilder();
            String str = "    ";
            for (int length = i_getStackOffset + 2 > stackTrace.length ? (stackTrace.length - i_getStackOffset) - 1 : 2; length > 0; length--) {
                int i5 = length + i_getStackOffset;
                if (i5 < stackTrace.length) {
                    sb.append("\n");
                    sb.append(str);
                    sb.append(_getSimpleClassName(stackTrace[i5].getClassName()));
                    sb.append(Consts.DOT);
                    sb.append(stackTrace[i5].getMethodName());
                    sb.append(" ");
                    sb.append("(");
                    sb.append(stackTrace[i5].getFileName());
                    sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
                    sb.append(stackTrace[i5].getLineNumber());
                    sb.append(")");
                    str = str + "    ";
                }
            }
            return sb.toString();
        } catch (Exception e) {
            Log.w(debugTag, e);
            return "";
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebugTag(String str) {
        debugTag = str;
    }

    public static void setIsDebug(boolean z6) {
        isDebug = z6;
    }

    public static String toStackTraceString(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        if (string.length() > MAX_STACK_TRACE_SIZE) {
            string = string.substring(0, 131047) + " [stack trace too large]";
        }
        printWriter.close();
        return string;
    }

    public static void verbose(String str) {
        verbose("", str);
    }

    public static void warn(Throwable th) {
        warn(toStackTraceString(th));
    }

    public static void debug(Object obj, String str) {
        debug(obj.getClass().getSimpleName(), str);
    }

    public static void error(String str) {
        error("", str);
    }

    public static void verbose(Object obj, String str) {
        verbose(obj.getClass().getSimpleName(), str);
    }

    public static void warn(String str) {
        warn("", str);
    }

    public static void debug(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            String strS = AbstractC0157z.s(sb, (str == null || str.trim().length() == 0) ? "" : ProcessIdUtil.DEFAULT_PROCESSID, str);
            StringBuilder sbR = a.r(str2);
            sbR.append(getTraceElement());
            Log.d(strS, sbR.toString());
        }
    }

    public static void error(Object obj, String str) {
        error(obj.getClass().getSimpleName(), str);
    }

    public static void verbose(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            String strS = AbstractC0157z.s(sb, (str == null || str.trim().length() == 0) ? "" : ProcessIdUtil.DEFAULT_PROCESSID, str);
            StringBuilder sbR = a.r(str2);
            sbR.append(getTraceElement());
            Log.v(strS, sbR.toString());
        }
    }

    public static void warn(Object obj, String str) {
        warn(obj.getClass().getSimpleName(), str);
    }

    public static void error(Object obj, Throwable th) {
        error(obj.getClass().getSimpleName(), toStackTraceString(th));
    }

    public static void warn(Object obj, Throwable th) {
        warn(obj.getClass().getSimpleName(), toStackTraceString(th));
    }

    public static void error(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            String strS = AbstractC0157z.s(sb, (str == null || str.trim().length() == 0) ? "" : ProcessIdUtil.DEFAULT_PROCESSID, str);
            StringBuilder sbR = a.r(str2);
            sbR.append(getTraceElement());
            Log.e(strS, sbR.toString());
        }
    }

    public static void warn(String str, String str2) {
        if (isDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append(debugTag);
            String strS = AbstractC0157z.s(sb, (str == null || str.trim().length() == 0) ? "" : ProcessIdUtil.DEFAULT_PROCESSID, str);
            StringBuilder sbR = a.r(str2);
            sbR.append(getTraceElement());
            Log.w(strS, sbR.toString());
        }
    }
}
