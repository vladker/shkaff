package p102s;

import A3.AbstractC0157z;
import O3.l;
import android.os.Bundle;
import android.speech.RecognitionListener;
import java.util.ArrayList;
import kotlin.jvm.internal.E;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: s.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1629b implements RecognitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f8169a;

    public C1629b(l lVar) {
        this.f8169a = lVar;
    }

    @Override // android.speech.RecognitionListener
    public final void onBufferReceived(byte[] buffer) {
        E.f(buffer, "buffer");
    }

    @Override // android.speech.RecognitionListener
    public final void onError(int i5) {
        this.f8169a.invoke(u.a(u.m1361constructorimpl(v.createFailure(new Exception(AbstractC0157z.k(i5, "Speech recognition error: "))))));
    }

    @Override // android.speech.RecognitionListener
    public final void onEvent(int i5, Bundle params) {
        E.f(params, "params");
    }

    @Override // android.speech.RecognitionListener
    public final void onPartialResults(Bundle partialResults) {
        E.f(partialResults, "partialResults");
    }

    @Override // android.speech.RecognitionListener
    public final void onReadyForSpeech(Bundle params) {
        E.f(params, "params");
    }

    @Override // android.speech.RecognitionListener
    public final void onResults(Bundle results) {
        E.f(results, "results");
        ArrayList<String> stringArrayList = results.getStringArrayList("results_recognition");
        if (stringArrayList != null) {
            this.f8169a.invoke(u.a(u.m1361constructorimpl(stringArrayList.get(0))));
        }
    }

    @Override // android.speech.RecognitionListener
    public final void onBeginningOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onEndOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public final void onRmsChanged(float f6) {
    }
}
