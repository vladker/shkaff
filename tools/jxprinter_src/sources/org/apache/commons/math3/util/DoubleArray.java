package org.apache.commons.math3.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface DoubleArray {
    void addElement(double d);

    double addElementRolling(double d);

    void addElements(double[] dArr);

    void clear();

    double getElement(int i5);

    double[] getElements();

    int getNumElements();

    void setElement(int i5, double d);
}
