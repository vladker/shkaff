package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArrayRealVector extends RealVector implements Serializable {
    private static final RealVectorFormat DEFAULT_FORMAT = RealVectorFormat.getInstance();
    private static final long serialVersionUID = -1097961340710804027L;
    private double[] data;

    public ArrayRealVector() {
        this.data = new double[0];
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void addToEntry(int i5, double d) {
        try {
            double[] dArr = this.data;
            dArr[i5] = dArr[i5] + d;
        } catch (IndexOutOfBoundsException unused) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(this.data.length - 1));
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector append(RealVector realVector) {
        try {
            return new ArrayRealVector(this, (ArrayRealVector) realVector);
        } catch (ClassCastException unused) {
            return new ArrayRealVector(this, realVector);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void checkVectorDimensions(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double dotProduct(RealVector realVector) {
        if (!(realVector instanceof ArrayRealVector)) {
            return super.dotProduct(realVector);
        }
        double[] dArr = ((ArrayRealVector) realVector).data;
        checkVectorDimensions(dArr.length);
        double d = 0.0d;
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.data;
            if (i5 >= dArr2.length) {
                return d;
            }
            d += dArr2[i5] * dArr[i5];
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealVector)) {
            return false;
        }
        RealVector realVector = (RealVector) obj;
        if (this.data.length != realVector.getDimension()) {
            return false;
        }
        if (realVector.isNaN()) {
            return isNaN();
        }
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return true;
            }
            if (dArr[i5] != realVector.getEntry(i5)) {
                return false;
            }
            i5++;
        }
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getDistance(RealVector realVector) {
        int i5 = 0;
        double d = 0.0d;
        if (realVector instanceof ArrayRealVector) {
            double[] dArr = ((ArrayRealVector) realVector).data;
            checkVectorDimensions(dArr.length);
            while (true) {
                double[] dArr2 = this.data;
                if (i5 >= dArr2.length) {
                    return FastMath.sqrt(d);
                }
                double d6 = dArr2[i5] - dArr[i5];
                d += d6 * d6;
                i5++;
            }
        } else {
            checkVectorDimensions(realVector);
            while (true) {
                double[] dArr3 = this.data;
                if (i5 >= dArr3.length) {
                    return FastMath.sqrt(d);
                }
                double entry = dArr3[i5] - realVector.getEntry(i5);
                d += entry * entry;
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getEntry(int i5) {
        try {
            return this.data[i5];
        } catch (IndexOutOfBoundsException unused) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(getDimension() - 1));
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Distance(RealVector realVector) {
        int i5 = 0;
        double dAbs = 0.0d;
        if (realVector instanceof ArrayRealVector) {
            double[] dArr = ((ArrayRealVector) realVector).data;
            checkVectorDimensions(dArr.length);
            while (true) {
                double[] dArr2 = this.data;
                if (i5 >= dArr2.length) {
                    return dAbs;
                }
                dAbs += FastMath.abs(dArr2[i5] - dArr[i5]);
                i5++;
            }
        } else {
            checkVectorDimensions(realVector);
            while (true) {
                double[] dArr3 = this.data;
                if (i5 >= dArr3.length) {
                    return dAbs;
                }
                dAbs += FastMath.abs(dArr3[i5] - realVector.getEntry(i5));
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Norm() {
        double dAbs = 0.0d;
        for (double d : this.data) {
            dAbs += FastMath.abs(d);
        }
        return dAbs;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfDistance(RealVector realVector) {
        int i5 = 0;
        double dMax = 0.0d;
        if (realVector instanceof ArrayRealVector) {
            double[] dArr = ((ArrayRealVector) realVector).data;
            checkVectorDimensions(dArr.length);
            while (true) {
                double[] dArr2 = this.data;
                if (i5 >= dArr2.length) {
                    return dMax;
                }
                dMax = FastMath.max(dMax, FastMath.abs(dArr2[i5] - dArr[i5]));
                i5++;
            }
        } else {
            checkVectorDimensions(realVector);
            while (true) {
                double[] dArr3 = this.data;
                if (i5 >= dArr3.length) {
                    return dMax;
                }
                dMax = FastMath.max(dMax, FastMath.abs(dArr3[i5] - realVector.getEntry(i5)));
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfNorm() {
        double dMax = 0.0d;
        for (double d : this.data) {
            dMax = FastMath.max(dMax, FastMath.abs(d));
        }
        return dMax;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getNorm() {
        double d = 0.0d;
        for (double d6 : this.data) {
            d += d6 * d6;
        }
        return FastMath.sqrt(d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector getSubVector(int i5, int i6) {
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(i6));
        }
        ArrayRealVector arrayRealVector = new ArrayRealVector(i6);
        try {
            System.arraycopy(this.data, i5, arrayRealVector.data, 0, i6);
            return arrayRealVector;
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
            checkIndex((i5 + i6) - 1);
            return arrayRealVector;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int hashCode() {
        if (isNaN()) {
            return 9;
        }
        return MathUtils.hash(this.data);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isInfinite() {
        if (isNaN()) {
            return false;
        }
        for (double d : this.data) {
            if (Double.isInfinite(d)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isNaN() {
        for (double d : this.data) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapAddToSelf(double d) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return this;
            }
            dArr[i5] = dArr[i5] + d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapDivideToSelf(double d) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return this;
            }
            dArr[i5] = dArr[i5] / d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapMultiplyToSelf(double d) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return this;
            }
            dArr[i5] = dArr[i5] * d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapSubtractToSelf(double d) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return this;
            }
            dArr[i5] = dArr[i5] - d;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealMatrix outerProduct(RealVector realVector) {
        if (realVector instanceof ArrayRealVector) {
            double[] dArr = ((ArrayRealVector) realVector).data;
            int length = this.data.length;
            int length2 = dArr.length;
            RealMatrix realMatrixCreateRealMatrix = MatrixUtils.createRealMatrix(length, length2);
            for (int i5 = 0; i5 < length; i5++) {
                for (int i6 = 0; i6 < length2; i6++) {
                    realMatrixCreateRealMatrix.setEntry(i5, i6, this.data[i5] * dArr[i6]);
                }
            }
            return realMatrixCreateRealMatrix;
        }
        int length3 = this.data.length;
        int dimension = realVector.getDimension();
        RealMatrix realMatrixCreateRealMatrix2 = MatrixUtils.createRealMatrix(length3, dimension);
        for (int i7 = 0; i7 < length3; i7++) {
            for (int i8 = 0; i8 < dimension; i8++) {
                realMatrixCreateRealMatrix2.setEntry(i7, i8, realVector.getEntry(i8) * this.data[i7]);
            }
        }
        return realMatrixCreateRealMatrix2;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void set(double d) {
        Arrays.fill(this.data, d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setEntry(int i5, double d) {
        try {
            this.data[i5] = d;
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setSubVector(int i5, RealVector realVector) {
        if (realVector instanceof ArrayRealVector) {
            setSubVector(i5, ((ArrayRealVector) realVector).data);
            return;
        }
        for (int i6 = i5; i6 < realVector.getDimension() + i5; i6++) {
            try {
                this.data[i6] = realVector.getEntry(i6 - i5);
            } catch (IndexOutOfBoundsException unused) {
                checkIndex(i5);
                checkIndex((realVector.getDimension() + i5) - 1);
                return;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double[] toArray() {
        return (double[]) this.data.clone();
    }

    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorPreservingVisitor realVectorPreservingVisitor) {
        double[] dArr = this.data;
        int i5 = 0;
        realVectorPreservingVisitor.start(dArr.length, 0, dArr.length - 1);
        while (true) {
            double[] dArr2 = this.data;
            if (i5 >= dArr2.length) {
                return realVectorPreservingVisitor.end();
            }
            realVectorPreservingVisitor.visit(i5, dArr2[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorPreservingVisitor realVectorPreservingVisitor) {
        return walkInDefaultOrder(realVectorPreservingVisitor);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector add(RealVector realVector) {
        if (realVector instanceof ArrayRealVector) {
            double[] dArr = ((ArrayRealVector) realVector).data;
            int length = dArr.length;
            checkVectorDimensions(length);
            ArrayRealVector arrayRealVector = new ArrayRealVector(length);
            double[] dArr2 = arrayRealVector.data;
            for (int i5 = 0; i5 < length; i5++) {
                dArr2[i5] = this.data[i5] + dArr[i5];
            }
            return arrayRealVector;
        }
        checkVectorDimensions(realVector);
        double[] dArr3 = (double[]) this.data.clone();
        for (RealVector.Entry entry : realVector) {
            int index = entry.getIndex();
            dArr3[index] = entry.getValue() + dArr3[index];
        }
        return new ArrayRealVector(dArr3, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void checkVectorDimensions(int i5) {
        if (this.data.length != i5) {
            throw new DimensionMismatchException(this.data.length, i5);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector combine(double d, double d6, RealVector realVector) {
        return copy().combineToSelf(d, d6, realVector);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector combineToSelf(double d, double d6, RealVector realVector) {
        int i5 = 0;
        if (!(realVector instanceof ArrayRealVector)) {
            checkVectorDimensions(realVector);
            while (true) {
                double[] dArr = this.data;
                if (i5 >= dArr.length) {
                    break;
                }
                dArr[i5] = (realVector.getEntry(i5) * d6) + (dArr[i5] * d);
                i5++;
            }
        } else {
            double[] dArr2 = ((ArrayRealVector) realVector).data;
            checkVectorDimensions(dArr2.length);
            while (true) {
                double[] dArr3 = this.data;
                if (i5 >= dArr3.length) {
                    break;
                }
                dArr3[i5] = (dArr2[i5] * d6) + (dArr3[i5] * d);
                i5++;
            }
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector copy() {
        return new ArrayRealVector(this, true);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector ebeDivide(RealVector realVector) {
        if (!(realVector instanceof ArrayRealVector)) {
            checkVectorDimensions(realVector);
            double[] dArr = (double[]) this.data.clone();
            for (int i5 = 0; i5 < this.data.length; i5++) {
                dArr[i5] = dArr[i5] / realVector.getEntry(i5);
            }
            return new ArrayRealVector(dArr, false);
        }
        double[] dArr2 = ((ArrayRealVector) realVector).data;
        int length = dArr2.length;
        checkVectorDimensions(length);
        ArrayRealVector arrayRealVector = new ArrayRealVector(length);
        double[] dArr3 = arrayRealVector.data;
        for (int i6 = 0; i6 < length; i6++) {
            dArr3[i6] = this.data[i6] / dArr2[i6];
        }
        return arrayRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector ebeMultiply(RealVector realVector) {
        if (!(realVector instanceof ArrayRealVector)) {
            checkVectorDimensions(realVector);
            double[] dArr = (double[]) this.data.clone();
            for (int i5 = 0; i5 < this.data.length; i5++) {
                dArr[i5] = realVector.getEntry(i5) * dArr[i5];
            }
            return new ArrayRealVector(dArr, false);
        }
        double[] dArr2 = ((ArrayRealVector) realVector).data;
        int length = dArr2.length;
        checkVectorDimensions(length);
        ArrayRealVector arrayRealVector = new ArrayRealVector(length);
        double[] dArr3 = arrayRealVector.data;
        for (int i6 = 0; i6 < length; i6++) {
            dArr3[i6] = this.data[i6] * dArr2[i6];
        }
        return arrayRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector map(UnivariateFunction univariateFunction) {
        return copy().mapToSelf(univariateFunction);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector mapToSelf(UnivariateFunction univariateFunction) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return this;
            }
            dArr[i5] = univariateFunction.value(dArr[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector subtract(RealVector realVector) {
        if (!(realVector instanceof ArrayRealVector)) {
            checkVectorDimensions(realVector);
            double[] dArr = (double[]) this.data.clone();
            for (RealVector.Entry entry : realVector) {
                int index = entry.getIndex();
                dArr[index] = dArr[index] - entry.getValue();
            }
            return new ArrayRealVector(dArr, false);
        }
        double[] dArr2 = ((ArrayRealVector) realVector).data;
        int length = dArr2.length;
        checkVectorDimensions(length);
        ArrayRealVector arrayRealVector = new ArrayRealVector(length);
        double[] dArr3 = arrayRealVector.data;
        for (int i5 = 0; i5 < length; i5++) {
            dArr3[i5] = this.data[i5] - dArr2[i5];
        }
        return arrayRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorPreservingVisitor realVectorPreservingVisitor, int i5, int i6) {
        return walkInDefaultOrder(realVectorPreservingVisitor, i5, i6);
    }

    public ArrayRealVector(int i5) {
        this.data = new double[i5];
    }

    public ArrayRealVector append(ArrayRealVector arrayRealVector) {
        return new ArrayRealVector(this, arrayRealVector);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorChangingVisitor realVectorChangingVisitor) {
        return walkInDefaultOrder(realVectorChangingVisitor);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector append(double d) {
        double[] dArr = this.data;
        double[] dArr2 = new double[dArr.length + 1];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        dArr2[this.data.length] = d;
        return new ArrayRealVector(dArr2, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorChangingVisitor realVectorChangingVisitor, int i5, int i6) {
        return walkInDefaultOrder(realVectorChangingVisitor, i5, i6);
    }

    public ArrayRealVector(int i5, double d) {
        double[] dArr = new double[i5];
        this.data = dArr;
        Arrays.fill(dArr, d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorPreservingVisitor realVectorPreservingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        realVectorPreservingVisitor.start(this.data.length, i5, i6);
        while (i5 <= i6) {
            realVectorPreservingVisitor.visit(i5, this.data[i5]);
            i5++;
        }
        return realVectorPreservingVisitor.end();
    }

    public void setSubVector(int i5, double[] dArr) {
        try {
            System.arraycopy(dArr, 0, this.data, i5, dArr.length);
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
            checkIndex((i5 + dArr.length) - 1);
        }
    }

    public ArrayRealVector(double[] dArr) {
        this.data = (double[]) dArr.clone();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorChangingVisitor realVectorChangingVisitor) {
        double[] dArr = this.data;
        int i5 = 0;
        realVectorChangingVisitor.start(dArr.length, 0, dArr.length - 1);
        while (true) {
            double[] dArr2 = this.data;
            if (i5 < dArr2.length) {
                dArr2[i5] = realVectorChangingVisitor.visit(i5, dArr2[i5]);
                i5++;
            } else {
                return realVectorChangingVisitor.end();
            }
        }
    }

    public ArrayRealVector(double[] dArr, boolean z6) {
        if (dArr != null) {
            this.data = z6 ? (double[]) dArr.clone() : dArr;
            return;
        }
        throw new NullArgumentException();
    }

    public ArrayRealVector(double[] dArr, int i5, int i6) {
        if (dArr != null) {
            int i7 = i5 + i6;
            if (dArr.length >= i7) {
                double[] dArr2 = new double[i6];
                this.data = dArr2;
                System.arraycopy(dArr, i5, dArr2, 0, i6);
                return;
            }
            throw new NumberIsTooLargeException(Integer.valueOf(i7), Integer.valueOf(dArr.length), true);
        }
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorChangingVisitor realVectorChangingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        realVectorChangingVisitor.start(this.data.length, i5, i6);
        while (i5 <= i6) {
            double[] dArr = this.data;
            dArr[i5] = realVectorChangingVisitor.visit(i5, dArr[i5]);
            i5++;
        }
        return realVectorChangingVisitor.end();
    }

    public ArrayRealVector(Double[] dArr) {
        this.data = new double[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            this.data[i5] = dArr[i5].doubleValue();
        }
    }

    public ArrayRealVector(Double[] dArr, int i5, int i6) {
        if (dArr != null) {
            int i7 = i5 + i6;
            if (dArr.length >= i7) {
                this.data = new double[i6];
                for (int i8 = i5; i8 < i7; i8++) {
                    this.data[i8 - i5] = dArr[i8].doubleValue();
                }
                return;
            }
            throw new NumberIsTooLargeException(Integer.valueOf(i7), Integer.valueOf(dArr.length), true);
        }
        throw new NullArgumentException();
    }

    public ArrayRealVector(RealVector realVector) {
        if (realVector != null) {
            this.data = new double[realVector.getDimension()];
            int i5 = 0;
            while (true) {
                double[] dArr = this.data;
                if (i5 >= dArr.length) {
                    return;
                }
                dArr[i5] = realVector.getEntry(i5);
                i5++;
            }
        } else {
            throw new NullArgumentException();
        }
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector) {
        this(arrayRealVector, true);
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector, boolean z6) {
        double[] dArr = arrayRealVector.data;
        this.data = z6 ? (double[]) dArr.clone() : dArr;
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector, ArrayRealVector arrayRealVector2) {
        double[] dArr = new double[arrayRealVector.data.length + arrayRealVector2.data.length];
        this.data = dArr;
        double[] dArr2 = arrayRealVector.data;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        double[] dArr3 = arrayRealVector2.data;
        System.arraycopy(dArr3, 0, this.data, arrayRealVector.data.length, dArr3.length);
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector, RealVector realVector) {
        int length = arrayRealVector.data.length;
        int dimension = realVector.getDimension();
        double[] dArr = new double[length + dimension];
        this.data = dArr;
        System.arraycopy(arrayRealVector.data, 0, dArr, 0, length);
        for (int i5 = 0; i5 < dimension; i5++) {
            this.data[length + i5] = realVector.getEntry(i5);
        }
    }

    public ArrayRealVector(RealVector realVector, ArrayRealVector arrayRealVector) {
        int dimension = realVector.getDimension();
        int length = arrayRealVector.data.length;
        this.data = new double[dimension + length];
        for (int i5 = 0; i5 < dimension; i5++) {
            this.data[i5] = realVector.getEntry(i5);
        }
        System.arraycopy(arrayRealVector.data, 0, this.data, dimension, length);
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector, double[] dArr) {
        int dimension = arrayRealVector.getDimension();
        int length = dArr.length;
        double[] dArr2 = new double[dimension + length];
        this.data = dArr2;
        System.arraycopy(arrayRealVector.data, 0, dArr2, 0, dimension);
        System.arraycopy(dArr, 0, this.data, dimension, length);
    }

    public ArrayRealVector(double[] dArr, ArrayRealVector arrayRealVector) {
        int length = dArr.length;
        int dimension = arrayRealVector.getDimension();
        double[] dArr2 = new double[length + dimension];
        this.data = dArr2;
        System.arraycopy(dArr, 0, dArr2, 0, length);
        System.arraycopy(arrayRealVector.data, 0, this.data, length, dimension);
    }

    public ArrayRealVector(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] dArr3 = new double[length + length2];
        this.data = dArr3;
        System.arraycopy(dArr, 0, dArr3, 0, length);
        System.arraycopy(dArr2, 0, this.data, length, length2);
    }
}
