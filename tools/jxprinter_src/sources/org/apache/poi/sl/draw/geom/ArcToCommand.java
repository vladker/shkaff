package org.apache.poi.sl.draw.geom;

import java.util.Objects;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArcToCommand implements ArcToCommandIf {
    private String hr;
    private String stAng;
    private String swAng;
    private String wr;

    @Internal
    public static double convertOoxml2AwtAngle(double d, double d6, double d7) {
        double d8 = d7 / d6;
        double d9 = -d;
        double d10 = d9 % 360.0d;
        double d11 = d9 - d10;
        int i5 = (int) (d10 / 90.0d);
        if (i5 == -3) {
            d11 -= 360.0d;
            d10 += 360.0d;
        } else if (i5 == -2 || i5 == -1) {
            d11 -= 180.0d;
            d10 += 180.0d;
        } else if (i5 == 1 || i5 == 2) {
            d11 += 180.0d;
            d10 -= 180.0d;
        } else if (i5 == 3) {
            d11 += 360.0d;
            d10 -= 360.0d;
        }
        return Math.toDegrees(Math.atan2(Math.tan(Math.toRadians(d10)), d8)) + d11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArcToCommand)) {
            return false;
        }
        ArcToCommand arcToCommand = (ArcToCommand) obj;
        return Objects.equals(this.wr, arcToCommand.wr) && Objects.equals(this.hr, arcToCommand.hr) && Objects.equals(this.stAng, arcToCommand.stAng) && Objects.equals(this.swAng, arcToCommand.swAng);
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getHR() {
        return this.hr;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getStAng() {
        return this.stAng;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getSwAng() {
        return this.swAng;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public String getWR() {
        return this.wr;
    }

    public int hashCode() {
        return Objects.hash(this.wr, this.hr, this.stAng, this.swAng);
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setHR(String str) {
        this.hr = str;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setStAng(String str) {
        this.stAng = str;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setSwAng(String str) {
        this.swAng = str;
    }

    @Override // org.apache.poi.sl.draw.geom.ArcToCommandIf
    public void setWR(String str) {
        this.wr = str;
    }
}
