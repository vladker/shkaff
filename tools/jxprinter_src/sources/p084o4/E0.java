package p084o4;

import java.util.ArrayList;
import kotlin.jvm.internal.E;
import p060k4.c;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E0 {
    public static final void throwArrayMissingFieldException(int[] seenArray, int[] goldenMaskArray, r descriptor) {
        E.f(seenArray, "seenArray");
        E.f(goldenMaskArray, "goldenMaskArray");
        E.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = goldenMaskArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = goldenMaskArray[i5] & (~seenArray[i5]);
            if (i6 != 0) {
                for (int i7 = 0; i7 < 32; i7++) {
                    if ((i6 & 1) != 0) {
                        arrayList.add(descriptor.getElementName((i5 * 32) + i7));
                    }
                    i6 >>>= 1;
                }
            }
        }
        throw new c(arrayList, descriptor.getSerialName());
    }

    public static final void throwMissingFieldException(int i5, int i6, r descriptor) {
        E.f(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i7 = (~i5) & i6;
        for (int i8 = 0; i8 < 32; i8++) {
            if ((i7 & 1) != 0) {
                arrayList.add(descriptor.getElementName(i8));
            }
            i7 >>>= 1;
        }
        throw new c(arrayList, descriptor.getSerialName());
    }
}
