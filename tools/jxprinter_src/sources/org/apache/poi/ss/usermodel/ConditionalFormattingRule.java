package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ConditionalFormattingRule extends DifferentialStyleProvider {
    BorderFormatting createBorderFormatting();

    FontFormatting createFontFormatting();

    PatternFormatting createPatternFormatting();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    BorderFormatting getBorderFormatting();

    ColorScaleFormatting getColorScaleFormatting();

    byte getComparisonOperation();

    ConditionFilterType getConditionFilterType();

    ConditionType getConditionType();

    DataBarFormatting getDataBarFormatting();

    ConditionFilterData getFilterConfiguration();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    FontFormatting getFontFormatting();

    String getFormula1();

    String getFormula2();

    IconMultiStateFormatting getMultiStateFormatting();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    ExcelNumberFormat getNumberFormat();

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    PatternFormatting getPatternFormatting();

    int getPriority();

    boolean getStopIfTrue();

    String getText();
}
