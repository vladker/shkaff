package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RecordFormatException extends RuntimeException {
    public RecordFormatException(String str) {
        super(str);
    }

    public static void check(boolean z6, String str) {
        if (!z6) {
            throw new RecordFormatException(str);
        }
    }

    public RecordFormatException(String str, Throwable th) {
        super(str, th);
    }

    public RecordFormatException(Throwable th) {
        super(th);
    }
}
