package org.apache.poi.xwpf.usermodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFSDTContent implements ISDTContent {
    private final List<ISDTContents> bodyElements = new ArrayList();

    public XWPFSDTContent(CTSdtContentRun cTSdtContentRun, IBody iBody, IRunBody iRunBody) {
        if (cTSdtContentRun == null) {
            return;
        }
        XmlCursor xmlCursorNewCursor = cTSdtContentRun.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTR) {
                    this.bodyElements.add(new XWPFRun((CTR) object, iRunBody));
                } else if (object instanceof CTSdtRun) {
                    this.bodyElements.add(new XWPFSDT((CTSdtRun) object, iBody));
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

    private void appendParagraph(XWPFParagraph xWPFParagraph, StringBuilder sb) {
        Iterator<XWPFRun> it = xWPFParagraph.getRuns().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
    }

    private void appendTable(XWPFTable xWPFTable, StringBuilder sb) {
        Iterator<XWPFTableRow> it = xWPFTable.getRows().iterator();
        while (it.hasNext()) {
            List<ICell> tableICells = it.next().getTableICells();
            for (int i5 = 0; i5 < tableICells.size(); i5++) {
                ICell iCell = tableICells.get(i5);
                if (iCell instanceof XWPFTableCell) {
                    sb.append(((XWPFTableCell) iCell).getTextRecursively());
                } else if (iCell instanceof XWPFSDTCell) {
                    sb.append(((XWPFSDTCell) iCell).getContent().getText());
                }
                if (i5 < tableICells.size() - 1) {
                    sb.append("\t");
                }
            }
            sb.append('\n');
        }
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String getText() {
        StringBuilder sb = new StringBuilder();
        boolean z6 = false;
        for (int i5 = 0; i5 < this.bodyElements.size(); i5++) {
            ISDTContents iSDTContents = this.bodyElements.get(i5);
            if (iSDTContents instanceof XWPFParagraph) {
                appendParagraph((XWPFParagraph) iSDTContents, sb);
            } else if (iSDTContents instanceof XWPFTable) {
                appendTable((XWPFTable) iSDTContents, sb);
            } else {
                if (iSDTContents instanceof XWPFSDT) {
                    sb.append(((XWPFSDT) iSDTContents).getContent().getText());
                } else if (iSDTContents instanceof XWPFRun) {
                    sb.append(iSDTContents);
                    z6 = false;
                }
                if (!z6 && i5 < this.bodyElements.size() - 1) {
                    sb.append("\n");
                }
            }
            z6 = true;
            if (!z6) {
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.ISDTContent
    public String toString() {
        return getText();
    }

    public XWPFSDTContent(CTSdtContentBlock cTSdtContentBlock, IBody iBody, IRunBody iRunBody) {
        if (cTSdtContentBlock == null) {
            return;
        }
        XmlCursor xmlCursorNewCursor = cTSdtContentBlock.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTP) {
                    this.bodyElements.add(new XWPFParagraph((CTP) object, iBody));
                } else if (object instanceof CTTbl) {
                    this.bodyElements.add(new XWPFTable((CTTbl) object, iBody));
                } else if (object instanceof CTSdtBlock) {
                    this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, iBody));
                } else if (object instanceof CTR) {
                    this.bodyElements.add(new XWPFRun((CTR) object, iRunBody));
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
}
