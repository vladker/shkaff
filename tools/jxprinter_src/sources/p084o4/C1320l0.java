package p084o4;

import A3.I;
import O3.l;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.C1241a;
import p147z3.Q;

/* JADX INFO: renamed from: o4.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1320l0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6467a;
    public final /* synthetic */ b b;
    public final /* synthetic */ b c;

    public /* synthetic */ C1320l0(b bVar, b bVar2, int i5) {
        this.f6467a = i5;
        this.b = bVar;
        this.c = bVar2;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        C1241a buildSerialDescriptor = (C1241a) obj;
        switch (this.f6467a) {
            case 0:
                E.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.element(Constants.KEY, this.b.getDescriptor(), I.emptyList(), false);
                buildSerialDescriptor.element("value", this.c.getDescriptor(), I.emptyList(), false);
                break;
            default:
                E.f(buildSerialDescriptor, "$this$buildClassSerialDescriptor");
                buildSerialDescriptor.element("first", this.b.getDescriptor(), I.emptyList(), false);
                buildSerialDescriptor.element("second", this.c.getDescriptor(), I.emptyList(), false);
                break;
        }
        return Q.INSTANCE;
    }
}
