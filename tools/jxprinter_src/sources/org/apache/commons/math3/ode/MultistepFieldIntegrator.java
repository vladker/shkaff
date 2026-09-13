package org.apache.commons.math3.ode;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeFieldIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853FieldIntegrator;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MultistepFieldIntegrator<T extends RealFieldElement<T>> extends AdaptiveStepsizeFieldIntegrator<T> {
    private double exp;
    private double maxGrowth;
    private double minReduction;
    private final int nSteps;
    protected Array2DRowFieldMatrix<T> nordsieck;
    private double safety;
    protected T[] scaled;
    private FirstOrderFieldIntegrator<T> starter;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        public InitializationCompletedMarkerException() {
            super((Throwable) null);
        }
    }

    public MultistepFieldIntegrator(Field<T> field, String str, int i5, int i6, double d, double d6, double d7, double d8) {
        super(field, str, d, d6, d7, d8);
        if (i5 < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, Integer.valueOf(i5), 2, true);
        }
        this.starter = new DormandPrince853FieldIntegrator(field, d, d6, d7, d8);
        this.nSteps = i5;
        this.exp = (-1.0d) / ((double) i6);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    public T computeStepGrowShrinkFactor(T t6) {
        return (T) MathUtils.min((RealFieldElement) ((RealFieldElement) t6.getField().getZero()).add(this.maxGrowth), MathUtils.max((RealFieldElement) ((RealFieldElement) t6.getField().getZero()).add(this.minReduction), (RealFieldElement) ((RealFieldElement) t6.pow(this.exp)).multiply(this.safety)));
    }

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public int getNSteps() {
        return this.nSteps;
    }

    public double getSafety() {
        return this.safety;
    }

    public FirstOrderFieldIntegrator<T> getStarterIntegrator() {
        return this.starter;
    }

    public abstract Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T t6, T[] tArr, T[][] tArr2, T[][] tArr3);

    public void rescale(T t6) {
        RealFieldElement realFieldElement = (RealFieldElement) t6.divide(getStepSize());
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = this.scaled;
            if (i5 >= fieldElementArr.length) {
                break;
            }
            fieldElementArr[i5] = (RealFieldElement) fieldElementArr[i5].multiply(realFieldElement);
            i5++;
        }
        RealFieldElement realFieldElement2 = realFieldElement;
        for (RealFieldElement[] realFieldElementArr : (RealFieldElement[][]) this.nordsieck.getDataRef()) {
            realFieldElement2 = (RealFieldElement) realFieldElement2.multiply(realFieldElement);
            for (int i6 = 0; i6 < realFieldElementArr.length; i6++) {
                realFieldElementArr[i6] = (RealFieldElement) realFieldElementArr[i6].multiply(realFieldElement2);
            }
        }
        setStepSize(t6);
    }

    public void setMaxGrowth(double d) {
        this.maxGrowth = d;
    }

    public void setMinReduction(double d) {
        this.minReduction = d;
    }

    public void setSafety(double d) {
        this.safety = d;
    }

    public void setStarterIntegrator(FirstOrderFieldIntegrator<T> firstOrderFieldIntegrator) {
        this.starter = firstOrderFieldIntegrator;
    }

    public void start(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6) {
        this.starter.clearEventHandlers();
        this.starter.clearStepHandlers();
        this.starter.addStepHandler(new FieldNordsieckInitializer(fieldExpandableODE.getMapper(), (this.nSteps + 3) / 2));
        try {
            this.starter.integrate(fieldExpandableODE, fieldODEState, t6);
            throw new MathIllegalStateException(LocalizedFormats.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);
        } catch (InitializationCompletedMarkerException unused) {
            getEvaluationsCounter().increment(this.starter.getEvaluations());
            this.starter.clearStepHandlers();
        }
    }

    public MultistepFieldIntegrator(Field<T> field, String str, int i5, int i6, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, str, d, d6, dArr, dArr2);
        this.starter = new DormandPrince853FieldIntegrator(field, d, d6, dArr, dArr2);
        this.nSteps = i5;
        this.exp = (-1.0d) / ((double) i6);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FieldNordsieckInitializer implements FieldStepHandler<T> {
        private int count = 0;
        private final FieldEquationsMapper<T> mapper;
        private FieldODEStateAndDerivative<T> savedStart;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final T[] f6825t;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final T[][] f6826y;
        private final T[][] yDot;

        public FieldNordsieckInitializer(FieldEquationsMapper<T> fieldEquationsMapper, int i5) {
            this.mapper = fieldEquationsMapper;
            this.f6825t = (T[]) ((RealFieldElement[]) MathArrays.buildArray(MultistepFieldIntegrator.this.getField(), i5));
            this.f6826y = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(MultistepFieldIntegrator.this.getField(), i5, -1));
            this.yDot = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(MultistepFieldIntegrator.this.getField(), i5, -1));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
        public void handleStep(FieldStepInterpolator<T> fieldStepInterpolator, boolean z6) {
            if (this.count == 0) {
                FieldODEStateAndDerivative<T> previousState = fieldStepInterpolator.getPreviousState();
                this.savedStart = previousState;
                this.f6825t[this.count] = previousState.getTime();
                ((T[][]) this.f6826y)[this.count] = this.mapper.mapState(previousState);
                ((T[][]) this.yDot)[this.count] = this.mapper.mapDerivative(previousState);
            }
            this.count++;
            FieldODEStateAndDerivative<T> currentState = fieldStepInterpolator.getCurrentState();
            this.f6825t[this.count] = currentState.getTime();
            ((T[][]) this.f6826y)[this.count] = this.mapper.mapState(currentState);
            ((T[][]) this.yDot)[this.count] = this.mapper.mapDerivative(currentState);
            int i5 = this.count;
            T[] tArr = this.f6825t;
            if (i5 != tArr.length - 1) {
                return;
            }
            MultistepFieldIntegrator.this.setStepSize((RealFieldElement) ((RealFieldElement) tArr[tArr.length - 1].subtract(tArr[0])).divide(this.f6825t.length - 1));
            MultistepFieldIntegrator multistepFieldIntegrator = MultistepFieldIntegrator.this;
            multistepFieldIntegrator.scaled = (T[]) ((RealFieldElement[]) MathArrays.buildArray(multistepFieldIntegrator.getField(), this.yDot[0].length));
            int i6 = 0;
            while (true) {
                MultistepFieldIntegrator multistepFieldIntegrator2 = MultistepFieldIntegrator.this;
                RealFieldElement[] realFieldElementArr = (T[]) multistepFieldIntegrator2.scaled;
                if (i6 >= realFieldElementArr.length) {
                    multistepFieldIntegrator2.nordsieck = multistepFieldIntegrator2.initializeHighOrderDerivatives(multistepFieldIntegrator2.getStepSize(), this.f6825t, this.f6826y, this.yDot);
                    MultistepFieldIntegrator.this.setStepStart(this.savedStart);
                    throw new InitializationCompletedMarkerException();
                }
                realFieldElementArr[i6] = (RealFieldElement) this.yDot[0][i6].multiply(multistepFieldIntegrator2.getStepSize());
                i6++;
            }
        }

        @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
        public void init(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T t6) {
        }
    }
}
