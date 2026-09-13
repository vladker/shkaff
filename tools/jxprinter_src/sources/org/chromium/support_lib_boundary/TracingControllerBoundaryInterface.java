package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int i5, Collection<String> collection, int i6);

    boolean stop(OutputStream outputStream, Executor executor);
}
