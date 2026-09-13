package androidx.privacysandbox.ads.adservices.adid;

import E3.g;
import F3.h;
import F3.i;
import G3.d;
import G3.f;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.a;
import androidx.core.app.c;
import androidx.core.os.OutcomeReceiverKt;
import kotlin.jvm.internal.E;
import org.apache.xmlbeans.SchemaType;
import p007a4.C0289m;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresExtension.Container({@RequiresExtension(extension = SchemaType.SIZE_BIG_INTEGER, version = 4), @RequiresExtension(extension = 31, version = 9)})
@SuppressLint({"ClassVerificationFailure", "NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AdIdManagerImplCommon extends AdIdManager {
    private final android.adservices.adid.AdIdManager mAdIdManager;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon$getAdId$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @f(c = "androidx.privacysandbox.ads.adservices.adid.AdIdManagerImplCommon", f = "AdIdManagerImplCommon.kt", i = {}, l = {40}, m = "getAdId$suspendImpl", n = {}, s = {})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(g<? super AnonymousClass1> gVar) {
            super(gVar);
        }

        @Override // G3.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AdIdManagerImplCommon.getAdId$suspendImpl(AdIdManagerImplCommon.this, this);
        }
    }

    public AdIdManagerImplCommon(android.adservices.adid.AdIdManager mAdIdManager) {
        E.f(mAdIdManager, "mAdIdManager");
        this.mAdIdManager = mAdIdManager;
    }

    private final AdId convertResponse(android.adservices.adid.AdId adId) {
        String adId2 = adId.getAdId();
        E.e(adId2, "response.adId");
        return new AdId(adId2, adId.isLimitAdTrackingEnabled());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @DoNotInline
    public static /* synthetic */ Object getAdId$suspendImpl(AdIdManagerImplCommon adIdManagerImplCommon, g<? super AdId> gVar) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (gVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) gVar;
            int i5 = anonymousClass1.label;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i5 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = adIdManagerImplCommon.new AnonymousClass1(gVar);
            }
        } else {
            anonymousClass1 = adIdManagerImplCommon.new AnonymousClass1(gVar);
        }
        Object adIdAsyncInternal = anonymousClass1.result;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = anonymousClass1.label;
        if (i6 == 0) {
            v.throwOnFailure(adIdAsyncInternal);
            anonymousClass1.L$0 = adIdManagerImplCommon;
            anonymousClass1.label = 1;
            adIdAsyncInternal = adIdManagerImplCommon.getAdIdAsyncInternal(anonymousClass1);
            if (adIdAsyncInternal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            adIdManagerImplCommon = (AdIdManagerImplCommon) anonymousClass1.L$0;
            v.throwOnFailure(adIdAsyncInternal);
        }
        return adIdManagerImplCommon.convertResponse(c.c(adIdAsyncInternal));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    public final Object getAdIdAsyncInternal(g<? super android.adservices.adid.AdId> gVar) {
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        this.mAdIdManager.getAdId(new a(2), OutcomeReceiverKt.asOutcomeReceiver(c0289m));
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result;
    }

    @Override // androidx.privacysandbox.ads.adservices.adid.AdIdManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_AD_ID")
    @DoNotInline
    public Object getAdId(g<? super AdId> gVar) {
        return getAdId$suspendImpl(this, gVar);
    }
}
