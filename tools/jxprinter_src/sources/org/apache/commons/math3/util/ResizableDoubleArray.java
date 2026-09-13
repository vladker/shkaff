package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ResizableDoubleArray implements DoubleArray, Serializable {

    @Deprecated
    public static final int ADDITIVE_MODE = 1;
    private static final double DEFAULT_CONTRACTION_DELTA = 0.5d;
    private static final double DEFAULT_EXPANSION_FACTOR = 2.0d;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @Deprecated
    public static final int MULTIPLICATIVE_MODE = 0;
    private static final long serialVersionUID = -3485529955529426875L;
    private double contractionCriterion;
    private double expansionFactor;
    private ExpansionMode expansionMode;
    private double[] internalArray;
    private int numElements;
    private int startIndex;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.ResizableDoubleArray$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode;

        static {
            int[] iArr = new int[ExpansionMode.values().length];
            $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode = iArr;
            try {
                iArr[ExpansionMode.MULTIPLICATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode[ExpansionMode.ADDITIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum ExpansionMode {
        MULTIPLICATIVE,
        ADDITIVE
    }

    public ResizableDoubleArray() {
        this(16);
    }

    public static void copy(ResizableDoubleArray resizableDoubleArray, ResizableDoubleArray resizableDoubleArray2) {
        MathUtils.checkNotNull(resizableDoubleArray);
        MathUtils.checkNotNull(resizableDoubleArray2);
        synchronized (resizableDoubleArray) {
            synchronized (resizableDoubleArray2) {
                resizableDoubleArray2.contractionCriterion = resizableDoubleArray.contractionCriterion;
                resizableDoubleArray2.expansionFactor = resizableDoubleArray.expansionFactor;
                resizableDoubleArray2.expansionMode = resizableDoubleArray.expansionMode;
                double[] dArr = new double[resizableDoubleArray.internalArray.length];
                resizableDoubleArray2.internalArray = dArr;
                System.arraycopy(resizableDoubleArray.internalArray, 0, dArr, 0, dArr.length);
                resizableDoubleArray2.numElements = resizableDoubleArray.numElements;
                resizableDoubleArray2.startIndex = resizableDoubleArray.startIndex;
            }
        }
    }

    private synchronized void discardExtremeElements(int i5, boolean z6) {
        try {
            int i6 = this.numElements;
            if (i5 > i6) {
                throw new MathIllegalArgumentException(LocalizedFormats.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY, Integer.valueOf(i5), Integer.valueOf(this.numElements));
            }
            if (i5 < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS, Integer.valueOf(i5));
            }
            this.numElements = i6 - i5;
            if (z6) {
                this.startIndex += i5;
            }
            if (shouldContract()) {
                contract();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void expandTo(int i5) {
        double[] dArr = new double[i5];
        double[] dArr2 = this.internalArray;
        System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        this.internalArray = dArr;
    }

    private synchronized boolean shouldContract() {
        if (this.expansionMode == ExpansionMode.MULTIPLICATIVE) {
            return ((double) (((float) this.internalArray.length) / ((float) this.numElements))) > this.contractionCriterion;
        }
        return ((double) (this.internalArray.length - this.numElements)) > this.contractionCriterion;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void addElement(double d) {
        try {
            if (this.internalArray.length <= this.startIndex + this.numElements) {
                expand();
            }
            double[] dArr = this.internalArray;
            int i5 = this.startIndex;
            int i6 = this.numElements;
            this.numElements = i6 + 1;
            dArr[i5 + i6] = d;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double addElementRolling(double d) {
        double d6;
        try {
            double[] dArr = this.internalArray;
            int i5 = this.startIndex;
            d6 = dArr[i5];
            if (this.numElements + 1 + i5 > dArr.length) {
                expand();
            }
            int i6 = this.startIndex + 1;
            this.startIndex = i6;
            this.internalArray[(this.numElements - 1) + i6] = d;
            if (shouldContract()) {
                contract();
            }
        } catch (Throwable th) {
            throw th;
        }
        return d6;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void addElements(double[] dArr) {
        int i5 = this.numElements;
        double[] dArr2 = new double[dArr.length + i5 + 1];
        System.arraycopy(this.internalArray, this.startIndex, dArr2, 0, i5);
        System.arraycopy(dArr, 0, dArr2, this.numElements, dArr.length);
        this.internalArray = dArr2;
        this.startIndex = 0;
        this.numElements += dArr.length;
    }

    @Deprecated
    public void checkContractExpand(float f6, float f7) {
        checkContractExpand(f6, f7);
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void clear() {
        this.numElements = 0;
        this.startIndex = 0;
    }

    public double compute(MathArrays.Function function) {
        double[] dArr;
        int i5;
        int i6;
        synchronized (this) {
            dArr = this.internalArray;
            i5 = this.startIndex;
            i6 = this.numElements;
        }
        return function.evaluate(dArr, i5, i6);
    }

    public synchronized void contract() {
        int i5 = this.numElements;
        double[] dArr = new double[i5 + 1];
        System.arraycopy(this.internalArray, this.startIndex, dArr, 0, i5);
        this.internalArray = dArr;
        this.startIndex = 0;
    }

    public synchronized void discardFrontElements(int i5) {
        discardExtremeElements(i5, true);
    }

    public synchronized void discardMostRecentElements(int i5) {
        discardExtremeElements(i5, false);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizableDoubleArray)) {
            return false;
        }
        synchronized (this) {
            synchronized (obj) {
                ResizableDoubleArray resizableDoubleArray = (ResizableDoubleArray) obj;
                if (resizableDoubleArray.contractionCriterion != this.contractionCriterion || resizableDoubleArray.expansionFactor != this.expansionFactor || resizableDoubleArray.expansionMode != this.expansionMode || resizableDoubleArray.numElements != this.numElements || resizableDoubleArray.startIndex != this.startIndex) {
                    return false;
                }
                return Arrays.equals(this.internalArray, resizableDoubleArray.internalArray);
            }
        }
    }

    public synchronized void expand() {
        try {
            double[] dArr = new double[this.expansionMode == ExpansionMode.MULTIPLICATIVE ? (int) FastMath.ceil(((double) this.internalArray.length) * this.expansionFactor) : (int) (((long) this.internalArray.length) + FastMath.round(this.expansionFactor))];
            double[] dArr2 = this.internalArray;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
            this.internalArray = dArr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public double[] getArrayRef() {
        return this.internalArray;
    }

    public int getCapacity() {
        return this.internalArray.length;
    }

    @Deprecated
    public float getContractionCriteria() {
        return (float) getContractionCriterion();
    }

    public double getContractionCriterion() {
        return this.contractionCriterion;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double getElement(int i5) {
        if (i5 >= this.numElements) {
            throw new ArrayIndexOutOfBoundsException(i5);
        }
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(i5);
        }
        return this.internalArray[this.startIndex + i5];
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double[] getElements() {
        double[] dArr;
        int i5 = this.numElements;
        dArr = new double[i5];
        System.arraycopy(this.internalArray, this.startIndex, dArr, 0, i5);
        return dArr;
    }

    @Deprecated
    public float getExpansionFactor() {
        return (float) this.expansionFactor;
    }

    @Deprecated
    public int getExpansionMode() {
        synchronized (this) {
            try {
                int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode[this.expansionMode.ordinal()];
                if (i5 == 1) {
                    return 0;
                }
                if (i5 == 2) {
                    return 1;
                }
                throw new MathInternalError();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public synchronized int getInternalLength() {
        return this.internalArray.length;
    }

    @Deprecated
    public synchronized double[] getInternalValues() {
        return this.internalArray;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized int getNumElements() {
        return this.numElements;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public synchronized int hashCode() {
        return Arrays.hashCode(new int[]{Double.valueOf(this.expansionFactor).hashCode(), Double.valueOf(this.contractionCriterion).hashCode(), this.expansionMode.hashCode(), Arrays.hashCode(this.internalArray), this.numElements, this.startIndex});
    }

    @Deprecated
    public void setContractionCriteria(float f6) {
        checkContractExpand(f6, getExpansionFactor());
        synchronized (this) {
            this.contractionCriterion = f6;
        }
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void setElement(int i5, double d) {
        try {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException(i5);
            }
            int i6 = i5 + 1;
            if (i6 > this.numElements) {
                this.numElements = i6;
            }
            int i7 = this.startIndex;
            if (i7 + i5 >= this.internalArray.length) {
                expandTo(i7 + i6);
            }
            this.internalArray[this.startIndex + i5] = d;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public void setExpansionFactor(float f6) {
        double d = f6;
        checkContractExpand(getContractionCriterion(), d);
        synchronized (this) {
            this.expansionFactor = d;
        }
    }

    @Deprecated
    public void setExpansionMode(int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new MathIllegalArgumentException(LocalizedFormats.UNSUPPORTED_EXPANSION_MODE, Integer.valueOf(i5), 0, "MULTIPLICATIVE_MODE", 1, "ADDITIVE_MODE");
        }
        synchronized (this) {
            try {
                if (i5 == 0) {
                    setExpansionMode(ExpansionMode.MULTIPLICATIVE);
                } else if (i5 == 1) {
                    setExpansionMode(ExpansionMode.ADDITIVE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void setNumElements(int i5) {
        try {
            if (i5 < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.INDEX_NOT_POSITIVE, Integer.valueOf(i5));
            }
            int i6 = this.startIndex + i5;
            if (i6 > this.internalArray.length) {
                expandTo(i6);
            }
            this.numElements = i5;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public synchronized int start() {
        return this.startIndex;
    }

    public synchronized double substituteMostRecentElement(double d) {
        double d6;
        int i5 = this.numElements;
        if (i5 < 1) {
            throw new MathIllegalStateException(LocalizedFormats.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY, new Object[0]);
        }
        int i6 = (i5 - 1) + this.startIndex;
        double[] dArr = this.internalArray;
        d6 = dArr[i6];
        dArr[i6] = d;
        return d6;
    }

    public ResizableDoubleArray(int i5) {
        this(i5, DEFAULT_EXPANSION_FACTOR);
    }

    public void checkContractExpand(double d, double d6) {
        if (d < d6) {
            NumberIsTooSmallException numberIsTooSmallException = new NumberIsTooSmallException(Double.valueOf(d), 1, true);
            numberIsTooSmallException.getContext().addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, Double.valueOf(d), Double.valueOf(d6));
            throw numberIsTooSmallException;
        }
        if (d <= 1.0d) {
            NumberIsTooSmallException numberIsTooSmallException2 = new NumberIsTooSmallException(Double.valueOf(d), 1, false);
            numberIsTooSmallException2.getContext().addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, Double.valueOf(d));
            throw numberIsTooSmallException2;
        }
        if (d6 > 1.0d) {
            return;
        }
        NumberIsTooSmallException numberIsTooSmallException3 = new NumberIsTooSmallException(Double.valueOf(d), 1, false);
        numberIsTooSmallException3.getContext().addMessage(LocalizedFormats.EXPANSION_FACTOR_SMALLER_THAN_ONE, Double.valueOf(d6));
        throw numberIsTooSmallException3;
    }

    public ResizableDoubleArray(double[] dArr) {
        this(16, DEFAULT_EXPANSION_FACTOR, 2.5d, ExpansionMode.MULTIPLICATIVE, dArr);
    }

    @Deprecated
    public ResizableDoubleArray(int i5, float f6) {
        this(i5, f6);
    }

    public ResizableDoubleArray(int i5, double d) {
        this(i5, d, d + DEFAULT_CONTRACTION_DELTA);
    }

    @Deprecated
    public ResizableDoubleArray(int i5, float f6, float f7) {
        this(i5, f6, f7);
    }

    @Deprecated
    public void setExpansionMode(ExpansionMode expansionMode) {
        synchronized (this) {
            this.expansionMode = expansionMode;
        }
    }

    public ResizableDoubleArray(int i5, double d, double d6) {
        this(i5, d, d6, ExpansionMode.MULTIPLICATIVE, null);
    }

    @Deprecated
    public ResizableDoubleArray(int i5, float f6, float f7, int i6) {
        this(i5, f6, f7, i6 == 1 ? ExpansionMode.ADDITIVE : ExpansionMode.MULTIPLICATIVE, null);
        setExpansionMode(i6);
    }

    public ResizableDoubleArray(int i5, double d, double d6, ExpansionMode expansionMode, double... dArr) {
        this.contractionCriterion = 2.5d;
        this.expansionFactor = DEFAULT_EXPANSION_FACTOR;
        this.expansionMode = ExpansionMode.MULTIPLICATIVE;
        this.numElements = 0;
        this.startIndex = 0;
        if (i5 > 0) {
            checkContractExpand(d6, d);
            this.expansionFactor = d;
            this.contractionCriterion = d6;
            this.expansionMode = expansionMode;
            this.internalArray = new double[i5];
            this.numElements = 0;
            this.startIndex = 0;
            if (dArr == null || dArr.length <= 0) {
                return;
            }
            addElements(dArr);
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.INITIAL_CAPACITY_NOT_POSITIVE, Integer.valueOf(i5));
    }

    public synchronized ResizableDoubleArray copy() {
        ResizableDoubleArray resizableDoubleArray;
        resizableDoubleArray = new ResizableDoubleArray();
        copy(this, resizableDoubleArray);
        return resizableDoubleArray;
    }

    public ResizableDoubleArray(ResizableDoubleArray resizableDoubleArray) {
        this.contractionCriterion = 2.5d;
        this.expansionFactor = DEFAULT_EXPANSION_FACTOR;
        this.expansionMode = ExpansionMode.MULTIPLICATIVE;
        this.numElements = 0;
        this.startIndex = 0;
        MathUtils.checkNotNull(resizableDoubleArray);
        copy(resizableDoubleArray, this);
    }

    @Deprecated
    public void setInitialCapacity(int i5) {
    }
}
