package S2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.provider.Settings;
import android.speech.SpeechRecognizer;
import com.idlefish.flutterboost.FlutterBoost;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.E;
import p007a4.M;
import p102s.C1628a;
import p102s.C1629b;
import p102s.C1631d;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f643a;
    public final /* synthetic */ O3.l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i5, E3.g gVar, O3.l lVar) {
        super(2, gVar);
        this.f643a = i5;
        this.b = lVar;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f643a) {
            case 0:
                return new n(0, gVar, this.b);
            case 1:
                return new n(1, gVar, this.b);
            case 2:
                return new n(2, gVar, this.b);
            default:
                return new n(3, gVar, this.b);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f643a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return ((n) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z6;
        int i5 = this.f643a;
        F3.i.getCOROUTINE_SUSPENDED();
        switch (i5) {
            case 0:
                p147z3.v.throwOnFailure(obj);
                this.b.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("ContentResolver is null")))));
                break;
            case 1:
                p147z3.v.throwOnFailure(obj);
                this.b.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(G3.b.boxBoolean(true))));
                break;
            case 2:
                p147z3.v.throwOnFailure(obj);
                this.b.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(G3.b.boxBoolean(false))));
                break;
            default:
                p147z3.v.throwOnFailure(obj);
                C1628a c1628a = C1631d.Companion;
                if (c1628a.getSpeechRecognizer() != null) {
                    SpeechRecognizer speechRecognizer = c1628a.getSpeechRecognizer();
                    E.c(speechRecognizer);
                    speechRecognizer.destroy();
                }
                String string = Settings.Secure.getString(FlutterBoost.instance().currentActivity().getContentResolver(), "voice_recognition_service");
                O3.l lVar = this.b;
                if (string != null) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(string);
                    if (componentNameUnflattenFromString != null) {
                        List<ResolveInfo> listQueryIntentServices = FlutterBoost.instance().currentActivity().getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 131072);
                        E.e(listQueryIntentServices, "queryIntentServices(...)");
                        if (!listQueryIntentServices.isEmpty()) {
                            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                            ComponentName componentName = null;
                            while (true) {
                                if (it.hasNext()) {
                                    ResolveInfo next = it.next();
                                    if (E.a(next.serviceInfo.packageName, componentNameUnflattenFromString.getPackageName()) && E.a(next.serviceInfo.name, componentNameUnflattenFromString.getClassName())) {
                                        z6 = true;
                                    } else {
                                        ServiceInfo serviceInfo = next.serviceInfo;
                                        componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                                    }
                                } else {
                                    z6 = false;
                                }
                            }
                            C1628a c1628a2 = C1631d.Companion;
                            c1628a2.setSpeechRecognizer(z6 ? SpeechRecognizer.createSpeechRecognizer(FlutterBoost.instance().currentActivity()) : SpeechRecognizer.createSpeechRecognizer(FlutterBoost.instance().currentActivity(), componentName));
                            SpeechRecognizer speechRecognizer2 = c1628a2.getSpeechRecognizer();
                            E.c(speechRecognizer2);
                            speechRecognizer2.setRecognitionListener(new C1629b(lVar));
                            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
                            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
                            intent.putExtra("calling_package", FlutterBoost.instance().currentActivity().getPackageName());
                            intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault().toLanguageTag());
                            try {
                                SpeechRecognizer speechRecognizer3 = c1628a2.getSpeechRecognizer();
                                E.c(speechRecognizer3);
                                speechRecognizer3.startListening(intent);
                            } catch (SecurityException e) {
                                lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(e))));
                            }
                        } else {
                            lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Speech recognition service not found")))));
                        }
                    } else {
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Speech recognition service not found")))));
                    }
                } else {
                    lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("Speech recognition service not found")))));
                }
                break;
        }
        return Q.INSTANCE;
    }
}
