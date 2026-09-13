package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CurveToCommandIf extends PathCommand {
    @Override // org.apache.poi.sl.draw.geom.PathCommand
    default void execute(Path2D.Double r17, Context context) {
        AdjustPointIf pt1 = getPt1();
        double value = context.getValue(pt1.getX());
        double value2 = context.getValue(pt1.getY());
        AdjustPointIf pt2 = getPt2();
        double value3 = context.getValue(pt2.getX());
        double value4 = context.getValue(pt2.getY());
        AdjustPointIf pt3 = getPt3();
        r17.curveTo(value, value2, value3, value4, context.getValue(pt3.getX()), context.getValue(pt3.getY()));
    }

    AdjustPointIf getPt1();

    AdjustPointIf getPt2();

    AdjustPointIf getPt3();

    void setPt1(AdjustPointIf adjustPointIf);

    void setPt2(AdjustPointIf adjustPointIf);

    void setPt3(AdjustPointIf adjustPointIf);
}
