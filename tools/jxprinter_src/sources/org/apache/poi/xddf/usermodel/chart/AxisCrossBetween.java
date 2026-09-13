package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STCrossBetween;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisCrossBetween {
    BETWEEN(STCrossBetween.BETWEEN),
    MIDPOINT_CATEGORY(STCrossBetween.MID_CAT);

    private static final HashMap<STCrossBetween.Enum, AxisCrossBetween> reverse = new HashMap<>();
    final STCrossBetween.Enum underlying;

    static {
        for (AxisCrossBetween axisCrossBetween : values()) {
            reverse.put(axisCrossBetween.underlying, axisCrossBetween);
        }
    }

    AxisCrossBetween(STCrossBetween.Enum r6) {
        this.underlying = r6;
    }

    public static AxisCrossBetween valueOf(STCrossBetween.Enum r6) {
        return reverse.get(r6);
    }
}
