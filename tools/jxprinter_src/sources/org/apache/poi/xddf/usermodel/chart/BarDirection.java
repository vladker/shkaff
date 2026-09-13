package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum BarDirection {
    BAR(STBarDir.BAR),
    COL(STBarDir.COL);

    private static final HashMap<STBarDir.Enum, BarDirection> reverse = new HashMap<>();
    final STBarDir.Enum underlying;

    static {
        for (BarDirection barDirection : values()) {
            reverse.put(barDirection.underlying, barDirection);
        }
    }

    BarDirection(STBarDir.Enum r6) {
        this.underlying = r6;
    }

    public static BarDirection valueOf(STBarDir.Enum r6) {
        return reverse.get(r6);
    }
}
