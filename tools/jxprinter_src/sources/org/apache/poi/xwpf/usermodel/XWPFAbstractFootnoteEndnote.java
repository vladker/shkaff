package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XWPFAbstractFootnoteEndnote implements Iterable<XWPFParagraph>, IBody {
    protected CTFtnEdn ctFtnEdn;
    protected XWPFDocument document;
    protected XWPFAbstractFootnotesEndnotes footnotes;
    private final List<XWPFParagraph> paragraphs = new ArrayList();
    private final List<XWPFTable> tables = new ArrayList();
    private final List<XWPFPictureData> pictures = new ArrayList();
    private final List<IBodyElement> bodyElements = new ArrayList();

    public XWPFAbstractFootnoteEndnote() {
    }

    private boolean isCursorInFtn(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.ctFtnEdn;
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

    public XWPFParagraph addNewParagraph(CTP ctp) {
        CTP ctpAddNewP = this.ctFtnEdn.addNewP();
        ctpAddNewP.set(ctp);
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctpAddNewP, this);
        this.paragraphs.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFTable addNewTbl(CTTbl cTTbl) {
        CTTbl cTTblAddNewTbl = this.ctFtnEdn.addNewTbl();
        cTTblAddNewTbl.set(cTTbl);
        XWPFTable xWPFTable = new XWPFTable(cTTblAddNewTbl, this);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctFtnEdn.addNewP(), this);
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
        if (xWPFParagraph.equals(getParagraphs().get(0))) {
            ensureFootnoteRef(xWPFParagraph);
        }
        return xWPFParagraph;
    }

    public XWPFTable createTable() {
        XWPFTable xWPFTable = new XWPFTable(this.ctFtnEdn.addNewTbl(), this);
        if (this.bodyElements.isEmpty()) {
            ensureFootnoteRef(createParagraph());
        }
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    public abstract void ensureFootnoteRef(XWPFParagraph xWPFParagraph);

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return this.bodyElements;
    }

    public CTFtnEdn getCTFtnEdn() {
        return this.ctFtnEdn;
    }

    public BigInteger getId() {
        return this.ctFtnEdn.getId();
    }

    public POIXMLDocumentPart getOwner() {
        return this.footnotes;
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
        return this.paragraphs;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.footnotes;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTNOTE;
    }

    public List<XWPFPictureData> getPictures() {
        return this.pictures;
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
        XWPFTableRow row;
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
            if (!(object2 instanceof CTTbl) || (table = getTable((CTTbl) object2)) == null || (row = table.getRow(cTRow)) == null) {
                return null;
            }
            return row.getTableCell(cTTc);
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
        return this.tables;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.document;
    }

    public void init() {
        XmlCursor xmlCursorNewCursor = this.ctFtnEdn.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                    this.bodyElements.add(xWPFParagraph);
                    this.paragraphs.add(xWPFParagraph);
                } else if (object instanceof CTTbl) {
                    XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                    this.bodyElements.add(xWPFTable);
                    this.tables.add(xWPFTable);
                } else if (object instanceof CTSdtBlock) {
                    this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
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

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInFtn(xmlCursor)) {
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
        if (!isCursorInFtn(xmlCursor)) {
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
        this.bodyElements.add(i5, xWPFTable);
        xmlCursorNewCursor.close();
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
        Iterator<CTTbl> it = this.ctFtnEdn.getTblList().iterator();
        int i6 = 0;
        while (it.hasNext() && it.next() != xWPFTable.getCTTbl()) {
            i6++;
        }
        this.tables.add(i6, xWPFTable);
    }

    @Override // java.lang.Iterable
    public Iterator<XWPFParagraph> iterator() {
        return this.paragraphs.iterator();
    }

    public void setCTFtnEdn(CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
    }

    @Override // java.lang.Iterable
    public Spliterator<XWPFParagraph> spliterator() {
        return this.paragraphs.spliterator();
    }

    @Internal
    public XWPFAbstractFootnoteEndnote(XWPFDocument xWPFDocument, CTFtnEdn cTFtnEdn) {
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFDocument;
        init();
    }

    public XWPFTable createTable(int i5, int i6) {
        XWPFTable xWPFTable = new XWPFTable(this.ctFtnEdn.addNewTbl(), this, i5, i6);
        this.bodyElements.add(xWPFTable);
        this.tables.add(xWPFTable);
        return xWPFTable;
    }

    @Internal
    public XWPFAbstractFootnoteEndnote(CTFtnEdn cTFtnEdn, XWPFAbstractFootnotesEndnotes xWPFAbstractFootnotesEndnotes) {
        this.footnotes = xWPFAbstractFootnotesEndnotes;
        this.ctFtnEdn = cTFtnEdn;
        this.document = xWPFAbstractFootnotesEndnotes.getXWPFDocument();
        init();
    }
}
