package org.apache.poi.poifs.crypt.dsig.services;

import java.util.function.Predicate;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return TSPTimeStampService.lambda$retrieveCRL$5((GeneralName) obj);
    }
}
