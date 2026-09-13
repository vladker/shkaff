package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.opencv.core.Core;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DormandPrince54FieldIntegrator<T extends RealFieldElement<T>> extends EmbeddedRungeKuttaFieldIntegrator<T> {
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";
    private final T e1;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    private final T f6835e3;

    /* JADX INFO: renamed from: e4, reason: collision with root package name */
    private final T f6836e4;

    /* JADX INFO: renamed from: e5, reason: collision with root package name */
    private final T f6837e5;
    private final T e6;
    private final T e7;

    public DormandPrince54FieldIntegrator(Field<T> field, double d, double d6, double d7, double d8) {
        super(field, METHOD_NAME, 6, d, d6, d7, d8);
        this.e1 = fraction(71, 57600);
        this.f6835e3 = fraction(-71, 16695);
        this.f6836e4 = fraction(71, 1920);
        this.f6837e5 = fraction(-17253, 339200);
        this.e6 = fraction(22, 525);
        this.e7 = fraction(-1, 40);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public T estimateError(T[][] tArr, T[] tArr2, T[] tArr3, T t6) {
        T zero = getField().getZero();
        int i5 = 0;
        while (true) {
            int i6 = this.mainSetDimension;
            if (i5 >= i6) {
                return (T) ((RealFieldElement) zero.divide(i6)).sqrt();
            }
            RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[0][i5].multiply(this.e1)).add(tArr[2][i5].multiply(this.f6835e3))).add(tArr[3][i5].multiply(this.f6836e4))).add(tArr[4][i5].multiply(this.f6837e5))).add(tArr[5][i5].multiply(this.e6))).add(tArr[6][i5].multiply(this.e7));
            RealFieldElement realFieldElementMax = MathUtils.max((RealFieldElement) tArr2[i5].abs(), (RealFieldElement) tArr3[i5].abs());
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) t6.multiply(realFieldElement)).divide((RealFieldElement) (this.vecAbsoluteTolerance == null ? ((RealFieldElement) realFieldElementMax.multiply(this.scalRelativeTolerance)).add(this.scalAbsoluteTolerance) : ((RealFieldElement) realFieldElementMax.multiply(this.vecRelativeTolerance[i5])).add(this.vecAbsoluteTolerance[i5])));
            zero = (T) zero.add(realFieldElement2.multiply(realFieldElement2));
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] tArr = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 6, -1));
        int i5 = 0;
        while (i5 < tArr.length) {
            int i6 = i5 + 1;
            tArr[i5] = (RealFieldElement[]) MathArrays.buildArray(getField(), i6);
            i5 = i6;
        }
        tArr[0][0] = fraction(1, 5);
        tArr[1][0] = fraction(3, 40);
        tArr[1][1] = fraction(9, 40);
        tArr[2][0] = fraction(44, 45);
        tArr[2][1] = fraction(-56, 15);
        tArr[2][2] = fraction(32, 9);
        tArr[3][0] = fraction(19372, 6561);
        tArr[3][1] = fraction(-25360, 2187);
        tArr[3][2] = fraction(64448, 6561);
        tArr[3][3] = fraction(Core.StsParseError, 729);
        tArr[4][0] = fraction(9017, 3168);
        tArr[4][1] = fraction(-355, 33);
        tArr[4][2] = fraction(46732, 5247);
        tArr[4][3] = fraction(49, 176);
        tArr[4][4] = fraction(-5103, 18656);
        tArr[5][0] = fraction(35, 384);
        tArr[5][1] = getField().getZero();
        tArr[5][2] = fraction(Videoio.CAP_QT, 1113);
        tArr[5][3] = fraction(125, 192);
        tArr[5][4] = fraction(-2187, 6784);
        tArr[5][5] = fraction(11, 84);
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 7));
        tArr[0] = fraction(35, 384);
        tArr[1] = getField().getZero();
        tArr[2] = fraction(Videoio.CAP_QT, 1113);
        tArr[3] = fraction(125, 192);
        tArr[4] = fraction(-2187, 6784);
        tArr[5] = fraction(11, 84);
        tArr[6] = getField().getZero();
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 6));
        tArr[0] = fraction(1, 5);
        tArr[1] = fraction(3, 10);
        tArr[2] = fraction(4, 5);
        tArr[3] = fraction(8, 9);
        tArr[4] = getField().getOne();
        tArr[5] = getField().getOne();
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public int getOrder() {
        return 5;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaFieldIntegrator
    public DormandPrince54FieldStepInterpolator<T> createInterpolator(boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new DormandPrince54FieldStepInterpolator<>(getField(), z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldEquationsMapper);
    }

    public DormandPrince54FieldIntegrator(Field<T> field, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, METHOD_NAME, 6, d, d6, dArr, dArr2);
        this.e1 = fraction(71, 57600);
        this.f6835e3 = fraction(-71, 16695);
        this.f6836e4 = fraction(71, 1920);
        this.f6837e5 = fraction(-17253, 339200);
        this.e6 = fraction(22, 525);
        this.e7 = fraction(-1, 40);
    }
}
