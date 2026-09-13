package org.apache.poi.xwpf.usermodel;

import java.io.InputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Removal;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.CharacterRun;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.picture.CTPictureNonVisual;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STHexColorRGB;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff1;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyContent;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrClear;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBrType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColorAuto;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFRun implements ISDTContents, IRunElement, CharacterRun {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final IRunBody parent;
    private final String pictureText;
    private final List<XWPFPicture> pictures;
    private final CTR run;

    /* JADX INFO: renamed from: org.apache.poi.xwpf.usermodel.XWPFRun$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange;

        static {
            int[] iArr = new int[FontCharRange.values().length];
            $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange = iArr;
            try {
                iArr[FontCharRange.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.cs.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.eastAsia.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[FontCharRange.hAnsi.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum FontCharRange {
        ascii,
        cs,
        eastAsia,
        hAnsi
    }

    public XWPFRun(CTR ctr, IRunBody iRunBody) {
        this.run = ctr;
        this.parent = iRunBody;
        int i5 = 0;
        for (CTDrawing cTDrawing : ctr.getDrawingArray()) {
            for (CTAnchor cTAnchor : cTDrawing.getAnchorArray()) {
                if (cTAnchor.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTAnchor.getDocPr().getId());
                }
            }
            for (CTInline cTInline : cTDrawing.getInlineArray()) {
                if (cTInline.getDocPr() != null) {
                    getDocument().getDrawingIdManager().reserve(cTInline.getDocPr().getId());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(ctr.getPictArray()));
        arrayList.addAll(Arrays.asList(ctr.getDrawingArray()));
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            for (XmlObject xmlObject : ((XmlObject) obj).selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:t")) {
                NodeList childNodes = xmlObject.getDomNode().getChildNodes();
                for (int i7 = 0; i7 < childNodes.getLength(); i7++) {
                    if (childNodes.item(i7) instanceof Text) {
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(childNodes.item(i7).getNodeValue());
                    }
                }
            }
        }
        this.pictureText = sb.toString();
        this.pictures = new ArrayList();
        int size2 = arrayList.size();
        while (i5 < size2) {
            Object obj2 = arrayList.get(i5);
            i5++;
            Iterator<CTPicture> it = getCTPictures((XmlObject) obj2).iterator();
            while (it.hasNext()) {
                this.pictures.add(new XWPFPicture(it.next(), this));
            }
        }
    }

    private void _getText(XmlObject xmlObject, StringBuilder sb) {
        String stringValue;
        if (xmlObject instanceof CTText) {
            Node domNode = xmlObject.getDomNode();
            if ((!"instrText".equals(domNode.getLocalName()) || !XSSFRelation.NS_WORDPROCESSINGML.equals(domNode.getNamespaceURI())) && (stringValue = ((CTText) xmlObject).getStringValue()) != null) {
                if (isCapitalized() || isSmallCaps()) {
                    stringValue = stringValue.toUpperCase(LocaleUtil.getUserLocale());
                }
                sb.append(stringValue);
            }
        }
        if (xmlObject instanceof CTFldChar) {
            CTFldChar cTFldChar = (CTFldChar) xmlObject;
            if (cTFldChar.getFldCharType() == STFldCharType.BEGIN && cTFldChar.getFfData() != null) {
                for (CTFFCheckBox cTFFCheckBox : cTFldChar.getFfData().getCheckBoxList()) {
                    sb.append((cTFFCheckBox.getDefault() == null || !POIXMLUnits.parseOnOff(cTFFCheckBox.getDefault().xgetVal())) ? "|_|" : "|X|");
                }
            }
        }
        if (xmlObject instanceof CTPTab) {
            sb.append('\t');
        }
        if (xmlObject instanceof CTBr) {
            sb.append('\n');
        }
        if (xmlObject instanceof CTEmpty) {
            Node domNode2 = xmlObject.getDomNode();
            if (XSSFRelation.NS_WORDPROCESSINGML.equals(domNode2.getNamespaceURI())) {
                String localName = domNode2.getLocalName();
                localName.getClass();
                switch (localName) {
                    case "br":
                    case "cr":
                        sb.append('\n');
                        break;
                    case "tab":
                        sb.append('\t');
                        break;
                }
            }
        }
        if (xmlObject instanceof CTFtnEdnRef) {
            CTFtnEdnRef cTFtnEdnRef = (CTFtnEdnRef) xmlObject;
            StringBuilder sb2 = cTFtnEdnRef.getDomNode().getLocalName().equals("footnoteReference") ? new StringBuilder("[footnoteRef:") : new StringBuilder("[endnoteRef:");
            sb2.append(cTFtnEdnRef.getId().intValue());
            sb2.append("]");
            sb.append(sb2.toString());
        }
    }

    private List<CTPicture> getCTPictures(XmlObject xmlObject) {
        ArrayList arrayList = new ArrayList();
        XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace pic='" + CTPicture.type.getName().getNamespaceURI() + "' .//pic:pic");
        int length = xmlObjectArrSelectPath.length;
        for (int i5 = 0; i5 < length; i5++) {
            CTPicture cTPicture = xmlObjectArrSelectPath[i5];
            if (cTPicture instanceof XmlAnyTypeImpl) {
                try {
                    cTPicture = CTPicture.Factory.parse(cTPicture.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                } catch (XmlException e) {
                    throw new POIXMLException(e);
                }
            }
            if (cTPicture instanceof CTPicture) {
                arrayList.add((CTPicture) cTPicture);
            }
        }
        return arrayList;
    }

    private CTUnderline getCTUnderline(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        if (runProperties.sizeOfUArray() > 0) {
            return runProperties.getUArray(0);
        }
        if (z6) {
            return runProperties.addNewU();
        }
        return null;
    }

    private BigDecimal getFontSizeAsBigDecimal(int i5) {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfSzArray() <= 0) {
            return null;
        }
        return BigDecimal.valueOf(Units.toPoints(POIXMLUnits.parseLength(runProperties.getSzArray(0).xgetVal()))).divide(BigDecimal.valueOf(4L), i5, RoundingMode.HALF_UP);
    }

    private void handleRuby(XmlObject xmlObject, StringBuilder sb, boolean z6) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.selectPath(".//*");
            boolean z7 = false;
            boolean z8 = false;
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRubyContent) {
                    Node domNode = object.getDomNode();
                    if (XSSFRelation.NS_WORDPROCESSINGML.equals(domNode.getNamespaceURI())) {
                        String localName = domNode.getLocalName();
                        if ("rt".equals(localName)) {
                            z7 = true;
                        } else if ("rubyBase".equals(localName)) {
                            z7 = false;
                            z8 = true;
                        }
                    }
                } else if (z6 && z7) {
                    _getText(object, sb);
                } else if (!z6 && z8) {
                    _getText(object, sb);
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

    private static boolean isCTOnOff(CTOnOff cTOnOff) {
        return !cTOnOff.isSetVal() || POIXMLUnits.parseOnOff(cTOnOff);
    }

    public static void preserveSpaces(XmlString xmlString) {
        String stringValue = xmlString.getStringValue();
        if (stringValue == null || stringValue.length() < 1) {
            return;
        }
        if (Character.isWhitespace(stringValue.charAt(0)) || Character.isWhitespace(stringValue.charAt(stringValue.length() - 1))) {
            XmlCursor xmlCursorNewCursor = xmlString.newCursor();
            try {
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.insertAttributeWithValue(new QName("http://www.w3.org/XML/1998/namespace", "space"), "preserve");
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

    public void addBreak() {
        this.run.addNewBr();
    }

    public void addCarriageReturn() {
        this.run.addNewCr();
    }

    @Internal
    public CTInline addChart(String str) {
        try {
            CTInline cTInlineAddNewInline = this.run.addNewDrawing().addNewInline();
            StringBuilder sb = new StringBuilder("<a:graphic xmlns:a=\"");
            sb.append(CTGraphicalObject.type.getName().getNamespaceURI());
            sb.append("\"><a:graphicData uri=\"");
            SchemaType schemaType = CTChart.type;
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\"><c:chart xmlns:c=\"");
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" r:id=\"");
            sb.append(str);
            sb.append("\" /></a:graphicData></a:graphic>");
            cTInlineAddNewInline.set(XmlToken.Factory.parse(DocumentHelper.readDocument(new InputSource(new StringReader(sb.toString()))).getDocumentElement(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
            cTInlineAddNewInline.setDistT(0L);
            cTInlineAddNewInline.setDistR(0L);
            cTInlineAddNewInline.setDistB(0L);
            cTInlineAddNewInline.setDistL(0L);
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewDocPr = cTInlineAddNewInline.addNewDocPr();
            long jReserveNew = getParent().getDocument().getDrawingIdManager().reserveNew();
            cTNonVisualDrawingPropsAddNewDocPr.setId(jReserveNew);
            cTNonVisualDrawingPropsAddNewDocPr.setName("chart " + jReserveNew);
            return cTInlineAddNewInline;
        } catch (XmlException | SAXException e) {
            throw new IllegalStateException(e);
        }
    }

    public XWPFPicture addPicture(InputStream inputStream, int i5, String str, int i6, int i7) {
        return addPicture(inputStream, PictureType.findByOoxmlId(i5), str, i6, i7);
    }

    public void addTab() {
        this.run.addNewTab();
    }

    @Internal
    public CTR getCTR() {
        return this.run;
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public int getCharacterSpacing() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfSpacingArray() == 0) {
            return 0;
        }
        return (int) Units.toDXA(POIXMLUnits.parseLength(runProperties.getSpacingArray(0).xgetVal()));
    }

    public String getColor() {
        CTRPr runProperties;
        if (!this.run.isSetRPr() || (runProperties = getRunProperties(false)) == null || runProperties.sizeOfColorArray() <= 0) {
            return null;
        }
        return runProperties.getColorArray(0).xgetVal().getStringValue();
    }

    public XWPFDocument getDocument() {
        IRunBody iRunBody = this.parent;
        if (iRunBody != null) {
            return iRunBody.getDocument();
        }
        return null;
    }

    public List<XWPFPicture> getEmbeddedPictures() {
        return this.pictures;
    }

    public STEm.Enum getEmphasisMark() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null) {
            return STEm.NONE;
        }
        STEm.Enum val = (runProperties.sizeOfEmArray() > 0 ? runProperties.getEmArray(0) : runProperties.addNewEm()).getVal();
        return val == null ? STEm.NONE : val;
    }

    public String getFontFamily() {
        return getFontFamily(null);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public String getFontName() {
        return getFontFamily();
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    @Removal(version = "6.0.0")
    @Deprecated
    public int getFontSize() {
        BigDecimal fontSizeAsBigDecimal = getFontSizeAsBigDecimal(0);
        if (fontSizeAsBigDecimal == null) {
            return -1;
        }
        return fontSizeAsBigDecimal.intValue();
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public Double getFontSizeAsDouble() {
        BigDecimal fontSizeAsBigDecimal = getFontSizeAsBigDecimal(1);
        if (fontSizeAsBigDecimal == null) {
            return null;
        }
        return Double.valueOf(fontSizeAsBigDecimal.doubleValue());
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public int getKerning() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfKernArray() == 0) {
            return 0;
        }
        return (int) POIXMLUnits.parseLength(runProperties.getKernArray(0).xgetVal());
    }

    public String getLang() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfLangArray() == 0) {
            return null;
        }
        return runProperties.getLangArray(0).getVal();
    }

    @Deprecated
    public XWPFParagraph getParagraph() {
        IRunBody iRunBody = this.parent;
        if (iRunBody instanceof XWPFParagraph) {
            return (XWPFParagraph) iRunBody;
        }
        return null;
    }

    public IRunBody getParent() {
        return this.parent;
    }

    public String getPhonetic() {
        StringBuilder sb = new StringBuilder(64);
        XmlCursor xmlCursorNewCursor = this.run.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRuby) {
                    handleRuby(object, sb, true);
                }
            }
            String str = this.pictureText;
            if (str != null && str.length() > 0) {
                sb.append("\n");
                sb.append(this.pictureText);
                sb.append("\n");
            }
            xmlCursorNewCursor.close();
            return sb.toString();
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

    public String getPictureText() {
        return this.pictureText;
    }

    public CTRPr getRunProperties(boolean z6) {
        CTRPr rPr = this.run.isSetRPr() ? this.run.getRPr() : null;
        return (z6 && rPr == null) ? this.run.addNewRPr() : rPr;
    }

    public String getStyle() {
        CTString rStyleArray;
        CTRPr rPr = getCTR().getRPr();
        return (rPr == null || rPr.sizeOfRStyleArray() <= 0 || (rStyleArray = rPr.getRStyleArray(0)) == null) ? "" : rStyleArray.getVal();
    }

    public String getText(int i5) {
        if (this.run.sizeOfTArray() == 0) {
            return null;
        }
        return this.run.getTArray(i5).getStringValue();
    }

    public STHighlightColor.Enum getTextHighlightColor() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null) {
            return STHighlightColor.NONE;
        }
        STHighlightColor sTHighlightColorXgetVal = (runProperties.sizeOfHighlightArray() > 0 ? runProperties.getHighlightArray(0) : runProperties.addNewHighlight()).xgetVal();
        if (sTHighlightColorXgetVal == null) {
            sTHighlightColorXgetVal = STHighlightColor.Factory.newInstance();
            sTHighlightColorXgetVal.setEnumValue(STHighlightColor.NONE);
        }
        return (STHighlightColor.Enum) sTHighlightColorXgetVal.getEnumValue();
    }

    @Removal(version = "7.0.0")
    @Deprecated
    public STHighlightColor.Enum getTextHightlightColor() {
        return getTextHighlightColor();
    }

    public int getTextPosition() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfPositionArray() <= 0) {
            return -1;
        }
        return (int) (Units.toPoints(POIXMLUnits.parseLength(runProperties.getPositionArray(0).xgetVal())) / 2.0d);
    }

    public int getTextScale() {
        int percent;
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfWArray() == 0 || (percent = POIXMLUnits.parsePercent(runProperties.getWArray(0).xgetVal())) == 0) {
            return 100;
        }
        return percent / 1000;
    }

    public UnderlinePatterns getUnderline() {
        STUnderline.Enum val;
        UnderlinePatterns underlinePatterns = UnderlinePatterns.NONE;
        CTUnderline cTUnderline = getCTUnderline(false);
        return (cTUnderline == null || (val = cTUnderline.getVal()) == null) ? underlinePatterns : UnderlinePatterns.valueOf(val.intValue());
    }

    public String getUnderlineColor() {
        Object color = getCTUnderline(true).getColor();
        if (color == null) {
            return "auto";
        }
        if (color instanceof String) {
            return (String) color;
        }
        byte[] bArr = (byte[]) color;
        return HexDump.toHex(bArr[0]) + HexDump.toHex(bArr[1]) + HexDump.toHex(bArr[2]);
    }

    public STThemeColor.Enum getUnderlineThemeColor() {
        CTUnderline cTUnderline = getCTUnderline(false);
        return cTUnderline != null ? cTUnderline.getThemeColor() : STThemeColor.NONE;
    }

    public STVerticalAlignRun.Enum getVerticalAlignment() {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null) {
            return STVerticalAlignRun.BASELINE;
        }
        STVerticalAlignRun.Enum val = (runProperties.sizeOfVertAlignArray() > 0 ? runProperties.getVertAlignArray(0) : runProperties.addNewVertAlign()).getVal();
        return val == null ? STVerticalAlignRun.BASELINE : val;
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isBold() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfBArray() > 0 && isCTOnOff(runProperties.getBArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isCapitalized() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfCapsArray() > 0 && isCTOnOff(runProperties.getCapsArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isDoubleStrikeThrough() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfDstrikeArray() > 0 && isCTOnOff(runProperties.getDstrikeArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isEmbossed() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfEmbossArray() > 0 && isCTOnOff(runProperties.getEmbossArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isHighlighted() {
        STHighlightColor.Enum val;
        CTRPr runProperties = getRunProperties(false);
        return (runProperties == null || runProperties.sizeOfHighlightArray() == 0 || (val = runProperties.getHighlightArray(0).getVal()) == null || val == STHighlightColor.NONE) ? false : true;
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isImprinted() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfImprintArray() > 0 && isCTOnOff(runProperties.getImprintArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isItalic() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfIArray() > 0 && isCTOnOff(runProperties.getIArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isShadowed() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfShadowArray() > 0 && isCTOnOff(runProperties.getShadowArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isSmallCaps() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfSmallCapsArray() > 0 && isCTOnOff(runProperties.getSmallCapsArray(0));
    }

    @Deprecated
    public boolean isStrike() {
        return isStrikeThrough();
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public boolean isStrikeThrough() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfStrikeArray() > 0 && isCTOnOff(runProperties.getStrikeArray(0));
    }

    public boolean isVanish() {
        CTRPr runProperties = getRunProperties(false);
        return runProperties != null && runProperties.sizeOfVanishArray() > 0 && isCTOnOff(runProperties.getVanishArray(0));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setBold(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfBArray() > 0 ? runProperties.getBArray(0) : runProperties.addNewB()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setCapitalized(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfCapsArray() > 0 ? runProperties.getCapsArray(0) : runProperties.addNewCaps()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setCharacterSpacing(int i5) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfSpacingArray() > 0 ? runProperties.getSpacingArray(0) : runProperties.addNewSpacing()).setVal(BigInteger.valueOf(i5));
    }

    public void setColor(String str) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfColorArray() > 0 ? runProperties.getColorArray(0) : runProperties.addNewColor()).setVal(str);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setDoubleStrikethrough(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfDstrikeArray() > 0 ? runProperties.getDstrikeArray(0) : runProperties.addNewDstrike()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setEmbossed(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfEmbossArray() > 0 ? runProperties.getEmbossArray(0) : runProperties.addNewEmboss()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    public void setEmphasisMark(String str) {
        CTRPr runProperties = getRunProperties(true);
        CTEm emArray = runProperties.sizeOfEmArray() > 0 ? runProperties.getEmArray(0) : runProperties.addNewEm();
        STEm sTEmXgetVal = emArray.xgetVal();
        if (sTEmXgetVal == null) {
            sTEmXgetVal = STEm.Factory.newInstance();
        }
        STEm.Enum enumForString = STEm.Enum.forString(str);
        if (enumForString != null) {
            sTEmXgetVal.setStringValue(enumForString.toString());
            emArray.xsetVal(sTEmXgetVal);
        }
    }

    public void setFontFamily(String str) {
        setFontFamily(str, null);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setFontSize(int i5) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i5);
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfSzArray() > 0 ? runProperties.getSzArray(0) : runProperties.addNewSz()).setVal(bigIntegerValueOf.multiply(BigInteger.valueOf(2L)));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setImprinted(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfImprintArray() > 0 ? runProperties.getImprintArray(0) : runProperties.addNewImprint()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setItalic(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfIArray() > 0 ? runProperties.getIArray(0) : runProperties.addNewI()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setKerning(int i5) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfKernArray() > 0 ? runProperties.getKernArray(0) : runProperties.addNewKern()).setVal(BigInteger.valueOf(i5));
    }

    public void setLang(String str) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfLangArray() > 0 ? runProperties.getLangArray(0) : runProperties.addNewLang()).setVal(str);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setShadow(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfShadowArray() > 0 ? runProperties.getShadowArray(0) : runProperties.addNewShadow()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setSmallCaps(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfSmallCapsArray() > 0 ? runProperties.getSmallCapsArray(0) : runProperties.addNewSmallCaps()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    @Deprecated
    public void setStrike(boolean z6) {
        setStrikeThrough(z6);
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setStrikeThrough(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfStrikeArray() > 0 ? runProperties.getStrikeArray(0) : runProperties.addNewStrike()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    public void setStyle(String str) {
        CTRPr rPr = getCTR().getRPr();
        if (rPr == null) {
            rPr = getCTR().addNewRPr();
        }
        (rPr.sizeOfRStyleArray() > 0 ? rPr.getRStyleArray(0) : rPr.addNewRStyle()).setVal(str);
    }

    public void setSubscript(VerticalAlign verticalAlign) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfVertAlignArray() > 0 ? runProperties.getVertAlignArray(0) : runProperties.addNewVertAlign()).setVal(STVerticalAlignRun.Enum.forInt(verticalAlign.getValue()));
    }

    public void setText(String str) {
        setText(str, this.run.sizeOfTArray());
    }

    public void setTextHighlightColor(String str) {
        CTRPr runProperties = getRunProperties(true);
        CTHighlight highlightArray = runProperties.sizeOfHighlightArray() > 0 ? runProperties.getHighlightArray(0) : runProperties.addNewHighlight();
        STHighlightColor sTHighlightColorXgetVal = highlightArray.xgetVal();
        if (sTHighlightColorXgetVal == null) {
            sTHighlightColorXgetVal = STHighlightColor.Factory.newInstance();
        }
        STHighlightColor.Enum enumForString = STHighlightColor.Enum.forString(str);
        if (enumForString != null) {
            sTHighlightColorXgetVal.setStringValue(enumForString.toString());
            highlightArray.xsetVal(sTHighlightColorXgetVal);
        }
    }

    public void setTextPosition(int i5) {
        BigInteger bigInteger = new BigInteger(Integer.toString(i5));
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfPositionArray() > 0 ? runProperties.getPositionArray(0) : runProperties.addNewPosition()).setVal(bigInteger);
    }

    public void setTextScale(int i5) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfWArray() > 0 ? runProperties.getWArray(0) : runProperties.addNewW()).setVal(Integer.valueOf(i5));
    }

    public void setUnderline(UnderlinePatterns underlinePatterns) {
        getCTUnderline(true).setVal(STUnderline.Enum.forInt(underlinePatterns.getValue()));
    }

    public void setUnderlineColor(String str) {
        SimpleValue simpleValue;
        CTUnderline cTUnderline = getCTUnderline(true);
        if (str.equals("auto")) {
            STHexColorAuto sTHexColorAutoNewInstance = STHexColorAuto.Factory.newInstance();
            sTHexColorAutoNewInstance.setEnumValue(STHexColorAuto.Enum.forString(str));
            simpleValue = (SimpleValue) sTHexColorAutoNewInstance;
        } else {
            STHexColorRGB sTHexColorRGBNewInstance = STHexColorRGB.Factory.newInstance();
            sTHexColorRGBNewInstance.setStringValue(str);
            simpleValue = (SimpleValue) sTHexColorRGBNewInstance;
        }
        cTUnderline.setColor(simpleValue);
    }

    public void setUnderlineThemeColor(String str) {
        CTUnderline cTUnderline = getCTUnderline(true);
        STThemeColor.Enum enumForString = STThemeColor.Enum.forString(str);
        if (enumForString != null) {
            cTUnderline.setThemeColor(enumForString);
        }
    }

    public void setVanish(boolean z6) {
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfVanishArray() > 0 ? runProperties.getVanishArray(0) : runProperties.addNewVanish()).setVal(z6 ? STOnOff1.ON : STOnOff1.OFF);
    }

    public void setVerticalAlignment(String str) {
        CTRPr runProperties = getRunProperties(true);
        CTVerticalAlignRun vertAlignArray = runProperties.sizeOfVertAlignArray() > 0 ? runProperties.getVertAlignArray(0) : runProperties.addNewVertAlign();
        STVerticalAlignRun sTVerticalAlignRunXgetVal = vertAlignArray.xgetVal();
        if (sTVerticalAlignRunXgetVal == null) {
            sTVerticalAlignRunXgetVal = STVerticalAlignRun.Factory.newInstance();
        }
        STVerticalAlignRun.Enum enumForString = STVerticalAlignRun.Enum.forString(str);
        if (enumForString != null) {
            sTVerticalAlignRunXgetVal.setStringValue(enumForString.toString());
            vertAlignArray.xsetVal(sTVerticalAlignRunXgetVal);
        }
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public String text() {
        StringBuilder sb = new StringBuilder(64);
        XmlCursor xmlCursorNewCursor = this.run.newCursor();
        try {
            xmlCursorNewCursor.selectPath("./*");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof CTRuby) {
                    handleRuby(object, sb, false);
                } else {
                    _getText(object, sb);
                }
            }
            xmlCursorNewCursor.close();
            return sb.toString();
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

    public String toString() {
        String phonetic = getPhonetic();
        if (phonetic.length() <= 0) {
            return text();
        }
        return text() + " (" + phonetic + ")";
    }

    public void addBreak(BreakType breakType) {
        this.run.addNewBr().setType(STBrType.Enum.forInt(breakType.getValue()));
    }

    public XWPFPicture addPicture(InputStream inputStream, PictureType pictureType, String str, int i5, int i6) throws InvalidFormatException {
        XWPFPictureData xWPFPictureData;
        if (pictureType == null) {
            throw new InvalidFormatException("pictureType is not supported");
        }
        if (this.parent.getPart() instanceof XWPFHeaderFooter) {
            XWPFHeaderFooter xWPFHeaderFooter = (XWPFHeaderFooter) this.parent.getPart();
            xWPFPictureData = (XWPFPictureData) xWPFHeaderFooter.getRelationById(xWPFHeaderFooter.addPictureData(inputStream, pictureType));
        } else if (this.parent.getPart() instanceof XWPFComments) {
            XWPFComments xWPFComments = (XWPFComments) this.parent.getPart();
            xWPFPictureData = (XWPFPictureData) xWPFComments.getRelationById(xWPFComments.addPictureData(inputStream, pictureType));
        } else {
            XWPFDocument document = this.parent.getDocument();
            xWPFPictureData = (XWPFPictureData) document.getRelationById(document.addPictureData(inputStream, pictureType));
        }
        try {
            CTInline cTInlineAddNewInline = this.run.addNewDrawing().addNewInline();
            StringBuilder sb = new StringBuilder("<a:graphic xmlns:a=\"");
            sb.append(CTGraphicalObject.type.getName().getNamespaceURI());
            sb.append("\"><a:graphicData uri=\"");
            SchemaType schemaType = CTPicture.type;
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\"><pic:pic xmlns:pic=\"");
            sb.append(schemaType.getName().getNamespaceURI());
            sb.append("\" /></a:graphicData></a:graphic>");
            cTInlineAddNewInline.set(XmlToken.Factory.parse(DocumentHelper.readDocument(new InputSource(new StringReader(sb.toString()))).getDocumentElement(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS));
            cTInlineAddNewInline.setDistT(0L);
            cTInlineAddNewInline.setDistR(0L);
            cTInlineAddNewInline.setDistB(0L);
            cTInlineAddNewInline.setDistL(0L);
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewDocPr = cTInlineAddNewInline.addNewDocPr();
            long jReserveNew = getParent().getDocument().getDrawingIdManager().reserveNew();
            cTNonVisualDrawingPropsAddNewDocPr.setId(jReserveNew);
            cTNonVisualDrawingPropsAddNewDocPr.setName("Drawing " + jReserveNew);
            cTNonVisualDrawingPropsAddNewDocPr.setDescr(str);
            CTPositiveSize2D cTPositiveSize2DAddNewExtent = cTInlineAddNewInline.addNewExtent();
            long j6 = i5;
            cTPositiveSize2DAddNewExtent.setCx(j6);
            long j7 = i6;
            cTPositiveSize2DAddNewExtent.setCy(j7);
            CTPicture cTPicture = getCTPictures(cTInlineAddNewInline.getGraphic().getGraphicData()).get(0);
            CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPicture.addNewNvPicPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(0L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture " + jReserveNew);
            cTNonVisualDrawingPropsAddNewCNvPr.setDescr(str);
            cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
            CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPicture.addNewBlipFill();
            cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed(this.parent.getPart().getRelationId(xWPFPictureData));
            cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTPicture.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0);
            cTPoint2DAddNewOff.setY(0);
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(j6);
            cTPositiveSize2DAddNewExt.setCy(j7);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            XWPFPicture xWPFPicture = new XWPFPicture(cTPicture, this);
            this.pictures.add(xWPFPicture);
            return xWPFPicture;
        } catch (XmlException | SAXException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getFontFamily(FontCharRange fontCharRange) {
        CTRPr runProperties = getRunProperties(false);
        if (runProperties == null || runProperties.sizeOfRFontsArray() == 0) {
            return null;
        }
        CTFonts rFontsArray = runProperties.getRFontsArray(0);
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange;
        if (fontCharRange == null) {
            fontCharRange = FontCharRange.ascii;
        }
        int i5 = iArr[fontCharRange.ordinal()];
        if (i5 == 2) {
            return rFontsArray.getCs();
        }
        if (i5 != 3) {
            return i5 != 4 ? rFontsArray.getAscii() : rFontsArray.getHAnsi();
        }
        return rFontsArray.getEastAsia();
    }

    public void setFontFamily(String str, FontCharRange fontCharRange) {
        CTRPr runProperties = getRunProperties(true);
        CTFonts rFontsArray = runProperties.sizeOfRFontsArray() > 0 ? runProperties.getRFontsArray(0) : runProperties.addNewRFonts();
        if (fontCharRange == null) {
            rFontsArray.setAscii(str);
            if (!rFontsArray.isSetHAnsi()) {
                rFontsArray.setHAnsi(str);
            }
            if (!rFontsArray.isSetCs()) {
                rFontsArray.setCs(str);
            }
            if (rFontsArray.isSetEastAsia()) {
                return;
            }
            rFontsArray.setEastAsia(str);
            return;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$xwpf$usermodel$XWPFRun$FontCharRange[fontCharRange.ordinal()];
        if (i5 == 1) {
            rFontsArray.setAscii(str);
            return;
        }
        if (i5 == 2) {
            rFontsArray.setCs(str);
        } else if (i5 == 3) {
            rFontsArray.setEastAsia(str);
        } else {
            if (i5 != 4) {
                return;
            }
            rFontsArray.setHAnsi(str);
        }
    }

    public void setText(String str, int i5) {
        if (i5 > this.run.sizeOfTArray()) {
            throw new ArrayIndexOutOfBoundsException("Value too large for the parameter position in XWPFRun.setText(String value,int pos)");
        }
        CTText cTTextAddNewT = (i5 >= this.run.sizeOfTArray() || i5 < 0) ? this.run.addNewT() : this.run.getTArray(i5);
        cTTextAddNewT.setStringValue(str);
        preserveSpaces(cTTextAddNewT);
    }

    public void addBreak(BreakClear breakClear) {
        CTBr cTBrAddNewBr = this.run.addNewBr();
        cTBrAddNewBr.setType(STBrType.Enum.forInt(BreakType.TEXT_WRAPPING.getValue()));
        cTBrAddNewBr.setClear(STBrClear.Enum.forInt(breakClear.getValue()));
    }

    @Override // org.apache.poi.wp.usermodel.CharacterRun
    public void setFontSize(double d) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d);
        CTRPr runProperties = getRunProperties(true);
        (runProperties.sizeOfSzArray() > 0 ? runProperties.getSzArray(0) : runProperties.addNewSz()).setVal(bigDecimalValueOf.multiply(BigDecimal.valueOf(2L)).setScale(0, RoundingMode.HALF_UP).toBigInteger());
    }

    public void removeBreak() {
    }

    public void removeCarriageReturn() {
    }

    public void removeTab() {
    }

    @Deprecated
    public XWPFRun(CTR ctr, XWPFParagraph xWPFParagraph) {
        this(ctr, (IRunBody) xWPFParagraph);
    }
}
