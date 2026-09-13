package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XWPFHeaderFooter extends POIXMLDocumentPart implements IBody {
    List<IBodyElement> bodyElements;
    XWPFDocument document;
    CTHdrFtr headerFooter;
    List<XWPFParagraph> paragraphs;
    List<XWPFPictureData> pictures;
    List<XWPFTable> tables;

    public XWPFHeaderFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        xWPFDocument.getClass();
        this.document = xWPFDocument;
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    private boolean isCursorInHdrF(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.headerFooter;
            xmlCursorNewCursor.close();
            return z6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Internal
    public CTHdrFtr _getHdrFtr() {
        return this.headerFooter;
    }

    public String addPictureData(byte[] bArr, int i5) {
        return addPictureData(bArr, PictureType.findByOoxmlId(i5));
    }

    public void clearHeaderFooter() {
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        try {
            xmlCursorNewCursor.removeXmlContents();
            xmlCursorNewCursor.close();
            this.paragraphs.clear();
            this.tables.clear();
            this.bodyElements.clear();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.headerFooter.addNewP(), this);
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFTable createTable(int i5, int i6) {
        XWPFTable xWPFTable = new XWPFTable(this.headerFooter.addNewTbl(), this, i5, i6);
        this.tables.add(xWPFTable);
        this.bodyElements.add(xWPFTable);
        return xWPFTable;
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        return this.document.getAllPackagePictures();
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public List<XWPFParagraph> getListParagraph() {
        return this.paragraphs;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (xWPFParagraph.getCTP().equals(ctp)) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i5) {
        if (i5 < 0 || i5 >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i5);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById instanceof XWPFPictureData) {
            return (XWPFPictureData) relationById;
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        XWPFTable next;
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.getCTTbl().equals(cTTbl)) {
                return next;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i5) {
        if (i5 < 0 || i5 >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i5);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            XmlObject object = xmlCursorNewCursor.getObject();
            if (!(object instanceof CTRow)) {
                xmlCursorNewCursor.close();
                return null;
            }
            CTRow cTRow = (CTRow) object;
            xmlCursorNewCursor.toParent();
            XmlObject object2 = xmlCursorNewCursor.getObject();
            xmlCursorNewCursor.close();
            if ((object2 instanceof CTTbl) && (table = getTable((CTTbl) object2)) != null) {
                return table.getRow(cTRow).getTableCell(cTTc);
            }
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    public String getText() {
        String text;
        StringBuilder sb = new StringBuilder(64);
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (!xWPFParagraph.isEmpty() && (text = xWPFParagraph.getText()) != null && text.length() > 0) {
                sb.append(text);
                sb.append('\n');
            }
        }
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext()) {
            String text2 = it.next().getText();
            if (text2 != null && text2.length() > 0) {
                sb.append(text2);
                sb.append('\n');
            }
        }
        for (IBodyElement iBodyElement : getBodyElements()) {
            if (iBodyElement instanceof XWPFSDT) {
                sb.append(((XWPFSDT) iBodyElement).getContent().getText());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("p", CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp, this);
        while (true) {
            z6 = object instanceof CTP;
            if (z6 || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i5 = 0;
        if (!z6 || object == ctp) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph((CTP) object)) + 1, xWPFParagraph);
        }
        XmlCursor xmlCursorNewCursor = ctp.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            while (xmlCursor.toPrevSibling()) {
                XmlObject object2 = xmlCursor.getObject();
                if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                    i5++;
                }
            }
            this.bodyElements.add(i5, xWPFParagraph);
            XmlCursor xmlCursorNewCursor2 = ctp.newCursor();
            try {
                xmlCursor.toCursor(xmlCursorNewCursor2);
                xmlCursor.toEndToken();
                if (xmlCursorNewCursor2 != null) {
                    xmlCursorNewCursor2.close();
                }
                return xWPFParagraph;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor2 != null) {
                        try {
                            xmlCursorNewCursor2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl cTTbl = (CTTbl) xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
        xmlCursor.removeXmlContents();
        while (true) {
            z6 = object instanceof CTTbl;
            if (z6 || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i5 = 0;
        if (z6) {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) object)) + 1, xWPFTable);
        } else {
            this.tables.add(0, xWPFTable);
        }
        XmlCursor xmlCursorNewCursor = cTTbl.newCursor();
        while (xmlCursorNewCursor.toPrevSibling()) {
            try {
                XmlObject object2 = xmlCursorNewCursor.getObject();
                if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                    i5++;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        xmlCursorNewCursor.close();
        this.bodyElements.add(i5, xWPFTable);
        XmlCursor xmlCursorNewCursor2 = cTTbl.newCursor();
        try {
            xmlCursor.toCursor(xmlCursorNewCursor2);
            xmlCursor.toEndToken();
            if (xmlCursorNewCursor2 != null) {
                xmlCursorNewCursor2.close();
            }
            return xWPFTable;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (xmlCursorNewCursor2 != null) {
                    try {
                        xmlCursorNewCursor2.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i5, XWPFTable xWPFTable) {
        this.bodyElements.add(i5, xWPFTable);
        CTTbl[] tblArray = this.headerFooter.getTblArray();
        int length = tblArray.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length && tblArray[i7] != xWPFTable.getCTTbl(); i7++) {
            i6++;
        }
        this.tables.add(i6, xWPFTable);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XWPFPictureData) {
                XWPFPictureData xWPFPictureData = (XWPFPictureData) pOIXMLDocumentPart;
                this.pictures.add(xWPFPictureData);
                this.document.registerPackagePictureData(xWPFPictureData);
            }
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
        if (this.bodyElements.isEmpty()) {
            createParagraph();
        }
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext()) {
            Iterator<XWPFTableRow> it2 = it.next().tableRows.iterator();
            while (it2.hasNext()) {
                for (XWPFTableCell xWPFTableCell : it2.next().getTableCells()) {
                    if (xWPFTableCell.getBodyElements().isEmpty()) {
                        xWPFTableCell.addParagraph();
                    }
                }
            }
        }
        super.prepareForCommit();
    }

    public void readHdrFtr() {
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                    this.paragraphs.add(xWPFParagraph);
                    this.bodyElements.add(xWPFParagraph);
                }
                if (object instanceof CTTbl) {
                    XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                    this.tables.add(xWPFTable);
                    this.bodyElements.add(xWPFTable);
                }
            }
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public void removeParagraph(XWPFParagraph xWPFParagraph) {
        if (this.paragraphs.contains(xWPFParagraph)) {
            XmlCursor xmlCursorNewCursor = xWPFParagraph.getCTP().newCursor();
            try {
                xmlCursorNewCursor.removeXml();
                xmlCursorNewCursor.close();
                this.paragraphs.remove(xWPFParagraph);
                this.bodyElements.remove(xWPFParagraph);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public void removeTable(XWPFTable xWPFTable) {
        if (this.tables.contains(xWPFTable)) {
            XmlCursor xmlCursorNewCursor = xWPFTable.getCTTbl().newCursor();
            try {
                xmlCursorNewCursor.removeXml();
                xmlCursorNewCursor.close();
                this.tables.remove(xWPFTable);
                this.bodyElements.remove(xWPFTable);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    public void setHeaderFooter(CTHdrFtr cTHdrFtr) {
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    public String addPictureData(byte[] bArr, PictureType pictureType) throws InvalidFormatException {
        if (pictureType == null) {
            throw new InvalidFormatException("pictureType is not supported");
        }
        XWPFPictureData xWPFPictureDataFindPackagePictureData = this.document.findPackagePictureData(bArr);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[pictureType.ooxmlId];
        if (xWPFPictureDataFindPackagePictureData != null) {
            if (getRelations().contains(xWPFPictureDataFindPackagePictureData)) {
                return getRelationId(xWPFPictureDataFindPackagePictureData);
            }
            POIXMLDocumentPart.RelationPart relationPartAddRelation = addRelation(null, XWPFRelation.IMAGES, xWPFPictureDataFindPackagePictureData);
            this.pictures.add(xWPFPictureDataFindPackagePictureData);
            return relationPartAddRelation.getRelationship().getId();
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), this.document.getNextPicNameNumber(pictureType));
        try {
            OutputStream outputStream = xWPFPictureData.getPackagePart().getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.close();
                this.document.registerPackagePictureData(xWPFPictureData);
                this.pictures.add(xWPFPictureData);
                return getRelationId(xWPFPictureData);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public XWPFHeaderFooter() {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        this.headerFooter = CTHdrFtr.Factory.newInstance();
        readHdrFtr();
    }

    public XWPFHeaderFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        super(pOIXMLDocumentPart, packagePart);
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        XWPFDocument xWPFDocument = (XWPFDocument) getParent();
        this.document = xWPFDocument;
        xWPFDocument.getClass();
    }

    public POIXMLDocumentPart getOwner() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    public String addPictureData(InputStream inputStream, int i5) {
        return addPictureData(IOUtils.toByteArrayWithMaxLength(inputStream, XWPFPictureData.getMaxImageSize()), i5);
    }

    public String addPictureData(InputStream inputStream, PictureType pictureType) {
        return addPictureData(IOUtils.toByteArrayWithMaxLength(inputStream, XWPFPictureData.getMaxImageSize()), pictureType);
    }
}
