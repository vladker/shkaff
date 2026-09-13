package org.apache.poi.hpsf;

import androidx.collection.a;
import org.apache.poi.util.HexDump;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IllegalVariantTypeException extends VariantTypeException {
    public IllegalVariantTypeException(long j6, Object obj, String str) {
        super(j6, obj, str);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IllegalVariantTypeException(long j6, Object obj) {
        StringBuilder sbT = a.t("The variant type ", j6, " (");
        sbT.append(Variant.getVariantName(j6));
        sbT.append(", ");
        sbT.append(HexDump.toHex(j6));
        sbT.append(") is illegal in this context.");
        this(j6, obj, sbT.toString());
    }
}
