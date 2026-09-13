package org.apache.commons.compress.archivers.zip;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6701a;
    public final /* synthetic */ ParallelScatterZipCreator b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(ParallelScatterZipCreator parallelScatterZipCreator, Object obj, int i5) {
        this.f6701a = i5;
        this.b = parallelScatterZipCreator;
        this.c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f6701a) {
            case 0:
                return this.b.lambda$createCallable$2((ZipArchiveEntryRequestSupplier) this.c);
            case 1:
                return this.b.lambda$submit$0((Callable) this.c);
            default:
                return this.b.lambda$createCallable$1((ZipArchiveEntryRequest) this.c);
        }
    }
}
