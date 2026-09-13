package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.analysis.solvers.BracketingNthOrderBrentSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.events.EventState;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractIntegrator implements FirstOrderIntegrator {
    private IntegerSequence.Incrementor evaluations;
    private Collection<EventState> eventsStates;
    private transient ExpandableStatefulODE expandable;
    protected boolean isLastStep;
    private final String name;
    protected boolean resetOccurred;
    private boolean statesInitialized;
    protected Collection<StepHandler> stepHandlers;
    protected double stepSize;
    protected double stepStart;

    public AbstractIntegrator(String str) {
        this.name = str;
        this.stepHandlers = new ArrayList();
        this.stepStart = Double.NaN;
        this.stepSize = Double.NaN;
        this.eventsStates = new ArrayList();
        this.statesInitialized = false;
        this.evaluations = IntegerSequence.Incrementor.create().withMaximalCount(Integer.MAX_VALUE);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x018e A[LOOP:8: B:74:0x0188->B:76:0x018e, LOOP_END] */
    public double acceptStep(AbstractStepInterpolator abstractStepInterpolator, double[] dArr, double[] dArr2, double d) {
        boolean z6;
        boolean z7;
        Iterator<StepHandler> it;
        double globalPreviousTime = abstractStepInterpolator.getGlobalPreviousTime();
        double globalCurrentTime = abstractStepInterpolator.getGlobalCurrentTime();
        if (!this.statesInitialized) {
            Iterator<EventState> it2 = this.eventsStates.iterator();
            while (it2.hasNext()) {
                it2.next().reinitializeBegin(abstractStepInterpolator);
            }
            this.statesInitialized = true;
        }
        final int i5 = abstractStepInterpolator.isForward() ? 1 : -1;
        TreeSet treeSet = new TreeSet(new Comparator<EventState>() { // from class: org.apache.commons.math3.ode.AbstractIntegrator.1
            @Override // java.util.Comparator
            public int compare(EventState eventState, EventState eventState2) {
                return Double.compare(eventState.getEventTime(), eventState2.getEventTime()) * i5;
            }
        });
        for (EventState eventState : this.eventsStates) {
            if (eventState.evaluateStep(abstractStepInterpolator)) {
                treeSet.add(eventState);
            }
        }
        while (!treeSet.isEmpty()) {
            Iterator it3 = treeSet.iterator();
            EventState eventState2 = (EventState) it3.next();
            it3.remove();
            double eventTime = eventState2.getEventTime();
            abstractStepInterpolator.setSoftPreviousTime(globalPreviousTime);
            abstractStepInterpolator.setSoftCurrentTime(eventTime);
            abstractStepInterpolator.setInterpolatedTime(eventTime);
            double[] dArr3 = new double[dArr.length];
            this.expandable.getPrimaryMapper().insertEquationData(abstractStepInterpolator.getInterpolatedState(), dArr3);
            EquationsMapper[] secondaryMappers = this.expandable.getSecondaryMappers();
            int length = secondaryMappers.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                secondaryMappers[i6].insertEquationData(abstractStepInterpolator.getInterpolatedSecondaryState(i7), dArr3);
                i6++;
                i7++;
            }
            for (EventState eventState3 : this.eventsStates) {
                eventState3.stepAccepted(eventTime, dArr3);
                this.isLastStep = this.isLastStep || eventState3.stop();
            }
            Iterator<StepHandler> it4 = this.stepHandlers.iterator();
            while (it4.hasNext()) {
                it4.next().handleStep(abstractStepInterpolator, this.isLastStep);
            }
            if (this.isLastStep) {
                System.arraycopy(dArr3, 0, dArr, 0, dArr.length);
                return eventTime;
            }
            this.resetOccurred = false;
            if (eventState2.reset(eventTime, dArr3)) {
                abstractStepInterpolator.setInterpolatedTime(eventTime);
                System.arraycopy(dArr3, 0, dArr, 0, dArr.length);
                computeDerivatives(eventTime, dArr, dArr2);
                this.resetOccurred = true;
                return eventTime;
            }
            abstractStepInterpolator.setSoftPreviousTime(eventTime);
            abstractStepInterpolator.setSoftCurrentTime(globalCurrentTime);
            if (eventState2.evaluateStep(abstractStepInterpolator)) {
                treeSet.add(eventState2);
            }
            globalPreviousTime = eventTime;
        }
        abstractStepInterpolator.setInterpolatedTime(globalCurrentTime);
        double[] dArr4 = new double[dArr.length];
        this.expandable.getPrimaryMapper().insertEquationData(abstractStepInterpolator.getInterpolatedState(), dArr4);
        EquationsMapper[] secondaryMappers2 = this.expandable.getSecondaryMappers();
        int length2 = secondaryMappers2.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length2) {
            secondaryMappers2[i8].insertEquationData(abstractStepInterpolator.getInterpolatedSecondaryState(i9), dArr4);
            i8++;
            i9++;
        }
        for (EventState eventState4 : this.eventsStates) {
            eventState4.stepAccepted(globalCurrentTime, dArr4);
            this.isLastStep = this.isLastStep || eventState4.stop();
        }
        if (!this.isLastStep) {
            z6 = true;
            if (!Precision.equals(globalCurrentTime, d, 1)) {
                z7 = false;
            }
            this.isLastStep = z7;
            it = this.stepHandlers.iterator();
            while (it.hasNext()) {
                it.next().handleStep(abstractStepInterpolator, this.isLastStep);
            }
            return globalCurrentTime;
        }
        z6 = true;
        z7 = z6;
        this.isLastStep = z7;
        it = this.stepHandlers.iterator();
        while (it.hasNext()) {
            it.next().handleStep(abstractStepInterpolator, this.isLastStep);
        }
        return globalCurrentTime;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler eventHandler, double d, double d6, int i5) {
        addEventHandler(eventHandler, d, d6, i5, new BracketingNthOrderBrentSolver(d6, 5));
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addStepHandler(StepHandler stepHandler) {
        this.stepHandlers.add(stepHandler);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void clearEventHandlers() {
        this.eventsStates.clear();
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void clearStepHandlers() {
        this.stepHandlers.clear();
    }

    public void computeDerivatives(double d, double[] dArr, double[] dArr2) {
        this.evaluations.increment();
        this.expandable.computeDerivatives(d, dArr, dArr2);
    }

    public IntegerSequence.Incrementor getCounter() {
        return this.evaluations;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentSignedStepsize() {
        return this.stepSize;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Deprecated
    public Incrementor getEvaluationsCounter() {
        return Incrementor.wrap(this.evaluations);
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public Collection<EventHandler> getEventHandlers() {
        ArrayList arrayList = new ArrayList(this.eventsStates.size());
        Iterator<EventState> it = this.eventsStates.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getEventHandler());
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    public ExpandableStatefulODE getExpandable() {
        return this.expandable;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public String getName() {
        return this.name;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public Collection<StepHandler> getStepHandlers() {
        return Collections.unmodifiableCollection(this.stepHandlers);
    }

    public void initIntegration(double d, double[] dArr, double d6) {
        this.evaluations = this.evaluations.withStart(0);
        for (EventState eventState : this.eventsStates) {
            eventState.setExpandable(this.expandable);
            eventState.getEventHandler().init(d, dArr, d6);
        }
        Iterator<StepHandler> it = this.stepHandlers.iterator();
        while (it.hasNext()) {
            it.next().init(d, dArr, d6);
        }
        setStateInitialized(false);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderIntegrator
    public double integrate(FirstOrderDifferentialEquations firstOrderDifferentialEquations, double d, double[] dArr, double d6, double[] dArr2) {
        if (dArr.length != firstOrderDifferentialEquations.getDimension()) {
            throw new DimensionMismatchException(dArr.length, firstOrderDifferentialEquations.getDimension());
        }
        if (dArr2.length != firstOrderDifferentialEquations.getDimension()) {
            throw new DimensionMismatchException(dArr2.length, firstOrderDifferentialEquations.getDimension());
        }
        ExpandableStatefulODE expandableStatefulODE = new ExpandableStatefulODE(firstOrderDifferentialEquations);
        expandableStatefulODE.setTime(d);
        expandableStatefulODE.setPrimaryState(dArr);
        integrate(expandableStatefulODE, d6);
        System.arraycopy(expandableStatefulODE.getPrimaryState(), 0, dArr2, 0, dArr2.length);
        return expandableStatefulODE.getTime();
    }

    public abstract void integrate(ExpandableStatefulODE expandableStatefulODE, double d);

    public void sanityChecks(ExpandableStatefulODE expandableStatefulODE, double d) {
        double dUlp = FastMath.ulp(FastMath.max(FastMath.abs(expandableStatefulODE.getTime()), FastMath.abs(d))) * 1000.0d;
        double dAbs = FastMath.abs(expandableStatefulODE.getTime() - d);
        if (dAbs <= dUlp) {
            throw new NumberIsTooSmallException(LocalizedFormats.TOO_SMALL_INTEGRATION_INTERVAL, Double.valueOf(dAbs), Double.valueOf(dUlp), false);
        }
    }

    public void setEquations(ExpandableStatefulODE expandableStatefulODE) {
        this.expandable = expandableStatefulODE;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void setMaxEvaluations(int i5) {
        IntegerSequence.Incrementor incrementor = this.evaluations;
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        this.evaluations = incrementor.withMaximalCount(i5);
    }

    public void setStateInitialized(boolean z6) {
        this.statesInitialized = z6;
    }

    @Override // org.apache.commons.math3.ode.ODEIntegrator
    public void addEventHandler(EventHandler eventHandler, double d, double d6, int i5, UnivariateSolver univariateSolver) {
        this.eventsStates.add(new EventState(eventHandler, d, d6, i5, univariateSolver));
    }

    public AbstractIntegrator() {
        this(null);
    }
}
