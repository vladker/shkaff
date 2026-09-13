package Q0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f570a;
    public final Executor b;
    public final CopyOnWriteArrayList c;
    public int d;
    public final O0.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f571f;

    public e(O0.e adapter, f config) {
        E.g(adapter, "adapter");
        E.g(config, "config");
        this.e = adapter;
        this.f571f = config;
        this.f570a = new g(adapter);
        Executor aVar = new a();
        Executor mainThreadExecutor = config.getMainThreadExecutor();
        this.b = mainThreadExecutor != null ? mainThreadExecutor : aVar;
        this.c = new CopyOnWriteArrayList();
    }

    public final void a(Runnable runnable) {
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            this.e.getData();
            throw null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void addList(List<Object> list) {
        if (list == null) {
            return;
        }
        O0.e eVar = this.e;
        List<Object> data = eVar.getData();
        eVar.getData().addAll(list);
        this.f570a.onInserted(data.size(), list.size());
        a(null);
    }

    @Override // Q0.h
    public void addListListener(i listener) {
        E.g(listener, "listener");
        this.c.add(listener);
    }

    public final void changeData(int i5, Object obj, Object obj2) {
        O0.e eVar = this.e;
        eVar.getData();
        eVar.getData().set(i5, obj);
        this.f570a.onChanged(i5, 1, obj2);
        a(null);
    }

    public final void removeListListener(i listener) {
        E.g(listener, "listener");
        this.c.remove(listener);
    }

    public final void submitList(List<Object> list) {
        submitList(list, null);
    }

    public final void submitList(List<Object> list, Runnable runnable) {
        int i5 = this.d + 1;
        this.d = i5;
        O0.e eVar = this.e;
        if (list == eVar.getData()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<Object> data = eVar.getData();
        g gVar = this.f570a;
        if (list == null) {
            int size = eVar.getData().size();
            eVar.setData$com_github_CymChad_brvah(new ArrayList());
            gVar.onRemoved(0, size);
            a(runnable);
            return;
        }
        if (!eVar.getData().isEmpty()) {
            this.f571f.getBackgroundThreadExecutor().execute(new d(this, data, list, i5, runnable));
            return;
        }
        eVar.setData$com_github_CymChad_brvah(list);
        gVar.onInserted(0, list.size());
        a(runnable);
    }
}
