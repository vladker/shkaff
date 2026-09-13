package org.apache.commons.math3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RealFieldElement<T> extends FieldElement<T> {
    T abs();

    T acos();

    T acosh();

    T add(double d);

    T asin();

    T asinh();

    T atan();

    T atan2(T t6);

    T atanh();

    T cbrt();

    T ceil();

    T copySign(double d);

    T copySign(T t6);

    T cos();

    T cosh();

    T divide(double d);

    T exp();

    T expm1();

    T floor();

    double getReal();

    T hypot(T t6);

    T linearCombination(double d, T t6, double d6, T t7);

    T linearCombination(double d, T t6, double d6, T t7, double d7, T t8);

    T linearCombination(double d, T t6, double d6, T t7, double d7, T t8, double d8, T t9);

    T linearCombination(T t6, T t7, T t8, T t9);

    T linearCombination(T t6, T t7, T t8, T t9, T t10, T t11);

    T linearCombination(T t6, T t7, T t8, T t9, T t10, T t11, T t12, T t13);

    T linearCombination(double[] dArr, T[] tArr);

    T linearCombination(T[] tArr, T[] tArr2);

    T log();

    T log1p();

    T multiply(double d);

    T pow(double d);

    T pow(int i5);

    T pow(T t6);

    @Override // org.apache.commons.math3.FieldElement
    T reciprocal();

    T remainder(double d);

    T remainder(T t6);

    T rint();

    T rootN(int i5);

    long round();

    T scalb(int i5);

    T signum();

    T sin();

    T sinh();

    T sqrt();

    T subtract(double d);

    T tan();

    T tanh();
}
