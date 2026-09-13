package retrofit2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okhttp3.C1377x;
import okhttp3.C1378y;
import okhttp3.InterfaceC1352e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8161a = new ArrayList();
    public final ArrayList b = new ArrayList();
    private C1378y baseUrl;
    private InterfaceC1352e callFactory;
    private Executor callbackExecutor;

    public final void a(String str) {
        Objects.requireNonNull(str, "baseUrl == null");
        C1378y c1378yA = new C1377x().parse(null, str).a();
        List list = c1378yA.f6681f;
        if ("".equals(list.get(list.size() - 1))) {
            this.baseUrl = c1378yA;
        } else {
            throw new IllegalArgumentException("baseUrl must end in /: " + c1378yA);
        }
    }

    public final u0 b() {
        if (this.baseUrl == null) {
            throw new IllegalStateException("Base URL required.");
        }
        InterfaceC1352e h6 = this.callFactory;
        if (h6 == null) {
            h6 = new okhttp3.H();
        }
        InterfaceC1352e interfaceC1352e = h6;
        Executor executor = this.callbackExecutor;
        if (executor == null) {
            executor = j0.callbackExecutor;
        }
        Executor executor2 = executor;
        C1612j c1612j = j0.b;
        ArrayList arrayList = new ArrayList(this.b);
        List<? extends AbstractC1614l> listCreateDefaultCallAdapterFactories = c1612j.createDefaultCallAdapterFactories(executor2);
        arrayList.addAll(listCreateDefaultCallAdapterFactories);
        List listA = c1612j.a();
        int size = listA.size();
        ArrayList arrayList2 = this.f8161a;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + 1 + size);
        arrayList3.add(new C1610h());
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(listA);
        return new u0(interfaceC1352e, this.baseUrl, Collections.unmodifiableList(arrayList3), size, Collections.unmodifiableList(arrayList), listCreateDefaultCallAdapterFactories.size(), executor2, false);
    }

    public final void c(ExecutorService executorService) {
        Objects.requireNonNull(executorService, "executor == null");
        this.callbackExecutor = executorService;
    }

    public final void d(okhttp3.H h6) {
        this.callFactory = h6;
    }
}
