package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum CapsType {
    ALL(STTextCapsType.ALL),
    NONE(STTextCapsType.NONE),
    SMALL(STTextCapsType.SMALL);

    private static final HashMap<STTextCapsType.Enum, CapsType> reverse = new HashMap<>();
    final STTextCapsType.Enum underlying;

    static {
        for (CapsType capsType : values()) {
            reverse.put(capsType.underlying, capsType);
        }
    }

    CapsType(STTextCapsType.Enum r6) {
        this.underlying = r6;
    }

    public static CapsType valueOf(STTextCapsType.Enum r6) {
        return reverse.get(r6);
    }
}
