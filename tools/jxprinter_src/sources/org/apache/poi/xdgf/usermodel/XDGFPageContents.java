package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFPageContents extends XDGFBaseContents {
    protected Map<Long, XDGFMaster> _masters;
    protected XDGFPage _page;

    public XDGFPageContents(PackagePart packagePart) {
        super(packagePart);
        this._masters = new HashMap();
    }

    public XDGFMaster getMasterById(long j6) {
        return this._masters.get(Long.valueOf(j6));
    }

    public XDGFPage getPage() {
        return this._page;
    }

    @Override // org.apache.poi.xdgf.usermodel.XDGFBaseContents, org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            try {
                InputStream inputStream = getPackagePart().getInputStream();
                try {
                    this._pageContents = PageContentsDocument.Factory.parse(inputStream).getPageContents();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                        if (pOIXMLDocumentPart instanceof XDGFMasterContents) {
                            XDGFMaster master = ((XDGFMasterContents) pOIXMLDocumentPart).getMaster();
                            if (master == null) {
                                throw new POIXMLException("Master entry is missing in XDGFPageContents");
                            }
                            this._masters.put(Long.valueOf(master.getID()), master);
                        }
                    }
                    super.onDocumentRead();
                    for (XDGFShape xDGFShape : this._shapes.values()) {
                        if (xDGFShape.isTopmost()) {
                            xDGFShape.setupMaster(this, null);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (POIXMLException e) {
                throw XDGFException.wrap(this, e);
            }
        } catch (IOException | XmlException e6) {
            throw new POIXMLException(e6);
        }
    }

    public void setPage(XDGFPage xDGFPage) {
        this._page = xDGFPage;
    }
}
