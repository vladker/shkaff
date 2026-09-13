package org.apache.poi.xddf.usermodel;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPoint2D {
    private CTPoint2D point;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f7263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f7264y;

    public XDDFPoint2D(CTPoint2D cTPoint2D) {
        this.point = cTPoint2D;
    }

    public long getX() {
        CTPoint2D cTPoint2D = this.point;
        return cTPoint2D == null ? this.f7263x : POIXMLUnits.parseLength(cTPoint2D.xgetX());
    }

    public long getY() {
        CTPoint2D cTPoint2D = this.point;
        return cTPoint2D == null ? this.f7264y : POIXMLUnits.parseLength(cTPoint2D.xgetY());
    }

    public XDDFPoint2D(long j6, long j7) {
        this.f7263x = j6;
        this.f7264y = j7;
    }
}
