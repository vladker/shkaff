package org.apache.commons.math3.ml.neuralnet.oned;

import java.io.ObjectInputStream;
import java.io.Serializable;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.ml.neuralnet.FeatureInitializer;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NeuronString implements Serializable {
    private static final long serialVersionUID = 1;
    private final long[] identifiers;
    private final Network network;
    private final int size;
    private final boolean wrap;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130226;
        private final double[][] featuresList;
        private final boolean wrap;

        public SerializationProxy(boolean z6, double[][] dArr) {
            this.wrap = z6;
            this.featuresList = dArr;
        }

        private Object readResolve() {
            return new NeuronString(this.wrap, this.featuresList);
        }
    }

    public NeuronString(boolean z6, double[][] dArr) {
        int length = dArr.length;
        this.size = length;
        if (length < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(length), 2, true);
        }
        this.wrap = z6;
        this.network = new Network(0L, dArr[0].length);
        this.identifiers = new long[length];
        for (int i5 = 0; i5 < this.size; i5++) {
            this.identifiers[i5] = this.network.createNeuron(dArr[i5]);
        }
        createLinks();
    }

    private void createLinks() {
        int i5;
        int i6 = 0;
        while (true) {
            i5 = this.size;
            if (i6 >= i5 - 1) {
                break;
            }
            Network network = this.network;
            Neuron neuron = network.getNeuron(i6);
            i6++;
            network.addLink(neuron, this.network.getNeuron(i6));
        }
        for (int i7 = i5 - 1; i7 > 0; i7--) {
            Network network2 = this.network;
            network2.addLink(network2.getNeuron(i7), this.network.getNeuron(i7 - 1));
        }
        if (this.wrap) {
            Network network3 = this.network;
            network3.addLink(network3.getNeuron(0L), this.network.getNeuron(this.size - 1));
            Network network4 = this.network;
            network4.addLink(network4.getNeuron(this.size - 1), this.network.getNeuron(0L));
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        double[][] dArr = new double[this.size][];
        for (int i5 = 0; i5 < this.size; i5++) {
            dArr[i5] = getFeatures(i5);
        }
        return new SerializationProxy(this.wrap, dArr);
    }

    public double[] getFeatures(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.size - 1));
        }
        return this.network.getNeuron(this.identifiers[i5]).getFeatures();
    }

    public Network getNetwork() {
        return this.network;
    }

    public int getSize() {
        return this.size;
    }

    public NeuronString(int i5, boolean z6, FeatureInitializer[] featureInitializerArr) {
        if (i5 >= 2) {
            this.size = i5;
            this.wrap = z6;
            this.identifiers = new long[i5];
            int length = featureInitializerArr.length;
            this.network = new Network(0L, length);
            for (int i6 = 0; i6 < i5; i6++) {
                double[] dArr = new double[length];
                for (int i7 = 0; i7 < length; i7++) {
                    dArr[i7] = featureInitializerArr[i7].value();
                }
                this.identifiers[i6] = this.network.createNeuron(dArr);
            }
            createLinks();
            return;
        }
        throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
    }
}
