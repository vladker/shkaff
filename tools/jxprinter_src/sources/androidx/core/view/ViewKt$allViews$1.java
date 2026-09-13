package androidx.core.view;

import W3.AbstractC0234s;
import android.view.View;
import org.opencv.videoio.Videoio;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@G3.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {Videoio.CAP_PROP_XI_GPO_MODE, Videoio.CAP_PROP_XI_LED_MODE}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class ViewKt$allViews$1 extends G3.l implements O3.p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, E3.g<? super ViewKt$allViews$1> gVar) {
        super(2, gVar);
        this.$this_allViews = view;
    }

    @Override // G3.a
    public final E3.g<Q> create(Object obj, E3.g<?> gVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, gVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // O3.p
    public final Object invoke(AbstractC0234s abstractC0234s, E3.g<? super Q> gVar) {
        return ((ViewKt$allViews$1) create(abstractC0234s, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r1.yieldAll(r5, r4) == r0) goto L17;
     */
    @Override // G3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = F3.i.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            p147z3.v.throwOnFailure(r5)
            goto L4f
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            java.lang.Object r1 = r4.L$0
            W3.s r1 = (W3.AbstractC0234s) r1
            p147z3.v.throwOnFailure(r5)
            goto L37
        L22:
            p147z3.v.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            r1 = r5
            W3.s r1 = (W3.AbstractC0234s) r1
            android.view.View r5 = r4.$this_allViews
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r5 = r1.yield(r5, r4)
            if (r5 != r0) goto L37
            goto L4e
        L37:
            android.view.View r5 = r4.$this_allViews
            boolean r3 = r5 instanceof android.view.ViewGroup
            if (r3 == 0) goto L4f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            W3.q r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r3 = 0
            r4.L$0 = r3
            r4.label = r2
            java.lang.Object r5 = r1.yieldAll(r5, r4)
            if (r5 != r0) goto L4f
        L4e:
            return r0
        L4f:
            z3.Q r5 = p147z3.Q.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewKt$allViews$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
