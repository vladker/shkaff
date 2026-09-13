package org.apache.poi.util;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class CodepointsUtil {
    public static Iterator<String> iteratorFor(String str) {
        return str.codePoints().mapToObj(new o5.i(7)).iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$iteratorFor$0(int i5) {
        return new StringBuilder().appendCodePoint(i5).toString();
    }
}
