package org.apache.logging.log4j.message;

import java.util.Arrays;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ParameterizedMessage implements Message, StringBuilderFormattable {
    private static final int DEFAULT_STRING_BUILDER_SIZE = 255;
    public static final String ERROR_MSG_SEPARATOR = ":";
    public static final String ERROR_PREFIX = "[!!!";
    public static final String ERROR_SEPARATOR = "=>";
    public static final String ERROR_SUFFIX = "!!!]";
    private static final int HASHVAL = 31;
    public static final String RECURSION_PREFIX = "[...";
    public static final String RECURSION_SUFFIX = "...]";
    private static final long serialVersionUID = -665975803997290697L;
    private static ThreadLocal<StringBuilder> threadLocalStringBuilder = new ThreadLocal<>();
    private transient Object[] argArray;
    private String formattedMessage;
    private int[] indices;
    private String messagePattern;
    private transient Throwable throwable;
    private int usedCount;

    @Deprecated
    public ParameterizedMessage(String str, String[] strArr, Throwable th) {
        this.argArray = strArr;
        this.throwable = th;
        init(str);
    }

    public static int countArgumentPlaceholders(String str) {
        return ParameterFormatter.countArgumentPlaceholders(str);
    }

    public static String deepToString(Object obj) {
        return ParameterFormatter.deepToString(obj);
    }

    public static String format(String str, Object[] objArr) {
        return ParameterFormatter.format(str, objArr);
    }

    private static StringBuilder getThreadLocalStringBuilder() {
        StringBuilder sb = threadLocalStringBuilder.get();
        if (sb == null) {
            sb = new StringBuilder(255);
            threadLocalStringBuilder.set(sb);
        }
        sb.setLength(0);
        return sb;
    }

    public static String identityToString(Object obj) {
        return ParameterFormatter.identityToString(obj);
    }

    private void init(String str) {
        this.messagePattern = str;
        int[] iArr = new int[Math.max(1, str == null ? 0 : str.length() >> 1)];
        this.indices = iArr;
        int iCountArgumentPlaceholders2 = ParameterFormatter.countArgumentPlaceholders2(str, iArr);
        initThrowable(this.argArray, iCountArgumentPlaceholders2);
        Object[] objArr = this.argArray;
        this.usedCount = Math.min(iCountArgumentPlaceholders2, objArr != null ? objArr.length : 0);
    }

    private void initThrowable(Object[] objArr, int i5) {
        int length;
        if (objArr == null || i5 >= (length = objArr.length) || this.throwable != null) {
            return;
        }
        Object obj = objArr[length - 1];
        if (obj instanceof Throwable) {
            this.throwable = (Throwable) obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParameterizedMessage parameterizedMessage = (ParameterizedMessage) obj;
        String str = this.messagePattern;
        if (str == null ? parameterizedMessage.messagePattern == null : str.equals(parameterizedMessage.messagePattern)) {
            return Arrays.equals(this.argArray, parameterizedMessage.argArray);
        }
        return false;
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        String str = this.formattedMessage;
        if (str != null) {
            sb.append(str);
            return;
        }
        int[] iArr = this.indices;
        if (iArr[0] < 0) {
            ParameterFormatter.formatMessage(sb, this.messagePattern, this.argArray, this.usedCount);
        } else {
            ParameterFormatter.formatMessage2(sb, this.messagePattern, this.argArray, this.usedCount, iArr);
        }
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.messagePattern;
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        if (this.formattedMessage == null) {
            StringBuilder threadLocalStringBuilder2 = getThreadLocalStringBuilder();
            formatTo(threadLocalStringBuilder2);
            this.formattedMessage = threadLocalStringBuilder2.toString();
            StringBuilders.trimToMaxSize(threadLocalStringBuilder2, Constants.MAX_REUSABLE_MESSAGE_SIZE);
        }
        return this.formattedMessage;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        return this.argArray;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        String str = this.messagePattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Object[] objArr = this.argArray;
        return iHashCode + (objArr != null ? Arrays.hashCode(objArr) : 0);
    }

    public String toString() {
        return "ParameterizedMessage[messagePattern=" + this.messagePattern + ", stringArgs=" + Arrays.toString(this.argArray) + ", throwable=" + this.throwable + ']';
    }

    public ParameterizedMessage(String str, Object[] objArr, Throwable th) {
        this.argArray = objArr;
        this.throwable = th;
        init(str);
    }

    public ParameterizedMessage(String str, Object... objArr) {
        this.argArray = objArr;
        init(str);
    }

    public ParameterizedMessage(String str, Object obj) {
        this(str, obj);
    }

    public ParameterizedMessage(String str, Object obj, Object obj2) {
        this(str, obj, obj2);
    }
}
