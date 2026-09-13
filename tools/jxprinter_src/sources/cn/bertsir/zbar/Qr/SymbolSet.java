package cn.bertsir.zbar.Qr;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SymbolSet extends AbstractCollection<Symbol> {
    private long peer;

    static {
        System.loadLibrary("zbar");
        init();
    }

    public SymbolSet(long j6) {
        this.peer = j6;
    }

    private native void destroy(long j6);

    private native long firstSymbol(long j6);

    private static native void init();

    public synchronized void destroy() {
        long j6 = this.peer;
        if (j6 != 0) {
            destroy(j6);
            this.peer = 0L;
        }
    }

    public void finalize() {
        destroy();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Symbol> iterator() {
        long jFirstSymbol = firstSymbol(this.peer);
        return jFirstSymbol == 0 ? new SymbolIterator(null) : new SymbolIterator(new Symbol(jFirstSymbol));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public native int size();
}
