package org.apache.poi.xddf.usermodel.text;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextTabAlignType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TabAlignment {
    CENTER(STTextTabAlignType.CTR),
    DECIMAL(STTextTabAlignType.DEC),
    LEFT(STTextTabAlignType.f7719L),
    RIGHT(STTextTabAlignType.f7720R);

    private static final HashMap<STTextTabAlignType.Enum, TabAlignment> reverse = new HashMap<>();
    final STTextTabAlignType.Enum underlying;

    static {
        for (TabAlignment tabAlignment : values()) {
            reverse.put(tabAlignment.underlying, tabAlignment);
        }
    }

    TabAlignment(STTextTabAlignType.Enum r6) {
        this.underlying = r6;
    }

    public static TabAlignment valueOf(STTextTabAlignType.Enum r6) {
        return reverse.get(r6);
    }
}
