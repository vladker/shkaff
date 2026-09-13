package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisOrientation {
    MIN_MAX(STOrientation.MIN_MAX),
    MAX_MIN(STOrientation.MAX_MIN);

    private static final HashMap<STOrientation.Enum, AxisOrientation> reverse = new HashMap<>();
    final STOrientation.Enum underlying;

    static {
        for (AxisOrientation axisOrientation : values()) {
            reverse.put(axisOrientation.underlying, axisOrientation);
        }
    }

    AxisOrientation(STOrientation.Enum r6) {
        this.underlying = r6;
    }

    public static AxisOrientation valueOf(STOrientation.Enum r6) {
        return reverse.get(r6);
    }
}
