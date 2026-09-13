package org.apache.commons.math3.ml.neuralnet;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Network implements Iterable<Neuron>, Serializable {
    private static final long serialVersionUID = 20130207;
    private final int featureSize;
    private final AtomicLong nextId;
    private final ConcurrentHashMap<Long, Neuron> neuronMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Long, Set<Long>> linkMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NeuronIdentifierComparator implements Comparator<Neuron>, Serializable {
        private static final long serialVersionUID = 20130207;

        @Override // java.util.Comparator
        public int compare(Neuron neuron, Neuron neuron2) {
            long identifier = neuron.getIdentifier();
            long identifier2 = neuron2.getIdentifier();
            if (identifier < identifier2) {
                return -1;
            }
            return identifier > identifier2 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130207;
        private final int featureSize;
        private final long[][] neighbourIdList;
        private final Neuron[] neuronList;
        private final long nextId;

        public SerializationProxy(long j6, int i5, Neuron[] neuronArr, long[][] jArr) {
            this.nextId = j6;
            this.featureSize = i5;
            this.neuronList = neuronArr;
            this.neighbourIdList = jArr;
        }

        private Object readResolve() {
            return new Network(this.nextId, this.featureSize, this.neuronList, this.neighbourIdList);
        }
    }

    public Network(long j6, int i5, Neuron[] neuronArr, long[][] jArr) {
        int length = neuronArr.length;
        if (length != jArr.length) {
            throw new MathIllegalStateException();
        }
        for (Neuron neuron : neuronArr) {
            long identifier = neuron.getIdentifier();
            if (identifier >= j6) {
                throw new MathIllegalStateException();
            }
            this.neuronMap.put(Long.valueOf(identifier), neuron);
            this.linkMap.put(Long.valueOf(identifier), new HashSet());
        }
        for (int i6 = 0; i6 < length; i6++) {
            Set<Long> set = this.linkMap.get(Long.valueOf(neuronArr[i6].getIdentifier()));
            for (long j7 : jArr[i6]) {
                if (this.neuronMap.get(Long.valueOf(j7)) == null) {
                    throw new MathIllegalStateException();
                }
                addLinkToLinkSet(set, j7);
            }
        }
        this.nextId = new AtomicLong(j6);
        this.featureSize = i5;
    }

    private void addLinkToLinkSet(Set<Long> set, long j6) {
        set.add(Long.valueOf(j6));
    }

    private Long createNextId() {
        return Long.valueOf(this.nextId.getAndIncrement());
    }

    private void deleteLinkFromLinkSet(Set<Long> set, long j6) {
        set.remove(Long.valueOf(j6));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        Neuron[] neuronArr = (Neuron[]) this.neuronMap.values().toArray(new Neuron[0]);
        long[][] jArr = new long[neuronArr.length][];
        for (int i5 = 0; i5 < neuronArr.length; i5++) {
            Collection<Neuron> neighbours = getNeighbours(neuronArr[i5]);
            long[] jArr2 = new long[neighbours.size()];
            Iterator<Neuron> it = neighbours.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                jArr2[i6] = it.next().getIdentifier();
                i6++;
            }
            jArr[i5] = jArr2;
        }
        return new SerializationProxy(this.nextId.get(), this.featureSize, neuronArr, jArr);
    }

    public void addLink(Neuron neuron, Neuron neuron2) {
        long identifier = neuron.getIdentifier();
        long identifier2 = neuron2.getIdentifier();
        if (neuron != getNeuron(identifier)) {
            throw new NoSuchElementException(Long.toString(identifier));
        }
        if (neuron2 != getNeuron(identifier2)) {
            throw new NoSuchElementException(Long.toString(identifier2));
        }
        addLinkToLinkSet(this.linkMap.get(Long.valueOf(identifier)), identifier2);
    }

    public synchronized Network copy() {
        Network network;
        try {
            network = new Network(this.nextId.get(), this.featureSize);
            for (Map.Entry<Long, Neuron> entry : this.neuronMap.entrySet()) {
                network.neuronMap.put(entry.getKey(), entry.getValue().copy());
            }
            for (Map.Entry<Long, Set<Long>> entry2 : this.linkMap.entrySet()) {
                network.linkMap.put(entry2.getKey(), new HashSet(entry2.getValue()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return network;
    }

    public long createNeuron(double[] dArr) {
        if (dArr.length != this.featureSize) {
            throw new DimensionMismatchException(dArr.length, this.featureSize);
        }
        Long lCreateNextId = createNextId();
        long jLongValue = lCreateNextId.longValue();
        this.neuronMap.put(lCreateNextId, new Neuron(jLongValue, dArr));
        this.linkMap.put(lCreateNextId, new HashSet());
        return jLongValue;
    }

    public void deleteLink(Neuron neuron, Neuron neuron2) {
        long identifier = neuron.getIdentifier();
        long identifier2 = neuron2.getIdentifier();
        if (neuron != getNeuron(identifier)) {
            throw new NoSuchElementException(Long.toString(identifier));
        }
        if (neuron2 != getNeuron(identifier2)) {
            throw new NoSuchElementException(Long.toString(identifier2));
        }
        deleteLinkFromLinkSet(this.linkMap.get(Long.valueOf(identifier)), identifier2);
    }

    public void deleteNeuron(Neuron neuron) {
        Iterator<Neuron> it = getNeighbours(neuron).iterator();
        while (it.hasNext()) {
            deleteLink(it.next(), neuron);
        }
        this.neuronMap.remove(Long.valueOf(neuron.getIdentifier()));
    }

    public int getFeaturesSize() {
        return this.featureSize;
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> iterable) {
        return getNeighbours(iterable, (Iterable<Neuron>) null);
    }

    public Neuron getNeuron(long j6) {
        Neuron neuron = this.neuronMap.get(Long.valueOf(j6));
        if (neuron != null) {
            return neuron;
        }
        throw new NoSuchElementException(Long.toString(j6));
    }

    public Collection<Neuron> getNeurons(Comparator<Neuron> comparator) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.neuronMap.values());
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    @Override // java.lang.Iterable
    public Iterator<Neuron> iterator() {
        return this.neuronMap.values().iterator();
    }

    public Collection<Neuron> getNeighbours(Iterable<Neuron> iterable, Iterable<Neuron> iterable2) {
        HashSet hashSet = new HashSet();
        Iterator<Neuron> it = iterable.iterator();
        while (it.hasNext()) {
            hashSet.addAll(this.linkMap.get(Long.valueOf(it.next().getIdentifier())));
        }
        if (iterable2 != null) {
            Iterator<Neuron> it2 = iterable2.iterator();
            while (it2.hasNext()) {
                hashSet.remove(Long.valueOf(it2.next().getIdentifier()));
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            arrayList.add(getNeuron(((Long) it3.next()).longValue()));
        }
        return arrayList;
    }

    public Collection<Neuron> getNeighbours(Neuron neuron) {
        return getNeighbours(neuron, (Iterable<Neuron>) null);
    }

    public Collection<Neuron> getNeighbours(Neuron neuron, Iterable<Neuron> iterable) {
        Set<Long> set = this.linkMap.get(Long.valueOf(neuron.getIdentifier()));
        if (iterable != null) {
            Iterator<Neuron> it = iterable.iterator();
            while (it.hasNext()) {
                set.remove(Long.valueOf(it.next().getIdentifier()));
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList.add(getNeuron(it2.next().longValue()));
        }
        return arrayList;
    }

    public Network(long j6, int i5) {
        this.nextId = new AtomicLong(j6);
        this.featureSize = i5;
    }
}
