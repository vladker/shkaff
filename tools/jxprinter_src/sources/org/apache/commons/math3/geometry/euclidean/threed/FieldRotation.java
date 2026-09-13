package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldRotation<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final T f6774q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    private final T f6775q1;

    /* JADX INFO: renamed from: q2, reason: collision with root package name */
    private final T f6776q2;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    private final T f6777q3;

    public FieldRotation(T t6, T t7, T t8, T t9, boolean z6) {
        if (!z6) {
            this.f6774q0 = t6;
            this.f6775q1 = t7;
            this.f6776q2 = t8;
            this.f6777q3 = t9;
            return;
        }
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.multiply(t6)).add(t7.multiply(t7))).add(t8.multiply(t8))).add(t9.multiply(t9))).sqrt()).reciprocal();
        this.f6774q0 = (T) realFieldElement.multiply(t6);
        this.f6775q1 = (T) realFieldElement.multiply(t7);
        this.f6776q2 = (T) realFieldElement.multiply(t8);
        this.f6777q3 = (T) realFieldElement.multiply(t9);
    }

    private T[] buildArray(T t6, T t7, T t8) {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(t6.getField(), 3));
        tArr[0] = t6;
        tArr[1] = t7;
        tArr[2] = t8;
        return tArr;
    }

    private FieldRotation<T> composeInternal(FieldRotation<T> fieldRotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) fieldRotation.f6774q0.multiply(this.f6774q0)).subtract(((RealFieldElement) ((RealFieldElement) fieldRotation.f6775q1.multiply(this.f6775q1)).add(fieldRotation.f6776q2.multiply(this.f6776q2))).add(fieldRotation.f6777q3.multiply(this.f6777q3))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6775q1.multiply(this.f6774q0)).add(fieldRotation.f6774q0.multiply(this.f6775q1))).add(((RealFieldElement) fieldRotation.f6776q2.multiply(this.f6777q3)).subtract(fieldRotation.f6777q3.multiply(this.f6776q2))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6776q2.multiply(this.f6774q0)).add(fieldRotation.f6774q0.multiply(this.f6776q2))).add(((RealFieldElement) fieldRotation.f6777q3.multiply(this.f6775q1)).subtract(fieldRotation.f6775q1.multiply(this.f6777q3))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6777q3.multiply(this.f6774q0)).add(fieldRotation.f6774q0.multiply(this.f6777q3))).add(((RealFieldElement) fieldRotation.f6775q1.multiply(this.f6776q2)).subtract(fieldRotation.f6776q2.multiply(this.f6775q1))), false);
    }

    private FieldRotation<T> composeInverseInternal(FieldRotation<T> fieldRotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6774q0.multiply(this.f6774q0)).add(((RealFieldElement) ((RealFieldElement) fieldRotation.f6775q1.multiply(this.f6775q1)).add(fieldRotation.f6776q2.multiply(this.f6776q2))).add(fieldRotation.f6777q3.multiply(this.f6777q3)))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6774q0.multiply(this.f6775q1)).add(((RealFieldElement) fieldRotation.f6776q2.multiply(this.f6777q3)).subtract(fieldRotation.f6777q3.multiply(this.f6776q2)))).subtract(fieldRotation.f6775q1.multiply(this.f6774q0)), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6774q0.multiply(this.f6776q2)).add(((RealFieldElement) fieldRotation.f6777q3.multiply(this.f6775q1)).subtract(fieldRotation.f6775q1.multiply(this.f6777q3)))).subtract(fieldRotation.f6776q2.multiply(this.f6774q0)), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldRotation.f6774q0.multiply(this.f6777q3)).add(((RealFieldElement) fieldRotation.f6775q1.multiply(this.f6776q2)).subtract(fieldRotation.f6776q2.multiply(this.f6775q1)))).subtract(fieldRotation.f6777q3.multiply(this.f6774q0)), false);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldRotation<T> fieldRotation, FieldRotation<T> fieldRotation2) {
        return (T) fieldRotation.composeInverseInternal(fieldRotation2).getAngle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] mat2quat(T[][] tArr) {
        T[] tArr2 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(tArr[0][0].getField(), 4));
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) tArr[0][0].add(tArr[1][1])).add(tArr[2][2]);
        if (realFieldElement.getReal() > -0.19d) {
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.add(1.0d)).sqrt()).multiply(0.5d);
            tArr2[0] = realFieldElement2;
            RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) realFieldElement2.reciprocal()).multiply(0.25d);
            tArr2[1] = (RealFieldElement) realFieldElement3.multiply(tArr[1][2].subtract(tArr[2][1]));
            tArr2[2] = (RealFieldElement) realFieldElement3.multiply(tArr[2][0].subtract(tArr[0][2]));
            tArr2[3] = (RealFieldElement) realFieldElement3.multiply(tArr[0][1].subtract(tArr[1][0]));
            return tArr2;
        }
        RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) tArr[0][0].subtract(tArr[1][1])).subtract(tArr[2][2]);
        if (realFieldElement4.getReal() > -0.19d) {
            RealFieldElement realFieldElement5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement4.add(1.0d)).sqrt()).multiply(0.5d);
            tArr2[1] = realFieldElement5;
            RealFieldElement realFieldElement6 = (RealFieldElement) ((RealFieldElement) realFieldElement5.reciprocal()).multiply(0.25d);
            tArr2[0] = (RealFieldElement) realFieldElement6.multiply(tArr[1][2].subtract(tArr[2][1]));
            tArr2[2] = (RealFieldElement) realFieldElement6.multiply(tArr[0][1].add(tArr[1][0]));
            tArr2[3] = (RealFieldElement) realFieldElement6.multiply(tArr[0][2].add(tArr[2][0]));
            return tArr2;
        }
        RealFieldElement realFieldElement7 = (RealFieldElement) ((RealFieldElement) tArr[1][1].subtract(tArr[0][0])).subtract(tArr[2][2]);
        if (realFieldElement7.getReal() > -0.19d) {
            RealFieldElement realFieldElement8 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement7.add(1.0d)).sqrt()).multiply(0.5d);
            tArr2[2] = realFieldElement8;
            RealFieldElement realFieldElement9 = (RealFieldElement) ((RealFieldElement) realFieldElement8.reciprocal()).multiply(0.25d);
            tArr2[0] = (RealFieldElement) realFieldElement9.multiply(tArr[2][0].subtract(tArr[0][2]));
            tArr2[1] = (RealFieldElement) realFieldElement9.multiply(tArr[0][1].add(tArr[1][0]));
            tArr2[3] = (RealFieldElement) realFieldElement9.multiply(tArr[2][1].add(tArr[1][2]));
            return tArr2;
        }
        RealFieldElement realFieldElement10 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[2][2].subtract(tArr[0][0])).subtract(tArr[1][1])).add(1.0d)).sqrt()).multiply(0.5d);
        tArr2[3] = realFieldElement10;
        RealFieldElement realFieldElement11 = (RealFieldElement) ((RealFieldElement) realFieldElement10.reciprocal()).multiply(0.25d);
        tArr2[0] = (RealFieldElement) realFieldElement11.multiply(tArr[0][1].subtract(tArr[1][0]));
        tArr2[1] = (RealFieldElement) realFieldElement11.multiply(tArr[0][2].add(tArr[2][0]));
        tArr2[2] = (RealFieldElement) realFieldElement11.multiply(tArr[2][1].add(tArr[1][2]));
        return tArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r15v60 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r18v8, types: [org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r21v0, types: [T extends org.apache.commons.math3.RealFieldElement<T>[][]] */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r24v0, types: [org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r28v0, types: [org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, org.apache.commons.math3.FieldElement] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    private T[][] orthogonalizeMatrix(T[][] tArr, double d) {
        char c = 0;
        T[] tArr2 = tArr[0];
        T t6 = tArr2[0];
        char c6 = 1;
        T t7 = tArr2[1];
        char c7 = 2;
        T t8 = tArr2[2];
        T[] tArr3 = tArr[1];
        T t9 = tArr3[0];
        T t10 = tArr3[1];
        T t11 = tArr3[2];
        T[] tArr4 = tArr[2];
        T t12 = tArr4[0];
        T t13 = tArr4[1];
        T t14 = tArr4[2];
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(t6.getField(), 3, 3);
        double d6 = 0.0d;
        int i5 = 0;
        ?? r6 = t8;
        ?? r7 = t6;
        ?? r8 = t7;
        ?? r9 = t11;
        ?? r10 = t9;
        ?? r11 = t10;
        ?? r12 = t14;
        ?? r13 = t12;
        ?? r14 = t13;
        ?? r15 = realFieldElementArr;
        while (true) {
            char c8 = c;
            int i6 = i5 + 1;
            char c9 = c6;
            if (i6 >= 11) {
                throw new NotARotationMatrixException(LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX, Integer.valueOf(i5));
            }
            RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c8].multiply(r7)).add(tArr[c9][c8].multiply(r10))).add(tArr[c7][c8].multiply(r13));
            char c10 = c7;
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c9].multiply(r7)).add(tArr[c9][c9].multiply(r10))).add(tArr[c10][c9].multiply(r13));
            RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c10].multiply(r7)).add(tArr[c9][c10].multiply(r10))).add(tArr[c10][c10].multiply(r13));
            ?? r21 = (T[][]) r15;
            RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c8].multiply(r8)).add(tArr[c9][c8].multiply(r11))).add(tArr[c10][c8].multiply(r14));
            double d7 = d6;
            RealFieldElement realFieldElement5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c9].multiply(r8)).add(tArr[c9][c9].multiply(r11))).add(tArr[c10][c9].multiply(r14));
            RealFieldElement realFieldElement6 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c10].multiply(r8)).add(tArr[c9][c10].multiply(r11))).add(tArr[c10][c10].multiply(r14));
            ?? r24 = r14;
            RealFieldElement realFieldElement7 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c8].multiply(r6)).add(tArr[c9][c8].multiply(r9))).add(tArr[c10][c8].multiply(r12));
            ?? r25 = r13;
            RealFieldElement realFieldElement8 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c9].multiply(r6)).add(tArr[c9][c9].multiply(r9))).add(tArr[c10][c9].multiply(r12));
            ?? r26 = r11;
            RealFieldElement realFieldElement9 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) tArr[c8][c10].multiply(r6)).add(tArr[c9][c10].multiply(r9))).add(tArr[c10][c10].multiply(r12));
            ?? r18 = r12;
            ?? r28 = r9;
            r21[c8][c8] = (RealFieldElement) r7.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r7.multiply(realFieldElement)).add(r8.multiply(realFieldElement2))).add(r6.multiply(realFieldElement3))).subtract(tArr[c8][c8])).multiply(0.5d));
            r21[c8][c9] = (RealFieldElement) r8.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r7.multiply(realFieldElement4)).add(r8.multiply(realFieldElement5))).add(r6.multiply(realFieldElement6))).subtract(tArr[c8][c9])).multiply(0.5d));
            r21[c8][c10] = (RealFieldElement) r6.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r7.multiply(realFieldElement7)).add(r8.multiply(realFieldElement8))).add(r6.multiply(realFieldElement9))).subtract(tArr[c8][c10])).multiply(0.5d));
            r21[c9][c8] = (RealFieldElement) r10.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r10.multiply(realFieldElement)).add(r26.multiply(realFieldElement2))).add(r28.multiply(realFieldElement3))).subtract(tArr[c9][c8])).multiply(0.5d));
            r21[c9][c9] = (RealFieldElement) r26.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r10.multiply(realFieldElement4)).add(r26.multiply(realFieldElement5))).add(r28.multiply(realFieldElement6))).subtract(tArr[c9][c9])).multiply(0.5d));
            r21[c9][c10] = (RealFieldElement) r28.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r10.multiply(realFieldElement7)).add(r26.multiply(realFieldElement8))).add(r28.multiply(realFieldElement9))).subtract(tArr[c9][c10])).multiply(0.5d));
            r21[c10][c8] = (RealFieldElement) r25.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(realFieldElement)).add(r24.multiply(realFieldElement2))).add(r18.multiply(realFieldElement3))).subtract(tArr[c10][c8])).multiply(0.5d));
            r21[c10][c9] = (RealFieldElement) r24.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(realFieldElement4)).add(r24.multiply(realFieldElement5))).add(r18.multiply(realFieldElement6))).subtract(tArr[c10][c9])).multiply(0.5d));
            r21[c10][c10] = (RealFieldElement) r18.subtract(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r25.multiply(realFieldElement7)).add(r24.multiply(realFieldElement8))).add(r18.multiply(realFieldElement9))).subtract(tArr[c10][c10])).multiply(0.5d));
            double real = r21[c8][c8].getReal() - tArr[c8][c8].getReal();
            double real2 = r21[c8][c9].getReal() - tArr[c8][c9].getReal();
            double real3 = r21[c8][c10].getReal() - tArr[c8][c10].getReal();
            double real4 = r21[c9][c8].getReal() - tArr[c9][c8].getReal();
            double real5 = r21[c9][c9].getReal() - tArr[c9][c9].getReal();
            double real6 = r21[c9][c10].getReal() - tArr[c9][c10].getReal();
            double real7 = r21[c10][c8].getReal() - tArr[c10][c8].getReal();
            double real8 = r21[c10][c9].getReal() - tArr[c10][c9].getReal();
            double real9 = r21[c10][c10].getReal() - tArr[c10][c10].getReal();
            double d8 = real4 * real4;
            double d9 = real5 * real5;
            double d10 = real6 * real6;
            double d11 = real7 * real7;
            double d12 = real8 * real8;
            double d13 = real9 * real9;
            d6 = d13 + d12 + d11 + d10 + d9 + d8 + (real3 * real3) + (real2 * real2) + (real * real);
            if (FastMath.abs(d6 - d7) <= d) {
                return r21;
            }
            ?? r16 = r21[c8];
            ?? r17 = r16[c8];
            ?? r19 = r16[c9];
            ?? r20 = r16[c10];
            ?? r22 = r21[c9];
            ?? r23 = r22[c8];
            ?? r27 = r22[c9];
            ?? r29 = r22[c10];
            ?? r30 = r21[c10];
            ?? r110 = r30[c8];
            ?? r111 = r30[c9];
            ?? r31 = r30[c10];
            c = c8;
            c6 = c9;
            c7 = c10;
            i5 = i6;
            r15 = r21;
            r6 = r20;
            r7 = r17;
            r8 = r19;
            r9 = r29;
            r10 = r23;
            r11 = r27;
            r12 = r31;
            r13 = r110;
            r14 = r111;
        }
    }

    private FieldVector3D<T> vector(double d, double d6, double d7) {
        RealFieldElement realFieldElement = (RealFieldElement) this.f6774q0.getField().getZero();
        return new FieldVector3D<>((RealFieldElement) realFieldElement.add(d), (RealFieldElement) realFieldElement.add(d6), (RealFieldElement) realFieldElement.add(d7));
    }

    public FieldVector3D<T> applyInverseTo(FieldVector3D<T> fieldVector3D) {
        RealFieldElement x6 = fieldVector3D.getX();
        RealFieldElement y6 = fieldVector3D.getY();
        RealFieldElement z6 = fieldVector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(x6)).add(this.f6776q2.multiply(y6))).add(this.f6777q3.multiply(z6));
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6774q0.negate();
        return new FieldVector3D<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) x6.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6776q2.multiply(z6)).subtract(this.f6777q3.multiply(y6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(x6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) y6.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6777q3.multiply(x6)).subtract(this.f6775q1.multiply(z6))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(y6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) z6.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6775q1.multiply(y6)).subtract(this.f6776q2.multiply(x6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(z6));
    }

    public FieldVector3D<T> applyTo(FieldVector3D<T> fieldVector3D) {
        RealFieldElement x6 = fieldVector3D.getX();
        RealFieldElement y6 = fieldVector3D.getY();
        RealFieldElement z6 = fieldVector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(x6)).add(this.f6776q2.multiply(y6))).add(this.f6777q3.multiply(z6));
        T t6 = this.f6774q0;
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.multiply(((RealFieldElement) x6.multiply(t6)).subtract(((RealFieldElement) this.f6776q2.multiply(z6)).subtract(this.f6777q3.multiply(y6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(x6);
        T t7 = this.f6774q0;
        RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t7.multiply(((RealFieldElement) y6.multiply(t7)).subtract(((RealFieldElement) this.f6777q3.multiply(x6)).subtract(this.f6775q1.multiply(z6))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(y6);
        T t8 = this.f6774q0;
        return new FieldVector3D<>(realFieldElement2, realFieldElement3, (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t8.multiply(((RealFieldElement) z6.multiply(t8)).subtract(((RealFieldElement) this.f6775q1.multiply(y6)).subtract(this.f6776q2.multiply(x6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(z6));
    }

    public FieldRotation<T> compose(FieldRotation<T> fieldRotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInternal(fieldRotation) : fieldRotation.composeInternal(this);
    }

    public FieldRotation<T> composeInverse(FieldRotation<T> fieldRotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInverseInternal(fieldRotation) : fieldRotation.composeInternal(revert());
    }

    public T getAngle() {
        if (this.f6774q0.getReal() >= -0.1d && this.f6774q0.getReal() <= 0.1d) {
            return this.f6774q0.getReal() < 0.0d ? (T) ((RealFieldElement) ((RealFieldElement) this.f6774q0.negate()).acos()).multiply(2) : (T) ((RealFieldElement) this.f6774q0.acos()).multiply(2);
        }
        T t6 = this.f6775q1;
        RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
        T t7 = this.f6776q2;
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.add(t7.multiply(t7));
        T t8 = this.f6777q3;
        return (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.add(t8.multiply(t8))).sqrt()).asin()).multiply(2);
    }

    @Deprecated
    public T[] getAngles(RotationOrder rotationOrder) {
        return (T[]) getAngles(rotationOrder, RotationConvention.VECTOR_OPERATOR);
    }

    @Deprecated
    public FieldVector3D<T> getAxis() {
        return getAxis(RotationConvention.VECTOR_OPERATOR);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] getMatrix() {
        T t6 = this.f6774q0;
        RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6774q0.multiply(this.f6775q1);
        RealFieldElement realFieldElement3 = (RealFieldElement) this.f6774q0.multiply(this.f6776q2);
        RealFieldElement realFieldElement4 = (RealFieldElement) this.f6774q0.multiply(this.f6777q3);
        T t7 = this.f6775q1;
        RealFieldElement realFieldElement5 = (RealFieldElement) t7.multiply(t7);
        RealFieldElement realFieldElement6 = (RealFieldElement) this.f6775q1.multiply(this.f6776q2);
        RealFieldElement realFieldElement7 = (RealFieldElement) this.f6775q1.multiply(this.f6777q3);
        T t8 = this.f6776q2;
        RealFieldElement realFieldElement8 = (RealFieldElement) t8.multiply(t8);
        RealFieldElement realFieldElement9 = (RealFieldElement) this.f6776q2.multiply(this.f6777q3);
        T t9 = this.f6777q3;
        RealFieldElement realFieldElement10 = (RealFieldElement) t9.multiply(t9);
        T[][] tArr = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(this.f6774q0.getField(), 3, 3));
        tArr[0][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.add(realFieldElement5)).multiply(2)).subtract(1.0d);
        tArr[1][0] = (RealFieldElement) ((RealFieldElement) realFieldElement6.subtract(realFieldElement4)).multiply(2);
        tArr[2][0] = (RealFieldElement) ((RealFieldElement) realFieldElement7.add(realFieldElement3)).multiply(2);
        tArr[0][1] = (RealFieldElement) ((RealFieldElement) realFieldElement6.add(realFieldElement4)).multiply(2);
        tArr[1][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.add(realFieldElement8)).multiply(2)).subtract(1.0d);
        tArr[2][1] = (RealFieldElement) ((RealFieldElement) realFieldElement9.subtract(realFieldElement2)).multiply(2);
        tArr[0][2] = (RealFieldElement) ((RealFieldElement) realFieldElement7.subtract(realFieldElement3)).multiply(2);
        tArr[1][2] = (RealFieldElement) ((RealFieldElement) realFieldElement9.add(realFieldElement2)).multiply(2);
        tArr[2][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.add(realFieldElement10)).multiply(2)).subtract(1.0d);
        return tArr;
    }

    public T getQ0() {
        return this.f6774q0;
    }

    public T getQ1() {
        return this.f6775q1;
    }

    public T getQ2() {
        return this.f6776q2;
    }

    public T getQ3() {
        return this.f6777q3;
    }

    public FieldRotation<T> revert() {
        return new FieldRotation<>((RealFieldElement) this.f6774q0.negate(), (RealFieldElement) this.f6775q1, (RealFieldElement) this.f6776q2, (RealFieldElement) this.f6777q3, false);
    }

    public Rotation toRotation() {
        return new Rotation(this.f6774q0.getReal(), this.f6775q1.getReal(), this.f6776q2.getReal(), this.f6777q3.getReal(), false);
    }

    private FieldRotation<T> composeInternal(Rotation rotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) this.f6774q0.multiply(rotation.getQ0())).subtract(((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(rotation.getQ1())).add(this.f6776q2.multiply(rotation.getQ2()))).add(this.f6777q3.multiply(rotation.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6774q0.multiply(rotation.getQ1())).add(this.f6775q1.multiply(rotation.getQ0()))).add(((RealFieldElement) this.f6777q3.multiply(rotation.getQ2())).subtract(this.f6776q2.multiply(rotation.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6774q0.multiply(rotation.getQ2())).add(this.f6776q2.multiply(rotation.getQ0()))).add(((RealFieldElement) this.f6775q1.multiply(rotation.getQ3())).subtract(this.f6777q3.multiply(rotation.getQ1()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6774q0.multiply(rotation.getQ3())).add(this.f6777q3.multiply(rotation.getQ0()))).add(((RealFieldElement) this.f6776q2.multiply(rotation.getQ1())).subtract(this.f6775q1.multiply(rotation.getQ2()))), false);
    }

    private FieldRotation<T> composeInverseInternal(Rotation rotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6774q0.multiply(rotation.getQ0())).add(((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(rotation.getQ1())).add(this.f6776q2.multiply(rotation.getQ2()))).add(this.f6777q3.multiply(rotation.getQ3())))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(rotation.getQ0())).add(((RealFieldElement) this.f6777q3.multiply(rotation.getQ2())).subtract(this.f6776q2.multiply(rotation.getQ3())))).subtract(this.f6774q0.multiply(rotation.getQ1())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6776q2.multiply(rotation.getQ0())).add(((RealFieldElement) this.f6775q1.multiply(rotation.getQ3())).subtract(this.f6777q3.multiply(rotation.getQ1())))).subtract(this.f6774q0.multiply(rotation.getQ2())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6777q3.multiply(rotation.getQ0())).add(((RealFieldElement) this.f6776q2.multiply(rotation.getQ1())).subtract(this.f6775q1.multiply(rotation.getQ2())))).subtract(this.f6774q0.multiply(rotation.getQ3())), false);
    }

    public FieldRotation<T> compose(Rotation rotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInternal(rotation) : applyTo(rotation, this);
    }

    public FieldRotation<T> composeInverse(Rotation rotation, RotationConvention rotationConvention) {
        return rotationConvention == RotationConvention.VECTOR_OPERATOR ? composeInverseInternal(rotation) : applyTo(rotation, revert());
    }

    public T[] getAngles(RotationOrder rotationOrder, RotationConvention rotationConvention) {
        if (rotationConvention == RotationConvention.VECTOR_OPERATOR) {
            if (rotationOrder == RotationOrder.XYZ) {
                FieldVector3D<T> fieldVector3DApplyTo = applyTo(vector(0.0d, 0.0d, 1.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
                if (fieldVector3DApplyInverseTo.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo.getZ().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo.getY().negate()).atan2(fieldVector3DApplyTo.getZ()), (RealFieldElement) fieldVector3DApplyInverseTo.getZ().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo.getY().negate()).atan2(fieldVector3DApplyInverseTo.getX()));
            }
            if (rotationOrder == RotationOrder.XZY) {
                FieldVector3D<T> fieldVector3DApplyTo2 = applyTo(vector(0.0d, 1.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo2 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
                if (fieldVector3DApplyInverseTo2.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo2.getY().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo2.getZ().atan2(fieldVector3DApplyTo2.getY()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo2.getY().asin()).negate(), (RealFieldElement) fieldVector3DApplyInverseTo2.getZ().atan2(fieldVector3DApplyInverseTo2.getX()));
            }
            if (rotationOrder == RotationOrder.YXZ) {
                FieldVector3D<T> fieldVector3DApplyTo3 = applyTo(vector(0.0d, 0.0d, 1.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo3 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
                if (fieldVector3DApplyInverseTo3.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo3.getZ().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo3.getX().atan2(fieldVector3DApplyTo3.getZ()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo3.getZ().asin()).negate(), (RealFieldElement) fieldVector3DApplyInverseTo3.getX().atan2(fieldVector3DApplyInverseTo3.getY()));
            }
            if (rotationOrder == RotationOrder.YZX) {
                FieldVector3D<T> fieldVector3DApplyTo4 = applyTo(vector(1.0d, 0.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo4 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
                if (fieldVector3DApplyInverseTo4.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo4.getX().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo4.getZ().negate()).atan2(fieldVector3DApplyTo4.getX()), (RealFieldElement) fieldVector3DApplyInverseTo4.getX().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo4.getZ().negate()).atan2(fieldVector3DApplyInverseTo4.getY()));
            }
            if (rotationOrder == RotationOrder.ZXY) {
                FieldVector3D<T> fieldVector3DApplyTo5 = applyTo(vector(0.0d, 1.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo5 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
                if (fieldVector3DApplyInverseTo5.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo5.getY().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo5.getX().negate()).atan2(fieldVector3DApplyTo5.getY()), (RealFieldElement) fieldVector3DApplyInverseTo5.getY().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo5.getX().negate()).atan2(fieldVector3DApplyInverseTo5.getZ()));
            }
            if (rotationOrder == RotationOrder.ZYX) {
                FieldVector3D<T> fieldVector3DApplyTo6 = applyTo(vector(1.0d, 0.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo6 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
                if (fieldVector3DApplyInverseTo6.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo6.getX().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(true);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo6.getY().atan2(fieldVector3DApplyTo6.getX()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo6.getX().asin()).negate(), (RealFieldElement) fieldVector3DApplyInverseTo6.getY().atan2(fieldVector3DApplyInverseTo6.getZ()));
            }
            if (rotationOrder == RotationOrder.XYX) {
                FieldVector3D<T> fieldVector3DApplyTo7 = applyTo(vector(1.0d, 0.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo7 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
                if (fieldVector3DApplyInverseTo7.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo7.getX().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo7.getY().atan2(fieldVector3DApplyTo7.getZ().negate()), (RealFieldElement) fieldVector3DApplyInverseTo7.getX().acos(), (RealFieldElement) fieldVector3DApplyInverseTo7.getY().atan2(fieldVector3DApplyInverseTo7.getZ()));
            }
            if (rotationOrder == RotationOrder.XZX) {
                FieldVector3D<T> fieldVector3DApplyTo8 = applyTo(vector(1.0d, 0.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo8 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
                if (fieldVector3DApplyInverseTo8.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo8.getX().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo8.getZ().atan2(fieldVector3DApplyTo8.getY()), (RealFieldElement) fieldVector3DApplyInverseTo8.getX().acos(), (RealFieldElement) fieldVector3DApplyInverseTo8.getZ().atan2(fieldVector3DApplyInverseTo8.getY().negate()));
            }
            if (rotationOrder == RotationOrder.YXY) {
                FieldVector3D<T> fieldVector3DApplyTo9 = applyTo(vector(0.0d, 1.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo9 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
                if (fieldVector3DApplyInverseTo9.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo9.getY().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo9.getX().atan2(fieldVector3DApplyTo9.getZ()), (RealFieldElement) fieldVector3DApplyInverseTo9.getY().acos(), (RealFieldElement) fieldVector3DApplyInverseTo9.getX().atan2(fieldVector3DApplyInverseTo9.getZ().negate()));
            }
            if (rotationOrder == RotationOrder.YZY) {
                FieldVector3D<T> fieldVector3DApplyTo10 = applyTo(vector(0.0d, 1.0d, 0.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo10 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
                if (fieldVector3DApplyInverseTo10.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo10.getY().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo10.getZ().atan2(fieldVector3DApplyTo10.getX().negate()), (RealFieldElement) fieldVector3DApplyInverseTo10.getY().acos(), (RealFieldElement) fieldVector3DApplyInverseTo10.getZ().atan2(fieldVector3DApplyInverseTo10.getX()));
            }
            if (rotationOrder == RotationOrder.ZXZ) {
                FieldVector3D<T> fieldVector3DApplyTo11 = applyTo(vector(0.0d, 0.0d, 1.0d));
                FieldVector3D<T> fieldVector3DApplyInverseTo11 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
                if (fieldVector3DApplyInverseTo11.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo11.getZ().getReal() > 0.9999999999d) {
                    throw new CardanEulerSingularityException(false);
                }
                return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo11.getX().atan2(fieldVector3DApplyTo11.getY().negate()), (RealFieldElement) fieldVector3DApplyInverseTo11.getZ().acos(), (RealFieldElement) fieldVector3DApplyInverseTo11.getX().atan2(fieldVector3DApplyInverseTo11.getY()));
            }
            FieldVector3D<T> fieldVector3DApplyTo12 = applyTo(vector(0.0d, 0.0d, 1.0d));
            FieldVector3D<T> fieldVector3DApplyInverseTo12 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
            if (fieldVector3DApplyInverseTo12.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo12.getZ().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyTo12.getY().atan2(fieldVector3DApplyTo12.getX()), (RealFieldElement) fieldVector3DApplyInverseTo12.getZ().acos(), (RealFieldElement) fieldVector3DApplyInverseTo12.getY().atan2(fieldVector3DApplyInverseTo12.getX().negate()));
        }
        if (rotationOrder == RotationOrder.XYZ) {
            FieldVector3D<T> fieldVector3DApplyTo13 = applyTo(Vector3D.PLUS_I);
            FieldVector3D<T> fieldVector3DApplyInverseTo13 = applyInverseTo(Vector3D.PLUS_K);
            if (fieldVector3DApplyInverseTo13.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo13.getX().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo13.getY().negate()).atan2(fieldVector3DApplyInverseTo13.getZ()), (RealFieldElement) fieldVector3DApplyInverseTo13.getX().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo13.getY().negate()).atan2(fieldVector3DApplyTo13.getX()));
        }
        if (rotationOrder == RotationOrder.XZY) {
            FieldVector3D<T> fieldVector3DApplyTo14 = applyTo(Vector3D.PLUS_I);
            FieldVector3D<T> fieldVector3DApplyInverseTo14 = applyInverseTo(Vector3D.PLUS_J);
            if (fieldVector3DApplyInverseTo14.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo14.getX().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo14.getZ().atan2(fieldVector3DApplyInverseTo14.getY()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo14.getX().asin()).negate(), (RealFieldElement) fieldVector3DApplyTo14.getZ().atan2(fieldVector3DApplyTo14.getX()));
        }
        if (rotationOrder == RotationOrder.YXZ) {
            FieldVector3D<T> fieldVector3DApplyTo15 = applyTo(Vector3D.PLUS_J);
            FieldVector3D<T> fieldVector3DApplyInverseTo15 = applyInverseTo(Vector3D.PLUS_K);
            if (fieldVector3DApplyInverseTo15.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo15.getY().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo15.getX().atan2(fieldVector3DApplyInverseTo15.getZ()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo15.getY().asin()).negate(), (RealFieldElement) fieldVector3DApplyTo15.getX().atan2(fieldVector3DApplyTo15.getY()));
        }
        if (rotationOrder == RotationOrder.YZX) {
            FieldVector3D<T> fieldVector3DApplyTo16 = applyTo(Vector3D.PLUS_J);
            FieldVector3D<T> fieldVector3DApplyInverseTo16 = applyInverseTo(Vector3D.PLUS_I);
            if (fieldVector3DApplyInverseTo16.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo16.getY().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo16.getZ().negate()).atan2(fieldVector3DApplyInverseTo16.getX()), (RealFieldElement) fieldVector3DApplyInverseTo16.getY().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo16.getZ().negate()).atan2(fieldVector3DApplyTo16.getY()));
        }
        if (rotationOrder == RotationOrder.ZXY) {
            FieldVector3D<T> fieldVector3DApplyTo17 = applyTo(Vector3D.PLUS_K);
            FieldVector3D<T> fieldVector3DApplyInverseTo17 = applyInverseTo(Vector3D.PLUS_J);
            if (fieldVector3DApplyInverseTo17.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo17.getZ().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo17.getX().negate()).atan2(fieldVector3DApplyInverseTo17.getY()), (RealFieldElement) fieldVector3DApplyInverseTo17.getZ().asin(), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyTo17.getX().negate()).atan2(fieldVector3DApplyTo17.getZ()));
        }
        if (rotationOrder == RotationOrder.ZYX) {
            FieldVector3D<T> fieldVector3DApplyTo18 = applyTo(Vector3D.PLUS_K);
            FieldVector3D<T> fieldVector3DApplyInverseTo18 = applyInverseTo(Vector3D.PLUS_I);
            if (fieldVector3DApplyInverseTo18.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo18.getZ().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(true);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo18.getY().atan2(fieldVector3DApplyInverseTo18.getX()), (RealFieldElement) ((RealFieldElement) fieldVector3DApplyInverseTo18.getZ().asin()).negate(), (RealFieldElement) fieldVector3DApplyTo18.getY().atan2(fieldVector3DApplyTo18.getZ()));
        }
        if (rotationOrder == RotationOrder.XYX) {
            Vector3D vector3D = Vector3D.PLUS_I;
            FieldVector3D<T> fieldVector3DApplyTo19 = applyTo(vector3D);
            FieldVector3D<T> fieldVector3DApplyInverseTo19 = applyInverseTo(vector3D);
            if (fieldVector3DApplyInverseTo19.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo19.getX().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo19.getY().atan2(fieldVector3DApplyInverseTo19.getZ().negate()), (RealFieldElement) fieldVector3DApplyInverseTo19.getX().acos(), (RealFieldElement) fieldVector3DApplyTo19.getY().atan2(fieldVector3DApplyTo19.getZ()));
        }
        if (rotationOrder == RotationOrder.XZX) {
            Vector3D vector3D2 = Vector3D.PLUS_I;
            FieldVector3D<T> fieldVector3DApplyTo20 = applyTo(vector3D2);
            FieldVector3D<T> fieldVector3DApplyInverseTo20 = applyInverseTo(vector3D2);
            if (fieldVector3DApplyInverseTo20.getX().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo20.getX().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo20.getZ().atan2(fieldVector3DApplyInverseTo20.getY()), (RealFieldElement) fieldVector3DApplyInverseTo20.getX().acos(), (RealFieldElement) fieldVector3DApplyTo20.getZ().atan2(fieldVector3DApplyTo20.getY().negate()));
        }
        if (rotationOrder == RotationOrder.YXY) {
            Vector3D vector3D3 = Vector3D.PLUS_J;
            FieldVector3D<T> fieldVector3DApplyTo21 = applyTo(vector3D3);
            FieldVector3D<T> fieldVector3DApplyInverseTo21 = applyInverseTo(vector3D3);
            if (fieldVector3DApplyInverseTo21.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo21.getY().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo21.getX().atan2(fieldVector3DApplyInverseTo21.getZ()), (RealFieldElement) fieldVector3DApplyInverseTo21.getY().acos(), (RealFieldElement) fieldVector3DApplyTo21.getX().atan2(fieldVector3DApplyTo21.getZ().negate()));
        }
        if (rotationOrder == RotationOrder.YZY) {
            Vector3D vector3D4 = Vector3D.PLUS_J;
            FieldVector3D<T> fieldVector3DApplyTo22 = applyTo(vector3D4);
            FieldVector3D<T> fieldVector3DApplyInverseTo22 = applyInverseTo(vector3D4);
            if (fieldVector3DApplyInverseTo22.getY().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo22.getY().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo22.getZ().atan2(fieldVector3DApplyInverseTo22.getX().negate()), (RealFieldElement) fieldVector3DApplyInverseTo22.getY().acos(), (RealFieldElement) fieldVector3DApplyTo22.getZ().atan2(fieldVector3DApplyTo22.getX()));
        }
        if (rotationOrder == RotationOrder.ZXZ) {
            Vector3D vector3D5 = Vector3D.PLUS_K;
            FieldVector3D<T> fieldVector3DApplyTo23 = applyTo(vector3D5);
            FieldVector3D<T> fieldVector3DApplyInverseTo23 = applyInverseTo(vector3D5);
            if (fieldVector3DApplyInverseTo23.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo23.getZ().getReal() > 0.9999999999d) {
                throw new CardanEulerSingularityException(false);
            }
            return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo23.getX().atan2(fieldVector3DApplyInverseTo23.getY().negate()), (RealFieldElement) fieldVector3DApplyInverseTo23.getZ().acos(), (RealFieldElement) fieldVector3DApplyTo23.getX().atan2(fieldVector3DApplyTo23.getY()));
        }
        Vector3D vector3D6 = Vector3D.PLUS_K;
        FieldVector3D<T> fieldVector3DApplyTo24 = applyTo(vector3D6);
        FieldVector3D<T> fieldVector3DApplyInverseTo24 = applyInverseTo(vector3D6);
        if (fieldVector3DApplyInverseTo24.getZ().getReal() < -0.9999999999d || fieldVector3DApplyInverseTo24.getZ().getReal() > 0.9999999999d) {
            throw new CardanEulerSingularityException(false);
        }
        return (T[]) buildArray((RealFieldElement) fieldVector3DApplyInverseTo24.getY().atan2(fieldVector3DApplyInverseTo24.getX()), (RealFieldElement) fieldVector3DApplyInverseTo24.getZ().acos(), (RealFieldElement) fieldVector3DApplyTo24.getY().atan2(fieldVector3DApplyTo24.getX().negate()));
    }

    public FieldVector3D<T> getAxis(RotationConvention rotationConvention) {
        T t6 = this.f6775q1;
        RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(t6);
        T t7 = this.f6776q2;
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.add(t7.multiply(t7));
        T t8 = this.f6777q3;
        RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElement2.add(t8.multiply(t8));
        if (realFieldElement3.getReal() == 0.0d) {
            Field<T> field = realFieldElement3.getField();
            return new FieldVector3D<>((RealFieldElement) (rotationConvention == RotationConvention.VECTOR_OPERATOR ? field.getOne() : ((RealFieldElement) field.getOne()).negate()), (RealFieldElement) field.getZero(), (RealFieldElement) field.getZero());
        }
        double d = rotationConvention == RotationConvention.VECTOR_OPERATOR ? 1.0d : -1.0d;
        if (this.f6774q0.getReal() < 0.0d) {
            RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement3.sqrt()).reciprocal()).multiply(d);
            return new FieldVector3D<>((RealFieldElement) this.f6775q1.multiply(realFieldElement4), (RealFieldElement) this.f6776q2.multiply(realFieldElement4), (RealFieldElement) this.f6777q3.multiply(realFieldElement4));
        }
        RealFieldElement realFieldElement5 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement3.sqrt()).reciprocal()).negate()).multiply(d);
        return new FieldVector3D<>((RealFieldElement) this.f6775q1.multiply(realFieldElement5), (RealFieldElement) this.f6776q2.multiply(realFieldElement5), (RealFieldElement) this.f6777q3.multiply(realFieldElement5));
    }

    public FieldVector3D<T> applyTo(Vector3D vector3D) {
        double x6 = vector3D.getX();
        double y6 = vector3D.getY();
        double z6 = vector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(x6)).add(this.f6776q2.multiply(y6))).add(this.f6777q3.multiply(z6));
        T t6 = this.f6774q0;
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.multiply(((RealFieldElement) t6.multiply(x6)).subtract(((RealFieldElement) this.f6776q2.multiply(z6)).subtract(this.f6777q3.multiply(y6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(x6);
        T t7 = this.f6774q0;
        RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(y6)).subtract(((RealFieldElement) this.f6777q3.multiply(x6)).subtract(this.f6775q1.multiply(z6))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(y6);
        T t8 = this.f6774q0;
        return new FieldVector3D<>(realFieldElement2, realFieldElement3, (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t8.multiply(((RealFieldElement) t8.multiply(z6)).subtract(((RealFieldElement) this.f6775q1.multiply(y6)).subtract(this.f6776q2.multiply(x6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(z6));
    }

    public FieldVector3D<T> applyInverseTo(Vector3D vector3D) {
        double x6 = vector3D.getX();
        double y6 = vector3D.getY();
        double z6 = vector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(x6)).add(this.f6776q2.multiply(y6))).add(this.f6777q3.multiply(z6));
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6774q0.negate();
        return new FieldVector3D<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(x6)).subtract(((RealFieldElement) this.f6776q2.multiply(z6)).subtract(this.f6777q3.multiply(y6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(x6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(y6)).subtract(((RealFieldElement) this.f6777q3.multiply(x6)).subtract(this.f6775q1.multiply(z6))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(y6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(z6)).subtract(((RealFieldElement) this.f6775q1.multiply(y6)).subtract(this.f6776q2.multiply(x6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(z6));
    }

    @Deprecated
    public FieldRotation(FieldVector3D<T> fieldVector3D, T t6) {
        this(fieldVector3D, t6, RotationConvention.VECTOR_OPERATOR);
    }

    public void applyTo(T[] tArr, T[] tArr2) {
        T t6 = tArr[0];
        T t7 = tArr[1];
        T t8 = tArr[2];
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(t6)).add(this.f6776q2.multiply(t7))).add(this.f6777q3.multiply(t8));
        T t9 = this.f6774q0;
        tArr2[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t9.multiply(((RealFieldElement) t6.multiply(t9)).subtract(((RealFieldElement) this.f6776q2.multiply(t8)).subtract(this.f6777q3.multiply(t7))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(t6);
        T t10 = this.f6774q0;
        tArr2[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t10.multiply(((RealFieldElement) t7.multiply(t10)).subtract(((RealFieldElement) this.f6777q3.multiply(t6)).subtract(this.f6775q1.multiply(t8))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(t7);
        T t11 = this.f6774q0;
        tArr2[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t11.multiply(((RealFieldElement) t8.multiply(t11)).subtract(((RealFieldElement) this.f6775q1.multiply(t7)).subtract(this.f6776q2.multiply(t6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(t8);
    }

    public FieldRotation(FieldVector3D<T> fieldVector3D, T t6, RotationConvention rotationConvention) {
        RealFieldElement norm = fieldVector3D.getNorm();
        if (norm.getReal() != 0.0d) {
            RealFieldElement realFieldElement = (RealFieldElement) t6.multiply(rotationConvention == RotationConvention.VECTOR_OPERATOR ? -0.5d : 0.5d);
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) realFieldElement.sin()).divide(norm);
            this.f6774q0 = (T) realFieldElement.cos();
            this.f6775q1 = (T) realFieldElement2.multiply(fieldVector3D.getX());
            this.f6776q2 = (T) realFieldElement2.multiply(fieldVector3D.getY());
            this.f6777q3 = (T) realFieldElement2.multiply(fieldVector3D.getZ());
            return;
        }
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public void applyInverseTo(T[] tArr, T[] tArr2) {
        T t6 = tArr[0];
        T t7 = tArr[1];
        T t8 = tArr[2];
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(t6)).add(this.f6776q2.multiply(t7))).add(this.f6777q3.multiply(t8));
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6774q0.negate();
        tArr2[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) t6.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6776q2.multiply(t8)).subtract(this.f6777q3.multiply(t7))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(t6);
        tArr2[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) t7.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6777q3.multiply(t6)).subtract(this.f6775q1.multiply(t8))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(t7);
        tArr2[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) t8.multiply(realFieldElement2)).subtract(((RealFieldElement) this.f6775q1.multiply(t7)).subtract(this.f6776q2.multiply(t6))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(t8);
    }

    public void applyTo(double[] dArr, T[] tArr) {
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(d)).add(this.f6776q2.multiply(d6))).add(this.f6777q3.multiply(d7));
        T t6 = this.f6774q0;
        tArr[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.multiply(((RealFieldElement) t6.multiply(d)).subtract(((RealFieldElement) this.f6776q2.multiply(d7)).subtract(this.f6777q3.multiply(d6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(d);
        T t7 = this.f6774q0;
        tArr[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(d6)).subtract(((RealFieldElement) this.f6777q3.multiply(d)).subtract(this.f6775q1.multiply(d7))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(d6);
        T t8 = this.f6774q0;
        tArr[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t8.multiply(((RealFieldElement) t8.multiply(d7)).subtract(((RealFieldElement) this.f6775q1.multiply(d6)).subtract(this.f6776q2.multiply(d))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(d7);
    }

    public void applyInverseTo(double[] dArr, T[] tArr) {
        double d = dArr[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.f6775q1.multiply(d)).add(this.f6776q2.multiply(d6))).add(this.f6777q3.multiply(d7));
        RealFieldElement realFieldElement2 = (RealFieldElement) this.f6774q0.negate();
        tArr[0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(d)).subtract(((RealFieldElement) this.f6776q2.multiply(d7)).subtract(this.f6777q3.multiply(d6))))).add(realFieldElement.multiply(this.f6775q1))).multiply(2)).subtract(d);
        tArr[1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(d6)).subtract(((RealFieldElement) this.f6777q3.multiply(d)).subtract(this.f6775q1.multiply(d7))))).add(realFieldElement.multiply(this.f6776q2))).multiply(2)).subtract(d6);
        tArr[2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.multiply(((RealFieldElement) realFieldElement2.multiply(d7)).subtract(((RealFieldElement) this.f6775q1.multiply(d6)).subtract(this.f6776q2.multiply(d))))).add(realFieldElement.multiply(this.f6777q3))).multiply(2)).subtract(d7);
    }

    public FieldRotation(T[][] tArr, double d) {
        if (tArr.length == 3 && tArr[0].length == 3 && tArr[1].length == 3 && tArr[2].length == 3) {
            RealFieldElement[][] realFieldElementArrOrthogonalizeMatrix = orthogonalizeMatrix(tArr, d);
            RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElementArrOrthogonalizeMatrix[0][0].multiply((RealFieldElement) ((RealFieldElement) realFieldElementArrOrthogonalizeMatrix[1][1].multiply(realFieldElementArrOrthogonalizeMatrix[2][2])).subtract(realFieldElementArrOrthogonalizeMatrix[2][1].multiply(realFieldElementArrOrthogonalizeMatrix[1][2])))).subtract(realFieldElementArrOrthogonalizeMatrix[1][0].multiply((RealFieldElement) ((RealFieldElement) realFieldElementArrOrthogonalizeMatrix[0][1].multiply(realFieldElementArrOrthogonalizeMatrix[2][2])).subtract(realFieldElementArrOrthogonalizeMatrix[2][1].multiply(realFieldElementArrOrthogonalizeMatrix[0][2]))))).add(realFieldElementArrOrthogonalizeMatrix[2][0].multiply((RealFieldElement) ((RealFieldElement) realFieldElementArrOrthogonalizeMatrix[0][1].multiply(realFieldElementArrOrthogonalizeMatrix[1][2])).subtract(realFieldElementArrOrthogonalizeMatrix[1][1].multiply(realFieldElementArrOrthogonalizeMatrix[0][2]))));
            if (realFieldElement.getReal() >= 0.0d) {
                RealFieldElement[] realFieldElementArrMat2quat = mat2quat(realFieldElementArrOrthogonalizeMatrix);
                this.f6774q0 = (T) realFieldElementArrMat2quat[0];
                this.f6775q1 = (T) realFieldElementArrMat2quat[1];
                this.f6776q2 = (T) realFieldElementArrMat2quat[2];
                this.f6777q3 = (T) realFieldElementArrMat2quat[3];
                return;
            }
            throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, realFieldElement);
        }
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, Integer.valueOf(tArr.length), Integer.valueOf(tArr[0].length));
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyTo(Rotation rotation, FieldVector3D<T> fieldVector3D) {
        RealFieldElement x6 = fieldVector3D.getX();
        RealFieldElement y6 = fieldVector3D.getY();
        RealFieldElement z6 = fieldVector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) x6.multiply(rotation.getQ1())).add(y6.multiply(rotation.getQ2()))).add(z6.multiply(rotation.getQ3()));
        return new FieldVector3D<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) x6.multiply(rotation.getQ0())).subtract(((RealFieldElement) z6.multiply(rotation.getQ2())).subtract(y6.multiply(rotation.getQ3())))).multiply(rotation.getQ0())).add(realFieldElement.multiply(rotation.getQ1()))).multiply(2)).subtract(x6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) y6.multiply(rotation.getQ0())).subtract(((RealFieldElement) x6.multiply(rotation.getQ3())).subtract(z6.multiply(rotation.getQ1())))).multiply(rotation.getQ0())).add(realFieldElement.multiply(rotation.getQ2()))).multiply(2)).subtract(y6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) z6.multiply(rotation.getQ0())).subtract(((RealFieldElement) y6.multiply(rotation.getQ1())).subtract(x6.multiply(rotation.getQ2())))).multiply(rotation.getQ0())).add(realFieldElement.multiply(rotation.getQ3()))).multiply(2)).subtract(z6));
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyInverseTo(Rotation rotation, FieldVector3D<T> fieldVector3D) {
        RealFieldElement x6 = fieldVector3D.getX();
        RealFieldElement y6 = fieldVector3D.getY();
        RealFieldElement z6 = fieldVector3D.getZ();
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) x6.multiply(rotation.getQ1())).add(y6.multiply(rotation.getQ2()))).add(z6.multiply(rotation.getQ3()));
        double d = -rotation.getQ0();
        return new FieldVector3D<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) x6.multiply(d)).subtract(((RealFieldElement) z6.multiply(rotation.getQ2())).subtract(y6.multiply(rotation.getQ3())))).multiply(d)).add(realFieldElement.multiply(rotation.getQ1()))).multiply(2)).subtract(x6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) y6.multiply(d)).subtract(((RealFieldElement) x6.multiply(rotation.getQ3())).subtract(z6.multiply(rotation.getQ1())))).multiply(d)).add(realFieldElement.multiply(rotation.getQ2()))).multiply(2)).subtract(y6), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) z6.multiply(d)).subtract(((RealFieldElement) y6.multiply(rotation.getQ1())).subtract(x6.multiply(rotation.getQ2())))).multiply(d)).add(realFieldElement.multiply(rotation.getQ3()))).multiply(2)).subtract(z6));
    }

    public FieldRotation<T> applyTo(FieldRotation<T> fieldRotation) {
        return compose(fieldRotation, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> applyTo(Rotation rotation) {
        return compose(rotation, RotationConvention.VECTOR_OPERATOR);
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyTo(Rotation rotation, FieldRotation<T> fieldRotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ0())).subtract(((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ1())).add(((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ2()))).add(((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ0())).add(((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ1()))).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ3())).subtract(((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ2()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ0())).add(((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ2()))).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ1())).subtract(((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ3()))), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ0())).add(((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ3()))).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ2())).subtract(((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ1()))), false);
    }

    public FieldRotation<T> applyInverseTo(FieldRotation<T> fieldRotation) {
        return composeInverse(fieldRotation, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> applyInverseTo(Rotation rotation) {
        return composeInverse(rotation, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2, FieldVector3D<T> fieldVector3D3, FieldVector3D<T> fieldVector3D4) {
        FieldVector3D<T> fieldVector3DNormalize = FieldVector3D.crossProduct(fieldVector3D, fieldVector3D2).normalize();
        FieldVector3D<T> fieldVector3DNormalize2 = FieldVector3D.crossProduct(fieldVector3DNormalize, fieldVector3D).normalize();
        FieldVector3D<T> fieldVector3DNormalize3 = fieldVector3D.normalize();
        FieldVector3D<T> fieldVector3DNormalize4 = FieldVector3D.crossProduct(fieldVector3D3, fieldVector3D4).normalize();
        FieldVector3D<T> fieldVector3DNormalize5 = FieldVector3D.crossProduct(fieldVector3DNormalize4, fieldVector3D3).normalize();
        FieldVector3D<T> fieldVector3DNormalize6 = fieldVector3D3.normalize();
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(fieldVector3DNormalize3.getX().getField(), 3, 3);
        realFieldElementArr[0][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getX().multiply(fieldVector3DNormalize6.getX())).add(fieldVector3DNormalize2.getX().multiply(fieldVector3DNormalize5.getX()))).add(fieldVector3DNormalize.getX().multiply(fieldVector3DNormalize4.getX()));
        realFieldElementArr[0][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getY().multiply(fieldVector3DNormalize6.getX())).add(fieldVector3DNormalize2.getY().multiply(fieldVector3DNormalize5.getX()))).add(fieldVector3DNormalize.getY().multiply(fieldVector3DNormalize4.getX()));
        realFieldElementArr[0][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getZ().multiply(fieldVector3DNormalize6.getX())).add(fieldVector3DNormalize2.getZ().multiply(fieldVector3DNormalize5.getX()))).add(fieldVector3DNormalize.getZ().multiply(fieldVector3DNormalize4.getX()));
        realFieldElementArr[1][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getX().multiply(fieldVector3DNormalize6.getY())).add(fieldVector3DNormalize2.getX().multiply(fieldVector3DNormalize5.getY()))).add(fieldVector3DNormalize.getX().multiply(fieldVector3DNormalize4.getY()));
        realFieldElementArr[1][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getY().multiply(fieldVector3DNormalize6.getY())).add(fieldVector3DNormalize2.getY().multiply(fieldVector3DNormalize5.getY()))).add(fieldVector3DNormalize.getY().multiply(fieldVector3DNormalize4.getY()));
        realFieldElementArr[1][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getZ().multiply(fieldVector3DNormalize6.getY())).add(fieldVector3DNormalize2.getZ().multiply(fieldVector3DNormalize5.getY()))).add(fieldVector3DNormalize.getZ().multiply(fieldVector3DNormalize4.getY()));
        realFieldElementArr[2][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getX().multiply(fieldVector3DNormalize6.getZ())).add(fieldVector3DNormalize2.getX().multiply(fieldVector3DNormalize5.getZ()))).add(fieldVector3DNormalize.getX().multiply(fieldVector3DNormalize4.getZ()));
        realFieldElementArr[2][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getY().multiply(fieldVector3DNormalize6.getZ())).add(fieldVector3DNormalize2.getY().multiply(fieldVector3DNormalize5.getZ()))).add(fieldVector3DNormalize.getY().multiply(fieldVector3DNormalize4.getZ()));
        realFieldElementArr[2][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) fieldVector3DNormalize3.getZ().multiply(fieldVector3DNormalize6.getZ())).add(fieldVector3DNormalize2.getZ().multiply(fieldVector3DNormalize5.getZ()))).add(fieldVector3DNormalize.getZ().multiply(fieldVector3DNormalize4.getZ()));
        RealFieldElement[] realFieldElementArrMat2quat = mat2quat(realFieldElementArr);
        this.f6774q0 = (T) realFieldElementArrMat2quat[0];
        this.f6775q1 = (T) realFieldElementArrMat2quat[1];
        this.f6776q2 = (T) realFieldElementArrMat2quat[2];
        this.f6777q3 = (T) realFieldElementArrMat2quat[3];
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyInverseTo(Rotation rotation, FieldRotation<T> fieldRotation) {
        return new FieldRotation<>((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ0())).add(((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ1())).add(((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ2()))).add(((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ3())))).negate(), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ1())).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ3())).subtract(((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ2())))).subtract(((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ0())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ2())).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ1())).subtract(((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ3())))).subtract(((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ0())), (RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((FieldRotation) fieldRotation).f6774q0.multiply(rotation.getQ3())).add(((RealFieldElement) ((FieldRotation) fieldRotation).f6775q1.multiply(rotation.getQ2())).subtract(((FieldRotation) fieldRotation).f6776q2.multiply(rotation.getQ1())))).subtract(((FieldRotation) fieldRotation).f6777q3.multiply(rotation.getQ0())), false);
    }

    public FieldRotation(FieldVector3D<T> fieldVector3D, FieldVector3D<T> fieldVector3D2) {
        RealFieldElement realFieldElement = (RealFieldElement) fieldVector3D.getNorm().multiply(fieldVector3D2.getNorm());
        if (realFieldElement.getReal() != 0.0d) {
            RealFieldElement realFieldElementDotProduct = FieldVector3D.dotProduct(fieldVector3D, fieldVector3D2);
            if (realFieldElementDotProduct.getReal() < realFieldElement.getReal() * (-0.999999999999998d)) {
                FieldVector3D<T> fieldVector3DOrthogonal = fieldVector3D.orthogonal();
                this.f6774q0 = (T) realFieldElement.getField().getZero();
                this.f6775q1 = (T) fieldVector3DOrthogonal.getX().negate();
                this.f6776q2 = (T) fieldVector3DOrthogonal.getY().negate();
                this.f6777q3 = (T) fieldVector3DOrthogonal.getZ().negate();
                return;
            }
            T t6 = (T) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElementDotProduct.divide(realFieldElement)).add(1.0d)).multiply(0.5d)).sqrt();
            this.f6774q0 = t6;
            RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.multiply(realFieldElement)).multiply(2.0d)).reciprocal();
            FieldVector3D fieldVector3DCrossProduct = FieldVector3D.crossProduct(fieldVector3D2, fieldVector3D);
            this.f6775q1 = (T) realFieldElement2.multiply(fieldVector3DCrossProduct.getX());
            this.f6776q2 = (T) realFieldElement2.multiply(fieldVector3DCrossProduct.getY());
            this.f6777q3 = (T) realFieldElement2.multiply(fieldVector3DCrossProduct.getZ());
            return;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    @Deprecated
    public FieldRotation(RotationOrder rotationOrder, T t6, T t7, T t8) {
        this(rotationOrder, RotationConvention.VECTOR_OPERATOR, t6, t7, t8);
    }

    public FieldRotation(RotationOrder rotationOrder, RotationConvention rotationConvention, T t6, T t7, T t8) {
        RealFieldElement realFieldElement = (RealFieldElement) t6.getField().getOne();
        FieldRotation<T> fieldRotationCompose = new FieldRotation(new FieldVector3D(realFieldElement, rotationOrder.getA1()), t6, rotationConvention).compose(new FieldRotation(new FieldVector3D(realFieldElement, rotationOrder.getA2()), t7, rotationConvention).compose(new FieldRotation<>(new FieldVector3D(realFieldElement, rotationOrder.getA3()), t8, rotationConvention), rotationConvention), rotationConvention);
        this.f6774q0 = fieldRotationCompose.f6774q0;
        this.f6775q1 = fieldRotationCompose.f6775q1;
        this.f6776q2 = fieldRotationCompose.f6776q2;
        this.f6777q3 = fieldRotationCompose.f6777q3;
    }
}
