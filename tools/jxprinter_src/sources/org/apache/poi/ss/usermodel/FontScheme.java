package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontScheme {
    NONE(1),
    MAJOR(2),
    MINOR(3);

    private final int value;
    private static final FontScheme[] _table = {null, NONE, MAJOR, MINOR};

    FontScheme(int i5) {
        this.value = i5;
    }

    public int getValue() {
        return this.value;
    }

    public static FontScheme valueOf(int i5) {
        return _table[i5];
    }
}
