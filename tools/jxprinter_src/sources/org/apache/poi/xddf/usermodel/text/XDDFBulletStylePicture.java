package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFPicture;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBulletStylePicture implements XDDFBulletStyle {
    private CTTextBlipBullet style;

    @Internal
    public XDDFBulletStylePicture(CTTextBlipBullet cTTextBlipBullet) {
        this.style = cTTextBlipBullet;
    }

    public XDDFPicture getPicture() {
        return new XDDFPicture(this.style.getBlip());
    }

    @Internal
    public CTTextBlipBullet getXmlObject() {
        return this.style;
    }

    public void setPicture(XDDFPicture xDDFPicture) {
        if (xDDFPicture != null) {
            this.style.setBlip(xDDFPicture.getXmlObject());
        }
    }
}
