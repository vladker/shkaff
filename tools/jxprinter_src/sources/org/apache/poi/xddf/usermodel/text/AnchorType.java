package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AnchorType {
    BOTTOM(STTextAnchoringType.f7715B),
    CENTER(STTextAnchoringType.CTR),
    DISTRIBUTED(STTextAnchoringType.DIST),
    JUSTIFIED(STTextAnchoringType.JUST),
    TOP(STTextAnchoringType.f7716T);

    private static final HashMap<STTextAnchoringType.Enum, AnchorType> reverse = new HashMap<>();
    final STTextAnchoringType.Enum underlying;

    static {
        for (AnchorType anchorType : values()) {
            reverse.put(anchorType.underlying, anchorType);
        }
    }

    AnchorType(STTextAnchoringType.Enum r6) {
        this.underlying = r6;
    }

    public static AnchorType valueOf(STTextAnchoringType.Enum r6) {
        return reverse.get(r6);
    }
}
