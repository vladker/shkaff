package androidx.constraintlayout.core;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int mNone = -1;
    private int mSize = 16;
    private int mHashSize = 16;
    int[] mKeys = new int[16];
    int[] mNextKeys = new int[16];
    int[] mVariables = new int[16];
    float[] mValues = new float[16];
    int[] mPrevious = new int[16];
    int[] mNext = new int[16];
    int mCount = 0;
    int mHead = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i5) {
        int[] iArr;
        int i6 = solverVariable.id % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i7 = iArr2[i6];
        if (i7 == -1) {
            iArr2[i6] = i5;
        } else {
            while (true) {
                iArr = this.mNextKeys;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    break;
                } else {
                    i7 = i8;
                }
            }
            iArr[i7] = i5;
        }
        this.mNextKeys[i5] = -1;
    }

    private void addVariable(int i5, SolverVariable solverVariable, float f6) {
        this.mVariables[i5] = solverVariable.id;
        this.mValues[i5] = f6;
        this.mPrevious[i5] = -1;
        this.mNext[i5] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i5 = 0; i5 < this.mHashSize; i5++) {
            if (this.mKeys[i5] != -1) {
                String string = hashCode() + " hash [" + i5 + "] => ";
                int i6 = this.mKeys[i5];
                boolean z6 = false;
                while (!z6) {
                    StringBuilder sbX = AbstractC0157z.x(string, " ");
                    sbX.append(this.mVariables[i6]);
                    string = sbX.toString();
                    int i7 = this.mNextKeys[i6];
                    if (i7 != -1) {
                        i6 = i7;
                    } else {
                        z6 = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i5 = 0; i5 < this.mSize; i5++) {
            if (this.mVariables[i5] == -1) {
                return i5;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i5 = this.mSize * 2;
        this.mVariables = Arrays.copyOf(this.mVariables, i5);
        this.mValues = Arrays.copyOf(this.mValues, i5);
        this.mPrevious = Arrays.copyOf(this.mPrevious, i5);
        this.mNext = Arrays.copyOf(this.mNext, i5);
        this.mNextKeys = Arrays.copyOf(this.mNextKeys, i5);
        for (int i6 = this.mSize; i6 < i5; i6++) {
            this.mVariables[i6] = -1;
            this.mNextKeys[i6] = -1;
        }
        this.mSize = i5;
    }

    private void insertVariable(int i5, SolverVariable solverVariable, float f6) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f6);
        if (i5 != -1) {
            this.mPrevious[iFindEmptySlot] = i5;
            int[] iArr = this.mNext;
            iArr[iFindEmptySlot] = iArr[i5];
            iArr[i5] = iFindEmptySlot;
        } else {
            this.mPrevious[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.mNext[iFindEmptySlot] = this.mHead;
                this.mHead = iFindEmptySlot;
            } else {
                this.mNext[iFindEmptySlot] = -1;
            }
        }
        int i6 = this.mNext[iFindEmptySlot];
        if (i6 != -1) {
            this.mPrevious[i6] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i5;
        int i6 = solverVariable.id;
        int i7 = i6 % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i8 = iArr2[i7];
        if (i8 == -1) {
            return;
        }
        if (this.mVariables[i8] == i6) {
            int[] iArr3 = this.mNextKeys;
            iArr2[i7] = iArr3[i8];
            iArr3[i8] = -1;
            return;
        }
        while (true) {
            iArr = this.mNextKeys;
            i5 = iArr[i8];
            if (i5 == -1 || this.mVariables[i5] == i6) {
                break;
            } else {
                i8 = i5;
            }
        }
        if (i5 == -1 || this.mVariables[i5] != i6) {
            return;
        }
        iArr[i8] = iArr[i5];
        iArr[i5] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f6, boolean z6) {
        float f7 = sEpsilon;
        if (f6 <= (-f7) || f6 >= f7) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f6);
                return;
            }
            float[] fArr = this.mValues;
            float f8 = fArr[iIndexOf] + f6;
            fArr[iIndexOf] = f8;
            float f9 = sEpsilon;
            if (f8 <= (-f9) || f8 >= f9) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z6);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i5 = this.mCount;
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i7 = 0; i7 < this.mSize; i7++) {
            this.mVariables[i7] = -1;
            this.mNextKeys[i7] = -1;
        }
        for (int i8 = 0; i8 < this.mHashSize; i8++) {
            this.mKeys[i8] = -1;
        }
        this.mCount = 0;
        this.mHead = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i5 = this.mCount;
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
        int i5 = this.mCount;
        int i6 = this.mHead;
        for (int i7 = 0; i7 < i5; i7++) {
            float[] fArr = this.mValues;
            fArr[i6] = fArr[i6] / f6;
            i6 = this.mNext[i6];
            if (i6 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.mValues[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i5) {
        int i6 = this.mCount;
        if (i6 == 0) {
            return null;
        }
        int i7 = this.mHead;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5 && i7 != -1) {
                return this.mCache.mIndexedVariables[this.mVariables[i7]];
            }
            i7 = this.mNext[i7];
            if (i7 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i5) {
        int i6 = this.mCount;
        int i7 = this.mHead;
        for (int i8 = 0; i8 < i6; i8++) {
            if (i8 == i5) {
                return this.mValues[i7];
            }
            i7 = this.mNext[i7];
            if (i7 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i5 = solverVariable.id;
            int i6 = this.mKeys[i5 % this.mHashSize];
            if (i6 == -1) {
                return -1;
            }
            if (this.mVariables[i6] == i5) {
                return i6;
            }
            do {
                i6 = this.mNextKeys[i6];
                if (i6 == -1) {
                    break;
                }
            } while (this.mVariables[i6] != i5);
            if (i6 != -1 && this.mVariables[i6] == i5) {
                return i6;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i5 = this.mCount;
        int i6 = this.mHead;
        for (int i7 = 0; i7 < i5; i7++) {
            float[] fArr = this.mValues;
            fArr[i6] = fArr[i6] * (-1.0f);
            i6 = this.mNext[i6];
            if (i6 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f6) {
        float f7 = sEpsilon;
        if (f6 > (-f7) && f6 < f7) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f6);
            addToHashMap(solverVariable, 0);
            this.mHead = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.mValues[iIndexOf] = f6;
            return;
        }
        if (this.mCount + 1 >= this.mSize) {
            increaseSize();
        }
        int i5 = this.mCount;
        int i6 = this.mHead;
        int i7 = -1;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = this.mVariables[i6];
            int i10 = solverVariable.id;
            if (i9 == i10) {
                this.mValues[i6] = f6;
                return;
            }
            if (i9 < i10) {
                i7 = i6;
            }
            i6 = this.mNext[i6];
            if (i6 == -1) {
                break;
            }
        }
        insertVariable(i7, solverVariable, f6);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z6) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f6 = this.mValues[iIndexOf];
        if (this.mHead == iIndexOf) {
            this.mHead = this.mNext[iIndexOf];
        }
        this.mVariables[iIndexOf] = -1;
        int[] iArr = this.mPrevious;
        int i5 = iArr[iIndexOf];
        if (i5 != -1) {
            int[] iArr2 = this.mNext;
            iArr2[i5] = iArr2[iIndexOf];
        }
        int i6 = this.mNext[iIndexOf];
        if (i6 != -1) {
            iArr[i6] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z6) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f6;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strN;
        String strN2;
        String strN3 = hashCode() + " { ";
        int i5 = this.mCount;
        for (int i6 = 0; i6 < i5; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                String str = strN3 + variable + " = " + getVariableValue(i6) + " ";
                int iIndexOf = indexOf(variable);
                String strN4 = a.n(str, "[p: ");
                if (this.mPrevious[iIndexOf] != -1) {
                    StringBuilder sbR = a.r(strN4);
                    sbR.append(this.mCache.mIndexedVariables[this.mVariables[this.mPrevious[iIndexOf]]]);
                    strN = sbR.toString();
                } else {
                    strN = a.n(strN4, "none");
                }
                String strN5 = a.n(strN, ", n: ");
                if (this.mNext[iIndexOf] != -1) {
                    StringBuilder sbR2 = a.r(strN5);
                    sbR2.append(this.mCache.mIndexedVariables[this.mVariables[this.mNext[iIndexOf]]]);
                    strN2 = sbR2.toString();
                } else {
                    strN2 = a.n(strN5, "none");
                }
                strN3 = a.n(strN2, "]");
            }
        }
        return a.n(strN3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z6) {
        float f6 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z6);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i5 = 0;
        int i6 = 0;
        while (i5 < currentSize) {
            int i7 = solverVariableValues.mVariables[i6];
            if (i7 != -1) {
                add(this.mCache.mIndexedVariables[i7], solverVariableValues.mValues[i6] * f6, z6);
                i5++;
            }
            i6++;
        }
        return f6;
    }
}
