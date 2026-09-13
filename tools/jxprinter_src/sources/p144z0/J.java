package p144z0;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class J implements H {

    @NonNull
    private final String value;

    public J(@NonNull String str) {
        this.value = str;
    }

    @Override // p144z0.H
    public final String buildHeader() {
        return this.value;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof J) {
            return this.value.equals(((J) obj).value);
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final String toString() {
        return AbstractC0157z.s(new StringBuilder("StringHeaderFactory{value='"), this.value, "'}");
    }
}
