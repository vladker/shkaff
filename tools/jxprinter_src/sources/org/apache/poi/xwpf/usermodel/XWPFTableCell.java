package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFTableCell implements IBody, ICell {
    private static final EnumMap<XWPFVertAlign, STVerticalJc.Enum> alignMap;
    private static final HashMap<Integer, XWPFVertAlign> stVertAlignTypeMap;
    private final CTTc ctTc;
    protected IBody part;
    private final XWPFTableRow tableRow;
    protected List<IBodyElement> bodyElements = new ArrayList();
    protected List<XWPFParagraph> paragraphs = new ArrayList();
    protected List<XWPFTable> tables = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum XWPFVertAlign {
        TOP,
        CENTER,
        BOTH,
        BOTTOM
    }

    static {
        EnumMap<XWPFVertAlign, STVerticalJc.Enum> enumMap = new EnumMap<>(XWPFVertAlign.class);
        alignMap = enumMap;
        XWPFVertAlign xWPFVertAlign = XWPFVertAlign.TOP;
        enumMap.put(xWPFVertAlign, STVerticalJc.TOP);
        XWPFVertAlign xWPFVertAlign2 = XWPFVertAlign.CENTER;
        enumMap.put(xWPFVertAlign2, STVerticalJc.CENTER);
        XWPFVertAlign xWPFVertAlign3 = XWPFVertAlign.BOTH;
        enumMap.put(xWPFVertAlign3, STVerticalJc.BOTH);
        XWPFVertAlign xWPFVertAlign4 = XWPFVertAlign.BOTTOM;
        enumMap.put(xWPFVertAlign4, STVerticalJc.BOTTOM);
        HashMap<Integer, XWPFVertAlign> map = new HashMap<>();
        stVertAlignTypeMap = map;
        map.put(1, xWPFVertAlign);
        map.put(2, xWPFVertAlign2);
        map.put(3, xWPFVertAlign3);
        map.put(4, xWPFVertAlign4);
    }

    public XWPFTableCell(CTTc cTTc, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.ctTc = cTTc;
        this.part = iBody;
        this.tableRow = xWPFTableRow;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
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
                if (object instanceof CTSdtBlock) {
                    this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
                }
                if (object instanceof CTSdtRun) {
                    this.bodyElements.add(new XWPFSDT((CTSdtRun) object, this));
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

    private void appendBodyElementText(StringBuilder sb, IBodyElement iBodyElement, boolean z6) {
        if (iBodyElement instanceof XWPFParagraph) {
            sb.append(((XWPFParagraph) iBodyElement).getText());
            if (z6) {
                return;
            }
            sb.append('\t');
            return;
        }
        if (!(iBodyElement instanceof XWPFTable)) {
            if (iBodyElement instanceof XWPFSDT) {
                sb.append(((XWPFSDT) iBodyElement).getContent().getText());
                if (z6) {
                    return;
                }
                sb.append('\t');
                return;
            }
            return;
        }
        Iterator<XWPFTableRow> it = ((XWPFTable) iBodyElement).getRows().iterator();
        while (it.hasNext()) {
            Iterator<XWPFTableCell> it2 = it.next().getTableCells().iterator();
            while (it2.hasNext()) {
                List<IBodyElement> bodyElements = it2.next().getBodyElements();
                for (int i5 = 0; i5 < bodyElements.size(); i5++) {
                    boolean z7 = true;
                    if (i5 != bodyElements.size() - 1) {
                        z7 = false;
                    }
                    appendBodyElementText(sb, bodyElements.get(i5), z7);
                }
            }
        }
        if (z6) {
            return;
        }
        sb.append('\n');
    }

    private CTTblWidth getTcWidth() {
        CTTcPr tcPr = getTcPr();
        return tcPr.isSetTcW() ? tcPr.getTcW() : tcPr.addNewTcW();
    }

    private boolean isCursorInTableCell(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.ctTc;
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

    public XWPFParagraph addParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctTc.addNewP(), this);
        addParagraph(xWPFParagraph);
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    @Internal
    public CTTc getCTTc() {
        return this.ctTc;
    }

    public String getColor() {
        CTShd shd;
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (tcPr == null || (shd = tcPr.getShd()) == null) {
            return null;
        }
        return shd.xgetFill().getStringValue();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (ctp.equals(xWPFParagraph.getCTP())) {
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
        return this.tableRow.getTable().getPart();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.TABLECELL;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        for (int i5 = 0; i5 < this.tables.size(); i5++) {
            if (getTables().get(i5).getCTTbl() == cTTbl) {
                return getTables().get(i5);
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

    public XWPFTableRow getTableRow() {
        return this.tableRow;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    public CTTcPr getTcPr() {
        return this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XWPFParagraph> it = this.paragraphs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    public String getTextRecursively() {
        StringBuilder sb = new StringBuilder(64);
        for (int i5 = 0; i5 < this.bodyElements.size(); i5++) {
            boolean z6 = true;
            if (i5 != this.bodyElements.size() - 1) {
                z6 = false;
            }
            appendBodyElementText(sb, this.bodyElements.get(i5), z6);
        }
        return sb.toString();
    }

    public XWPFVertAlign getVerticalAlignment() {
        CTVerticalJc vAlign;
        CTTcPr tcPr = this.ctTc.getTcPr();
        if (tcPr == null || (vAlign = tcPr.getVAlign()) == null) {
            return null;
        }
        return stVertAlignTypeMap.get(Integer.valueOf(vAlign.getVal().intValue()));
    }

    public int getWidth() {
        return (int) Units.toDXA(POIXMLUnits.parseLength(getTcWidth().xgetW()));
    }

    public double getWidthDecimal() {
        return XWPFTable.getWidthDecimal(getTcWidth());
    }

    public TableWidthType getWidthType() {
        return XWPFTable.getWidthType(getTcWidth());
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        return this.part.getXWPFDocument();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z6;
        XmlObject object = null;
        if (!isCursorInTableCell(xmlCursor)) {
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
                if (xmlCursorNewCursor2 != null) {
                    xmlCursorNewCursor2.close();
                }
                xmlCursor.toEndToken();
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
        if (!isCursorInTableCell(xmlCursor)) {
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
        Iterator<CTTbl> it = this.ctTc.getTblList().iterator();
        int i6 = 0;
        while (it.hasNext() && it.next() != xWPFTable.getCTTbl()) {
            i6++;
        }
        this.tables.add(i6, xWPFTable);
    }

    public void removeParagraph(int i5) {
        XWPFParagraph xWPFParagraph = this.paragraphs.get(i5);
        this.paragraphs.remove(i5);
        this.ctTc.removeP(i5);
        this.bodyElements.remove(xWPFParagraph);
    }

    public void removeTable(int i5) {
        XWPFTable xWPFTable = this.tables.get(i5);
        this.tables.remove(i5);
        this.ctTc.removeTbl(i5);
        this.bodyElements.remove(xWPFTable);
    }

    public void setColor(String str) {
        CTTcPr tcPr = getTcPr();
        CTShd shd = tcPr.isSetShd() ? tcPr.getShd() : tcPr.addNewShd();
        shd.setColor("auto");
        shd.setVal(STShd.CLEAR);
        shd.setFill(str);
    }

    public void setParagraph(XWPFParagraph xWPFParagraph) {
        if (this.ctTc.sizeOfPArray() == 0) {
            this.ctTc.addNewP();
        }
        this.ctTc.setPArray(0, xWPFParagraph.getCTP());
    }

    public void setText(String str) {
        (this.paragraphs.isEmpty() ? addParagraph() : this.paragraphs.get(0)).createRun().setText(str);
    }

    public void setVerticalAlignment(XWPFVertAlign xWPFVertAlign) {
        getTcPr().addNewVAlign().setVal(alignMap.get(xWPFVertAlign));
    }

    public void setWidth(String str) {
        XWPFTable.setWidthValue(str, getTcWidth());
    }

    public void setWidthType(TableWidthType tableWidthType) {
        XWPFTable.setWidthType(tableWidthType, getTcWidth());
    }

    public void addParagraph(XWPFParagraph xWPFParagraph) {
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
    }
}
