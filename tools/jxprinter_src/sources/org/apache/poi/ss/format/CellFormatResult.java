package org.apache.poi.ss.format;

import java.awt.Color;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellFormatResult {
    public final boolean applies;
    public final String text;
    public final Color textColor;

    public CellFormatResult(boolean z6, String str, Color color) {
        this.applies = z6;
        if (str == null) {
            throw new IllegalArgumentException("CellFormatResult text may not be null");
        }
        this.text = str;
        this.textColor = z6 ? color : null;
    }
}
