package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LegendPosition {
    BOTTOM(STLegendPos.f7704B),
    LEFT(STLegendPos.f7705L),
    RIGHT(STLegendPos.f7706R),
    TOP(STLegendPos.f7707T),
    TOP_RIGHT(STLegendPos.TR);

    private static final HashMap<STLegendPos.Enum, LegendPosition> reverse = new HashMap<>();
    final STLegendPos.Enum underlying;

    static {
        for (LegendPosition legendPosition : values()) {
            reverse.put(legendPosition.underlying, legendPosition);
        }
    }

    LegendPosition(STLegendPos.Enum r6) {
        this.underlying = r6;
    }

    public static LegendPosition valueOf(STLegendPos.Enum r6) {
        return reverse.get(r6);
    }
}
