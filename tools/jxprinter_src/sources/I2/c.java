package I2;

import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface c extends a {
    @Override // I2.a
    @NonNull
    /* synthetic */ J2.c getSpinnerStyle();

    @Override // I2.a
    @NonNull
    /* synthetic */ View getView();

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ int onFinish(@NonNull f fVar, boolean z6);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onHorizontalDrag(float f6, int i5, int i6);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onInitialized(@NonNull e eVar, int i5, int i6);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onMoving(boolean z6, float f6, int i5, int i6, int i7);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onReleased(@NonNull f fVar, int i5, int i6);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onStartAnimator(@NonNull f fVar, int i5, int i6);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void onStateChanged(@NonNull f fVar, @NonNull J2.b bVar, @NonNull J2.b bVar2);

    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    boolean setNoMoreData(boolean z6);

    @Override // I2.a
    @RestrictTo({RestrictTo.Scope.LIBRARY, RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.SUBCLASSES})
    /* synthetic */ void setPrimaryColors(@ColorInt int... iArr);
}
