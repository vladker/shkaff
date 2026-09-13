package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application) {
        E.f(application, "application");
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        T t6 = (T) this.application;
        E.d(t6, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t6;
    }
}
