package org.apache.poi.hssf.usermodel.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.usermodel.helpers.ColumnShifter;
import org.apache.poi.util.NotImplemented;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFColumnShifter extends ColumnShifter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) HSSFColumnShifter.class);

    public HSSFColumnShifter(HSSFSheet hSSFSheet) {
        super(hSSFSheet);
    }

    @Override // org.apache.poi.ss.usermodel.helpers.BaseRowColShifter
    @NotImplemented
    public void updateConditionalFormatting(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateConditionalFormatting");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.BaseRowColShifter
    @NotImplemented
    public void updateFormulas(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateFormulas");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.BaseRowColShifter
    @NotImplemented
    public void updateHyperlinks(FormulaShifter formulaShifter) {
        throw new NotImplementedException("updateHyperlinks");
    }

    @Override // org.apache.poi.ss.usermodel.helpers.BaseRowColShifter
    @NotImplemented
    public void updateNamedRanges(FormulaShifter formulaShifter) {
        throw new NotImplementedException("HSSFColumnShifter.updateNamedRanges");
    }
}
