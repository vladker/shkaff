package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ReadingOrder {
    CONTEXT,
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT;

    public static ReadingOrder forLong(long j6) {
        if (j6 < 0 || j6 >= values().length) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Invalid ReadingOrder code: "));
        }
        return values()[(int) j6];
    }

    public short getCode() {
        return (short) ordinal();
    }
}
