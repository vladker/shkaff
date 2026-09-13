package org.apache.poi.hpsf;

import androidx.collection.a;
import org.apache.poi.util.HexDump;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UnsupportedVariantTypeException extends VariantTypeException {
    /* JADX WARN: Illegal instructions before constructor call */
    public UnsupportedVariantTypeException(long j6, Object obj) {
        StringBuilder sbT = a.t("HPSF does not yet support the variant type ", j6, " (");
        sbT.append(Variant.getVariantName(j6));
        sbT.append(", ");
        sbT.append(HexDump.toHex(j6));
        sbT.append("). If you want support for this variant type in one of the next POI releases please submit a request for enhancement (RFE) to <http://issues.apache.org/bugzilla/>! Thank you!");
        super(j6, obj, sbT.toString());
    }
}
