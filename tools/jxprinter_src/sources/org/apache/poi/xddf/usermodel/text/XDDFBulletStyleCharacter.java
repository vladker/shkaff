package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBulletStyleCharacter implements XDDFBulletStyle {
    private CTTextCharBullet style;

    @Internal
    public XDDFBulletStyleCharacter(CTTextCharBullet cTTextCharBullet) {
        this.style = cTTextCharBullet;
    }

    public String getCharacter() {
        return this.style.getChar();
    }

    @Internal
    public CTTextCharBullet getXmlObject() {
        return this.style;
    }

    public void setCharacter(String str) {
        this.style.setChar(str);
    }
}
