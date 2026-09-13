package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STGrouping;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum Grouping {
    STANDARD(STGrouping.STANDARD),
    STACKED(STGrouping.STACKED),
    PERCENT_STACKED(STGrouping.PERCENT_STACKED);

    private static final HashMap<STGrouping.Enum, Grouping> reverse = new HashMap<>();
    final STGrouping.Enum underlying;

    static {
        for (Grouping grouping : values()) {
            reverse.put(grouping.underlying, grouping);
        }
    }

    Grouping(STGrouping.Enum r6) {
        this.underlying = r6;
    }

    public static Grouping valueOf(STGrouping.Enum r6) {
        return reverse.get(r6);
    }
}
