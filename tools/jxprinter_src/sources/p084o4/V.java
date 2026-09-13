package p084o4;

import kotlin.jvm.internal.E;
import p060k4.b;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f6457a;

    public V(b bVar) {
        this.f6457a = bVar;
    }

    @Override // p084o4.O
    public final b[] childSerializers() {
        return new b[]{this.f6457a};
    }

    @Override // p084o4.O, p060k4.b, p060k4.a
    public final Object deserialize(j decoder) {
        E.f(decoder, "decoder");
        throw new IllegalStateException("unsupported");
    }

    @Override // p084o4.O, p060k4.b, p060k4.m, p060k4.a
    public final r getDescriptor() {
        throw new IllegalStateException("unsupported");
    }

    @Override // p084o4.O, p060k4.b, p060k4.m
    public final void serialize(l encoder, Object obj) {
        E.f(encoder, "encoder");
        throw new IllegalStateException("unsupported");
    }

    @Override // p084o4.O
    public final b[] typeParametersSerializers() {
        return N.typeParametersSerializers(this);
    }
}
