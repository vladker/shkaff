package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PrintOrientation {
    DEFAULT(1),
    PORTRAIT(2),
    LANDSCAPE(3);

    private static PrintOrientation[] _table = new PrintOrientation[4];
    private int orientation;

    static {
        for (PrintOrientation printOrientation : values()) {
            _table[printOrientation.getValue()] = printOrientation;
        }
    }

    PrintOrientation(int i5) {
        this.orientation = i5;
    }

    public int getValue() {
        return this.orientation;
    }

    public static PrintOrientation valueOf(int i5) {
        return _table[i5];
    }
}
