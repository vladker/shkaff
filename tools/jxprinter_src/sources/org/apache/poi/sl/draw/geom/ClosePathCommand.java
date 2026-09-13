package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClosePathCommand implements ClosePathCommandIf {
    public boolean equals(Object obj) {
        return obj instanceof ClosePathCommand;
    }

    @Override // org.apache.poi.sl.draw.geom.PathCommand
    public void execute(Path2D.Double r6, Context context) {
        r6.closePath();
    }

    public int hashCode() {
        return 790622;
    }
}
