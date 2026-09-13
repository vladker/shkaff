package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentFormatException extends RuntimeException {
    public DocumentFormatException(String str) {
        super(str);
    }

    public static void check(boolean z6, String str) {
        if (!z6) {
            throw new DocumentFormatException(str);
        }
    }

    public DocumentFormatException(String str, Throwable th) {
        super(str, th);
    }

    public DocumentFormatException(Throwable th) {
        super(th);
    }
}
