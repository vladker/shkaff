package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ConditionType {
    public final byte id;
    public final String type;
    private static Map<Integer, ConditionType> lookup = new HashMap();
    public static final ConditionType CELL_VALUE_IS = new ConditionType(1, "cellIs");
    public static final ConditionType FORMULA = new ConditionType(2, "expression");
    public static final ConditionType COLOR_SCALE = new ConditionType(3, "colorScale");
    public static final ConditionType DATA_BAR = new ConditionType(4, "dataBar");
    public static final ConditionType FILTER = new ConditionType(5, null);
    public static final ConditionType ICON_SET = new ConditionType(6, "iconSet");

    private ConditionType(int i5, String str) {
        this.id = (byte) i5;
        this.type = str;
        lookup.put(Integer.valueOf(i5), this);
    }

    public static ConditionType forId(byte b) {
        return forId((int) b);
    }

    public String toString() {
        return ((int) this.id) + " - " + this.type;
    }

    public static ConditionType forId(int i5) {
        return lookup.get(Integer.valueOf(i5));
    }
}
