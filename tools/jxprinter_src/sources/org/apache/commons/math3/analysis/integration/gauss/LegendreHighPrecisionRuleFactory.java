package org.apache.commons.math3.analysis.integration.gauss;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.commons.math3.util.Pair;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LegendreHighPrecisionRuleFactory extends BaseRuleFactory<BigDecimal> {
    private final MathContext mContext;
    private final BigDecimal minusOne;
    private final BigDecimal oneHalf;
    private final BigDecimal two;

    public LegendreHighPrecisionRuleFactory() {
        this(MathContext.DECIMAL128);
    }

    @Override // org.apache.commons.math3.analysis.integration.gauss.BaseRuleFactory
    public Pair<BigDecimal[], BigDecimal[]> computeRule(int i5) {
        int i6 = 1;
        if (i5 == 1) {
            return new Pair<>(new BigDecimal[]{BigDecimal.ZERO}, new BigDecimal[]{this.two});
        }
        BigDecimal[] first = getRuleInternal(i5 - 1).getFirst();
        BigDecimal[] bigDecimalArr = new BigDecimal[i5];
        BigDecimal[] bigDecimalArr2 = new BigDecimal[i5];
        int i7 = i5 / 2;
        int i8 = 0;
        while (i8 < i7) {
            BigDecimal bigDecimal = i8 == 0 ? this.minusOne : first[i8 - 1];
            BigDecimal bigDecimal2 = i7 == i6 ? BigDecimal.ONE : first[i8];
            int i9 = i6;
            BigDecimal bigDecimal3 = bigDecimal2;
            BigDecimal bigDecimal4 = BigDecimal.ONE;
            BigDecimal bigDecimal5 = bigDecimal4;
            BigDecimal bigDecimal6 = bigDecimal;
            while (i6 < i5) {
                BigDecimal[] bigDecimalArr3 = first;
                BigDecimal bigDecimal7 = new BigDecimal((i6 * 2) + 1, this.mContext);
                BigDecimal bigDecimal8 = new BigDecimal(i6, this.mContext);
                int i10 = i6 + 1;
                BigDecimal bigDecimal9 = new BigDecimal(i10, this.mContext);
                BigDecimal bigDecimalDivide = bigDecimal6.multiply(bigDecimal.multiply(bigDecimal7, this.mContext), this.mContext).subtract(bigDecimal4.multiply(bigDecimal8, this.mContext), this.mContext).divide(bigDecimal9, this.mContext);
                BigDecimal bigDecimalDivide2 = bigDecimal3.multiply(bigDecimal2.multiply(bigDecimal7, this.mContext), this.mContext).subtract(bigDecimal5.multiply(bigDecimal8, this.mContext), this.mContext).divide(bigDecimal9, this.mContext);
                bigDecimal4 = bigDecimal6;
                bigDecimal5 = bigDecimal3;
                i7 = i7;
                bigDecimal6 = bigDecimalDivide;
                bigDecimal3 = bigDecimalDivide2;
                first = bigDecimalArr3;
                i6 = i10;
            }
            BigDecimal[] bigDecimalArr4 = first;
            int i11 = i7;
            BigDecimal bigDecimalMultiply = bigDecimal.add(bigDecimal2, this.mContext).multiply(this.oneHalf, this.mContext);
            BigDecimal bigDecimal10 = BigDecimal.ONE;
            int i12 = 0;
            BigDecimal bigDecimal11 = bigDecimalMultiply;
            while (i12 == 0) {
                int i13 = bigDecimal2.subtract(bigDecimal, this.mContext).compareTo(bigDecimalMultiply.ulp().multiply(BigDecimal.TEN, this.mContext)) <= 0 ? i9 : 0;
                bigDecimal10 = BigDecimal.ONE;
                int i14 = i9;
                bigDecimal11 = bigDecimalMultiply;
                while (i14 < i5) {
                    BigDecimal bigDecimal12 = new BigDecimal((i14 * 2) + 1, this.mContext);
                    BigDecimal bigDecimal13 = new BigDecimal(i14, this.mContext);
                    i14++;
                    BigDecimal bigDecimalDivide3 = bigDecimal11.multiply(bigDecimalMultiply.multiply(bigDecimal12, this.mContext), this.mContext).subtract(bigDecimal10.multiply(bigDecimal13, this.mContext), this.mContext).divide(new BigDecimal(i14, this.mContext), this.mContext);
                    bigDecimal10 = bigDecimal11;
                    bigDecimal11 = bigDecimalDivide3;
                    i13 = i13;
                }
                int i15 = i13;
                if (i15 == 0) {
                    if (bigDecimal11.signum() * bigDecimal6.signum() <= 0) {
                        bigDecimal2 = bigDecimalMultiply;
                        bigDecimalMultiply = bigDecimal;
                    } else {
                        bigDecimal6 = bigDecimal11;
                    }
                    bigDecimal = bigDecimalMultiply;
                    bigDecimalMultiply = bigDecimalMultiply.add(bigDecimal2, this.mContext).multiply(this.oneHalf, this.mContext);
                }
                i12 = i15;
            }
            BigDecimal bigDecimalDivide4 = BigDecimal.ONE.subtract(bigDecimalMultiply.pow(2, this.mContext), this.mContext).multiply(this.two, this.mContext).divide(bigDecimal10.subtract(bigDecimalMultiply.multiply(bigDecimal11, this.mContext), this.mContext).multiply(new BigDecimal(i5, this.mContext)).pow(2, this.mContext), this.mContext);
            bigDecimalArr[i8] = bigDecimalMultiply;
            bigDecimalArr2[i8] = bigDecimalDivide4;
            int i16 = (i5 - i8) - 1;
            bigDecimalArr[i16] = bigDecimalMultiply.negate(this.mContext);
            bigDecimalArr2[i16] = bigDecimalDivide4;
            i8++;
            i6 = i9;
            first = bigDecimalArr4;
            i7 = i11;
        }
        int i17 = i6;
        int i18 = i7;
        if (i5 % 2 != 0) {
            BigDecimal bigDecimalNegate = BigDecimal.ONE;
            for (int i19 = i17; i19 < i5; i19 += 2) {
                bigDecimalNegate = bigDecimalNegate.multiply(new BigDecimal(i19, this.mContext), this.mContext).divide(new BigDecimal(i19 + 1, this.mContext), this.mContext).negate(this.mContext);
            }
            BigDecimal bigDecimalDivide5 = this.two.divide(bigDecimalNegate.multiply(new BigDecimal(i5, this.mContext), this.mContext).pow(2, this.mContext), this.mContext);
            bigDecimalArr[i18] = BigDecimal.ZERO;
            bigDecimalArr2[i18] = bigDecimalDivide5;
        }
        return new Pair<>(bigDecimalArr, bigDecimalArr2);
    }

    public LegendreHighPrecisionRuleFactory(MathContext mathContext) {
        this.mContext = mathContext;
        this.two = new BigDecimal(ExifInterface.GPS_MEASUREMENT_2D, mathContext);
        this.minusOne = new BigDecimal(StructuredDataId.RESERVED, mathContext);
        this.oneHalf = new BigDecimal("0.5", mathContext);
    }
}
