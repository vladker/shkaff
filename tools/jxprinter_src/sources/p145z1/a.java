package p145z1;

import java.util.ArrayList;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements k {
    private final ArrayList<n> texts = new ArrayList<>();

    public final void addText(n text) {
        E.f(text, "text");
        this.texts.add(text);
    }

    public final ArrayList<n> getTexts() {
        return this.texts;
    }
}
