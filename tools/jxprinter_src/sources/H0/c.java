package H0;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f284a = new ArrayList();

    public synchronized void add(@NonNull p126w0.g gVar) {
        this.f284a.add(gVar);
    }

    @NonNull
    public synchronized List<p126w0.g> getParsers() {
        return this.f284a;
    }
}
