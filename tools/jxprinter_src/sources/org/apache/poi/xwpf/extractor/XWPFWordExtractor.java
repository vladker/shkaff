package org.apache.poi.xwpf.extractor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFCommentsDecorator;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ICell;
import org.apache.poi.xwpf.usermodel.IRunElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFSDTCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFWordExtractor implements POIXMLTextExtractor {
    public static final List<XWPFRelation> SUPPORTED_TYPES = Collections.unmodifiableList(Arrays.asList(XWPFRelation.DOCUMENT, XWPFRelation.TEMPLATE, XWPFRelation.MACRO_DOCUMENT, XWPFRelation.MACRO_TEMPLATE_DOCUMENT));
    private boolean concatenatePhoneticRuns;
    private boolean doCloseFilesystem;
    private final XWPFDocument document;
    private boolean fetchHyperlinks;

    public XWPFWordExtractor(OPCPackage oPCPackage) {
        this(new XWPFDocument(oPCPackage));
    }

    private void appendTableText(StringBuilder sb, XWPFTable xWPFTable) {
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

    private void extractFooters(StringBuilder sb, XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy) {
        if (xWPFHeaderFooterPolicy == null) {
            return;
        }
        if (xWPFHeaderFooterPolicy.getFirstPageFooter() != null) {
            sb.append(xWPFHeaderFooterPolicy.getFirstPageFooter().getText());
        }
        if (xWPFHeaderFooterPolicy.getEvenPageFooter() != null) {
            sb.append(xWPFHeaderFooterPolicy.getEvenPageFooter().getText());
        }
        if (xWPFHeaderFooterPolicy.getDefaultFooter() != null) {
            sb.append(xWPFHeaderFooterPolicy.getDefaultFooter().getText());
        }
    }

    private void extractHeaders(StringBuilder sb, XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy) {
        if (xWPFHeaderFooterPolicy == null) {
            return;
        }
        if (xWPFHeaderFooterPolicy.getFirstPageHeader() != null) {
            sb.append(xWPFHeaderFooterPolicy.getFirstPageHeader().getText());
        }
        if (xWPFHeaderFooterPolicy.getEvenPageHeader() != null) {
            sb.append(xWPFHeaderFooterPolicy.getEvenPageHeader().getText());
        }
        if (xWPFHeaderFooterPolicy.getDefaultHeader() != null) {
            sb.append(xWPFHeaderFooterPolicy.getDefaultHeader().getText());
        }
    }

    public void appendBodyElementText(StringBuilder sb, IBodyElement iBodyElement) {
        if (iBodyElement instanceof XWPFParagraph) {
            appendParagraphText(sb, (XWPFParagraph) iBodyElement);
        } else if (iBodyElement instanceof XWPFTable) {
            appendTableText(sb, (XWPFTable) iBodyElement);
        } else if (iBodyElement instanceof XWPFSDT) {
            sb.append(((XWPFSDT) iBodyElement).getContent().getText());
        }
    }

    public void appendParagraphText(StringBuilder sb, XWPFParagraph xWPFParagraph) {
        XWPFHeaderFooterPolicy xWPFHeaderFooterPolicy;
        XWPFHyperlink hyperlink;
        CTSectPr sectPr = xWPFParagraph.getCTP().getPPr() != null ? xWPFParagraph.getCTP().getPPr().getSectPr() : null;
        if (sectPr != null) {
            xWPFHeaderFooterPolicy = new XWPFHeaderFooterPolicy(this.document, sectPr);
            extractHeaders(sb, xWPFHeaderFooterPolicy);
        } else {
            xWPFHeaderFooterPolicy = null;
        }
        for (IRunElement iRunElement : xWPFParagraph.getIRuns()) {
            if (iRunElement instanceof XWPFSDT) {
                sb.append(((XWPFSDT) iRunElement).getContent().getText());
            } else if (this.concatenatePhoneticRuns || !(iRunElement instanceof XWPFRun)) {
                sb.append(iRunElement);
            } else {
                sb.append(((XWPFRun) iRunElement).text());
            }
            if ((iRunElement instanceof XWPFHyperlinkRun) && this.fetchHyperlinks && (hyperlink = ((XWPFHyperlinkRun) iRunElement).getHyperlink(this.document)) != null) {
                sb.append(" <");
                sb.append(hyperlink.getURL());
                sb.append(">");
            }
        }
        String commentText = new XWPFCommentsDecorator(xWPFParagraph, null).getCommentText();
        if (commentText.length() > 0) {
            sb.append(commentText);
            sb.append('\n');
        }
        String footnoteText = xWPFParagraph.getFootnoteText();
        if (footnoteText != null && footnoteText.length() > 0) {
            sb.append(footnoteText);
            sb.append('\n');
        }
        if (sectPr != null) {
            extractFooters(sb, xWPFHeaderFooterPolicy);
        }
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        StringBuilder sb = new StringBuilder(64);
        XWPFHeaderFooterPolicy headerFooterPolicy = this.document.getHeaderFooterPolicy();
        extractHeaders(sb, headerFooterPolicy);
        Iterator<IBodyElement> it = this.document.getBodyElements().iterator();
        while (it.hasNext()) {
            appendBodyElementText(sb, it.next());
            sb.append('\n');
        }
        extractFooters(sb, headerFooterPolicy);
        return sb.toString();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    public void setConcatenatePhoneticRuns(boolean z6) {
        this.concatenatePhoneticRuns = z6;
    }

    public void setFetchHyperlinks(boolean z6) {
        this.fetchHyperlinks = z6;
    }

    public XWPFWordExtractor(XWPFDocument xWPFDocument) {
        this.concatenatePhoneticRuns = true;
        this.doCloseFilesystem = true;
        this.document = xWPFDocument;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public XWPFDocument getFilesystem() {
        return this.document;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public XWPFDocument getDocument() {
        return this.document;
    }
}
