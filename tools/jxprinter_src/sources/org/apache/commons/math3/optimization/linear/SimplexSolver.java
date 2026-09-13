package org.apache.commons.math3.optimization.linear;

import java.util.ArrayList;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SimplexSolver extends AbstractLinearOptimizer {
    private static final double DEFAULT_EPSILON = 1.0E-6d;
    private static final int DEFAULT_ULPS = 10;
    private final double epsilon;
    private final int maxUlps;

    public SimplexSolver() {
        this(1.0E-6d, 10);
    }

    private Integer getPivotColumn(SimplexTableau simplexTableau) {
        double d = 0.0d;
        Integer numValueOf = null;
        for (int numObjectiveFunctions = simplexTableau.getNumObjectiveFunctions(); numObjectiveFunctions < simplexTableau.getWidth() - 1; numObjectiveFunctions++) {
            double entry = simplexTableau.getEntry(0, numObjectiveFunctions);
            if (entry < d) {
                numValueOf = Integer.valueOf(numObjectiveFunctions);
                d = entry;
            }
        }
        return numValueOf;
    }

    private Integer getPivotRow(SimplexTableau simplexTableau, int i5) {
        ArrayList arrayList = new ArrayList();
        double d = Double.MAX_VALUE;
        for (int numObjectiveFunctions = simplexTableau.getNumObjectiveFunctions(); numObjectiveFunctions < simplexTableau.getHeight(); numObjectiveFunctions++) {
            double entry = simplexTableau.getEntry(numObjectiveFunctions, simplexTableau.getWidth() - 1);
            double entry2 = simplexTableau.getEntry(numObjectiveFunctions, i5);
            if (Precision.compareTo(entry2, 0.0d, this.maxUlps) > 0) {
                double d6 = entry / entry2;
                int iCompare = Double.compare(d6, d);
                if (iCompare == 0) {
                    arrayList.add(Integer.valueOf(numObjectiveFunctions));
                } else if (iCompare < 0) {
                    arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf(numObjectiveFunctions));
                    d = d6;
                }
            }
        }
        Integer num = null;
        if (arrayList.size() == 0) {
            return null;
        }
        int i6 = 0;
        if (arrayList.size() > 1) {
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
            if (getIterations() < getMaxIterations() / 2) {
                int width = simplexTableau.getWidth();
                int numObjectiveFunctions2 = simplexTableau.getNumObjectiveFunctions();
                int width2 = simplexTableau.getWidth() - 1;
                int size2 = arrayList.size();
                while (i6 < size2) {
                    Object obj2 = arrayList.get(i6);
                    i6++;
                    Integer num3 = (Integer) obj2;
                    for (int i9 = numObjectiveFunctions2; i9 < width2 && !num3.equals(num); i9++) {
                        Integer basicRow = simplexTableau.getBasicRow(i9);
                        if (basicRow != null && basicRow.equals(num3) && i9 < width) {
                            num = num3;
                            width = i9;
                        }
                    }
                }
                return num;
            }
        }
        return (Integer) arrayList.get(0);
    }

    public void doIteration(SimplexTableau simplexTableau) {
        incrementIterationsCounter();
        Integer pivotColumn = getPivotColumn(simplexTableau);
        Integer pivotRow = getPivotRow(simplexTableau, pivotColumn.intValue());
        if (pivotRow == null) {
            throw new UnboundedSolutionException();
        }
        simplexTableau.divideRow(pivotRow.intValue(), simplexTableau.getEntry(pivotRow.intValue(), pivotColumn.intValue()));
        for (int i5 = 0; i5 < simplexTableau.getHeight(); i5++) {
            if (i5 != pivotRow.intValue()) {
                simplexTableau.subtractRow(i5, pivotRow.intValue(), simplexTableau.getEntry(i5, pivotColumn.intValue()));
            }
        }
    }

    @Override // org.apache.commons.math3.optimization.linear.AbstractLinearOptimizer
    public PointValuePair doOptimize() {
        SimplexTableau simplexTableau = new SimplexTableau(getFunction(), getConstraints(), getGoalType(), restrictToNonNegative(), this.epsilon, this.maxUlps);
        solvePhase1(simplexTableau);
        simplexTableau.dropPhase1Objective();
        while (!simplexTableau.isOptimal()) {
            doIteration(simplexTableau);
        }
        return simplexTableau.getSolution();
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

    public SimplexSolver(double d, int i5) {
        this.epsilon = d;
        this.maxUlps = i5;
    }
}
