package Q0;

import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private final Executor backgroundThreadExecutor;
    private final DiffUtil.ItemCallback<Object> diffCallback;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final Executor mainThreadExecutor;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a {
        public static final Object d = new Object();
        public static ExecutorService e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f572a;
        public Executor b;
        public final DiffUtil.ItemCallback c;

        public a(DiffUtil.ItemCallback<Object> mDiffCallback) {
            E.g(mDiffCallback, "mDiffCallback");
            this.c = mDiffCallback;
        }

        public final f build() {
            if (this.b == null) {
                synchronized (d) {
                    if (e == null) {
                        e = Executors.newFixedThreadPool(2);
                    }
                }
                this.b = e;
            }
            Executor executor = this.f572a;
            Executor executor2 = this.b;
            if (executor2 != null) {
                return new f(executor, executor2, this.c);
            }
            E.k();
            throw null;
        }

        public final a setBackgroundThreadExecutor(Executor executor) {
            this.b = executor;
            return this;
        }

        public final a setMainThreadExecutor(Executor executor) {
            this.f572a = executor;
            return this;
        }
    }

    public f(Executor executor, Executor backgroundThreadExecutor, DiffUtil.ItemCallback<Object> diffCallback) {
        E.g(backgroundThreadExecutor, "backgroundThreadExecutor");
        E.g(diffCallback, "diffCallback");
        this.mainThreadExecutor = executor;
        this.backgroundThreadExecutor = backgroundThreadExecutor;
        this.diffCallback = diffCallback;
    }

    public final Executor getBackgroundThreadExecutor() {
        return this.backgroundThreadExecutor;
    }

    public final DiffUtil.ItemCallback<Object> getDiffCallback() {
        return this.diffCallback;
    }

    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }
}
