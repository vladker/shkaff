package org.apache.poi.xddf.usermodel.text;

import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextShapeAutofit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFShapeAutoFit implements XDDFAutoFit {
    private CTTextShapeAutofit autofit;

    public XDDFShapeAutoFit() {
        this(CTTextShapeAutofit.Factory.newInstance());
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFAutoFit
    public int getFontScale() {
        return BZip2Constants.BASEBLOCKSIZE;
    }

    @Override // org.apache.poi.xddf.usermodel.text.XDDFAutoFit
    public int getLineSpaceReduction() {
        return 0;
    }

    @Internal
    public CTTextShapeAutofit getXmlObject() {
        return this.autofit;
    }

    @Internal
    public XDDFShapeAutoFit(CTTextShapeAutofit cTTextShapeAutofit) {
        this.autofit = cTTextShapeAutofit;
    }
}
