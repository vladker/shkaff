package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STMarkerStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum MarkerStyle {
    CIRCLE(STMarkerStyle.CIRCLE),
    DASH(STMarkerStyle.DASH),
    DIAMOND(STMarkerStyle.DIAMOND),
    DOT(STMarkerStyle.DOT),
    NONE(STMarkerStyle.NONE),
    PICTURE(STMarkerStyle.PICTURE),
    PLUS(STMarkerStyle.PLUS),
    SQUARE(STMarkerStyle.SQUARE),
    STAR(STMarkerStyle.STAR),
    TRIANGLE(STMarkerStyle.TRIANGLE),
    X(STMarkerStyle.f7708X);

    private static final HashMap<STMarkerStyle.Enum, MarkerStyle> reverse = new HashMap<>();
    final STMarkerStyle.Enum underlying;

    static {
        for (MarkerStyle markerStyle : values()) {
            reverse.put(markerStyle.underlying, markerStyle);
        }
    }

    MarkerStyle(STMarkerStyle.Enum r6) {
        this.underlying = r6;
    }

    public static MarkerStyle valueOf(STMarkerStyle.Enum r6) {
        return reverse.get(r6);
    }
}
