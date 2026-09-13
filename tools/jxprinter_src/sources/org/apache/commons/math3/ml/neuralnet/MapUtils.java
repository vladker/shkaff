package org.apache.commons.math3.ml.neuralnet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MapUtils {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PairNeuronDouble {
        static final Comparator<PairNeuronDouble> COMPARATOR = new Comparator<PairNeuronDouble>() { // from class: org.apache.commons.math3.ml.neuralnet.MapUtils.PairNeuronDouble.1
            @Override // java.util.Comparator
            public int compare(PairNeuronDouble pairNeuronDouble, PairNeuronDouble pairNeuronDouble2) {
                return Double.compare(pairNeuronDouble.value, pairNeuronDouble2.value);
            }
        };
        private final Neuron neuron;
        private final double value;

        public PairNeuronDouble(Neuron neuron, double d) {
            this.neuron = neuron;
            this.value = d;
        }

        public Neuron getNeuron() {
            return this.neuron;
        }
    }

    private MapUtils() {
    }

    public static int[][] computeHitHistogram(Iterable<double[]> iterable, NeuronSquareMesh2D neuronSquareMesh2D, DistanceMeasure distanceMeasure) {
        HashMap map = new HashMap();
        Network network = neuronSquareMesh2D.getNetwork();
        Iterator<double[]> it = iterable.iterator();
        while (it.hasNext()) {
            Neuron neuronFindBest = findBest(it.next(), network, distanceMeasure);
            Integer num = (Integer) map.get(neuronFindBest);
            if (num == null) {
                map.put(neuronFindBest, 1);
            } else {
                map.put(neuronFindBest, Integer.valueOf(num.intValue() + 1));
            }
        }
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, numberOfRows, numberOfColumns);
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                Integer num2 = (Integer) map.get(neuronSquareMesh2D.getNeuron(i5, i6));
                if (num2 == null) {
                    iArr[i5][i6] = 0;
                } else {
                    iArr[i5][i6] = num2.intValue();
                }
            }
        }
        return iArr;
    }

    public static double computeQuantizationError(Iterable<double[]> iterable, Iterable<Neuron> iterable2, DistanceMeasure distanceMeasure) {
        double dCompute = 0.0d;
        int i5 = 0;
        for (double[] dArr : iterable) {
            i5++;
            dCompute += distanceMeasure.compute(dArr, findBest(dArr, iterable2, distanceMeasure).getFeatures());
        }
        if (i5 != 0) {
            return dCompute / ((double) i5);
        }
        throw new NoDataException();
    }

    public static double computeTopographicError(Iterable<double[]> iterable, Network network, DistanceMeasure distanceMeasure) {
        Iterator<double[]> it = iterable.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            i5++;
            Pair<Neuron, Neuron> pairFindBestAndSecondBest = findBestAndSecondBest(it.next(), network, distanceMeasure);
            if (!network.getNeighbours(pairFindBestAndSecondBest.getFirst()).contains(pairFindBestAndSecondBest.getSecond())) {
                i6++;
            }
        }
        if (i5 != 0) {
            return ((double) i6) / ((double) i5);
        }
        throw new NoDataException();
    }

    public static double[][] computeU(NeuronSquareMesh2D neuronSquareMesh2D, DistanceMeasure distanceMeasure) {
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
                    dCompute += distanceMeasure.compute(features, it.next().getFeatures());
                }
                dArr[i5][i6] = dCompute / ((double) i7);
            }
        }
        return dArr;
    }

    public static Neuron findBest(double[] dArr, Iterable<Neuron> iterable, DistanceMeasure distanceMeasure) {
        Neuron neuron = null;
        double d = Double.POSITIVE_INFINITY;
        for (Neuron neuron2 : iterable) {
            double dCompute = distanceMeasure.compute(neuron2.getFeatures(), dArr);
            if (dCompute < d) {
                neuron = neuron2;
                d = dCompute;
            }
        }
        return neuron;
    }

    public static Pair<Neuron, Neuron> findBestAndSecondBest(double[] dArr, Iterable<Neuron> iterable, DistanceMeasure distanceMeasure) {
        Neuron[] neuronArr = {null, null};
        double[] dArr2 = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
        for (Neuron neuron : iterable) {
            double dCompute = distanceMeasure.compute(neuron.getFeatures(), dArr);
            double d = dArr2[0];
            if (dCompute < d) {
                dArr2[1] = d;
                neuronArr[1] = neuronArr[0];
                dArr2[0] = dCompute;
                neuronArr[0] = neuron;
            } else if (dCompute < dArr2[1]) {
                dArr2[1] = dCompute;
                neuronArr[1] = neuron;
            }
        }
        return new Pair<>(neuronArr[0], neuronArr[1]);
    }

    public static Neuron[] sort(double[] dArr, Iterable<Neuron> iterable, DistanceMeasure distanceMeasure) {
        ArrayList arrayList = new ArrayList();
        for (Neuron neuron : iterable) {
            arrayList.add(new PairNeuronDouble(neuron, distanceMeasure.compute(neuron.getFeatures(), dArr)));
        }
        Collections.sort(arrayList, PairNeuronDouble.COMPARATOR);
        int size = arrayList.size();
        Neuron[] neuronArr = new Neuron[size];
        for (int i5 = 0; i5 < size; i5++) {
            neuronArr[i5] = ((PairNeuronDouble) arrayList.get(i5)).getNeuron();
        }
        return neuronArr;
    }
}
