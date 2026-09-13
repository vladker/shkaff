package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFColorSystemDefined extends XDDFColor {
    private CTSystemColor color;

    public XDDFColorSystemDefined(SystemColor systemColor) {
        this(CTSystemColor.Factory.newInstance(), CTColor.Factory.newInstance());
        setValue(systemColor);
    }

    public byte[] getLastColor() {
        if (this.color.isSetLastClr()) {
            return this.color.getLastClr();
        }
        return null;
    }

    public SystemColor getValue() {
        return SystemColor.valueOf(this.color.getVal());
    }

    @Override // org.apache.poi.xddf.usermodel.XDDFColor
    @Internal
    public XmlObject getXmlObject() {
        return this.color;
    }

    public void setLastColor(byte[] bArr) {
        if (bArr != null) {
            this.color.setLastClr(bArr);
        } else if (this.color.isSetLastClr()) {
            this.color.unsetLastClr();
        }
    }

    public void setValue(SystemColor systemColor) {
        this.color.setVal(systemColor.underlying);
    }

    @Internal
    public XDDFColorSystemDefined(CTSystemColor cTSystemColor) {
        this(cTSystemColor, null);
    }

    @Internal
    public XDDFColorSystemDefined(CTSystemColor cTSystemColor, CTColor cTColor) {
        super(cTColor);
        this.color = cTSystemColor;
    }
}
