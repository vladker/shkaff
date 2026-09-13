package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MoveToCommand implements MoveToCommandIf {
    private final AdjustPoint pt = new AdjustPoint();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MoveToCommand) {
            return Objects.equals(this.pt, ((MoveToCommand) obj).pt);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.pt);
    }

    @Override // org.apache.poi.sl.draw.geom.MoveToCommandIf
    public void setPt(AdjustPointIf adjustPointIf) {
        if (adjustPointIf != null) {
            this.pt.setX(adjustPointIf.getX());
            this.pt.setY(adjustPointIf.getY());
        }
    }

    @Override // org.apache.poi.sl.draw.geom.MoveToCommandIf
    public AdjustPoint getPt() {
        return this.pt;
    }
}
