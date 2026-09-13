package io.reactivex.internal.operators.observable;

import android.content.Context;
import android.util.Log;
import com.orhanobut.hawk.Hawk;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0953x2 implements InterfaceC0901m2, p134x2.Q0, p134x2.N, p015c1.a, p089p4.w, L2.b, L2.a, p138y0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5307a;

    public /* synthetic */ C0953x2(int i5) {
        this.f5307a = i5;
    }

    public static void b(String str) {
        p051j0.a.d("ModelFileDownloadUtil", "Model file download failed: " + str);
        p056k0.n.e(str);
    }

    @Override // p138y0.d
    public void a(Throwable th) {
        if (Log.isLoggable("GlideExecutor", 6)) {
            Log.e("GlideExecutor", "Request threw uncaught throwable", th);
        }
    }

    @Override // p015c1.a
    public String c(Object obj) {
        return "Thread: " + ((Thread) obj).getName();
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0901m2
    public InterfaceC0925r2 call() {
        return new C0957y2(16);
    }

    @Override // L2.a
    public I2.c createRefreshFooter(Context context, I2.f fVar) {
        D2.a.f208y = context.getString(p113u.g.footer_pulling);
        D2.a.f209z = context.getString(p113u.g.footer_release);
        D2.a.f204C = context.getString(p113u.g.footer_refreshing);
        D2.a.f203A = context.getString(p113u.g.footer_loading);
        D2.a.f205D = context.getString(p113u.g.footer_finish);
        D2.a.f206G = context.getString(p113u.g.footer_failed);
        D2.a.f207H = context.getString(p113u.g.footer_nothing);
        D2.a aVar = new D2.a(context);
        aVar.d.setTextSize(12.0f);
        I2.e eVar = aVar.f128g;
        if (eVar != null) {
            ((H2.k) eVar).requestRemeasureHeightFor(aVar);
        }
        aVar.setPrimaryColor(0);
        return aVar;
    }

    @Override // L2.b
    public I2.d createRefreshHeader(Context context, I2.f fVar) {
        F2.a.f243H = context.getString(p113u.g.header_pulldown);
        F2.a.f244I = context.getString(p113u.g.header_refreshing);
        F2.a.f245J = context.getString(p113u.g.header_loading);
        F2.a.f246K = context.getString(p113u.g.header_release);
        F2.a.f247M = context.getString(p113u.g.header_finish);
        F2.a.f248Q = context.getString(p113u.g.header_failed);
        F2.a.f250n0 = context.getString(p113u.g.header_secondary);
        F2.a.f249k0 = context.getString(p113u.g.header_lasttime);
        F2.a aVar = new F2.a(context);
        aVar.d.setTextSize(12.0f);
        I2.e eVar = aVar.f128g;
        if (eVar != null) {
            ((H2.k) eVar).requestRemeasureHeightFor(aVar);
        }
        aVar.f257s.setTextSize(12.0f);
        I2.e eVar2 = aVar.f128g;
        if (eVar2 != null) {
            ((H2.k) eVar2).requestRemeasureHeightFor(aVar);
        }
        aVar.setPrimaryColor(0);
        return aVar;
    }

    @Override // p134x2.N
    public void d(String str, String str2) {
        p051j0.a.c(str, str2);
    }

    @Override // p134x2.Q0
    public boolean delete(String key) {
        kotlin.jvm.internal.E.f(key, "key");
        return Hawk.delete(key);
    }

    @Override // p134x2.N
    public void e(String str, String str2) {
        p051j0.a.d(str, str2);
    }

    @Override // p134x2.Q0
    public Object get(String key) {
        kotlin.jvm.internal.E.f(key, "key");
        return Hawk.get(key);
    }

    @Override // p134x2.N
    public void i(String str, String str2) {
        p051j0.a.k(str, str2);
    }

    @Override // p134x2.Q0
    public boolean put(String key, Object obj) {
        kotlin.jvm.internal.E.f(key, "key");
        return Hawk.put(key, obj);
    }

    @Override // p089p4.w
    public String serialNameForJson(p072m4.r descriptor, int i5, String serialName) {
        switch (this.f5307a) {
            case 7:
                kotlin.jvm.internal.E.f(descriptor, "descriptor");
                kotlin.jvm.internal.E.f(serialName, "serialName");
                return p089p4.v.a(serialName, '-');
            default:
                kotlin.jvm.internal.E.f(descriptor, "descriptor");
                kotlin.jvm.internal.E.f(serialName, "serialName");
                return p089p4.v.a(serialName, NameUtil.USCORE);
        }
    }

    public String toString() {
        switch (this.f5307a) {
            case 7:
                return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
            case 8:
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            default:
                return super.toString();
        }
    }

    @Override // p134x2.N
    public void v(String str, String str2) {
        if (p051j0.a.f5394a < 0) {
            p004a1.d.c(str).a().g(2, str2);
        }
    }

    @Override // p134x2.N
    public void w(String str, String str2) {
        p051j0.a.o(str, str2);
    }

    @Override // p134x2.N
    public void d(String str, String str2, Object... args) {
        kotlin.jvm.internal.E.f(args, "args");
        Object[] objArr = {args};
        if (1 > p051j0.a.f5394a) {
            p004a1.d.c(str).a().h(str2, 3, objArr);
        }
    }

    @Override // p134x2.N
    public void e(String str, String str2, Throwable th) {
        p051j0.a.e(str, str2, th);
    }

    @Override // p134x2.Q0
    public Object get(String key, Object obj) {
        kotlin.jvm.internal.E.f(key, "key");
        return Hawk.get(key, obj);
    }

    @Override // p134x2.N
    public void i(String str, String str2, Object... args) {
        kotlin.jvm.internal.E.f(args, "args");
        Object[] objArr = {args};
        if (2 > p051j0.a.f5394a) {
            p004a1.d.c(str).a().h(str2, 4, objArr);
        }
    }

    @Override // p134x2.N
    public void w(String str, String str2, Object... args) {
        kotlin.jvm.internal.E.f(args, "args");
        Object[] objArr = {args};
        if (3 > p051j0.a.f5394a) {
            p004a1.d.c(str).a().h(str2, 5, objArr);
        }
    }

    @Override // p134x2.N
    public void e(String str, String str2, Object... args) {
        kotlin.jvm.internal.E.f(args, "args");
        Object[] objArr = {args};
        if (4 > p051j0.a.f5394a) {
            p004a1.d.c(str).a().h(str2, 6, objArr);
        }
    }

    @Override // p134x2.N
    public void v(String str, String str2, Object... args) {
        kotlin.jvm.internal.E.f(args, "args");
        Object[] objArr = {args};
        if (p051j0.a.f5394a < 0) {
            p004a1.d.c(str).a().h(str2, 2, objArr);
        }
    }
}
