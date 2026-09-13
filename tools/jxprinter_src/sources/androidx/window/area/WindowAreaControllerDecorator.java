package androidx.window.area;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WindowAreaControllerDecorator {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    WindowAreaController decorate(WindowAreaController windowAreaController);
}
