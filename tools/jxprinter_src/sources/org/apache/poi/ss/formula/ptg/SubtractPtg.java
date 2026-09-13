package org.apache.poi.ss.formula.ptg;

import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SubtractPtg extends ValueOperatorPtg {
    public static final SubtractPtg instance = new SubtractPtg();
    public static final byte sid = 4;

    private SubtractPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 4;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        return strArr[0] + ProcessIdUtil.DEFAULT_PROCESSID + strArr[1];
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public SubtractPtg copy() {
        return instance;
    }
}
