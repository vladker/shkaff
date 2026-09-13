package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTInd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPBdr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFParagraph implements IBodyElement, IRunBody, ISDTContents, Paragraph {
    protected XWPFDocument document;
    private final StringBuilder footnoteText = new StringBuilder(64);
    protected List<IRunElement> iruns;
    private final CTP paragraph;
    protected IBody part;
    protected List<XWPFRun> runs;

    public XWPFParagraph(CTP ctp, IBody iBody) {
        this.paragraph = ctp;
        this.part = iBody;
        XWPFDocument xWPFDocument = iBody.getXWPFDocument();
        this.document = xWPFDocument;
        xWPFDocument.getClass();
        this.runs = new ArrayList();
        this.iruns = new ArrayList();
        buildRunsInOrderFromXml(ctp);
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            XmlCursor xmlCursorNewCursor = it.next().getCTR().newCursor();
            try {
                xmlCursorNewCursor.selectPath("child::*");
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTFtnEdnRef) {
                        CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) object;
                        StringBuilder sb = this.footnoteText;
                        sb.append(" [");
                        sb.append(cTFtnEdnRef.getId());
                        sb.append(": ");
                        IBody footnoteByID = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? this.document.getFootnoteByID(cTFtnEdnRef.getId().intValue()) : this.document.getEndnoteByID(cTFtnEdnRef.getId().intValue());
                        if (footnoteByID != null) {
                            boolean z6 = true;
                            for (XWPFParagraph xWPFParagraph : footnoteByID.getParagraphs()) {
                                if (!z6) {
                                    this.footnoteText.append("\n");
                                }
                                this.footnoteText.append(xWPFParagraph.getText());
                                z6 = false;
                            }
                        } else {
                            StringBuilder sb2 = this.footnoteText;
                            sb2.append("!!! End note with ID \"");
                            sb2.append(cTFtnEdnRef.getId());
                            sb2.append("\" not found in document.");
                        }
                        this.footnoteText.append("] ");
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

    private void buildRunsInOrderFromXml(XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath("child::*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTR) {
                    XWPFRun xWPFRun = new XWPFRun((CTR) object, this);
                    this.runs.add(xWPFRun);
                    this.iruns.add(xWPFRun);
                }
                if (object instanceof CTHyperlink) {
                    CTHyperlink cTHyperlink = (CTHyperlink) object;
                    for (CTR ctr : cTHyperlink.getRArray()) {
                        XWPFHyperlinkRun xWPFHyperlinkRun = new XWPFHyperlinkRun(cTHyperlink, ctr, this);
                        this.runs.add(xWPFHyperlinkRun);
                        this.iruns.add(xWPFHyperlinkRun);
                    }
                }
                if (object instanceof CTSimpleField) {
                    CTSimpleField cTSimpleField = (CTSimpleField) object;
                    for (CTR ctr2 : cTSimpleField.getRArray()) {
                        XWPFFieldRun xWPFFieldRun = new XWPFFieldRun(cTSimpleField, ctr2, this);
                        this.runs.add(xWPFFieldRun);
                        this.iruns.add(xWPFFieldRun);
                    }
                }
                if (object instanceof CTSdtBlock) {
                    this.iruns.add(new XWPFSDT((CTSdtBlock) object, this.part));
                }
                if (object instanceof CTSdtRun) {
                    this.iruns.add(new XWPFSDT((CTSdtRun) object, this.part));
                }
                if (object instanceof CTRunTrackChange) {
                    for (CTR ctr3 : ((CTRunTrackChange) object).getRArray()) {
                        XWPFRun xWPFRun2 = new XWPFRun(ctr3, this);
                        this.runs.add(xWPFRun2);
                        this.iruns.add(xWPFRun2);
                    }
                }
                if (object instanceof CTSmartTagRun) {
                    buildRunsInOrderFromXml(object);
                }
                if (object instanceof CTRunTrackChange) {
                    for (CTRunTrackChange cTRunTrackChange : ((CTRunTrackChange) object).getInsArray()) {
                        buildRunsInOrderFromXml(cTRunTrackChange);
                    }
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

    private CTInd getCTInd(boolean z6) {
        CTPPr cTPPr = getCTPPr();
        CTInd ind = cTPPr.getInd();
        return (z6 && ind == null) ? cTPPr.addNewInd() : ind;
    }

    private CTPBdr getCTPBrd(boolean z6) {
        CTPPr cTPPr = getCTPPr();
        CTPBdr pBdr = cTPPr.isSetPBdr() ? cTPPr.getPBdr() : null;
        return (z6 && pBdr == null) ? cTPPr.addNewPBdr() : pBdr;
    }

    private CTSpacing getCTSpacing(boolean z6) {
        CTPPr cTPPr = getCTPPr();
        CTSpacing spacing = cTPPr.getSpacing();
        return (z6 && spacing == null) ? cTPPr.addNewSpacing() : spacing;
    }

    private <T extends XWPFRun> T insertNewProvidedRun(int i5, Function<XmlCursor, T> function) {
        if (i5 < 0 || i5 >= this.runs.size()) {
            return null;
        }
        XWPFRun xWPFRun = this.runs.get(i5);
        XmlCursor xmlCursorNewCursor = xWPFRun.getCTR().newCursor();
        try {
            if (!isCursorInParagraph(xmlCursorNewCursor)) {
                xmlCursorNewCursor.toParent();
            }
            if (!isCursorInParagraph(xmlCursorNewCursor)) {
                if (xmlCursorNewCursor == null) {
                    return null;
                }
                xmlCursorNewCursor.close();
                return null;
            }
            T tApply = function.apply(xmlCursorNewCursor);
            int size = this.iruns.size();
            int iIndexOf = this.iruns.indexOf(xWPFRun);
            if (iIndexOf != -1) {
                size = iIndexOf;
            }
            this.iruns.add(size, tApply);
            this.runs.add(i5, tApply);
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            return tApply;
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

    private boolean isCursorInParagraph(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursorNewCursor.toParent();
            boolean z6 = xmlCursorNewCursor.getObject() == this.paragraph;
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

    private boolean isTheOnlyCTFieldInRuns(XWPFFieldRun xWPFFieldRun) {
        return this.runs.stream().filter(new E4.a(xWPFFieldRun.getCTField(), 6)).count() <= 1;
    }

    private boolean isTheOnlyCTHyperlinkInRuns(XWPFHyperlinkRun xWPFHyperlinkRun) {
        return this.runs.stream().filter(new E4.a(xWPFHyperlinkRun.getCTHyperlink(), 7)).count() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ XWPFFieldRun lambda$insertNewFieldRun$2(XmlCursor xmlCursor) {
        xmlCursor.beginElement("fldSimple", CTSimpleField.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTSimpleField cTSimpleField = (CTSimpleField) xmlCursor.getObject();
        return new XWPFFieldRun(cTSimpleField, cTSimpleField.addNewR(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ XWPFHyperlinkRun lambda$insertNewHyperlinkRun$1(XmlCursor xmlCursor) {
        xmlCursor.beginElement("hyperlink", CTHyperlink.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTHyperlink cTHyperlink = (CTHyperlink) xmlCursor.getObject();
        return new XWPFHyperlinkRun(cTHyperlink, cTHyperlink.addNewR(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ XWPFRun lambda$insertNewRun$0(XmlCursor xmlCursor) {
        xmlCursor.beginElement("r", CTR.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        return new XWPFRun((CTR) xmlCursor.getObject(), (IRunBody) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isTheOnlyCTFieldInRuns$4(CTSimpleField cTSimpleField, XWPFRun xWPFRun) {
        return (xWPFRun instanceof XWPFFieldRun) && cTSimpleField == ((XWPFFieldRun) xWPFRun).getCTField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isTheOnlyCTHyperlinkInRuns$3(CTHyperlink cTHyperlink, XWPFRun xWPFRun) {
        return (xWPFRun instanceof XWPFHyperlinkRun) && cTHyperlink == ((XWPFHyperlinkRun) xWPFRun).getCTHyperlink();
    }

    public void addFootnoteReference(XWPFAbstractFootnoteEndnote xWPFAbstractFootnoteEndnote) {
        CTR ctr = createRun().getCTR();
        ctr.addNewRPr().addNewRStyle().setVal("FootnoteReference");
        if (xWPFAbstractFootnoteEndnote instanceof XWPFEndnote) {
            ctr.addNewEndnoteReference().setId(xWPFAbstractFootnoteEndnote.getId());
        } else {
            ctr.addNewFootnoteReference().setId(xWPFAbstractFootnoteEndnote.getId());
        }
    }

    public void addRun(CTR ctr) {
        int iSizeOfRArray = this.paragraph.sizeOfRArray();
        this.paragraph.addNewR();
        this.paragraph.setRArray(iSizeOfRArray, ctr);
    }

    public XWPFFieldRun createFieldRun() {
        CTSimpleField cTSimpleFieldAddNewFldSimple = this.paragraph.addNewFldSimple();
        XWPFFieldRun xWPFFieldRun = new XWPFFieldRun(cTSimpleFieldAddNewFldSimple, cTSimpleFieldAddNewFldSimple.addNewR(), this);
        this.runs.add(xWPFFieldRun);
        this.iruns.add(xWPFFieldRun);
        return xWPFFieldRun;
    }

    public XWPFHyperlinkRun createHyperlinkRun(String str) {
        String id = getPart().getPackagePart().addExternalRelationship(str, XWPFRelation.HYPERLINK.getRelation()).getId();
        CTHyperlink cTHyperlinkAddNewHyperlink = getCTP().addNewHyperlink();
        cTHyperlinkAddNewHyperlink.setId(id);
        cTHyperlinkAddNewHyperlink.addNewR();
        XWPFHyperlinkRun xWPFHyperlinkRun = new XWPFHyperlinkRun(cTHyperlinkAddNewHyperlink, cTHyperlinkAddNewHyperlink.getRArray(0), this);
        this.runs.add(xWPFHyperlinkRun);
        this.iruns.add(xWPFHyperlinkRun);
        return xWPFHyperlinkRun;
    }

    public XWPFRun createRun() {
        XWPFRun xWPFRun = new XWPFRun(this.paragraph.addNewR(), (IRunBody) this);
        this.runs.add(xWPFRun);
        this.iruns.add(xWPFRun);
        return xWPFRun;
    }

    public ParagraphAlignment getAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetJc()) ? ParagraphAlignment.LEFT : ParagraphAlignment.valueOf(cTPPr.getJc().getVal().intValue());
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    public Borders getBorderBetween() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder between = cTPBrd != null ? cTPBrd.getBetween() : null;
        return Borders.valueOf((between != null ? between.getVal() : STBorder.NONE).intValue());
    }

    public Borders getBorderBottom() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder bottom = cTPBrd != null ? cTPBrd.getBottom() : null;
        return Borders.valueOf((bottom != null ? bottom.getVal() : STBorder.NONE).intValue());
    }

    public Borders getBorderLeft() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder left = cTPBrd != null ? cTPBrd.getLeft() : null;
        return Borders.valueOf((left != null ? left.getVal() : STBorder.NONE).intValue());
    }

    public Borders getBorderRight() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder right = cTPBrd != null ? cTPBrd.getRight() : null;
        return Borders.valueOf((right != null ? right.getVal() : STBorder.NONE).intValue());
    }

    public Borders getBorderTop() {
        CTPBdr cTPBrd = getCTPBrd(false);
        CTBorder top = cTPBrd != null ? cTPBrd.getTop() : null;
        return Borders.valueOf((top != null ? top.getVal() : STBorder.NONE).intValue());
    }

    @Internal
    public CTP getCTP() {
        return this.paragraph;
    }

    @Internal
    public CTPPr getCTPPr() {
        return this.paragraph.getPPr() == null ? this.paragraph.addNewPPr() : this.paragraph.getPPr();
    }

    @Override // org.apache.poi.xwpf.usermodel.IRunBody
    public XWPFDocument getDocument() {
        return this.document;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.PARAGRAPH;
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getFirstLineIndent() {
        return getIndentationFirstLine();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getFontAlignment() {
        return getAlignment().getValue();
    }

    public String getFootnoteText() {
        return this.footnoteText.toString();
    }

    public List<IRunElement> getIRuns() {
        return Collections.unmodifiableList(this.iruns);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getIndentFromLeft() {
        return getIndentationLeft();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public int getIndentFromRight() {
        return getIndentationRight();
    }

    public int getIndentationFirstLine() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetFirstLine()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTInd.xgetFirstLine()));
    }

    public int getIndentationHanging() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetHanging()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTInd.xgetHanging()));
    }

    public int getIndentationLeft() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetLeft()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTInd.xgetLeft()));
    }

    public int getIndentationLeftChars() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetLeftChars()) {
            return -1;
        }
        return cTInd.getLeftChars().intValue();
    }

    public int getIndentationRight() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetRight()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTInd.xgetRight()));
    }

    public int getIndentationRightChars() {
        CTInd cTInd = getCTInd(false);
        if (cTInd == null || !cTInd.isSetRightChars()) {
            return -1;
        }
        return cTInd.getRightChars().intValue();
    }

    public String getNumFmt() {
        XWPFNum num;
        CTLvl lvlArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTAbstractNum abstractNum = numbering.getAbstractNum(num.getCTNum().getAbstractNumId().getVal()).getAbstractNum();
            int i5 = 0;
            while (true) {
                if (i5 >= abstractNum.sizeOfLvlArray()) {
                    lvlArray = null;
                    break;
                }
                lvlArray = abstractNum.getLvlArray(i5);
                if (lvlArray.getIlvl().equals(numIlvl)) {
                    break;
                }
                i5++;
            }
            if (lvlArray != null && lvlArray.getNumFmt() != null && lvlArray.getNumFmt().getVal() != null) {
                return lvlArray.getNumFmt().getVal().toString();
            }
        }
        return null;
    }

    public BigInteger getNumID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getNumId() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getNumId().getVal();
    }

    public BigInteger getNumIlvl() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getNumPr() == null || this.paragraph.getPPr().getNumPr().getIlvl() == null) {
            return null;
        }
        return this.paragraph.getPPr().getNumPr().getIlvl().getVal();
    }

    public String getNumLevelText() {
        XWPFNum num;
        CTDecimalNumber abstractNumId;
        BigInteger val;
        XWPFAbstractNum abstractNum;
        CTAbstractNum cTAbstractNum;
        CTLvl lvlArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID != null && numbering != null && (num = numbering.getNum(numID)) != null) {
            BigInteger numIlvl = getNumIlvl();
            CTNum cTNum = num.getCTNum();
            if (cTNum == null || (abstractNumId = cTNum.getAbstractNumId()) == null || (val = abstractNumId.getVal()) == null || (abstractNum = numbering.getAbstractNum(val)) == null || (cTAbstractNum = abstractNum.getCTAbstractNum()) == null) {
                return null;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= cTAbstractNum.sizeOfLvlArray()) {
                    lvlArray = null;
                    break;
                }
                lvlArray = cTAbstractNum.getLvlArray(i5);
                if (lvlArray != null && lvlArray.getIlvl() != null && lvlArray.getIlvl().equals(numIlvl)) {
                    break;
                }
                i5++;
            }
            if (lvlArray != null && lvlArray.getLvlText() != null && lvlArray.getLvlText().getVal() != null) {
                return lvlArray.getLvlText().getVal();
            }
        }
        return null;
    }

    public BigInteger getNumStartOverride() {
        XWPFNum num;
        CTNum cTNum;
        CTNumLvl lvlOverrideArray;
        BigInteger numID = getNumID();
        XWPFNumbering numbering = this.document.getNumbering();
        if (numID == null || numbering == null || (num = numbering.getNum(numID)) == null || (cTNum = num.getCTNum()) == null) {
            return null;
        }
        BigInteger numIlvl = getNumIlvl();
        int i5 = 0;
        while (true) {
            if (i5 >= cTNum.sizeOfLvlOverrideArray()) {
                lvlOverrideArray = null;
                break;
            }
            lvlOverrideArray = cTNum.getLvlOverrideArray(i5);
            if (lvlOverrideArray != null && lvlOverrideArray.getIlvl() != null && lvlOverrideArray.getIlvl().equals(numIlvl)) {
                break;
            }
            i5++;
        }
        if (lvlOverrideArray != null && lvlOverrideArray.getStartOverride() != null) {
            return lvlOverrideArray.getStartOverride().getVal();
        }
        return null;
    }

    public String getParagraphText() {
        StringBuilder sb = new StringBuilder(64);
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public String getPictureText() {
        StringBuilder sb = new StringBuilder(64);
        Iterator<XWPFRun> it = this.runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getPictureText());
        }
        return sb.toString();
    }

    public XWPFRun getRun(CTR ctr) {
        for (int i5 = 0; i5 < getRuns().size(); i5++) {
            if (getRuns().get(i5).getCTR() == ctr) {
                return getRuns().get(i5);
            }
        }
        return null;
    }

    public List<XWPFRun> getRuns() {
        return Collections.unmodifiableList(this.runs);
    }

    public int getSpacingAfter() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfter()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTSpacing.xgetAfter()));
    }

    public int getSpacingAfterLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetAfterLines()) {
            return -1;
        }
        return cTSpacing.getAfterLines().intValue();
    }

    public int getSpacingBefore() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBefore()) {
            return -1;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(cTSpacing.xgetBefore()));
    }

    public int getSpacingBeforeLines() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetBeforeLines()) {
            return -1;
        }
        return cTSpacing.getBeforeLines().intValue();
    }

    public double getSpacingBetween() {
        CTSpacing cTSpacing = getCTSpacing(false);
        if (cTSpacing == null || !cTSpacing.isSetLine()) {
            return -1.0d;
        }
        return Units.toDXA(POIXMLUnits.parseLength(cTSpacing.xgetLine())) / ((double) ((cTSpacing.getLineRule() == null || cTSpacing.getLineRule() == STLineSpacingRule.AUTO) ? 240 : 20));
    }

    public LineSpacingRule getSpacingLineRule() {
        CTSpacing cTSpacing = getCTSpacing(false);
        return (cTSpacing == null || !cTSpacing.isSetLineRule()) ? LineSpacingRule.AUTO : LineSpacingRule.valueOf(cTSpacing.getLineRule().intValue());
    }

    public String getStyle() {
        CTPPr cTPPr = getCTPPr();
        CTString pStyle = cTPPr.isSetPStyle() ? cTPPr.getPStyle() : null;
        if (pStyle != null) {
            return pStyle.getVal();
        }
        return null;
    }

    public String getStyleID() {
        if (this.paragraph.getPPr() == null || this.paragraph.getPPr().getPStyle() == null || this.paragraph.getPPr().getPStyle().getVal() == null) {
            return null;
        }
        return this.paragraph.getPPr().getPStyle().getVal();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder(64);
        for (IRunElement iRunElement : this.iruns) {
            if (iRunElement instanceof XWPFRun) {
                XWPFRun xWPFRun = (XWPFRun) iRunElement;
                if (xWPFRun.getCTR().getDelTextArray().length == 0) {
                    sb.append(xWPFRun);
                }
            } else if (iRunElement instanceof XWPFSDT) {
                sb.append(((XWPFSDT) iRunElement).getContent().getText());
            } else {
                sb.append(iRunElement);
            }
        }
        sb.append((CharSequence) this.footnoteText);
        return sb.toString();
    }

    public TextAlignment getVerticalAlignment() {
        CTPPr cTPPr = getCTPPr();
        return (cTPPr == null || !cTPPr.isSetTextAlignment()) ? TextAlignment.AUTO : TextAlignment.valueOf(cTPPr.getTextAlignment().getVal().intValue());
    }

    public XWPFFieldRun insertNewFieldRun(int i5) {
        return i5 == this.runs.size() ? createFieldRun() : (XWPFFieldRun) insertNewProvidedRun(i5, new a(this, 0));
    }

    public XWPFHyperlinkRun insertNewHyperlinkRun(int i5, String str) {
        if (i5 == this.runs.size()) {
            return createHyperlinkRun(str);
        }
        XWPFHyperlinkRun xWPFHyperlinkRun = (XWPFHyperlinkRun) insertNewProvidedRun(i5, new a(this, 1));
        if (xWPFHyperlinkRun != null) {
            xWPFHyperlinkRun.getCTHyperlink().setId(getPart().getPackagePart().addExternalRelationship(str, XWPFRelation.HYPERLINK.getRelation()).getId());
        }
        return xWPFHyperlinkRun;
    }

    public XWPFRun insertNewRun(int i5) {
        return i5 == this.runs.size() ? createRun() : insertNewProvidedRun(i5, new a(this, 2));
    }

    public boolean isEmpty() {
        return !this.paragraph.getDomNode().hasChildNodes();
    }

    public boolean isKeepNext() {
        if (getCTP() == null || getCTP().getPPr() == null || !getCTP().getPPr().isSetKeepNext()) {
            return false;
        }
        return POIXMLUnits.parseOnOff(getCTP().getPPr().getKeepNext().xgetVal());
    }

    public boolean isPageBreak() {
        CTPPr cTPPr = getCTPPr();
        CTOnOff pageBreakBefore = cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : null;
        if (pageBreakBefore == null) {
            return false;
        }
        return POIXMLUnits.parseOnOff(pageBreakBefore.xgetVal());
    }

    public boolean isWordWrap() {
        return isWordWrapped();
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public boolean isWordWrapped() {
        return getCTPPr().isSetWordWrap() && POIXMLUnits.parseOnOff(getCTPPr().getWordWrap());
    }

    public boolean removeRun(int i5) {
        if (i5 < 0 || i5 >= this.runs.size()) {
            return false;
        }
        XWPFRun xWPFRun = this.runs.get(i5);
        if (xWPFRun instanceof XWPFHyperlinkRun) {
            XWPFHyperlinkRun xWPFHyperlinkRun = (XWPFHyperlinkRun) xWPFRun;
            if (isTheOnlyCTHyperlinkInRuns(xWPFHyperlinkRun)) {
                XmlCursor xmlCursorNewCursor = xWPFHyperlinkRun.getCTHyperlink().newCursor();
                try {
                    xmlCursorNewCursor.removeXml();
                    xmlCursorNewCursor.close();
                    this.runs.remove(i5);
                    this.iruns.remove(xWPFRun);
                    return true;
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
        if (xWPFRun instanceof XWPFFieldRun) {
            XWPFFieldRun xWPFFieldRun = (XWPFFieldRun) xWPFRun;
            if (isTheOnlyCTFieldInRuns(xWPFFieldRun)) {
                XmlCursor xmlCursorNewCursor2 = xWPFFieldRun.getCTField().newCursor();
                try {
                    xmlCursorNewCursor2.removeXml();
                    xmlCursorNewCursor2.close();
                    this.runs.remove(i5);
                    this.iruns.remove(xWPFRun);
                    return true;
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
        }
        XmlCursor xmlCursorNewCursor3 = xWPFRun.getCTR().newCursor();
        try {
            xmlCursorNewCursor3.removeXml();
            xmlCursorNewCursor3.close();
            this.runs.remove(i5);
            this.iruns.remove(xWPFRun);
            return true;
        } catch (Throwable th7) {
            try {
                throw th7;
            } catch (Throwable th8) {
                if (xmlCursorNewCursor3 != null) {
                    try {
                        xmlCursorNewCursor3.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                }
                throw th8;
            }
        }
    }

    public boolean runsIsEmpty() {
        return this.runs.isEmpty();
    }

    public TextSegment searchText(String str, PositionInParagraph positionInParagraph) {
        int i5;
        int i6;
        int run = positionInParagraph.getRun();
        int text = positionInParagraph.getText();
        int i7 = positionInParagraph.getChar();
        CTR[] rArray = this.paragraph.getRArray();
        int i8 = run;
        int i9 = 0;
        boolean z6 = false;
        int i10 = 0;
        while (i8 < rArray.length) {
            XmlCursor xmlCursorNewCursor = rArray[i8].newCursor();
            try {
                xmlCursorNewCursor.selectPath("./*");
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTText) {
                        if (i11 >= text) {
                            String stringValue = ((CTText) object).getStringValue();
                            int i14 = i8 == run ? i7 : 0;
                            while (i14 < stringValue.length()) {
                                int i15 = text;
                                int i16 = i7;
                                if (stringValue.charAt(i14) == str.charAt(0) && i9 == 0) {
                                    z6 = true;
                                    i10 = i8;
                                    i12 = i11;
                                    i13 = i14;
                                }
                                if (stringValue.charAt(i14) == str.charAt(i9)) {
                                    int i17 = i9 + 1;
                                    if (i17 < str.length()) {
                                        i9 = i17;
                                    } else if (z6) {
                                        TextSegment textSegment = new TextSegment();
                                        textSegment.setBeginRun(i10);
                                        textSegment.setBeginText(i12);
                                        textSegment.setBeginChar(i13);
                                        textSegment.setEndRun(i8);
                                        textSegment.setEndText(i11);
                                        textSegment.setEndChar(i14);
                                        xmlCursorNewCursor.close();
                                        return textSegment;
                                    }
                                } else {
                                    i9 = 0;
                                }
                                i14++;
                                i7 = i16;
                                text = i15;
                            }
                        } else {
                            run = run;
                        }
                        i5 = text;
                        i6 = i7;
                        i11++;
                    } else {
                        run = run;
                        i5 = text;
                        i6 = i7;
                        if (object instanceof CTProofErr) {
                            xmlCursorNewCursor.removeXml();
                        } else if (!(object instanceof CTRPr)) {
                            i9 = 0;
                        }
                    }
                    i7 = i6;
                    run = run;
                    text = i5;
                }
                xmlCursorNewCursor.close();
                i8++;
                text = text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor == null) {
                        throw th2;
                    }
                    try {
                        xmlCursorNewCursor.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        }
        return null;
    }

    public void setAlignment(ParagraphAlignment paragraphAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetJc() ? cTPPr.getJc() : cTPPr.addNewJc()).setVal(STJc.Enum.forInt(paragraphAlignment.getValue()));
    }

    public void setBorderBetween(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder between = cTPBrd.isSetBetween() ? cTPBrd.getBetween() : cTPBrd.addNewBetween();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBetween();
        } else {
            between.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public void setBorderBottom(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder bottom = cTPBrd.isSetBottom() ? cTPBrd.getBottom() : cTPBrd.addNewBottom();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetBottom();
        } else {
            bottom.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public void setBorderLeft(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder left = cTPBrd.isSetLeft() ? cTPBrd.getLeft() : cTPBrd.addNewLeft();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetLeft();
        } else {
            left.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public void setBorderRight(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        CTBorder right = cTPBrd.isSetRight() ? cTPBrd.getRight() : cTPBrd.addNewRight();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetRight();
        } else {
            right.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    public void setBorderTop(Borders borders) {
        CTPBdr cTPBrd = getCTPBrd(true);
        if (cTPBrd == null) {
            throw new RuntimeException("invalid paragraph state");
        }
        CTBorder top = cTPBrd.isSetTop() ? cTPBrd.getTop() : cTPBrd.addNewTop();
        if (borders.getValue() == Borders.NONE.getValue()) {
            cTPBrd.unsetTop();
        } else {
            top.setVal(STBorder.Enum.forInt(borders.getValue()));
        }
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setFirstLineIndent(int i5) {
        setIndentationFirstLine(i5);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setFontAlignment(int i5) {
        setAlignment(ParagraphAlignment.valueOf(i5));
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setIndentFromLeft(int i5) {
        setIndentationLeft(i5);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setIndentFromRight(int i5) {
        setIndentationRight(i5);
    }

    public void setIndentationFirstLine(int i5) {
        getCTInd(true).setFirstLine(new BigInteger(Integer.toString(i5)));
    }

    public void setIndentationHanging(int i5) {
        getCTInd(true).setHanging(new BigInteger(Integer.toString(i5)));
    }

    public void setIndentationLeft(int i5) {
        getCTInd(true).setLeft(new BigInteger(Integer.toString(i5)));
    }

    public void setIndentationLeftChars(int i5) {
        getCTInd(true).setLeftChars(new BigInteger(Integer.toString(i5)));
    }

    public void setIndentationRight(int i5) {
        getCTInd(true).setRight(new BigInteger(Integer.toString(i5)));
    }

    public void setIndentationRightChars(int i5) {
        getCTInd(true).setRightChars(new BigInteger(Integer.toString(i5)));
    }

    public void setKeepNext(boolean z6) {
        CTOnOff cTOnOffNewInstance = CTOnOff.Factory.newInstance();
        cTOnOffNewInstance.setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
        getCTP().getPPr().setKeepNext(cTOnOffNewInstance);
    }

    public void setNumID(BigInteger bigInteger) {
        if (this.paragraph.getPPr() == null) {
            this.paragraph.addNewPPr();
        }
        if (this.paragraph.getPPr().getNumPr() == null) {
            this.paragraph.getPPr().addNewNumPr();
        }
        if (this.paragraph.getPPr().getNumPr().getNumId() == null) {
            this.paragraph.getPPr().getNumPr().addNewNumId();
        }
        this.paragraph.getPPr().getNumPr().getNumId().setVal(bigInteger);
    }

    public void setNumILvl(BigInteger bigInteger) {
        if (this.paragraph.getPPr() == null) {
            this.paragraph.addNewPPr();
        }
        if (this.paragraph.getPPr().getNumPr() == null) {
            this.paragraph.getPPr().addNewNumPr();
        }
        if (this.paragraph.getPPr().getNumPr().getIlvl() == null) {
            this.paragraph.getPPr().getNumPr().addNewIlvl();
        }
        this.paragraph.getPPr().getNumPr().getIlvl().setVal(bigInteger);
    }

    public void setPageBreak(boolean z6) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetPageBreakBefore() ? cTPPr.getPageBreakBefore() : cTPPr.addNewPageBreakBefore()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    public void setSpacingAfter(int i5) {
        CTSpacing cTSpacing = getCTSpacing(true);
        if (cTSpacing != null) {
            cTSpacing.setAfter(new BigInteger(Integer.toString(i5)));
        }
    }

    public void setSpacingAfterLines(int i5) {
        getCTSpacing(true).setAfterLines(new BigInteger(Integer.toString(i5)));
    }

    public void setSpacingBefore(int i5) {
        getCTSpacing(true).setBefore(new BigInteger(Integer.toString(i5)));
    }

    public void setSpacingBeforeLines(int i5) {
        getCTSpacing(true).setBeforeLines(new BigInteger(Integer.toString(i5)));
    }

    public void setSpacingBetween(double d, LineSpacingRule lineSpacingRule) {
        CTSpacing cTSpacing = getCTSpacing(true);
        if (lineSpacingRule == LineSpacingRule.AUTO) {
            cTSpacing.setLine(new BigInteger(String.valueOf(Math.round(d * 240.0d))));
        } else {
            cTSpacing.setLine(new BigInteger(String.valueOf(Math.round(d * 20.0d))));
        }
        cTSpacing.setLineRule(STLineSpacingRule.Enum.forInt(lineSpacingRule.getValue()));
    }

    public void setSpacingLineRule(LineSpacingRule lineSpacingRule) {
        getCTSpacing(true).setLineRule(STLineSpacingRule.Enum.forInt(lineSpacingRule.getValue()));
    }

    public void setStyle(String str) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.getPStyle() != null ? cTPPr.getPStyle() : cTPPr.addNewPStyle()).setVal(str);
    }

    public void setVerticalAlignment(TextAlignment textAlignment) {
        CTPPr cTPPr = getCTPPr();
        (cTPPr.isSetTextAlignment() ? cTPPr.getTextAlignment() : cTPPr.addNewTextAlignment()).setVal(STTextAlignment.Enum.forInt(textAlignment.getValue()));
    }

    @Deprecated
    public void setWordWrap(boolean z6) {
        setWordWrapped(z6);
    }

    @Override // org.apache.poi.wp.usermodel.Paragraph
    public void setWordWrapped(boolean z6) {
        CTPPr cTPPr = getCTPPr();
        if (z6) {
            (cTPPr.isSetWordWrap() ? cTPPr.getWordWrap() : cTPPr.addNewWordWrap()).setVal(STOnOff1.ON);
        } else if (cTPPr.isSetWordWrap()) {
            cTPPr.unsetWordWrap();
        }
    }

    public void addRun(XWPFRun xWPFRun) {
        if (this.runs.contains(xWPFRun)) {
            return;
        }
        this.runs.add(xWPFRun);
        this.iruns.add(xWPFRun);
    }

    public void setSpacingBetween(double d) {
        setSpacingBetween(d, LineSpacingRule.AUTO);
    }

    public String getText(TextSegment textSegment) {
        int beginRun = textSegment.getBeginRun();
        int beginText = textSegment.getBeginText();
        int beginChar = textSegment.getBeginChar();
        int endRun = textSegment.getEndRun();
        int endText = textSegment.getEndText();
        int endChar = textSegment.getEndChar();
        StringBuilder sb = new StringBuilder();
        CTR[] rArray = this.paragraph.getRArray();
        int i5 = beginRun;
        while (i5 <= endRun) {
            CTText[] tArray = rArray[i5].getTArray();
            int length = tArray.length - 1;
            int i6 = i5 == beginRun ? beginText : 0;
            if (i5 == endRun) {
                length = endText;
            }
            while (i6 <= length) {
                String stringValue = tArray[i6].getStringValue();
                int length2 = stringValue.length() - 1;
                int i7 = (i6 == beginText && i5 == beginRun) ? beginChar : 0;
                if (i6 == endText && i5 == endRun) {
                    length2 = endChar;
                }
                sb.append((CharSequence) stringValue, i7, length2 + 1);
                i6++;
            }
            i5++;
        }
        return sb.toString();
    }
}
