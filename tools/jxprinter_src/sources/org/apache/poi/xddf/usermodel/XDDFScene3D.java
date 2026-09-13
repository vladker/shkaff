package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFScene3D {
    private CTScene3D scene;

    public XDDFScene3D(CTScene3D cTScene3D) {
        this.scene = cTScene3D;
    }

    @Internal
    public CTScene3D getXmlObject() {
        return this.scene;
    }
}
