package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFDataValidationHelper implements DataValidationHelper {
    public HSSFDataValidationHelper(HSSFSheet hSSFSheet) {
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createCustomConstraint(String str) {
        return DVConstraint.createCustomFormulaConstraint(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDateConstraint(int i5, String str, String str2, String str3) {
        return DVConstraint.createDateConstraint(i5, str, str2, str3);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createDecimalConstraint(int i5, String str, String str2) {
        return DVConstraint.createNumericConstraint(2, i5, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createExplicitListConstraint(String[] strArr) {
        return DVConstraint.createExplicitListConstraint(strArr);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createFormulaListConstraint(String str) {
        return DVConstraint.createFormulaListConstraint(str);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createIntegerConstraint(int i5, String str, String str2) {
        return DVConstraint.createNumericConstraint(1, i5, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createNumericConstraint(int i5, int i6, String str, String str2) {
        return DVConstraint.createNumericConstraint(i5, i6, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTextLengthConstraint(int i5, String str, String str2) {
        return DVConstraint.createNumericConstraint(6, i5, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidationConstraint createTimeConstraint(int i5, String str, String str2) {
        return DVConstraint.createTimeConstraint(i5, str, str2);
    }

    @Override // org.apache.poi.ss.usermodel.DataValidationHelper
    public DataValidation createValidation(DataValidationConstraint dataValidationConstraint, CellRangeAddressList cellRangeAddressList) {
        return new HSSFDataValidation(cellRangeAddressList, dataValidationConstraint);
    }
}
