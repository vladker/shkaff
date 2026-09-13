package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldEventHandler<T extends RealFieldElement<T>> {
    Action eventOccurred(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, boolean z6);

    T g(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative);

    void init(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T t6);

    FieldODEState<T> resetState(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative);
}
