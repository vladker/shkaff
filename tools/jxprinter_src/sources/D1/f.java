package D1;

import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue f167a;
    public final PriorityQueue b;
    public final ArrayList c;
    public final Object d = new Object();

    public f() {
        e eVar = new e(this);
        this.b = new PriorityQueue(120, eVar);
        this.f167a = new PriorityQueue(120, eVar);
        this.c = new ArrayList();
    }

    @Nullable
    private static H1.a find(PriorityQueue<H1.a> priorityQueue, H1.a aVar) {
        for (H1.a aVar2 : priorityQueue) {
            if (aVar2.equals(aVar)) {
                return aVar2;
            }
        }
        return null;
    }

    public final void a() {
        synchronized (this.d) {
            while (this.b.size() + this.f167a.size() >= 120 && !this.f167a.isEmpty()) {
                try {
                    ((H1.a) this.f167a.poll()).b.recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
            while (this.b.size() + this.f167a.size() >= 120 && !this.b.isEmpty()) {
                ((H1.a) this.b.poll()).b.recycle();
            }
        }
    }

    public final boolean b(RectF rectF, int i5, int i6) {
        H1.a aVar = new H1.a(i5, null, rectF, false, 0);
        synchronized (this.d) {
            try {
                H1.a aVarFind = find(this.f167a, aVar);
                boolean z6 = true;
                if (aVarFind == null) {
                    if (find(this.b, aVar) == null) {
                        z6 = false;
                    }
                    return z6;
                }
                this.f167a.remove(aVarFind);
                aVarFind.e = i6;
                this.b.offer(aVarFind);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
