package androidx.window.embedding;

import android.os.Build;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ExtensionEmbeddingBackend$splitSupportStatus$2 extends F implements O3.a {
    final /* synthetic */ ExtensionEmbeddingBackend this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionEmbeddingBackend$splitSupportStatus$2(ExtensionEmbeddingBackend extensionEmbeddingBackend) {
        super(0);
        this.this$0 = extensionEmbeddingBackend;
    }

    @Override // O3.a
    public final SplitController.SplitSupportStatus invoke() {
        if (this.this$0.areExtensionsAvailable()) {
            return Build.VERSION.SDK_INT >= 31 ? ExtensionEmbeddingBackend.Api31Impl.INSTANCE.isSplitPropertyEnabled(this.this$0.applicationContext) : SplitController.SplitSupportStatus.SPLIT_AVAILABLE;
        }
        return SplitController.SplitSupportStatus.SPLIT_UNAVAILABLE;
    }
}
