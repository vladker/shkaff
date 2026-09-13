package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface DataValidationHelper {
    DataValidationConstraint createCustomConstraint(String str);

    DataValidationConstraint createDateConstraint(int i5, String str, String str2, String str3);

    DataValidationConstraint createDecimalConstraint(int i5, String str, String str2);

    DataValidationConstraint createExplicitListConstraint(String[] strArr);

    DataValidationConstraint createFormulaListConstraint(String str);

    DataValidationConstraint createIntegerConstraint(int i5, String str, String str2);

    DataValidationConstraint createNumericConstraint(int i5, int i6, String str, String str2);

    DataValidationConstraint createTextLengthConstraint(int i5, String str, String str2);

    DataValidationConstraint createTimeConstraint(int i5, String str, String str2);

    DataValidation createValidation(DataValidationConstraint dataValidationConstraint, CellRangeAddressList cellRangeAddressList);
}
