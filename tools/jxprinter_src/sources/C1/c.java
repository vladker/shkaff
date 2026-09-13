package C1;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class c extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    public c(String str, String[] strArr, String[] strArr2) {
        StringBuilder sbY = AbstractC0157z.y("Could not find '", str, "'. Looked for: ");
        sbY.append(Arrays.toString(strArr));
        sbY.append(", but only found: ");
        super(AbstractC0157z.s(sbY, Arrays.toString(strArr2), Consts.DOT));
    }
}
