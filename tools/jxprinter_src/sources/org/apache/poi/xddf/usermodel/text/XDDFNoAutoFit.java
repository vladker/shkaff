package org.apache.poi.xddf.usermodel.text;

import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoAutofit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFNoAutoFit implements XDDFAutoFit {
    private CTTextNoAutofit autofit;

    public XDDFNoAutoFit() {
        this(CTTextNoAutofit.Factory.newInstance());
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
    public CTTextNoAutofit getXmlObject() {
        return this.autofit;
    }

    @Internal
    public XDDFNoAutoFit(CTTextNoAutofit cTTextNoAutofit) {
        this.autofit = cTTextNoAutofit;
    }
}
