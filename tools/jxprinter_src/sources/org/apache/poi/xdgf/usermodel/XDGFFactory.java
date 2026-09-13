package org.apache.poi.xdgf.usermodel;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFFactory extends POIXMLFactory {
    private final XDGFDocument document;

    public XDGFFactory(XDGFDocument xDGFDocument) {
        this.document = xDGFDocument;
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLDocumentPart createDocumentPart(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        POIXMLDocumentPart pOIXMLDocumentPartCreateDocumentPart = super.createDocumentPart(pOIXMLDocumentPart, packagePart);
        if (pOIXMLDocumentPartCreateDocumentPart instanceof XDGFXMLDocumentPart) {
            ((XDGFXMLDocumentPart) pOIXMLDocumentPartCreateDocumentPart).setDocument(this.document);
        }
        return pOIXMLDocumentPartCreateDocumentPart;
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLRelation getDescriptor(String str) {
        return XDGFRelation.getInstance(str);
    }

    @Override // org.apache.poi.ooxml.POIXMLFactory
    public POIXMLDocumentPart newDocumentPart(POIXMLRelation pOIXMLRelation) {
        POIXMLDocumentPart pOIXMLDocumentPartNewDocumentPart = super.newDocumentPart(pOIXMLRelation);
        if (pOIXMLDocumentPartNewDocumentPart instanceof XDGFXMLDocumentPart) {
            ((XDGFXMLDocumentPart) pOIXMLDocumentPartNewDocumentPart).setDocument(this.document);
        }
        return pOIXMLDocumentPartNewDocumentPart;
    }
}
