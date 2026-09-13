package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.io.File;
import java.io.IOException;
import p126w0.v;
import p126w0.y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements y {
    @Override // p126w0.y
    @NonNull
    public p126w0.c getEncodeStrategy(@NonNull v vVar) {
        return p126w0.c.f8804a;
    }

    @Override // p126w0.y, p126w0.d
    public boolean encode(@NonNull O o6, @NonNull File file, @NonNull v vVar) throws Throwable {
        try {
            L0.c.toFile(((f) o6.get()).a(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
