package p096r;

import W1.a;
import Y4.q;
import com.android.billingclient.api.h1;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzr;
import java.lang.reflect.Type;
import org.apache.poi.ss.util.IEEEDouble;
import org.jsoup.nodes.m;
import org.jsoup.nodes.s;
import org.jsoup.nodes.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements q, zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7911a;
    public final Object b;

    public /* synthetic */ f(h1 h1Var, int i5) {
        this.b = h1Var;
        this.f7911a = i5;
    }

    public Object a(Type type) {
        for (a aVar = ((a[]) this.b)[System.identityHashCode(type) & this.f7911a]; aVar != null; aVar = (a) aVar.b) {
            if (type == aVar.c) {
                return aVar.f784a;
            }
        }
        return null;
    }

    @Override // Y4.q
    public void b(s sVar, int i5) {
        if (sVar instanceof m) {
            sVar.r();
            throw null;
        }
    }

    public boolean c(Type type, Object obj) {
        int iIdentityHashCode = System.identityHashCode(type) & this.f7911a;
        a[] aVarArr = (a[]) this.b;
        for (a aVar = aVarArr[iIdentityHashCode]; aVar != null; aVar = (a) aVar.b) {
            if (type == aVar.c) {
                aVar.f784a = obj;
                return true;
            }
        }
        aVarArr[iIdentityHashCode] = new a(type, false, obj, aVarArr[iIdentityHashCode]);
        return false;
    }

    @Override // Y4.q
    public void e(s sVar, int i5) {
        if (sVar instanceof m) {
            String str = ((m) sVar).c.b;
            throw null;
        }
        if (sVar instanceof u) {
            ((m) this.b).z(new u(((u) sVar).z()));
        } else {
            if (sVar instanceof org.jsoup.nodes.f) {
                sVar.parent().r();
                throw null;
            }
            this.f7911a++;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzr
    public Object zza(zzp zzpVar) {
        h1.n0((h1) this.b, this.f7911a, zzpVar);
        return "billingOverrideService.getBillingOverride";
    }

    public f() {
        this.f7911a = IEEEDouble.EXPONENT_BIAS;
        this.b = new a[1024];
    }

    public f(X4.a aVar, m mVar, m mVar2) {
        this.f7911a = 0;
        this.b = mVar2;
    }
}
