package p102s;

import O3.l;
import S2.n;
import android.speech.SpeechRecognizer;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p108t.InterfaceC1778j;

/* JADX INFO: renamed from: s.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1631d implements InterfaceC1778j {
    public static final C1628a Companion = new C1628a();
    private static SpeechRecognizer speechRecognizer;

    @Override // p108t.InterfaceC1778j
    public void listen(l callback) {
        E.f(callback, "callback");
        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new n(3, null, callback));
    }
}
