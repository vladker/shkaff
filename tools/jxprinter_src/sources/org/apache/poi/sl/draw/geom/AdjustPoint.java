package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AdjustPoint implements AdjustPointIf {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f7174x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f7175y;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustPoint)) {
            return false;
        }
        AdjustPoint adjustPoint = (AdjustPoint) obj;
        return Objects.equals(this.f7174x, adjustPoint.f7174x) && Objects.equals(this.f7175y, adjustPoint.f7175y);
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getX() {
        return this.f7174x;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public String getY() {
        return this.f7175y;
    }

    public int hashCode() {
        return Objects.hash(this.f7174x, this.f7175y);
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public boolean isSetX() {
        return this.f7174x != null;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public boolean isSetY() {
        return this.f7175y != null;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public void setX(String str) {
        this.f7174x = str;
    }

    @Override // org.apache.poi.sl.draw.geom.AdjustPointIf
    public void setY(String str) {
        this.f7175y = str;
    }
}
