package io.flutter.embedding.engine.dart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4082a;
    public final /* synthetic */ DartMessenger.SerialTaskQueue b;

    public /* synthetic */ b(DartMessenger.SerialTaskQueue serialTaskQueue, int i5) {
        this.f4082a = i5;
        this.b = serialTaskQueue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4082a) {
            case 0:
                this.b.lambda$dispatch$0();
                break;
            default:
                this.b.lambda$flush$1();
                break;
        }
    }
}
