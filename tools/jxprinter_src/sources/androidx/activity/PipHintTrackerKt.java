package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import p023d4.AbstractC0618q;
import p023d4.InterfaceC0615p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity activity, View view, E3.g<? super Q> gVar) {
        Object objCollect = AbstractC0618q.callbackFlow(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new InterfaceC0615p() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            public final Object emit(Rect rect, E3.g<? super Q> gVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return Q.INSTANCE;
            }

            @Override // p023d4.InterfaceC0615p
            public /* bridge */ /* synthetic */ Object emit(Object obj, E3.g gVar2) {
                return emit((Rect) obj, (E3.g<? super Q>) gVar2);
            }
        }, gVar);
        return objCollect == F3.i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
