package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizeFollowText;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFBulletSizeFollowText implements XDDFBulletSize {
    private CTTextBulletSizeFollowText follow;

    public XDDFBulletSizeFollowText() {
        this(CTTextBulletSizeFollowText.Factory.newInstance());
    }

    @Internal
    public CTTextBulletSizeFollowText getXmlObject() {
        return this.follow;
    }

    @Internal
    public XDDFBulletSizeFollowText(CTTextBulletSizeFollowText cTTextBulletSizeFollowText) {
        this.follow = cTTextBulletSizeFollowText;
    }
}
