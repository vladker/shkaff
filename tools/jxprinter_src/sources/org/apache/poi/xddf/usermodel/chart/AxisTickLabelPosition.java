package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisTickLabelPosition {
    HIGH(STTickLblPos.HIGH),
    LOW(STTickLblPos.LOW),
    NEXT_TO(STTickLblPos.NEXT_TO),
    NONE(STTickLblPos.NONE);

    private static final HashMap<STTickLblPos.Enum, AxisTickLabelPosition> reverse = new HashMap<>();
    final STTickLblPos.Enum underlying;

    static {
        for (AxisTickLabelPosition axisTickLabelPosition : values()) {
            reverse.put(axisTickLabelPosition.underlying, axisTickLabelPosition);
        }
    }

    AxisTickLabelPosition(STTickLblPos.Enum r6) {
        this.underlying = r6;
    }

    public static AxisTickLabelPosition valueOf(STTickLblPos.Enum r6) {
        return reverse.get(r6);
    }
}
