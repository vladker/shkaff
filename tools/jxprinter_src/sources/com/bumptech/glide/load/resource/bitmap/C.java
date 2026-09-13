package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C implements F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3085a;
    public final List b;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a c;

    public C(File file, List list, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3085a = file;
        this.b = list;
        this.c = aVar;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    @Nullable
    public Bitmap decodeBitmap(BitmapFactory.Options options) throws Throwable {
        K k6 = null;
        try {
            K k7 = new K(new FileInputStream(this.f3085a), this.c);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(k7, null, options);
                try {
                    k7.close();
                } catch (IOException unused) {
                }
                return bitmapDecodeStream;
            } catch (Throwable th) {
                th = th;
                k6 = k7;
                if (k6 != null) {
                    try {
                        k6.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public int getImageOrientation() throws Throwable {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.c;
        K k6 = null;
        try {
            K k7 = new K(new FileInputStream(this.f3085a), aVar);
            try {
                int orientation = p126w0.p.getOrientation((List<p126w0.g>) this.b, k7, aVar);
                try {
                    k7.close();
                } catch (IOException unused) {
                }
                return orientation;
            } catch (Throwable th) {
                th = th;
                k6 = k7;
                if (k6 != null) {
                    try {
                        k6.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public ImageHeaderParser$ImageType getImageType() throws Throwable {
        com.bumptech.glide.load.engine.bitmap_recycle.a aVar = this.c;
        K k6 = null;
        try {
            K k7 = new K(new FileInputStream(this.f3085a), aVar);
            try {
                ImageHeaderParser$ImageType type = p126w0.p.getType((List<p126w0.g>) this.b, k7, aVar);
                try {
                    k7.close();
                } catch (IOException unused) {
                }
                return type;
            } catch (Throwable th) {
                th = th;
                k6 = k7;
                if (k6 != null) {
                    try {
                        k6.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bumptech.glide.load.resource.bitmap.F
    public final void a() {
    }
}
