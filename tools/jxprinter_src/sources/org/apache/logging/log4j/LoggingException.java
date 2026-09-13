package org.apache.logging.log4j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LoggingException extends RuntimeException {
    private static final long serialVersionUID = 6366395965071580537L;

    public LoggingException(String str) {
        super(str);
    }

    public LoggingException(String str, Throwable th) {
        super(str, th);
    }

    public LoggingException(Throwable th) {
        super(th);
    }
}
