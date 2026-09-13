package S2;

import A3.J;
import A3.j0;
import X3.EnumC0238d;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import java.util.LinkedHashMap;
import p089p4.C;
import p089p4.F;
import p108t.e0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f636a;

    public /* synthetic */ d(int i5) {
        this.f636a = i5;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f636a) {
            case 0:
                return new i();
            case 1:
                H3.a entries = EnumC0238d.getEntries();
                int iMapCapacity = j0.mapCapacity(J.collectionSizeOrDefault(entries, 10));
                if (iMapCapacity < 16) {
                    iMapCapacity = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                for (Object obj : entries) {
                    linkedHashMap.put(Integer.valueOf(((EnumC0238d) obj).f856a), obj);
                }
                return linkedHashMap;
            case 2:
                return CrashlyticsWorkers.Companion.checkBackgroundThread$lambda$2();
            case 3:
                return CrashlyticsWorkers.Companion.checkNotMainThread$lambda$0();
            case 4:
                return CrashlyticsWorkers.Companion.checkBlockingThread$lambda$1();
            case 5:
                return FirebaseAnalyticsHostApi.Companion.codec_delegate$lambda$0();
            case 6:
                throw new p060k4.l("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
            case 7:
                return F.INSTANCE.getDescriptor();
            case 8:
                return p089p4.y.INSTANCE.getDescriptor();
            case 9:
                return p089p4.t.INSTANCE.getDescriptor();
            case 10:
                return C.INSTANCE.getDescriptor();
            case 11:
                return p089p4.h.INSTANCE.getDescriptor();
            case 12:
                return e0.INSTANCE;
            case 13:
                return e0.INSTANCE;
            case 14:
                return e0.INSTANCE;
            case 15:
                return e0.INSTANCE;
            case 16:
                return e0.INSTANCE;
            case 17:
                return e0.INSTANCE;
            case 18:
                return e0.INSTANCE;
            case 19:
                return e0.INSTANCE;
            case 20:
                return e0.INSTANCE;
            case 21:
                return e0.INSTANCE;
            case 22:
                return e0.INSTANCE;
            case 23:
                return e0.INSTANCE;
            case 24:
                return e0.INSTANCE;
            case 25:
                return e0.INSTANCE;
            default:
                return e0.INSTANCE;
        }
    }
}
