package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K implements E3.g, G3.e {
    private final E3.q context;
    private final E3.g<Object> uCont;

    public K(E3.g<Object> gVar, E3.q qVar) {
        this.uCont = gVar;
        this.context = qVar;
    }

    @Override // G3.e
    public G3.e getCallerFrame() {
        E3.g<Object> gVar = this.uCont;
        if (gVar instanceof G3.e) {
            return (G3.e) gVar;
        }
        return null;
    }

    @Override // E3.g
    public E3.q getContext() {
        return this.context;
    }

    @Override // G3.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // E3.g
    public void resumeWith(Object obj) {
        this.uCont.resumeWith(obj);
    }
}
