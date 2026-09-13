package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickMark;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisTickMark {
    CROSS(STTickMark.CROSS),
    IN(STTickMark.IN),
    NONE(STTickMark.NONE),
    OUT(STTickMark.OUT);

    private static final HashMap<STTickMark.Enum, AxisTickMark> reverse = new HashMap<>();
    final STTickMark.Enum underlying;

    static {
        for (AxisTickMark axisTickMark : values()) {
            reverse.put(axisTickMark.underlying, axisTickMark);
        }
    }

    AxisTickMark(STTickMark.Enum r6) {
        this.underlying = r6;
    }

    public static AxisTickMark valueOf(STTickMark.Enum r6) {
        return reverse.get(r6);
    }
}
