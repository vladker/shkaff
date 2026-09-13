package org.apache.poi.xdgf.extractor;

import java.util.Iterator;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeTextVisitor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFVisioExtractor implements POIXMLTextExtractor {
    private boolean doCloseFilesystem;
    protected final XmlVisioDocument document;

    public XDGFVisioExtractor(XmlVisioDocument xmlVisioDocument) {
        this.doCloseFilesystem = true;
        this.document = xmlVisioDocument;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        ShapeTextVisitor shapeTextVisitor = new ShapeTextVisitor();
        Iterator<XDGFPage> it = this.document.getPages().iterator();
        while (it.hasNext()) {
            it.next().getContent().visitShapes(shapeTextVisitor);
        }
        return shapeTextVisitor.getText();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public XmlVisioDocument getFilesystem() {
        return this.document;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public XmlVisioDocument getDocument() {
        return this.document;
    }

    public XDGFVisioExtractor(OPCPackage oPCPackage) {
        this(new XmlVisioDocument(oPCPackage));
    }
}
