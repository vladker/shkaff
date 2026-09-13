package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PageOrder {
    DOWN_THEN_OVER(1),
    OVER_THEN_DOWN(2);

    private static PageOrder[] _table = new PageOrder[3];
    private final int order;

    static {
        for (PageOrder pageOrder : values()) {
            _table[pageOrder.getValue()] = pageOrder;
        }
    }

    PageOrder(int i5) {
        this.order = i5;
    }

    public int getValue() {
        return this.order;
    }

    public static PageOrder valueOf(int i5) {
        return _table[i5];
    }
}
