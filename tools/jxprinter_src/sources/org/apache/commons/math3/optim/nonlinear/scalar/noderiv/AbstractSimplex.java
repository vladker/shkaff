package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSimplex implements OptimizationData {
    private final int dimension;
    private PointValuePair[] simplex;
    private double[][] startConfiguration;

    public AbstractSimplex(int i5) {
        this(i5, 1.0d);
    }

    private static double[] createHypercubeSteps(int i5, double d) {
        double[] dArr = new double[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = d;
        }
        return dArr;
    }

    public void build(double[] dArr) {
        int i5 = this.dimension;
        if (i5 != dArr.length) {
            throw new DimensionMismatchException(this.dimension, dArr.length);
        }
        PointValuePair[] pointValuePairArr = new PointValuePair[i5 + 1];
        this.simplex = pointValuePairArr;
        pointValuePairArr[0] = new PointValuePair(dArr, Double.NaN);
        int i6 = 0;
        while (true) {
            int i7 = this.dimension;
            if (i6 >= i7) {
                return;
            }
            double[] dArr2 = this.startConfiguration[i6];
            double[] dArr3 = new double[i7];
            for (int i8 = 0; i8 < this.dimension; i8++) {
                dArr3[i8] = dArr[i8] + dArr2[i8];
            }
            i6++;
            this.simplex[i6] = new PointValuePair(dArr3, Double.NaN);
        }
    }

    public void evaluate(MultivariateFunction multivariateFunction, Comparator<PointValuePair> comparator) {
        int i5 = 0;
        while (true) {
            PointValuePair[] pointValuePairArr = this.simplex;
            if (i5 >= pointValuePairArr.length) {
                Arrays.sort(pointValuePairArr, comparator);
                return;
            }
            PointValuePair pointValuePair = pointValuePairArr[i5];
            double[] pointRef = pointValuePair.getPointRef();
            if (Double.isNaN(pointValuePair.getValue().doubleValue())) {
                this.simplex[i5] = new PointValuePair(pointRef, multivariateFunction.value(pointRef), false);
            }
            i5++;
        }
    }

    public int getDimension() {
        return this.dimension;
    }

    public PointValuePair getPoint(int i5) {
        if (i5 >= 0) {
            PointValuePair[] pointValuePairArr = this.simplex;
            if (i5 < pointValuePairArr.length) {
                return pointValuePairArr[i5];
            }
        }
        throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.simplex.length - 1));
    }

    public PointValuePair[] getPoints() {
        PointValuePair[] pointValuePairArr = this.simplex;
        PointValuePair[] pointValuePairArr2 = new PointValuePair[pointValuePairArr.length];
        System.arraycopy(pointValuePairArr, 0, pointValuePairArr2, 0, pointValuePairArr.length);
        return pointValuePairArr2;
    }

    public int getSize() {
        return this.simplex.length;
    }

    public abstract void iterate(MultivariateFunction multivariateFunction, Comparator<PointValuePair> comparator);

    public void replaceWorstPoint(PointValuePair pointValuePair, Comparator<PointValuePair> comparator) {
        int i5 = 0;
        while (true) {
            int i6 = this.dimension;
            if (i5 >= i6) {
                this.simplex[i6] = pointValuePair;
                return;
            }
            if (comparator.compare(this.simplex[i5], pointValuePair) > 0) {
                PointValuePair[] pointValuePairArr = this.simplex;
                PointValuePair pointValuePair2 = pointValuePairArr[i5];
                pointValuePairArr[i5] = pointValuePair;
                pointValuePair = pointValuePair2;
            }
            i5++;
        }
    }

    public void setPoint(int i5, PointValuePair pointValuePair) {
        if (i5 >= 0) {
            PointValuePair[] pointValuePairArr = this.simplex;
            if (i5 < pointValuePairArr.length) {
                pointValuePairArr[i5] = pointValuePair;
                return;
            }
        }
        throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.simplex.length - 1));
    }

    public void setPoints(PointValuePair[] pointValuePairArr) {
        if (pointValuePairArr.length != this.simplex.length) {
            throw new DimensionMismatchException(pointValuePairArr.length, this.simplex.length);
        }
        this.simplex = pointValuePairArr;
    }

    public AbstractSimplex(int i5, double d) {
        this(createHypercubeSteps(i5, d));
    }

    public AbstractSimplex(double[] dArr) {
        int i5;
        if (dArr != null) {
            if (dArr.length != 0) {
                int length = dArr.length;
                this.dimension = length;
                this.startConfiguration = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
                int i6 = 0;
                while (i6 < this.dimension) {
                    double[] dArr2 = this.startConfiguration[i6];
                    int i7 = 0;
                    while (true) {
                        i5 = i6 + 1;
                        if (i7 < i5) {
                            if (dArr[i7] != 0.0d) {
                                i7++;
                                System.arraycopy(dArr, 0, dArr2, 0, i7);
                            } else {
                                throw new ZeroException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, new Object[0]);
                            }
                        }
                    }
                    i6 = i5;
                }
                return;
            }
            throw new ZeroException();
        }
        throw new NullArgumentException();
    }

    public AbstractSimplex(double[][] dArr) {
        if (dArr.length > 0) {
            int length = dArr.length - 1;
            this.dimension = length;
            this.startConfiguration = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            double[] dArr2 = dArr[0];
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double[] dArr3 = dArr[i5];
                if (dArr3.length != this.dimension) {
                    throw new DimensionMismatchException(dArr3.length, this.dimension);
                }
                for (int i6 = 0; i6 < i5; i6++) {
                    double[] dArr4 = dArr[i6];
                    int i7 = 0;
                    while (true) {
                        if (i7 >= this.dimension) {
                            throw new MathIllegalArgumentException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, Integer.valueOf(i5), Integer.valueOf(i6));
                        }
                        if (dArr3[i7] != dArr4[i7]) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
                if (i5 > 0) {
                    double[] dArr5 = this.startConfiguration[i5 - 1];
                    for (int i8 = 0; i8 < this.dimension; i8++) {
                        dArr5[i8] = dArr3[i8] - dArr2[i8];
                    }
                }
            }
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.SIMPLEX_NEED_ONE_POINT, Integer.valueOf(dArr.length));
    }
}
