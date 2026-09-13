package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3468a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(Object obj, Object obj2, int i5) {
        this.f3468a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3468a) {
            case 0:
                ((OptionalProvider) this.c).set((Provider) this.b);
                break;
            case 1:
                ((LazySet) this.c).add((Provider) this.b);
                break;
            default:
                EventBus.lambda$publish$0((Map.Entry) this.c, (Event) this.b);
                break;
        }
    }
}
