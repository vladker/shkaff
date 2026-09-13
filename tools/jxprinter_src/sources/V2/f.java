package V2;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Cloneable, Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long[] f748h = new long[32];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final transient b f749i = new b(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final transient b f750j = new b(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final transient b f751k = new b(2);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final transient b f752l = new b(3);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final transient b f753m = new b(4);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final transient d f754n = new d(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final transient b f755o = new b(5);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final transient b f756p = new b(6);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final transient b f757q = new b(7);
    private static final long serialVersionUID = -6663013367427929992L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f758a;
    public transient long[][][] b;
    public transient int c;
    public transient c d;
    public transient long[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient d f759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient e f760g;

    public f(int i5, int i6) {
        if (i5 < 0) {
            throw new NegativeArraySizeException(androidx.collection.a.i(i5, "(requested capacity=", ") < 0"));
        }
        i(i5 - 1);
        this.f758a = i6;
        e();
        k();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f758a = objectInputStream.readInt();
        i(objectInputStream.readInt());
        int i5 = objectInputStream.readInt();
        for (int i6 = 0; i6 != i5; i6++) {
            int i7 = objectInputStream.readInt();
            int i8 = i7 & 31;
            int i9 = (i7 >> 5) & 31;
            int i10 = i7 >> 10;
            long j6 = objectInputStream.readLong();
            long[][][] jArr = this.b;
            long[][] jArr2 = jArr[i10];
            if (jArr2 == null) {
                jArr2 = new long[32][];
                jArr[i10] = jArr2;
            }
            long[] jArr3 = jArr2[i9];
            if (jArr3 == null) {
                jArr3 = new long[32];
                jArr2[i9] = jArr3;
            }
            jArr3[i8] = j6;
        }
        e();
        k();
        if (i5 != this.d.d) {
            throw new InternalError("count of entries not consistent");
        }
        if (objectInputStream.readInt() != this.d.f742a) {
            throw new IOException("deserialized hashCode mis-match");
        }
    }

    public static void throwIndexOutOfBoundsException(int i5, int i6) {
        String strI = i5 < 0 ? androidx.collection.a.i(i5, "(i=", ") < 0") : "";
        if (i5 == Integer.MAX_VALUE) {
            strI = strI + "(i=" + i5 + ")";
        }
        if (i6 < 0) {
            StringBuilder sbR = androidx.collection.a.r(strI);
            sbR.append(strI.isEmpty() ? "" : ", ");
            sbR.append("(j=");
            sbR.append(i6);
            sbR.append(") < 0");
            strI = sbR.toString();
        }
        if (i5 > i6) {
            StringBuilder sbR2 = androidx.collection.a.r(strI);
            sbR2.append(strI.isEmpty() ? "" : ", ");
            sbR2.append("(i=");
            sbR2.append(i5);
            sbR2.append(") > (j=");
            strI = AbstractC0157z.l(")", i6, sbR2);
        }
        throw new IndexOutOfBoundsException(strI);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        k();
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f758a);
        objectOutputStream.writeInt(this.d.c);
        int i5 = this.d.d;
        objectOutputStream.writeInt(i5);
        long[][][] jArr = this.b;
        int length = jArr.length;
        for (int i6 = 0; i6 != length; i6++) {
            long[][] jArr2 = jArr[i6];
            if (jArr2 != null) {
                for (int i7 = 0; i7 != 32; i7++) {
                    long[] jArr3 = jArr2[i7];
                    if (jArr3 != null) {
                        int i8 = (i6 << 10) + (i7 << 5);
                        for (int i9 = 0; i9 != 32; i9++) {
                            long j6 = jArr3[i9];
                            if (j6 != 0) {
                                objectOutputStream.writeInt(i8 + i9);
                                objectOutputStream.writeLong(j6);
                                i5--;
                            }
                        }
                    }
                }
            }
        }
        if (i5 != 0) {
            throw new InternalError("count of entries not consistent");
        }
        objectOutputStream.writeInt(this.d.f742a);
    }

    public final void a(int i5) {
        long[] jArr;
        if (i5 + 1 < 1) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
        }
        if (i5 >= this.c) {
            return;
        }
        int i6 = i5 >> 6;
        long[][] jArr2 = this.b[i5 >> 16];
        if (jArr2 == null || (jArr = jArr2[(i5 >> 11) & 31]) == null) {
            return;
        }
        int i7 = i6 & 31;
        jArr[i7] = jArr[i7] & (~(1 << i5));
        this.d.f742a = 0;
    }

    public void and(int i5, boolean z6) {
        if (i5 + 1 < 1) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
        }
        if (z6) {
            return;
        }
        a(i5);
    }

    public void andNot(int i5, int i6, f fVar) {
        setScanner(i5, i6, fVar, f750j);
    }

    public void clear(int i5, int i6) {
        setScanner(i5, i6, null, f751k);
    }

    public Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.b = null;
            fVar.i(1);
            fVar.e();
            fVar.f759f = null;
            fVar.setScanner(0, this.c, this, f752l);
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }

    public final void e() {
        this.e = new long[32];
        this.d = new c();
        this.f760g = new e(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this == fVar) {
            return true;
        }
        if (this.f759f == null) {
            this.f759f = new d(0);
        }
        setScanner(0, Math.max(this.c, fVar.c), fVar, this.f759f);
        return this.f759f.b;
    }

    public final boolean f(int i5) {
        long[][] jArr;
        long[] jArr2;
        if (i5 + 1 >= 1) {
            return (i5 >= this.c || (jArr = this.b[i5 >> 16]) == null || (jArr2 = jArr[(i5 >> 11) & 31]) == null || (jArr2[(i5 >> 6) & 31] & (1 << i5)) == 0) ? false : true;
        }
        throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
    }

    public void flip(int i5, int i6) {
        setScanner(i5, i6, null, f753m);
    }

    public final int g(int i5) {
        long[][] jArr;
        long[] jArr2;
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
        }
        int i6 = i5 >> 6;
        int i7 = i6 & 31;
        int i8 = (i5 >> 11) & 31;
        int i9 = i5 >> 16;
        long j6 = -1;
        long j7 = (-1) << i5;
        long[][][] jArr3 = this.b;
        int length = jArr3.length;
        if (i9 < length && (jArr = jArr3[i9]) != null && (jArr2 = jArr[i8]) != null) {
            j7 &= ~jArr2[i7];
            if (j7 == 0) {
                int i10 = i6 + 1;
                i9 = i10 >> 10;
                i8 = (i10 >> 5) & 31;
                i7 = i10 & 31;
                loop0: while (i9 != length) {
                    long[][] jArr4 = this.b[i9];
                    if (jArr4 == null) {
                        break;
                    }
                    while (i8 != 32) {
                        long[] jArr5 = jArr4[i8];
                        if (jArr5 == null) {
                            break loop0;
                        }
                        while (i7 != 32) {
                            j6 = ~jArr5[i7];
                            if (j6 != 0) {
                                break loop0;
                            }
                            i7++;
                        }
                        i8++;
                        i7 = 0;
                    }
                    i9++;
                    i7 = 0;
                    i8 = 0;
                }
                j7 = j6;
            }
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j7) + ((((i9 << 10) + (i8 << 5)) + i7) << 6);
        if (iNumberOfTrailingZeros == Integer.MAX_VALUE) {
            return -1;
        }
        return iNumberOfTrailingZeros;
    }

    public f get(int i5, int i6) {
        f fVar = new f(i6, this.f758a);
        fVar.setScanner(i5, i6, this, f752l);
        return fVar;
    }

    public final int h(int i5) {
        long j6;
        long[] jArr;
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
        }
        int i6 = i5 >> 6;
        int i7 = i6 & 31;
        int i8 = (i5 >> 11) & 31;
        int i9 = i5 >> 16;
        long[][][] jArr2 = this.b;
        int length = jArr2.length;
        long j7 = 0;
        if (i9 < length) {
            long[][] jArr3 = jArr2[i9];
            if (jArr3 == null || (jArr = jArr3[i8]) == null) {
                j6 = 0;
            } else {
                j6 = jArr[i7] & ((-1) << i5);
                if (j6 == 0) {
                }
                j7 = j6;
            }
            int i10 = i6 + 1;
            i9 = i10 >> 10;
            i8 = (i10 >> 5) & 31;
            i7 = i10 & 31;
            loop0: while (i9 != length) {
                long[][] jArr4 = this.b[i9];
                if (jArr4 != null) {
                    while (i8 != 32) {
                        long[] jArr5 = jArr4[i8];
                        if (jArr5 != null) {
                            while (i7 != 32) {
                                j6 = jArr5[i7];
                                if (j6 != 0) {
                                    break loop0;
                                }
                                i7++;
                            }
                        }
                        i8++;
                        i7 = 0;
                    }
                }
                i9++;
                i7 = 0;
                i8 = 0;
            }
            j7 = j6;
        }
        if (i9 >= length) {
            return -1;
        }
        return Long.numberOfTrailingZeros(j7) + ((((i9 << 10) + (i8 << 5)) + i7) << 6);
    }

    public final int hashCode() {
        k();
        return this.d.f742a;
    }

    public final void i(int i5) {
        int i6 = i5 >> 16;
        int iHighestOneBit = Integer.highestOneBit(i6);
        if (iHighestOneBit == 0) {
            iHighestOneBit = 1;
        }
        if (i6 >= iHighestOneBit) {
            iHighestOneBit <<= 1;
        }
        if (iHighestOneBit > 32768) {
            iHighestOneBit = 32768;
        }
        long[][][] jArr = this.b;
        int length = jArr != null ? jArr.length : 0;
        if (iHighestOneBit != length || jArr == null) {
            long[][][] jArr2 = new long[iHighestOneBit][][];
            if (length != 0) {
                System.arraycopy(jArr, 0, jArr2, 0, Math.min(length, iHighestOneBit));
                int length2 = this.b.length;
                if (length2 > 0) {
                    for (int i7 = 0; i7 != length2; i7++) {
                        this.b[i7] = null;
                    }
                    this.d.f742a = 0;
                }
            }
            this.b = jArr2;
            this.c = iHighestOneBit == 32768 ? Integer.MAX_VALUE : 65536 * iHighestOneBit;
        }
    }

    public boolean intersects(int i5, int i6, f fVar) {
        d dVar = f754n;
        setScanner(i5, i6, fVar, dVar);
        return dVar.b;
    }

    public final void j(int i5) {
        if (i5 + 1 < 1) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "i="));
        }
        int i6 = i5 >> 6;
        int i7 = i5 >> 16;
        int i8 = (i5 >> 11) & 31;
        if (i5 >= this.c) {
            i(i5);
        }
        long[][][] jArr = this.b;
        long[][] jArr2 = jArr[i7];
        if (jArr2 == null) {
            jArr2 = new long[32][];
            jArr[i7] = jArr2;
        }
        long[] jArr3 = jArr2[i8];
        if (jArr3 == null) {
            jArr3 = new long[32];
            jArr2[i8] = jArr3;
        }
        int i9 = i6 & 31;
        jArr3[i9] = jArr3[i9] | (1 << i5);
        this.d.f742a = 0;
    }

    public final void k() {
        if (this.d.f742a != 0) {
            return;
        }
        setScanner(0, this.c, null, this.f760g);
    }

    public void or(int i5, int i6, f fVar) {
        setScanner(i5, i6, fVar, f755o);
    }

    public void set(int i5, int i6) {
        setScanner(i5, i6, null, f756p);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:108:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x014c  */
    /* JADX WARN: Code duplicated, block: B:112:0x014f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0153  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:129:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:131:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:132:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:137:0x0219  */
    /* JADX WARN: Code duplicated, block: B:138:0x0224  */
    /* JADX WARN: Code duplicated, block: B:141:0x022d  */
    /* JADX WARN: Code duplicated, block: B:143:0x0231  */
    /* JADX WARN: Code duplicated, block: B:146:0x0239 A[LOOP:3: B:142:0x022f->B:146:0x0239, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:149:0x0240 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x0242  */
    /* JADX WARN: Code duplicated, block: B:152:0x0246  */
    /* JADX WARN: Code duplicated, block: B:154:0x024a  */
    /* JADX WARN: Code duplicated, block: B:156:0x024e  */
    /* JADX WARN: Code duplicated, block: B:159:0x025b  */
    /* JADX WARN: Code duplicated, block: B:162:0x026c  */
    /* JADX WARN: Code duplicated, block: B:166:0x0273  */
    /* JADX WARN: Code duplicated, block: B:171:0x02a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:177:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:183:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x023c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:73:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:86:0x0101  */
    /* JADX WARN: Code duplicated, block: B:87:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0110  */
    /* JADX WARN: Code duplicated, block: B:92:0x0113  */
    /* JADX WARN: Code duplicated, block: B:94:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x011b A[ADDED_TO_REGION] */
    public final void setScanner(int i5, int i6, f fVar, a aVar) {
        long[][] jArr;
        boolean z6;
        long[][] jArr2;
        boolean z7;
        int i7;
        int i8;
        boolean z8;
        boolean z9;
        long[][][] jArr3;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z10;
        boolean z11;
        long j6;
        int i13;
        long j7;
        long[] jArr4;
        boolean z12;
        long[] jArr5;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        int i16;
        long[] jArr6;
        int i17;
        int i18;
        boolean z15;
        long[] jArr7;
        int length;
        boolean z16;
        long[] jArr8;
        int i19;
        int i20;
        int i21;
        long j8;
        boolean zE;
        long j9;
        boolean zE2;
        boolean zE3;
        int length2;
        int i22;
        boolean z17;
        int i23 = i5;
        int i24 = i6;
        a aVar2 = aVar;
        if (aVar2.d(fVar)) {
            this.d.f742a = 0;
        }
        if (i24 < i23 || i23 + 1 < 1) {
            throwIndexOutOfBoundsException(i5, i6);
        }
        if (i23 == i24) {
            return;
        }
        int iC = aVar2.c();
        boolean z18 = (iC & 1) != 0;
        boolean z19 = (iC & 2) != 0;
        boolean z20 = (iC & 4) != 0;
        boolean z21 = (iC & 8) != 0;
        int i25 = i23 >> 6;
        long j10 = (-1) << i23;
        int i26 = i24 - 1;
        int i27 = i26 >> 6;
        long j11 = (-1) >>> (-i24);
        long[][][] jArr9 = this.b;
        int length3 = jArr9.length;
        long[][][] jArr10 = fVar != null ? fVar.b : null;
        int length4 = jArr10 != null ? fVar.b.length : 0;
        int i28 = i23 >> 16;
        int i29 = (i23 >> 11) & 31;
        int i30 = i25 & 31;
        int i31 = i26 >> 16;
        int i32 = (i26 >> 11) & 31;
        int i33 = i27 & 31;
        int i34 = (i31 << 5) + i32;
        boolean z22 = i25 == 0 && j10 == -1;
        boolean z23 = i29 == 0;
        long[][][] jArr11 = jArr10;
        int i35 = i28;
        while (i23 < i24) {
            if (i35 < length3) {
                jArr = jArr9[i35];
                z6 = jArr != null;
                if (i35 < length4 || jArr11 == null) {
                    jArr2 = null;
                } else {
                    jArr2 = jArr11[i35];
                    z7 = jArr2 != null;
                    if ((!(z6 && !z7 && z18) && ((z6 || !z19) && (z7 || !z20))) || !z22 || i35 == i31) {
                        int i36 = length3;
                        if (i35 == i31) {
                            i7 = i32 + 1;
                        } else {
                            i7 = 32;
                        }
                        i8 = i29;
                        z8 = z23;
                        z9 = z22;
                        jArr3 = jArr9;
                        i9 = i36;
                        while (i8 != i7) {
                            if (z6) {
                                jArr4 = jArr[i8];
                                z12 = jArr4 != null;
                                if (z7) {
                                    jArr5 = jArr2[i8];
                                    z13 = jArr5 != null;
                                    int i37 = length4;
                                    i14 = (i35 << 5) + i8;
                                    if (i34 != i14) {
                                        z14 = true;
                                    } else {
                                        z14 = false;
                                    }
                                    if (((z12 && !z13 && z18) || ((!z12 && z19) || (!z13 && z20))) && z9 && z14) {
                                        if (z6) {
                                            jArr[i8] = null;
                                        }
                                        i17 = i7;
                                        i18 = i31;
                                        z16 = z18;
                                        z15 = z19;
                                        j8 = j10;
                                        i19 = i25;
                                        i21 = i27;
                                        j9 = j11;
                                    } else {
                                        i15 = i14 << 5;
                                        if (z14) {
                                            i16 = 32;
                                        } else {
                                            i16 = i33;
                                        }
                                        if (z12) {
                                            jArr6 = jArr4;
                                        } else {
                                            jArr6 = this.e;
                                        }
                                        if (!z13) {
                                            jArr5 = f748h;
                                        }
                                        if (!z9 || !z14) {
                                            i17 = i7;
                                            i18 = i31;
                                            z15 = z19;
                                            jArr7 = jArr5;
                                            length = i9;
                                            z16 = z18;
                                            jArr8 = jArr6;
                                            i19 = i25;
                                            if (z9) {
                                                boolean zA = aVar.a(jArr8, jArr7, i15, 0, i16);
                                                int i38 = i16;
                                                i21 = i27;
                                                j9 = j11;
                                                zE3 = zA & aVar.e(i15, i38, jArr8, jArr7, j9);
                                                j8 = j10;
                                            } else {
                                                i20 = i16;
                                                i21 = i27;
                                                if (i19 == i21) {
                                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                                    j8 = j10;
                                                    j9 = j11;
                                                } else {
                                                    long j12 = j10;
                                                    int i39 = i30;
                                                    j8 = j12;
                                                    zE = aVar.e(i15, i39, jArr8, jArr7, j12) & aVar.a(jArr8, jArr7, i15, i39 + 1, i20);
                                                    if (i20 != 32) {
                                                        jArr8 = jArr8;
                                                        j9 = j11;
                                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                                    } else {
                                                        jArr8 = jArr8;
                                                        j9 = j11;
                                                        zE2 = zE;
                                                    }
                                                }
                                                zE3 = zE2;
                                                z9 = true;
                                            }
                                            if (zE3) {
                                                length2 = jArr8.length;
                                                i22 = 0;
                                                while (true) {
                                                    if (i22 >= length2) {
                                                        jArr8 = jArr8;
                                                        zE3 = true;
                                                        break;
                                                    } else if (jArr8[i22] != 0) {
                                                        jArr8 = jArr8;
                                                        zE3 = false;
                                                        break;
                                                    } else {
                                                        jArr8 = jArr8;
                                                        i22++;
                                                    }
                                                }
                                            }
                                        } else if (!z21 || z13) {
                                            long[] jArr12 = jArr6;
                                            boolean z24 = z18;
                                            i19 = i25;
                                            long[] jArr13 = jArr5;
                                            z16 = z24;
                                            i18 = i31;
                                            z15 = z19;
                                            length = i9;
                                            i17 = i7;
                                            jArr8 = jArr12;
                                            zE3 = aVar2.a(jArr12, jArr13, i15, 0, 32);
                                            i21 = i27;
                                            j8 = j10;
                                            j9 = j11;
                                        } else {
                                            int length5 = jArr6.length;
                                            long[] jArr14 = jArr6;
                                            int i40 = 0;
                                            while (true) {
                                                if (i40 >= length5) {
                                                    zE3 = true;
                                                    break;
                                                } else {
                                                    if (jArr14[i40] != 0) {
                                                        zE3 = false;
                                                        break;
                                                    }
                                                    i40++;
                                                }
                                            }
                                            i18 = i31;
                                            z16 = z18;
                                            z15 = z19;
                                            j8 = j10;
                                            i19 = i25;
                                            length = i9;
                                            i21 = i27;
                                            j9 = j11;
                                            jArr8 = jArr14;
                                            i17 = i7;
                                        }
                                        if (zE3) {
                                            if (z6) {
                                                jArr[i8] = null;
                                            }
                                        } else if (jArr8 == this.e) {
                                            if (i23 >= this.c) {
                                                i(i23);
                                                long[][][] jArr15 = this.b;
                                                jArr3 = jArr15;
                                                length = jArr15.length;
                                            }
                                            if (jArr == null) {
                                                long[][] jArr16 = new long[32][];
                                                jArr3[i35] = jArr16;
                                                jArr = jArr16;
                                                z6 = true;
                                            }
                                            jArr[i8] = jArr8;
                                            this.e = new long[32];
                                        }
                                        i9 = length;
                                        if (z6 || jArr[i8] == null) {
                                            z17 = true;
                                        } else {
                                            z17 = false;
                                        }
                                        z8 &= z17;
                                    }
                                    i8++;
                                    aVar2 = aVar;
                                    j11 = j9;
                                    i25 = i19;
                                    i27 = i21;
                                    z18 = z16;
                                    i7 = i17;
                                    i31 = i18;
                                    length4 = i37;
                                    i34 = i34;
                                    z19 = z15;
                                    j10 = j8;
                                    i30 = 0;
                                } else {
                                    jArr5 = null;
                                }
                                int i310 = length4;
                                i14 = (i35 << 5) + i8;
                                if (i34 != i14) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (z12) {
                                }
                                i15 = i14 << 5;
                                if (z14) {
                                    i16 = 32;
                                } else {
                                    i16 = i33;
                                }
                                if (z12) {
                                    jArr6 = this.e;
                                } else {
                                    jArr6 = jArr4;
                                }
                                if (!z13) {
                                    jArr5 = f748h;
                                }
                                if (!z9) {
                                    i17 = i7;
                                    i18 = i31;
                                    z15 = z19;
                                    jArr7 = jArr5;
                                    length = i9;
                                    z16 = z18;
                                    jArr8 = jArr6;
                                    i19 = i25;
                                    if (z9) {
                                        boolean zA2 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                        int i311 = i16;
                                        i21 = i27;
                                        j9 = j11;
                                        zE3 = zA2 & aVar.e(i15, i311, jArr8, jArr7, j9);
                                        j8 = j10;
                                    } else {
                                        i20 = i16;
                                        i21 = i27;
                                        if (i19 == i21) {
                                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                            j8 = j10;
                                            j9 = j11;
                                        } else {
                                            long j13 = j10;
                                            int i312 = i30;
                                            j8 = j13;
                                            zE = aVar.e(i15, i312, jArr8, jArr7, j13) & aVar.a(jArr8, jArr7, i15, i312 + 1, i20);
                                            if (i20 != 32) {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                            } else {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE;
                                            }
                                        }
                                        zE3 = zE2;
                                        z9 = true;
                                    }
                                    if (zE3) {
                                        length2 = jArr8.length;
                                        i22 = 0;
                                        while (true) {
                                            if (i22 >= length2) {
                                                jArr8 = jArr8;
                                                zE3 = true;
                                                break;
                                            } else if (jArr8[i22] != 0) {
                                                jArr8 = jArr8;
                                                zE3 = false;
                                                break;
                                            } else {
                                                jArr8 = jArr8;
                                                i22++;
                                            }
                                        }
                                    }
                                } else {
                                    i17 = i7;
                                    i18 = i31;
                                    z15 = z19;
                                    jArr7 = jArr5;
                                    length = i9;
                                    z16 = z18;
                                    jArr8 = jArr6;
                                    i19 = i25;
                                    if (z9) {
                                        boolean zA3 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                        int i313 = i16;
                                        i21 = i27;
                                        j9 = j11;
                                        zE3 = zA3 & aVar.e(i15, i313, jArr8, jArr7, j9);
                                        j8 = j10;
                                    } else {
                                        i20 = i16;
                                        i21 = i27;
                                        if (i19 == i21) {
                                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                            j8 = j10;
                                            j9 = j11;
                                        } else {
                                            long j14 = j10;
                                            int i314 = i30;
                                            j8 = j14;
                                            zE = aVar.e(i15, i314, jArr8, jArr7, j14) & aVar.a(jArr8, jArr7, i15, i314 + 1, i20);
                                            if (i20 != 32) {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                            } else {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE;
                                            }
                                        }
                                        zE3 = zE2;
                                        z9 = true;
                                    }
                                    if (zE3) {
                                        length2 = jArr8.length;
                                        i22 = 0;
                                        while (true) {
                                            if (i22 >= length2) {
                                                jArr8 = jArr8;
                                                zE3 = true;
                                                break;
                                            } else if (jArr8[i22] != 0) {
                                                jArr8 = jArr8;
                                                zE3 = false;
                                                break;
                                            } else {
                                                jArr8 = jArr8;
                                                i22++;
                                            }
                                        }
                                    }
                                }
                                if (zE3) {
                                    if (z6) {
                                        jArr[i8] = null;
                                    }
                                } else if (jArr8 == this.e) {
                                    if (i23 >= this.c) {
                                        i(i23);
                                        long[][][] jArr17 = this.b;
                                        jArr3 = jArr17;
                                        length = jArr17.length;
                                    }
                                    if (jArr == null) {
                                        long[][] jArr18 = new long[32][];
                                        jArr3[i35] = jArr18;
                                        jArr = jArr18;
                                        z6 = true;
                                    }
                                    jArr[i8] = jArr8;
                                    this.e = new long[32];
                                }
                                i9 = length;
                                if (z6) {
                                    z17 = true;
                                } else {
                                    z17 = true;
                                }
                                z8 &= z17;
                                i8++;
                                aVar2 = aVar;
                                j11 = j9;
                                i25 = i19;
                                i27 = i21;
                                z18 = z16;
                                i7 = i17;
                                i31 = i18;
                                length4 = i310;
                                i34 = i34;
                                z19 = z15;
                                j10 = j8;
                                i30 = 0;
                            } else {
                                jArr4 = null;
                            }
                            if (z7) {
                                jArr5 = jArr2[i8];
                                if (jArr5 != null) {
                                }
                                int i315 = length4;
                                i14 = (i35 << 5) + i8;
                                if (i34 != i14) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (z12) {
                                }
                                i15 = i14 << 5;
                                if (z14) {
                                    i16 = 32;
                                } else {
                                    i16 = i33;
                                }
                                if (z12) {
                                    jArr6 = this.e;
                                } else {
                                    jArr6 = jArr4;
                                }
                                if (!z13) {
                                    jArr5 = f748h;
                                }
                                if (!z9) {
                                    i17 = i7;
                                    i18 = i31;
                                    z15 = z19;
                                    jArr7 = jArr5;
                                    length = i9;
                                    z16 = z18;
                                    jArr8 = jArr6;
                                    i19 = i25;
                                    if (z9) {
                                        boolean zA4 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                        int i316 = i16;
                                        i21 = i27;
                                        j9 = j11;
                                        zE3 = zA4 & aVar.e(i15, i316, jArr8, jArr7, j9);
                                        j8 = j10;
                                    } else {
                                        i20 = i16;
                                        i21 = i27;
                                        if (i19 == i21) {
                                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                            j8 = j10;
                                            j9 = j11;
                                        } else {
                                            long j15 = j10;
                                            int i317 = i30;
                                            j8 = j15;
                                            zE = aVar.e(i15, i317, jArr8, jArr7, j15) & aVar.a(jArr8, jArr7, i15, i317 + 1, i20);
                                            if (i20 != 32) {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                            } else {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE;
                                            }
                                        }
                                        zE3 = zE2;
                                        z9 = true;
                                    }
                                    if (zE3) {
                                        length2 = jArr8.length;
                                        i22 = 0;
                                        while (true) {
                                            if (i22 >= length2) {
                                                jArr8 = jArr8;
                                                zE3 = true;
                                                break;
                                            } else if (jArr8[i22] != 0) {
                                                jArr8 = jArr8;
                                                zE3 = false;
                                                break;
                                            } else {
                                                jArr8 = jArr8;
                                                i22++;
                                            }
                                        }
                                    }
                                } else {
                                    i17 = i7;
                                    i18 = i31;
                                    z15 = z19;
                                    jArr7 = jArr5;
                                    length = i9;
                                    z16 = z18;
                                    jArr8 = jArr6;
                                    i19 = i25;
                                    if (z9) {
                                        boolean zA5 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                        int i318 = i16;
                                        i21 = i27;
                                        j9 = j11;
                                        zE3 = zA5 & aVar.e(i15, i318, jArr8, jArr7, j9);
                                        j8 = j10;
                                    } else {
                                        i20 = i16;
                                        i21 = i27;
                                        if (i19 == i21) {
                                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                            j8 = j10;
                                            j9 = j11;
                                        } else {
                                            long j16 = j10;
                                            int i319 = i30;
                                            j8 = j16;
                                            zE = aVar.e(i15, i319, jArr8, jArr7, j16) & aVar.a(jArr8, jArr7, i15, i319 + 1, i20);
                                            if (i20 != 32) {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                            } else {
                                                jArr8 = jArr8;
                                                j9 = j11;
                                                zE2 = zE;
                                            }
                                        }
                                        zE3 = zE2;
                                        z9 = true;
                                    }
                                    if (zE3) {
                                        length2 = jArr8.length;
                                        i22 = 0;
                                        while (true) {
                                            if (i22 >= length2) {
                                                jArr8 = jArr8;
                                                zE3 = true;
                                                break;
                                            } else if (jArr8[i22] != 0) {
                                                jArr8 = jArr8;
                                                zE3 = false;
                                                break;
                                            } else {
                                                jArr8 = jArr8;
                                                i22++;
                                            }
                                        }
                                    }
                                }
                                if (zE3) {
                                    if (z6) {
                                        jArr[i8] = null;
                                    }
                                } else if (jArr8 == this.e) {
                                    if (i23 >= this.c) {
                                        i(i23);
                                        long[][][] jArr19 = this.b;
                                        jArr3 = jArr19;
                                        length = jArr19.length;
                                    }
                                    if (jArr == null) {
                                        long[][] jArr110 = new long[32][];
                                        jArr3[i35] = jArr110;
                                        jArr = jArr110;
                                        z6 = true;
                                    }
                                    jArr[i8] = jArr8;
                                    this.e = new long[32];
                                }
                                i9 = length;
                                if (z6) {
                                    z17 = true;
                                } else {
                                    z17 = true;
                                }
                                z8 &= z17;
                                i8++;
                                aVar2 = aVar;
                                j11 = j9;
                                i25 = i19;
                                i27 = i21;
                                z18 = z16;
                                i7 = i17;
                                i31 = i18;
                                length4 = i315;
                                i34 = i34;
                                z19 = z15;
                                j10 = j8;
                                i30 = 0;
                            } else {
                                jArr5 = null;
                            }
                            int i3110 = length4;
                            i14 = (i35 << 5) + i8;
                            if (i34 != i14) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z12) {
                            }
                            i15 = i14 << 5;
                            if (z14) {
                                i16 = 32;
                            } else {
                                i16 = i33;
                            }
                            if (z12) {
                                jArr6 = this.e;
                            } else {
                                jArr6 = jArr4;
                            }
                            if (!z13) {
                                jArr5 = f748h;
                            }
                            if (!z9) {
                                i17 = i7;
                                i18 = i31;
                                z15 = z19;
                                jArr7 = jArr5;
                                length = i9;
                                z16 = z18;
                                jArr8 = jArr6;
                                i19 = i25;
                                if (z9) {
                                    boolean zA6 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                    int i3111 = i16;
                                    i21 = i27;
                                    j9 = j11;
                                    zE3 = zA6 & aVar.e(i15, i3111, jArr8, jArr7, j9);
                                    j8 = j10;
                                } else {
                                    i20 = i16;
                                    i21 = i27;
                                    if (i19 == i21) {
                                        zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                        j8 = j10;
                                        j9 = j11;
                                    } else {
                                        long j17 = j10;
                                        int i3112 = i30;
                                        j8 = j17;
                                        zE = aVar.e(i15, i3112, jArr8, jArr7, j17) & aVar.a(jArr8, jArr7, i15, i3112 + 1, i20);
                                        if (i20 != 32) {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                        } else {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE;
                                        }
                                    }
                                    zE3 = zE2;
                                    z9 = true;
                                }
                                if (zE3) {
                                    length2 = jArr8.length;
                                    i22 = 0;
                                    while (true) {
                                        if (i22 >= length2) {
                                            jArr8 = jArr8;
                                            zE3 = true;
                                            break;
                                        } else if (jArr8[i22] != 0) {
                                            jArr8 = jArr8;
                                            zE3 = false;
                                            break;
                                        } else {
                                            jArr8 = jArr8;
                                            i22++;
                                        }
                                    }
                                }
                            } else {
                                i17 = i7;
                                i18 = i31;
                                z15 = z19;
                                jArr7 = jArr5;
                                length = i9;
                                z16 = z18;
                                jArr8 = jArr6;
                                i19 = i25;
                                if (z9) {
                                    boolean zA7 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                    int i3113 = i16;
                                    i21 = i27;
                                    j9 = j11;
                                    zE3 = zA7 & aVar.e(i15, i3113, jArr8, jArr7, j9);
                                    j8 = j10;
                                } else {
                                    i20 = i16;
                                    i21 = i27;
                                    if (i19 == i21) {
                                        zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                        j8 = j10;
                                        j9 = j11;
                                    } else {
                                        long j18 = j10;
                                        int i3114 = i30;
                                        j8 = j18;
                                        zE = aVar.e(i15, i3114, jArr8, jArr7, j18) & aVar.a(jArr8, jArr7, i15, i3114 + 1, i20);
                                        if (i20 != 32) {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                        } else {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE;
                                        }
                                    }
                                    zE3 = zE2;
                                    z9 = true;
                                }
                                if (zE3) {
                                    length2 = jArr8.length;
                                    i22 = 0;
                                    while (true) {
                                        if (i22 >= length2) {
                                            jArr8 = jArr8;
                                            zE3 = true;
                                            break;
                                        } else if (jArr8[i22] != 0) {
                                            jArr8 = jArr8;
                                            zE3 = false;
                                            break;
                                        } else {
                                            jArr8 = jArr8;
                                            i22++;
                                        }
                                    }
                                }
                            }
                            if (zE3) {
                                if (z6) {
                                    jArr[i8] = null;
                                }
                            } else if (jArr8 == this.e) {
                                if (i23 >= this.c) {
                                    i(i23);
                                    long[][][] jArr111 = this.b;
                                    jArr3 = jArr111;
                                    length = jArr111.length;
                                }
                                if (jArr == null) {
                                    long[][] jArr112 = new long[32][];
                                    jArr3[i35] = jArr112;
                                    jArr = jArr112;
                                    z6 = true;
                                }
                                jArr[i8] = jArr8;
                                this.e = new long[32];
                            }
                            i9 = length;
                            if (z6) {
                                z17 = true;
                            } else {
                                z17 = true;
                            }
                            z8 &= z17;
                            i8++;
                            aVar2 = aVar;
                            j11 = j9;
                            i25 = i19;
                            i27 = i21;
                            z18 = z16;
                            i7 = i17;
                            i31 = i18;
                            length4 = i3110;
                            i34 = i34;
                            z19 = z15;
                            j10 = j8;
                            i30 = 0;
                        }
                        i10 = length4;
                        i11 = i34;
                        i12 = i31;
                        z10 = z18;
                        z11 = z19;
                        j6 = j10;
                        int i41 = i30;
                        int i42 = i9;
                        i13 = i27;
                        j7 = j11;
                        if (i8 == 32 && z8 && i35 < i42) {
                            jArr3[i35] = null;
                        }
                        i30 = i41;
                        length3 = i42;
                        jArr9 = jArr3;
                        z22 = z9;
                        z23 = z8;
                    } else {
                        if (i35 < length3) {
                            jArr9[i35] = null;
                        }
                        i10 = length4;
                        i11 = i34;
                        i12 = i31;
                        z10 = z18;
                        z11 = z19;
                        j6 = j10;
                        i13 = i27;
                        j7 = j11;
                    }
                    i35++;
                    i25 = i35 << 10;
                    i23 = i35 << 16;
                    if (i23 < 0) {
                        i23 = Integer.MAX_VALUE;
                    }
                    i24 = i6;
                    aVar2 = aVar;
                    j11 = j7;
                    i27 = i13;
                    z18 = z10;
                    i31 = i12;
                    length4 = i10;
                    i34 = i11;
                    z19 = z11;
                    j10 = j6;
                    i29 = 0;
                }
                if (z6) {
                }
                int i320 = length3;
                if (i35 == i31) {
                    i7 = i32 + 1;
                } else {
                    i7 = 32;
                }
                i8 = i29;
                z8 = z23;
                z9 = z22;
                jArr3 = jArr9;
                i9 = i320;
                while (i8 != i7) {
                    if (z6) {
                        jArr4 = jArr[i8];
                        if (jArr4 != null) {
                        }
                        if (z7) {
                            jArr5 = jArr2[i8];
                            if (jArr5 != null) {
                            }
                            int i3115 = length4;
                            i14 = (i35 << 5) + i8;
                            if (i34 != i14) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z12) {
                            }
                            i15 = i14 << 5;
                            if (z14) {
                                i16 = 32;
                            } else {
                                i16 = i33;
                            }
                            if (z12) {
                                jArr6 = this.e;
                            } else {
                                jArr6 = jArr4;
                            }
                            if (!z13) {
                                jArr5 = f748h;
                            }
                            if (!z9) {
                                i17 = i7;
                                i18 = i31;
                                z15 = z19;
                                jArr7 = jArr5;
                                length = i9;
                                z16 = z18;
                                jArr8 = jArr6;
                                i19 = i25;
                                if (z9) {
                                    boolean zA8 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                    int i3116 = i16;
                                    i21 = i27;
                                    j9 = j11;
                                    zE3 = zA8 & aVar.e(i15, i3116, jArr8, jArr7, j9);
                                    j8 = j10;
                                } else {
                                    i20 = i16;
                                    i21 = i27;
                                    if (i19 == i21) {
                                        zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                        j8 = j10;
                                        j9 = j11;
                                    } else {
                                        long j19 = j10;
                                        int i3117 = i30;
                                        j8 = j19;
                                        zE = aVar.e(i15, i3117, jArr8, jArr7, j19) & aVar.a(jArr8, jArr7, i15, i3117 + 1, i20);
                                        if (i20 != 32) {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                        } else {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE;
                                        }
                                    }
                                    zE3 = zE2;
                                    z9 = true;
                                }
                                if (zE3) {
                                    length2 = jArr8.length;
                                    i22 = 0;
                                    while (true) {
                                        if (i22 >= length2) {
                                            jArr8 = jArr8;
                                            zE3 = true;
                                            break;
                                        } else if (jArr8[i22] != 0) {
                                            jArr8 = jArr8;
                                            zE3 = false;
                                            break;
                                        } else {
                                            jArr8 = jArr8;
                                            i22++;
                                        }
                                    }
                                }
                            } else {
                                i17 = i7;
                                i18 = i31;
                                z15 = z19;
                                jArr7 = jArr5;
                                length = i9;
                                z16 = z18;
                                jArr8 = jArr6;
                                i19 = i25;
                                if (z9) {
                                    boolean zA9 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                    int i3118 = i16;
                                    i21 = i27;
                                    j9 = j11;
                                    zE3 = zA9 & aVar.e(i15, i3118, jArr8, jArr7, j9);
                                    j8 = j10;
                                } else {
                                    i20 = i16;
                                    i21 = i27;
                                    if (i19 == i21) {
                                        zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                        j8 = j10;
                                        j9 = j11;
                                    } else {
                                        long j110 = j10;
                                        int i3119 = i30;
                                        j8 = j110;
                                        zE = aVar.e(i15, i3119, jArr8, jArr7, j110) & aVar.a(jArr8, jArr7, i15, i3119 + 1, i20);
                                        if (i20 != 32) {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                        } else {
                                            jArr8 = jArr8;
                                            j9 = j11;
                                            zE2 = zE;
                                        }
                                    }
                                    zE3 = zE2;
                                    z9 = true;
                                }
                                if (zE3) {
                                    length2 = jArr8.length;
                                    i22 = 0;
                                    while (true) {
                                        if (i22 >= length2) {
                                            jArr8 = jArr8;
                                            zE3 = true;
                                            break;
                                        } else if (jArr8[i22] != 0) {
                                            jArr8 = jArr8;
                                            zE3 = false;
                                            break;
                                        } else {
                                            jArr8 = jArr8;
                                            i22++;
                                        }
                                    }
                                }
                            }
                            if (zE3) {
                                if (z6) {
                                    jArr[i8] = null;
                                }
                            } else if (jArr8 == this.e) {
                                if (i23 >= this.c) {
                                    i(i23);
                                    long[][][] jArr113 = this.b;
                                    jArr3 = jArr113;
                                    length = jArr113.length;
                                }
                                if (jArr == null) {
                                    long[][] jArr114 = new long[32][];
                                    jArr3[i35] = jArr114;
                                    jArr = jArr114;
                                    z6 = true;
                                }
                                jArr[i8] = jArr8;
                                this.e = new long[32];
                            }
                            i9 = length;
                            if (z6) {
                                z17 = true;
                            } else {
                                z17 = true;
                            }
                            z8 &= z17;
                            i8++;
                            aVar2 = aVar;
                            j11 = j9;
                            i25 = i19;
                            i27 = i21;
                            z18 = z16;
                            i7 = i17;
                            i31 = i18;
                            length4 = i3115;
                            i34 = i34;
                            z19 = z15;
                            j10 = j8;
                            i30 = 0;
                        } else {
                            jArr5 = null;
                        }
                        int i31110 = length4;
                        i14 = (i35 << 5) + i8;
                        if (i34 != i14) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z12) {
                        }
                        i15 = i14 << 5;
                        if (z14) {
                            i16 = 32;
                        } else {
                            i16 = i33;
                        }
                        if (z12) {
                            jArr6 = this.e;
                        } else {
                            jArr6 = jArr4;
                        }
                        if (!z13) {
                            jArr5 = f748h;
                        }
                        if (!z9) {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA10 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i31111 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA10 & aVar.e(i15, i31111, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j111 = j10;
                                    int i31112 = i30;
                                    j8 = j111;
                                    zE = aVar.e(i15, i31112, jArr8, jArr7, j111) & aVar.a(jArr8, jArr7, i15, i31112 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        } else {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA11 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i31113 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA11 & aVar.e(i15, i31113, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j112 = j10;
                                    int i31114 = i30;
                                    j8 = j112;
                                    zE = aVar.e(i15, i31114, jArr8, jArr7, j112) & aVar.a(jArr8, jArr7, i15, i31114 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        }
                        if (zE3) {
                            if (z6) {
                                jArr[i8] = null;
                            }
                        } else if (jArr8 == this.e) {
                            if (i23 >= this.c) {
                                i(i23);
                                long[][][] jArr115 = this.b;
                                jArr3 = jArr115;
                                length = jArr115.length;
                            }
                            if (jArr == null) {
                                long[][] jArr116 = new long[32][];
                                jArr3[i35] = jArr116;
                                jArr = jArr116;
                                z6 = true;
                            }
                            jArr[i8] = jArr8;
                            this.e = new long[32];
                        }
                        i9 = length;
                        if (z6) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        z8 &= z17;
                        i8++;
                        aVar2 = aVar;
                        j11 = j9;
                        i25 = i19;
                        i27 = i21;
                        z18 = z16;
                        i7 = i17;
                        i31 = i18;
                        length4 = i31110;
                        i34 = i34;
                        z19 = z15;
                        j10 = j8;
                        i30 = 0;
                    } else {
                        jArr4 = null;
                    }
                    if (z7) {
                        jArr5 = jArr2[i8];
                        if (jArr5 != null) {
                        }
                        int i31115 = length4;
                        i14 = (i35 << 5) + i8;
                        if (i34 != i14) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z12) {
                        }
                        i15 = i14 << 5;
                        if (z14) {
                            i16 = 32;
                        } else {
                            i16 = i33;
                        }
                        if (z12) {
                            jArr6 = this.e;
                        } else {
                            jArr6 = jArr4;
                        }
                        if (!z13) {
                            jArr5 = f748h;
                        }
                        if (!z9) {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA12 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i31116 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA12 & aVar.e(i15, i31116, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j113 = j10;
                                    int i31117 = i30;
                                    j8 = j113;
                                    zE = aVar.e(i15, i31117, jArr8, jArr7, j113) & aVar.a(jArr8, jArr7, i15, i31117 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        } else {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA13 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i31118 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA13 & aVar.e(i15, i31118, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j114 = j10;
                                    int i31119 = i30;
                                    j8 = j114;
                                    zE = aVar.e(i15, i31119, jArr8, jArr7, j114) & aVar.a(jArr8, jArr7, i15, i31119 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        }
                        if (zE3) {
                            if (z6) {
                                jArr[i8] = null;
                            }
                        } else if (jArr8 == this.e) {
                            if (i23 >= this.c) {
                                i(i23);
                                long[][][] jArr117 = this.b;
                                jArr3 = jArr117;
                                length = jArr117.length;
                            }
                            if (jArr == null) {
                                long[][] jArr118 = new long[32][];
                                jArr3[i35] = jArr118;
                                jArr = jArr118;
                                z6 = true;
                            }
                            jArr[i8] = jArr8;
                            this.e = new long[32];
                        }
                        i9 = length;
                        if (z6) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        z8 &= z17;
                        i8++;
                        aVar2 = aVar;
                        j11 = j9;
                        i25 = i19;
                        i27 = i21;
                        z18 = z16;
                        i7 = i17;
                        i31 = i18;
                        length4 = i31115;
                        i34 = i34;
                        z19 = z15;
                        j10 = j8;
                        i30 = 0;
                    } else {
                        jArr5 = null;
                    }
                    int i311110 = length4;
                    i14 = (i35 << 5) + i8;
                    if (i34 != i14) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z12) {
                    }
                    i15 = i14 << 5;
                    if (z14) {
                        i16 = 32;
                    } else {
                        i16 = i33;
                    }
                    if (z12) {
                        jArr6 = this.e;
                    } else {
                        jArr6 = jArr4;
                    }
                    if (!z13) {
                        jArr5 = f748h;
                    }
                    if (!z9) {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA14 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i311111 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA14 & aVar.e(i15, i311111, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j115 = j10;
                                int i311112 = i30;
                                j8 = j115;
                                zE = aVar.e(i15, i311112, jArr8, jArr7, j115) & aVar.a(jArr8, jArr7, i15, i311112 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    } else {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA15 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i311113 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA15 & aVar.e(i15, i311113, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j116 = j10;
                                int i311114 = i30;
                                j8 = j116;
                                zE = aVar.e(i15, i311114, jArr8, jArr7, j116) & aVar.a(jArr8, jArr7, i15, i311114 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    }
                    if (zE3) {
                        if (z6) {
                            jArr[i8] = null;
                        }
                    } else if (jArr8 == this.e) {
                        if (i23 >= this.c) {
                            i(i23);
                            long[][][] jArr119 = this.b;
                            jArr3 = jArr119;
                            length = jArr119.length;
                        }
                        if (jArr == null) {
                            long[][] jArr1110 = new long[32][];
                            jArr3[i35] = jArr1110;
                            jArr = jArr1110;
                            z6 = true;
                        }
                        jArr[i8] = jArr8;
                        this.e = new long[32];
                    }
                    i9 = length;
                    if (z6) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    z8 &= z17;
                    i8++;
                    aVar2 = aVar;
                    j11 = j9;
                    i25 = i19;
                    i27 = i21;
                    z18 = z16;
                    i7 = i17;
                    i31 = i18;
                    length4 = i311110;
                    i34 = i34;
                    z19 = z15;
                    j10 = j8;
                    i30 = 0;
                }
                i10 = length4;
                i11 = i34;
                i12 = i31;
                z10 = z18;
                z11 = z19;
                j6 = j10;
                int i43 = i30;
                int i44 = i9;
                i13 = i27;
                j7 = j11;
                if (i8 == 32) {
                    jArr3[i35] = null;
                }
                i30 = i43;
                length3 = i44;
                jArr9 = jArr3;
                z22 = z9;
                z23 = z8;
                i35++;
                i25 = i35 << 10;
                i23 = i35 << 16;
                if (i23 < 0) {
                    i23 = Integer.MAX_VALUE;
                }
                i24 = i6;
                aVar2 = aVar;
                j11 = j7;
                i27 = i13;
                z18 = z10;
                i31 = i12;
                length4 = i10;
                i34 = i11;
                z19 = z11;
                j10 = j6;
                i29 = 0;
            } else {
                jArr = null;
            }
            if (i35 < length4) {
                jArr2 = null;
            } else {
                jArr2 = null;
            }
            if (z6) {
            }
            int i321 = length3;
            if (i35 == i31) {
                i7 = i32 + 1;
            } else {
                i7 = 32;
            }
            i8 = i29;
            z8 = z23;
            z9 = z22;
            jArr3 = jArr9;
            i9 = i321;
            while (i8 != i7) {
                if (z6) {
                    jArr4 = jArr[i8];
                    if (jArr4 != null) {
                    }
                    if (z7) {
                        jArr5 = jArr2[i8];
                        if (jArr5 != null) {
                        }
                        int i311115 = length4;
                        i14 = (i35 << 5) + i8;
                        if (i34 != i14) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z12) {
                        }
                        i15 = i14 << 5;
                        if (z14) {
                            i16 = 32;
                        } else {
                            i16 = i33;
                        }
                        if (z12) {
                            jArr6 = this.e;
                        } else {
                            jArr6 = jArr4;
                        }
                        if (!z13) {
                            jArr5 = f748h;
                        }
                        if (!z9) {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA16 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i311116 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA16 & aVar.e(i15, i311116, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j117 = j10;
                                    int i311117 = i30;
                                    j8 = j117;
                                    zE = aVar.e(i15, i311117, jArr8, jArr7, j117) & aVar.a(jArr8, jArr7, i15, i311117 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        } else {
                            i17 = i7;
                            i18 = i31;
                            z15 = z19;
                            jArr7 = jArr5;
                            length = i9;
                            z16 = z18;
                            jArr8 = jArr6;
                            i19 = i25;
                            if (z9) {
                                boolean zA17 = aVar.a(jArr8, jArr7, i15, 0, i16);
                                int i311118 = i16;
                                i21 = i27;
                                j9 = j11;
                                zE3 = zA17 & aVar.e(i15, i311118, jArr8, jArr7, j9);
                                j8 = j10;
                            } else {
                                i20 = i16;
                                i21 = i27;
                                if (i19 == i21) {
                                    zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                    j8 = j10;
                                    j9 = j11;
                                } else {
                                    long j118 = j10;
                                    int i311119 = i30;
                                    j8 = j118;
                                    zE = aVar.e(i15, i311119, jArr8, jArr7, j118) & aVar.a(jArr8, jArr7, i15, i311119 + 1, i20);
                                    if (i20 != 32) {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                    } else {
                                        jArr8 = jArr8;
                                        j9 = j11;
                                        zE2 = zE;
                                    }
                                }
                                zE3 = zE2;
                                z9 = true;
                            }
                            if (zE3) {
                                length2 = jArr8.length;
                                i22 = 0;
                                while (true) {
                                    if (i22 >= length2) {
                                        jArr8 = jArr8;
                                        zE3 = true;
                                        break;
                                    } else if (jArr8[i22] != 0) {
                                        jArr8 = jArr8;
                                        zE3 = false;
                                        break;
                                    } else {
                                        jArr8 = jArr8;
                                        i22++;
                                    }
                                }
                            }
                        }
                        if (zE3) {
                            if (z6) {
                                jArr[i8] = null;
                            }
                        } else if (jArr8 == this.e) {
                            if (i23 >= this.c) {
                                i(i23);
                                long[][][] jArr1111 = this.b;
                                jArr3 = jArr1111;
                                length = jArr1111.length;
                            }
                            if (jArr == null) {
                                long[][] jArr1112 = new long[32][];
                                jArr3[i35] = jArr1112;
                                jArr = jArr1112;
                                z6 = true;
                            }
                            jArr[i8] = jArr8;
                            this.e = new long[32];
                        }
                        i9 = length;
                        if (z6) {
                            z17 = true;
                        } else {
                            z17 = true;
                        }
                        z8 &= z17;
                        i8++;
                        aVar2 = aVar;
                        j11 = j9;
                        i25 = i19;
                        i27 = i21;
                        z18 = z16;
                        i7 = i17;
                        i31 = i18;
                        length4 = i311115;
                        i34 = i34;
                        z19 = z15;
                        j10 = j8;
                        i30 = 0;
                    } else {
                        jArr5 = null;
                    }
                    int i3111110 = length4;
                    i14 = (i35 << 5) + i8;
                    if (i34 != i14) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z12) {
                    }
                    i15 = i14 << 5;
                    if (z14) {
                        i16 = 32;
                    } else {
                        i16 = i33;
                    }
                    if (z12) {
                        jArr6 = this.e;
                    } else {
                        jArr6 = jArr4;
                    }
                    if (!z13) {
                        jArr5 = f748h;
                    }
                    if (!z9) {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA18 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i3111111 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA18 & aVar.e(i15, i3111111, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j119 = j10;
                                int i3111112 = i30;
                                j8 = j119;
                                zE = aVar.e(i15, i3111112, jArr8, jArr7, j119) & aVar.a(jArr8, jArr7, i15, i3111112 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    } else {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA19 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i3111113 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA19 & aVar.e(i15, i3111113, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j1110 = j10;
                                int i3111114 = i30;
                                j8 = j1110;
                                zE = aVar.e(i15, i3111114, jArr8, jArr7, j1110) & aVar.a(jArr8, jArr7, i15, i3111114 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    }
                    if (zE3) {
                        if (z6) {
                            jArr[i8] = null;
                        }
                    } else if (jArr8 == this.e) {
                        if (i23 >= this.c) {
                            i(i23);
                            long[][][] jArr1113 = this.b;
                            jArr3 = jArr1113;
                            length = jArr1113.length;
                        }
                        if (jArr == null) {
                            long[][] jArr1114 = new long[32][];
                            jArr3[i35] = jArr1114;
                            jArr = jArr1114;
                            z6 = true;
                        }
                        jArr[i8] = jArr8;
                        this.e = new long[32];
                    }
                    i9 = length;
                    if (z6) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    z8 &= z17;
                    i8++;
                    aVar2 = aVar;
                    j11 = j9;
                    i25 = i19;
                    i27 = i21;
                    z18 = z16;
                    i7 = i17;
                    i31 = i18;
                    length4 = i3111110;
                    i34 = i34;
                    z19 = z15;
                    j10 = j8;
                    i30 = 0;
                } else {
                    jArr4 = null;
                }
                if (z7) {
                    jArr5 = jArr2[i8];
                    if (jArr5 != null) {
                    }
                    int i3111115 = length4;
                    i14 = (i35 << 5) + i8;
                    if (i34 != i14) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z12) {
                    }
                    i15 = i14 << 5;
                    if (z14) {
                        i16 = 32;
                    } else {
                        i16 = i33;
                    }
                    if (z12) {
                        jArr6 = this.e;
                    } else {
                        jArr6 = jArr4;
                    }
                    if (!z13) {
                        jArr5 = f748h;
                    }
                    if (!z9) {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA110 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i3111116 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA110 & aVar.e(i15, i3111116, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j1111 = j10;
                                int i3111117 = i30;
                                j8 = j1111;
                                zE = aVar.e(i15, i3111117, jArr8, jArr7, j1111) & aVar.a(jArr8, jArr7, i15, i3111117 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    } else {
                        i17 = i7;
                        i18 = i31;
                        z15 = z19;
                        jArr7 = jArr5;
                        length = i9;
                        z16 = z18;
                        jArr8 = jArr6;
                        i19 = i25;
                        if (z9) {
                            boolean zA111 = aVar.a(jArr8, jArr7, i15, 0, i16);
                            int i3111118 = i16;
                            i21 = i27;
                            j9 = j11;
                            zE3 = zA111 & aVar.e(i15, i3111118, jArr8, jArr7, j9);
                            j8 = j10;
                        } else {
                            i20 = i16;
                            i21 = i27;
                            if (i19 == i21) {
                                zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                                j8 = j10;
                                j9 = j11;
                            } else {
                                long j1112 = j10;
                                int i3111119 = i30;
                                j8 = j1112;
                                zE = aVar.e(i15, i3111119, jArr8, jArr7, j1112) & aVar.a(jArr8, jArr7, i15, i3111119 + 1, i20);
                                if (i20 != 32) {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                                } else {
                                    jArr8 = jArr8;
                                    j9 = j11;
                                    zE2 = zE;
                                }
                            }
                            zE3 = zE2;
                            z9 = true;
                        }
                        if (zE3) {
                            length2 = jArr8.length;
                            i22 = 0;
                            while (true) {
                                if (i22 >= length2) {
                                    jArr8 = jArr8;
                                    zE3 = true;
                                    break;
                                } else if (jArr8[i22] != 0) {
                                    jArr8 = jArr8;
                                    zE3 = false;
                                    break;
                                } else {
                                    jArr8 = jArr8;
                                    i22++;
                                }
                            }
                        }
                    }
                    if (zE3) {
                        if (z6) {
                            jArr[i8] = null;
                        }
                    } else if (jArr8 == this.e) {
                        if (i23 >= this.c) {
                            i(i23);
                            long[][][] jArr1115 = this.b;
                            jArr3 = jArr1115;
                            length = jArr1115.length;
                        }
                        if (jArr == null) {
                            long[][] jArr1116 = new long[32][];
                            jArr3[i35] = jArr1116;
                            jArr = jArr1116;
                            z6 = true;
                        }
                        jArr[i8] = jArr8;
                        this.e = new long[32];
                    }
                    i9 = length;
                    if (z6) {
                        z17 = true;
                    } else {
                        z17 = true;
                    }
                    z8 &= z17;
                    i8++;
                    aVar2 = aVar;
                    j11 = j9;
                    i25 = i19;
                    i27 = i21;
                    z18 = z16;
                    i7 = i17;
                    i31 = i18;
                    length4 = i3111115;
                    i34 = i34;
                    z19 = z15;
                    j10 = j8;
                    i30 = 0;
                } else {
                    jArr5 = null;
                }
                int i31111110 = length4;
                i14 = (i35 << 5) + i8;
                if (i34 != i14) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z12) {
                }
                i15 = i14 << 5;
                if (z14) {
                    i16 = 32;
                } else {
                    i16 = i33;
                }
                if (z12) {
                    jArr6 = this.e;
                } else {
                    jArr6 = jArr4;
                }
                if (!z13) {
                    jArr5 = f748h;
                }
                if (!z9) {
                    i17 = i7;
                    i18 = i31;
                    z15 = z19;
                    jArr7 = jArr5;
                    length = i9;
                    z16 = z18;
                    jArr8 = jArr6;
                    i19 = i25;
                    if (z9) {
                        boolean zA112 = aVar.a(jArr8, jArr7, i15, 0, i16);
                        int i31111111 = i16;
                        i21 = i27;
                        j9 = j11;
                        zE3 = zA112 & aVar.e(i15, i31111111, jArr8, jArr7, j9);
                        j8 = j10;
                    } else {
                        i20 = i16;
                        i21 = i27;
                        if (i19 == i21) {
                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                            j8 = j10;
                            j9 = j11;
                        } else {
                            long j1113 = j10;
                            int i31111112 = i30;
                            j8 = j1113;
                            zE = aVar.e(i15, i31111112, jArr8, jArr7, j1113) & aVar.a(jArr8, jArr7, i15, i31111112 + 1, i20);
                            if (i20 != 32) {
                                jArr8 = jArr8;
                                j9 = j11;
                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                            } else {
                                jArr8 = jArr8;
                                j9 = j11;
                                zE2 = zE;
                            }
                        }
                        zE3 = zE2;
                        z9 = true;
                    }
                    if (zE3) {
                        length2 = jArr8.length;
                        i22 = 0;
                        while (true) {
                            if (i22 >= length2) {
                                jArr8 = jArr8;
                                zE3 = true;
                                break;
                            } else if (jArr8[i22] != 0) {
                                jArr8 = jArr8;
                                zE3 = false;
                                break;
                            } else {
                                jArr8 = jArr8;
                                i22++;
                            }
                        }
                    }
                } else {
                    i17 = i7;
                    i18 = i31;
                    z15 = z19;
                    jArr7 = jArr5;
                    length = i9;
                    z16 = z18;
                    jArr8 = jArr6;
                    i19 = i25;
                    if (z9) {
                        boolean zA113 = aVar.a(jArr8, jArr7, i15, 0, i16);
                        int i31111113 = i16;
                        i21 = i27;
                        j9 = j11;
                        zE3 = zA113 & aVar.e(i15, i31111113, jArr8, jArr7, j9);
                        j8 = j10;
                    } else {
                        i20 = i16;
                        i21 = i27;
                        if (i19 == i21) {
                            zE2 = aVar.e(i15, i30, jArr8, jArr7, j10 & j11);
                            j8 = j10;
                            j9 = j11;
                        } else {
                            long j1114 = j10;
                            int i31111114 = i30;
                            j8 = j1114;
                            zE = aVar.e(i15, i31111114, jArr8, jArr7, j1114) & aVar.a(jArr8, jArr7, i15, i31111114 + 1, i20);
                            if (i20 != 32) {
                                jArr8 = jArr8;
                                j9 = j11;
                                zE2 = zE & aVar.e(i15, i20, jArr8, jArr7, j9);
                            } else {
                                jArr8 = jArr8;
                                j9 = j11;
                                zE2 = zE;
                            }
                        }
                        zE3 = zE2;
                        z9 = true;
                    }
                    if (zE3) {
                        length2 = jArr8.length;
                        i22 = 0;
                        while (true) {
                            if (i22 >= length2) {
                                jArr8 = jArr8;
                                zE3 = true;
                                break;
                            } else if (jArr8[i22] != 0) {
                                jArr8 = jArr8;
                                zE3 = false;
                                break;
                            } else {
                                jArr8 = jArr8;
                                i22++;
                            }
                        }
                    }
                }
                if (zE3) {
                    if (z6) {
                        jArr[i8] = null;
                    }
                } else if (jArr8 == this.e) {
                    if (i23 >= this.c) {
                        i(i23);
                        long[][][] jArr1117 = this.b;
                        jArr3 = jArr1117;
                        length = jArr1117.length;
                    }
                    if (jArr == null) {
                        long[][] jArr1118 = new long[32][];
                        jArr3[i35] = jArr1118;
                        jArr = jArr1118;
                        z6 = true;
                    }
                    jArr[i8] = jArr8;
                    this.e = new long[32];
                }
                i9 = length;
                if (z6) {
                    z17 = true;
                } else {
                    z17 = true;
                }
                z8 &= z17;
                i8++;
                aVar2 = aVar;
                j11 = j9;
                i25 = i19;
                i27 = i21;
                z18 = z16;
                i7 = i17;
                i31 = i18;
                length4 = i31111110;
                i34 = i34;
                z19 = z15;
                j10 = j8;
                i30 = 0;
            }
            i10 = length4;
            i11 = i34;
            i12 = i31;
            z10 = z18;
            z11 = z19;
            j6 = j10;
            int i45 = i30;
            int i46 = i9;
            i13 = i27;
            j7 = j11;
            if (i8 == 32) {
                jArr3[i35] = null;
            }
            i30 = i45;
            length3 = i46;
            jArr9 = jArr3;
            z22 = z9;
            z23 = z8;
            i35++;
            i25 = i35 << 10;
            i23 = i35 << 16;
            if (i23 < 0) {
                i23 = Integer.MAX_VALUE;
            }
            i24 = i6;
            aVar2 = aVar;
            j11 = j7;
            i27 = i13;
            z18 = z10;
            i31 = i12;
            length4 = i10;
            i34 = i11;
            z19 = z11;
            j10 = j6;
            i29 = 0;
        }
        aVar.b();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    public final String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append('{');
        int iH = h(0);
        while (iH >= 0) {
            sb.append(iH);
            int iH2 = h(iH + 1);
            if (this.f758a <= 0) {
                iH = iH2;
            } else {
                if (iH2 < 0) {
                    break;
                }
                int iG = g(iH);
                if (iG < 0) {
                    iG = Integer.MAX_VALUE;
                }
                if (iH + this.f758a < iG) {
                    sb.append("..");
                    sb.append(iG - 1);
                    iH = h(iG);
                } else {
                    iH = iH2;
                }
            }
            if (iH >= 0) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void xor(int i5, int i6, f fVar) {
        setScanner(i5, i6, fVar, f757q);
    }

    public void and(int i5, int i6, f fVar) {
        setScanner(i5, i6, fVar, f749i);
    }

    public f() {
        this(1, 2);
    }

    public f(int i5) {
        this(i5, 2);
    }
}
