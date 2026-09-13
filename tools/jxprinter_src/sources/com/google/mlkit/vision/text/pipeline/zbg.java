package com.google.mlkit.vision.text.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaaw;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class zbg {
    public static String zba(List list) {
        Iterator it = list.iterator();
        float fZbc = 0.0f;
        String strZbf = "und";
        while (it.hasNext()) {
            zbaaw zbaawVar = (zbaaw) it.next();
            if (fZbc < zbaawVar.zbc()) {
                fZbc = zbaawVar.zbc();
                strZbf = zbaawVar.zbf();
            }
        }
        return strZbf;
    }
}
