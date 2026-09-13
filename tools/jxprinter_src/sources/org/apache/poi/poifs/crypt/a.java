package org.apache.poi.poifs.crypt;

import java.io.IOException;
import java.net.HttpURLConnection;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampSimpleHttpClient;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements POIFSWriterListener, TimeStampSimpleHttpClient.MethodHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f7140a;

    public /* synthetic */ a(byte[] bArr) {
        this.f7140a = bArr;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampSimpleHttpClient.MethodHandler
    public void handle(HttpURLConnection httpURLConnection) throws IOException {
        TimeStampSimpleHttpClient.lambda$post$0(this.f7140a, httpURLConnection);
    }

    @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
    public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
        DataSpaceMapUtils.lambda$createEncryptionEntry$0(this.f7140a, pOIFSWriterEvent);
    }
}
