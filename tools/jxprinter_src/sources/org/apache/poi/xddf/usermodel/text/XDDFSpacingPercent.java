package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPercent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFSpacingPercent extends XDDFSpacing {
    private CTTextSpacingPercent percent;
    private Double scale;

    public XDDFSpacingPercent(double d) {
        this(CTTextSpacing.Factory.newInstance(), CTTextSpacingPercent.Factory.newInstance(), null);
        if (this.spacing.isSetSpcPts()) {
            this.spacing.unsetSpcPts();
        }
        this.spacing.setSpcPct(this.percent);
        setPercent(d);
    }

    public double getPercent() {
        return this.scale.doubleValue() * ((double) POIXMLUnits.parsePercent(this.percent.xgetVal()));
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFSpacing
    public XDDFSpacing.Kind getType() {
        return XDDFSpacing.Kind.PERCENT;
    }

    public void setPercent(double d) {
        this.percent.setVal(Integer.valueOf((int) (d * 1000.0d)));
    }

    @Internal
    public XDDFSpacingPercent(CTTextSpacing cTTextSpacing, CTTextSpacingPercent cTTextSpacingPercent, Double d) {
        super(cTTextSpacing);
        this.percent = cTTextSpacingPercent;
        this.scale = Double.valueOf(d != null ? 0.001d * d.doubleValue() : 0.001d);
    }
}
