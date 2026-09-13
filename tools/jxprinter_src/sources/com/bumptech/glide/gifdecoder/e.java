package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.UnsignedBytes;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public ByteBuffer b;
    public d c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f2884a = new byte[256];
    public int d = 0;

    @Nullable
    private int[] readColorTable(int i5) {
        byte[] bArr = new byte[i5 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i5) {
                int i8 = bArr[i7] & UnsignedBytes.MAX_VALUE;
                int i9 = i7 + 2;
                int i10 = bArr[i7 + 1] & UnsignedBytes.MAX_VALUE;
                i7 += 3;
                int i11 = i6 + 1;
                iArr[i6] = (i10 << 8) | (i8 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i9] & UnsignedBytes.MAX_VALUE);
                i6 = i11;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.f2878a = 1;
            return iArr;
        }
    }

    public final boolean a() {
        return this.c.f2878a != 0;
    }

    public final int b() {
        try {
            return this.b.get() & UnsignedBytes.MAX_VALUE;
        } catch (Exception unused) {
            this.c.f2878a = 1;
            return 0;
        }
    }

    public final void c() {
        int iB = b();
        this.d = iB;
        if (iB <= 0) {
            return;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            try {
                int i7 = this.d;
                if (i5 >= i7) {
                    return;
                }
                i6 = i7 - i5;
                this.b.get(this.f2884a, i5, i6);
                i5 += i6;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbS = androidx.collection.a.s("Error Reading Block n: ", i5, i6, " count: ", " blockSize: ");
                    sbS.append(this.d);
                    Log.d("GifHeaderParser", sbS.toString(), e);
                }
                this.c.f2878a = 1;
                return;
            }
        }
    }

    public final void d() {
        int iB;
        do {
            iB = b();
            this.b.position(Math.min(this.b.position() + iB, this.b.limit()));
        } while (iB > 0);
    }

    @NonNull
    public d parseHeader() {
        byte[] bArr;
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 6; i5++) {
            sb.append((char) b());
        }
        if (sb.toString().startsWith("GIF")) {
            this.c.e = this.b.getShort();
            this.c.f2879f = this.b.getShort();
            int iB = b();
            d dVar = this.c;
            dVar.f2880g = (iB & 128) != 0;
            dVar.f2881h = (int) Math.pow(2.0d, (iB & 7) + 1);
            this.c.f2882i = b();
            d dVar2 = this.c;
            b();
            dVar2.getClass();
            if (this.c.f2880g && !a()) {
                d dVar3 = this.c;
                dVar3.gct = readColorTable(dVar3.f2881h);
                d dVar4 = this.c;
                dVar4.bgColor = dVar4.gct[dVar4.f2882i];
            }
        } else {
            this.c.f2878a = 1;
        }
        if (!a()) {
            boolean z6 = false;
            while (!z6 && !a() && this.c.b <= Integer.MAX_VALUE) {
                int iB2 = b();
                if (iB2 == 33) {
                    int iB3 = b();
                    if (iB3 == 1) {
                        d();
                    } else if (iB3 == 249) {
                        this.c.c = new c();
                        b();
                        int iB4 = b();
                        c cVar = this.c.c;
                        int i6 = (iB4 & 28) >> 2;
                        cVar.f2874g = i6;
                        if (i6 == 0) {
                            cVar.f2874g = 1;
                        }
                        cVar.f2873f = (iB4 & 1) != 0;
                        short s6 = this.b.getShort();
                        if (s6 < 2) {
                            s6 = 10;
                        }
                        c cVar2 = this.c.c;
                        cVar2.f2876i = s6 * 10;
                        cVar2.f2875h = b();
                        b();
                    } else if (iB3 == 254) {
                        d();
                    } else if (iB3 != 255) {
                        d();
                    } else {
                        c();
                        StringBuilder sb2 = new StringBuilder();
                        int i7 = 0;
                        while (true) {
                            bArr = this.f2884a;
                            if (i7 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i7]);
                            i7++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                c();
                                if (bArr[0] == 1) {
                                    this.c.f2883j = (bArr[1] & UnsignedBytes.MAX_VALUE) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8);
                                }
                                if (this.d <= 0) {
                                    break;
                                }
                            } while (!a());
                        } else {
                            d();
                        }
                    }
                } else if (iB2 == 44) {
                    d dVar5 = this.c;
                    if (dVar5.c == null) {
                        dVar5.c = new c();
                    }
                    dVar5.c.f2872a = this.b.getShort();
                    this.c.c.b = this.b.getShort();
                    this.c.c.c = this.b.getShort();
                    this.c.c.d = this.b.getShort();
                    int iB5 = b();
                    boolean z7 = (iB5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iB5 & 7) + 1);
                    c cVar3 = this.c.c;
                    cVar3.e = (iB5 & 64) != 0;
                    if (z7) {
                        cVar3.lct = readColorTable(iPow);
                    } else {
                        cVar3.lct = null;
                    }
                    this.c.c.f2877j = this.b.position();
                    b();
                    d();
                    if (!a()) {
                        d dVar6 = this.c;
                        dVar6.b++;
                        dVar6.d.add(dVar6.c);
                    }
                } else if (iB2 != 59) {
                    this.c.f2878a = 1;
                } else {
                    z6 = true;
                }
            }
            d dVar7 = this.c;
            if (dVar7.b < 0) {
                dVar7.f2878a = 1;
            }
        }
        return this.c;
    }

    public e setData(@Nullable byte[] bArr) {
        if (bArr != null) {
            setData(ByteBuffer.wrap(bArr));
            return this;
        }
        this.b = null;
        this.c.f2878a = 2;
        return this;
    }

    public e setData(@NonNull ByteBuffer byteBuffer) {
        this.b = null;
        Arrays.fill(this.f2884a, (byte) 0);
        this.c = new d();
        this.d = 0;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
