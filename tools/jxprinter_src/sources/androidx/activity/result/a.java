package androidx.activity.result;

import O3.l;
import com.appdev.standard.dialog.InterfaceC0461n;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.Map;
import kotlin.jvm.internal.E;
import p108t.C1772d;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback, InterfaceC0461n, OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f972a;
    public final /* synthetic */ l b;

    public /* synthetic */ a(int i5, l lVar) {
        this.f972a = i5;
        this.b = lVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f972a) {
            case 0:
                this.b.invoke(obj);
                break;
            default:
                this.b.invoke(obj);
                break;
        }
    }

    @Override // com.appdev.standard.dialog.InterfaceC0461n
    public void onClick(String str, Map map) {
        switch (this.f972a) {
            case 2:
                if (str != null) {
                    this.b.invoke(u.a(u.m1361constructorimpl(new C1772d(str, map))));
                }
                break;
            case 3:
                if (str != null) {
                    this.b.invoke(u.a(u.m1361constructorimpl(new C1772d(str, map))));
                }
                break;
            default:
                if (str != null) {
                    this.b.invoke(u.a(u.m1361constructorimpl(new C1772d(str, map))));
                }
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        E.c(exc);
        this.b.invoke(u.a(u.m1361constructorimpl(v.createFailure(exc))));
    }
}
