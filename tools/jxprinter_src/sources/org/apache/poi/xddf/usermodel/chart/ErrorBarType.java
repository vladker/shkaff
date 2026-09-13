package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrBarType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ErrorBarType {
    BOTH(STErrBarType.BOTH),
    MINUS(STErrBarType.MINUS),
    PLUS(STErrBarType.PLUS);

    private static final HashMap<STErrBarType.Enum, ErrorBarType> reverse = new HashMap<>();
    final STErrBarType.Enum underlying;

    static {
        for (ErrorBarType errorBarType : values()) {
            reverse.put(errorBarType.underlying, errorBarType);
        }
    }

    ErrorBarType(STErrBarType.Enum r6) {
        this.underlying = r6;
    }

    public static ErrorBarType valueOf(STErrBarType.Enum r6) {
        return reverse.get(r6);
    }
}
