package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.usermodel.Notes;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSLFNotes extends XSLFSheet implements Notes<XSLFShape, XSLFTextParagraph> {
    private CTNotesSlide _notes;

    public XSLFNotes() {
        this._notes = prototype();
    }

    private static CTNotesSlide prototype() {
        CTNotesSlide cTNotesSlideNewInstance = CTNotesSlide.Factory.newInstance();
        cTNotesSlideNewInstance.addNewCSld().addNewSpTree();
        return cTNotesSlideNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "notes";
    }

    @Override // org.apache.poi.sl.usermodel.Notes
    public List<List<XSLFTextParagraph>> getTextParagraphs() {
        ArrayList arrayList = new ArrayList();
        for (XSLFShape xSLFShape : super.getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                arrayList.add(((XSLFTextShape) xSLFShape).getTextParagraphs());
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        XSLFNotesMaster masterSheet = getMasterSheet();
        if (masterSheet != null) {
            return masterSheet.getTheme();
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String mapSchemeColor(String str) {
        return mapSchemeColor(this._notes.getClrMapOvr(), str);
    }

    public void removeRelations(XSLFSlide xSLFSlide, XSLFNotesMaster xSLFNotesMaster) {
        removeRelation(xSLFSlide);
        removeRelation(xSLFNotesMaster);
    }

    @Override // org.apache.poi.sl.usermodel.Sheet
    public XSLFNotesMaster getMasterSheet() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
                return (XSLFNotesMaster) pOIXMLDocumentPart;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesSlide getXmlObject() {
        return this._notes;
    }

    public XSLFNotes(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = getPackagePart().getInputStream();
        try {
            this._notes = NotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
            if (inputStream != null) {
                inputStream.close();
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
    }
}
