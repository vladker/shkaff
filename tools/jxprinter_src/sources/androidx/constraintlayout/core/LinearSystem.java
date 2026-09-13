package androidx.constraintlayout.core;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    private Row mTempGoal;
    private int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int mTableSize = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[1000];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z6);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z6);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.mSolverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i5 = this.mPoolVariablesCount;
        int i6 = this.mPoolSize;
        if (i5 >= i6) {
            int i7 = i6 * 2;
            this.mPoolSize = i7;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i7);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i8 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i8 + 1;
        solverVariableArr[i8] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addRow(ArrayRow arrayRow) {
        int i5;
        if (SIMPLIFY_SYNONYMS && arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i6 = this.mNumRows;
            arrayRowArr[i6] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i6;
            this.mNumRows = i6 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i7 = 0;
            while (i7 < this.mNumRows) {
                if (this.mRows[i7] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i7];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i7] = null;
                    int i8 = i7 + 1;
                    int i9 = i8;
                    while (true) {
                        i5 = this.mNumRows;
                        if (i8 >= i5) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i10 = i8 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i8];
                        arrayRowArr2[i10] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i8) {
                            solverVariable2.mDefinitionId = i10;
                        }
                        i9 = i8;
                        i8++;
                    }
                    if (i9 < i5) {
                        this.mRows[i9] = null;
                    }
                    this.mNumRows = i5 - 1;
                    i7--;
                }
                i7++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f6) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f6);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        int i5 = this.mVariablesID + 1;
        this.mVariablesID = i5;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i5;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String strN = "";
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            StringBuilder sbR = a.r(strN);
            sbR.append(this.mRows[i5]);
            strN = a.n(sbR.toString(), "\n");
        }
        StringBuilder sbR2 = a.r(strN);
        sbR2.append(this.mGoal);
        sbR2.append("\n");
        System.out.println(sbR2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.mNumRows);
        sb.append("x");
        System.out.println(AbstractC0157z.l(")\n", this.mNumColumns, sb));
    }

    private int enforceBFS(Row row) {
        float f6;
        long j6;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f7 = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z6 = false;
                    int i6 = 0;
                    while (!z6) {
                        Metrics metrics = sMetrics;
                        long j7 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i6++;
                        float f8 = Float.MAX_VALUE;
                        int i7 = 0;
                        int i8 = -1;
                        int i9 = -1;
                        int i10 = 0;
                        while (true) {
                            if (i7 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i7];
                            if (arrayRow2.mVariable.mType == SolverVariable.Type.UNRESTRICTED || arrayRow2.mIsSimpleDefinition || arrayRow2.mConstantValue >= f7) {
                                f6 = f7;
                                j6 = j7;
                            } else if (SKIP_COLUMNS) {
                                int currentSize = arrayRow2.variables.getCurrentSize();
                                int i11 = 0;
                                while (i11 < currentSize) {
                                    float f9 = f7;
                                    SolverVariable variable = arrayRow2.variables.getVariable(i11);
                                    long j8 = j7;
                                    float f10 = arrayRow2.variables.get(variable);
                                    if (f10 > f9) {
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f11 = variable.mStrengthVector[i12] / f10;
                                            if ((f11 < f8 && i12 == i10) || i12 > i10) {
                                                i10 = i12;
                                                i9 = variable.id;
                                                i8 = i7;
                                                f8 = f11;
                                            }
                                        }
                                    }
                                    i11++;
                                    f7 = f9;
                                    j7 = j8;
                                }
                                f6 = f7;
                                j6 = j7;
                            } else {
                                f6 = f7;
                                j6 = j7;
                                for (int i13 = 1; i13 < this.mNumColumns; i13++) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i13];
                                    float f12 = arrayRow2.variables.get(solverVariable);
                                    if (f12 > f6) {
                                        for (int i14 = 0; i14 < 9; i14++) {
                                            float f13 = solverVariable.mStrengthVector[i14] / f12;
                                            if ((f13 < f8 && i14 == i10) || i14 > i10) {
                                                i10 = i14;
                                                f8 = f13;
                                                i8 = i7;
                                                i9 = i13;
                                            }
                                        }
                                    }
                                }
                            }
                            i7++;
                            f7 = f6;
                            j7 = j6;
                        }
                        float f14 = f7;
                        long j9 = j7;
                        if (i8 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i8];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j9;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i9]);
                            SolverVariable solverVariable2 = arrayRow3.mVariable;
                            solverVariable2.mDefinitionId = i8;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z6 = true;
                        }
                        if (i6 > this.mNumColumns / 2) {
                            z6 = true;
                        }
                        f7 = f14;
                    }
                    return i6;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i5) {
        int i6 = i5 * 4;
        int i7 = i6 / 1024;
        int i8 = i7 / 1024;
        if (i8 > 0) {
            return a.i(i8, "", " Mb");
        }
        return i7 > 0 ? a.i(i7, "", " Kb") : a.i(i6, "", " bytes");
    }

    private String getDisplayStrength(int i5) {
        if (i5 == 1) {
            return "LOW";
        }
        if (i5 == 2) {
            return "MEDIUM";
        }
        if (i5 == 3) {
            return "HIGH";
        }
        if (i5 == 4) {
            return "HIGHEST";
        }
        if (i5 == 5) {
            return "EQUALITY";
        }
        if (i5 == 8) {
            return "FIXED";
        }
        return i5 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i5 = this.mTableSize * 2;
        this.mTableSize = i5;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i5);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.mTableSize);
        int i6 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i6];
        this.mMaxColumns = i6;
        this.mMaxRows = i6;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i6);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z6) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i5 = 0; i5 < this.mNumColumns; i5++) {
            this.mAlreadyTestedCandidates[i5] = false;
        }
        boolean z7 = false;
        int i6 = 0;
        while (!z7) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i6++;
            if (i6 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i7 = pivotCandidate.id;
                    if (!zArr[i7]) {
                        zArr[i7] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f6 = Float.MAX_VALUE;
                    int i8 = -1;
                    for (int i9 = 0; i9 < this.mNumRows; i9++) {
                        ArrayRow arrayRow = this.mRows[i9];
                        if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f7 = arrayRow.variables.get(pivotCandidate);
                            if (f7 < 0.0f) {
                                float f8 = (-arrayRow.mConstantValue) / f7;
                                if (f8 < f6) {
                                    i8 = i9;
                                    f6 = f8;
                                }
                            }
                        }
                    }
                    if (i8 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i8];
                        arrayRow2.mVariable.mDefinitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.mVariable;
                        solverVariable.mDefinitionId = i8;
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z7 = true;
                }
            }
            return i6;
        }
        return i6;
    }

    private void releaseRows() {
        int i5 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i5 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i5];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i5] = null;
                i5++;
            }
            return;
        }
        while (i5 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i5];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i5] = null;
            i5++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f6, int i5) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow arrayRowCreateRow = createRow();
        double d = f6;
        double d6 = i5;
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d) * d6));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d) * d6));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, float f6, SolverVariable solverVariable3, SolverVariable solverVariable4, int i6, int i7) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i5, f6, solverVariable3, solverVariable4, i6);
        if (i7 != 8) {
            arrayRowCreateRow.addError(this, i7);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x009a  */
    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable solverVariablePickPivot;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.mIsSimpleDefinition) {
                metrics.simpleconstraints++;
            }
        }
        boolean z6 = true;
        if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        boolean z7 = false;
        if (!arrayRow.mIsSimpleDefinition) {
            arrayRow.updateFromSystem(this);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.ensurePositiveConstant();
            if (arrayRow.chooseSubject(this)) {
                SolverVariable solverVariableCreateExtraVariable = createExtraVariable();
                arrayRow.mVariable = solverVariableCreateExtraVariable;
                int i5 = this.mNumRows;
                addRow(arrayRow);
                if (this.mNumRows == i5 + 1) {
                    this.mTempGoal.initFromRow(arrayRow);
                    optimize(this.mTempGoal, true);
                    if (solverVariableCreateExtraVariable.mDefinitionId == -1) {
                        if (arrayRow.mVariable == solverVariableCreateExtraVariable && (solverVariablePickPivot = arrayRow.pickPivot(solverVariableCreateExtraVariable)) != null) {
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow.pivot(solverVariablePickPivot);
                        }
                        if (!arrayRow.mIsSimpleDefinition) {
                            arrayRow.mVariable.updateReferencesWithNewDefinition(this, arrayRow);
                        }
                        if (OPTIMIZED_ENGINE) {
                            this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                        } else {
                            this.mCache.mArrayRowPool.release(arrayRow);
                        }
                        this.mNumRows--;
                    }
                } else {
                    z6 = false;
                }
            } else {
                z6 = false;
            }
            if (!arrayRow.hasKeyVariable()) {
                return;
            } else {
                z7 = z6;
            }
        }
        if (z7) {
            return;
        }
        addRow(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, int i6) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i6 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i5);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i5);
        if (i6 != 8) {
            arrayRowCreateRow.addError(this, i6);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, boolean z6) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i5);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, int i6) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i5);
        if (i6 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i6);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, boolean z6) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i5);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i5, int i6) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i5);
        if (i6 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i6);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f6, int i5) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f6);
        if (i5 != 8) {
            arrayRowCreateRow.addError(this, i5);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addSingleError(ArrayRow arrayRow, int i5, int i6) {
        arrayRow.addSingleError(createErrorVariable(i6, null), i5);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i5) {
        if (solverVariable.mDefinitionId != -1 || i5 != 0) {
            addEquality(solverVariable, solverVariable2, i5, 8);
            return;
        }
        if (solverVariable2.mIsSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
        }
        if (solverVariable.mIsSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i5;
        int i6 = 0;
        while (i6 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.mVariable;
                solverVariable.computedValue = arrayRow.mConstantValue;
                solverVariable.removeFromRow(arrayRow);
                int i7 = i6;
                while (true) {
                    i5 = this.mNumRows;
                    if (i7 >= i5 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i8 = i7 + 1;
                    arrayRowArr[i7] = arrayRowArr[i8];
                    i7 = i8;
                }
                this.mRows[i5 - 1] = null;
                this.mNumRows = i5 - 1;
                i6--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.mArrayRowPool.release(arrayRow);
                }
            }
            i6++;
        }
    }

    public SolverVariable createErrorVariable(int i5, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i6 = this.mVariablesID + 1;
        this.mVariablesID = i6;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i6;
        solverVariableAcquireSolverVariable.strength = i5;
        this.mCache.mIndexedVariables[i6] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i5 = this.mVariablesID + 1;
        this.mVariablesID = i5;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i5;
        this.mCache.mIndexedVariables[i5] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i5 = solverVariable.id;
            if (i5 != -1 && i5 <= this.mVariablesID && this.mCache.mIndexedVariables[i5] != null) {
                return solverVariable;
            }
            if (i5 != -1) {
                solverVariable.reset();
            }
            int i6 = this.mVariablesID + 1;
            this.mVariablesID = i6;
            this.mNumColumns++;
            solverVariable.id = i6;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i6] = solverVariable;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        if (OPTIMIZED_ENGINE) {
            arrayRowAcquire = this.mCache.mOptimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = this.mCache.mArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i5 = this.mVariablesID + 1;
        this.mVariablesID = i5;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i5;
        this.mCache.mIndexedVariables[i5] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String strL = AbstractC0157z.l("\n", this.mVariablesID, new StringBuilder(" num vars "));
        for (int i5 = 0; i5 < this.mVariablesID + 1; i5++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i5];
            if (solverVariable != null && solverVariable.isFinalValue) {
                StringBuilder sb = new StringBuilder();
                sb.append(strL);
                sb.append(" $[");
                sb.append(i5);
                sb.append("] => ");
                sb.append(solverVariable);
                sb.append(" = ");
                strL = a.q(sb, "\n", solverVariable.computedValue);
            }
        }
        String strN = a.n(strL, "\n");
        for (int i6 = 0; i6 < this.mVariablesID + 1; i6++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i6];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                SolverVariable solverVariable3 = solverVariableArr[solverVariable2.mSynonym];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(strN);
                sb2.append(" ~[");
                sb2.append(i6);
                sb2.append("] => ");
                sb2.append(solverVariable2);
                sb2.append(" = ");
                sb2.append(solverVariable3);
                sb2.append(" + ");
                strN = a.q(sb2, "\n", solverVariable2.mSynonymDelta);
            }
        }
        String strN2 = a.n(strN, "\n\n #  ");
        for (int i7 = 0; i7 < this.mNumRows; i7++) {
            StringBuilder sbR = a.r(strN2);
            sbR.append(this.mRows[i7].toReadableString());
            strN2 = a.n(sbR.toString(), "\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder sbX = AbstractC0157z.x(strN2, "Goal: ");
            sbX.append(this.mGoal);
            sbX.append("\n");
            strN2 = sbX.toString();
        }
        System.out.println(strN2);
    }

    public void displaySystemInformation() {
        int iSizeInBytes = 0;
        for (int i5 = 0; i5 < this.mTableSize; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                iSizeInBytes += arrayRow.sizeInBytes();
            }
        }
        int iSizeInBytes2 = 0;
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow2 = this.mRows[i6];
            if (arrayRow2 != null) {
                iSizeInBytes2 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Linear System -> Table size: ");
        sb.append(this.mTableSize);
        sb.append(" (");
        int i7 = this.mTableSize;
        sb.append(getDisplaySize(i7 * i7));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(iSizeInBytes));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(iSizeInBytes2));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append(PackagingURIHelper.FORWARD_SLASH_STRING);
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append(PackagingURIHelper.FORWARD_SLASH_STRING);
        sb.append(this.mMaxColumns);
        sb.append(" 0 occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String strN = "";
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            if (this.mRows[i5].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder sbR = a.r(strN);
                sbR.append(this.mRows[i5].toReadableString());
                strN = a.n(sbR.toString(), "\n");
            }
        }
        StringBuilder sbR2 = a.r(strN);
        sbR2.append(this.mGoal);
        sbR2.append("\n");
        System.out.println(sbR2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            ArrayRow arrayRow = this.mRows[i5];
            if (arrayRow != null) {
                iSizeInBytes = arrayRow.sizeInBytes() + iSizeInBytes;
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i5) {
        return this.mRows[i5];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i5 = 0; i5 < this.mNumRows; i5++) {
            if (!this.mRows[i5].mIsSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i5;
        if (!arrayRow.mIsSimpleDefinition || (solverVariable = arrayRow.mVariable) == null) {
            return;
        }
        int i6 = solverVariable.mDefinitionId;
        if (i6 != -1) {
            while (true) {
                i5 = this.mNumRows;
                if (i6 >= i5 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i7 = i6 + 1;
                ArrayRow arrayRow2 = arrayRowArr[i7];
                SolverVariable solverVariable2 = arrayRow2.mVariable;
                if (solverVariable2.mDefinitionId == i7) {
                    solverVariable2.mDefinitionId = i6;
                }
                arrayRowArr[i6] = arrayRow2;
                i6 = i7;
            }
            this.mNumRows = i5 - 1;
        }
        SolverVariable solverVariable3 = arrayRow.mVariable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.mConstantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.mOptimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.mArrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i5 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i5 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i5];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i5++;
        }
        cache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow != null) {
                arrayRow.mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i5) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.mDefinitionId == -1) {
            float f6 = i5;
            solverVariable.setFinalValue(this, f6);
            for (int i6 = 0; i6 < this.mVariablesID + 1; i6++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i6];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.mSynonymDelta + f6);
                }
            }
            return;
        }
        int i7 = solverVariable.mDefinitionId;
        if (i7 != -1) {
            ArrayRow arrayRow = this.mRows[i7];
            if (arrayRow.mIsSimpleDefinition) {
                arrayRow.mConstantValue = i5;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
                arrayRow.mConstantValue = i5;
                return;
            } else {
                ArrayRow arrayRowCreateRow = createRow();
                arrayRowCreateRow.createRowEquals(solverVariable, i5);
                addConstraint(arrayRowCreateRow);
                return;
            }
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowDefinition(solverVariable, i5);
        addConstraint(arrayRowCreateRow2);
    }
}
