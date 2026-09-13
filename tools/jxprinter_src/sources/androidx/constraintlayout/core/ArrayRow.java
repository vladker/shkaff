package androidx.constraintlayout.core;

import androidx.collection.a;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayRow implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    public ArrayRowVariables variables;
    SolverVariable mVariable = null;
    float mConstantValue = 0.0f;
    boolean mUsed = false;
    ArrayList<SolverVariable> mVariablesToUpdate = new ArrayList<>();
    boolean mIsSimpleDefinition = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f6, boolean z6);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f6);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i5);

        float getVariableValue(int i5);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f6);

        float remove(SolverVariable solverVariable, boolean z6);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z6);
    }

    public ArrayRow() {
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    private SolverVariable pickPivotInVariables(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < currentSize; i5++) {
            float variableValue = this.variables.getVariableValue(i5);
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i5);
                if ((zArr == null || !zArr[variable.id]) && variable != solverVariable && (((type = variable.mType) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && variableValue < f6)) {
                    f6 = variableValue;
                    solverVariable2 = variable;
                }
            }
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int i5) {
        this.variables.put(linearSystem.createErrorVariable(i5, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i5, "em"), -1.0f);
        return this;
    }

    public ArrayRow addSingleError(SolverVariable solverVariable, int i5) {
        this.variables.put(solverVariable, i5);
        return this;
    }

    public boolean chooseSubject(LinearSystem linearSystem) {
        boolean z6;
        SolverVariable solverVariableChooseSubjectInVariables = chooseSubjectInVariables(linearSystem);
        if (solverVariableChooseSubjectInVariables == null) {
            z6 = true;
        } else {
            pivot(solverVariableChooseSubjectInVariables);
            z6 = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
        }
        return z6;
    }

    public SolverVariable chooseSubjectInVariables(LinearSystem linearSystem) {
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable = null;
        float f6 = 0.0f;
        float f7 = 0.0f;
        boolean z6 = false;
        boolean z7 = false;
        SolverVariable solverVariable2 = null;
        for (int i5 = 0; i5 < currentSize; i5++) {
            float variableValue = this.variables.getVariableValue(i5);
            SolverVariable variable = this.variables.getVariable(i5);
            if (variable.mType == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null || f6 > variableValue) {
                    boolean zIsNew = isNew(variable, linearSystem);
                    z6 = zIsNew;
                    f6 = variableValue;
                    solverVariable = variable;
                } else if (!z6 && isNew(variable, linearSystem)) {
                    f6 = variableValue;
                    solverVariable = variable;
                    z6 = true;
                }
            } else if (solverVariable == null && variableValue < 0.0f) {
                if (solverVariable2 == null || f7 > variableValue) {
                    boolean zIsNew2 = isNew(variable, linearSystem);
                    z7 = zIsNew2;
                    f7 = variableValue;
                    solverVariable2 = variable;
                } else if (!z7 && isNew(variable, linearSystem)) {
                    f7 = variableValue;
                    solverVariable2 = variable;
                    z7 = true;
                }
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.mVariable = null;
        this.mConstantValue = 0.0f;
    }

    public ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, float f6, SolverVariable solverVariable3, SolverVariable solverVariable4, int i6) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f6 == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i5 > 0 || i6 > 0) {
                this.mConstantValue = (-i5) + i6;
                return this;
            }
        } else {
            if (f6 <= 0.0f) {
                this.variables.put(solverVariable, -1.0f);
                this.variables.put(solverVariable2, 1.0f);
                this.mConstantValue = i5;
                return this;
            }
            if (f6 >= 1.0f) {
                this.variables.put(solverVariable4, -1.0f);
                this.variables.put(solverVariable3, 1.0f);
                this.mConstantValue = -i6;
                return this;
            }
            float f7 = 1.0f - f6;
            this.variables.put(solverVariable, f7 * 1.0f);
            this.variables.put(solverVariable2, f7 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f6);
            this.variables.put(solverVariable4, 1.0f * f6);
            if (i5 > 0 || i6 > 0) {
                this.mConstantValue = (i6 * f6) + ((-i5) * f7);
                return this;
            }
        }
        return this;
    }

    public ArrayRow createRowDefinition(SolverVariable solverVariable, int i5) {
        this.mVariable = solverVariable;
        float f6 = i5;
        solverVariable.computedValue = f6;
        this.mConstantValue = f6;
        this.mIsSimpleDefinition = true;
        return this;
    }

    public ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f6) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f6);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f6);
        this.variables.put(solverVariable4, -f6);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f6, float f7, float f8, SolverVariable solverVariable, int i5, SolverVariable solverVariable2, int i6, SolverVariable solverVariable3, int i7, SolverVariable solverVariable4, int i8) {
        if (f7 == 0.0f || f6 == f8) {
            this.mConstantValue = ((-i5) - i6) + i7 + i8;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        float f9 = (f6 / f7) / (f8 / f7);
        this.mConstantValue = (i8 * f9) + (i7 * f9) + ((-i5) - i6);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f9);
        this.variables.put(solverVariable3, -f9);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f6, float f7, float f8, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.mConstantValue = 0.0f;
        if (f7 == 0.0f || f6 == f8) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        if (f6 == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        }
        if (f8 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
            return this;
        }
        float f9 = (f6 / f7) / (f8 / f7);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f9);
        this.variables.put(solverVariable3, -f9);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i5) {
        if (i5 < 0) {
            this.mConstantValue = i5 * (-1);
            this.variables.put(solverVariable, 1.0f);
            return this;
        }
        this.mConstantValue = i5;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i5) {
        boolean z6 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z6 = true;
            }
            this.mConstantValue = i5;
        }
        if (z6) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i5) {
        boolean z6 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z6 = true;
            }
            this.mConstantValue = i5;
        }
        if (z6) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.mConstantValue = -f6;
        return this;
    }

    public void ensurePositiveConstant() {
        float f6 = this.mConstantValue;
        if (f6 < 0.0f) {
            this.mConstantValue = f6 * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.mVariable;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return pickPivotInVariables(zArr, null);
    }

    public boolean hasKeyVariable() {
        SolverVariable solverVariable = this.mVariable;
        if (solverVariable != null) {
            return solverVariable.mType == SolverVariable.Type.UNRESTRICTED || this.mConstantValue >= 0.0f;
        }
        return false;
    }

    public boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (row instanceof ArrayRow) {
            ArrayRow arrayRow = (ArrayRow) row;
            this.mVariable = null;
            this.variables.clear();
            for (int i5 = 0; i5 < arrayRow.variables.getCurrentSize(); i5++) {
                this.variables.add(arrayRow.variables.getVariable(i5), arrayRow.variables.getVariableValue(i5), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mVariable == null && this.mConstantValue == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return pickPivotInVariables(null, solverVariable);
    }

    public void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.mVariable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.mVariable.mDefinitionId = -1;
            this.mVariable = null;
        }
        float fRemove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.mVariable = solverVariable;
        if (fRemove == 1.0f) {
            return;
        }
        this.mConstantValue /= fRemove;
        this.variables.divideByAmount(fRemove);
    }

    public void reset() {
        this.mVariable = null;
        this.variables.clear();
        this.mConstantValue = 0.0f;
        this.mIsSimpleDefinition = false;
    }

    public int sizeInBytes() {
        return this.variables.sizeInBytes() + (this.mVariable != null ? 4 : 0) + 8;
    }

    public String toReadableString() {
        boolean z6;
        String strN = a.n(this.mVariable == null ? "0" : "" + this.mVariable, " = ");
        if (this.mConstantValue != 0.0f) {
            StringBuilder sbR = a.r(strN);
            sbR.append(this.mConstantValue);
            strN = sbR.toString();
            z6 = true;
        } else {
            z6 = false;
        }
        int currentSize = this.variables.getCurrentSize();
        for (int i5 = 0; i5 < currentSize; i5++) {
            SolverVariable variable = this.variables.getVariable(i5);
            if (variable != null) {
                float variableValue = this.variables.getVariableValue(i5);
                if (variableValue != 0.0f) {
                    String string = variable.toString();
                    if (z6) {
                        if (variableValue > 0.0f) {
                            strN = a.n(strN, " + ");
                        } else {
                            strN = a.n(strN, " - ");
                            variableValue *= -1.0f;
                        }
                    } else if (variableValue < 0.0f) {
                        strN = a.n(strN, "- ");
                        variableValue *= -1.0f;
                    }
                    strN = variableValue == 1.0f ? a.n(strN, string) : strN + variableValue + " " + string;
                    z6 = true;
                }
            }
        }
        return !z6 ? a.n(strN, IdManager.DEFAULT_VERSION_NAME) : strN;
    }

    public String toString() {
        return toReadableString();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z6) {
        if (solverVariable == null || !solverVariable.isFinalValue) {
            return;
        }
        float f6 = this.variables.get(solverVariable);
        this.mConstantValue = (solverVariable.computedValue * f6) + this.mConstantValue;
        this.variables.remove(solverVariable, z6);
        if (z6) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z6) {
        float fUse = this.variables.use(arrayRow, z6);
        this.mConstantValue = (arrayRow.mConstantValue * fUse) + this.mConstantValue;
        if (z6) {
            arrayRow.mVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z6) {
        if (solverVariable == null || !solverVariable.mIsSynonym) {
            return;
        }
        float f6 = this.variables.get(solverVariable);
        this.mConstantValue = (solverVariable.mSynonymDelta * f6) + this.mConstantValue;
        this.variables.remove(solverVariable, z6);
        if (z6) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.mSynonym], f6, z6);
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean z6 = false;
        while (!z6) {
            int currentSize = this.variables.getCurrentSize();
            for (int i5 = 0; i5 < currentSize; i5++) {
                SolverVariable variable = this.variables.getVariable(i5);
                if (variable.mDefinitionId != -1 || variable.isFinalValue || variable.mIsSynonym) {
                    this.mVariablesToUpdate.add(variable);
                }
            }
            int size = this.mVariablesToUpdate.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    SolverVariable solverVariable = this.mVariablesToUpdate.get(i6);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.mIsSynonym) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.mRows[solverVariable.mDefinitionId], true);
                    }
                }
                this.mVariablesToUpdate.clear();
            } else {
                z6 = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.mVariable != null && this.variables.getCurrentSize() == 0) {
            this.mIsSimpleDefinition = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        int i5 = solverVariable.strength;
        float f6 = 1.0f;
        if (i5 != 1) {
            if (i5 == 2) {
                f6 = 1000.0f;
            } else if (i5 == 3) {
                f6 = 1000000.0f;
            } else if (i5 == 4) {
                f6 = 1.0E9f;
            } else if (i5 == 5) {
                f6 = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f6);
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i5) {
        boolean z6 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z6 = true;
            }
            this.mConstantValue = i5;
        }
        if (!z6) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        return this;
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i5, SolverVariable solverVariable2) {
        this.mConstantValue = i5;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }
}
