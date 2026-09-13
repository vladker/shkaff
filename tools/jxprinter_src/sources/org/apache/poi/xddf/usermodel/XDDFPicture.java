package org.apache.poi.xddf.usermodel;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFPicture {
    private CTBlip blip;

    @Internal
    public XDDFPicture(CTBlip cTBlip) {
        this.blip = cTBlip;
    }

    @Internal
    public CTBlip getXmlObject() {
        return this.blip;
    }
}
