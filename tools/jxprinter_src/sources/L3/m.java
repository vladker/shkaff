package L3;

import A3.AbstractC0134c;
import java.io.File;
import java.util.ArrayDeque;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AbstractC0134c {
    public final /* synthetic */ i b;
    private final ArrayDeque<i.b> state;

    public m(i iVar) {
        this.b = iVar;
        ArrayDeque<i.b> arrayDeque = new ArrayDeque<>();
        this.state = arrayDeque;
        if (iVar.start.isDirectory()) {
            arrayDeque.push(d(iVar.start));
        } else if (iVar.start.isFile()) {
            arrayDeque.push(new k(this, iVar.start));
        } else {
            this.f37a = 2;
        }
    }

    @Override // A3.AbstractC0134c
    public final void b() {
        Object obj;
        while (true) {
            i.b bVarPeek = this.state.peek();
            if (bVarPeek == null) {
                obj = null;
                break;
            }
            File fileStep = bVarPeek.step();
            if (fileStep == null) {
                this.state.pop();
            } else {
                if (fileStep.equals(bVarPeek.getRoot()) || !fileStep.isDirectory() || this.state.size() >= this.b.f447a) {
                    obj = fileStep;
                    break;
                }
                this.state.push(d(fileStep));
            }
        }
        if (obj != null) {
            c(obj);
        } else {
            this.f37a = 2;
        }
    }

    public final i.a d(File file) {
        int iOrdinal = this.b.direction.ordinal();
        if (iOrdinal == 0) {
            return new l(this, file);
        }
        if (iOrdinal == 1) {
            return new j(this, file);
        }
        throw new C1937q();
    }
}
