package org.apache.poi.xwpf.usermodel;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSDTContentCell implements ISDTContent {
    private String text;

    public XWPFSDTContentCell(CTSdtContentCell cTSdtContentCell, XWPFTableRow xWPFTableRow, IBody iBody) {
        this.text = "";
        if (cTSdtContentCell == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        XmlCursor xmlCursorNewCursor = cTSdtContentCell.newCursor();
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (xmlCursorNewCursor.hasNextToken() && i5 > 0) {
            try {
                if (xmlCursorNewCursor.toNextToken().isText()) {
                    sb.append(xmlCursorNewCursor.getTextValue());
                } else if (isStartToken(xmlCursorNewCursor, "tr")) {
                    i6 = 0;
                    i7 = 0;
                } else if (isStartToken(xmlCursorNewCursor, "tc")) {
                    int i8 = i6 + 1;
                    if (i6 > 0) {
                        sb.append("\t");
                    }
                    i6 = i8;
                    i7 = 0;
                } else if (isStartToken(xmlCursorNewCursor, "p") || isStartToken(xmlCursorNewCursor, "tbl") || isStartToken(xmlCursorNewCursor, "sdt")) {
                    if (i7 > 0) {
                        sb.append("\n");
                    }
                    i7++;
                }
                if (xmlCursorNewCursor.isStart()) {
                    i5++;
                } else if (xmlCursorNewCursor.isEnd()) {
                    i5--;
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
        this.text = sb.toString();
        xmlCursorNewCursor.close();
    }

    private boolean isStartToken(XmlCursor xmlCursor, String str) {
        QName name;
        return xmlCursor.isStart() && (name = xmlCursor.getName()) != null && name.getLocalPart() != null && name.getLocalPart().equals(str);
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        return this.text;
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String toString() {
        return getText();
    }
}
