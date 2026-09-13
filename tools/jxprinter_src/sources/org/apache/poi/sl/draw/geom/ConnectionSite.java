package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConnectionSite implements ConnectionSiteIf {
    private String ang;
    private final AdjustPoint pos = new AdjustPoint();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionSite)) {
            return false;
        }
        ConnectionSite connectionSite = (ConnectionSite) obj;
        return Objects.equals(this.pos, connectionSite.pos) && Objects.equals(this.ang, connectionSite.ang);
    }

    @Override // org.apache.poi.sl.draw.geom.ConnectionSiteIf
    public String getAng() {
        return this.ang;
    }

    public int hashCode() {
        return Objects.hash(this.pos, this.ang);
    }

    @Override // org.apache.poi.sl.draw.geom.ConnectionSiteIf
    public boolean isSetAng() {
        return this.ang != null;
    }

    @Override // org.apache.poi.sl.draw.geom.ConnectionSiteIf
    public void setAng(String str) {
        this.ang = str;
    }

    @Override // org.apache.poi.sl.draw.geom.ConnectionSiteIf
    public void setPos(AdjustPointIf adjustPointIf) {
        if (adjustPointIf != null) {
            this.pos.setX(adjustPointIf.getX());
            this.pos.setY(adjustPointIf.getY());
        }
    }

    @Override // org.apache.poi.sl.draw.geom.ConnectionSiteIf
    public AdjustPoint getPos() {
        return this.pos;
    }
}
