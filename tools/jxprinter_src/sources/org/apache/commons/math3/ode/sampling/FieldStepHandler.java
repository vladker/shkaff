package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldStepHandler<T extends RealFieldElement<T>> {
    void handleStep(FieldStepInterpolator<T> fieldStepInterpolator, boolean z6);

    void init(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T t6);
}
