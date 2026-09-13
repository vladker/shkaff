package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ConditionalFormatting {
    void addRule(ConditionalFormattingRule conditionalFormattingRule);

    CellRangeAddress[] getFormattingRanges();

    int getNumberOfRules();

    ConditionalFormattingRule getRule(int i5);

    void setFormattingRanges(CellRangeAddress[] cellRangeAddressArr);

    void setRule(int i5, ConditionalFormattingRule conditionalFormattingRule);
}
