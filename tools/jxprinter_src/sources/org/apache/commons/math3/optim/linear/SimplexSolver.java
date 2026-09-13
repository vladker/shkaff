package org.apache.commons.math3.optim.linear;

import java.util.ArrayList;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimplexSolver extends LinearOptimizer {
    static final double DEFAULT_CUT_OFF = 1.0E-10d;
    private static final double DEFAULT_EPSILON = 1.0E-6d;
    static final int DEFAULT_ULPS = 10;
    private final double cutOff;
    private final double epsilon;
    private final int maxUlps;
    private PivotSelectionRule pivotSelection;
    private SolutionCallback solutionCallback;

    public SimplexSolver() {
        this(1.0E-6d, 10, 1.0E-10d);
    }

    private Integer getPivotColumn(SimplexTableau simplexTableau) {
        double d = 0.0d;
        Integer num = null;
        for (int numObjectiveFunctions = simplexTableau.getNumObjectiveFunctions(); numObjectiveFunctions < simplexTableau.getWidth() - 1; numObjectiveFunctions++) {
            double entry = simplexTableau.getEntry(0, numObjectiveFunctions);
            if (entry < d) {
                Integer numValueOf = Integer.valueOf(numObjectiveFunctions);
                if (this.pivotSelection == PivotSelectionRule.BLAND && isValidPivotColumn(simplexTableau, numObjectiveFunctions)) {
                    return numValueOf;
                }
                num = numValueOf;
                d = entry;
            }
        }
        return num;
    }

    private Integer getPivotRow(SimplexTableau simplexTableau, int i5) {
        ArrayList arrayList = new ArrayList();
        double d = Double.MAX_VALUE;
        for (int numObjectiveFunctions = simplexTableau.getNumObjectiveFunctions(); numObjectiveFunctions < simplexTableau.getHeight(); numObjectiveFunctions++) {
            double entry = simplexTableau.getEntry(numObjectiveFunctions, simplexTableau.getWidth() - 1);
            double entry2 = simplexTableau.getEntry(numObjectiveFunctions, i5);
            if (Precision.compareTo(entry2, 0.0d, this.cutOff) > 0) {
                double dAbs = FastMath.abs(entry / entry2);
                int iCompare = Double.compare(dAbs, d);
                if (iCompare == 0) {
                    arrayList.add(Integer.valueOf(numObjectiveFunctions));
                } else if (iCompare < 0) {
                    arrayList.clear();
                    arrayList.add(Integer.valueOf(numObjectiveFunctions));
                    d = dAbs;
                }
            }
        }
        Integer num = null;
        if (arrayList.size() == 0) {
            return null;
        }
        int i6 = 0;
        if (arrayList.size() <= 1) {
            return (Integer) arrayList.get(0);
        }
        if (simplexTableau.getNumArtificialVariables() > 0) {
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                Integer num2 = (Integer) obj;
                for (int i8 = 0; i8 < simplexTableau.getNumArtificialVariables(); i8++) {
                    int artificialVariableOffset = simplexTableau.getArtificialVariableOffset() + i8;
                    if (Precision.equals(simplexTableau.getEntry(num2.intValue(), artificialVariableOffset), 1.0d, this.maxUlps) && num2.equals(simplexTableau.getBasicRow(artificialVariableOffset))) {
                        return num2;
                    }
                }
            }
        }
        int width = simplexTableau.getWidth();
        int size2 = arrayList.size();
        while (i6 < size2) {
            Object obj2 = arrayList.get(i6);
            i6++;
            Integer num3 = (Integer) obj2;
            int basicVariable = simplexTableau.getBasicVariable(num3.intValue());
            if (basicVariable < width) {
                num = num3;
                width = basicVariable;
            }
        }
        return num;
    }

    private boolean isValidPivotColumn(SimplexTableau simplexTableau, int i5) {
        for (int numObjectiveFunctions = simplexTableau.getNumObjectiveFunctions(); numObjectiveFunctions < simplexTableau.getHeight(); numObjectiveFunctions++) {
            if (Precision.compareTo(simplexTableau.getEntry(numObjectiveFunctions, i5), 0.0d, this.cutOff) > 0) {
                return true;
            }
        }
        return false;
    }

    public void doIteration(SimplexTableau simplexTableau) {
        incrementIterationCount();
        Integer pivotColumn = getPivotColumn(simplexTableau);
        Integer pivotRow = getPivotRow(simplexTableau, pivotColumn.intValue());
        if (pivotRow == null) {
            throw new UnboundedSolutionException();
        }
        simplexTableau.performRowOperations(pivotColumn.intValue(), pivotRow.intValue());
    }

    @Override // org.apache.commons.math3.optim.linear.LinearOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public void parseOptimizationData(OptimizationData... optimizationDataArr) {
        super.parseOptimizationData(optimizationDataArr);
        this.solutionCallback = null;
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof SolutionCallback) {
                this.solutionCallback = (SolutionCallback) optimizationData;
            } else if (optimizationData instanceof PivotSelectionRule) {
                this.pivotSelection = (PivotSelectionRule) optimizationData;
            }
        }
    }

    public void solvePhase1(SimplexTableau simplexTableau) {
        if (simplexTableau.getNumArtificialVariables() == 0) {
            return;
        }
        while (!simplexTableau.isOptimal()) {
            doIteration(simplexTableau);
        }
        if (!Precision.equals(simplexTableau.getEntry(0, simplexTableau.getRhsOffset()), 0.0d, this.epsilon)) {
            throw new NoFeasibleSolutionException();
        }
    }

    public SimplexSolver(double d) {
        this(d, 10, 1.0E-10d);
    }

    @Override // org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair doOptimize() {
        SolutionCallback solutionCallback = this.solutionCallback;
        if (solutionCallback != null) {
            solutionCallback.setTableau(null);
        }
        SimplexTableau simplexTableau = new SimplexTableau(getFunction(), getConstraints(), getGoalType(), isRestrictedToNonNegative(), this.epsilon, this.maxUlps);
        solvePhase1(simplexTableau);
        simplexTableau.dropPhase1Objective();
        SolutionCallback solutionCallback2 = this.solutionCallback;
        if (solutionCallback2 != null) {
            solutionCallback2.setTableau(simplexTableau);
        }
        while (!simplexTableau.isOptimal()) {
            doIteration(simplexTableau);
        }
        PointValuePair solution = simplexTableau.getSolution();
        if (isRestrictedToNonNegative()) {
            for (double d : solution.getPoint()) {
                if (Precision.compareTo(d, 0.0d, this.epsilon) < 0) {
                    throw new NoFeasibleSolutionException();
                }
            }
        }
        return solution;
    }

    @Override // org.apache.commons.math3.optim.linear.LinearOptimizer, org.apache.commons.math3.optim.nonlinear.scalar.MultivariateOptimizer, org.apache.commons.math3.optim.BaseMultivariateOptimizer, org.apache.commons.math3.optim.BaseOptimizer
    public PointValuePair optimize(OptimizationData... optimizationDataArr) {
        return super.optimize(optimizationDataArr);
    }

    public SimplexSolver(double d, int i5) {
        this(d, i5, 1.0E-10d);
    }

    public SimplexSolver(double d, int i5, double d6) {
        this.epsilon = d;
        this.maxUlps = i5;
        this.cutOff = d6;
        this.pivotSelection = PivotSelectionRule.DANTZIG;
    }
}
