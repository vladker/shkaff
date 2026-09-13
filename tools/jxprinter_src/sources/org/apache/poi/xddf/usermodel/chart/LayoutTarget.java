package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLayoutTarget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum LayoutTarget {
    INNER(STLayoutTarget.INNER),
    OUTER(STLayoutTarget.OUTER);

    private static final HashMap<STLayoutTarget.Enum, LayoutTarget> reverse = new HashMap<>();
    final STLayoutTarget.Enum underlying;

    static {
        for (LayoutTarget layoutTarget : values()) {
            reverse.put(layoutTarget.underlying, layoutTarget);
        }
    }

    LayoutTarget(STLayoutTarget.Enum r6) {
        this.underlying = r6;
    }

    public static LayoutTarget valueOf(STLayoutTarget.Enum r6) {
        return reverse.get(r6);
    }
}
