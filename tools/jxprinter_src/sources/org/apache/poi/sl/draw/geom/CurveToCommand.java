package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CurveToCommand implements CurveToCommandIf {
    private final AdjustPoint pt1 = new AdjustPoint();
    private final AdjustPoint pt2 = new AdjustPoint();
    private final AdjustPoint pt3 = new AdjustPoint();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurveToCommand)) {
            return false;
        }
        CurveToCommand curveToCommand = (CurveToCommand) obj;
        return Objects.equals(this.pt1, curveToCommand.pt1) && Objects.equals(this.pt2, curveToCommand.pt2) && Objects.equals(this.pt3, curveToCommand.pt3);
    }

    public int hashCode() {
        return Objects.hash(this.pt1, this.pt2, this.pt3);
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt1(AdjustPointIf adjustPointIf) {
        if (adjustPointIf != null) {
            this.pt1.setX(adjustPointIf.getX());
            this.pt1.setY(adjustPointIf.getY());
        }
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt2(AdjustPointIf adjustPointIf) {
        if (adjustPointIf != null) {
            this.pt2.setX(adjustPointIf.getX());
            this.pt2.setY(adjustPointIf.getY());
        }
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public void setPt3(AdjustPointIf adjustPointIf) {
        if (adjustPointIf != null) {
            this.pt3.setX(adjustPointIf.getX());
            this.pt3.setY(adjustPointIf.getY());
        }
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public AdjustPoint getPt1() {
        return this.pt1;
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public AdjustPoint getPt2() {
        return this.pt2;
    }

    @Override // org.apache.poi.sl.draw.geom.CurveToCommandIf
    public AdjustPoint getPt3() {
        return this.pt3;
    }
}
