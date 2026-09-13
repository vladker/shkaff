package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ErrorDirection {
    X(STErrDir.f7700X),
    Y(STErrDir.f7701Y);

    private static final HashMap<STErrDir.Enum, ErrorDirection> reverse = new HashMap<>();
    final STErrDir.Enum underlying;

    static {
        for (ErrorDirection errorDirection : values()) {
            reverse.put(errorDirection.underlying, errorDirection);
        }
    }

    ErrorDirection(STErrDir.Enum r6) {
        this.underlying = r6;
    }

    public static ErrorDirection valueOf(STErrDir.Enum r6) {
        return reverse.get(r6);
    }
}
