package p118u4;

import A4.f0;
import A4.h0;
import okhttp3.C1376w;
import okhttp3.M;
import okhttp3.S;
import okhttp3.T;
import t4.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface c {
    void cancel();

    h connection();

    f0 createRequestBody(M m6, long j6);

    void finishRequest();

    void flushRequest();

    h0 openResponseBodySource(T t6);

    S readResponseHeaders(boolean z6);

    long reportedContentLength(T t6);

    C1376w trailers();

    void writeRequestHeaders(M m6);
}
