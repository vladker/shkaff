package org.apache.commons.math3.stat.descriptive.rank;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.interpolation.NevilleInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.exception.InsufficientDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PSquarePercentile extends AbstractStorelessUnivariateStatistic implements StorelessUnivariateStatistic, Serializable {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("00.00");
    private static final double DEFAULT_QUANTILE_DESIRED = 50.0d;
    private static final int PSQUARE_CONSTANT = 5;
    private static final long serialVersionUID = 2283912083175715479L;
    private long countOfObservations;
    private final List<Double> initialFive;
    private transient double lastObservation;
    private PSquareMarkers markers;
    private double pValue;
    private final double quantile;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FixedCapacityList<E> extends ArrayList<E> implements Serializable {
        private static final long serialVersionUID = 2283952083075725479L;
        private final int capacity;

        public FixedCapacityList(int i5) {
            super(i5);
            this.capacity = i5;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E e) {
            if (size() < this.capacity) {
                return super.add(e);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            if (collection == null) {
                return false;
            }
            if (size() + collection.size() <= this.capacity) {
                return super.addAll(collection);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Markers implements PSquareMarkers, Serializable {
        private static final int HIGH = 4;
        private static final int LOW = 2;
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private transient int f6926k;
        private final Marker[] markerArray;

        private void adjustHeightsOfMarkers() {
            for (int i5 = 2; i5 <= 4; i5++) {
                estimate(i5);
            }
        }

        private static Marker[] createMarkerArray(List<Double> list, double d) {
            int size = list == null ? -1 : list.size();
            if (size < 5) {
                throw new InsufficientDataException(LocalizedFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE, Integer.valueOf(size), 5);
            }
            Collections.sort(list);
            double d6 = d * 2.0d;
            return new Marker[]{new Marker(), new Marker(list.get(0).doubleValue(), 1.0d, 0.0d, 1.0d), new Marker(list.get(1).doubleValue(), d6 + 1.0d, d / 2.0d, 2.0d), new Marker(list.get(2).doubleValue(), (4.0d * d) + 1.0d, d, 3.0d), new Marker(list.get(3).doubleValue(), d6 + 3.0d, (d + 1.0d) / 2.0d, 4.0d), new Marker(list.get(4).doubleValue(), 5.0d, 1.0d, 5.0d)};
        }

        private int findCellAndUpdateMinMax(double d) {
            this.f6926k = -1;
            if (d < height(1)) {
                this.markerArray[1].markerHeight = d;
                this.f6926k = 1;
            } else if (d < height(2)) {
                this.f6926k = 1;
            } else if (d < height(3)) {
                this.f6926k = 2;
            } else if (d < height(4)) {
                this.f6926k = 3;
            } else if (d <= height(5)) {
                this.f6926k = 4;
            } else {
                this.markerArray[5].markerHeight = d;
                this.f6926k = 4;
            }
            return this.f6926k;
        }

        private void incrementPositions(int i5, int i6, int i7) {
            while (i6 <= i7) {
                this.markerArray[i6].incrementPosition(i5);
                i6++;
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            int i5 = 1;
            while (i5 < 5) {
                Marker[] markerArr = this.markerArray;
                int i6 = i5 + 1;
                markerArr[i5].previous(markerArr[i5 - 1]).next(this.markerArray[i6]).index(i5);
                i5 = i6;
            }
            Marker marker = this.markerArray[0];
            marker.previous(marker).next(this.markerArray[1]).index(0);
            Marker[] markerArr2 = this.markerArray;
            markerArr2[5].previous(markerArr2[4]).next(this.markerArray[5]).index(5);
        }

        private void updateDesiredPositions() {
            int i5 = 1;
            while (true) {
                Marker[] markerArr = this.markerArray;
                if (i5 >= markerArr.length) {
                    return;
                }
                markerArr[i5].updateDesiredPosition();
                i5++;
            }
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public Object clone() {
            return new Markers(new Marker[]{new Marker(), (Marker) this.markerArray[1].clone(), (Marker) this.markerArray[2].clone(), (Marker) this.markerArray[3].clone(), (Marker) this.markerArray[4].clone(), (Marker) this.markerArray[5].clone()});
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Markers)) {
                return false;
            }
            return Arrays.deepEquals(this.markerArray, ((Markers) obj).markerArray);
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double estimate(int i5) {
            if (i5 < 2 || i5 > 4) {
                throw new OutOfRangeException(Integer.valueOf(i5), 2, 4);
            }
            return this.markerArray[i5].estimate();
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double getPercentileValue() {
            return height(3);
        }

        public int hashCode() {
            return Arrays.deepHashCode(this.markerArray);
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double height(int i5) {
            Marker[] markerArr = this.markerArray;
            if (i5 >= markerArr.length || i5 <= 0) {
                throw new OutOfRangeException(Integer.valueOf(i5), 1, Integer.valueOf(this.markerArray.length));
            }
            return markerArr[i5].markerHeight;
        }

        @Override // org.apache.commons.math3.stat.descriptive.rank.PSquarePercentile.PSquareMarkers
        public double processDataPoint(double d) {
            incrementPositions(1, findCellAndUpdateMinMax(d) + 1, 5);
            updateDesiredPositions();
            adjustHeightsOfMarkers();
            return getPercentileValue();
        }

        public String toString() {
            String string = this.markerArray[1].toString();
            String string2 = this.markerArray[2].toString();
            String string3 = this.markerArray[3].toString();
            String string4 = this.markerArray[4].toString();
            String string5 = this.markerArray[5].toString();
            StringBuilder sbU = a.u("m1=[", string, "],m2=[", string2, "],m3=[");
            a.y(sbU, string3, "],m4=[", string4, "],m5=[");
            return AbstractC0157z.s(sbU, string5, "]");
        }

        private Markers(Marker[] markerArr) {
            this.f6926k = -1;
            MathUtils.checkNotNull(markerArr);
            this.markerArray = markerArr;
            int i5 = 1;
            while (i5 < 5) {
                Marker[] markerArr2 = this.markerArray;
                int i6 = i5 + 1;
                markerArr2[i5].previous(markerArr2[i5 - 1]).next(this.markerArray[i6]).index(i5);
                i5 = i6;
            }
            Marker marker = this.markerArray[0];
            marker.previous(marker).next(this.markerArray[1]).index(0);
            Marker[] markerArr3 = this.markerArray;
            markerArr3[5].previous(markerArr3[4]).next(this.markerArray[5]).index(5);
        }

        private Markers(List<Double> list, double d) {
            this(createMarkerArray(list, d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface PSquareMarkers extends Cloneable {
        Object clone();

        double estimate(int i5);

        double getPercentileValue();

        double height(int i5);

        double processDataPoint(double d);
    }

    public PSquarePercentile(double d) {
        this.initialFive = new FixedCapacityList(5);
        this.markers = null;
        this.pValue = Double.NaN;
        if (d > 100.0d || d < 0.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE, Double.valueOf(d), 0, 100);
        }
        this.quantile = d / 100.0d;
    }

    private double maximum() {
        PSquareMarkers pSquareMarkers = this.markers;
        if (pSquareMarkers != null) {
            return pSquareMarkers.height(5);
        }
        if (this.initialFive.isEmpty()) {
            return Double.NaN;
        }
        return ((Double) AbstractC0157z.f(1, this.initialFive)).doubleValue();
    }

    private double minimum() {
        PSquareMarkers pSquareMarkers = this.markers;
        if (pSquareMarkers != null) {
            return pSquareMarkers.height(1);
        }
        if (this.initialFive.isEmpty()) {
            return Double.NaN;
        }
        return this.initialFive.get(0).doubleValue();
    }

    public static PSquareMarkers newMarkers(List<Double> list, double d) {
        return new Markers(list, d);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        this.markers = null;
        this.initialFive.clear();
        this.countOfObservations = 0L;
        this.pValue = Double.NaN;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof PSquarePercentile)) {
            PSquarePercentile pSquarePercentile = (PSquarePercentile) obj;
            PSquareMarkers pSquareMarkers = this.markers;
            boolean z6 = (pSquareMarkers == null || pSquarePercentile.markers == null) ? false : true;
            boolean zEquals = pSquareMarkers == null && pSquarePercentile.markers == null;
            if (z6) {
                zEquals = pSquareMarkers.equals(pSquarePercentile.markers);
            }
            if (zEquals && getN() == pSquarePercentile.getN()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.countOfObservations;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        if (Double.compare(this.quantile, 1.0d) == 0) {
            this.pValue = maximum();
        } else if (Double.compare(this.quantile, 0.0d) == 0) {
            this.pValue = minimum();
        }
        return this.pValue;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic
    public int hashCode() {
        double result = getResult();
        if (Double.isNaN(result)) {
            result = 37.0d;
        }
        PSquareMarkers pSquareMarkers = this.markers;
        return Arrays.hashCode(new double[]{result, this.quantile, pSquareMarkers == null ? 0.0d : pSquareMarkers.hashCode(), this.countOfObservations});
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        this.countOfObservations++;
        this.lastObservation = d;
        if (this.markers == null) {
            if (this.initialFive.add(Double.valueOf(d))) {
                Collections.sort(this.initialFive);
                List<Double> list = this.initialFive;
                this.pValue = list.get((int) (this.quantile * ((double) (list.size() - 1)))).doubleValue();
                return;
            }
            this.markers = newMarkers(this.initialFive, this.quantile);
        }
        this.pValue = this.markers.processDataPoint(d);
    }

    public double quantile() {
        return this.quantile;
    }

    public String toString() {
        if (this.markers != null) {
            return androidx.exifinterface.media.a.m("obs=", DECIMAL_FORMAT.format(this.lastObservation), " markers=", this.markers.toString());
        }
        DecimalFormat decimalFormat = DECIMAL_FORMAT;
        return androidx.exifinterface.media.a.m("obs=", decimalFormat.format(this.lastObservation), " pValue=", decimalFormat.format(this.pValue));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Marker implements Serializable, Cloneable {
        private static final long serialVersionUID = -3575879478288538431L;
        private double desiredMarkerIncrement;
        private double desiredMarkerPosition;
        private int index;
        private double intMarkerPosition;
        private transient UnivariateInterpolator linear;
        private double markerHeight;
        private transient Marker next;
        private final UnivariateInterpolator nonLinear;
        private transient Marker previous;

        private double difference() {
            return this.desiredMarkerPosition - this.intMarkerPosition;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double estimate() {
            double dDifference = difference();
            Marker marker = this.next;
            double d = marker.intMarkerPosition;
            double d6 = this.intMarkerPosition;
            boolean z6 = d - d6 > 1.0d;
            Marker marker2 = this.previous;
            double d7 = marker2.intMarkerPosition;
            boolean z7 = d7 - d6 < -1.0d;
            if ((dDifference >= 1.0d && z6) || (dDifference <= -1.0d && z7)) {
                int i5 = dDifference >= 0.0d ? 1 : -1;
                double[] dArr = {d7, d6, d};
                double[] dArr2 = {marker2.markerHeight, this.markerHeight, marker.markerHeight};
                double d8 = d6 + ((double) i5);
                double dValue = this.nonLinear.interpolate(dArr, dArr2).value(d8);
                this.markerHeight = dValue;
                if (isEstimateBad(dArr2, dValue)) {
                    double d9 = dArr[1];
                    int i6 = (d8 - d9 > 0.0d ? 1 : -1) + 1;
                    double[] dArr3 = {d9, dArr[i6]};
                    double[] dArr4 = {dArr2[1], dArr2[i6]};
                    MathArrays.sortInPlace(dArr3, dArr4);
                    this.markerHeight = this.linear.interpolate(dArr3, dArr4).value(d8);
                }
                incrementPosition(i5);
            }
            return this.markerHeight;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void incrementPosition(int i5) {
            this.intMarkerPosition += (double) i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Marker index(int i5) {
            this.index = i5;
            return this;
        }

        private boolean isEstimateBad(double[] dArr, double d) {
            return d <= dArr[0] || d >= dArr[2];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Marker next(Marker marker) {
            MathUtils.checkNotNull(marker);
            this.next = marker;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Marker previous(Marker marker) {
            MathUtils.checkNotNull(marker);
            this.previous = marker;
            return this;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.next = this;
            this.previous = this;
            this.linear = new LinearInterpolator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateDesiredPosition() {
            this.desiredMarkerPosition += this.desiredMarkerIncrement;
        }

        public Object clone() {
            return new Marker(this.markerHeight, this.desiredMarkerPosition, this.desiredMarkerIncrement, this.intMarkerPosition);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Marker)) {
                Marker marker = (Marker) obj;
                if (Double.compare(this.markerHeight, marker.markerHeight) == 0 && Double.compare(this.intMarkerPosition, marker.intMarkerPosition) == 0 && Double.compare(this.desiredMarkerPosition, marker.desiredMarkerPosition) == 0 && Double.compare(this.desiredMarkerIncrement, marker.desiredMarkerIncrement) == 0 && this.next.index == marker.next.index && this.previous.index == marker.previous.index) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(new double[]{this.markerHeight, this.intMarkerPosition, this.desiredMarkerIncrement, this.desiredMarkerPosition, this.previous.index, this.next.index});
        }

        public String toString() {
            return String.format("index=%.0f,n=%.0f,np=%.2f,q=%.2f,dn=%.2f,prev=%d,next=%d", Double.valueOf(this.index), Double.valueOf(Precision.round(this.intMarkerPosition, 0)), Double.valueOf(Precision.round(this.desiredMarkerPosition, 2)), Double.valueOf(Precision.round(this.markerHeight, 2)), Double.valueOf(Precision.round(this.desiredMarkerIncrement, 2)), Integer.valueOf(this.previous.index), Integer.valueOf(this.next.index));
        }

        private Marker() {
            this.nonLinear = new NevilleInterpolator();
            this.linear = new LinearInterpolator();
            this.previous = this;
            this.next = this;
        }

        private Marker(double d, double d6, double d7, double d8) {
            this();
            this.markerHeight = d;
            this.desiredMarkerPosition = d6;
            this.desiredMarkerIncrement = d7;
            this.intMarkerPosition = d8;
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public StorelessUnivariateStatistic copy() {
        PSquarePercentile pSquarePercentile = new PSquarePercentile(this.quantile * 100.0d);
        PSquareMarkers pSquareMarkers = this.markers;
        if (pSquareMarkers != null) {
            pSquarePercentile.markers = (PSquareMarkers) pSquareMarkers.clone();
        }
        pSquarePercentile.countOfObservations = this.countOfObservations;
        pSquarePercentile.pValue = this.pValue;
        pSquarePercentile.initialFive.clear();
        pSquarePercentile.initialFive.addAll(this.initialFive);
        return pSquarePercentile;
    }

    public PSquarePercentile() {
        this(DEFAULT_QUANTILE_DESIRED);
    }
}
