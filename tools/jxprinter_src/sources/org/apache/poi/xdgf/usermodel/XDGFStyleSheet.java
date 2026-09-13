package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFStyleSheet extends XDGFSheet {
    public XDGFStyleSheet(StyleSheetType styleSheetType, XDGFDocument xDGFDocument) {
        super(styleSheetType, xDGFDocument);
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    @Internal
    public StyleSheetType getXmlObject() {
        return (StyleSheetType) this._sheet;
    }
}
