package p012b4;

import android.os.Looper;
import java.util.List;
import p007a4.AbstractC0265b1;
import p028e4.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements v {
    @Override // p028e4.v
    public AbstractC0265b1 createDispatcher(List<? extends v> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(f.asHandler(mainLooper, true), null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // p028e4.v
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}
