package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import p101r4.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SnackbarBehavior extends CoordinatorLayout.Behavior<c> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull c cVar, @NonNull View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull c cVar, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(cVar);
        int size = dependencies.size();
        float fMin = 0.0f;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = dependencies.get(i5);
            if ((view2 instanceof Snackbar.SnackbarLayout) && coordinatorLayout.doViewsOverlap(cVar, view2)) {
                fMin = Math.min(fMin, view2.getTranslationY() - view2.getHeight());
            }
        }
        cVar.setTranslationY(fMin);
        return true;
    }
}
