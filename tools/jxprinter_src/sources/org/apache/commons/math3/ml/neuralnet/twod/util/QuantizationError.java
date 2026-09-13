package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class QuantizationError implements MapDataVisualization {
    private final DistanceMeasure distance;

    public QuantizationError(DistanceMeasure distanceMeasure) {
        this.distance = distanceMeasure;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D neuronSquareMesh2D, Iterable<double[]> iterable) {
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        LocationFinder locationFinder = new LocationFinder(neuronSquareMesh2D);
        int i5 = 1;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, numberOfRows, numberOfColumns);
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, numberOfRows, numberOfColumns);
        for (double[] dArr2 : iterable) {
            Neuron neuronFindBest = MapUtils.findBest(dArr2, neuronSquareMesh2D, this.distance);
            LocationFinder.Location location = locationFinder.getLocation(neuronFindBest);
            int row = location.getRow();
            int column = location.getColumn();
            int[] iArr2 = iArr[row];
            iArr2[column] = iArr2[column] + i5;
            double[] dArr3 = dArr[row];
            dArr3[column] = this.distance.compute(dArr2, neuronFindBest.getFeatures()) + dArr3[column];
            i5 = 1;
        }
        for (int i6 = 0; i6 < numberOfRows; i6++) {
            for (int i7 = 0; i7 < numberOfColumns; i7++) {
                int i8 = iArr[i6][i7];
                if (i8 != 0) {
                    double[] dArr4 = dArr[i6];
                    dArr4[i7] = dArr4[i7] / ((double) i8);
                }
            }
        }
        return dArr;
    }
}
