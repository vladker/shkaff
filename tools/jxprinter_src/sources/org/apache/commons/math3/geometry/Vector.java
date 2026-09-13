package org.apache.commons.math3.geometry;

import java.text.NumberFormat;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Vector<S extends Space> extends Point<S> {
    Vector<S> add(double d, Vector<S> vector);

    Vector<S> add(Vector<S> vector);

    double distance(Vector<S> vector);

    double distance1(Vector<S> vector);

    double distanceInf(Vector<S> vector);

    double distanceSq(Vector<S> vector);

    double dotProduct(Vector<S> vector);

    double getNorm();

    double getNorm1();

    double getNormInf();

    double getNormSq();

    Vector<S> getZero();

    boolean isInfinite();

    Vector<S> negate();

    Vector<S> normalize();

    Vector<S> scalarMultiply(double d);

    Vector<S> subtract(double d, Vector<S> vector);

    Vector<S> subtract(Vector<S> vector);

    String toString(NumberFormat numberFormat);
}
