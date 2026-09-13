package com.appdev.standard.util.fileDownload;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f2841f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(g gVar, String str, File file) {
        super(file, str);
        this.f2841f = gVar;
    }

    @Override // com.appdev.standard.util.fileDownload.a
    public final void b(String str) {
        g gVar = this.f2841f;
        ArrayList arrayList = gVar.f2845a;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            a aVar = (a) obj;
            if (str.equals(aVar.c)) {
                arrayList.remove(aVar);
                break;
            }
        }
        Iterator it = gVar.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onDeleted(str);
        }
    }

    @Override // com.appdev.standard.util.fileDownload.a
    public final void c(String str) {
        Iterator it = this.f2841f.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onPaused(str);
        }
    }

    @Override // com.appdev.standard.util.fileDownload.a
    public final void d(String str) {
        Iterator it = this.f2841f.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onSuccess(str);
        }
    }
}
