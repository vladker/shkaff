package androidx.privacysandbox.ads.adservices.adselection;

import E3.g;
import G3.d;
import G3.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.privacysandbox.ads.adservices.adselection.AdSelectionManagerImplCommon$Ext10Impl$Companion", f = "AdSelectionManagerImplCommon.kt", i = {0, 0}, l = {231}, m = "selectAds", n = {"adSelectionManager", "adSelectionFromOutcomesConfig"}, s = {"L$0", "L$1"})
public final class AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdSelectionManagerImplCommon.Ext10Impl.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1(AdSelectionManagerImplCommon.Ext10Impl.Companion companion, g<? super AdSelectionManagerImplCommon$Ext10Impl$Companion$selectAds$1> gVar) {
        super(gVar);
        this.this$0 = companion;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.selectAds(null, null, this);
    }
}
