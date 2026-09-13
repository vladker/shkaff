package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldStepInterpolator<T extends RealFieldElement<T>> {
    FieldODEStateAndDerivative<T> getCurrentState();

    FieldODEStateAndDerivative<T> getInterpolatedState(T t6);

    FieldODEStateAndDerivative<T> getPreviousState();

    boolean isForward();
}
