package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFSpacingPoints extends XDDFSpacing {
    private CTTextSpacingPoint points;

    public XDDFSpacingPoints(double d) {
        this(CTTextSpacing.Factory.newInstance(), CTTextSpacingPoint.Factory.newInstance());
        if (this.spacing.isSetSpcPct()) {
            this.spacing.unsetSpcPct();
        }
        this.spacing.setSpcPts(this.points);
        setPoints(d);
    }

    public double getPoints() {
        return ((double) this.points.getVal()) * 0.01d;
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFSpacing
    public XDDFSpacing.Kind getType() {
        return XDDFSpacing.Kind.POINTS;
    }

    public void setPoints(double d) {
        this.points.setVal((int) (d * 100.0d));
    }

    @Internal
    public XDDFSpacingPoints(CTTextSpacing cTTextSpacing, CTTextSpacingPoint cTTextSpacingPoint) {
        super(cTTextSpacing);
        this.points = cTTextSpacingPoint;
    }
}
