package org.apache.poi.ss.formula.functions;

import androidx.exifinterface.media.ExifInterface;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Roman extends Fixed2ArgFunction {
    private static final int[] VALUES = {1000, 900, Videoio.CAP_QT, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
    private static final String[][] REPLACEMENTS = {new String[]{"XLV", "VL", "XCV", "VC", "CDL", "LD", "CML", "LM", "CMVC", "LMVL"}, new String[]{"CDXC", "LDXL", "CDVC", "LDVL", "CMXC", "LMXL", "XCIX", "VCIV", "XLIX", "VLIV"}, new String[]{"XLIX", "IL", "XCIX", "IC", "CDXC", "XD", "CDVC", "XDV", "CDIC", "XDIX", "LMVL", "XMV", "CMIC", "XMIX", "CMXC", "XM"}, new String[]{"XDV", "VD", "XDIX", "VDIV", "XMV", "VM", "XMIX", "VMIV"}, new String[]{"VDIV", "ID", "VMIV", "IM"}};

    private String integerToRoman(int i5) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 13; i6++) {
            while (true) {
                int i7 = VALUES[i6];
                if (i5 >= i7) {
                    i5 -= i7;
                    sb.append(ROMAN[i6]);
                }
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2) {
        try {
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i5, i6));
            if (iCoerceValueToInt < 0) {
                return ErrorEval.VALUE_INVALID;
            }
            if (iCoerceValueToInt > 3999) {
                return ErrorEval.VALUE_INVALID;
            }
            if (iCoerceValueToInt == 0) {
                return new StringEval("");
            }
            try {
                int iCoerceValueToInt2 = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i5, i6));
                if (iCoerceValueToInt2 > 4 || iCoerceValueToInt2 < 0) {
                    return ErrorEval.VALUE_INVALID;
                }
                String strIntegerToRoman = integerToRoman(iCoerceValueToInt);
                return iCoerceValueToInt2 == 0 ? new StringEval(strIntegerToRoman) : new StringEval(makeConcise(strIntegerToRoman, iCoerceValueToInt2));
            } catch (EvaluationException unused) {
                return ErrorEval.NUM_ERROR;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    public String makeConcise(String str, int i5) {
        for (int i6 = 0; i6 <= i5 && i6 <= 4 && i5 > 0; i6++) {
            if (i6 != 1 || i5 <= 1) {
                String[] strArr = REPLACEMENTS[i6];
                for (int i7 = 0; i7 < strArr.length; i7 += 2) {
                    str = str.replace(strArr[i7], strArr[i7 + 1]);
                }
            }
        }
        return str;
    }
}
