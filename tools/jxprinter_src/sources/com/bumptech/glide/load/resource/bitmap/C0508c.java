package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class C0508c implements p126w0.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p126w0.u f3104a = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final p126w0.u b = p126w0.u.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.a arrayPool;

    public C0508c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.arrayPool = aVar;
    }

    @Override // p126w0.y
    @NonNull
    public p126w0.c getEncodeStrategy(@NonNull p126w0.v vVar) {
        return p126w0.c.b;
    }

    @Override // p126w0.y, p126w0.d
    public boolean encode(@NonNull com.bumptech.glide.load.engine.O o6, @NonNull File file, @NonNull p126w0.v vVar) throws Throwable {
        boolean z6;
        Bitmap bitmap = (Bitmap) o6.get();
        p126w0.u uVar = b;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) vVar.get(uVar);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        long logTime = L0.l.getLogTime();
        int iIntValue = ((Integer) vVar.get(f3104a)).intValue();
        OutputStream cVar = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        cVar = this.arrayPool != null ? new com.bumptech.glide.load.data.c(fileOutputStream, this.arrayPool) : fileOutputStream;
                        bitmap.compress(compressFormat, iIntValue, cVar);
                        cVar.close();
                        try {
                            cVar.close();
                        } catch (IOException unused) {
                        }
                        z6 = true;
                    } catch (IOException e) {
                        e = e;
                        cVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z6 = false;
                    } catch (Throwable th) {
                        th = th;
                        cVar = fileOutputStream;
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (IOException e6) {
                e = e6;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + L0.s.getBitmapByteSize(bitmap) + " in " + L0.l.a(logTime) + ", options format: " + vVar.get(uVar) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z6;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Deprecated
    public C0508c() {
        this.arrayPool = null;
    }
}
