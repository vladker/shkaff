package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Logit;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MultivariateFunctionMappingAdapter implements MultivariateFunction {
    private final MultivariateFunction bounded;
    private final Mapper[] mappers;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LowerBoundMapper implements Mapper {
        private final double lower;

        public LowerBoundMapper(double d) {
            this.lower = d;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double d) {
            return FastMath.log(d - this.lower);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double d) {
            return FastMath.exp(d) + this.lower;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LowerUpperBoundMapper implements Mapper {
        private final UnivariateFunction boundingFunction;
        private final UnivariateFunction unboundingFunction;

        public LowerUpperBoundMapper(double d, double d6) {
            this.boundingFunction = new Sigmoid(d, d6);
            this.unboundingFunction = new Logit(d, d6);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double d) {
            return this.unboundingFunction.value(d);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double d) {
            return this.boundingFunction.value(d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Mapper {
        double boundedToUnbounded(double d);

        double unboundedToBounded(double d);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UpperBoundMapper implements Mapper {
        private final double upper;

        public UpperBoundMapper(double d) {
            this.upper = d;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double d) {
            return -FastMath.log(this.upper - d);
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double d) {
            return this.upper - FastMath.exp(-d);
        }
    }

    public MultivariateFunctionMappingAdapter(MultivariateFunction multivariateFunction, double[] dArr, double[] dArr2) {
        MathUtils.checkNotNull(dArr);
        MathUtils.checkNotNull(dArr2);
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (dArr2[i5] < dArr[i5]) {
                throw new NumberIsTooSmallException(Double.valueOf(dArr2[i5]), Double.valueOf(dArr[i5]), true);
            }
        }
        this.bounded = multivariateFunction;
        this.mappers = new Mapper[dArr.length];
        for (int i6 = 0; i6 < this.mappers.length; i6++) {
            if (Double.isInfinite(dArr[i6])) {
                if (Double.isInfinite(dArr2[i6])) {
                    this.mappers[i6] = new NoBoundsMapper();
                } else {
                    this.mappers[i6] = new UpperBoundMapper(dArr2[i6]);
                }
            } else if (Double.isInfinite(dArr2[i6])) {
                this.mappers[i6] = new LowerBoundMapper(dArr[i6]);
            } else {
                this.mappers[i6] = new LowerUpperBoundMapper(dArr[i6], dArr2[i6]);
            }
        }
    }

    public double[] boundedToUnbounded(double[] dArr) {
        double[] dArr2 = new double[this.mappers.length];
        int i5 = 0;
        while (true) {
            Mapper[] mapperArr = this.mappers;
            if (i5 >= mapperArr.length) {
                return dArr2;
            }
            dArr2[i5] = mapperArr[i5].boundedToUnbounded(dArr[i5]);
            i5++;
        }
    }

    public double[] unboundedToBounded(double[] dArr) {
        double[] dArr2 = new double[this.mappers.length];
        int i5 = 0;
        while (true) {
            Mapper[] mapperArr = this.mappers;
            if (i5 >= mapperArr.length) {
                return dArr2;
            }
            dArr2[i5] = mapperArr[i5].unboundedToBounded(dArr[i5]);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] dArr) {
        return this.bounded.value(unboundedToBounded(dArr));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NoBoundsMapper implements Mapper {
        private NoBoundsMapper() {
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double boundedToUnbounded(double d) {
            return d;
        }

        @Override // org.apache.commons.math3.optim.nonlinear.scalar.MultivariateFunctionMappingAdapter.Mapper
        public double unboundedToBounded(double d) {
            return d;
        }
    }
}
