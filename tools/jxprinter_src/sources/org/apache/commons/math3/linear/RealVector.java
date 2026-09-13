package org.apache.commons.math3.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Divide;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RealVector {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Entry {
        private int index;

        public Entry() {
            setIndex(0);
        }

        public int getIndex() {
            return this.index;
        }

        public double getValue() {
            return RealVector.this.getEntry(getIndex());
        }

        public void setIndex(int i5) {
            this.index = i5;
        }

        public void setValue(double d) {
            RealVector.this.setEntry(getIndex(), d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class SparseEntryIterator implements Iterator<Entry> {
        private Entry current;
        private final int dim;
        private Entry next;

        public SparseEntryIterator() {
            this.dim = RealVector.this.getDimension();
            this.current = RealVector.this.new Entry();
            Entry entry = RealVector.this.new Entry();
            this.next = entry;
            if (entry.getValue() == 0.0d) {
                advance(this.next);
            }
        }

        public void advance(Entry entry) {
            if (entry == null) {
                return;
            }
            do {
                entry.setIndex(entry.getIndex() + 1);
                if (entry.getIndex() >= this.dim) {
                    break;
                }
            } while (entry.getValue() == 0.0d);
            if (entry.getIndex() >= this.dim) {
                entry.setIndex(-1);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next.getIndex() >= 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Entry next() {
            int index = this.next.getIndex();
            if (index < 0) {
                throw new NoSuchElementException();
            }
            this.current.setIndex(index);
            advance(this.next);
            return this.current;
        }
    }

    public static RealVector unmodifiableRealVector(RealVector realVector) {
        return new RealVector() { // from class: org.apache.commons.math3.linear.RealVector.2

            /* JADX INFO: renamed from: org.apache.commons.math3.linear.RealVector$2$UnmodifiableEntry */
            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public class UnmodifiableEntry extends Entry {
                public UnmodifiableEntry() {
                    super();
                }

                @Override // org.apache.commons.math3.linear.RealVector.Entry
                public double getValue() {
                    return RealVector.this.getEntry(getIndex());
                }

                @Override // org.apache.commons.math3.linear.RealVector.Entry
                public void setValue(double d) {
                    throw new MathUnsupportedOperationException();
                }
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector add(RealVector realVector2) {
                return RealVector.this.add(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public void addToEntry(int i5, double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector append(RealVector realVector2) {
                return RealVector.this.append(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector combine(double d, double d6, RealVector realVector2) {
                return RealVector.this.combine(d, d6, realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector combineToSelf(double d, double d6, RealVector realVector2) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector copy() {
                return RealVector.this.copy();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double cosine(RealVector realVector2) {
                return RealVector.this.cosine(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double dotProduct(RealVector realVector2) {
                return RealVector.this.dotProduct(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector ebeDivide(RealVector realVector2) {
                return RealVector.this.ebeDivide(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector ebeMultiply(RealVector realVector2) {
                return RealVector.this.ebeMultiply(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public int getDimension() {
                return RealVector.this.getDimension();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getDistance(RealVector realVector2) {
                return RealVector.this.getDistance(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getEntry(int i5) {
                return RealVector.this.getEntry(i5);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getL1Distance(RealVector realVector2) {
                return RealVector.this.getL1Distance(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getL1Norm() {
                return RealVector.this.getL1Norm();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getLInfDistance(RealVector realVector2) {
                return RealVector.this.getLInfDistance(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getLInfNorm() {
                return RealVector.this.getLInfNorm();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double getNorm() {
                return RealVector.this.getNorm();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector getSubVector(int i5, int i6) {
                return RealVector.this.getSubVector(i5, i6);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public boolean isInfinite() {
                return RealVector.this.isInfinite();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public boolean isNaN() {
                return RealVector.this.isNaN();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public Iterator<Entry> iterator() {
                final Iterator<Entry> it = RealVector.this.iterator();
                return new Iterator<Entry>() { // from class: org.apache.commons.math3.linear.RealVector.2.1
                    private final UnmodifiableEntry e;

                    {
                        this.e = AnonymousClass2.this.new UnmodifiableEntry();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new MathUnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public Entry next() {
                        this.e.setIndex(((Entry) it.next()).getIndex());
                        return this.e;
                    }
                };
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector map(UnivariateFunction univariateFunction) {
                return RealVector.this.map(univariateFunction);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapAdd(double d) {
                return RealVector.this.mapAdd(d);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapAddToSelf(double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapDivide(double d) {
                return RealVector.this.mapDivide(d);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapDivideToSelf(double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapMultiply(double d) {
                return RealVector.this.mapMultiply(d);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapMultiplyToSelf(double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapSubtract(double d) {
                return RealVector.this.mapSubtract(d);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapSubtractToSelf(double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector mapToSelf(UnivariateFunction univariateFunction) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealMatrix outerProduct(RealVector realVector2) {
                return RealVector.this.outerProduct(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public void set(double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public void setEntry(int i5, double d) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public void setSubVector(int i5, RealVector realVector2) {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public Iterator<Entry> sparseIterator() {
                final Iterator<Entry> itSparseIterator = RealVector.this.sparseIterator();
                return new Iterator<Entry>() { // from class: org.apache.commons.math3.linear.RealVector.2.2
                    private final UnmodifiableEntry e;

                    {
                        this.e = AnonymousClass2.this.new UnmodifiableEntry();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return itSparseIterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new MathUnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public Entry next() {
                        this.e.setIndex(((Entry) itSparseIterator.next()).getIndex());
                        return this.e;
                    }
                };
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector subtract(RealVector realVector2) {
                return RealVector.this.subtract(realVector2);
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public double[] toArray() {
                return RealVector.this.toArray();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector unitVector() {
                return RealVector.this.unitVector();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public void unitize() {
                throw new MathUnsupportedOperationException();
            }

            @Override // org.apache.commons.math3.linear.RealVector
            public RealVector append(double d) {
                return RealVector.this.append(d);
            }
        };
    }

    public RealVector add(RealVector realVector) {
        checkVectorDimensions(realVector);
        RealVector realVectorCopy = realVector.copy();
        for (Entry entry : this) {
            int index = entry.getIndex();
            realVectorCopy.setEntry(index, realVectorCopy.getEntry(index) + entry.getValue());
        }
        return realVectorCopy;
    }

    public void addToEntry(int i5, double d) {
        setEntry(i5, getEntry(i5) + d);
    }

    public abstract RealVector append(double d);

    public abstract RealVector append(RealVector realVector);

    public void checkIndex(int i5) {
        if (i5 < 0 || i5 >= getDimension()) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(getDimension() - 1));
        }
    }

    public void checkIndices(int i5, int i6) {
        int dimension = getDimension();
        if (i5 < 0 || i5 >= dimension) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(dimension - 1));
        }
        if (i6 < 0 || i6 >= dimension) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i6), 0, Integer.valueOf(dimension - 1));
        }
        if (i6 < i5) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i6), Integer.valueOf(i5), false);
        }
    }

    public void checkVectorDimensions(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
    }

    public RealVector combine(double d, double d6, RealVector realVector) {
        return copy().combineToSelf(d, d6, realVector);
    }

    public RealVector combineToSelf(double d, double d6, RealVector realVector) {
        checkVectorDimensions(realVector);
        for (int i5 = 0; i5 < getDimension(); i5++) {
            double entry = getEntry(i5);
            setEntry(i5, (realVector.getEntry(i5) * d6) + (entry * d));
        }
        return this;
    }

    public abstract RealVector copy();

    public double cosine(RealVector realVector) {
        double norm = getNorm();
        double norm2 = realVector.getNorm();
        if (norm == 0.0d || norm2 == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        return dotProduct(realVector) / (norm * norm2);
    }

    public double dotProduct(RealVector realVector) {
        checkVectorDimensions(realVector);
        int dimension = getDimension();
        double entry = 0.0d;
        for (int i5 = 0; i5 < dimension; i5++) {
            entry += realVector.getEntry(i5) * getEntry(i5);
        }
        return entry;
    }

    public abstract RealVector ebeDivide(RealVector realVector);

    public abstract RealVector ebeMultiply(RealVector realVector);

    public boolean equals(Object obj) {
        throw new MathUnsupportedOperationException();
    }

    public abstract int getDimension();

    public double getDistance(RealVector realVector) {
        checkVectorDimensions(realVector);
        double d = 0.0d;
        for (Entry entry : this) {
            double value = entry.getValue() - realVector.getEntry(entry.getIndex());
            d += value * value;
        }
        return FastMath.sqrt(d);
    }

    public abstract double getEntry(int i5);

    public double getL1Distance(RealVector realVector) {
        checkVectorDimensions(realVector);
        double dAbs = 0.0d;
        for (Entry entry : this) {
            dAbs += FastMath.abs(entry.getValue() - realVector.getEntry(entry.getIndex()));
        }
        return dAbs;
    }

    public double getL1Norm() {
        Iterator<Entry> it = iterator();
        double dAbs = 0.0d;
        while (it.hasNext()) {
            dAbs += FastMath.abs(it.next().getValue());
        }
        return dAbs;
    }

    public double getLInfDistance(RealVector realVector) {
        checkVectorDimensions(realVector);
        double dMax = 0.0d;
        for (Entry entry : this) {
            dMax = FastMath.max(FastMath.abs(entry.getValue() - realVector.getEntry(entry.getIndex())), dMax);
        }
        return dMax;
    }

    public double getLInfNorm() {
        Iterator<Entry> it = iterator();
        double dMax = 0.0d;
        while (it.hasNext()) {
            dMax = FastMath.max(dMax, FastMath.abs(it.next().getValue()));
        }
        return dMax;
    }

    public int getMaxIndex() {
        int index = -1;
        double value = Double.NEGATIVE_INFINITY;
        for (Entry entry : this) {
            if (entry.getValue() >= value) {
                index = entry.getIndex();
                value = entry.getValue();
            }
        }
        return index;
    }

    public double getMaxValue() {
        int maxIndex = getMaxIndex();
        if (maxIndex < 0) {
            return Double.NaN;
        }
        return getEntry(maxIndex);
    }

    public int getMinIndex() {
        int index = -1;
        double value = Double.POSITIVE_INFINITY;
        for (Entry entry : this) {
            if (entry.getValue() <= value) {
                index = entry.getIndex();
                value = entry.getValue();
            }
        }
        return index;
    }

    public double getMinValue() {
        int minIndex = getMinIndex();
        if (minIndex < 0) {
            return Double.NaN;
        }
        return getEntry(minIndex);
    }

    public double getNorm() {
        Iterator<Entry> it = iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            double value = it.next().getValue();
            d += value * value;
        }
        return FastMath.sqrt(d);
    }

    public abstract RealVector getSubVector(int i5, int i6);

    public int hashCode() {
        throw new MathUnsupportedOperationException();
    }

    public abstract boolean isInfinite();

    public abstract boolean isNaN();

    public Iterator<Entry> iterator() {
        final int dimension = getDimension();
        return new Iterator<Entry>() { // from class: org.apache.commons.math3.linear.RealVector.1
            private Entry e;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f6810i = 0;

            {
                this.e = RealVector.this.new Entry();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6810i < dimension;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new MathUnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Entry next() {
                int i5 = this.f6810i;
                if (i5 >= dimension) {
                    throw new NoSuchElementException();
                }
                Entry entry = this.e;
                this.f6810i = i5 + 1;
                entry.setIndex(i5);
                return this.e;
            }
        };
    }

    public RealVector map(UnivariateFunction univariateFunction) {
        return copy().mapToSelf(univariateFunction);
    }

    public RealVector mapAdd(double d) {
        return copy().mapAddToSelf(d);
    }

    public RealVector mapAddToSelf(double d) {
        return d != 0.0d ? mapToSelf(FunctionUtils.fix2ndArgument(new Add(), d)) : this;
    }

    public RealVector mapDivide(double d) {
        return copy().mapDivideToSelf(d);
    }

    public RealVector mapDivideToSelf(double d) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Divide(), d));
    }

    public RealVector mapMultiply(double d) {
        return copy().mapMultiplyToSelf(d);
    }

    public RealVector mapMultiplyToSelf(double d) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Multiply(), d));
    }

    public RealVector mapSubtract(double d) {
        return copy().mapSubtractToSelf(d);
    }

    public RealVector mapSubtractToSelf(double d) {
        return mapAddToSelf(-d);
    }

    public RealVector mapToSelf(UnivariateFunction univariateFunction) {
        for (Entry entry : this) {
            entry.setValue(univariateFunction.value(entry.getValue()));
        }
        return this;
    }

    public RealMatrix outerProduct(RealVector realVector) {
        int dimension = getDimension();
        int dimension2 = realVector.getDimension();
        RealMatrix openMapRealMatrix = ((realVector instanceof SparseRealVector) || (this instanceof SparseRealVector)) ? new OpenMapRealMatrix(dimension, dimension2) : new Array2DRowRealMatrix(dimension, dimension2);
        for (int i5 = 0; i5 < dimension; i5++) {
            for (int i6 = 0; i6 < dimension2; i6++) {
                openMapRealMatrix.setEntry(i5, i6, realVector.getEntry(i6) * getEntry(i5));
            }
        }
        return openMapRealMatrix;
    }

    public RealVector projection(RealVector realVector) {
        if (realVector.dotProduct(realVector) != 0.0d) {
            return realVector.mapMultiply(dotProduct(realVector) / realVector.dotProduct(realVector));
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void set(double d) {
        Iterator<Entry> it = iterator();
        while (it.hasNext()) {
            it.next().setValue(d);
        }
    }

    public abstract void setEntry(int i5, double d);

    public abstract void setSubVector(int i5, RealVector realVector);

    public Iterator<Entry> sparseIterator() {
        return new SparseEntryIterator();
    }

    public RealVector subtract(RealVector realVector) {
        checkVectorDimensions(realVector);
        RealVector realVectorMapMultiply = realVector.mapMultiply(-1.0d);
        for (Entry entry : this) {
            int index = entry.getIndex();
            realVectorMapMultiply.setEntry(index, realVectorMapMultiply.getEntry(index) + entry.getValue());
        }
        return realVectorMapMultiply;
    }

    public double[] toArray() {
        int dimension = getDimension();
        double[] dArr = new double[dimension];
        for (int i5 = 0; i5 < dimension; i5++) {
            dArr[i5] = getEntry(i5);
        }
        return dArr;
    }

    public RealVector unitVector() {
        double norm = getNorm();
        if (norm != 0.0d) {
            return mapDivide(norm);
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void unitize() {
        if (getNorm() == 0.0d) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        mapDivideToSelf(getNorm());
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor realVectorPreservingVisitor) {
        int dimension = getDimension();
        realVectorPreservingVisitor.start(dimension, 0, dimension - 1);
        for (int i5 = 0; i5 < dimension; i5++) {
            realVectorPreservingVisitor.visit(i5, getEntry(i5));
        }
        return realVectorPreservingVisitor.end();
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor realVectorPreservingVisitor) {
        return walkInDefaultOrder(realVectorPreservingVisitor);
    }

    public void checkVectorDimensions(int i5) {
        int dimension = getDimension();
        if (dimension != i5) {
            throw new DimensionMismatchException(dimension, i5);
        }
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor realVectorPreservingVisitor, int i5, int i6) {
        return walkInDefaultOrder(realVectorPreservingVisitor, i5, i6);
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor realVectorChangingVisitor) {
        return walkInDefaultOrder(realVectorChangingVisitor);
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor realVectorChangingVisitor, int i5, int i6) {
        return walkInDefaultOrder(realVectorChangingVisitor, i5, i6);
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor realVectorPreservingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        realVectorPreservingVisitor.start(getDimension(), i5, i6);
        while (i5 <= i6) {
            realVectorPreservingVisitor.visit(i5, getEntry(i5));
            i5++;
        }
        return realVectorPreservingVisitor.end();
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor realVectorChangingVisitor) {
        int dimension = getDimension();
        realVectorChangingVisitor.start(dimension, 0, dimension - 1);
        for (int i5 = 0; i5 < dimension; i5++) {
            setEntry(i5, realVectorChangingVisitor.visit(i5, getEntry(i5)));
        }
        return realVectorChangingVisitor.end();
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor realVectorChangingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        realVectorChangingVisitor.start(getDimension(), i5, i6);
        while (i5 <= i6) {
            setEntry(i5, realVectorChangingVisitor.visit(i5, getEntry(i5)));
            i5++;
        }
        return realVectorChangingVisitor.end();
    }
}
