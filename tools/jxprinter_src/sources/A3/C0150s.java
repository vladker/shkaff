package A3;

import java.util.RandomAccess;

/* JADX INFO: renamed from: A3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0150s extends AbstractC0139g implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f48a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0150s(Object obj, int i5) {
        this.f48a = i5;
        this.b = obj;
    }

    @Override // A3.AbstractC0132b
    public final int b() {
        switch (this.f48a) {
            case 0:
                return ((float[]) this.b).length;
            case 1:
                return ((double[]) this.b).length;
            case 2:
                return ((boolean[]) this.b).length;
            default:
                return ((char[]) this.b).length;
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f48a) {
            case 0:
                if (!(obj instanceof Float)) {
                    return false;
                }
                float fFloatValue = ((Number) obj).floatValue();
                for (float f6 : (float[]) this.b) {
                    if (Float.floatToIntBits(f6) == Float.floatToIntBits(fFloatValue)) {
                        return true;
                    }
                }
                return false;
            case 1:
                if (!(obj instanceof Double)) {
                    return false;
                }
                double dDoubleValue = ((Number) obj).doubleValue();
                for (double d : (double[]) this.b) {
                    if (Double.doubleToLongBits(d) == Double.doubleToLongBits(dDoubleValue)) {
                        return true;
                    }
                }
                return false;
            case 2:
                if (!(obj instanceof Boolean)) {
                    return false;
                }
                return C.contains((boolean[]) this.b, ((Boolean) obj).booleanValue());
            default:
                if (!(obj instanceof Character)) {
                    return false;
                }
                return C.contains((char[]) this.b, ((Character) obj).charValue());
        }
    }

    @Override // java.util.List
    public final Object get(int i5) {
        switch (this.f48a) {
            case 0:
                return Float.valueOf(((float[]) this.b)[i5]);
            case 1:
                return Double.valueOf(((double[]) this.b)[i5]);
            case 2:
                return Boolean.valueOf(((boolean[]) this.b)[i5]);
            default:
                return Character.valueOf(((char[]) this.b)[i5]);
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int indexOf(Object obj) {
        switch (this.f48a) {
            case 0:
                if (!(obj instanceof Float)) {
                    return -1;
                }
                float fFloatValue = ((Number) obj).floatValue();
                float[] fArr = (float[]) this.b;
                int length = fArr.length;
                for (int i5 = 0; i5 < length; i5++) {
                    if (Float.floatToIntBits(fArr[i5]) == Float.floatToIntBits(fFloatValue)) {
                        return i5;
                    }
                }
                return -1;
            case 1:
                if (!(obj instanceof Double)) {
                    return -1;
                }
                double dDoubleValue = ((Number) obj).doubleValue();
                double[] dArr = (double[]) this.b;
                int length2 = dArr.length;
                for (int i6 = 0; i6 < length2; i6++) {
                    if (Double.doubleToLongBits(dArr[i6]) == Double.doubleToLongBits(dDoubleValue)) {
                        return i6;
                    }
                }
                return -1;
            case 2:
                if (!(obj instanceof Boolean)) {
                    return -1;
                }
                return C.indexOf((boolean[]) this.b, ((Boolean) obj).booleanValue());
            default:
                if (!(obj instanceof Character)) {
                    return -1;
                }
                return C.indexOf((char[]) this.b, ((Character) obj).charValue());
        }
    }

    @Override // A3.AbstractC0132b, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f48a) {
            case 0:
                return ((float[]) this.b).length == 0;
            case 1:
                return ((double[]) this.b).length == 0;
            case 2:
                return ((boolean[]) this.b).length == 0;
            default:
                return ((char[]) this.b).length == 0;
        }
    }

    @Override // A3.AbstractC0139g, java.util.List
    public final int lastIndexOf(Object obj) {
        switch (this.f48a) {
            case 0:
                if (!(obj instanceof Float)) {
                    return -1;
                }
                float fFloatValue = ((Number) obj).floatValue();
                float[] fArr = (float[]) this.b;
                int length = fArr.length - 1;
                if (length < 0) {
                    return -1;
                }
                while (true) {
                    int i5 = length - 1;
                    if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(fFloatValue)) {
                        return length;
                    }
                    if (i5 < 0) {
                        return -1;
                    }
                    length = i5;
                }
                break;
            case 1:
                if (!(obj instanceof Double)) {
                    return -1;
                }
                double dDoubleValue = ((Number) obj).doubleValue();
                double[] dArr = (double[]) this.b;
                int length2 = dArr.length - 1;
                if (length2 < 0) {
                    return -1;
                }
                while (true) {
                    int i6 = length2 - 1;
                    if (Double.doubleToLongBits(dArr[length2]) == Double.doubleToLongBits(dDoubleValue)) {
                        return length2;
                    }
                    if (i6 < 0) {
                        return -1;
                    }
                    length2 = i6;
                }
                break;
            case 2:
                if (!(obj instanceof Boolean)) {
                    return -1;
                }
                return C.lastIndexOf((boolean[]) this.b, ((Boolean) obj).booleanValue());
            default:
                if (!(obj instanceof Character)) {
                    return -1;
                }
                return C.lastIndexOf((char[]) this.b, ((Character) obj).charValue());
        }
    }
}
