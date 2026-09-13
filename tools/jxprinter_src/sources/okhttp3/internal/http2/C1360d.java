package okhttp3.internal.http2;

import A4.C0173p;
import A4.InterfaceC0171n;
import A4.N;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: okhttp3.internal.http2.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1360d {
    public final InterfaceC0171n b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6605a = new ArrayList();
    public C1359c[] e = new C1359c[8];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6606f = 7;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6607g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6608h = 0;
    public final int c = 4096;
    public int d = 4096;

    public C1360d(u uVar) {
        this.b = N.buffer(uVar);
    }

    private C0173p getName(int i5) throws IOException {
        if (i5 >= 0) {
            C1359c[] c1359cArr = AbstractC1362f.f6613a;
            if (i5 <= c1359cArr.length - 1) {
                return c1359cArr[i5].f6604a;
            }
        }
        int length = this.f6606f + 1 + (i5 - AbstractC1362f.f6613a.length);
        if (length >= 0) {
            C1359c[] c1359cArr2 = this.e;
            if (length < c1359cArr2.length) {
                return c1359cArr2[length].f6604a;
            }
        }
        throw new IOException("Header index too large " + (i5 + 1));
    }

    private int readByte() {
        return this.b.readByte() & UnsignedBytes.MAX_VALUE;
    }

    private void readIndexedHeader(int i5) throws IOException {
        ArrayList arrayList = this.f6605a;
        if (i5 >= 0) {
            C1359c[] c1359cArr = AbstractC1362f.f6613a;
            if (i5 <= c1359cArr.length - 1) {
                arrayList.add(c1359cArr[i5]);
                return;
            }
        }
        int length = this.f6606f + 1 + (i5 - AbstractC1362f.f6613a.length);
        if (length >= 0) {
            C1359c[] c1359cArr2 = this.e;
            if (length < c1359cArr2.length) {
                arrayList.add(c1359cArr2[length]);
                return;
            }
        }
        throw new IOException("Header index too large " + (i5 + 1));
    }

    private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i5) {
        b(new C1359c(getName(i5), readByteString()));
    }

    private void readLiteralHeaderWithIncrementalIndexingNewName() {
        b(new C1359c(AbstractC1362f.checkLowercase(readByteString()), readByteString()));
    }

    private void readLiteralHeaderWithoutIndexingIndexedName(int i5) {
        this.f6605a.add(new C1359c(getName(i5), readByteString()));
    }

    private void readLiteralHeaderWithoutIndexingNewName() {
        this.f6605a.add(new C1359c(AbstractC1362f.checkLowercase(readByteString()), readByteString()));
    }

    public final int a(int i5) {
        int i6;
        int i7 = 0;
        if (i5 > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i6 = this.f6606f;
                if (length < i6 || i5 <= 0) {
                    break;
                }
                int i8 = this.e[length].c;
                i5 -= i8;
                this.f6608h -= i8;
                this.f6607g--;
                i7++;
            }
            C1359c[] c1359cArr = this.e;
            System.arraycopy(c1359cArr, i6 + 1, c1359cArr, i6 + 1 + i7, this.f6607g);
            this.f6606f += i7;
        }
        return i7;
    }

    public final void b(C1359c c1359c) {
        this.f6605a.add(c1359c);
        int i5 = c1359c.c;
        int i6 = this.d;
        if (i5 > i6) {
            Arrays.fill(this.e, (Object) null);
            this.f6606f = this.e.length - 1;
            this.f6607g = 0;
            this.f6608h = 0;
            return;
        }
        a((this.f6608h + i5) - i6);
        int i7 = this.f6607g + 1;
        C1359c[] c1359cArr = this.e;
        if (i7 > c1359cArr.length) {
            C1359c[] c1359cArr2 = new C1359c[c1359cArr.length * 2];
            System.arraycopy(c1359cArr, 0, c1359cArr2, c1359cArr.length, c1359cArr.length);
            this.f6606f = this.e.length - 1;
            this.e = c1359cArr2;
        }
        int i8 = this.f6606f;
        this.f6606f = i8 - 1;
        this.e[i8] = c1359c;
        this.f6607g++;
        this.f6608h += i5;
    }

    public C0173p readByteString() {
        int i5 = readByte();
        boolean z6 = (i5 & 128) == 128;
        int i6 = readInt(i5, 127);
        InterfaceC0171n interfaceC0171n = this.b;
        if (!z6) {
            return interfaceC0171n.readByteString(i6);
        }
        C c = C.d;
        byte[] byteArray = interfaceC0171n.readByteArray(i6);
        c.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        S1.f fVar = c.f6592a;
        S1.f fVar2 = fVar;
        int i7 = 0;
        int i8 = 0;
        for (byte b : byteArray) {
            i7 = (i7 << 8) | (b & UnsignedBytes.MAX_VALUE);
            i8 += 8;
            while (i8 >= 8) {
                fVar2 = ((S1.f[]) fVar2.c)[(i7 >>> (i8 - 8)) & 255];
                if (((S1.f[]) fVar2.c) == null) {
                    byteArrayOutputStream.write(fVar2.f623a);
                    i8 -= fVar2.b;
                    fVar2 = fVar;
                } else {
                    i8 -= 8;
                }
            }
        }
        while (i8 > 0) {
            S1.f fVar3 = ((S1.f[]) fVar2.c)[(i7 << (8 - i8)) & 255];
            S1.f[] fVarArr = (S1.f[]) fVar3.c;
            int i9 = fVar3.b;
            if (fVarArr != null || i9 > i8) {
                break;
            }
            byteArrayOutputStream.write(fVar3.f623a);
            i8 -= i9;
            fVar2 = fVar;
        }
        return C0173p.of(byteArrayOutputStream.toByteArray());
    }

    public void readHeaders() {
        while (true) {
            InterfaceC0171n interfaceC0171n = this.b;
            if (interfaceC0171n.exhausted()) {
                return;
            }
            byte b = interfaceC0171n.readByte();
            int i5 = b & UnsignedBytes.MAX_VALUE;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 128) {
                readIndexedHeader(readInt(i5, 127) - 1);
            } else if (i5 == 64) {
                readLiteralHeaderWithIncrementalIndexingNewName();
            } else if ((b & 64) == 64) {
                readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i5, 63) - 1);
            } else if ((b & 32) == 32) {
                int i6 = readInt(i5, 31);
                this.d = i6;
                if (i6 < 0 || i6 > this.c) {
                    throw new IOException("Invalid dynamic table size update " + this.d);
                }
                int i7 = this.f6608h;
                if (i6 < i7) {
                    if (i6 == 0) {
                        Arrays.fill(this.e, (Object) null);
                        this.f6606f = this.e.length - 1;
                        this.f6607g = 0;
                        this.f6608h = 0;
                    } else {
                        a(i7 - i6);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                readLiteralHeaderWithoutIndexingNewName();
            } else {
                readLiteralHeaderWithoutIndexingIndexedName(readInt(i5, 15) - 1);
            }
        }
    }

    public int readInt(int i5, int i6) {
        int i7 = i5 & i6;
        if (i7 < i6) {
            return i7;
        }
        int i8 = 0;
        while (true) {
            int i9 = readByte();
            if ((i9 & 128) == 0) {
                return i6 + (i9 << i8);
            }
            i6 += (i9 & 127) << i8;
            i8 += 7;
        }
    }
}
