package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface MoveToCommandIf extends PathCommand {
    @Override // org.apache.poi.sl.draw.geom.PathCommand
    default void execute(Path2D.Double r6, Context context) {
        AdjustPointIf pt = getPt();
        r6.moveTo(context.getValue(pt.getX()), context.getValue(pt.getY()));
    }

    AdjustPointIf getPt();

    void setPt(AdjustPointIf adjustPointIf);
}
