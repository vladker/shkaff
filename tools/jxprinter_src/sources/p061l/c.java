package p061l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5763a;
    public int b;
    public int c;
    public Object d;

    public c() {
        this(16, 0);
    }

    public void a(p011b3.c cVar) {
        Object obj;
        Object obj2;
        Object[] objArr = (Object[]) this.d;
        int i5 = this.f5763a;
        int iHashCode = cVar.hashCode() * (-1640531527);
        int i6 = (iHashCode ^ (iHashCode >>> 16)) & i5;
        Object obj3 = objArr[i6];
        if (obj3 != null) {
            if (obj3.equals(cVar)) {
                return;
            }
            do {
                i6 = (i6 + 1) & i5;
                obj2 = objArr[i6];
                if (obj2 == null) {
                }
            } while (!obj2.equals(cVar));
            return;
        }
        objArr[i6] = cVar;
        int i7 = this.b + 1;
        this.b = i7;
        if (i7 < this.c) {
            return;
        }
        Object[] objArr2 = (Object[]) this.d;
        int length = objArr2.length;
        int i8 = length << 1;
        int i9 = i8 - 1;
        Object[] objArr3 = new Object[i8];
        while (true) {
            int i10 = i7 - 1;
            if (i7 == 0) {
                this.f5763a = i9;
                this.c = (int) (i8 * 0.75f);
                this.d = objArr3;
                return;
            }
            do {
                length--;
                obj = objArr2[length];
            } while (obj == null);
            int iHashCode2 = obj.hashCode() * (-1640531527);
            int i11 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i9;
            if (objArr3[i11] != null) {
                do {
                    i11 = (i11 + 1) & i9;
                } while (objArr3[i11] != null);
            }
            objArr3[i11] = objArr2[length];
            i7 = i10;
        }
    }

    public void b(int i5, int i6, Object[] objArr) {
        int i7;
        Object obj;
        this.b--;
        while (true) {
            int i8 = i5 + 1;
            while (true) {
                i7 = i8 & i6;
                obj = objArr[i7];
                if (obj != null) {
                    int iHashCode = obj.hashCode() * (-1640531527);
                    int i9 = (iHashCode ^ (iHashCode >>> 16)) & i6;
                    if (i5 > i7) {
                        if (i5 >= i9 && i9 > i7) {
                            break;
                        } else {
                            i8 = i7 + 1;
                        }
                    } else if (i5 >= i9 || i9 > i7) {
                        break;
                    } else {
                        i8 = i7 + 1;
                    }
                } else {
                    objArr[i5] = null;
                    return;
                }
            }
            objArr[i5] = obj;
            i5 = i7;
        }
    }

    public c(int i5, int i6) {
        int iNumberOfLeadingZeros = 1 << (32 - Integer.numberOfLeadingZeros(i5 - 1));
        this.f5763a = iNumberOfLeadingZeros - 1;
        this.c = (int) (0.75f * iNumberOfLeadingZeros);
        this.d = new Object[iNumberOfLeadingZeros];
    }
}
