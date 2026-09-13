package org.apache.commons.math3.optimization.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LinearConstraint implements Serializable {
    private static final long serialVersionUID = -764632794033034092L;
    private final transient RealVector coefficients;
    private final Relationship relationship;
    private final double value;

    public LinearConstraint(double[] dArr, Relationship relationship, double d) {
        this(new ArrayRealVector(dArr), relationship, d);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        MatrixUtils.deserializeRealVector(this, "coefficients", objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        MatrixUtils.serializeRealVector(this.coefficients, objectOutputStream);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LinearConstraint) {
            LinearConstraint linearConstraint = (LinearConstraint) obj;
            if (this.relationship == linearConstraint.relationship && this.value == linearConstraint.value && this.coefficients.equals(linearConstraint.coefficients)) {
                return true;
            }
        }
        return false;
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public Relationship getRelationship() {
        return this.relationship;
    }

    public double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.relationship.hashCode() ^ Double.valueOf(this.value).hashCode()) ^ this.coefficients.hashCode();
    }

    public LinearConstraint(RealVector realVector, Relationship relationship, double d) {
        this.coefficients = realVector;
        this.relationship = relationship;
        this.value = d;
    }

    public LinearConstraint(double[] dArr, double d, Relationship relationship, double[] dArr2, double d6) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr3[i5] = dArr[i5] - dArr2[i5];
        }
        this.coefficients = new ArrayRealVector(dArr3, false);
        this.relationship = relationship;
        this.value = d6 - d;
    }

    public LinearConstraint(RealVector realVector, double d, Relationship relationship, RealVector realVector2, double d6) {
        this.coefficients = realVector.subtract(realVector2);
        this.relationship = relationship;
        this.value = d6 - d;
    }
}
