package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFComment implements IBody {
    protected XWPFComments comments;
    protected CTComment ctComment;
    protected XWPFDocument document;
    private List<XWPFParagraph> paragraphs = new ArrayList();
    private List<XWPFTable> tables = new ArrayList();
    private List<IBodyElement> bodyElements = new ArrayList();

    public XWPFComment(CTComment cTComment, XWPFComments xWPFComments) {
        this.comments = xWPFComments;
        this.ctComment = cTComment;
        this.document = xWPFComments.getXWPFDocument();
        init();
    }

    private boolean isCursorInCmt(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.ctComment;
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

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctComment.addNewP(), this);
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFTable createTable(int i5, int i6) {
        XWPFTable xWPFTable = new XWPFTable(this.ctComment.addNewTbl(), this, i5, i6);
        this.tables.add(xWPFTable);
        this.bodyElements.add(xWPFTable);
        return xWPFTable;
    }

    public String getAuthor() {
        return this.ctComment.getAuthor();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public XWPFComments getComments() {
        return this.comments;
    }

    public CTComment getCtComment() {
        return this.ctComment;
    }

    public Calendar getDate() {
        return this.ctComment.getDate();
    }

    public String getId() {
        return this.ctComment.getId().toString();
    }

    public String getInitials() {
        return this.ctComment.getInitials();
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

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this.comments;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.COMMENT;
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
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(xWPFParagraph.getText());
        }
        return sb.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.document;
    }

    public void init() {
        XmlCursor xmlCursorNewCursor = this.ctComment.newCursor();
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
        if (!isCursorInCmt(xmlCursor)) {
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
        if (!isCursorInCmt(xmlCursor)) {
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
        Iterator<CTTbl> it = this.ctComment.getTblList().iterator();
        int i6 = 0;
        while (it.hasNext() && it.next() != xWPFTable.getCTTbl()) {
            i6++;
        }
        this.tables.add(i6, xWPFTable);
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

    public void setAuthor(String str) {
        this.ctComment.setAuthor(str);
    }

    public void setDate(Calendar calendar) {
        this.ctComment.setDate(calendar);
    }

    public void setInitials(String str) {
        this.ctComment.setInitials(str);
    }
}
