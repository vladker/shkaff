package org.apache.poi.ss.formula.ptg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConcatPtg extends ValueOperatorPtg {
    private static final String CONCAT = "&";
    public static final ConcatPtg instance = new ConcatPtg();
    public static final byte sid = 8;

    private ConcatPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 8;
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        return strArr[0] + CONCAT + strArr[1];
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public ConcatPtg copy() {
        return instance;
    }
}
