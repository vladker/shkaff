package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class DormandPrince853FieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T[][] d;

    /* JADX WARN: Multi-variable type inference failed */
    public DormandPrince853FieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
        T[][] tArr2 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(field, 7, 16));
        this.d = tArr2;
        tArr2[0][0] = fraction(field, 104257.0d, 1920240.0d);
        tArr2[0][1] = field.getZero();
        tArr2[0][2] = field.getZero();
        tArr2[0][3] = field.getZero();
        tArr2[0][4] = field.getZero();
        tArr2[0][5] = fraction(field, 3399327.0d, 763840.0d);
        tArr2[0][6] = fraction(field, 6.6578432E7d, 3.5198415E7d);
        tArr2[0][7] = fraction(field, -1.674902723E9d, 2.887164E8d);
        tArr2[0][8] = fraction(field, 5.4980371265625E13d, 1.76692375811392E14d);
        tArr2[0][9] = fraction(field, -734375.0d, 4826304.0d);
        tArr2[0][10] = fraction(field, 1.71414593E8d, 8.512614E8d);
        tArr2[0][11] = fraction(field, 137909.0d, 3084480.0d);
        tArr2[0][12] = field.getZero();
        tArr2[0][13] = field.getZero();
        tArr2[0][14] = field.getZero();
        tArr2[0][15] = field.getZero();
        tArr2[1][0] = (RealFieldElement) ((RealFieldElement) tArr2[0][0].negate()).add(1.0d);
        tArr2[1][1] = (RealFieldElement) tArr2[0][1].negate();
        tArr2[1][2] = (RealFieldElement) tArr2[0][2].negate();
        tArr2[1][3] = (RealFieldElement) tArr2[0][3].negate();
        tArr2[1][4] = (RealFieldElement) tArr2[0][4].negate();
        tArr2[1][5] = (RealFieldElement) tArr2[0][5].negate();
        tArr2[1][6] = (RealFieldElement) tArr2[0][6].negate();
        tArr2[1][7] = (RealFieldElement) tArr2[0][7].negate();
        tArr2[1][8] = (RealFieldElement) tArr2[0][8].negate();
        tArr2[1][9] = (RealFieldElement) tArr2[0][9].negate();
        tArr2[1][10] = (RealFieldElement) tArr2[0][10].negate();
        tArr2[1][11] = (RealFieldElement) tArr2[0][11].negate();
        tArr2[1][12] = (RealFieldElement) tArr2[0][12].negate();
        tArr2[1][13] = (RealFieldElement) tArr2[0][13].negate();
        tArr2[1][14] = (RealFieldElement) tArr2[0][14].negate();
        tArr2[1][15] = (RealFieldElement) tArr2[0][15].negate();
        tArr2[2][0] = (RealFieldElement) ((RealFieldElement) tArr2[0][0].multiply(2)).subtract(1.0d);
        tArr2[2][1] = (RealFieldElement) tArr2[0][1].multiply(2);
        tArr2[2][2] = (RealFieldElement) tArr2[0][2].multiply(2);
        tArr2[2][3] = (RealFieldElement) tArr2[0][3].multiply(2);
        tArr2[2][4] = (RealFieldElement) tArr2[0][4].multiply(2);
        tArr2[2][5] = (RealFieldElement) tArr2[0][5].multiply(2);
        tArr2[2][6] = (RealFieldElement) tArr2[0][6].multiply(2);
        tArr2[2][7] = (RealFieldElement) tArr2[0][7].multiply(2);
        tArr2[2][8] = (RealFieldElement) tArr2[0][8].multiply(2);
        tArr2[2][9] = (RealFieldElement) tArr2[0][9].multiply(2);
        tArr2[2][10] = (RealFieldElement) tArr2[0][10].multiply(2);
        tArr2[2][11] = (RealFieldElement) tArr2[0][11].multiply(2);
        tArr2[2][12] = (RealFieldElement) ((RealFieldElement) tArr2[0][12].multiply(2)).subtract(1.0d);
        tArr2[2][13] = (RealFieldElement) tArr2[0][13].multiply(2);
        tArr2[2][14] = (RealFieldElement) tArr2[0][14].multiply(2);
        tArr2[2][15] = (RealFieldElement) tArr2[0][15].multiply(2);
        tArr2[3][0] = fraction(field, -1.7751989329E10d, 2.10607656E9d);
        tArr2[3][1] = field.getZero();
        tArr2[3][2] = field.getZero();
        tArr2[3][3] = field.getZero();
        tArr2[3][4] = field.getZero();
        tArr2[3][5] = fraction(field, 4.272954039E9d, 7.53986464E9d);
        tArr2[3][6] = fraction(field, -1.18476319744E11d, 3.8604839385E10d);
        tArr2[3][7] = fraction(field, 7.55123450731E11d, 3.166577316E11d);
        tArr2[3][8] = fraction(field, 3.6923844612348283E18d, 1.7441304416342505E18d);
        tArr2[3][9] = fraction(field, -4.612609375E9d, 5.293382976E9d);
        tArr2[3][10] = fraction(field, 2.091772278379E12d, 9.336445866E11d);
        tArr2[3][11] = fraction(field, 2.136624137E9d, 3.38298912E9d);
        tArr2[3][12] = fraction(field, -126493.0d, 1421424.0d);
        tArr2[3][13] = fraction(field, 9.835E7d, 5419179.0d);
        tArr2[3][14] = fraction(field, -1.8878125E7d, 2053168.0d);
        tArr2[3][15] = fraction(field, -1.944542619E9d, 4.38351368E8d);
        tArr2[4][0] = fraction(field, 3.2941697297E10d, 3.15911484E9d);
        tArr2[4][1] = field.getZero();
        tArr2[4][2] = field.getZero();
        tArr2[4][3] = field.getZero();
        tArr2[4][4] = field.getZero();
        tArr2[4][5] = fraction(field, 4.56696183123E11d, 1.88496616E9d);
        tArr2[4][6] = fraction(field, 1.9132610714624E13d, 1.15814518155E11d);
        tArr2[4][7] = fraction(field, -1.77904688592943E14d, 4.749865974E11d);
        tArr2[4][8] = fraction(field, -4.821139941836765E18d, 2.180163052042813E17d);
        tArr2[4][9] = fraction(field, 3.0702015625E10d, 3.970037232E9d);
        tArr2[4][10] = fraction(field, -8.5916079474274E13d, 2.8009337598E12d);
        tArr2[4][11] = fraction(field, -5.919468007E9d, 6.3431046E8d);
        tArr2[4][12] = fraction(field, 2479159.0d, 157936.0d);
        tArr2[4][13] = fraction(field, -1.875E7d, 602131.0d);
        tArr2[4][14] = fraction(field, -1.9203125E7d, 2053168.0d);
        tArr2[4][15] = fraction(field, 1.5700361463E10d, 4.38351368E8d);
        tArr2[5][0] = fraction(field, 1.2627015655E10d, 6.31822968E8d);
        tArr2[5][1] = field.getZero();
        tArr2[5][2] = field.getZero();
        tArr2[5][3] = field.getZero();
        tArr2[5][4] = field.getZero();
        tArr2[5][5] = fraction(field, -7.2955222965E10d, 1.88496616E8d);
        tArr2[5][6] = fraction(field, -1.314574495232E13d, 6.9488710893E10d);
        tArr2[5][7] = fraction(field, 3.0084216194513E13d, 5.6998391688E10d);
        tArr2[5][8] = fraction(field, -2.9685876100664064E17d, 2.5648977082856624E16d);
        tArr2[5][9] = fraction(field, 5.69140625E8d, 8.2709109E7d);
        tArr2[5][10] = fraction(field, -1.8684190637E10d, 1.8672891732E10d);
        tArr2[5][11] = fraction(field, 6.9644045E7d, 8.9549712E7d);
        tArr2[5][12] = fraction(field, -1.1847025E7d, 4264272.0d);
        tArr2[5][13] = fraction(field, -9.7865E8d, 1.6257537E7d);
        tArr2[5][14] = fraction(field, 5.19371875E8d, 6159504.0d);
        tArr2[5][15] = fraction(field, 5.256837225E9d, 4.38351368E8d);
        tArr2[6][0] = fraction(field, -4.50944925E8d, 1.7550638E7d);
        tArr2[6][1] = field.getZero();
        tArr2[6][2] = field.getZero();
        tArr2[6][3] = field.getZero();
        tArr2[6][4] = field.getZero();
        tArr2[6][5] = fraction(field, -1.4532122925E10d, 9.4248308E7d);
        tArr2[6][6] = fraction(field, -5.958769664E11d, 2.573655959E9d);
        tArr2[6][7] = fraction(field, 1.88748653015E11d, 5.27762886E8d);
        tArr2[6][8] = fraction(field, 2.5454854581152343E18d, 2.7252038150535164E16d);
        tArr2[6][9] = fraction(field, -1.376953125E9d, 3.6759604E7d);
        tArr2[6][10] = fraction(field, 5.3995596795E10d, 5.18691437E8d);
        tArr2[6][11] = fraction(field, 2.10311225E8d, 7047894.0d);
        tArr2[6][12] = fraction(field, -1718875.0d, 39484.0d);
        tArr2[6][13] = fraction(field, 5.8E7d, 602131.0d);
        tArr2[6][14] = fraction(field, -1546875.0d, 39484.0d);
        tArr2[6][15] = fraction(field, -1.262172375E9d, 8429834.0d);
    }

    private T fraction(Field<T> field, double d, double d6) {
        return (T) ((RealFieldElement) field.getZero().add(d)).divide(d6);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        T[] tArrCurrentStateLinearCombination;
        T[] tArrDerivativeLinearCombination;
        T t10 = t8;
        RealFieldElement realFieldElement = (RealFieldElement) t6.getField().getOne();
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.subtract(t7);
        RealFieldElement realFieldElement3 = (RealFieldElement) t7.multiply(2);
        RealFieldElement realFieldElement4 = (RealFieldElement) t7.multiply(t7);
        RealFieldElement realFieldElement5 = (RealFieldElement) realFieldElement.subtract(realFieldElement3);
        RealFieldElement realFieldElement6 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-3)).add(2.0d));
        RealFieldElement realFieldElement7 = (RealFieldElement) realFieldElement3.multiply(((RealFieldElement) t7.multiply(realFieldElement3.subtract(3.0d))).add(1.0d));
        RealFieldElement realFieldElement8 = (RealFieldElement) realFieldElement4.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(5)).subtract(8.0d))).add(3.0d));
        RealFieldElement realFieldElement9 = (RealFieldElement) realFieldElement4.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-6)).add(15.0d))).subtract(12.0d))).add(3.0d));
        RealFieldElement realFieldElement10 = (RealFieldElement) realFieldElement4.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-7)).add(18.0d))).subtract(15.0d))).add(4.0d)));
        if (getGlobalPreviousState() == null || t7.getReal() > 0.5d) {
            RealFieldElement realFieldElement11 = (RealFieldElement) t9.negate();
            RealFieldElement realFieldElement12 = (RealFieldElement) ((RealFieldElement) realFieldElement11.multiply(t7)).negate();
            RealFieldElement realFieldElement13 = (RealFieldElement) realFieldElement12.multiply(t7);
            RealFieldElement realFieldElement14 = (RealFieldElement) realFieldElement13.multiply(realFieldElement2);
            RealFieldElement realFieldElement15 = (RealFieldElement) realFieldElement14.multiply(t7);
            RealFieldElement realFieldElement16 = (RealFieldElement) realFieldElement15.multiply(realFieldElement2);
            RealFieldElement realFieldElement17 = (RealFieldElement) realFieldElement16.multiply(t7);
            RealFieldElement[] realFieldElementArr = (RealFieldElement[]) MathArrays.buildArray(t6.getField(), 16);
            RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) MathArrays.buildArray(t6.getField(), 16);
            int i5 = 0;
            while (i5 < realFieldElementArr.length) {
                RealFieldElement realFieldElement18 = realFieldElement11;
                realFieldElementArr[i5] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement11.multiply(this.d[0][i5])).add(realFieldElement12.multiply(this.d[1][i5]))).add(realFieldElement13.multiply(this.d[2][i5]))).add(realFieldElement14.multiply(this.d[3][i5]))).add(realFieldElement15.multiply(this.d[4][i5]))).add(realFieldElement16.multiply(this.d[5][i5]))).add(realFieldElement17.multiply(this.d[6][i5]));
                T[][] tArr = this.d;
                realFieldElementArr2[i5] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[0][i5].add(realFieldElement5.multiply(tArr[1][i5]))).add(realFieldElement6.multiply(this.d[2][i5]))).add(realFieldElement7.multiply(this.d[3][i5]))).add(realFieldElement8.multiply(this.d[4][i5]))).add(realFieldElement9.multiply(this.d[5][i5]))).add(realFieldElement10.multiply(this.d[6][i5]));
                i5++;
                realFieldElement11 = realFieldElement18;
                realFieldElement17 = realFieldElement17;
            }
            tArrCurrentStateLinearCombination = currentStateLinearCombination(realFieldElementArr[0], realFieldElementArr[1], realFieldElementArr[2], realFieldElementArr[3], realFieldElementArr[4], realFieldElementArr[5], realFieldElementArr[6], realFieldElementArr[7], realFieldElementArr[8], realFieldElementArr[9], realFieldElementArr[10], realFieldElementArr[11], realFieldElementArr[12], realFieldElementArr[13], realFieldElementArr[14], realFieldElementArr[15]);
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElementArr2[0], realFieldElementArr2[1], realFieldElementArr2[2], realFieldElementArr2[3], realFieldElementArr2[4], realFieldElementArr2[5], realFieldElementArr2[6], realFieldElementArr2[7], realFieldElementArr2[8], realFieldElementArr2[9], realFieldElementArr2[10], realFieldElementArr2[11], realFieldElementArr2[12], realFieldElementArr2[13], realFieldElementArr2[14], realFieldElementArr2[15]);
        } else {
            RealFieldElement realFieldElement19 = (RealFieldElement) t10.multiply(realFieldElement2);
            RealFieldElement realFieldElement20 = (RealFieldElement) realFieldElement19.multiply(t7);
            RealFieldElement realFieldElement21 = (RealFieldElement) realFieldElement20.multiply(realFieldElement2);
            RealFieldElement realFieldElement22 = (RealFieldElement) realFieldElement21.multiply(t7);
            RealFieldElement realFieldElement23 = (RealFieldElement) realFieldElement22.multiply(realFieldElement2);
            RealFieldElement realFieldElement24 = (RealFieldElement) realFieldElement23.multiply(t7);
            RealFieldElement[] realFieldElementArr3 = (RealFieldElement[]) MathArrays.buildArray(t6.getField(), 16);
            RealFieldElement[] realFieldElementArr4 = (RealFieldElement[]) MathArrays.buildArray(t6.getField(), 16);
            int i6 = 0;
            while (i6 < realFieldElementArr3.length) {
                realFieldElementArr3[i6] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t10.multiply(this.d[0][i6])).add(realFieldElement19.multiply(this.d[1][i6]))).add(realFieldElement20.multiply(this.d[2][i6]))).add(realFieldElement21.multiply(this.d[3][i6]))).add(realFieldElement22.multiply(this.d[4][i6]))).add(realFieldElement23.multiply(this.d[5][i6]))).add(realFieldElement24.multiply(this.d[6][i6]));
                T[][] tArr2 = this.d;
                int i7 = i6;
                realFieldElementArr4[i7] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr2[0][i6].add(realFieldElement5.multiply(tArr2[1][i6]))).add(realFieldElement6.multiply(this.d[2][i6]))).add(realFieldElement7.multiply(this.d[3][i6]))).add(realFieldElement8.multiply(this.d[4][i6]))).add(realFieldElement9.multiply(this.d[5][i7]))).add(realFieldElement10.multiply(this.d[6][i7]));
                i6 = i7 + 1;
                t10 = t8;
            }
            tArrCurrentStateLinearCombination = previousStateLinearCombination(realFieldElementArr3[0], realFieldElementArr3[1], realFieldElementArr3[2], realFieldElementArr3[3], realFieldElementArr3[4], realFieldElementArr3[5], realFieldElementArr3[6], realFieldElementArr3[7], realFieldElementArr3[8], realFieldElementArr3[9], realFieldElementArr3[10], realFieldElementArr3[11], realFieldElementArr3[12], realFieldElementArr3[13], realFieldElementArr3[14], realFieldElementArr3[15]);
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElementArr4[0], realFieldElementArr4[1], realFieldElementArr4[2], realFieldElementArr4[3], realFieldElementArr4[4], realFieldElementArr4[5], realFieldElementArr4[6], realFieldElementArr4[7], realFieldElementArr4[8], realFieldElementArr4[9], realFieldElementArr4[10], realFieldElementArr4[11], realFieldElementArr4[12], realFieldElementArr4[13], realFieldElementArr4[14], realFieldElementArr4[15]);
        }
        return new FieldODEStateAndDerivative<>(t6, tArrCurrentStateLinearCombination, tArrDerivativeLinearCombination);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    public DormandPrince853FieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new DormandPrince853FieldStepInterpolator<>(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
