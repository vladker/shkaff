package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLblAlgn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AxisLabelAlignment {
    CENTER(STLblAlgn.CTR),
    LEFT(STLblAlgn.f7702L),
    RIGHT(STLblAlgn.f7703R);

    private static final HashMap<STLblAlgn.Enum, AxisLabelAlignment> reverse = new HashMap<>();
    final STLblAlgn.Enum underlying;

    static {
        for (AxisLabelAlignment axisLabelAlignment : values()) {
            reverse.put(axisLabelAlignment.underlying, axisLabelAlignment);
        }
    }

    AxisLabelAlignment(STLblAlgn.Enum r6) {
        this.underlying = r6;
    }

    public static AxisLabelAlignment valueOf(STLblAlgn.Enum r6) {
        return reverse.get(r6);
    }
}
