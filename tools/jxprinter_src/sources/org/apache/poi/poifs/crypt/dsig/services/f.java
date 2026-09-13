package org.apache.poi.poifs.crypt.dsig.services;

import java.util.function.Function;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return TSPTimeStampService.lambda$timeStamp$0((X509CertificateHolder) obj);
    }
}
