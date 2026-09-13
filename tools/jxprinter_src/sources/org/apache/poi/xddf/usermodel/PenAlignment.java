package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PenAlignment {
    CENTER(STPenAlignment.CTR),
    IN(STPenAlignment.IN);

    private static final HashMap<STPenAlignment.Enum, PenAlignment> reverse = new HashMap<>();
    final STPenAlignment.Enum underlying;

    static {
        for (PenAlignment penAlignment : values()) {
            reverse.put(penAlignment.underlying, penAlignment);
        }
    }

    PenAlignment(STPenAlignment.Enum r6) {
        this.underlying = r6;
    }

    public static PenAlignment valueOf(STPenAlignment.Enum r6) {
        return reverse.get(r6);
    }
}
