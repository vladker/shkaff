package org.apache.poi.ss.usermodel;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellCopyContext {
    private final Map<CellStyle, CellStyle> styleMap = new HashMap();

    public CellStyle getMappedStyle(CellStyle cellStyle) {
        return this.styleMap.get(cellStyle);
    }

    public void putMappedStyle(CellStyle cellStyle, CellStyle cellStyle2) {
        this.styleMap.put(cellStyle, cellStyle2);
    }
}
