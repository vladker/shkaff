package p102s;

import E3.g;
import F3.i;
import O3.p;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.appdev.standard.page.LoadFileActivity;
import com.idlefish.flutterboost.FlutterBoost;
import kotlin.jvm.internal.E;
import p007a4.M;
import p042h2.d;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends G3.m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8177a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String str, String str2, g gVar) {
        super(2, gVar);
        this.f8177a = str;
        this.b = str2;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        return new m(this.f8177a, this.b, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((m) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        PackageManager packageManager = FlutterBoost.instance().currentActivity().getPackageManager();
        Intent launchIntentForPackage = packageManager != null ? packageManager.getLaunchIntentForPackage("com.tencent.mobileqq") : null;
        if (launchIntentForPackage == null) {
            d.show(p113u.g.text_463);
            return Q.INSTANCE;
        }
        FlutterBoost.instance().currentActivity().startActivity(launchIntentForPackage);
        String str = this.f8177a;
        if (E.a(str, "openFile")) {
            LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_SP_FILE);
        } else if (E.a(str, "openExcel")) {
            LoadFileActivity.setLoadType(LoadFileActivity.LoadType.LOAD_TYPE_SP_EXCEL);
        }
        G.Companion.setAddFileToCloudId(this.b);
        return Q.INSTANCE;
    }
}
