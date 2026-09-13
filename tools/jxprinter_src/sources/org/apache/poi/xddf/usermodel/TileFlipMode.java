package org.apache.poi.xddf.usermodel;

import java.util.HashMap;
import org.openxmlformats.schemas.drawingml.x2006.main.STTileFlipMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TileFlipMode {
    NONE(STTileFlipMode.NONE),
    X(STTileFlipMode.f7721X),
    XY(STTileFlipMode.XY),
    Y(STTileFlipMode.f7722Y);

    private static final HashMap<STTileFlipMode.Enum, TileFlipMode> reverse = new HashMap<>();
    final STTileFlipMode.Enum underlying;

    static {
        for (TileFlipMode tileFlipMode : values()) {
            reverse.put(tileFlipMode.underlying, tileFlipMode);
        }
    }

    TileFlipMode(STTileFlipMode.Enum r6) {
        this.underlying = r6;
    }

    public static TileFlipMode valueOf(STTileFlipMode.Enum r6) {
        return reverse.get(r6);
    }
}
