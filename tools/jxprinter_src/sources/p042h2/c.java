package p042h2;

import androidx.annotation.NonNull;
import com.orhanobut.hawk.Hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static void requestPermissionResult(@NonNull String[] strArr, @NonNull int[] iArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (iArr[i5] != 0) {
                Hawk.put("permission." + strArr[i5], Boolean.FALSE);
            } else {
                Hawk.put("permission." + strArr[i5], Boolean.TRUE);
            }
        }
    }
}
