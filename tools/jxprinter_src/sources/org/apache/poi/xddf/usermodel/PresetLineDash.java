package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum PresetLineDash {
    DASH(STPresetLineDashVal.DASH),
    DASH_DOT(STPresetLineDashVal.DASH_DOT),
    DOT(STPresetLineDashVal.DOT),
    LARGE_DASH(STPresetLineDashVal.LG_DASH),
    LARGE_DASH_DOT(STPresetLineDashVal.LG_DASH_DOT),
    LARGE_DASH_DOT_DOT(STPresetLineDashVal.LG_DASH_DOT_DOT),
    SOLID(STPresetLineDashVal.SOLID),
    SYSTEM_DASH(STPresetLineDashVal.SYS_DASH),
    SYSTEM_DASH_DOT(STPresetLineDashVal.SYS_DASH_DOT),
    SYSTEM_DASH_DOT_DOT(STPresetLineDashVal.SYS_DASH_DOT_DOT),
    SYSTEM_DOT(STPresetLineDashVal.SYS_DOT);

    private static final HashMap<STPresetLineDashVal.Enum, PresetLineDash> reverse = new HashMap<>();
    final STPresetLineDashVal.Enum underlying;

    static {
        for (PresetLineDash presetLineDash : values()) {
            reverse.put(presetLineDash.underlying, presetLineDash);
        }
    }

    PresetLineDash(STPresetLineDashVal.Enum r6) {
        this.underlying = r6;
    }

    public static PresetLineDash valueOf(STPresetLineDashVal.Enum r6) {
        return reverse.get(r6);
    }
}
