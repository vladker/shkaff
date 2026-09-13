package org.apache.poi.xslf.usermodel;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.StrokeStyle;
import org.apache.poi.sl.usermodel.TableCell;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTableCell extends XSLFTextShape implements TableCell<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CTTableCellProperties _tcPr;
    private Rectangle2D anchor;
    private int col;
    private int row;
    private final XSLFTable table;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTableCell$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection;

        static {
            int[] iArr = new int[TextShape.TextDirection.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection = iArr;
            try {
                iArr[TextShape.TextDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.VERTICAL_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[TextShape.TextDirection.STACKED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TableCell.BorderEdge.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge = iArr2;
            try {
                iArr2[TableCell.BorderEdge.bottom.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.left.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.top.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[TableCell.BorderEdge.right.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class XSLFCellTextParagraph extends XSLFTextParagraph {
        private XSLFCellTextParagraph(CTTextParagraph cTTextParagraph, XSLFTextShape xSLFTextShape) {
            super(cTTextParagraph, xSLFTextShape);
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextParagraph
        public XSLFCellTextRun newTextRun(XmlObject xmlObject) {
            return new XSLFCellTextRun(xmlObject, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class XSLFCellTextRun extends XSLFTextRun {
        private CTTableStyleTextStyle getTextStyle() {
            CTTablePartStyle tablePartStyle = XSLFTableCell.this.getTablePartStyle(null);
            if (tablePartStyle == null || !tablePartStyle.isSetTcTxStyle()) {
                tablePartStyle = XSLFTableCell.this.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl);
            }
            if (tablePartStyle == null) {
                return null;
            }
            return tablePartStyle.getTcTxStyle();
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public PaintStyle getFontColor() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.getFontColor();
            }
            CTFontReference fontRef = textStyle.getFontRef();
            return DrawPaint.createSolidPaint(new XSLFColor(textStyle, XSLFTableCell.this.getSheet().getTheme(), fontRef != null ? fontRef.getSchemeClr() : null, XSLFTableCell.this.getSheet()).getColorStyle());
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public boolean isBold() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.isBold();
            }
            return textStyle.isSetB() && textStyle.getB().intValue() == 1;
        }

        @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.sl.usermodel.TextRun
        public boolean isItalic() {
            CTTableStyleTextStyle textStyle = getTextStyle();
            if (textStyle == null) {
                return super.isItalic();
            }
            return textStyle.isSetI() && textStyle.getI().intValue() == 1;
        }

        private XSLFCellTextRun(XmlObject xmlObject, XSLFTextParagraph xSLFTextParagraph) {
            super(xmlObject, xSLFTextParagraph);
        }
    }

    public XSLFTableCell(CTTableCell cTTableCell, XSLFTable xSLFTable) {
        super(cTTableCell, xSLFTable.getSheet());
        this.table = xSLFTable;
    }

    private CTLineProperties getCTLine(TableCell.BorderEdge borderEdge, boolean z6) {
        if (borderEdge == null) {
            throw new IllegalArgumentException("BorderEdge needs to be specified.");
        }
        CTTableCellProperties cellProperties = getCellProperties(z6);
        if (cellProperties == null) {
            return null;
        }
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
        if (i5 == 1) {
            if (cellProperties.isSetLnB()) {
                return cellProperties.getLnB();
            }
            if (z6) {
                return cellProperties.addNewLnB();
            }
            return null;
        }
        if (i5 == 2) {
            if (cellProperties.isSetLnL()) {
                return cellProperties.getLnL();
            }
            if (z6) {
                return cellProperties.addNewLnL();
            }
            return null;
        }
        if (i5 == 3) {
            if (cellProperties.isSetLnT()) {
                return cellProperties.getLnT();
            }
            if (z6) {
                return cellProperties.addNewLnT();
            }
            return null;
        }
        if (i5 != 4) {
            return null;
        }
        if (cellProperties.isSetLnR()) {
            return cellProperties.getLnR();
        }
        if (z6) {
            return cellProperties.addNewLnR();
        }
        return null;
    }

    private CTTableCell getCell() {
        return (CTTableCell) getXmlObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CTTablePartStyle getTablePartStyle(XSLFTableStyle.TablePartStyle tablePartStyle) {
        CTTable cTTable = this.table.getCTTable();
        if (!cTTable.isSetTblPr()) {
            return null;
        }
        CTTableProperties tblPr = cTTable.getTblPr();
        boolean z6 = false;
        boolean z7 = tblPr.isSetBandRow() && tblPr.getBandRow();
        int i5 = (tblPr.isSetFirstRow() && tblPr.getFirstRow()) ? 1 : 0;
        boolean z8 = tblPr.isSetLastRow() && tblPr.getLastRow();
        boolean z9 = tblPr.isSetBandCol() && tblPr.getBandCol();
        int i6 = (tblPr.isSetFirstCol() && tblPr.getFirstCol()) ? 1 : 0;
        if (tblPr.isSetLastCol() && tblPr.getLastCol()) {
            z6 = true;
        }
        if (tablePartStyle == null) {
            int i7 = this.row;
            if (i7 == 0 && i5 != 0) {
                tablePartStyle = XSLFTableStyle.TablePartStyle.firstRow;
            } else if (i7 == this.table.getNumberOfRows() - 1 && z8) {
                tablePartStyle = XSLFTableStyle.TablePartStyle.lastRow;
            } else {
                int i8 = this.col;
                if (i8 == 0 && i6 != 0) {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.firstCol;
                } else if (i8 == this.table.getNumberOfColumns() - 1 && z6) {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.lastCol;
                } else {
                    tablePartStyle = XSLFTableStyle.TablePartStyle.wholeTbl;
                    int i9 = this.row + i5;
                    int i10 = this.col + i6;
                    if (z7 && (i9 & 1) == 0) {
                        tablePartStyle = XSLFTableStyle.TablePartStyle.band1H;
                    } else if (z9 && (i10 & 1) == 0) {
                        tablePartStyle = XSLFTableStyle.TablePartStyle.band1V;
                    }
                }
            }
        }
        XSLFTableStyle tableStyle = this.table.getTableStyle();
        if (tableStyle == null) {
            return null;
        }
        CTTablePartStyle tablePartStyle2 = tableStyle.getTablePartStyle(tablePartStyle);
        return tablePartStyle2 == null ? tableStyle.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl) : tablePartStyle2;
    }

    public static CTTableCell prototype() {
        CTTableCell cTTableCellNewInstance = CTTableCell.Factory.newInstance();
        CTTableCellProperties cTTableCellPropertiesAddNewTcPr = cTTableCellNewInstance.addNewTcPr();
        cTTableCellPropertiesAddNewTcPr.addNewLnL().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnR().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnT().addNewNoFill();
        cTTableCellPropertiesAddNewTcPr.addNewLnB().addNewNoFill();
        return cTTableCellNewInstance;
    }

    private CTLineProperties setBorderDefaults(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, true);
        if (cTLine == null) {
            throw new IllegalStateException("CTLineProperties couldn't be initialized");
        }
        if (cTLine.isSetNoFill()) {
            cTLine.unsetNoFill();
        }
        if (!cTLine.isSetPrstDash()) {
            cTLine.addNewPrstDash().setVal(STPresetLineDashVal.SOLID);
        }
        if (!cTLine.isSetCmpd()) {
            cTLine.setCmpd(STCompoundLine.SNG);
        }
        if (!cTLine.isSetAlgn()) {
            cTLine.setAlgn(STPenAlignment.CTR);
        }
        if (!cTLine.isSetCap()) {
            cTLine.setCap(STLineCap.FLAT);
        }
        if (!cTLine.isSetRound()) {
            cTLine.addNewRound();
        }
        if (!cTLine.isSetHeadEnd()) {
            CTLineEndProperties cTLineEndPropertiesAddNewHeadEnd = cTLine.addNewHeadEnd();
            cTLineEndPropertiesAddNewHeadEnd.setType(STLineEndType.NONE);
            cTLineEndPropertiesAddNewHeadEnd.setW(STLineEndWidth.MED);
            cTLineEndPropertiesAddNewHeadEnd.setLen(STLineEndLength.MED);
        }
        if (!cTLine.isSetTailEnd()) {
            CTLineEndProperties cTLineEndPropertiesAddNewTailEnd = cTLine.addNewTailEnd();
            cTLineEndPropertiesAddNewTailEnd.setType(STLineEndType.NONE);
            cTLineEndPropertiesAddNewTailEnd.setW(STLineEndWidth.MED);
            cTLineEndPropertiesAddNewTailEnd.setLen(STLineEndLength.MED);
        }
        return cTLine;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.Shape, org.apache.poi.sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        if (this.anchor == null) {
            this.table.updateCellAnchor();
        }
        return this.anchor;
    }

    public StrokeStyle.LineCap getBorderCap(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetCap()) {
            return null;
        }
        return StrokeStyle.LineCap.fromOoxmlId(cTLine.getCap().intValue());
    }

    public Color getBorderColor(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill()) {
            return null;
        }
        CTSolidColorFillProperties solidFill = cTLine.getSolidFill();
        return new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr(), getSheet()).getColor();
    }

    public StrokeStyle.LineCompound getBorderCompound(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetCmpd()) {
            return null;
        }
        return StrokeStyle.LineCompound.fromOoxmlId(cTLine.getCmpd().intValue());
    }

    public StrokeStyle.LineDash getBorderDash(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || cTLine.isSetNoFill() || !cTLine.isSetSolidFill() || !cTLine.isSetPrstDash()) {
            return null;
        }
        return StrokeStyle.LineDash.fromOoxmlId(cTLine.getPrstDash().getVal().intValue());
    }

    public XDDFLineProperties getBorderProperties(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null) {
            return null;
        }
        return new XDDFLineProperties(cTLine);
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public StrokeStyle getBorderStyle(final TableCell.BorderEdge borderEdge) {
        final Double borderWidth = getBorderWidth(borderEdge);
        if (borderWidth == null) {
            return null;
        }
        return new StrokeStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFTableCell.1
            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCap getLineCap() {
                return XSLFTableCell.this.getBorderCap(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineCompound getLineCompound() {
                return XSLFTableCell.this.getBorderCompound(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public StrokeStyle.LineDash getLineDash() {
                return XSLFTableCell.this.getBorderDash(borderEdge);
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public double getLineWidth() {
                return borderWidth.doubleValue();
            }

            @Override // org.apache.poi.sl.usermodel.StrokeStyle
            public PaintStyle getPaint() {
                return DrawPaint.createSolidPaint(XSLFTableCell.this.getBorderColor(borderEdge));
            }
        };
    }

    public Double getBorderWidth(TableCell.BorderEdge borderEdge) {
        CTLineProperties cTLine = getCTLine(borderEdge, false);
        if (cTLine == null || !cTLine.isSetW()) {
            return null;
        }
        return Double.valueOf(Units.toPoints(cTLine.getW()));
    }

    public CTTableCellProperties getCellProperties(boolean z6) {
        if (this._tcPr == null) {
            CTTableCell cell = getCell();
            CTTableCellProperties tcPr = cell.getTcPr();
            this._tcPr = tcPr;
            if (tcPr == null && z6) {
                this._tcPr = cell.addNewTcPr();
            }
        }
        return this._tcPr;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public Color getFillColor() {
        PaintStyle fillPaint = getFillPaint();
        if (fillPaint instanceof PaintStyle.SolidPaint) {
            return DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) fillPaint).getSolidColor());
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public PaintStyle getFillPaint() {
        XSLFTableCell xSLFTableCell;
        XmlObject fillRef;
        PaintStyle paintStyleSelectPaint;
        XSLFSheet sheet = getSheet();
        XSLFTheme theme = sheet.getTheme();
        boolean z6 = getPlaceholder() != null;
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(getCellProperties(false));
        if (fillDelegate != null) {
            xSLFTableCell = this;
            PaintStyle paintStyleSelectPaint2 = xSLFTableCell.selectPaint(fillDelegate, null, sheet.getPackagePart(), theme, z6);
            if (paintStyleSelectPaint2 != null) {
                return paintStyleSelectPaint2;
            }
        } else {
            xSLFTableCell = this;
        }
        CTTablePartStyle tablePartStyle = getTablePartStyle(null);
        if ((tablePartStyle != null && tablePartStyle.isSetTcStyle()) || ((tablePartStyle = getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl)) != null && tablePartStyle.isSetTcStyle())) {
            XMLSlideShow slideShow = sheet.getSlideShow();
            CTTableStyleCellStyle tcStyle = tablePartStyle.getTcStyle();
            if (tcStyle.isSetFill()) {
                fillRef = tcStyle.getFill();
            } else if (tcStyle.isSetFillRef()) {
                fillRef = tcStyle.getFillRef();
            }
            XSLFPropertiesDelegate.XSLFFillProperties fillDelegate2 = XSLFPropertiesDelegate.getFillDelegate(fillRef);
            if (fillDelegate2 != null && (paintStyleSelectPaint = xSLFTableCell.selectPaint(fillDelegate2, null, slideShow.getPackagePart(), theme, z6)) != null) {
                return paintStyleSelectPaint;
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public int getGridSpan() {
        CTTableCell cell = getCell();
        if (cell.isSetGridSpan()) {
            return cell.getGridSpan();
        }
        return 1;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public int getRowSpan() {
        CTTableCell cell = getCell();
        if (cell.isSetRowSpan()) {
            return cell.getRowSpan();
        }
        return 1;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public XmlObject getShapeProperties() {
        return getCellProperties(false);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public CTTextBody getTextBody(boolean z6) {
        CTTableCell cell = getCell();
        CTTextBody txBody = cell.getTxBody();
        if (txBody != null || !z6) {
            return txBody;
        }
        cell.setTxBody(new XDDFTextBody(this).getXmlObject());
        return cell.getTxBody();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public TextShape.TextDirection getTextDirection() {
        CTTableCellProperties cellProperties = getCellProperties(false);
        switch (((cellProperties == null || !cellProperties.isSetVert()) ? STTextVerticalType.HORZ : cellProperties.getVert()).intValue()) {
            case 2:
            case 5:
            case 6:
                return TextShape.TextDirection.VERTICAL;
            case 3:
                return TextShape.TextDirection.VERTICAL_270;
            case 4:
            case 7:
                return TextShape.TextDirection.STACKED;
            default:
                return TextShape.TextDirection.HORIZONTAL;
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public VerticalAlignment getVerticalAlignment() {
        CTTableCellProperties cellProperties = getCellProperties(false);
        VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
        if (cellProperties == null || !cellProperties.isSetAnchor()) {
            return verticalAlignment;
        }
        return VerticalAlignment.values()[cellProperties.getAnchor().intValue() - 1];
    }

    public CTTransform2D getXfrm() {
        Rectangle2D anchor = getAnchor();
        CTTransform2D cTTransform2DNewInstance = CTTransform2D.Factory.newInstance();
        CTPoint2D cTPoint2DAddNewOff = cTTransform2DNewInstance.addNewOff();
        cTPoint2DAddNewOff.setX(Integer.valueOf(Units.toEMU(anchor.getX())));
        cTPoint2DAddNewOff.setY(Integer.valueOf(Units.toEMU(anchor.getY())));
        CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DNewInstance.addNewExt();
        cTPositiveSize2DAddNewExt.setCx(Units.toEMU(anchor.getWidth()));
        cTPositiveSize2DAddNewExt.setCy(Units.toEMU(anchor.getHeight()));
        return cTTransform2DNewInstance;
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public boolean isMerged() {
        CTTableCell cell = getCell();
        if (cell.isSetHMerge() && cell.getHMerge()) {
            return true;
        }
        return cell.isSetVMerge() && cell.getVMerge();
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void removeBorder(TableCell.BorderEdge borderEdge) {
        CTTableCellProperties cellProperties = getCellProperties(false);
        if (cellProperties == null) {
            return;
        }
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TableCell$BorderEdge[borderEdge.ordinal()];
        if (i5 == 1) {
            if (cellProperties.isSetLnB()) {
                cellProperties.unsetLnB();
                return;
            }
            return;
        }
        if (i5 == 2) {
            if (cellProperties.isSetLnL()) {
                cellProperties.unsetLnL();
            }
        } else if (i5 == 3) {
            if (cellProperties.isSetLnT()) {
                cellProperties.unsetLnT();
            }
        } else {
            if (i5 != 4) {
                throw new IllegalArgumentException();
            }
            if (cellProperties.isSetLnR()) {
                cellProperties.unsetLnR();
            }
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        Rectangle2D rectangle2D2 = this.anchor;
        if (rectangle2D2 == null) {
            this.anchor = (Rectangle2D) rectangle2D.clone();
        } else {
            rectangle2D2.setRect(rectangle2D);
        }
    }

    public void setBorderCap(TableCell.BorderEdge borderEdge, StrokeStyle.LineCap lineCap) {
        if (lineCap == null) {
            throw new IllegalArgumentException("LineCap need to be specified.");
        }
        setBorderDefaults(borderEdge).setCap(STLineCap.Enum.forInt(lineCap.ooxmlId));
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderColor(TableCell.BorderEdge borderEdge, Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Colors need to be specified.");
        }
        CTSolidColorFillProperties cTSolidColorFillPropertiesAddNewSolidFill = setBorderDefaults(borderEdge).addNewSolidFill();
        new XSLFColor(cTSolidColorFillPropertiesAddNewSolidFill, getSheet().getTheme(), cTSolidColorFillPropertiesAddNewSolidFill.getSchemeClr(), getSheet()).setColor(color);
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderCompound(TableCell.BorderEdge borderEdge, StrokeStyle.LineCompound lineCompound) {
        if (lineCompound == null) {
            throw new IllegalArgumentException("LineCompound need to be specified.");
        }
        setBorderDefaults(borderEdge).setCmpd(STCompoundLine.Enum.forInt(lineCompound.ooxmlId));
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderDash(TableCell.BorderEdge borderEdge, StrokeStyle.LineDash lineDash) {
        if (lineDash == null) {
            throw new IllegalArgumentException("LineDash need to be specified.");
        }
        CTLineProperties borderDefaults = setBorderDefaults(borderEdge);
        if (!borderDefaults.isSetPrstDash()) {
            borderDefaults.addNewPrstDash();
        }
        borderDefaults.getPrstDash().setVal(STPresetLineDashVal.Enum.forInt(lineDash.ooxmlId));
    }

    public void setBorderProperties(TableCell.BorderEdge borderEdge, XDDFLineProperties xDDFLineProperties) {
        CTLineProperties cTLine = getCTLine(borderEdge, true);
        if (cTLine != null) {
            cTLine.set(xDDFLineProperties.getXmlObject().copy());
        }
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderStyle(TableCell.BorderEdge borderEdge, StrokeStyle strokeStyle) {
        if (strokeStyle == null) {
            throw new IllegalArgumentException("StrokeStyle needs to be specified.");
        }
        StrokeStyle.LineCap lineCap = strokeStyle.getLineCap();
        if (lineCap != null) {
            setBorderCap(borderEdge, lineCap);
        }
        StrokeStyle.LineCompound lineCompound = strokeStyle.getLineCompound();
        if (lineCompound != null) {
            setBorderCompound(borderEdge, lineCompound);
        }
        StrokeStyle.LineDash lineDash = strokeStyle.getLineDash();
        if (lineDash != null) {
            setBorderDash(borderEdge, lineDash);
        }
        setBorderWidth(borderEdge, strokeStyle.getLineWidth());
    }

    @Override // org.apache.poi.sl.usermodel.TableCell
    public void setBorderWidth(TableCell.BorderEdge borderEdge, double d) {
        CTLineProperties cTLine = getCTLine(borderEdge, true);
        if (cTLine == null) {
            return;
        }
        cTLine.setW(Units.toEMU(d));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setBottomInset(double d) {
        getCellProperties(true).setMarB(Integer.valueOf(Units.toEMU(d)));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setFillColor(Color color) {
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (color != null) {
            CTSolidColorFillProperties solidFill = cellProperties.isSetSolidFill() ? cellProperties.getSolidFill() : cellProperties.addNewSolidFill();
            new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr(), getSheet()).setColor(color);
        } else if (cellProperties.isSetSolidFill()) {
            cellProperties.unsetSolidFill();
        }
    }

    public void setGridSpan(int i5) {
        getCell().setGridSpan(i5);
    }

    public void setHMerge() {
        getCell().setHMerge(true);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setLeftInset(double d) {
        getCellProperties(true).setMarL(Integer.valueOf(Units.toEMU(d)));
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setRightInset(double d) {
        getCellProperties(true).setMarR(Integer.valueOf(Units.toEMU(d)));
    }

    public void setRowColIndex(int i5, int i6) {
        this.row = i5;
        this.col = i6;
    }

    public void setRowSpan(int i5) {
        getCell().setRowSpan(i5);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public void setTextDirection(TextShape.TextDirection textDirection) {
        STTextVerticalType.Enum r6;
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (textDirection == null) {
            if (cellProperties.isSetVert()) {
                cellProperties.unsetVert();
                return;
            }
            return;
        }
        int i5 = AnonymousClass2.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextDirection[textDirection.ordinal()];
        if (i5 == 2) {
            r6 = STTextVerticalType.VERT;
        } else if (i5 != 3) {
            r6 = i5 != 4 ? STTextVerticalType.HORZ : STTextVerticalType.WORD_ART_VERT;
        } else {
            r6 = STTextVerticalType.VERT_270;
        }
        cellProperties.setVert(r6);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public void setTopInset(double d) {
        getCellProperties(true).setMarT(Integer.valueOf(Units.toEMU(d)));
    }

    public void setVMerge() {
        getCell().setVMerge(true);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape, org.apache.poi.sl.usermodel.TextShape
    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTableCellProperties cellProperties = getCellProperties(true);
        if (verticalAlignment != null) {
            cellProperties.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
        } else if (cellProperties.isSetAnchor()) {
            cellProperties.unsetAnchor();
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public XSLFCellTextParagraph newTextParagraph(CTTextParagraph cTTextParagraph) {
        return new XSLFCellTextParagraph(cTTextParagraph, this);
    }
}
