package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PrintCellComments {
    NONE(1),
    AS_DISPLAYED(2),
    AT_END(3);

    private static PrintCellComments[] _table = new PrintCellComments[4];
    private int comments;

    static {
        for (PrintCellComments printCellComments : values()) {
            _table[printCellComments.getValue()] = printCellComments;
        }
    }

    PrintCellComments(int i5) {
        this.comments = i5;
    }

    public int getValue() {
        return this.comments;
    }

    public static PrintCellComments valueOf(int i5) {
        return _table[i5];
    }
}
