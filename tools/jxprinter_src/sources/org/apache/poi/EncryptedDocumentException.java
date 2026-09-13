package org.apache.poi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EncryptedDocumentException extends IllegalStateException {
    private static final long serialVersionUID = 7276950444540469193L;

    public EncryptedDocumentException(String str) {
        super(str);
    }

    public EncryptedDocumentException(String str, Throwable th) {
        super(str, th);
    }

    public EncryptedDocumentException(Throwable th) {
        super(th);
    }
}
