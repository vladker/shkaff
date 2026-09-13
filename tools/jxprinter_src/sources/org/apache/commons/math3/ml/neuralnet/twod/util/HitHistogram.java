package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HitHistogram implements MapDataVisualization {
    private final DistanceMeasure distance;
    private final boolean normalizeCount;

    public HitHistogram(boolean z6, DistanceMeasure distanceMeasure) {
        this.normalizeCount = z6;
        this.distance = distanceMeasure;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapDataVisualization
    public double[][] computeImage(NeuronSquareMesh2D neuronSquareMesh2D, Iterable<double[]> iterable) {
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        LocationFinder locationFinder = new LocationFinder(neuronSquareMesh2D);
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, numberOfRows, numberOfColumns);
        Iterator<double[]> it = iterable.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            LocationFinder.Location location = locationFinder.getLocation(MapUtils.findBest(it.next(), neuronSquareMesh2D, this.distance));
            int row = location.getRow();
            int column = location.getColumn();
            double[] dArr2 = dArr[row];
            dArr2[column] = dArr2[column] + 1.0d;
            i5++;
        }
        if (this.normalizeCount) {
            for (int i6 = 0; i6 < numberOfRows; i6++) {
                for (int i7 = 0; i7 < numberOfColumns; i7++) {
                    double[] dArr3 = dArr[i6];
                    dArr3[i7] = dArr3[i7] / ((double) i5);
                }
            }
        }
        return dArr;
    }
}
