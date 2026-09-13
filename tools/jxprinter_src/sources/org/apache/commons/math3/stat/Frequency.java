package org.apache.commons.math3.stat;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Frequency implements Serializable {
    private static final long serialVersionUID = -3845586908418844111L;
    private final SortedMap<Comparable<?>, Long> freqTable;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NaturalComparator<T extends Comparable<T>> implements Comparator<Comparable<T>>, Serializable {
        private static final long serialVersionUID = -3852193713161395148L;

        private NaturalComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Comparable<T> comparable, Comparable<T> comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public Frequency() {
        this.freqTable = new TreeMap();
    }

    public void addValue(Comparable<?> comparable) {
        incrementValue(comparable, 1L);
    }

    public void clear() {
        this.freqTable.clear();
    }

    public Iterator<Map.Entry<Comparable<?>, Long>> entrySetIterator() {
        return this.freqTable.entrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Frequency)) {
            return false;
        }
        Frequency frequency = (Frequency) obj;
        SortedMap<Comparable<?>, Long> sortedMap = this.freqTable;
        if (sortedMap == null) {
            if (frequency.freqTable != null) {
                return false;
            }
        } else if (!sortedMap.equals(frequency.freqTable)) {
            return false;
        }
        return true;
    }

    public long getCount(Comparable<?> comparable) {
        if (comparable instanceof Integer) {
            return getCount(((Integer) comparable).longValue());
        }
        try {
            Long l6 = this.freqTable.get(comparable);
            if (l6 != null) {
                return l6.longValue();
            }
            return 0L;
        } catch (ClassCastException unused) {
            return 0L;
        }
    }

    public long getCumFreq(Comparable<?> comparable) {
        if (getSumFreq() == 0) {
            return 0L;
        }
        if (comparable instanceof Integer) {
            return getCumFreq(((Integer) comparable).longValue());
        }
        Comparator<? super Comparable<?>> comparator = this.freqTable.comparator();
        if (comparator == null) {
            comparator = new NaturalComparator<>();
        }
        try {
            Long l6 = this.freqTable.get(comparable);
            long jLongValue = l6 != null ? l6.longValue() : 0L;
            if (comparator.compare(comparable, this.freqTable.firstKey()) < 0) {
                return 0L;
            }
            if (comparator.compare(comparable, this.freqTable.lastKey()) >= 0) {
                return getSumFreq();
            }
            Iterator<Comparable<?>> itValuesIterator = valuesIterator();
            while (itValuesIterator.hasNext()) {
                Comparable<?> next = itValuesIterator.next();
                if (comparator.compare(comparable, next) <= 0) {
                    break;
                }
                jLongValue += getCount(next);
            }
            return jLongValue;
        } catch (ClassCastException unused) {
            return 0L;
        }
    }

    public double getCumPct(Comparable<?> comparable) {
        long sumFreq = getSumFreq();
        if (sumFreq == 0) {
            return Double.NaN;
        }
        return getCumFreq(comparable) / sumFreq;
    }

    public List<Comparable<?>> getMode() {
        Iterator<Long> it = this.freqTable.values().iterator();
        long j6 = 0;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (jLongValue > j6) {
                j6 = jLongValue;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Comparable<?>, Long> entry : this.freqTable.entrySet()) {
            if (entry.getValue().longValue() == j6) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public double getPct(Comparable<?> comparable) {
        long sumFreq = getSumFreq();
        if (sumFreq == 0) {
            return Double.NaN;
        }
        return getCount(comparable) / sumFreq;
    }

    public long getSumFreq() {
        Iterator<Long> it = this.freqTable.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue();
        }
        return jLongValue;
    }

    public int getUniqueCount() {
        return this.freqTable.keySet().size();
    }

    public int hashCode() {
        SortedMap<Comparable<?>, Long> sortedMap = this.freqTable;
        return 31 + (sortedMap == null ? 0 : sortedMap.hashCode());
    }

    public void incrementValue(Comparable<?> comparable, long j6) {
        Comparable<?> comparableValueOf = comparable instanceof Integer ? Long.valueOf(((Integer) comparable).longValue()) : comparable;
        try {
            Long l6 = this.freqTable.get(comparableValueOf);
            if (l6 == null) {
                this.freqTable.put(comparableValueOf, Long.valueOf(j6));
            } else {
                this.freqTable.put(comparableValueOf, Long.valueOf(l6.longValue() + j6));
            }
        } catch (ClassCastException unused) {
            throw new MathIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, comparable.getClass().getName());
        }
    }

    public void merge(Frequency frequency) {
        MathUtils.checkNotNull(frequency, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator<Map.Entry<Comparable<?>, Long>> itEntrySetIterator = frequency.entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<Comparable<?>, Long> next = itEntrySetIterator.next();
            incrementValue(next.getKey(), next.getValue().longValue());
        }
    }

    public String toString() {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        StringBuilder sb = new StringBuilder("Value \t Freq. \t Pct. \t Cum Pct. \n");
        for (Comparable<?> comparable : this.freqTable.keySet()) {
            sb.append(comparable);
            sb.append('\t');
            sb.append(getCount(comparable));
            sb.append('\t');
            sb.append(percentInstance.format(getPct(comparable)));
            sb.append('\t');
            sb.append(percentInstance.format(getCumPct(comparable)));
            sb.append('\n');
        }
        return sb.toString();
    }

    public Iterator<Comparable<?>> valuesIterator() {
        return this.freqTable.keySet().iterator();
    }

    public void addValue(int i5) {
        addValue(Long.valueOf(i5));
    }

    public Frequency(Comparator<?> comparator) {
        this.freqTable = new TreeMap(comparator);
    }

    public void addValue(long j6) {
        addValue(Long.valueOf(j6));
    }

    public double getCumPct(int i5) {
        return getCumPct(Long.valueOf(i5));
    }

    public double getPct(int i5) {
        return getPct(Long.valueOf(i5));
    }

    public void addValue(char c) {
        addValue(Character.valueOf(c));
    }

    public double getCumPct(long j6) {
        return getCumPct(Long.valueOf(j6));
    }

    public double getPct(long j6) {
        return getPct(Long.valueOf(j6));
    }

    public long getCount(int i5) {
        return getCount(Long.valueOf(i5));
    }

    public double getCumPct(char c) {
        return getCumPct(Character.valueOf(c));
    }

    public double getPct(char c) {
        return getPct(Character.valueOf(c));
    }

    public long getCount(long j6) {
        return getCount(Long.valueOf(j6));
    }

    public void merge(Collection<Frequency> collection) {
        MathUtils.checkNotNull(collection, LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
        Iterator<Frequency> it = collection.iterator();
        while (it.hasNext()) {
            merge(it.next());
        }
    }

    public long getCount(char c) {
        return getCount(Character.valueOf(c));
    }

    public void incrementValue(int i5, long j6) {
        incrementValue(Long.valueOf(i5), j6);
    }

    public void incrementValue(long j6, long j7) {
        incrementValue(Long.valueOf(j6), j7);
    }

    public void incrementValue(char c, long j6) {
        incrementValue(Character.valueOf(c), j6);
    }

    public long getCumFreq(int i5) {
        return getCumFreq(Long.valueOf(i5));
    }

    public long getCumFreq(long j6) {
        return getCumFreq(Long.valueOf(j6));
    }

    public long getCumFreq(char c) {
        return getCumFreq(Character.valueOf(c));
    }
}
