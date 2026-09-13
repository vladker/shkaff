package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STRadarStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum RadarStyle {
    FILLED(STRadarStyle.FILLED),
    MARKER(STRadarStyle.MARKER),
    STANDARD(STRadarStyle.STANDARD);

    private static final HashMap<STRadarStyle.Enum, RadarStyle> reverse = new HashMap<>();
    final STRadarStyle.Enum underlying;

    static {
        for (RadarStyle radarStyle : values()) {
            reverse.put(radarStyle.underlying, radarStyle);
        }
    }

    RadarStyle(STRadarStyle.Enum r6) {
        this.underlying = r6;
    }

    public static RadarStyle valueOf(STRadarStyle.Enum r6) {
        return reverse.get(r6);
    }
}
