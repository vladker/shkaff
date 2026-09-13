package p002a;

import io.reactivex.B;
import io.reactivex.I;
import io.reactivex.plugins.a;
import java.util.concurrent.LinkedBlockingQueue;
import p017c3.g;
import p039g3.A;
import p039g3.z;
import p048i3.h;
import p048i3.r;
import p100r3.n;
import retrofit2.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u0 f905a;

    public static void a(float f6, float f7, float f8) {
        if (f6 >= f7) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f7 >= f8) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static void b(Class cls) {
        String name = cls.getName();
        a.onError(new g(androidx.collection.a.p("It is not allowed to subscribe with a(n) ", name, " multiple times. Please create a fresh instance of ", name, " and subscribe that to the target source instead.")));
    }

    public static void c(B b, p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar) {
        A.b(gVar, "onNext is null");
        A.b(gVar2, "onError is null");
        A.b(aVar, "onComplete is null");
        d(b, new r(gVar, gVar2, aVar, z.d));
    }

    public static void d(B b, I i5) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        h hVar = new h(linkedBlockingQueue);
        i5.onSubscribe(hVar);
        b.subscribe(hVar);
        while (!hVar.e()) {
            Object objPoll = linkedBlockingQueue.poll();
            if (objPoll == null) {
                try {
                    objPoll = linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    hVar.dispose();
                    i5.onError(e);
                    return;
                }
            }
            if (hVar.e() || b == h.b || n.a(i5, objPoll)) {
                return;
            }
        }
    }
}
