package org.apache.poi.xdgf.usermodel;

import javax.xml.stream.XMLStreamReader;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.apache.poi.xslf.model.TextBodyPropertyFetcher;
import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
import org.apache.poi.xslf.usermodel.XSLFComments;
import org.apache.poi.xslf.usermodel.XSLFDiagramDrawing;
import org.apache.poi.xslf.usermodel.XSLFFontData;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFNotesMaster;
import org.apache.poi.xslf.usermodel.XSLFObjectData;
import org.apache.poi.xslf.usermodel.XSLFObjectShape;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTableStyles;
import org.apache.poi.xslf.usermodel.XSLFTheme;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements POIXMLRelation.PackagePartConstructor, ShapeVisitorAcceptor, XSLFShape.ReparseFactory, POIXMLRelation.NoArgConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7276a;

    public /* synthetic */ a(int i5) {
        this.f7276a = i5;
    }

    @Override // org.apache.poi.xdgf.usermodel.shape.ShapeVisitorAcceptor
    public boolean accept(XDGFShape xDGFShape) {
        return ShapeVisitor.lambda$getAcceptor$0(xDGFShape);
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.NoArgConstructor
    public POIXMLDocumentPart init() {
        switch (this.f7276a) {
            case 8:
                return new XSLFNotes();
            case 11:
                return new XSLFPictureData();
            case 13:
                return new XSLFSlide();
            case 16:
                return new XSLFTableStyles();
            case 18:
                return new XSLFObjectData();
            case 19:
                return new XSLFCommentAuthors();
            case 21:
                return new XSLFFontData();
            case 24:
                return new XSLFNotesMaster();
            case 26:
                return new XSLFComments();
            default:
                return new XSLFTheme();
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape.ReparseFactory
    public XmlObject parse(XMLStreamReader xMLStreamReader) {
        switch (this.f7276a) {
            case 4:
                return ParagraphPropertyFetcher.parse(xMLStreamReader);
            case 5:
                return TextBodyPropertyFetcher.parse(xMLStreamReader);
            case 6:
                return XSLFObjectShape.parse(xMLStreamReader);
            default:
                return XSLFPictureShape.parse(xMLStreamReader);
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.PackagePartConstructor
    public POIXMLDocumentPart init(PackagePart packagePart) {
        switch (this.f7276a) {
            case 0:
                return new XDGFMasterContents(packagePart);
            case 1:
                return new XDGFPages(packagePart);
            case 2:
                return new XDGFPageContents(packagePart);
            case 9:
                return new XSLFDiagramDrawing(packagePart);
            case 10:
                return new XSLFNotes(packagePart);
            case 12:
                return new XSLFPictureData(packagePart);
            case 14:
                return new XSLFSlide(packagePart);
            case 15:
                return new XSLFSlideLayout(packagePart);
            case 17:
                return new XSLFTableStyles(packagePart);
            case 20:
                return new XSLFObjectData(packagePart);
            case 22:
                return new XSLFFontData(packagePart);
            case 23:
                return new XSLFSlideMaster(packagePart);
            case 25:
                return new XSLFNotesMaster(packagePart);
            case 27:
                return new XSLFComments(packagePart);
            default:
                return new XSLFCommentAuthors(packagePart);
        }
    }
}
