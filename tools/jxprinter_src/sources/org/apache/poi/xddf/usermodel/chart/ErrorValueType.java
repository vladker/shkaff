package org.apache.poi.xddf.usermodel.chart;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrValType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum ErrorValueType {
    CUSTOM(STErrValType.CUST),
    FIXED_VALUE(STErrValType.FIXED_VAL),
    PERCENTAGE(STErrValType.PERCENTAGE),
    STANDARD_DEVIATION(STErrValType.STD_DEV),
    STANDARD_ERROR(STErrValType.STD_ERR);

    private static final HashMap<STErrValType.Enum, ErrorValueType> reverse = new HashMap<>();
    final STErrValType.Enum underlying;

    static {
        for (ErrorValueType errorValueType : values()) {
            reverse.put(errorValueType.underlying, errorValueType);
        }
    }

    ErrorValueType(STErrValType.Enum r6) {
        this.underlying = r6;
    }

    public static ErrorValueType valueOf(STErrValType.Enum r6) {
        return reverse.get(r6);
    }
}
