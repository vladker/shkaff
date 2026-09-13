package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4083a;
    public final /* synthetic */ FlutterLoader b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ String[] d;
    public final /* synthetic */ Handler e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f4084f;

    public /* synthetic */ a(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable, int i5) {
        this.f4083a = i5;
        this.b = flutterLoader;
        this.c = context;
        this.d = strArr;
        this.e = handler;
        this.f4084f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4083a) {
            case 0:
                this.b.lambda$ensureInitializationCompleteAsync$1(this.c, this.d, this.e, this.f4084f);
                break;
            default:
                this.b.lambda$ensureInitializationCompleteAsync$0(this.c, this.d, this.e, this.f4084f);
                break;
        }
    }
}
