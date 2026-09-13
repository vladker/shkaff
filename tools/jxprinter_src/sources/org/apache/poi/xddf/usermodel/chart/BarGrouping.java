package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarGrouping;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BarGrouping {
    STANDARD(STBarGrouping.STANDARD),
    CLUSTERED(STBarGrouping.CLUSTERED),
    STACKED(STBarGrouping.STACKED),
    PERCENT_STACKED(STBarGrouping.PERCENT_STACKED);

    private static final HashMap<STBarGrouping.Enum, BarGrouping> reverse = new HashMap<>();
    final STBarGrouping.Enum underlying;

    static {
        for (BarGrouping barGrouping : values()) {
            reverse.put(barGrouping.underlying, barGrouping);
        }
    }

    BarGrouping(STBarGrouping.Enum r6) {
        this.underlying = r6;
    }

    public static BarGrouping valueOf(STBarGrouping.Enum r6) {
        return reverse.get(r6);
    }
}
