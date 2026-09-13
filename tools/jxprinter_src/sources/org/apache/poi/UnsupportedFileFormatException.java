package org.apache.poi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsupportedFileFormatException extends IllegalArgumentException {
    private static final long serialVersionUID = -8281969197282030046L;

    public UnsupportedFileFormatException(String str) {
        super(str);
    }

    public UnsupportedFileFormatException(String str, Throwable th) {
        super(str, th);
    }
}
