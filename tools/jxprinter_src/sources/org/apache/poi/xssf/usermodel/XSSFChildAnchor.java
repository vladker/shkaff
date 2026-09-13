package org.apache.poi.xssf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFChildAnchor extends XSSFAnchor {
    private CTTransform2D t2d;

    public XSSFChildAnchor(int i5, int i6, int i7, int i8) {
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        this.t2d = cTTransform2DNewInstance;
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        CTPositiveSize2D cTPositiveSize2DAddNewExt = this.t2d.addNewExt();
        cTPoint2DAddNewOff.setX(Integer.valueOf(i5));
        cTPoint2DAddNewOff.setY(Integer.valueOf(i6));
        cTPositiveSize2DAddNewExt.setCx(Math.abs(i7 - i5));
        cTPositiveSize2DAddNewExt.setCy(Math.abs(i8 - i6));
        if (i5 > i7) {
            this.t2d.setFlipH(true);
        }
        if (i6 > i8) {
            this.t2d.setFlipV(true);
        }
    }

    @Internal
    public CTTransform2D getCTTransform2D() {
        return this.t2d;
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx1() {
        return ((Integer) this.t2d.getOff().getX()).intValue();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx2() {
        return (int) (this.t2d.getExt().getCx() + ((long) getDx1()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy1() {
        return ((Integer) this.t2d.getOff().getY()).intValue();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy2() {
        return (int) (this.t2d.getExt().getCy() + ((long) getDy1()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx1(int i5) {
        this.t2d.getOff().setX(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx2(int i5) {
        this.t2d.getExt().setCx(((long) i5) - ((long) getDx1()));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy1(int i5) {
        this.t2d.getOff().setY(Integer.valueOf(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy2(int i5) {
        this.t2d.getExt().setCy(((long) i5) - ((long) getDy1()));
    }

    public XSSFChildAnchor(CTTransform2D cTTransform2D) {
        this.t2d = cTTransform2D;
    }
}
