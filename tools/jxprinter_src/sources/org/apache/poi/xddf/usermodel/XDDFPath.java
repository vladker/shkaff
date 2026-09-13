package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPath {
    private CTPath2D path;

    @Internal
    public XDDFPath(CTPath2D cTPath2D) {
        this.path = cTPath2D;
    }

    @Internal
    public CTPath2D getXmlObject() {
        return this.path;
    }
}
