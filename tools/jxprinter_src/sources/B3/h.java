package B3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends j implements Iterator, P3.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(m map) {
        super(map);
        E.f(map, "map");
    }

    public final void nextAppendString(StringBuilder sb) {
        E.f(sb, "sb");
        if (this.f95a >= getMap$kotlin_stdlib().b) {
            throw new NoSuchElementException();
        }
        int i5 = this.f95a;
        this.f95a = i5 + 1;
        this.b = i5;
        Object obj = getMap$kotlin_stdlib().keysArray[this.b];
        if (obj == getMap$kotlin_stdlib()) {
            sb.append("(this Map)");
        } else {
            sb.append(obj);
        }
        sb.append(Chars.EQ);
        Object[] objArr = getMap$kotlin_stdlib().valuesArray;
        E.c(objArr);
        Object obj2 = objArr[this.b];
        if (obj2 == getMap$kotlin_stdlib()) {
            sb.append("(this Map)");
        } else {
            sb.append(obj2);
        }
        c();
    }

    @Override // java.util.Iterator
    public i next() {
        b();
        if (this.f95a >= getMap$kotlin_stdlib().b) {
            throw new NoSuchElementException();
        }
        int i5 = this.f95a;
        this.f95a = i5 + 1;
        this.b = i5;
        i iVar = new i(getMap$kotlin_stdlib(), this.b);
        c();
        return iVar;
    }
}
