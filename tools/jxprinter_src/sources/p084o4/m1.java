package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.j;
import p078n4.l;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m1 implements b {
    public static final m1 INSTANCE = new m1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1345y0 f6469a = new C1345y0("kotlin.Unit", Q.INSTANCE);

    /* JADX INFO: renamed from: deserialize, reason: collision with other method in class */
    public void m1072deserialize(j decoder) {
        E.f(decoder, "decoder");
        this.f6469a.deserialize(decoder);
    }

    @Override // p060k4.b, p060k4.m, p060k4.a
    public r getDescriptor() {
        return this.f6469a.getDescriptor();
    }

    @Override // p060k4.b, p060k4.m
    public void serialize(l encoder, Q value) {
        E.f(encoder, "encoder");
        E.f(value, "value");
        this.f6469a.serialize(encoder, value);
    }

    @Override // p060k4.b, p060k4.a
    public final /* bridge */ /* synthetic */ Object deserialize(j jVar) {
        m1072deserialize(jVar);
        return Q.INSTANCE;
    }
}
