package io.flutter.embedding.engine.renderer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4086a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i5) {
        this.f4086a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4086a) {
            case 0:
                ((FlutterRenderer.ImageReaderSurfaceProducer) this.b).lambda$dequeueImage$0();
                break;
            default:
                ((FlutterRenderer.SurfaceTextureRegistryEntry) this.b).lambda$new$0();
                break;
        }
    }
}
