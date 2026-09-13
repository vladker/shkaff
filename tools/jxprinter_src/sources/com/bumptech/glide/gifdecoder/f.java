package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class f implements b {

    @ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2885a;

    @ColorInt
    private int[] act;
    public ByteBuffer b;

    @NonNull
    private Bitmap.Config bitmapConfig;
    public byte[] c;
    public e d;
    public short[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f2886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f2887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f2888h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2889i;

    @Nullable
    private Boolean isFirstFrameTransparent;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f2890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Bitmap f2891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2893m;

    @ColorInt
    private int[] mainScratch;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2896p;

    @ColorInt
    private final int[] pct;

    public f(@NonNull a aVar, d dVar, ByteBuffer byteBuffer) {
        this(aVar, dVar, byteBuffer, 1);
    }

    @ColorInt
    private int averageColorsNear(int i5, int i6, int i7) {
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i5; i13 < this.f2894n + i5; i13++) {
            byte[] bArr = this.f2888h;
            if (i13 >= bArr.length || i13 >= i6) {
                break;
            }
            int i14 = this.act[bArr[i13] & UnsignedBytes.MAX_VALUE];
            if (i14 != 0) {
                i8 += (i14 >> 24) & 255;
                i9 += (i14 >> 16) & 255;
                i10 += (i14 >> 8) & 255;
                i11 += i14 & 255;
                i12++;
            }
        }
        int i15 = i5 + i7;
        for (int i16 = i15; i16 < this.f2894n + i15; i16++) {
            byte[] bArr2 = this.f2888h;
            if (i16 >= bArr2.length || i16 >= i6) {
                break;
            }
            int i17 = this.act[bArr2[i16] & UnsignedBytes.MAX_VALUE];
            if (i17 != 0) {
                i8 += (i17 >> 24) & 255;
                i9 += (i17 >> 16) & 255;
                i10 += (i17 >> 8) & 255;
                i11 += i17 & 255;
                i12++;
            }
        }
        if (i12 == 0) {
            return 0;
        }
        return ((i8 / i12) << 24) | ((i9 / i12) << 16) | ((i10 / i12) << 8) | (i11 / i12);
    }

    @NonNull
    private e getHeaderParser() {
        if (this.d == null) {
            this.d = new e();
        }
        return this.d;
    }

    public final void a() {
        this.f2890j = null;
        byte[] bArr = this.f2888h;
        a aVar = this.f2885a;
        if (bArr != null) {
            aVar.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            aVar.release(iArr);
        }
        Bitmap bitmap = this.f2891k;
        if (bitmap != null) {
            aVar.release(bitmap);
        }
        this.f2891k = null;
        this.b = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            aVar.release(bArr2);
        }
    }

    public final int b() {
        return (this.mainScratch.length * 4) + this.b.limit() + this.f2888h.length;
    }

    public final Bitmap c() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap bitmapObtain = this.f2885a.obtain(this.f2896p, this.f2895o, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        bitmapObtain.setHasAlpha(true);
        return bitmapObtain;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v19, types: [short] */
    /* JADX WARN: Type inference failed for: r6v21 */
    public final Bitmap d(c cVar, c cVar2) {
        int i5;
        byte b;
        int i6;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        int i10;
        short s6;
        int i11;
        Bitmap bitmap;
        int i12;
        int[] iArr2 = this.mainScratch;
        a aVar = this.f2885a;
        byte b6 = 0;
        if (cVar2 == null) {
            Bitmap bitmap2 = this.f2891k;
            if (bitmap2 != null) {
                aVar.release(bitmap2);
            }
            this.f2891k = null;
            Arrays.fill(iArr2, 0);
        }
        if (cVar2 != null && cVar2.f2874g == 3 && this.f2891k == null) {
            Arrays.fill(iArr2, 0);
        }
        if (cVar2 != null && (i11 = cVar2.f2874g) > 0) {
            if (i11 == 2) {
                if (cVar.f2873f) {
                    i12 = 0;
                } else {
                    d dVar = this.f2890j;
                    i12 = dVar.bgColor;
                    if (cVar.lct != null && dVar.f2882i == cVar.f2875h) {
                        i12 = 0;
                    }
                }
                int i13 = cVar2.d;
                int i14 = this.f2894n;
                int i15 = i13 / i14;
                int i16 = cVar2.b / i14;
                int i17 = cVar2.c / i14;
                int i18 = cVar2.f2872a / i14;
                int i19 = this.f2896p;
                int i20 = (i16 * i19) + i18;
                int i21 = (i15 * i19) + i20;
                while (i20 < i21) {
                    int i22 = i20 + i17;
                    for (int i23 = i20; i23 < i22; i23++) {
                        iArr2[i23] = i12;
                    }
                    i20 += this.f2896p;
                }
            } else if (i11 == 3 && (bitmap = this.f2891k) != null) {
                int i24 = this.f2896p;
                bitmap.getPixels(iArr2, 0, i24, 0, 0, i24, this.f2895o);
            }
        }
        int[] iArr3 = iArr2;
        this.b.position(cVar.f2877j);
        int i25 = cVar.c * cVar.d;
        byte[] bArr = this.f2888h;
        if (bArr == null || bArr.length < i25) {
            this.f2888h = aVar.obtainByteArray(i25);
        }
        byte[] bArr2 = this.f2888h;
        if (this.e == null) {
            this.e = new short[4096];
        }
        short[] sArr = this.e;
        if (this.f2886f == null) {
            this.f2886f = new byte[4096];
        }
        byte[] bArr3 = this.f2886f;
        if (this.f2887g == null) {
            this.f2887g = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = this.f2887g;
        int i26 = this.b.get() & UnsignedBytes.MAX_VALUE;
        int i27 = 1;
        int i28 = 1 << i26;
        int i29 = i28 + 1;
        int i30 = i28 + 2;
        int i31 = i26 + 1;
        int i32 = (1 << i31) - 1;
        int i33 = 0;
        while (i33 < i28) {
            sArr[i33] = 0;
            bArr3[i33] = (byte) i33;
            i33++;
            i27 = i27;
        }
        int i34 = i27;
        byte[] bArr5 = this.c;
        int i35 = i31;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = i30;
        int i45 = i32;
        int i46 = -1;
        while (true) {
            i5 = 8;
            if (i36 >= i25) {
                iArr3 = iArr3;
                b = b6;
                break;
            }
            if (i37 == 0) {
                i10 = -1;
                int i47 = this.b.get() & UnsignedBytes.MAX_VALUE;
                if (i47 > 0) {
                    ByteBuffer byteBuffer = this.b;
                    byteBuffer.get(this.c, 0, Math.min(i47, byteBuffer.remaining()));
                }
                if (i47 <= 0) {
                    this.f2893m = 3;
                    b = 0;
                    break;
                }
                i37 = i47;
                i38 = 0;
            } else {
                iArr3 = iArr3;
                sArr = sArr;
                i10 = -1;
            }
            i40 += (bArr5[i38] & UnsignedBytes.MAX_VALUE) << i39;
            i38++;
            i37--;
            i39 += 8;
            i44 = i44;
            i35 = i35;
            i46 = i46;
            i42 = i42;
            while (true) {
                i39 = i39;
                if (i39 < i35) {
                    b6 = 0;
                    break;
                }
                int i48 = i40 & i45;
                i40 >>= i35;
                i39 -= i35;
                if (i48 == i28) {
                    i35 = i31;
                    i44 = i30;
                    i45 = i32;
                    i39 = i39;
                    i46 = i10;
                } else {
                    if (i48 == i29) {
                        b6 = 0;
                        break;
                    }
                    int i49 = i36;
                    if (i46 == i10) {
                        bArr2[i41] = bArr3[i48];
                        i41++;
                        i36 = i49 + 1;
                        i46 = i48;
                        i42 = i46;
                    } else {
                        if (i48 >= i44) {
                            bArr4[i43] = (byte) i42;
                            i43++;
                            s6 = i46;
                        } else {
                            s6 = i48;
                        }
                        while (s6 >= i28) {
                            bArr4[i43] = bArr3[s6];
                            i43++;
                            s6 = sArr[s6];
                        }
                        i42 = bArr3[s6] & UnsignedBytes.MAX_VALUE;
                        byte b7 = (byte) i42;
                        bArr2[i41] = b7;
                        while (true) {
                            i41++;
                            i49++;
                            if (i43 <= 0) {
                                break;
                            }
                            i43--;
                            bArr2[i41] = bArr4[i43];
                        }
                        if (i44 < 4096) {
                            sArr[i44] = (short) i46;
                            bArr3[i44] = b7;
                            i44++;
                            if ((i44 & i45) == 0 && i44 < 4096) {
                                i35++;
                                i45 += i44;
                            }
                        }
                        i36 = i49;
                        i46 = i48;
                    }
                    i10 = -1;
                }
            }
        }
        Arrays.fill(bArr2, i41, i25, b);
        if (cVar.e || this.f2894n != i34) {
            int[] iArr4 = this.mainScratch;
            int i50 = cVar.d;
            int i51 = this.f2894n;
            int i52 = i50 / i51;
            int i53 = cVar.b / i51;
            int i54 = cVar.c / i51;
            int i55 = cVar.f2872a / i51;
            boolean z6 = this.f2889i == 0;
            int i56 = this.f2896p;
            int i57 = this.f2895o;
            byte[] bArr6 = this.f2888h;
            int[] iArr5 = this.act;
            Boolean bool = this.isFirstFrameTransparent;
            int i58 = 0;
            int i59 = 1;
            int i60 = 0;
            while (i60 < i52) {
                int[] iArr6 = iArr4;
                if (cVar.e) {
                    if (i58 >= i52) {
                        i59++;
                        if (i59 == 2) {
                            i58 = 4;
                        } else if (i59 == 3) {
                            i5 = 4;
                            i58 = 2;
                        } else if (i59 == 4) {
                            i58 = 1;
                            i5 = 2;
                        }
                    }
                    i6 = i58 + i5;
                } else {
                    i6 = i58;
                    i58 = i60;
                }
                int i61 = i58 + i53;
                int i62 = i6;
                boolean z7 = i51 == 1;
                if (i61 < i57) {
                    int i63 = i61 * i56;
                    int i64 = i63 + i55;
                    boolean z8 = z7;
                    int i65 = i64 + i54;
                    int i66 = i63 + i56;
                    if (i66 < i65) {
                        i65 = i66;
                    }
                    i7 = i52;
                    int i67 = i60 * i51 * cVar.c;
                    if (z8) {
                        int i68 = i64;
                        while (i68 < i65) {
                            int i69 = i68;
                            int i70 = iArr5[bArr6[i67] & UnsignedBytes.MAX_VALUE];
                            if (i70 != 0) {
                                iArr6[i69] = i70;
                            } else if (z6 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i67 += i51;
                            i68 = i69 + 1;
                        }
                    } else {
                        int i71 = ((i65 - i64) * i51) + i67;
                        i8 = i51;
                        int i72 = i64;
                        while (i72 < i65) {
                            int i73 = i65;
                            int iAverageColorsNear = averageColorsNear(i67, i71, cVar.c);
                            if (iAverageColorsNear != 0) {
                                iArr6[i72] = iAverageColorsNear;
                            } else if (z6 && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i67 += i8;
                            i72++;
                            i65 = i73;
                        }
                    }
                    i60++;
                    iArr4 = iArr6;
                    i58 = i62;
                    i51 = i8;
                    i52 = i7;
                } else {
                    i7 = i52;
                }
                i8 = i51;
                i60++;
                iArr4 = iArr6;
                i58 = i62;
                i51 = i8;
                i52 = i7;
            }
            if (this.isFirstFrameTransparent == null) {
                this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
            }
        } else {
            int[] iArr7 = this.mainScratch;
            int i74 = cVar.d;
            int i75 = cVar.b;
            int i76 = cVar.c;
            int i77 = cVar.f2872a;
            byte b8 = this.f2889i == 0 ? (byte) 1 : b;
            int i78 = this.f2896p;
            byte[] bArr7 = this.f2888h;
            int[] iArr8 = this.act;
            byte b9 = -1;
            for (int i79 = b; i79 < i74; i79++) {
                int i80 = (i79 + i75) * i78;
                int i81 = i80 + i77;
                int i82 = i81 + i76;
                int i83 = i80 + i78;
                if (i83 < i82) {
                    i82 = i83;
                }
                int i84 = cVar.c * i79;
                while (i81 < i82) {
                    int[] iArr9 = iArr7;
                    byte b10 = bArr7[i84];
                    int i85 = i74;
                    int i86 = b10 & UnsignedBytes.MAX_VALUE;
                    if (i86 != b9) {
                        int i87 = iArr8[i86];
                        if (i87 != 0) {
                            iArr9[i81] = i87;
                        } else {
                            b9 = b10;
                        }
                    }
                    i84++;
                    i81++;
                    iArr7 = iArr9;
                    i74 = i85;
                }
            }
            Boolean bool2 = this.isFirstFrameTransparent;
            this.isFirstFrameTransparent = Boolean.valueOf((bool2 != null && bool2.booleanValue()) || !(this.isFirstFrameTransparent != null || b8 == 0 || b9 == -1));
        }
        if (this.f2892l && ((i9 = cVar.f2874g) == 0 || i9 == 1)) {
            if (this.f2891k == null) {
                this.f2891k = c();
            }
            Bitmap bitmap3 = this.f2891k;
            int i88 = this.f2896p;
            iArr = iArr3;
            bitmap3.setPixels(iArr, 0, i88, 0, 0, i88, this.f2895o);
        } else {
            iArr = iArr3;
        }
        Bitmap bitmapC = c();
        int i89 = this.f2896p;
        bitmapC.setPixels(iArr, 0, i89, 0, 0, i89, this.f2895o);
        return bitmapC;
    }

    @Override // com.bumptech.glide.gifdecoder.b
    @NonNull
    public ByteBuffer getData() {
        return this.b;
    }

    @Override // com.bumptech.glide.gifdecoder.b
    @Deprecated
    public int getLoopCount() {
        int i5 = this.f2890j.f2883j;
        if (i5 == -1) {
            return 1;
        }
        return i5;
    }

    @Override // com.bumptech.glide.gifdecoder.b
    @Nullable
    public synchronized Bitmap getNextFrame() {
        try {
            if (this.f2890j.b <= 0 || this.f2889i < 0) {
                if (Log.isLoggable("f", 3)) {
                    Log.d("f", "Unable to decode frame, frameCount=" + this.f2890j.b + ", framePointer=" + this.f2889i);
                }
                this.f2893m = 1;
            }
            int i5 = this.f2893m;
            if (i5 != 1 && i5 != 2) {
                this.f2893m = 0;
                if (this.c == null) {
                    this.c = this.f2885a.obtainByteArray(255);
                }
                c cVar = (c) this.f2890j.d.get(this.f2889i);
                int i6 = this.f2889i - 1;
                c cVar2 = i6 >= 0 ? (c) this.f2890j.d.get(i6) : null;
                int[] iArr = cVar.lct;
                if (iArr == null) {
                    iArr = this.f2890j.gct;
                }
                this.act = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("f", 3)) {
                        Log.d("f", "No valid color table found for frame #" + this.f2889i);
                    }
                    this.f2893m = 1;
                    return null;
                }
                if (cVar.f2873f) {
                    System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                    int[] iArr2 = this.pct;
                    this.act = iArr2;
                    iArr2[cVar.f2875h] = 0;
                    if (cVar.f2874g == 2 && this.f2889i == 0) {
                        this.isFirstFrameTransparent = Boolean.TRUE;
                    }
                }
                return d(cVar, cVar2);
            }
            if (Log.isLoggable("f", 3)) {
                Log.d("f", "Unable to decode frame, status=" + this.f2893m);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public int read(@Nullable InputStream inputStream, int i5) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i5 > 0 ? i5 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i6 = inputStream.read(bArr, 0, 16384);
                    if (i6 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i6);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w("f", "Error reading data from stream", e);
            }
        } else {
            this.f2893m = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                Log.w("f", "Error closing stream", e6);
            }
        }
        return this.f2893m;
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public synchronized void setData(@NonNull d dVar, @NonNull byte[] bArr) {
        setData(dVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public void setDefaultBitmapConfig(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.bitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    public f(@NonNull a aVar, d dVar, ByteBuffer byteBuffer, int i5) {
        this(aVar);
        setData(dVar, byteBuffer, i5);
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public synchronized void setData(@NonNull d dVar, @NonNull ByteBuffer byteBuffer) {
        setData(dVar, byteBuffer, 1);
    }

    public f(@NonNull a aVar) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.f2885a = aVar;
        this.f2890j = new d();
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public synchronized void setData(@NonNull d dVar, @NonNull ByteBuffer byteBuffer, int i5) {
        try {
            if (i5 > 0) {
                int iHighestOneBit = Integer.highestOneBit(i5);
                int i6 = 0;
                this.f2893m = 0;
                this.f2890j = dVar;
                this.f2889i = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.b = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.b.order(ByteOrder.LITTLE_ENDIAN);
                this.f2892l = false;
                ArrayList arrayList = dVar.d;
                int size = arrayList.size();
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    if (((c) obj).f2874g == 3) {
                        this.f2892l = true;
                        break;
                    }
                }
                this.f2894n = iHighestOneBit;
                int i7 = dVar.e;
                this.f2896p = i7 / iHighestOneBit;
                int i8 = dVar.f2879f;
                this.f2895o = i8 / iHighestOneBit;
                this.f2888h = this.f2885a.obtainByteArray(i7 * i8);
                this.mainScratch = this.f2885a.obtainIntArray(this.f2896p * this.f2895o);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.b
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            d header = getHeaderParser().setData(bArr).parseHeader();
            this.f2890j = header;
            if (bArr != null) {
                setData(header, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2893m;
    }
}
