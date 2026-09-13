package org.apache.poi.xddf.usermodel.text;

import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFNormalAutoFit implements XDDFAutoFit {
    private CTTextNormalAutofit autofit;

    public XDDFNormalAutoFit() {
        this(CTTextNormalAutofit.Factory.newInstance());
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFAutoFit
    public int getFontScale() {
        return this.autofit.isSetFontScale() ? POIXMLUnits.parsePercent(this.autofit.xgetFontScale()) : BZip2Constants.BASEBLOCKSIZE;
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFAutoFit
    public int getLineSpaceReduction() {
        if (this.autofit.isSetLnSpcReduction()) {
            return POIXMLUnits.parsePercent(this.autofit.xgetLnSpcReduction());
        }
        return 0;
    }

    @Internal
    public CTTextNormalAutofit getXmlObject() {
        return this.autofit;
    }

    public void setFontScale(Integer num) {
        if (num != null) {
            this.autofit.setFontScale(num);
        } else if (this.autofit.isSetFontScale()) {
            this.autofit.unsetFontScale();
        }
    }

    public void setLineSpaceReduction(Integer num) {
        if (num != null) {
            this.autofit.setLnSpcReduction(num);
        } else if (this.autofit.isSetLnSpcReduction()) {
            this.autofit.unsetLnSpcReduction();
        }
    }

    @Internal
    public XDDFNormalAutoFit(CTTextNormalAutofit cTTextNormalAutofit) {
        this.autofit = cTTextNormalAutofit;
    }
}
