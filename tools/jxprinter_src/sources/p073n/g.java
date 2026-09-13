package p073n;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import p067m.a;
import p067m.b;
import p067m.i;
import p067m.j;
import p096r.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends l {
    public p c;

    @Override // p073n.l
    public final int a() {
        p pVar = this.c;
        if (pVar != null) {
            return pVar.a();
        }
        return 2;
    }

    @Override // p073n.l
    public final void b(Object obj, Type type, Map map, b bVar) throws Throwable {
        Object objB;
        int i5;
        j jVar = bVar.b;
        if (this.c == null) {
            d(jVar);
        }
        d dVar = this.f6187a;
        Type typeD = dVar.f7885f;
        String str = dVar.f7884a;
        if (type instanceof ParameterizedType) {
            i iVar = bVar.f6067f;
            if (iVar != null) {
                iVar.d = (ParameterizedType) type;
            }
            typeD = d.d(type, this.b, typeD);
            this.c = jVar.b(typeD);
        }
        p pVar = this.c;
        if (!(pVar instanceof m) || (i5 = dVar.f7889j) == 0) {
            String str2 = dVar.f7896q;
            objB = (str2 == null || !(pVar instanceof f)) ? pVar.b(bVar, typeD, str) : ((f) pVar).c(bVar, typeD, str, str2);
        } else {
            objB = ((m) pVar).d(bVar, typeD, str, i5);
        }
        if (bVar.f6071j == 1) {
            a aVarF = bVar.f();
            aVarF.c = this;
            aVarF.d = bVar.f6067f;
            bVar.f6071j = 0;
            return;
        }
        if (obj == null) {
            map.put(str, objB);
        } else {
            c(obj, objB);
        }
    }

    public final p d(j jVar) {
        if (this.c == null) {
            d dVar = this.f6187a;
            p055k.b bVarC = dVar.c();
            if (bVarC == null || bVarC.deserializeUsing() == Void.class) {
                this.c = jVar.c(dVar.f7885f, dVar.e);
            } else {
                try {
                    this.c = (p) bVarC.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new p050j.d("create deserializeUsing ObjectDeserializer error", e);
                }
            }
        }
        return this.c;
    }
}
