package org.apache.poi.hssf.eventusermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFUserException extends Exception {
    private Throwable reason;

    public HSSFUserException() {
    }

    public Throwable getReason() {
        return this.reason;
    }

    public HSSFUserException(String str) {
        super(str);
    }

    public HSSFUserException(Throwable th) {
        this.reason = th;
    }

    public HSSFUserException(String str, Throwable th) {
        super(str);
        this.reason = th;
    }
}
