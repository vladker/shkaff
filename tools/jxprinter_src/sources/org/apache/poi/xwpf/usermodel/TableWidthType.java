package org.apache.poi.xwpf.usermodel;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TableWidthType {
    AUTO(STTblWidth.AUTO),
    DXA(STTblWidth.DXA),
    NIL(STTblWidth.NIL),
    PCT(STTblWidth.PCT);

    private STTblWidth.Enum type;

    TableWidthType(STTblWidth.Enum r6) {
        SimpleTypeFactory<STTblWidth> simpleTypeFactory = STTblWidth.Factory;
        this.type = r6;
    }

    @Internal
    public STTblWidth.Enum getStWidthType() {
        return this.type;
    }
}
