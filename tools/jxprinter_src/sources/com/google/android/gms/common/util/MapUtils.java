package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.collection.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(@NonNull StringBuilder sb, @NonNull HashMap<String, String> map) {
        sb.append(VectorFormat.DEFAULT_PREFIX);
        boolean z6 = true;
        for (String str : map.keySet()) {
            if (!z6) {
                sb.append(",");
            }
            String str2 = map.get(str);
            a.x(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append(AbstractC1127c.NULL);
            } else {
                a.x(sb, "\"", str2, "\"");
            }
            z6 = false;
        }
        sb.append(VectorFormat.DEFAULT_SUFFIX);
    }
}
