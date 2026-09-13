package org.apache.poi.xwpf.usermodel;

import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface IBody {
    List<IBodyElement> getBodyElements();

    XWPFParagraph getParagraph(CTP ctp);

    XWPFParagraph getParagraphArray(int i5);

    List<XWPFParagraph> getParagraphs();

    POIXMLDocumentPart getPart();

    BodyType getPartType();

    XWPFTable getTable(CTTbl cTTbl);

    XWPFTable getTableArray(int i5);

    XWPFTableCell getTableCell(CTTc cTTc);

    List<XWPFTable> getTables();

    XWPFDocument getXWPFDocument();

    XWPFParagraph insertNewParagraph(XmlCursor xmlCursor);

    XWPFTable insertNewTbl(XmlCursor xmlCursor);

    void insertTable(int i5, XWPFTable xWPFTable);
}
