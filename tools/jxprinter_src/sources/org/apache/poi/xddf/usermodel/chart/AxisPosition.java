package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisPosition {
    BOTTOM(STAxPos.f7692B),
    LEFT(STAxPos.f7693L),
    RIGHT(STAxPos.f7694R),
    TOP(STAxPos.f7695T);

    private static final HashMap<STAxPos.Enum, AxisPosition> reverse = new HashMap<>();
    final STAxPos.Enum underlying;

    static {
        for (AxisPosition axisPosition : values()) {
            reverse.put(axisPosition.underlying, axisPosition);
        }
    }

    AxisPosition(STAxPos.Enum r6) {
        this.underlying = r6;
    }

    public static AxisPosition valueOf(STAxPos.Enum r6) {
        return reverse.get(r6);
    }
}
