package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfvoType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private static final Map<STCfType.Enum, ConditionFilterType> filterTypeLookup;
    private static final Map<STCfType.Enum, ConditionType> typeLookup;
    private final CTCfRule _cfRule;
    private final XSSFSheet _sh;

    static {
        HashMap map = new HashMap();
        typeLookup = map;
        HashMap map2 = new HashMap();
        filterTypeLookup = map2;
        map.put(STCfType.CELL_IS, ConditionType.CELL_VALUE_IS);
        map.put(STCfType.EXPRESSION, ConditionType.FORMULA);
        map.put(STCfType.COLOR_SCALE, ConditionType.COLOR_SCALE);
        map.put(STCfType.DATA_BAR, ConditionType.DATA_BAR);
        map.put(STCfType.ICON_SET, ConditionType.ICON_SET);
        STCfType.Enum r6 = STCfType.TOP_10;
        ConditionType conditionType = ConditionType.FILTER;
        map.put(r6, conditionType);
        STCfType.Enum r7 = STCfType.UNIQUE_VALUES;
        map.put(r7, conditionType);
        STCfType.Enum r8 = STCfType.DUPLICATE_VALUES;
        map.put(r8, conditionType);
        STCfType.Enum r9 = STCfType.CONTAINS_TEXT;
        map.put(r9, conditionType);
        STCfType.Enum r10 = STCfType.NOT_CONTAINS_TEXT;
        map.put(r10, conditionType);
        STCfType.Enum r11 = STCfType.BEGINS_WITH;
        map.put(r11, conditionType);
        STCfType.Enum r12 = STCfType.ENDS_WITH;
        map.put(r12, conditionType);
        STCfType.Enum r13 = STCfType.CONTAINS_BLANKS;
        map.put(r13, conditionType);
        STCfType.Enum r14 = STCfType.NOT_CONTAINS_BLANKS;
        map.put(r14, conditionType);
        STCfType.Enum r15 = STCfType.CONTAINS_ERRORS;
        map.put(r15, conditionType);
        STCfType.Enum r16 = STCfType.NOT_CONTAINS_ERRORS;
        map.put(r16, conditionType);
        STCfType.Enum r17 = STCfType.TIME_PERIOD;
        map.put(r17, conditionType);
        STCfType.Enum r18 = STCfType.ABOVE_AVERAGE;
        map.put(r18, conditionType);
        map2.put(r6, ConditionFilterType.TOP_10);
        map2.put(r7, ConditionFilterType.UNIQUE_VALUES);
        map2.put(r8, ConditionFilterType.DUPLICATE_VALUES);
        map2.put(r9, ConditionFilterType.CONTAINS_TEXT);
        map2.put(r10, ConditionFilterType.NOT_CONTAINS_TEXT);
        map2.put(r11, ConditionFilterType.BEGINS_WITH);
        map2.put(r12, ConditionFilterType.ENDS_WITH);
        map2.put(r13, ConditionFilterType.CONTAINS_BLANKS);
        map2.put(r14, ConditionFilterType.NOT_CONTAINS_BLANKS);
        map2.put(r15, ConditionFilterType.CONTAINS_ERRORS);
        map2.put(r16, ConditionFilterType.NOT_CONTAINS_ERRORS);
        map2.put(r17, ConditionFilterType.TIME_PERIOD);
        map2.put(r18, ConditionFilterType.ABOVE_AVERAGE);
    }

    public XSSFConditionalFormattingRule(XSSFSheet xSSFSheet) {
        this._cfRule = CTCfRule.Factory.newInstance();
        this._sh = xSSFSheet;
    }

    public XSSFColorScaleFormatting createColorScaleFormatting() {
        if (this._cfRule.isSetColorScale() && this._cfRule.getType() == STCfType.COLOR_SCALE) {
            return getColorScaleFormatting();
        }
        this._cfRule.setType(STCfType.COLOR_SCALE);
        CTColorScale colorScale = this._cfRule.isSetColorScale() ? this._cfRule.getColorScale() : this._cfRule.addNewColorScale();
        if (colorScale.sizeOfCfvoArray() == 0) {
            colorScale.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
            CTCfvo cTCfvoAddNewCfvo = colorScale.addNewCfvo();
            cTCfvoAddNewCfvo.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENTILE.name));
            cTCfvoAddNewCfvo.setVal("50");
            colorScale.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
            for (int i5 = 0; i5 < 3; i5++) {
                colorScale.addNewColor();
            }
        }
        return new XSSFColorScaleFormatting(colorScale, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    public XSSFDataBarFormatting createDataBarFormatting(XSSFColor xSSFColor) {
        if (this._cfRule.isSetDataBar() && this._cfRule.getType() == STCfType.DATA_BAR) {
            return getDataBarFormatting();
        }
        this._cfRule.setType(STCfType.DATA_BAR);
        CTDataBar dataBar = this._cfRule.isSetDataBar() ? this._cfRule.getDataBar() : this._cfRule.addNewDataBar();
        dataBar.setColor(xSSFColor.getCTColor());
        dataBar.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
        dataBar.addNewCfvo().setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
        return new XSSFDataBarFormatting(dataBar, this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    public XSSFIconMultiStateFormatting createMultiStateFormatting(IconMultiStateFormatting.IconSet iconSet) {
        if (this._cfRule.isSetIconSet() && this._cfRule.getType() == STCfType.ICON_SET) {
            return getMultiStateFormatting();
        }
        this._cfRule.setType(STCfType.ICON_SET);
        CTIconSet iconSet2 = this._cfRule.isSetIconSet() ? this._cfRule.getIconSet() : this._cfRule.addNewIconSet();
        String str = iconSet.name;
        if (str != null) {
            iconSet2.setIconSet(STIconSetType.Enum.forString(str));
        }
        int i5 = 100 / iconSet.num;
        STCfvoType.Enum enumForString = STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENT.name);
        for (int i6 = 0; i6 < iconSet.num; i6++) {
            CTCfvo cTCfvoAddNewCfvo = iconSet2.addNewCfvo();
            cTCfvoAddNewCfvo.setType(enumForString);
            cTCfvoAddNewCfvo.setVal(Integer.toString(i6 * i5));
        }
        return new XSSFIconMultiStateFormatting(iconSet2);
    }

    public CTCfRule getCTCfRule() {
        return this._cfRule;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        STConditionalFormattingOperator.Enum operator = this._cfRule.getOperator();
        if (operator == null) {
            return (byte) 0;
        }
        switch (operator.intValue()) {
            case 1:
                return (byte) 6;
            case 2:
                return (byte) 8;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 4;
            case 5:
                return (byte) 7;
            case 6:
                return (byte) 5;
            case 7:
                return (byte) 1;
            case 8:
                return (byte) 2;
            default:
                return (byte) 0;
        }
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterType getConditionFilterType() {
        return filterTypeLookup.get(this._cfRule.getType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionType getConditionType() {
        return typeLookup.get(this._cfRule.getType());
    }

    public CTDxf getDxf(boolean z6) {
        StylesTable stylesSource = this._sh.getWorkbook().getStylesSource();
        CTDxf dxfAt = (stylesSource._getDXfsSize() <= 0 || !this._cfRule.isSetDxfId()) ? null : stylesSource.getDxfAt((int) this._cfRule.getDxfId());
        if (!z6 || dxfAt != null) {
            return dxfAt;
        }
        CTDxf cTDxfNewInstance = CTDxf.Factory.newInstance();
        this._cfRule.setDxfId(((long) stylesSource.putDxf(cTDxfNewInstance)) - 1);
        return cTDxfNewInstance;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterData getFilterConfiguration() {
        return new XSSFConditionFilterData(this._cfRule);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        if (this._cfRule.sizeOfFormulaArray() > 0) {
            return this._cfRule.getFormulaArray(0);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this._cfRule.sizeOfFormulaArray() == 2) {
            return this._cfRule.getFormulaArray(1);
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public ExcelNumberFormat getNumberFormat() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetNumFmt()) {
            return null;
        }
        CTNumFmt numFmt = dxf.getNumFmt();
        return new ExcelNumberFormat((int) numFmt.getNumFmtId(), numFmt.getFormatCode());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public int getPriority() {
        int priority = this._cfRule.getPriority();
        if (priority >= 1) {
            return priority;
        }
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public boolean getStopIfTrue() {
        return this._cfRule.getStopIfTrue();
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getText() {
        return this._cfRule.getText();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFBorderFormatting createBorderFormatting() {
        CTDxf dxf = getDxf(true);
        return new XSSFBorderFormatting(!dxf.isSetBorder() ? dxf.addNewBorder() : dxf.getBorder(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFFontFormatting createFontFormatting() {
        CTDxf dxf = getDxf(true);
        return new XSSFFontFormatting(!dxf.isSetFont() ? dxf.addNewFont() : dxf.getFont(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFPatternFormatting createPatternFormatting() {
        CTDxf dxf = getDxf(true);
        return new XSSFPatternFormatting(!dxf.isSetFill() ? dxf.addNewFill() : dxf.getFill(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFBorderFormatting getBorderFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetBorder()) {
            return null;
        }
        return new XSSFBorderFormatting(dxf.getBorder(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFColorScaleFormatting getColorScaleFormatting() {
        if (this._cfRule.isSetColorScale()) {
            return new XSSFColorScaleFormatting(this._cfRule.getColorScale(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFDataBarFormatting getDataBarFormatting() {
        if (this._cfRule.isSetDataBar()) {
            return new XSSFDataBarFormatting(this._cfRule.getDataBar(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFFontFormatting getFontFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFont()) {
            return null;
        }
        return new XSSFFontFormatting(dxf.getFont(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public XSSFIconMultiStateFormatting getMultiStateFormatting() {
        if (this._cfRule.isSetIconSet()) {
            return new XSSFIconMultiStateFormatting(this._cfRule.getIconSet());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public XSSFPatternFormatting getPatternFormatting() {
        CTDxf dxf = getDxf(false);
        if (dxf == null || !dxf.isSetFill()) {
            return null;
        }
        return new XSSFPatternFormatting(dxf.getFill(), this._sh.getWorkbook().getStylesSource().getIndexedColors());
    }

    public XSSFConditionalFormattingRule(XSSFSheet xSSFSheet, CTCfRule cTCfRule) {
        this._cfRule = cTCfRule;
        this._sh = xSSFSheet;
    }
}
