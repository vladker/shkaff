package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Notes;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.util.NotImplemented;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShapeNonVisual;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSLFSlide extends XSLFSheet implements Slide<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private XSLFCommentAuthors _commentAuthors;
    private XSLFComments _comments;
    private XSLFSlideLayout _layout;
    private XSLFNotes _notes;
    private final CTSlide _slide;

    public XSLFSlide() {
        this._slide = prototype();
    }

    private static CTSlide prototype() {
        CTSlide cTSlideNewInstance = CTSlide.Factory.newInstance();
        CTGroupShape cTGroupShapeAddNewSpTree = cTSlideNewInstance.addNewCSld().addNewSpTree();
        CTGroupShapeNonVisual cTGroupShapeNonVisualAddNewNvGrpSpPr = cTGroupShapeAddNewSpTree.addNewNvGrpSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
        cTNonVisualDrawingPropsAddNewCNvPr.setName("");
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewCNvGrpSpPr();
        cTGroupShapeNonVisualAddNewNvGrpSpPr.addNewNvPr();
        CTGroupTransform2D cTGroupTransform2DAddNewXfrm = cTGroupShapeAddNewSpTree.addNewGrpSpPr().addNewXfrm();
        CTPoint2D cTPoint2DAddNewOff = cTGroupTransform2DAddNewXfrm.addNewOff();
        cTPoint2DAddNewOff.setX(0);
        cTPoint2DAddNewOff.setY(0);
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTGroupTransform2DAddNewXfrm.addNewExt();
        cTPositiveSize2DAddNewExt.setCx(0L);
        cTPositiveSize2DAddNewExt.setCy(0L);
        CTPoint2D cTPoint2DAddNewChOff = cTGroupTransform2DAddNewXfrm.addNewChOff();
        cTPoint2DAddNewChOff.setX(0);
        cTPoint2DAddNewChOff.setY(0);
        CTPositiveSize2D cTPositiveSize2DAddNewChExt = cTGroupTransform2DAddNewXfrm.addNewChExt();
        cTPositiveSize2DAddNewChExt.setCx(0L);
        cTPositiveSize2DAddNewChExt.setCy(0L);
        cTSlideNewInstance.addNewClrMapOvr().addNewMasterClrMapping();
        return cTSlideNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public void draw(Graphics2D graphics2D) {
        DrawFactory.getInstance(graphics2D).getDrawable((Slide<?, ?>) this).draw(graphics2D);
    }

    public XSLFCommentAuthors getCommentAuthorsPart() {
        if (this._commentAuthors != null) {
            return null;
        }
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFCommentAuthors) {
                XSLFCommentAuthors xSLFCommentAuthors = (XSLFCommentAuthors) pOIXMLDocumentPart;
                this._commentAuthors = xSLFCommentAuthors;
                return xSLFCommentAuthors;
            }
        }
        for (POIXMLDocumentPart pOIXMLDocumentPart2 : getSlideShow().getRelations()) {
            if (pOIXMLDocumentPart2 instanceof XSLFCommentAuthors) {
                XSLFCommentAuthors xSLFCommentAuthors2 = (XSLFCommentAuthors) pOIXMLDocumentPart2;
                this._commentAuthors = xSLFCommentAuthors2;
                return xSLFCommentAuthors2;
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public List<XSLFComment> getComments() {
        ArrayList arrayList = new ArrayList();
        XSLFComments commentsPart = getCommentsPart();
        XSLFCommentAuthors commentAuthorsPart = getCommentAuthorsPart();
        if (commentsPart != null) {
            for (CTComment cTComment : commentsPart.getCTCommentsList().getCmArray()) {
                arrayList.add(new XSLFComment(cTComment, commentAuthorsPart));
            }
        }
        return arrayList;
    }

    public XSLFComments getCommentsPart() {
        if (this._comments == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFComments) {
                    this._comments = (XSLFComments) pOIXMLDocumentPart;
                    break;
                }
            }
        }
        return this._comments;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterBackground() {
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterColourScheme() {
        return false;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public boolean getFollowMasterGraphics() {
        return this._slide.getShowMasterSp();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean getFollowMasterObjects() {
        return getFollowMasterGraphics();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "sld";
    }

    public XSLFSlideMaster getSlideMaster() {
        return getSlideLayout().getSlideMaster();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public String getSlideName() {
        CTCommonSlideData cSld = getXmlObject().getCSld();
        if (cSld.isSetName()) {
            return cSld.getName();
        }
        return "Slide" + getSlideNumber();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public int getSlideNumber() {
        int iIndexOf = getSlideShow().getSlides().indexOf(this);
        return iIndexOf == -1 ? iIndexOf : iIndexOf + 1;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getSlideLayout().getSlideMaster().getTheme();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public String getTitle() {
        XSLFTextShape textShapeByType = getTextShapeByType(Placeholder.TITLE);
        if (textShapeByType == null) {
            return null;
        }
        return textShapeByType.getText();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public boolean isHidden() {
        CTSlide xmlObject = getXmlObject();
        return xmlObject.isSetShow() && !xmlObject.getShow();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String mapSchemeColor(String str) {
        return mapSchemeColor(this._slide.getClrMapOvr(), str);
    }

    public void removeChartRelation(XSLFChart xSLFChart) {
        removeRelation(xSLFChart);
    }

    public void removeLayoutRelation(XSLFSlideLayout xSLFSlideLayout) {
        removeRelation((POIXMLDocumentPart) xSLFSlideLayout, false);
    }

    public XSLFNotes removeNotes(XSLFNotesMaster xSLFNotesMaster) {
        XSLFNotes notes = getNotes();
        if (notes == null) {
            return null;
        }
        notes.removeRelations(this, xSLFNotesMaster);
        removeRelation(notes);
        this._notes = null;
        return notes;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setFollowMasterBackground(boolean z6) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setFollowMasterColourScheme(boolean z6) {
        throw new UnsupportedOperationException();
    }

    public void setFollowMasterGraphics(boolean z6) {
        this._slide.setShowMasterSp(z6);
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public void setFollowMasterObjects(boolean z6) {
        setFollowMasterGraphics(z6);
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public void setHidden(boolean z6) {
        CTSlide xmlObject = getXmlObject();
        if (z6) {
            xmlObject.setShow(false);
        } else if (xmlObject.isSetShow()) {
            xmlObject.unsetShow();
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet, org.apache.poi.sl.usermodel.Sheet
    public XSLFBackground getBackground() {
        CTBackground bg = this._slide.getCSld().getBg();
        return bg != null ? new XSLFBackground(bg, this) : getMasterSheet().getBackground();
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFSlideLayout getMasterSheet() {
        return getSlideLayout();
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public XSLFNotes getNotes() {
        if (this._notes == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFNotes) {
                    this._notes = (XSLFNotes) pOIXMLDocumentPart;
                }
            }
        }
        XSLFNotes xSLFNotes = this._notes;
        if (xSLFNotes == null) {
            return null;
        }
        return xSLFNotes;
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    public XSLFSlideLayout getSlideLayout() {
        if (this._layout == null) {
            for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
                if (pOIXMLDocumentPart instanceof XSLFSlideLayout) {
                    this._layout = (XSLFSlideLayout) pOIXMLDocumentPart;
                }
            }
        }
        XSLFSlideLayout xSLFSlideLayout = this._layout;
        if (xSLFSlideLayout != null) {
            return xSLFSlideLayout;
        }
        throw new IllegalArgumentException("SlideLayout was not found for " + this);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTSlide getXmlObject() {
        return this._slide;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFSlide importContent(XSLFSheet xSLFSheet) {
        super.importContent(xSLFSheet);
        if (xSLFSheet instanceof XSLFSlide) {
            XSLFSlide xSLFSlide = (XSLFSlide) xSLFSheet;
            XSLFNotes notes = xSLFSlide.getNotes();
            if (notes != null) {
                getSlideShow().getNotesSlide(this).importContent(notes);
            }
            CTBackground bg = xSLFSlide._slide.getCSld().getBg();
            if (bg != null) {
                CTBackground bg2 = this._slide.getCSld().getBg();
                if (bg2 != null) {
                    if (bg2.isSetBgPr() && bg2.getBgPr().isSetBlipFill()) {
                        removeRelation(bg2.getBgPr().getBlipFill().getBlip().getEmbed());
                    }
                    this._slide.getCSld().unsetBg();
                }
                CTBackground cTBackground = (CTBackground) this._slide.getCSld().addNewBg().set(bg);
                if (bg.isSetBgPr() && bg.getBgPr().isSetBlipFill()) {
                    cTBackground.getBgPr().getBlipFill().getBlip().setEmbed(importBlip(bg.getBgPr().getBlipFill().getBlip().getEmbed(), xSLFSheet));
                }
            }
        }
        return this;
    }

    public XSLFSlide(PackagePart packagePart) throws IOException {
        super(packagePart);
        try {
            InputStream inputStream = getPackagePart().getInputStream();
            try {
                Document document = DocumentHelper.readDocument(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                this._slide = SldDocument.Factory.parse(document, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSld();
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
        } catch (SAXException e) {
            throw new IOException(e);
        }
    }

    @Override // org.apache.poi.sl.usermodel.Slide
    @NotImplemented
    public void setNotes(Notes<XSLFShape, XSLFTextParagraph> notes) {
    }
}
