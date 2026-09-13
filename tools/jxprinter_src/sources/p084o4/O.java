package p084o4;

import p060k4.b;
import p072m4.r;
import p078n4.j;
import p078n4.l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface O extends b {
    b[] childSerializers();

    @Override // p060k4.b, p060k4.a
    /* synthetic */ Object deserialize(j jVar);

    @Override // p060k4.b, p060k4.m, p060k4.a
    /* synthetic */ r getDescriptor();

    @Override // p060k4.b, p060k4.m
    /* synthetic */ void serialize(l lVar, Object obj);

    b[] typeParametersSerializers();
}
