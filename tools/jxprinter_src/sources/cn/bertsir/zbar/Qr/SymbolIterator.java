package cn.bertsir.zbar.Qr;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SymbolIterator implements Iterator<Symbol> {
    private Symbol current;

    public SymbolIterator(Symbol symbol) {
        this.current = symbol;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.current != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("SymbolIterator is immutable");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Symbol next() {
        Symbol symbol = this.current;
        if (symbol == null) {
            throw new NoSuchElementException("access past end of SymbolIterator");
        }
        long next = symbol.next();
        if (next != 0) {
            this.current = new Symbol(next);
            return symbol;
        }
        this.current = null;
        return symbol;
    }
}
