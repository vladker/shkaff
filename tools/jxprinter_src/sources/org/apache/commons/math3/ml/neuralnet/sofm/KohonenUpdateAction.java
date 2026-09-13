package org.apache.commons.math3.ml.neuralnet.sofm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.ml.neuralnet.MapUtils;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.UpdateAction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KohonenUpdateAction implements UpdateAction {
    private final DistanceMeasure distance;
    private final LearningFactorFunction learningFactor;
    private final NeighbourhoodSizeFunction neighbourhoodSize;
    private final AtomicLong numberOfCalls = new AtomicLong(0);

    public KohonenUpdateAction(DistanceMeasure distanceMeasure, LearningFactorFunction learningFactorFunction, NeighbourhoodSizeFunction neighbourhoodSizeFunction) {
        this.distance = distanceMeasure;
        this.learningFactor = learningFactorFunction;
        this.neighbourhoodSize = neighbourhoodSizeFunction;
    }

    private boolean attemptNeuronUpdate(Neuron neuron, double[] dArr, double d) {
        double[] features = neuron.getFeatures();
        return neuron.compareAndSetFeatures(features, computeFeatures(features, dArr, d));
    }

    private double[] computeFeatures(double[] dArr, double[] dArr2, double d) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(dArr, false);
        return new ArrayRealVector(dArr2, false).subtract((RealVector) arrayRealVector).mapMultiplyToSelf(d).add(arrayRealVector).toArray();
    }

    private Neuron findAndUpdateBestNeuron(Network network, double[] dArr, double d) {
        Neuron neuronFindBest;
        do {
            neuronFindBest = MapUtils.findBest(dArr, network, this.distance);
        } while (!attemptNeuronUpdate(neuronFindBest, dArr, d));
        return neuronFindBest;
    }

    private void updateNeighbouringNeuron(Neuron neuron, double[] dArr, double d) {
        while (!attemptNeuronUpdate(neuron, dArr, d)) {
        }
    }

    public long getNumberOfCalls() {
        return this.numberOfCalls.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.apache.commons.math3.ml.neuralnet.Network] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection] */
    @Override // org.apache.commons.math3.ml.neuralnet.UpdateAction
    public void update(Network network, double[] dArr) {
        long jIncrementAndGet = this.numberOfCalls.incrementAndGet() - 1;
        double dValue = this.learningFactor.value(jIncrementAndGet);
        Neuron neuronFindAndUpdateBestNeuron = findAndUpdateBestNeuron(network, dArr, dValue);
        int iValue = this.neighbourhoodSize.value(jIncrementAndGet);
        Gaussian gaussian = new Gaussian(dValue, 0.0d, iValue);
        if (iValue > 0) {
            ?? hashSet = new HashSet();
            hashSet.add(neuronFindAndUpdateBestNeuron);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(neuronFindAndUpdateBestNeuron);
            int i5 = 1;
            do {
                hashSet = network.getNeighbours(hashSet, hashSet2);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    updateNeighbouringNeuron((Neuron) it.next(), dArr, gaussian.value(i5));
                }
                hashSet2.addAll(hashSet);
                i5++;
            } while (i5 <= iValue);
        }
    }
}
