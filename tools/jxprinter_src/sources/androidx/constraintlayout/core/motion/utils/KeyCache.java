package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> mMap = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i5) {
        HashMap<String, float[]> map;
        float[] fArr;
        if (this.mMap.containsKey(obj) && (map = this.mMap.get(obj)) != null && map.containsKey(str) && (fArr = map.get(str)) != null && fArr.length > i5) {
            return fArr[i5];
        }
        return Float.NaN;
    }

    public void setFloatValue(Object obj, String str, int i5, float f6) {
        if (!this.mMap.containsKey(obj)) {
            HashMap<String, float[]> map = new HashMap<>();
            float[] fArr = new float[i5 + 1];
            fArr[i5] = f6;
            map.put(str, fArr);
            this.mMap.put(obj, map);
            return;
        }
        HashMap<String, float[]> map2 = this.mMap.get(obj);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        if (!map2.containsKey(str)) {
            float[] fArr2 = new float[i5 + 1];
            fArr2[i5] = f6;
            map2.put(str, fArr2);
            this.mMap.put(obj, map2);
            return;
        }
        float[] fArrCopyOf = map2.get(str);
        if (fArrCopyOf == null) {
            fArrCopyOf = new float[0];
        }
        if (fArrCopyOf.length <= i5) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i5 + 1);
        }
        fArrCopyOf[i5] = f6;
        map2.put(str, fArrCopyOf);
    }
}
