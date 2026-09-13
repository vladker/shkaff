package p095q4;

import O3.l;
import V3.c;
import p060k4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface k {
    <T> void contextual(c cVar, l lVar);

    <T> void contextual(c cVar, b bVar);

    <Base, Sub extends Base> void polymorphic(c cVar, c cVar2, b bVar);

    <Base> void polymorphicDefault(c cVar, l lVar);

    <Base> void polymorphicDefaultDeserializer(c cVar, l lVar);

    <Base> void polymorphicDefaultSerializer(c cVar, l lVar);
}
