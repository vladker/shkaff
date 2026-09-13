package M2;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzkw;
import java.util.ArrayList;
import p050j.p;
import p050j.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f470a;
    public Object b;

    public a(String str, boolean z6) {
        this.b = str;
        this.f470a = z6;
    }

    public void a(zzkw zzkwVar) {
        if (this.f470a) {
            zzc.zzn("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            ((Transport) this.b).send(Event.ofData(zzkwVar));
        } catch (Throwable unused) {
            zzc.zzn("BillingLogger", "logging failed.");
        }
    }

    @Override // p050j.p
    public Object c(r rVar, Object obj, Object obj2) {
        String str = (String) this.b;
        if (!this.f470a) {
            return rVar.d(obj2, str);
        }
        ArrayList arrayList = new ArrayList();
        rVar.a(obj2, str, arrayList);
        return arrayList;
    }
}
