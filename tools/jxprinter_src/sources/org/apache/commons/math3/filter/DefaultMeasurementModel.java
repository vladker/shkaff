package org.apache.commons.math3.filter;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultMeasurementModel implements MeasurementModel {
    private RealMatrix measurementMatrix;
    private RealMatrix measurementNoise;

    public DefaultMeasurementModel(double[][] dArr, double[][] dArr2) {
        this(new Array2DRowRealMatrix(dArr), new Array2DRowRealMatrix(dArr2));
    }

    @Override // org.apache.commons.math3.filter.MeasurementModel
    public RealMatrix getMeasurementMatrix() {
        return this.measurementMatrix;
    }

    @Override // org.apache.commons.math3.filter.MeasurementModel
    public RealMatrix getMeasurementNoise() {
        return this.measurementNoise;
    }

    public DefaultMeasurementModel(RealMatrix realMatrix, RealMatrix realMatrix2) {
        this.measurementMatrix = realMatrix;
        this.measurementNoise = realMatrix2;
    }
}
