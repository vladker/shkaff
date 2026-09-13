package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnifiedDistanceMatrix implements MapVisualization {
    private final DistanceMeasure distance;
    private final boolean individualDistances;

    public UnifiedDistanceMatrix(boolean z6, DistanceMeasure distanceMeasure) {
        this.individualDistances = z6;
        this.distance = distanceMeasure;
    }

    private double[][] averageDistances(NeuronSquareMesh2D neuronSquareMesh2D) {
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, numberOfRows, numberOfColumns);
        Network network = neuronSquareMesh2D.getNetwork();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                Neuron neuron = neuronSquareMesh2D.getNeuron(i5, i6);
                Collection<Neuron> neighbours = network.getNeighbours(neuron);
                double[] features = neuron.getFeatures();
                Iterator<Neuron> it = neighbours.iterator();
                double dCompute = 0.0d;
                int i7 = 0;
                while (it.hasNext()) {
                    i7++;
                    dCompute += this.distance.compute(features, it.next().getFeatures());
                }
                dArr[i5][i6] = dCompute / ((double) i7);
            }
        }
        return dArr;
    }

    private double[][] individualDistances(NeuronSquareMesh2D neuronSquareMesh2D) {
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        boolean z6 = true;
        char c = 2;
        int i5 = 0;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (numberOfRows * 2) + 1, (numberOfColumns * 2) + 1);
        for (int i6 = 0; i6 < numberOfRows; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + 1;
            int i9 = i5;
            while (i9 < numberOfColumns) {
                int i10 = i9 * 2;
                int i11 = i10 + 1;
                double[] features = neuronSquareMesh2D.getNeuron(i6, i9).getFeatures();
                boolean z7 = z6;
                Neuron neuron = neuronSquareMesh2D.getNeuron(i6, i9, NeuronSquareMesh2D.HorizontalDirection.RIGHT, NeuronSquareMesh2D.VerticalDirection.CENTER);
                if (neuron != null) {
                    dArr[i8][i10 + 2] = this.distance.compute(features, neuron.getFeatures());
                }
                Neuron neuron2 = neuronSquareMesh2D.getNeuron(i6, i9, NeuronSquareMesh2D.HorizontalDirection.CENTER, NeuronSquareMesh2D.VerticalDirection.DOWN);
                if (neuron2 != null) {
                    dArr[i7 + 2][i11] = this.distance.compute(features, neuron2.getFeatures());
                }
                i9++;
                z6 = z7;
                i5 = i5;
            }
        }
        int i12 = i5;
        for (int i13 = i12; i13 < numberOfRows; i13++) {
            int i14 = i13 * 2;
            int i15 = i12;
            while (i15 < numberOfColumns) {
                int i16 = i15 * 2;
                Neuron neuron3 = neuronSquareMesh2D.getNeuron(i13, i15);
                NeuronSquareMesh2D.HorizontalDirection horizontalDirection = NeuronSquareMesh2D.HorizontalDirection.RIGHT;
                Neuron neuron4 = neuronSquareMesh2D.getNeuron(i13, i15, horizontalDirection, NeuronSquareMesh2D.VerticalDirection.CENTER);
                NeuronSquareMesh2D.HorizontalDirection horizontalDirection2 = NeuronSquareMesh2D.HorizontalDirection.CENTER;
                NeuronSquareMesh2D.VerticalDirection verticalDirection = NeuronSquareMesh2D.VerticalDirection.DOWN;
                Neuron neuron5 = neuronSquareMesh2D.getNeuron(i13, i15, horizontalDirection2, verticalDirection);
                Neuron neuron6 = neuronSquareMesh2D.getNeuron(i13, i15, horizontalDirection, verticalDirection);
                double dCompute = 0.0d;
                char c6 = c;
                double dCompute2 = neuron6 == null ? 0.0d : this.distance.compute(neuron3.getFeatures(), neuron6.getFeatures());
                if (neuron4 != null && neuron5 != null) {
                    dCompute = this.distance.compute(neuron4.getFeatures(), neuron5.getFeatures());
                }
                dArr[i14 + 2][i16 + 2] = (dCompute2 + dCompute) * 0.5d;
                i15++;
                c = c6;
            }
        }
        int length = dArr.length - 1;
        double[] dArr2 = dArr[length];
        dArr[i12] = dArr2;
        int length2 = dArr2.length - 1;
        for (int i17 = i12; i17 < length; i17++) {
            double[] dArr3 = dArr[i17];
            dArr3[i12] = dArr3[length2];
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.ml.neuralnet.twod.util.MapVisualization
    public double[][] computeImage(NeuronSquareMesh2D neuronSquareMesh2D) {
        return this.individualDistances ? individualDistances(neuronSquareMesh2D) : averageDistances(neuronSquareMesh2D);
    }
}
