package org.apache.poi.xssf.usermodel;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.SimpleShape;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFColorRgbBinary;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.opencv.videoio.Videoio;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextHorzOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVertOverflowType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShapeNonVisual;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRPrElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFSimpleShape extends XSSFShape implements Iterable<XSSFTextParagraph>, SimpleShape, TextContainer {
    private static CTShape prototype;
    private final List<XSSFTextParagraph> _paragraphs;
    private final XDDFTextBody _textBody;
    private CTShape ctShape;
    private static String[] _romanChars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
    private static int[] _romanAlphaValues = {1000, 900, Videoio.CAP_QT, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.XSSFSimpleShape$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit;

        static {
            int[] iArr = new int[TextAutofit.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit = iArr;
            try {
                iArr[TextAutofit.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[TextAutofit.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ListAutoNumber.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber = iArr2;
            try {
                iArr2[ListAutoNumber.ALPHA_LC_PARENT_BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PARENT_R.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_BOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PARENT_R.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_LC_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ALPHA_UC_PERIOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_BOTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PARENT_R.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PERIOD.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ARABIC_PLAIN.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_BOTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PARENT_R.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_BOTH.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PARENT_R.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_LC_PERIOD.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[ListAutoNumber.ROMAN_UC_PERIOD.ordinal()] = 16;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public XSSFSimpleShape(XSSFDrawing xSSFDrawing, CTShape cTShape) {
        this.drawing = xSSFDrawing;
        this.ctShape = cTShape;
        this._paragraphs = new ArrayList();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody == null) {
            this._textBody = null;
            return;
        }
        this._textBody = new XDDFTextBody(this, txBody);
        for (int i5 = 0; i5 < txBody.sizeOfPArray(); i5++) {
            this._paragraphs.add(new XSSFTextParagraph(txBody.getPArray(i5), cTShape));
        }
    }

    private static void applyAttributes(CTRPrElt cTRPrElt, CTTextCharacterProperties cTTextCharacterProperties) {
        HSSFColor hSSFColor;
        if (cTRPrElt.sizeOfBArray() > 0) {
            cTTextCharacterProperties.setB(cTRPrElt.getBArray(0).getVal());
        }
        if (cTRPrElt.sizeOfUArray() > 0) {
            STUnderlineValues.Enum val = cTRPrElt.getUArray(0).getVal();
            if (val == STUnderlineValues.SINGLE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.SNG);
            } else if (val == STUnderlineValues.DOUBLE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.DBL);
            } else if (val == STUnderlineValues.NONE) {
                cTTextCharacterProperties.setU(STTextUnderlineType.NONE);
            }
        }
        if (cTRPrElt.sizeOfIArray() > 0) {
            cTTextCharacterProperties.setI(cTRPrElt.getIArray(0).getVal());
        }
        if (cTRPrElt.sizeOfRFontArray() > 0) {
            (cTTextCharacterProperties.isSetLatin() ? cTTextCharacterProperties.getLatin() : cTTextCharacterProperties.addNewLatin()).setTypeface(cTRPrElt.getRFontArray(0).getVal());
        }
        if (cTRPrElt.sizeOfSzArray() > 0) {
            cTTextCharacterProperties.setSz((int) (cTRPrElt.getSzArray(0).getVal() * 100.0d));
        }
        if (cTRPrElt.sizeOfColorArray() > 0) {
            CTSolidColorFillProperties solidFill = cTTextCharacterProperties.isSetSolidFill() ? cTTextCharacterProperties.getSolidFill() : cTTextCharacterProperties.addNewSolidFill();
            CTColor colorArray = cTRPrElt.getColorArray(0);
            if (colorArray.isSetRgb()) {
                (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(colorArray.getRgb());
            } else {
                if (!colorArray.isSetIndexed() || (hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf((int) colorArray.getIndexed()))) == null) {
                    return;
                }
                (solidFill.isSetSrgbClr() ? solidFill.getSrgbClr() : solidFill.addNewSrgbClr()).setVal(new byte[]{(byte) hSSFColor.getTriplet()[0], (byte) hSSFColor.getTriplet()[1], (byte) hSSFColor.getTriplet()[2]});
            }
        }
    }

    private String getBulletPrefix(ListAutoNumber listAutoNumber, int i5) {
        StringBuilder sb = new StringBuilder();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$ListAutoNumber[listAutoNumber.ordinal()]) {
            case 1:
            case 2:
                if (listAutoNumber == ListAutoNumber.ALPHA_LC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToAlpha(i5).toLowerCase(Locale.ROOT));
                sb.append(')');
                break;
            case 3:
            case 4:
                if (listAutoNumber == ListAutoNumber.ALPHA_UC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToAlpha(i5));
                sb.append(')');
                break;
            case 5:
                sb.append(valueToAlpha(i5).toLowerCase(Locale.ROOT));
                sb.append('.');
                break;
            case 6:
                sb.append(valueToAlpha(i5));
                sb.append('.');
                break;
            case 7:
            case 8:
                if (listAutoNumber == ListAutoNumber.ARABIC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(i5);
                sb.append(')');
                break;
            case 9:
                sb.append(i5);
                sb.append('.');
                break;
            case 10:
                sb.append(i5);
                break;
            case 11:
            case 12:
                if (listAutoNumber == ListAutoNumber.ROMAN_LC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToRoman(i5).toLowerCase(Locale.ROOT));
                sb.append(')');
                break;
            case 13:
            case 14:
                if (listAutoNumber == ListAutoNumber.ROMAN_UC_PARENT_BOTH) {
                    sb.append('(');
                }
                sb.append(valueToRoman(i5));
                sb.append(')');
                break;
            case 15:
                sb.append(valueToRoman(i5).toLowerCase(Locale.ROOT));
                sb.append('.');
                break;
            case 16:
                sb.append(valueToRoman(i5));
                sb.append('.');
                break;
            default:
                sb.append((char) 8226);
                break;
        }
        sb.append(" ");
        return sb.toString();
    }

    private int processAutoNumGroup(int i5, int i6, List<Integer> list, StringBuilder sb) {
        XSSFTextParagraph xSSFTextParagraph = this._paragraphs.get(i5);
        int bulletAutoNumberStart = xSSFTextParagraph.getBulletAutoNumberStart();
        ListAutoNumber bulletAutoNumberScheme = xSSFTextParagraph.getBulletAutoNumberScheme();
        if (list.get(i6).intValue() == 0) {
            list.set(i6, Integer.valueOf(bulletAutoNumberStart == 0 ? 1 : bulletAutoNumberStart));
        }
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append('\t');
        }
        if (xSSFTextParagraph.getText().length() > 0) {
            sb.append(getBulletPrefix(bulletAutoNumberScheme, list.get(i6).intValue()));
            sb.append(xSSFTextParagraph.getText());
        }
        while (true) {
            int i8 = i5 + 1;
            XSSFTextParagraph xSSFTextParagraph2 = i8 == this._paragraphs.size() ? null : this._paragraphs.get(i8);
            if (xSSFTextParagraph2 == null || !xSSFTextParagraph2.isBullet() || !xSSFTextParagraph.isBulletAutoNumber()) {
                break;
            }
            if (xSSFTextParagraph2.getLevel() > i6) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                i5 = processAutoNumGroup(i8, xSSFTextParagraph2.getLevel(), list, sb);
            } else {
                if (xSSFTextParagraph2.getLevel() < i6) {
                    break;
                }
                ListAutoNumber bulletAutoNumberScheme2 = xSSFTextParagraph2.getBulletAutoNumberScheme();
                int bulletAutoNumberStart2 = xSSFTextParagraph2.getBulletAutoNumberStart();
                if (bulletAutoNumberScheme2 != bulletAutoNumberScheme || bulletAutoNumberStart2 != bulletAutoNumberStart) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                for (int i9 = 0; i9 < i6; i9++) {
                    sb.append('\t');
                }
                if (xSSFTextParagraph2.getText().length() > 0) {
                    list.set(i6, Integer.valueOf(list.get(i6).intValue() + 1));
                    sb.append(getBulletPrefix(bulletAutoNumberScheme2, list.get(i6).intValue()));
                    sb.append(xSSFTextParagraph2.getText());
                }
                i5 = i8;
            }
        }
        list.set(i6, 0);
        return i5;
    }

    public static CTShape prototype() {
        if (prototype == null) {
            CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
            CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Shape 1");
            cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTShapeNewInstance.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0);
            cTPoint2DAddNewOff.setY(0);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            new XDDFTextBody(null, cTShapeNewInstance.addNewTxBody()).initialize().getAfterLastRunProperties().setFillProperties(new XDDFSolidFillProperties(new XDDFColorRgbBinary(new byte[]{0, 0, 0})));
            prototype = cTShapeNewInstance;
        }
        return prototype;
    }

    private String valueToAlpha(int i5) {
        StringBuilder sb = new StringBuilder();
        while (i5 > 0) {
            int i6 = (i5 - 1) % 26;
            sb.append((char) (i6 + 65));
            i5 = (i5 - i6) / 26;
        }
        sb.reverse();
        return sb.toString();
    }

    private String valueToRoman(int i5) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i5 > 0 && i6 < _romanChars.length; i6++) {
            while (_romanAlphaValues[i6] <= i5) {
                sb.append(_romanChars[i6]);
                i5 -= _romanAlphaValues[i6];
            }
        }
        return sb.toString();
    }

    public XSSFTextParagraph addNewTextParagraph() {
        XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(this.ctShape.getTxBody().addNewP(), this.ctShape);
        this._paragraphs.add(xSSFTextParagraph);
        return xSSFTextParagraph;
    }

    public void clearText() {
        this._paragraphs.clear();
        this.ctShape.getTxBody().setPArray(null);
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        return Optional.empty();
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        return Optional.empty();
    }

    public double getBottomInset() {
        Double bottomInset = this._textBody.getBodyProperties().getBottomInset();
        if (bottomInset == null) {
            return 3.6d;
        }
        return bottomInset.doubleValue();
    }

    @Internal
    public CTShape getCTShape() {
        return this.ctShape;
    }

    public double getLeftInset() {
        Double leftInset = this._textBody.getBodyProperties().getLeftInset();
        if (leftInset == null) {
            return 3.6d;
        }
        return leftInset.doubleValue();
    }

    public double getRightInset() {
        Double rightInset = this._textBody.getBodyProperties().getRightInset();
        if (rightInset == null) {
            return 3.6d;
        }
        return rightInset.doubleValue();
    }

    @Override // org.apache.poi.ss.usermodel.SimpleShape
    public int getShapeId() {
        return (int) this.ctShape.getNvSpPr().getCNvPr().getId();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        return this.ctShape.getNvSpPr().getCNvPr().getName();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFShape
    public CTShapeProperties getShapeProperties() {
        return this.ctShape.getSpPr();
    }

    public int getShapeType() {
        return this.ctShape.getSpPr().getPrstGeom().getPrst().intValue();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(9);
        for (int i5 = 0; i5 < 9; i5++) {
            arrayList.add(0);
        }
        int iProcessAutoNumGroup = 0;
        while (iProcessAutoNumGroup < this._paragraphs.size()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            XSSFTextParagraph xSSFTextParagraph = this._paragraphs.get(iProcessAutoNumGroup);
            if (!xSSFTextParagraph.isBullet() || xSSFTextParagraph.getText().length() <= 0) {
                sb.append(xSSFTextParagraph.getText());
                for (int i6 = 0; i6 < 9; i6++) {
                    arrayList.set(i6, 0);
                }
            } else {
                int iMin = Math.min(xSSFTextParagraph.getLevel(), 8);
                if (xSSFTextParagraph.isBulletAutoNumber()) {
                    iProcessAutoNumGroup = processAutoNumGroup(iProcessAutoNumGroup, iMin, arrayList, sb);
                } else {
                    for (int i7 = 0; i7 < iMin; i7++) {
                        sb.append('\t');
                    }
                    String bulletCharacter = xSSFTextParagraph.getBulletCharacter();
                    sb.append(bulletCharacter.length() > 0 ? bulletCharacter.concat(" ") : "- ");
                    sb.append(xSSFTextParagraph.getText());
                }
            }
            iProcessAutoNumGroup++;
        }
        return sb.toString();
    }

    public TextAutofit getTextAutofit() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (bodyPr.isSetNoAutofit()) {
                return TextAutofit.NONE;
            }
            if (bodyPr.isSetNormAutofit()) {
                return TextAutofit.NORMAL;
            }
            if (bodyPr.isSetSpAutoFit()) {
                return TextAutofit.SHAPE;
            }
        }
        return TextAutofit.NORMAL;
    }

    public XDDFTextBody getTextBody() {
        return this._textBody;
    }

    public TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return (bodyPr == null || (vert = bodyPr.getVert()) == null) ? TextDirection.HORIZONTAL : TextDirection.values()[vert.intValue() - 1];
    }

    public TextHorizontalOverflow getTextHorizontalOverflow() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return (bodyPr == null || !bodyPr.isSetHorzOverflow()) ? TextHorizontalOverflow.OVERFLOW : TextHorizontalOverflow.values()[bodyPr.getHorzOverflow().intValue() - 1];
    }

    public List<XSSFTextParagraph> getTextParagraphs() {
        return this._paragraphs;
    }

    public TextVerticalOverflow getTextVerticalOverflow() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return (bodyPr == null || !bodyPr.isSetVertOverflow()) ? TextVerticalOverflow.OVERFLOW : TextVerticalOverflow.values()[bodyPr.getVertOverflow().intValue() - 1];
    }

    public double getTopInset() {
        Double topInset = this._textBody.getBodyProperties().getTopInset();
        if (topInset == null) {
            return 3.6d;
        }
        return topInset.doubleValue();
    }

    public VerticalAlignment getVerticalAlignment() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return (bodyPr == null || !bodyPr.isSetAnchor()) ? VerticalAlignment.TOP : VerticalAlignment.values()[bodyPr.getAnchor().intValue() - 1];
    }

    public boolean getWordWrap() {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        return bodyPr == null || !bodyPr.isSetWrap() || bodyPr.getWrap() == STTextWrappingType.SQUARE;
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFTextParagraph> iterator() {
        return this._paragraphs.iterator();
    }

    public void setBottomInset(double d) {
        if (d == -1.0d) {
            this._textBody.getBodyProperties().setBottomInset(null);
        } else {
            this._textBody.getBodyProperties().setBottomInset(Double.valueOf(d));
        }
    }

    public void setLeftInset(double d) {
        if (d == -1.0d) {
            this._textBody.getBodyProperties().setLeftInset(null);
        } else {
            this._textBody.getBodyProperties().setLeftInset(Double.valueOf(d));
        }
    }

    public void setRightInset(double d) {
        if (d == -1.0d) {
            this._textBody.getBodyProperties().setRightInset(null);
        } else {
            this._textBody.getBodyProperties().setRightInset(Double.valueOf(d));
        }
    }

    public void setShapeType(int i5) {
        this.ctShape.getSpPr().getPrstGeom().setPrst(STShapeType.Enum.forInt(i5));
    }

    public void setText(String str) {
        clearText();
        addNewTextParagraph().addNewTextRun().setText(str);
    }

    public void setTextAutofit(TextAutofit textAutofit) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (bodyPr.isSetSpAutoFit()) {
                bodyPr.unsetSpAutoFit();
            }
            if (bodyPr.isSetNoAutofit()) {
                bodyPr.unsetNoAutofit();
            }
            if (bodyPr.isSetNormAutofit()) {
                bodyPr.unsetNormAutofit();
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$TextAutofit[textAutofit.ordinal()];
            if (i5 == 1) {
                bodyPr.addNewNoAutofit();
            } else if (i5 == 2) {
                bodyPr.addNewNormAutofit();
            } else {
                if (i5 != 3) {
                    return;
                }
                bodyPr.addNewSpAutoFit();
            }
        }
    }

    public void setTextDirection(TextDirection textDirection) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textDirection != null) {
                bodyPr.setVert(STTextVerticalType.Enum.forInt(textDirection.ordinal() + 1));
            } else if (bodyPr.isSetVert()) {
                bodyPr.unsetVert();
            }
        }
    }

    public void setTextHorizontalOverflow(TextHorizontalOverflow textHorizontalOverflow) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textHorizontalOverflow != null) {
                bodyPr.setHorzOverflow(STTextHorzOverflowType.Enum.forInt(textHorizontalOverflow.ordinal() + 1));
            } else if (bodyPr.isSetHorzOverflow()) {
                bodyPr.unsetHorzOverflow();
            }
        }
    }

    public void setTextVerticalOverflow(TextVerticalOverflow textVerticalOverflow) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (textVerticalOverflow != null) {
                bodyPr.setVertOverflow(STTextVertOverflowType.Enum.forInt(textVerticalOverflow.ordinal() + 1));
            } else if (bodyPr.isSetVertOverflow()) {
                bodyPr.unsetVertOverflow();
            }
        }
    }

    public void setTopInset(double d) {
        if (d == -1.0d) {
            this._textBody.getBodyProperties().setTopInset(null);
        } else {
            this._textBody.getBodyProperties().setTopInset(Double.valueOf(d));
        }
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            if (verticalAlignment != null) {
                bodyPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
            } else if (bodyPr.isSetAnchor()) {
                bodyPr.unsetAnchor();
            }
        }
    }

    public void setWordWrap(boolean z6) {
        CTTextBodyProperties bodyPr = this.ctShape.getTxBody().getBodyPr();
        if (bodyPr != null) {
            bodyPr.setWrap(z6 ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
        }
    }

    public void setXfrm(CTTransform2D cTTransform2D) {
        this.ctShape.getSpPr().setXfrm(cTTransform2D);
    }

    @Override // java.lang.Iterable
    public Spliterator<XSSFTextParagraph> spliterator() {
        return this._paragraphs.spliterator();
    }

    public void setText(XSSFRichTextString xSSFRichTextString) {
        xSSFRichTextString.setStylesTableReference(((XSSFWorkbook) getDrawing().getParent().getParent()).getStylesSource());
        CTTextParagraph cTTextParagraphNewInstance = CTTextParagraph.Factory.newInstance();
        if (xSSFRichTextString.numFormattingRuns() == 0) {
            CTRegularTextRun cTRegularTextRunAddNewR = cTTextParagraphNewInstance.addNewR();
            CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr = cTRegularTextRunAddNewR.addNewRPr();
            cTTextCharacterPropertiesAddNewRPr.setLang("en-US");
            cTTextCharacterPropertiesAddNewRPr.setSz(Videoio.CAP_XIAPI);
            cTRegularTextRunAddNewR.setT(xSSFRichTextString.getString());
        } else {
            for (int i5 = 0; i5 < xSSFRichTextString.getCTRst().sizeOfRArray(); i5++) {
                CTRElt rArray = xSSFRichTextString.getCTRst().getRArray(i5);
                CTRPrElt rPr = rArray.getRPr();
                if (rPr == null) {
                    rPr = rArray.addNewRPr();
                }
                CTRegularTextRun cTRegularTextRunAddNewR2 = cTTextParagraphNewInstance.addNewR();
                CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr2 = cTRegularTextRunAddNewR2.addNewRPr();
                cTTextCharacterPropertiesAddNewRPr2.setLang("en-US");
                applyAttributes(rPr, cTTextCharacterPropertiesAddNewRPr2);
                cTRegularTextRunAddNewR2.setT(rArray.getT());
            }
        }
        clearText();
        this.ctShape.getTxBody().setPArray(new CTTextParagraph[]{cTTextParagraphNewInstance});
        this._paragraphs.add(new XSSFTextParagraph(this.ctShape.getTxBody().getPArray(0), this.ctShape));
    }

    public XSSFTextParagraph addNewTextParagraph(String str) {
        XSSFTextParagraph xSSFTextParagraphAddNewTextParagraph = addNewTextParagraph();
        xSSFTextParagraphAddNewTextParagraph.addNewTextRun().setText(str);
        return xSSFTextParagraphAddNewTextParagraph;
    }

    public XSSFTextParagraph addNewTextParagraph(XSSFRichTextString xSSFRichTextString) {
        CTTextParagraph cTTextParagraphAddNewP = this.ctShape.getTxBody().addNewP();
        if (xSSFRichTextString.numFormattingRuns() == 0) {
            CTRegularTextRun cTRegularTextRunAddNewR = cTTextParagraphAddNewP.addNewR();
            CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr = cTRegularTextRunAddNewR.addNewRPr();
            cTTextCharacterPropertiesAddNewRPr.setLang("en-US");
            cTTextCharacterPropertiesAddNewRPr.setSz(Videoio.CAP_XIAPI);
            cTRegularTextRunAddNewR.setT(xSSFRichTextString.getString());
        } else {
            for (int i5 = 0; i5 < xSSFRichTextString.getCTRst().sizeOfRArray(); i5++) {
                CTRElt rArray = xSSFRichTextString.getCTRst().getRArray(i5);
                CTRPrElt rPr = rArray.getRPr();
                if (rPr == null) {
                    rPr = rArray.addNewRPr();
                }
                CTRegularTextRun cTRegularTextRunAddNewR2 = cTTextParagraphAddNewP.addNewR();
                CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr2 = cTRegularTextRunAddNewR2.addNewRPr();
                cTTextCharacterPropertiesAddNewRPr2.setLang("en-US");
                applyAttributes(rPr, cTTextCharacterPropertiesAddNewRPr2);
                cTRegularTextRunAddNewR2.setT(rArray.getT());
            }
        }
        XSSFTextParagraph xSSFTextParagraph = new XSSFTextParagraph(cTTextParagraphAddNewP, this.ctShape);
        this._paragraphs.add(xSSFTextParagraph);
        return xSSFTextParagraph;
    }
}
