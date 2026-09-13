package androidx.constraintlayout.core;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i5 = 0; i5 < 9; i5++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f6 = fArr[i5] + solverVariable.mGoalStrengthVector[i5];
                fArr[i5] = f6;
                if (Math.abs(f6) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i5] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f6) {
            boolean z6 = true;
            if (!this.mVariable.inGoal) {
                for (int i5 = 0; i5 < 9; i5++) {
                    float f7 = solverVariable.mGoalStrengthVector[i5];
                    if (f7 != 0.0f) {
                        float f8 = f7 * f6;
                        if (Math.abs(f8) < 1.0E-4f) {
                            f8 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i5] = f8;
                    } else {
                        this.mVariable.mGoalStrengthVector[i5] = 0.0f;
                    }
                }
                return true;
            }
            for (int i6 = 0; i6 < 9; i6++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f9 = (solverVariable.mGoalStrengthVector[i6] * f6) + fArr[i6];
                fArr[i6] = f9;
                if (Math.abs(f9) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i6] = 0.0f;
                } else {
                    z6 = false;
                }
            }
            if (z6) {
                PriorityGoalRow.this.removeGoal(this.mVariable);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i5 = 8; i5 >= 0; i5--) {
                float f6 = this.mVariable.mGoalStrengthVector[i5];
                if (f6 > 0.0f) {
                    return false;
                }
                if (f6 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i5 = 0; i5 < 9; i5++) {
                if (this.mVariable.mGoalStrengthVector[i5] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            for (int i5 = 8; i5 >= 0; i5--) {
                float f6 = solverVariable.mGoalStrengthVector[i5];
                float f7 = this.mVariable.mGoalStrengthVector[i5];
                if (f7 != f6) {
                    if (f7 < f6) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String strQ = "[ ";
            if (this.mVariable != null) {
                for (int i5 = 0; i5 < 9; i5++) {
                    strQ = a.q(a.r(strQ), " ", this.mVariable.mGoalStrengthVector[i5]);
                }
            }
            StringBuilder sbX = AbstractC0157z.x(strQ, "] ");
            sbX.append(this.mVariable);
            return sbX.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i5;
        int i6 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i6 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i7 = this.mNumGoals;
        solverVariableArr3[i7] = solverVariable;
        int i8 = i7 + 1;
        this.mNumGoals = i8;
        if (i8 > 1 && solverVariableArr3[i7].id > solverVariable.id) {
            int i9 = 0;
            while (true) {
                i5 = this.mNumGoals;
                if (i9 >= i5) {
                    break;
                }
                this.mSortArray[i9] = this.mArrayGoals[i9];
                i9++;
            }
            Arrays.sort(this.mSortArray, 0, i5, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i10 = 0; i10 < this.mNumGoals; i10++) {
                this.mArrayGoals[i10] = this.mSortArray[i10];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i5 = 0;
        while (i5 < this.mNumGoals) {
            if (this.mArrayGoals[i5] == solverVariable) {
                while (true) {
                    int i6 = this.mNumGoals;
                    if (i5 >= i6 - 1) {
                        this.mNumGoals = i6 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i7 = i5 + 1;
                        solverVariableArr[i5] = solverVariableArr[i7];
                        i5 = i7;
                    }
                }
            } else {
                i5++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i5 = -1;
        for (int i6 = 0; i6 < this.mNumGoals; i6++) {
            SolverVariable solverVariable = this.mArrayGoals[i6];
            if (!zArr[solverVariable.id]) {
                this.mAccessor.init(solverVariable);
                if (i5 == -1) {
                    if (this.mAccessor.isNegative()) {
                        i5 = i6;
                    }
                } else if (this.mAccessor.isSmallerThan(this.mArrayGoals[i5])) {
                    i5 = i6;
                }
            }
        }
        if (i5 == -1) {
            return null;
        }
        return this.mArrayGoals[i5];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String strQ = a.q(new StringBuilder(" goal -> ("), ") : ", this.mConstantValue);
        for (int i5 = 0; i5 < this.mNumGoals; i5++) {
            this.mAccessor.init(this.mArrayGoals[i5]);
            StringBuilder sbR = a.r(strQ);
            sbR.append(this.mAccessor);
            sbR.append(" ");
            strQ = sbR.toString();
        }
        return strQ;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z6) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i5 = 0; i5 < currentSize; i5++) {
            SolverVariable variable = arrayRowVariables.getVariable(i5);
            float variableValue = arrayRowVariables.getVariableValue(i5);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue = (arrayRow.mConstantValue * variableValue) + this.mConstantValue;
        }
        removeGoal(solverVariable);
    }
}
