package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STScatterStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ScatterStyle {
    LINE(STScatterStyle.LINE),
    LINE_MARKER(STScatterStyle.LINE_MARKER),
    MARKER(STScatterStyle.MARKER),
    NONE(STScatterStyle.NONE),
    SMOOTH(STScatterStyle.SMOOTH),
    SMOOTH_MARKER(STScatterStyle.SMOOTH_MARKER);

    private static final HashMap<STScatterStyle.Enum, ScatterStyle> reverse = new HashMap<>();
    final STScatterStyle.Enum underlying;

    static {
        for (ScatterStyle scatterStyle : values()) {
            reverse.put(scatterStyle.underlying, scatterStyle);
        }
    }

    ScatterStyle(STScatterStyle.Enum r6) {
        this.underlying = r6;
    }

    public static ScatterStyle valueOf(STScatterStyle.Enum r6) {
        return reverse.get(r6);
    }
}
