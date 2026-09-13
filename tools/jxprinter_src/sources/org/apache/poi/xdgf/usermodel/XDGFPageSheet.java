package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFPageSheet extends XDGFSheet {
    PageSheetType _pageSheet;

    public XDGFPageSheet(PageSheetType pageSheetType, XDGFDocument xDGFDocument) {
        super(pageSheetType, xDGFDocument);
        this._pageSheet = pageSheetType;
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFSheet
    public PageSheetType getXmlObject() {
        return this._pageSheet;
    }
}
