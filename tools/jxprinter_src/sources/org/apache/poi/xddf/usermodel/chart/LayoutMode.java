package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LayoutMode {
    EDGE(STLayoutMode.EDGE),
    FACTOR(STLayoutMode.FACTOR);

    private static final HashMap<STLayoutMode.Enum, LayoutMode> reverse = new HashMap<>();
    final STLayoutMode.Enum underlying;

    static {
        for (LayoutMode layoutMode : values()) {
            reverse.put(layoutMode.underlying, layoutMode);
        }
    }

    LayoutMode(STLayoutMode.Enum r6) {
        this.underlying = r6;
    }

    public static LayoutMode valueOf(STLayoutMode.Enum r6) {
        return reverse.get(r6);
    }
}
