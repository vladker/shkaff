package org.apache.poi.sl.draw.geom;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Guide implements GuideIf {
    private String fmla;
    private String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Guide guide = (Guide) obj;
            if (Objects.equals(this.name, guide.name) && Objects.equals(this.fmla, guide.fmla)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public String getFmla() {
        return this.fmla;
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.fmla);
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public void setFmla(String str) {
        this.fmla = str;
    }

    @Override // org.apache.poi.sl.draw.geom.GuideIf
    public void setName(String str) {
        this.name = str;
    }
}
