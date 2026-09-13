package androidx.privacysandbox.ads.adservices.adid;

import O3.l;
import android.content.Context;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class AdIdManager$Companion$obtain$1 extends F implements l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // O3.l
    public final AdIdManagerApi31Ext9Impl invoke(Context it) {
        E.f(it, "it");
        return new AdIdManagerApi31Ext9Impl(this.$context);
    }
}
