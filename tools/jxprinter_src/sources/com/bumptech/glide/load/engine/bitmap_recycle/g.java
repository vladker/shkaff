package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2985a = new f(null);
    public final HashMap b = new HashMap();

    public final void a(m mVar, Object obj) {
        HashMap map = this.b;
        f fVar = (f) map.get(mVar);
        if (fVar == null) {
            fVar = new f(mVar);
            fVar.d = fVar;
            f fVar2 = this.f2985a;
            fVar.d = fVar2.d;
            fVar.c = fVar2;
            fVar2.d = fVar;
            fVar.d.c = fVar;
            map.put(mVar, fVar);
        } else {
            mVar.a();
        }
        if (fVar.b == null) {
            fVar.b = new ArrayList();
        }
        fVar.b.add(obj);
    }

    @Nullable
    public Object get(m mVar) {
        HashMap map = this.b;
        f fVar = (f) map.get(mVar);
        if (fVar == null) {
            fVar = new f(mVar);
            map.put(mVar, fVar);
        } else {
            mVar.a();
        }
        f fVar2 = fVar.d;
        fVar2.c = fVar.c;
        fVar.c.d = fVar2;
        f fVar3 = this.f2985a;
        fVar.d = fVar3;
        f fVar4 = fVar3.c;
        fVar.c = fVar4;
        fVar4.d = fVar;
        fVar.d.c = fVar;
        return fVar.removeLast();
    }

    @Nullable
    public Object removeLast() {
        f fVar = this.f2985a;
        f fVar2 = fVar.d;
        while (true) {
            boolean zEquals = fVar2.equals(fVar);
            Object obj = fVar2.f2984a;
            if (zEquals) {
                return null;
            }
            Object objRemoveLast = fVar2.removeLast();
            if (objRemoveLast != null) {
                return objRemoveLast;
            }
            f fVar3 = fVar2.d;
            fVar3.c = fVar2.c;
            fVar2.c.d = fVar3;
            this.b.remove(obj);
            ((m) obj).a();
            fVar2 = fVar2.d;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        f fVar = this.f2985a;
        f fVar2 = fVar.c;
        boolean z6 = false;
        while (!fVar2.equals(fVar)) {
            sb.append('{');
            sb.append(fVar2.f2984a);
            sb.append(NameUtil.COLON);
            ArrayList arrayList = fVar2.b;
            sb.append(arrayList != null ? arrayList.size() : 0);
            sb.append("}, ");
            fVar2 = fVar2.c;
            z6 = true;
        }
        if (z6) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
