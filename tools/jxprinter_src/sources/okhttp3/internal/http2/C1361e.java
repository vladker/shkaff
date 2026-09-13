package okhttp3.internal.http2;

import A4.C0169l;
import A4.C0173p;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: okhttp3.internal.http2.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1361e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0169l f6609a;
    public boolean c;
    public int b = Integer.MAX_VALUE;
    public C1359c[] e = new C1359c[8];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6610f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6611g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6612h = 0;
    public int d = 4096;

    public C1361e(C0169l c0169l) {
        this.f6609a = c0169l;
    }

    public final void a(int i5) {
        int i6;
        if (i5 > 0) {
            int length = this.e.length - 1;
            int i7 = 0;
            while (true) {
                i6 = this.f6610f;
                if (length < i6 || i5 <= 0) {
                    break;
                }
                int i8 = this.e[length].c;
                i5 -= i8;
                this.f6612h -= i8;
                this.f6611g--;
                i7++;
                length--;
            }
            C1359c[] c1359cArr = this.e;
            int i9 = i6 + 1;
            System.arraycopy(c1359cArr, i9, c1359cArr, i9 + i7, this.f6611g);
            C1359c[] c1359cArr2 = this.e;
            int i10 = this.f6610f + 1;
            Arrays.fill(c1359cArr2, i10, i10 + i7, (Object) null);
            this.f6610f += i7;
        }
    }

    public final void b(C1359c c1359c) {
        int i5 = c1359c.c;
        int i6 = this.d;
        if (i5 > i6) {
            Arrays.fill(this.e, (Object) null);
            this.f6610f = this.e.length - 1;
            this.f6611g = 0;
            this.f6612h = 0;
            return;
        }
        a((this.f6612h + i5) - i6);
        int i7 = this.f6611g + 1;
        C1359c[] c1359cArr = this.e;
        if (i7 > c1359cArr.length) {
            C1359c[] c1359cArr2 = new C1359c[c1359cArr.length * 2];
            System.arraycopy(c1359cArr, 0, c1359cArr2, c1359cArr.length, c1359cArr.length);
            this.f6610f = this.e.length - 1;
            this.e = c1359cArr2;
        }
        int i8 = this.f6610f;
        this.f6610f = i8 - 1;
        this.e[i8] = c1359c;
        this.f6611g++;
        this.f6612h += i5;
    }

    public final void c(int i5, int i6, int i7) {
        C0169l c0169l = this.f6609a;
        if (i5 < i6) {
            c0169l.writeByte(i5 | i7);
            return;
        }
        c0169l.writeByte(i7 | i6);
        int i8 = i5 - i6;
        while (i8 >= 128) {
            c0169l.writeByte(128 | (i8 & 127));
            i8 >>>= 7;
        }
        c0169l.writeByte(i8);
    }

    public void writeByteString(C0173p c0173p) {
        C.d.getClass();
        long j6 = 0;
        for (int i5 = 0; i5 < c0173p.size(); i5++) {
            j6 += (long) C.c[c0173p.getByte(i5) & UnsignedBytes.MAX_VALUE];
        }
        int i6 = (int) ((j6 + 7) >> 3);
        int size = c0173p.size();
        C0169l c0169l = this.f6609a;
        if (i6 >= size) {
            c(c0173p.size(), 127, 0);
            c0169l.write(c0173p);
            return;
        }
        C0169l c0169l2 = new C0169l();
        C.d.encode(c0173p, c0169l2);
        C0173p byteString = c0169l2.readByteString();
        c(byteString.size(), 127, 128);
        c0169l.write(byteString);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public void writeHeaders(List<C1359c> list) {
        int length;
        int length2;
        if (this.c) {
            int i5 = this.b;
            if (i5 < this.d) {
                c(i5, 31, 32);
            }
            this.c = false;
            this.b = Integer.MAX_VALUE;
            c(this.d, 31, 32);
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            C1359c c1359c = list.get(i6);
            C0173p asciiLowercase = c1359c.f6604a.toAsciiLowercase();
            C0173p c0173p = c1359c.b;
            Integer num = (Integer) AbstractC1362f.b.get(asciiLowercase);
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (length2 <= 1 || length2 >= 8) {
                    length = length2;
                    length2 = -1;
                } else {
                    C1359c[] c1359cArr = AbstractC1362f.f6613a;
                    if (Objects.equals(c1359cArr[iIntValue].b, c0173p)) {
                        length = length2;
                    } else if (Objects.equals(c1359cArr[length2].b, c0173p)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length2 == -1) {
                int length3 = this.e.length;
                for (int i7 = this.f6610f + 1; i7 < length3; i7++) {
                    if (Objects.equals(this.e[i7].f6604a, asciiLowercase)) {
                        if (Objects.equals(this.e[i7].b, c0173p)) {
                            length2 = (i7 - this.f6610f) + AbstractC1362f.f6613a.length;
                            break;
                        } else if (length == -1) {
                            length = (i7 - this.f6610f) + AbstractC1362f.f6613a.length;
                        }
                    }
                }
            }
            if (length2 != -1) {
                c(length2, 127, 128);
            } else if (length == -1) {
                this.f6609a.writeByte(64);
                writeByteString(asciiLowercase);
                writeByteString(c0173p);
                b(c1359c);
            } else if (!asciiLowercase.startsWith(C1359c.d) || C1359c.f6603i.equals(asciiLowercase)) {
                c(length, 63, 64);
                writeByteString(c0173p);
                b(c1359c);
            } else {
                c(length, 15, 0);
                writeByteString(c0173p);
            }
        }
    }
}
