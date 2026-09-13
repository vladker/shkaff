package org.apache.commons.math3.ml.neuralnet;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Neuron implements Serializable {
    private static final long serialVersionUID = 20130207;
    private final AtomicReference<double[]> features;
    private final long identifier;
    private final AtomicLong numberOfAttemptedUpdates = new AtomicLong(0);
    private final AtomicLong numberOfSuccessfulUpdates = new AtomicLong(0);
    private final int size;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130207;
        private final double[] features;
        private final long identifier;

        public SerializationProxy(long j6, double[] dArr) {
            this.identifier = j6;
            this.features = dArr;
        }

        private Object readResolve() {
            return new Neuron(this.identifier, this.features);
        }
    }

    public Neuron(long j6, double[] dArr) {
        this.identifier = j6;
        this.size = dArr.length;
        this.features = new AtomicReference<>(dArr.clone());
    }

    private boolean containSameValues(double[] dArr, double[] dArr2) {
        if (dArr2.length != this.size) {
            throw new DimensionMismatchException(dArr2.length, this.size);
        }
        for (int i5 = 0; i5 < this.size; i5++) {
            if (!Precision.equals(dArr[i5], dArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        return new SerializationProxy(this.identifier, this.features.get());
    }

    public boolean compareAndSetFeatures(double[] dArr, double[] dArr2) throws CloneNotSupportedException {
        if (dArr2.length != this.size) {
            throw new DimensionMismatchException(dArr2.length, this.size);
        }
        double[] dArr3 = this.features.get();
        if (!containSameValues(dArr3, dArr)) {
            return false;
        }
        this.numberOfAttemptedUpdates.incrementAndGet();
        AtomicReference<double[]> atomicReference = this.features;
        Object objClone = dArr2.clone();
        while (!atomicReference.compareAndSet(dArr3, (double[]) objClone)) {
            if (atomicReference.get() != dArr3) {
                return false;
            }
        }
        this.numberOfSuccessfulUpdates.incrementAndGet();
        return true;
    }

    public synchronized Neuron copy() {
        Neuron neuron;
        neuron = new Neuron(getIdentifier(), getFeatures());
        neuron.numberOfAttemptedUpdates.set(this.numberOfAttemptedUpdates.get());
        neuron.numberOfSuccessfulUpdates.set(this.numberOfSuccessfulUpdates.get());
        return neuron;
    }

    public double[] getFeatures() {
        return (double[]) this.features.get().clone();
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public long getNumberOfAttemptedUpdates() {
        return this.numberOfAttemptedUpdates.get();
    }

    public long getNumberOfSuccessfulUpdates() {
        return this.numberOfSuccessfulUpdates.get();
    }

    public int getSize() {
        return this.size;
    }
}
