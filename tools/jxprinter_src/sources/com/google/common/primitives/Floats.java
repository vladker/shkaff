package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class Floats extends FloatsMethodsForWeb {
    public static final int BYTES = 4;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @GwtCompatible
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i5 = 0; i5 < size; i5++) {
                if (this.array[this.start + i5] != floatArrayAsList.array[floatArrayAsList.start + i5]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                iHashCode = (iHashCode * 31) + Floats.hashCode(this.array[i5]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Float) || (iIndexOf = Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            if (!(obj instanceof Float) || (iLastIndexOf = Floats.lastIndexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i5, int i6) {
            Preconditions.checkPositionIndexes(i5, i6, size());
            if (i5 == i6) {
                return Collections.EMPTY_LIST;
            }
            float[] fArr = this.array;
            int i7 = this.start;
            return new FloatArrayAsList(fArr, i5 + i7, i7 + i6);
        }

        public float[] toFloatArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append('[');
            sb.append(this.array[this.start]);
            int i5 = this.start;
            while (true) {
                i5++;
                if (i5 >= this.end) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.array[i5]);
            }
        }

        public FloatArrayAsList(float[] fArr, int i5, int i6) {
            this.array = fArr;
            this.start = i5;
            this.end = i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int i5) {
            Preconditions.checkElementIndex(i5, size());
            return Float.valueOf(this.array[this.start + i5]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Float set(int i5, Float f6) {
            Preconditions.checkElementIndex(i5, size());
            float[] fArr = this.array;
            int i6 = this.start;
            float f7 = fArr[i6 + i5];
            fArr[i6 + i5] = ((Float) Preconditions.checkNotNull(f6)).floatValue();
            return Float.valueOf(f7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter INSTANCE = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Float f6) {
            return f6.toString();
        }

        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int iMin = Math.min(fArr.length, fArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int iCompare = Float.compare(fArr[i5], fArr2[i5]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return fArr.length - fArr2.length;
        }
    }

    private Floats() {
    }

    public static List<Float> asList(float... fArr) {
        return fArr.length == 0 ? Collections.EMPTY_LIST : new FloatArrayAsList(fArr);
    }

    public static int compare(float f6, float f7) {
        return Float.compare(f6, f7);
    }

    public static float[] concat(float[]... fArr) {
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int length2 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, length2, fArr4.length);
            length2 += fArr4.length;
        }
        return fArr3;
    }

    @Beta
    public static float constrainToRange(float f6, float f7, float f8) {
        if (f7 <= f8) {
            return Math.min(Math.max(f6, f7), f8);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Float.valueOf(f7), Float.valueOf(f8)));
    }

    public static boolean contains(float[] fArr, float f6) {
        for (float f7 : fArr) {
            if (f7 == f6) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i5, int i6) {
        Preconditions.checkArgument(i5 >= 0, "Invalid minLength: %s", i5);
        Preconditions.checkArgument(i6 >= 0, "Invalid padding: %s", i6);
        return fArr.length < i5 ? Arrays.copyOf(fArr, i5 + i6) : fArr;
    }

    public static int hashCode(float f6) {
        return Float.valueOf(f6).hashCode();
    }

    public static int indexOf(float[] fArr, float f6) {
        return indexOf(fArr, f6, 0, fArr.length);
    }

    public static boolean isFinite(float f6) {
        return Float.NEGATIVE_INFINITY < f6 && f6 < Float.POSITIVE_INFINITY;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i5 = 1; i5 < fArr.length; i5++) {
            sb.append(str);
            sb.append(fArr[i5]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(float[] fArr, float f6) {
        return lastIndexOf(fArr, f6, 0, fArr.length);
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float fMax = fArr[0];
        for (int i5 = 1; i5 < fArr.length; i5++) {
            fMax = Math.max(fMax, fArr[i5]);
        }
        return fMax;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float fMin = fArr[0];
        for (int i5 = 1; i5 < fArr.length; i5++) {
            fMin = Math.min(fMin, fArr[i5]);
        }
        return fMin;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i5 = 0; i5 < length; i5++) {
            fArr[i5] = ((Number) Preconditions.checkNotNull(array[i5])).floatValue();
        }
        return fArr;
    }

    @Beta
    @GwtIncompatible
    public static Float tryParse(String str) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(float[] fArr, float f6, int i5, int i6) {
        while (i5 < i6) {
            if (fArr[i5] == f6) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(float[] fArr, float f6, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (fArr[i7] == f6) {
                return i7;
            }
        }
        return -1;
    }

    public static int indexOf(float[] fArr, float[] fArr2) {
        Preconditions.checkNotNull(fArr, "array");
        Preconditions.checkNotNull(fArr2, TypedValues.AttributesType.S_TARGET);
        if (fArr2.length == 0) {
            return 0;
        }
        for (int i5 = 0; i5 < (fArr.length - fArr2.length) + 1; i5++) {
            for (int i6 = 0; i6 < fArr2.length; i6++) {
                if (fArr[i5 + i6] != fArr2[i6]) {
                }
            }
            return i5;
        }
        return -1;
    }

    public static void reverse(float[] fArr, int i5, int i6) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i5, i6, fArr.length);
        for (int i7 = i6 - 1; i5 < i7; i7--) {
            float f6 = fArr[i5];
            fArr[i5] = fArr[i7];
            fArr[i7] = f6;
            i5++;
        }
    }

    public static void sortDescending(float[] fArr, int i5, int i6) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i5, i6, fArr.length);
        Arrays.sort(fArr, i5, i6);
        reverse(fArr, i5, i6);
    }
}
