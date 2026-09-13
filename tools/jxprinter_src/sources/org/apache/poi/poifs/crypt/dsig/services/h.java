package org.apache.poi.poifs.crypt.dsig.services;

import java.util.function.Function;
import org.bouncycastle.asn1.x509.DistributionPoint;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((DistributionPoint) obj).getDistributionPoint();
    }
}
