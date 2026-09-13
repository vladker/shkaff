package D4;

import java.lang.invoke.MethodHandle;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;
import java.util.Locale;
import org.apache.commons.compress.harmony.archive.internal.nls.Messages;
import org.apache.poi.poifs.nio.CleanerUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f224a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, Object obj2, int i5) {
        this.f224a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f224a) {
            case 0:
                return Messages.lambda$setLocale$0((String) this.b, (Locale) this.c, null);
            default:
                return CleanerUtil.lambda$null$0((MethodHandle) this.b, (ByteBuffer) this.c);
        }
    }
}
