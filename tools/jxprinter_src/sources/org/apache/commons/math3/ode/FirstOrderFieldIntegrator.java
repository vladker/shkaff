package org.apache.commons.math3.ode;

import java.util.Collection;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver;
import org.apache.commons.math3.ode.events.FieldEventHandler;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FirstOrderFieldIntegrator<T extends RealFieldElement<T>> {
    void addEventHandler(FieldEventHandler<T> fieldEventHandler, double d, double d6, int i5);

    void addEventHandler(FieldEventHandler<T> fieldEventHandler, double d, double d6, int i5, BracketedRealFieldUnivariateSolver<T> bracketedRealFieldUnivariateSolver);

    void addStepHandler(FieldStepHandler<T> fieldStepHandler);

    void clearEventHandlers();

    void clearStepHandlers();

    T getCurrentSignedStepsize();

    FieldODEStateAndDerivative<T> getCurrentStepStart();

    int getEvaluations();

    Collection<FieldEventHandler<T>> getEventHandlers();

    int getMaxEvaluations();

    String getName();

    Collection<FieldStepHandler<T>> getStepHandlers();

    FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6);

    void setMaxEvaluations(int i5);
}
