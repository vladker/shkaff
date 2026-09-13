package com.google.mlkit.vision.text.pipeline;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcr;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbnx;
import com.google.android.libraries.vision.visionkit.pipeline.zbbd;
import com.google.android.libraries.vision.visionkit.pipeline.zbbe;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbj {
    public static zbbe zba(@NonNull ByteBuffer byteBuffer, @NonNull zbnx zbnxVar) {
        zbbd zbbdVar = new zbbd();
        zbbdVar.zba(byteBuffer.array());
        zbbdVar.zbf(zbb(zbnxVar.zbc()));
        zbbdVar.zbb(new zbcr(zbnxVar.zbd(), zbnxVar.zba()));
        zbbdVar.zbc(zbnxVar.zbe() * 1000);
        zbbdVar.zbe(2);
        return zbbdVar.zbd();
    }

    public static int zbb(int i5) {
        if (i5 == 1) {
            return 4;
        }
        if (i5 != 2) {
            return i5 != 3 ? 1 : 2;
        }
        return 3;
    }
}
