package androidx.privacysandbox.ads.adservices.appsetid;

import O3.l;
import android.content.Context;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class AppSetIdManager$Companion$obtain$1 extends F implements l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSetIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // O3.l
    public final AppSetIdManagerApi31Ext9Impl invoke(Context it) {
        E.f(it, "it");
        return new AppSetIdManagerApi31Ext9Impl(this.$context);
    }
}
