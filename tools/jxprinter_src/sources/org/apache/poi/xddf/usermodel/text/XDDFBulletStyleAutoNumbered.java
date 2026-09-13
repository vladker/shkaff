package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBulletStyleAutoNumbered implements XDDFBulletStyle {
    private CTTextAutonumberBullet style;

    @Internal
    public XDDFBulletStyleAutoNumbered(CTTextAutonumberBullet cTTextAutonumberBullet) {
        this.style = cTTextAutonumberBullet;
    }

    public int getStartAt() {
        if (this.style.isSetStartAt()) {
            return this.style.getStartAt();
        }
        return 1;
    }

    public AutonumberScheme getType() {
        return AutonumberScheme.valueOf(this.style.getType());
    }

    @Internal
    public CTTextAutonumberBullet getXmlObject() {
        return this.style;
    }

    public void setStartAt(Integer num) {
        if (num != null) {
            this.style.setStartAt(num.intValue());
        } else if (this.style.isSetStartAt()) {
            this.style.unsetStartAt();
        }
    }

    public void setType(AutonumberScheme autonumberScheme) {
        this.style.setType(autonumberScheme.underlying);
    }
}
