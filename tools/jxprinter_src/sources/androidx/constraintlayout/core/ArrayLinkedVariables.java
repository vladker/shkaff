package androidx.constraintlayout.core;

import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int mCurrentSize = 0;
    private int mRowSize = 8;
    private SolverVariable mCandidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f6, boolean z6) {
        float f7 = sEpsilon;
        if (f6 <= (-f7) || f6 >= f7) {
            int i5 = this.mHead;
            if (i5 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f6;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i6 = this.mLast + 1;
                this.mLast = i6;
                int[] iArr = this.mArrayIndices;
                if (i6 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i7 = -1;
            for (int i8 = 0; i5 != -1 && i8 < this.mCurrentSize; i8++) {
                int i9 = this.mArrayIndices[i5];
                int i10 = solverVariable.id;
                if (i9 == i10) {
                    float[] fArr = this.mArrayValues;
                    float f8 = fArr[i5] + f6;
                    float f9 = sEpsilon;
                    if (f8 > (-f9) && f8 < f9) {
                        f8 = 0.0f;
                    }
                    fArr[i5] = f8;
                    if (f8 == 0.0f) {
                        if (i5 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i5];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i7] = iArr2[i5];
                        }
                        if (z6) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i5;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i9 < i10) {
                    i7 = i5;
                }
                i5 = this.mArrayNextIndices[i5];
            }
            int length = this.mLast;
            int i11 = length + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i11;
            }
            int[] iArr4 = this.mArrayIndices;
            if (length >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i12 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i12 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i12] == -1) {
                        length = i12;
                        break;
                    }
                    i12++;
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i13 = this.mRowSize * 2;
                this.mRowSize = i13;
                this.mDidFillOnce = false;
                this.mLast = length - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[length] = solverVariable.id;
            this.mArrayValues[length] = f6;
            if (i7 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[length] = iArr7[i7];
                iArr7[i7] = length;
            } else {
                this.mArrayNextIndices[length] = this.mHead;
                this.mHead = length;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i14 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i14 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i5 = this.mArrayNextIndices[i5];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i5 = this.mHead;
        if (i5 == -1) {
            return false;
        }
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return true;
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i5 = this.mCurrentSize;
        System.out.print("{ ");
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i6) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f6) {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            float[] fArr = this.mArrayValues;
            fArr[i5] = fArr[i5] / f6;
            i5 = this.mArrayNextIndices[i5];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return this.mArrayValues[i5];
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i5) {
        return this.mArrayIndices[i5];
    }

    public final int getNextIndice(int i5) {
        return this.mArrayNextIndices[i5];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i5 = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayValues[i5] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i5]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return solverVariable2;
    }

    public final float getValue(int i5) {
        return this.mArrayValues[i5];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i5) {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.mCurrentSize; i7++) {
            if (i7 == i5) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i5) {
        int i6 = this.mHead;
        for (int i7 = 0; i6 != -1 && i7 < this.mCurrentSize; i7++) {
            if (i7 == i5) {
                return this.mArrayValues[i6];
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayValues[i5] > 0.0f) {
                return true;
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i5 = this.mHead;
        if (i5 == -1) {
            return -1;
        }
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                return i5;
            }
            i5 = this.mArrayNextIndices[i5];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i5 = this.mHead;
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            float[] fArr = this.mArrayValues;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.mArrayNextIndices[i5];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f6) {
        if (f6 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i5 = this.mHead;
        if (i5 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f6;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            int i6 = this.mLast + 1;
            this.mLast = i6;
            int[] iArr = this.mArrayIndices;
            if (i6 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i7 = -1;
        for (int i8 = 0; i5 != -1 && i8 < this.mCurrentSize; i8++) {
            int i9 = this.mArrayIndices[i5];
            int i10 = solverVariable.id;
            if (i9 == i10) {
                this.mArrayValues[i5] = f6;
                return;
            }
            if (i9 < i10) {
                i7 = i5;
            }
            i5 = this.mArrayNextIndices[i5];
        }
        int length = this.mLast;
        int i11 = length + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i11;
        }
        int[] iArr3 = this.mArrayIndices;
        if (length >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i12 >= iArr4.length) {
                    break;
                }
                if (iArr4[i12] == -1) {
                    length = i12;
                    break;
                }
                i12++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i13 = this.mRowSize * 2;
            this.mRowSize = i13;
            this.mDidFillOnce = false;
            this.mLast = length - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i13);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[length] = solverVariable.id;
        this.mArrayValues[length] = f6;
        if (i7 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[length] = iArr6[i7];
            iArr6[i7] = length;
        } else {
            this.mArrayNextIndices[length] = this.mHead;
            this.mHead = length;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i14 = this.mCurrentSize + 1;
        this.mCurrentSize = i14;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i14 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z6) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i5 = this.mHead;
        if (i5 == -1) {
            return 0.0f;
        }
        int i6 = 0;
        int i7 = -1;
        while (i5 != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i5] == solverVariable.id) {
                if (i5 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i5];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i7] = iArr[i5];
                }
                if (z6) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i5] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i5;
                }
                return this.mArrayValues[i5];
            }
            i6++;
            i7 = i5;
            i5 = this.mArrayNextIndices[i5];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i5 = this.mHead;
        String string = "";
        for (int i6 = 0; i5 != -1 && i6 < this.mCurrentSize; i6++) {
            StringBuilder sbR = a.r(a.q(a.r(a.n(string, " -> ")), " : ", this.mArrayValues[i5]));
            sbR.append(this.mCache.mIndexedVariables[this.mArrayIndices[i5]]);
            string = sbR.toString();
            i5 = this.mArrayNextIndices[i5];
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z6) {
        float f6 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z6);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i5 = 0; i5 < currentSize; i5++) {
            SolverVariable variable = arrayRowVariables.getVariable(i5);
            add(variable, arrayRowVariables.get(variable) * f6, z6);
        }
        return f6;
    }
}
