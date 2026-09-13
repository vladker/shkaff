package xyz.doikki.videoplayer.controller;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8961a;
    public final /* synthetic */ b b;

    public /* synthetic */ a(b bVar, int i5) {
        this.f8961a = i5;
        this.b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8961a) {
            case 0:
                this.b.hide();
                break;
            case 1:
                b bVar = this.b;
                int currentPosition = (int) bVar.f8962a.f8974a.getCurrentPosition();
                int duration = (int) bVar.f8962a.f8974a.getDuration();
                Iterator it = bVar.f8968k.entrySet().iterator();
                while (it.hasNext()) {
                    ((e) ((Map.Entry) it.next()).getKey()).c(duration, currentPosition);
                }
                if (!bVar.f8962a.f8974a.h()) {
                    bVar.f8967j = false;
                } else {
                    bVar.postDelayed(this, (long) ((1000 - (currentPosition % 1000)) / bVar.f8962a.f8974a.getSpeed()));
                }
                break;
            default:
                this.b.f8963f.enable();
                break;
        }
    }
}
