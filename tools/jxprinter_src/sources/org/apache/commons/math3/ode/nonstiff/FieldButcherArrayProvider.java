package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldButcherArrayProvider<T extends RealFieldElement<T>> {
    T[][] getA();

    T[] getB();

    T[] getC();
}
