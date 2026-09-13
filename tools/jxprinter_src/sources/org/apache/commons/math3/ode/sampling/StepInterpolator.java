package org.apache.commons.math3.ode.sampling;

import java.io.Externalizable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface StepInterpolator extends Externalizable {
    StepInterpolator copy();

    double getCurrentTime();

    double[] getInterpolatedDerivatives();

    double[] getInterpolatedSecondaryDerivatives(int i5);

    double[] getInterpolatedSecondaryState(int i5);

    double[] getInterpolatedState();

    double getInterpolatedTime();

    double getPreviousTime();

    boolean isForward();

    void setInterpolatedTime(double d);
}
