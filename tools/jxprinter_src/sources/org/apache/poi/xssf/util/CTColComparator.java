package org.apache.poi.xssf.util;

import I4.a;
import java.util.Comparator;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CTColComparator {
    public static final Comparator<CTCol> BY_MAX = new a(0);
    public static final Comparator<CTCol> BY_MIN_MAX = new a(1);

    private CTColComparator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(CTCol cTCol, CTCol cTCol2) {
        return Long.compare(cTCol.getMax(), cTCol2.getMax());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$1(CTCol cTCol, CTCol cTCol2) {
        long min = cTCol.getMin();
        long min2 = cTCol2.getMin();
        if (min < min2) {
            return -1;
        }
        if (min > min2) {
            return 1;
        }
        return BY_MAX.compare(cTCol, cTCol2);
    }
}
