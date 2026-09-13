package org.apache.commons.math3.optim.linear;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class SimplexTableau implements Serializable {
    private static final String NEGATIVE_VAR_COLUMN_LABEL = "x-";
    private static final long serialVersionUID = -1369660067587938365L;
    private int[] basicRows;
    private int[] basicVariables;
    private final List<String> columnLabels;
    private final List<LinearConstraint> constraints;
    private final double epsilon;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearObjectiveFunction f6868f;
    private final int maxUlps;
    private int numArtificialVariables;
    private final int numDecisionVariables;
    private final int numSlackVariables;
    private final boolean restrictToNonNegative;
    private transient Array2DRowRealMatrix tableau;

    public SimplexTableau(LinearObjectiveFunction linearObjectiveFunction, Collection<LinearConstraint> collection, GoalType goalType, boolean z6, double d) {
        this(linearObjectiveFunction, collection, goalType, z6, d, 10);
    }

    private void copyArray(double[] dArr, double[] dArr2) {
        System.arraycopy(dArr, 0, dArr2, getNumObjectiveFunctions(), dArr.length);
    }

    private Integer findBasicRow(int i5) {
        Integer numValueOf = null;
        for (int i6 = 0; i6 < getHeight(); i6++) {
            double entry = getEntry(i6, i5);
            if (Precision.equals(entry, 1.0d, this.maxUlps) && numValueOf == null) {
                numValueOf = Integer.valueOf(i6);
            } else if (!Precision.equals(entry, 0.0d, this.maxUlps)) {
                return null;
            }
        }
        return numValueOf;
    }

    private int getConstraintTypeCounts(Relationship relationship) {
        Iterator<LinearConstraint> it = this.constraints.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().getRelationship() == relationship) {
                i5++;
            }
        }
        return i5;
    }

    public static double getInvertedCoefficientSum(RealVector realVector) {
        double d = 0.0d;
        for (double d6 : realVector.toArray()) {
            d -= d6;
        }
        return d;
    }

    private void initializeBasicVariables(int i5) {
        this.basicVariables = new int[getWidth() - 1];
        this.basicRows = new int[getHeight()];
        Arrays.fill(this.basicVariables, -1);
        while (i5 < getWidth() - 1) {
            Integer numFindBasicRow = findBasicRow(i5);
            if (numFindBasicRow != null) {
                this.basicVariables[i5] = numFindBasicRow.intValue();
                this.basicRows[numFindBasicRow.intValue()] = i5;
            }
            i5++;
        }
    }

    private LinearConstraint normalize(LinearConstraint linearConstraint) {
        return linearConstraint.getValue() < 0.0d ? new LinearConstraint(linearConstraint.getCoefficients().mapMultiply(-1.0d), linearConstraint.getRelationship().oppositeRelationship(), linearConstraint.getValue() * (-1.0d)) : new LinearConstraint(linearConstraint.getCoefficients(), linearConstraint.getRelationship(), linearConstraint.getValue());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        MatrixUtils.deserializeRealMatrix(this, "tableau", objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MatrixUtils.serializeRealMatrix(this.tableau, objectOutputStream);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f7  */
    public Array2DRowRealMatrix createTableau(boolean z6) {
        long j6;
        int numObjectiveFunctions = this.numDecisionVariables + this.numSlackVariables + this.numArtificialVariables + getNumObjectiveFunctions();
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(this.constraints.size() + getNumObjectiveFunctions(), numObjectiveFunctions + 1);
        if (getNumObjectiveFunctions() == 2) {
            array2DRowRealMatrix.setEntry(0, 0, -1.0d);
        }
        int i5 = getNumObjectiveFunctions() == 1 ? 0 : 1;
        array2DRowRealMatrix.setEntry(i5, i5, z6 ? 1.0d : -1.0d);
        RealVector coefficients = this.f6868f.getCoefficients();
        if (z6) {
            coefficients = coefficients.mapMultiply(-1.0d);
        }
        copyArray(coefficients.toArray(), array2DRowRealMatrix.getDataRef()[i5]);
        double constantTerm = this.f6868f.getConstantTerm();
        if (!z6) {
            constantTerm *= -1.0d;
        }
        array2DRowRealMatrix.setEntry(i5, numObjectiveFunctions, constantTerm);
        if (!this.restrictToNonNegative) {
            array2DRowRealMatrix.setEntry(i5, getSlackVariableOffset() - 1, getInvertedCoefficientSum(coefficients));
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < this.constraints.size(); i8++) {
            LinearConstraint linearConstraint = this.constraints.get(i8);
            int numObjectiveFunctions2 = getNumObjectiveFunctions() + i8;
            copyArray(linearConstraint.getCoefficients().toArray(), array2DRowRealMatrix.getDataRef()[numObjectiveFunctions2]);
            if (!this.restrictToNonNegative) {
                array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getSlackVariableOffset() - 1, getInvertedCoefficientSum(linearConstraint.getCoefficients()));
            }
            array2DRowRealMatrix.setEntry(numObjectiveFunctions2, numObjectiveFunctions, linearConstraint.getValue());
            if (linearConstraint.getRelationship() == Relationship.LEQ) {
                array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getSlackVariableOffset() + i6, 1.0d);
                i6++;
            } else {
                if (linearConstraint.getRelationship() == Relationship.GEQ) {
                    j6 = -4616189618054758400L;
                    array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getSlackVariableOffset() + i6, -1.0d);
                    i6++;
                }
                if (linearConstraint.getRelationship() != Relationship.EQ || linearConstraint.getRelationship() == Relationship.GEQ) {
                    array2DRowRealMatrix.setEntry(0, getArtificialVariableOffset() + i7, 1.0d);
                    array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getArtificialVariableOffset() + i7, 1.0d);
                    array2DRowRealMatrix.setRowVector(0, array2DRowRealMatrix.getRowVector(0).subtract(array2DRowRealMatrix.getRowVector(numObjectiveFunctions2)));
                    i7++;
                }
            }
            j6 = -4616189618054758400L;
            if (linearConstraint.getRelationship() != Relationship.EQ) {
                array2DRowRealMatrix.setEntry(0, getArtificialVariableOffset() + i7, 1.0d);
                array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getArtificialVariableOffset() + i7, 1.0d);
                array2DRowRealMatrix.setRowVector(0, array2DRowRealMatrix.getRowVector(0).subtract(array2DRowRealMatrix.getRowVector(numObjectiveFunctions2)));
                i7++;
            } else {
                array2DRowRealMatrix.setEntry(0, getArtificialVariableOffset() + i7, 1.0d);
                array2DRowRealMatrix.setEntry(numObjectiveFunctions2, getArtificialVariableOffset() + i7, 1.0d);
                array2DRowRealMatrix.setRowVector(0, array2DRowRealMatrix.getRowVector(0).subtract(array2DRowRealMatrix.getRowVector(numObjectiveFunctions2)));
                i7++;
            }
        }
        return array2DRowRealMatrix;
    }

    public void divideRow(int i5, double d) {
        double[] row = getRow(i5);
        for (int i6 = 0; i6 < getWidth(); i6++) {
            row[i6] = row[i6] / d;
        }
    }

    public void dropPhase1Objective() {
        if (getNumObjectiveFunctions() == 1) {
            return;
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(0);
        for (int numObjectiveFunctions = getNumObjectiveFunctions(); numObjectiveFunctions < getArtificialVariableOffset(); numObjectiveFunctions++) {
            if (Precision.compareTo(getEntry(0, numObjectiveFunctions), 0.0d, this.epsilon) > 0) {
                treeSet.add(Integer.valueOf(numObjectiveFunctions));
            }
        }
        for (int i5 = 0; i5 < getNumArtificialVariables(); i5++) {
            int artificialVariableOffset = getArtificialVariableOffset() + i5;
            if (getBasicRow(artificialVariableOffset) == null) {
                treeSet.add(Integer.valueOf(artificialVariableOffset));
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, getHeight() - 1, getWidth() - treeSet.size());
        for (int i6 = 1; i6 < getHeight(); i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < getWidth(); i8++) {
                if (!treeSet.contains(Integer.valueOf(i8))) {
                    dArr[i6 - 1][i7] = getEntry(i6, i8);
                    i7++;
                }
            }
        }
        Integer[] numArr = (Integer[]) treeSet.toArray(new Integer[treeSet.size()]);
        for (int length = numArr.length - 1; length >= 0; length--) {
            this.columnLabels.remove(numArr[length].intValue());
        }
        this.tableau = new Array2DRowRealMatrix(dArr);
        this.numArtificialVariables = 0;
        initializeBasicVariables(getNumObjectiveFunctions());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimplexTableau) {
            SimplexTableau simplexTableau = (SimplexTableau) obj;
            if (this.restrictToNonNegative == simplexTableau.restrictToNonNegative && this.numDecisionVariables == simplexTableau.numDecisionVariables && this.numSlackVariables == simplexTableau.numSlackVariables && this.numArtificialVariables == simplexTableau.numArtificialVariables && this.epsilon == simplexTableau.epsilon && this.maxUlps == simplexTableau.maxUlps && this.f6868f.equals(simplexTableau.f6868f) && this.constraints.equals(simplexTableau.constraints) && this.tableau.equals(simplexTableau.tableau)) {
                return true;
            }
        }
        return false;
    }

    public final int getArtificialVariableOffset() {
        return getNumObjectiveFunctions() + this.numDecisionVariables + this.numSlackVariables;
    }

    public Integer getBasicRow(int i5) {
        int i6 = this.basicVariables[i5];
        if (i6 == -1) {
            return null;
        }
        return Integer.valueOf(i6);
    }

    public int getBasicVariable(int i5) {
        return this.basicRows[i5];
    }

    public final double[][] getData() {
        return this.tableau.getData();
    }

    public final double getEntry(int i5, int i6) {
        return this.tableau.getEntry(i5, i6);
    }

    public final int getHeight() {
        return this.tableau.getRowDimension();
    }

    public final int getNumArtificialVariables() {
        return this.numArtificialVariables;
    }

    public final int getNumDecisionVariables() {
        return this.numDecisionVariables;
    }

    public final int getNumObjectiveFunctions() {
        return this.numArtificialVariables > 0 ? 2 : 1;
    }

    public final int getNumSlackVariables() {
        return this.numSlackVariables;
    }

    public final int getOriginalNumDecisionVariables() {
        return this.f6868f.getCoefficients().getDimension();
    }

    public final int getRhsOffset() {
        return getWidth() - 1;
    }

    public final double[] getRow(int i5) {
        return this.tableau.getDataRef()[i5];
    }

    public final int getSlackVariableOffset() {
        return getNumObjectiveFunctions() + this.numDecisionVariables;
    }

    public PointValuePair getSolution() {
        int iIndexOf = this.columnLabels.indexOf(NEGATIVE_VAR_COLUMN_LABEL);
        Integer basicRow = iIndexOf > 0 ? getBasicRow(iIndexOf) : null;
        double entry = basicRow == null ? 0.0d : getEntry(basicRow.intValue(), getRhsOffset());
        HashSet hashSet = new HashSet();
        int originalNumDecisionVariables = getOriginalNumDecisionVariables();
        double[] dArr = new double[originalNumDecisionVariables];
        for (int i5 = 0; i5 < originalNumDecisionVariables; i5++) {
            int iIndexOf2 = this.columnLabels.indexOf("x" + i5);
            if (iIndexOf2 < 0) {
                dArr[i5] = 0.0d;
            } else {
                Integer basicRow2 = getBasicRow(iIndexOf2);
                if (basicRow2 != null && basicRow2.intValue() == 0) {
                    dArr[i5] = 0.0d;
                } else if (hashSet.contains(basicRow2)) {
                    dArr[i5] = 0.0d - (this.restrictToNonNegative ? 0.0d : entry);
                } else {
                    hashSet.add(basicRow2);
                    dArr[i5] = (basicRow2 == null ? 0.0d : getEntry(basicRow2.intValue(), getRhsOffset())) - (this.restrictToNonNegative ? 0.0d : entry);
                }
            }
        }
        return new PointValuePair(dArr, this.f6868f.value(dArr));
    }

    public final int getWidth() {
        return this.tableau.getColumnDimension();
    }

    public int hashCode() {
        return (((((((Boolean.valueOf(this.restrictToNonNegative).hashCode() ^ this.numDecisionVariables) ^ this.numSlackVariables) ^ this.numArtificialVariables) ^ Double.valueOf(this.epsilon).hashCode()) ^ this.maxUlps) ^ this.f6868f.hashCode()) ^ this.constraints.hashCode()) ^ this.tableau.hashCode();
    }

    public void initializeColumnLabels() {
        if (getNumObjectiveFunctions() == 2) {
            this.columnLabels.add(ExifInterface.LONGITUDE_WEST);
        }
        this.columnLabels.add("Z");
        for (int i5 = 0; i5 < getOriginalNumDecisionVariables(); i5++) {
            this.columnLabels.add("x" + i5);
        }
        if (!this.restrictToNonNegative) {
            this.columnLabels.add(NEGATIVE_VAR_COLUMN_LABEL);
        }
        for (int i6 = 0; i6 < getNumSlackVariables(); i6++) {
            this.columnLabels.add("s" + i6);
        }
        for (int i7 = 0; i7 < getNumArtificialVariables(); i7++) {
            this.columnLabels.add("a" + i7);
        }
        this.columnLabels.add("RHS");
    }

    public boolean isOptimal() {
        double[] row = getRow(0);
        int rhsOffset = getRhsOffset();
        for (int numObjectiveFunctions = getNumObjectiveFunctions(); numObjectiveFunctions < rhsOffset; numObjectiveFunctions++) {
            if (Precision.compareTo(row[numObjectiveFunctions], 0.0d, this.epsilon) < 0) {
                return false;
            }
        }
        return true;
    }

    public List<LinearConstraint> normalizeConstraints(Collection<LinearConstraint> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<LinearConstraint> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(normalize(it.next()));
        }
        return arrayList;
    }

    public void performRowOperations(int i5, int i6) {
        divideRow(i6, getEntry(i6, i5));
        for (int i7 = 0; i7 < getHeight(); i7++) {
            if (i7 != i6) {
                double entry = getEntry(i7, i5);
                if (entry != 0.0d) {
                    subtractRow(i7, i6, entry);
                }
            }
        }
        int basicVariable = getBasicVariable(i6);
        int[] iArr = this.basicVariables;
        iArr[basicVariable] = -1;
        iArr[i5] = i6;
        this.basicRows[i6] = i5;
    }

    public final void setEntry(int i5, int i6, double d) {
        this.tableau.setEntry(i5, i6, d);
    }

    public void subtractRow(int i5, int i6, double d) {
        double[] row = getRow(i5);
        double[] row2 = getRow(i6);
        for (int i7 = 0; i7 < getWidth(); i7++) {
            row[i7] = row[i7] - (row2[i7] * d);
        }
    }

    public SimplexTableau(LinearObjectiveFunction linearObjectiveFunction, Collection<LinearConstraint> collection, GoalType goalType, boolean z6, double d, int i5) {
        this.columnLabels = new ArrayList();
        this.f6868f = linearObjectiveFunction;
        this.constraints = normalizeConstraints(collection);
        this.restrictToNonNegative = z6;
        this.epsilon = d;
        this.maxUlps = i5;
        this.numDecisionVariables = linearObjectiveFunction.getCoefficients().getDimension() + (!z6 ? 1 : 0);
        int constraintTypeCounts = getConstraintTypeCounts(Relationship.LEQ);
        Relationship relationship = Relationship.GEQ;
        this.numSlackVariables = constraintTypeCounts + getConstraintTypeCounts(relationship);
        this.numArtificialVariables = getConstraintTypeCounts(Relationship.EQ) + getConstraintTypeCounts(relationship);
        this.tableau = createTableau(goalType == GoalType.MAXIMIZE);
        initializeBasicVariables(getSlackVariableOffset());
        initializeColumnLabels();
    }
}
