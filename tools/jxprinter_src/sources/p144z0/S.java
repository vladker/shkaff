package p144z0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.util.Collections;
import java.util.List;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f9063a;
    public final List b;
    public final e c;

    public S(@NonNull q qVar, @NonNull e eVar) {
        this(qVar, Collections.EMPTY_LIST, eVar);
    }

    public S(@NonNull q qVar, @NonNull List<q> list, @NonNull e eVar) {
        this.f9063a = (q) L0.q.checkNotNull(qVar);
        this.b = (List) L0.q.checkNotNull(list);
        this.c = (e) L0.q.checkNotNull(eVar);
    }
}
