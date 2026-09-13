package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.exceptions.XDGFException;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFPages extends XDGFXMLDocumentPart {
    List<XDGFPage> _pages;
    PagesType _pagesObject;

    public XDGFPages(PackagePart packagePart) {
        super(packagePart);
        this._pages = new ArrayList();
    }

    public List<XDGFPage> getPageList() {
        return Collections.unmodifiableList(this._pages);
    }

    @Internal
    public PagesType getXmlObject() {
        return this._pagesObject;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        try {
            try {
                InputStream inputStream = getPackagePart().getInputStream();
                try {
                    this._pagesObject = PagesDocument.Factory.parse(inputStream).getPages();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    for (PageType pageType : this._pagesObject.getPageArray()) {
                        String id = pageType.getRel().getId();
                        POIXMLDocumentPart relationById = getRelationById(id);
                        if (relationById == null) {
                            throw new POIXMLException("PageSettings relationship for " + id + " not found");
                        }
                        if (!(relationById instanceof XDGFPageContents)) {
                            throw new POIXMLException("Unexpected pages relationship for " + id + ": " + relationById);
                        }
                        XDGFPageContents xDGFPageContents = (XDGFPageContents) relationById;
                        XDGFPage xDGFPage = new XDGFPage(pageType, xDGFPageContents, this._document, this);
                        xDGFPageContents.onDocumentRead();
                        this._pages.add(xDGFPage);
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
}
