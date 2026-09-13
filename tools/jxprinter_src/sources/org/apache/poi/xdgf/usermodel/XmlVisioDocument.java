package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XmlVisioDocument extends POIXMLDocument {
    protected XDGFDocument _document;
    protected XDGFMasters _masters;
    protected XDGFPages _pages;

    public XmlVisioDocument(OPCPackage oPCPackage) {
        super(oPCPackage, PackageRelationshipTypes.VISIO_CORE_DOCUMENT);
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                VisioDocumentType visioDocument = VisioDocumentDocument1.Factory.parse(inputStream).getVisioDocument();
                if (inputStream != null) {
                    inputStream.close();
                }
                this._document = new XDGFDocument(visioDocument);
                load(new XDGFFactory(this._document));
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
        } catch (IOException | XmlException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument
    public List<PackagePart> getAllEmbeddedParts() {
        return new ArrayList();
    }

    public Collection<XDGFPage> getPages() {
        return this._pages.getPageList();
    }

    public XDGFStyleSheet getStyleById(long j6) {
        return this._document.getStyleById(j6);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XDGFPages) {
                this._pages = (XDGFPages) pOIXMLDocumentPart;
            } else if (pOIXMLDocumentPart instanceof XDGFMasters) {
                this._masters = (XDGFMasters) pOIXMLDocumentPart;
            }
        }
        XDGFMasters xDGFMasters = this._masters;
        if (xDGFMasters != null) {
            xDGFMasters.onDocumentRead();
        }
        XDGFPages xDGFPages = this._pages;
        if (xDGFPages != null) {
            xDGFPages.onDocumentRead();
        }
    }

    public XmlVisioDocument(InputStream inputStream) {
        this(PackageHelper.open(inputStream));
    }
}
