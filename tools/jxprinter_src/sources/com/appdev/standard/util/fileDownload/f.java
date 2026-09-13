package com.appdev.standard.util.fileDownload;

import A5.w;
import A5.y;
import com.google.common.net.HttpHeaders;
import io.reactivex.B;
import okhttp3.W;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
interface f {
    @A5.f
    @w
    B<W> download(@y String str);

    @A5.f
    @w
    B<W> downloadPartial(@y String str, @A5.i(HttpHeaders.RANGE) String str2);
}
