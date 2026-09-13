package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OpenMapRealVector extends SparseRealVector implements Serializable {
    public static final double DEFAULT_ZERO_TOLERANCE = 1.0E-12d;
    private static final long serialVersionUID = 8772222695580707260L;
    private final OpenIntToDoubleHashMap entries;
    private final double epsilon;
    private final int virtualSize;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class OpenMapEntry extends RealVector.Entry {
        private final OpenIntToDoubleHashMap.Iterator iter;

        public OpenMapEntry(OpenIntToDoubleHashMap.Iterator iterator) {
            super();
            this.iter = iterator;
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public int getIndex() {
            return this.iter.key();
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public double getValue() {
            return this.iter.value();
        }

        @Override // org.apache.commons.math3.linear.RealVector.Entry
        public void setValue(double d) {
            OpenMapRealVector.this.entries.put(this.iter.key(), d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class OpenMapSparseIterator implements Iterator<RealVector.Entry> {
        private final RealVector.Entry current;
        private final OpenIntToDoubleHashMap.Iterator iter;

        public OpenMapSparseIterator() {
            OpenIntToDoubleHashMap.Iterator it = OpenMapRealVector.this.entries.iterator();
            this.iter = it;
            this.current = OpenMapRealVector.this.new OpenMapEntry(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override // java.util.Iterator
        public RealVector.Entry next() {
            this.iter.advance();
            return this.current;
        }
    }

    public OpenMapRealVector() {
        this(0, 1.0E-12d);
    }

    private OpenIntToDoubleHashMap getEntries() {
        return this.entries;
    }

    private double getLInfDistance(OpenMapRealVector openMapRealVector) {
        checkVectorDimensions(openMapRealVector.getDimension());
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        double dValue = 0.0d;
        while (it.hasNext()) {
            it.advance();
            double dAbs = FastMath.abs(it.value() - openMapRealVector.getEntry(it.key()));
            if (dAbs > dValue) {
                dValue = dAbs;
            }
        }
        OpenIntToDoubleHashMap.Iterator it2 = openMapRealVector.getEntries().iterator();
        while (it2.hasNext()) {
            it2.advance();
            if (!this.entries.containsKey(it2.key()) && it2.value() > dValue) {
                dValue = it2.value();
            }
        }
        return dValue;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector add(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        return realVector instanceof OpenMapRealVector ? add((OpenMapRealVector) realVector) : super.add(realVector);
    }

    @Deprecated
    public double dotProduct(OpenMapRealVector openMapRealVector) {
        return dotProduct((RealVector) openMapRealVector);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenMapRealVector)) {
            return false;
        }
        OpenMapRealVector openMapRealVector = (OpenMapRealVector) obj;
        if (this.virtualSize != openMapRealVector.virtualSize || Double.doubleToLongBits(this.epsilon) != Double.doubleToLongBits(openMapRealVector.epsilon)) {
            return false;
        }
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            if (Double.doubleToLongBits(openMapRealVector.getEntry(it.key())) != Double.doubleToLongBits(it.value())) {
                return false;
            }
        }
        OpenIntToDoubleHashMap.Iterator it2 = openMapRealVector.getEntries().iterator();
        while (it2.hasNext()) {
            it2.advance();
            if (Double.doubleToLongBits(it2.value()) != Double.doubleToLongBits(getEntry(it2.key()))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int getDimension() {
        return this.virtualSize;
    }

    public double getDistance(OpenMapRealVector openMapRealVector) {
        checkVectorDimensions(openMapRealVector.getDimension());
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            it.advance();
            double dValue = it.value() - openMapRealVector.getEntry(it.key());
            d += dValue * dValue;
        }
        OpenIntToDoubleHashMap.Iterator it2 = openMapRealVector.getEntries().iterator();
        while (it2.hasNext()) {
            it2.advance();
            if (!this.entries.containsKey(it2.key())) {
                double dValue2 = it2.value();
                d = (dValue2 * dValue2) + d;
            }
        }
        return FastMath.sqrt(d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getEntry(int i5) {
        checkIndex(i5);
        return this.entries.get(i5);
    }

    public double getL1Distance(OpenMapRealVector openMapRealVector) {
        checkVectorDimensions(openMapRealVector.getDimension());
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        double dAbs = 0.0d;
        while (it.hasNext()) {
            it.advance();
            dAbs += FastMath.abs(it.value() - openMapRealVector.getEntry(it.key()));
        }
        OpenIntToDoubleHashMap.Iterator it2 = openMapRealVector.getEntries().iterator();
        while (it2.hasNext()) {
            it2.advance();
            if (!this.entries.containsKey(it2.key())) {
                dAbs = FastMath.abs(FastMath.abs(it2.value())) + dAbs;
            }
        }
        return dAbs;
    }

    public double getSparsity() {
        return ((double) this.entries.size()) / ((double) getDimension());
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.epsilon);
        int i5 = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + this.virtualSize;
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            long jDoubleToLongBits2 = Double.doubleToLongBits(it.value());
            i5 = (i5 * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >> 32)));
        }
        return i5;
    }

    public boolean isDefaultValue(double d) {
        return FastMath.abs(d) < this.epsilon;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isInfinite() {
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            it.advance();
            double dValue = it.value();
            if (Double.isNaN(dValue)) {
                return false;
            }
            if (Double.isInfinite(dValue)) {
                z6 = true;
            }
        }
        return z6;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isNaN() {
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            if (Double.isNaN(it.value())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void set(double d) {
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            setEntry(i5, d);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setEntry(int i5, double d) {
        checkIndex(i5);
        if (!isDefaultValue(d)) {
            this.entries.put(i5, d);
        } else if (this.entries.containsKey(i5)) {
            this.entries.remove(i5);
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setSubVector(int i5, RealVector realVector) {
        checkIndex(i5);
        checkIndex((realVector.getDimension() + i5) - 1);
        for (int i6 = 0; i6 < realVector.getDimension(); i6++) {
            setEntry(i6 + i5, realVector.getEntry(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public Iterator<RealVector.Entry> sparseIterator() {
        return new OpenMapSparseIterator();
    }

    public OpenMapRealVector subtract(OpenMapRealVector openMapRealVector) {
        checkVectorDimensions(openMapRealVector.getDimension());
        OpenMapRealVector openMapRealVectorCopy = copy();
        OpenIntToDoubleHashMap.Iterator it = openMapRealVector.getEntries().iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            if (this.entries.containsKey(iKey)) {
                openMapRealVectorCopy.setEntry(iKey, this.entries.get(iKey) - it.value());
            } else {
                openMapRealVectorCopy.setEntry(iKey, -it.value());
            }
        }
        return openMapRealVectorCopy;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double[] toArray() {
        double[] dArr = new double[this.virtualSize];
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            dArr[it.key()] = it.value();
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void unitize() {
        double norm = getNorm();
        if (isDefaultValue(norm)) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
        }
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            this.entries.put(it.key(), it.value() / norm);
        }
    }

    public OpenMapRealVector(int i5) {
        this(i5, 1.0E-12d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector copy() {
        return new OpenMapRealVector(this);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector ebeDivide(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        OpenMapRealVector openMapRealVector = new OpenMapRealVector(this);
        int dimension = getDimension();
        for (int i5 = 0; i5 < dimension; i5++) {
            openMapRealVector.setEntry(i5, getEntry(i5) / realVector.getEntry(i5));
        }
        return openMapRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector ebeMultiply(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        OpenMapRealVector openMapRealVector = new OpenMapRealVector(this);
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            openMapRealVector.setEntry(it.key(), realVector.getEntry(it.key()) * it.value());
        }
        return openMapRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector getSubVector(int i5, int i6) {
        checkIndex(i5);
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(i6));
        }
        int i7 = i5 + i6;
        checkIndex(i7 - 1);
        OpenMapRealVector openMapRealVector = new OpenMapRealVector(i6);
        OpenIntToDoubleHashMap.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            if (iKey >= i5 && iKey < i7) {
                openMapRealVector.setEntry(iKey - i5, it.value());
            }
        }
        return openMapRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector mapAdd(double d) {
        return copy().mapAddToSelf(d);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector mapAddToSelf(double d) {
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            setEntry(i5, getEntry(i5) + d);
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector unitVector() {
        OpenMapRealVector openMapRealVectorCopy = copy();
        openMapRealVectorCopy.unitize();
        return openMapRealVectorCopy;
    }

    public OpenMapRealVector(int i5, double d) {
        this.virtualSize = i5;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = d;
    }

    public OpenMapRealVector append(OpenMapRealVector openMapRealVector) {
        OpenMapRealVector openMapRealVector2 = new OpenMapRealVector(this, openMapRealVector.getDimension());
        OpenIntToDoubleHashMap.Iterator it = openMapRealVector.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            openMapRealVector2.setEntry(it.key() + this.virtualSize, it.value());
        }
        return openMapRealVector2;
    }

    public OpenMapRealVector add(OpenMapRealVector openMapRealVector) {
        checkVectorDimensions(openMapRealVector.getDimension());
        boolean z6 = this.entries.size() > openMapRealVector.entries.size();
        OpenMapRealVector openMapRealVectorCopy = z6 ? copy() : openMapRealVector.copy();
        OpenIntToDoubleHashMap.Iterator it = (z6 ? openMapRealVector.entries : this.entries).iterator();
        OpenIntToDoubleHashMap openIntToDoubleHashMap = z6 ? this.entries : openMapRealVector.entries;
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            if (openIntToDoubleHashMap.containsKey(iKey)) {
                openMapRealVectorCopy.setEntry(iKey, it.value() + openIntToDoubleHashMap.get(iKey));
            } else {
                openMapRealVectorCopy.setEntry(iKey, it.value());
            }
        }
        return openMapRealVectorCopy;
    }

    public OpenMapRealVector(OpenMapRealVector openMapRealVector, int i5) {
        this.virtualSize = openMapRealVector.getDimension() + i5;
        this.entries = new OpenIntToDoubleHashMap(openMapRealVector.entries);
        this.epsilon = openMapRealVector.epsilon;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector append(RealVector realVector) {
        if (realVector instanceof OpenMapRealVector) {
            return append((OpenMapRealVector) realVector);
        }
        OpenMapRealVector openMapRealVector = new OpenMapRealVector(this, realVector.getDimension());
        for (int i5 = 0; i5 < realVector.getDimension(); i5++) {
            openMapRealVector.setEntry(this.virtualSize + i5, realVector.getEntry(i5));
        }
        return openMapRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector subtract(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        if (realVector instanceof OpenMapRealVector) {
            return subtract((OpenMapRealVector) realVector);
        }
        return super.subtract(realVector);
    }

    public OpenMapRealVector(int i5, int i6) {
        this(i5, i6, 1.0E-12d);
    }

    public OpenMapRealVector(int i5, int i6, double d) {
        this.virtualSize = i5;
        this.entries = new OpenIntToDoubleHashMap(i6, 0.0d);
        this.epsilon = d;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfDistance(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        if (realVector instanceof OpenMapRealVector) {
            return getLInfDistance((OpenMapRealVector) realVector);
        }
        return super.getLInfDistance(realVector);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public OpenMapRealVector append(double d) {
        OpenMapRealVector openMapRealVector = new OpenMapRealVector(this, 1);
        openMapRealVector.setEntry(this.virtualSize, d);
        return openMapRealVector;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Distance(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        if (realVector instanceof OpenMapRealVector) {
            return getL1Distance((OpenMapRealVector) realVector);
        }
        return super.getL1Distance(realVector);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getDistance(RealVector realVector) {
        checkVectorDimensions(realVector.getDimension());
        if (realVector instanceof OpenMapRealVector) {
            return getDistance((OpenMapRealVector) realVector);
        }
        return super.getDistance(realVector);
    }

    public OpenMapRealVector(double[] dArr) {
        this(dArr, 1.0E-12d);
    }

    public OpenMapRealVector(double[] dArr, double d) {
        this.virtualSize = dArr.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d6 = dArr[i5];
            if (!isDefaultValue(d6)) {
                this.entries.put(i5, d6);
            }
        }
    }

    public OpenMapRealVector(Double[] dArr) {
        this(dArr, 1.0E-12d);
    }

    public OpenMapRealVector(Double[] dArr, double d) {
        this.virtualSize = dArr.length;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = d;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double dDoubleValue = dArr[i5].doubleValue();
            if (!isDefaultValue(dDoubleValue)) {
                this.entries.put(i5, dDoubleValue);
            }
        }
    }

    public OpenMapRealVector(OpenMapRealVector openMapRealVector) {
        this.virtualSize = openMapRealVector.getDimension();
        this.entries = new OpenIntToDoubleHashMap(openMapRealVector.getEntries());
        this.epsilon = openMapRealVector.epsilon;
    }

    public OpenMapRealVector(RealVector realVector) {
        this.virtualSize = realVector.getDimension();
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        this.epsilon = 1.0E-12d;
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            double entry = realVector.getEntry(i5);
            if (!isDefaultValue(entry)) {
                this.entries.put(i5, entry);
            }
        }
    }
}
