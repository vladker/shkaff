package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;
import org.apache.poi.sl.usermodel.PaintStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface PathIf {
    void addCommand(PathCommand pathCommand);

    PaintStyle.PaintModifier getFill();

    long getH();

    Path2D.Double getPath(Context context);

    long getW();

    boolean isExtrusionOk();

    boolean isFilled();

    boolean isStroked();

    void setExtrusionOk(boolean z6);

    void setFill(PaintStyle.PaintModifier paintModifier);

    void setH(long j6);

    void setStroke(boolean z6);

    void setW(long j6);
}
