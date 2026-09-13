package org.apache.poi.xddf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPositiveSize2D {
    private CTPositiveSize2D size;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f7265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f7266y;

    public XDDFPositiveSize2D(CTPositiveSize2D cTPositiveSize2D) {
        this.size = cTPositiveSize2D;
    }

    public long getX() {
        CTPositiveSize2D cTPositiveSize2D = this.size;
        return cTPositiveSize2D == null ? this.f7265x : cTPositiveSize2D.getCx();
    }

    public long getY() {
        CTPositiveSize2D cTPositiveSize2D = this.size;
        return cTPositiveSize2D == null ? this.f7266y : cTPositiveSize2D.getCy();
    }

    public XDDFPositiveSize2D(long j6, long j7) {
        if (j6 >= 0 && j7 >= 0) {
            this.f7265x = j6;
            this.f7266y = j7;
            return;
        }
        throw new IllegalArgumentException("x and y must be positive");
    }
}
