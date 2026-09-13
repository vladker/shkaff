package B4;

import A3.AbstractC0157z;
import A3.T;
import A3.k0;
import A4.AbstractC0177u;
import A4.AbstractC0180x;
import A4.C0178v;
import A4.InterfaceC0171n;
import A4.N;
import A4.V;
import A4.m0;
import X3.AbstractC0239e;
import X3.W;
import X3.b0;
import android.support.v4.media.session.PlaybackStateCompat;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.P;
import kotlin.jvm.internal.S;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p147z3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t {
    public static final Map a(ArrayList arrayList) {
        V v6 = V.Companion.get(PackagingURIHelper.FORWARD_SLASH_STRING, false);
        Map mapMutableMapOf = k0.mutableMapOf(A.to(v6, new o(v6)));
        for (o oVar : T.sortedWith(arrayList, new p(0))) {
            if (((o) mapMutableMapOf.put(oVar.getCanonicalPath(), oVar)) == null) {
                while (true) {
                    V vParent = oVar.getCanonicalPath().parent();
                    if (vParent == null) {
                        break;
                    }
                    o oVar2 = (o) mapMutableMapOf.get(vParent);
                    if (oVar2 != null) {
                        oVar2.getChildren().add(oVar.getCanonicalPath());
                        break;
                    }
                    o oVar3 = new o(vParent);
                    mapMutableMapOf.put(vParent, oVar3);
                    oVar3.getChildren().add(oVar.getCanonicalPath());
                    oVar = oVar3;
                }
            }
        }
        return mapMutableMapOf;
    }

    public static final String b(int i5) {
        String string = Integer.toString(i5, AbstractC0239e.checkRadix(16));
        E.e(string, "toString(this, checkRadix(radix))");
        return "0x".concat(string);
    }

    public static final void c(InterfaceC0171n interfaceC0171n, int i5, O3.p pVar) throws IOException {
        long j6 = i5;
        while (j6 != 0) {
            if (j6 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = interfaceC0171n.readShortLe() & 65535;
            long shortLe2 = ((long) interfaceC0171n.readShortLe()) & 65535;
            long j7 = j6 - ((long) 4);
            if (j7 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            interfaceC0171n.require(shortLe2);
            long size = interfaceC0171n.getBuffer().size();
            pVar.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long size2 = (interfaceC0171n.getBuffer().size() + shortLe2) - size;
            if (size2 < 0) {
                throw new IOException(AbstractC0157z.k(shortLe, "unsupported zip: too many bytes processed for "));
            }
            if (size2 > 0) {
                interfaceC0171n.getBuffer().skip(size2);
            }
            j6 = j7 - shortLe2;
        }
    }

    public static final C0178v d(InterfaceC0171n interfaceC0171n, C0178v c0178v) throws IOException {
        kotlin.jvm.internal.T t6 = new kotlin.jvm.internal.T();
        t6.f5689a = c0178v != null ? c0178v.getLastModifiedAtMillis() : null;
        kotlin.jvm.internal.T t7 = new kotlin.jvm.internal.T();
        kotlin.jvm.internal.T t8 = new kotlin.jvm.internal.T();
        int intLe = interfaceC0171n.readIntLe();
        if (intLe != 67324752) {
            throw new IOException("bad zip: expected " + b(67324752) + " but was " + b(intLe));
        }
        interfaceC0171n.skip(2L);
        short shortLe = interfaceC0171n.readShortLe();
        int i5 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i5));
        }
        interfaceC0171n.skip(18L);
        long shortLe2 = ((long) interfaceC0171n.readShortLe()) & 65535;
        int shortLe3 = interfaceC0171n.readShortLe() & 65535;
        interfaceC0171n.skip(shortLe2);
        if (c0178v == null) {
            interfaceC0171n.skip(shortLe3);
            return null;
        }
        c(interfaceC0171n, shortLe3, new s(interfaceC0171n, t6, t7, t8));
        return new C0178v(c0178v.f83a, c0178v.b, null, c0178v.getSize(), (Long) t8.f5689a, (Long) t6.f5689a, (Long) t7.f5689a);
    }

    public static final m0 openZip(V zipPath, AbstractC0180x fileSystem, O3.l predicate) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(zipPath, "zipPath");
        E.f(fileSystem, "fileSystem");
        E.f(predicate, "predicate");
        AbstractC0177u abstractC0177uOpenReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            long size = abstractC0177uOpenReadOnly.size() - ((long) 22);
            long j6 = 0;
            if (size < 0) {
                throw new IOException("not a zip: size=" + abstractC0177uOpenReadOnly.size());
            }
            long jMax = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
            do {
                InterfaceC0171n interfaceC0171nBuffer = N.buffer(abstractC0177uOpenReadOnly.source(size));
                try {
                    if (interfaceC0171nBuffer.readIntLe() == 101010256) {
                        i eocdRecord = readEocdRecord(interfaceC0171nBuffer);
                        String utf8 = interfaceC0171nBuffer.readUtf8(eocdRecord.c);
                        interfaceC0171nBuffer.close();
                        long j7 = size - ((long) 20);
                        Throwable th = null;
                        if (j7 > 0) {
                            InterfaceC0171n interfaceC0171nBuffer2 = N.buffer(abstractC0177uOpenReadOnly.source(j7));
                            try {
                                if (interfaceC0171nBuffer2.readIntLe() == 117853008) {
                                    int intLe = interfaceC0171nBuffer2.readIntLe();
                                    long longLe = interfaceC0171nBuffer2.readLongLe();
                                    if (interfaceC0171nBuffer2.readIntLe() != 1 || intLe != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    InterfaceC0171n interfaceC0171nBuffer3 = N.buffer(abstractC0177uOpenReadOnly.source(longLe));
                                    try {
                                        int intLe2 = interfaceC0171nBuffer3.readIntLe();
                                        if (intLe2 != 101075792) {
                                            throw new IOException("bad zip: expected " + b(101075792) + " but was " + b(intLe2));
                                        }
                                        eocdRecord = readZip64EocdRecord(interfaceC0171nBuffer3, eocdRecord);
                                        L3.d.closeFinally(interfaceC0171nBuffer3, null);
                                    } catch (Throwable th2) {
                                        try {
                                            throw th2;
                                        } catch (Throwable th3) {
                                            L3.d.closeFinally(interfaceC0171nBuffer3, th2);
                                            throw th3;
                                        }
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        L3.d.closeFinally(abstractC0177uOpenReadOnly, th);
                                        throw th4;
                                    }
                                }
                                L3.d.closeFinally(interfaceC0171nBuffer2, null);
                            } catch (Throwable th5) {
                                try {
                                    throw th5;
                                } catch (Throwable th6) {
                                    L3.d.closeFinally(interfaceC0171nBuffer2, th5);
                                    throw th6;
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        InterfaceC0171n interfaceC0171nBuffer4 = N.buffer(abstractC0177uOpenReadOnly.source(eocdRecord.b));
                        try {
                            long j8 = eocdRecord.f108a;
                            while (j6 < j8) {
                                o entry = readEntry(interfaceC0171nBuffer4);
                                long j9 = j8;
                                if (entry.e >= eocdRecord.b) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (((Boolean) predicate.invoke(entry)).booleanValue()) {
                                    arrayList.add(entry);
                                }
                                j6++;
                                j8 = j9;
                                th = null;
                                throw th;
                            }
                            Throwable th7 = th;
                            L3.d.closeFinally(interfaceC0171nBuffer4, th7);
                            m0 m0Var = new m0(zipPath, fileSystem, a(arrayList), utf8);
                            L3.d.closeFinally(abstractC0177uOpenReadOnly, th7);
                            return m0Var;
                        } catch (Throwable th8) {
                            try {
                                throw th8;
                            } catch (Throwable th9) {
                                L3.d.closeFinally(interfaceC0171nBuffer4, th8);
                                throw th9;
                            }
                        }
                    }
                    interfaceC0171nBuffer.close();
                    size--;
                } catch (Throwable th10) {
                    interfaceC0171nBuffer.close();
                    throw th10;
                }
            } while (size >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } catch (Throwable th11) {
            throw th11;
        }
    }

    public static /* synthetic */ m0 openZip$default(V v6, AbstractC0180x abstractC0180x, O3.l lVar, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            lVar = q.f114a;
        }
        return openZip(v6, abstractC0180x, lVar);
    }

    public static final o readEntry(InterfaceC0171n interfaceC0171n) throws IOException {
        Long lValueOf;
        E.f(interfaceC0171n, "<this>");
        int intLe = interfaceC0171n.readIntLe();
        if (intLe != 33639248) {
            throw new IOException("bad zip: expected " + b(33639248) + " but was " + b(intLe));
        }
        interfaceC0171n.skip(4L);
        short shortLe = interfaceC0171n.readShortLe();
        int i5 = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + b(i5));
        }
        int shortLe2 = interfaceC0171n.readShortLe() & 65535;
        short shortLe3 = interfaceC0171n.readShortLe();
        int i6 = shortLe3 & 65535;
        short shortLe4 = interfaceC0171n.readShortLe();
        int i7 = shortLe4 & 65535;
        if (i6 == -1) {
            lValueOf = null;
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(14, 0);
            gregorianCalendar.set(((i7 >> 9) & 127) + 1980, ((i7 >> 5) & 15) - 1, shortLe4 & 31, (i6 >> 11) & 31, (i6 >> 5) & 63, (shortLe3 & 31) << 1);
            lValueOf = Long.valueOf(gregorianCalendar.getTime().getTime());
        }
        Long l6 = lValueOf;
        long intLe2 = ((long) interfaceC0171n.readIntLe()) & KeyboardMap.kValueMask;
        S s6 = new S();
        s6.f5688a = ((long) interfaceC0171n.readIntLe()) & KeyboardMap.kValueMask;
        S s7 = new S();
        s7.f5688a = ((long) interfaceC0171n.readIntLe()) & KeyboardMap.kValueMask;
        int shortLe5 = interfaceC0171n.readShortLe() & 65535;
        int shortLe6 = interfaceC0171n.readShortLe() & 65535;
        int shortLe7 = interfaceC0171n.readShortLe() & 65535;
        interfaceC0171n.skip(8L);
        S s8 = new S();
        s8.f5688a = ((long) interfaceC0171n.readIntLe()) & KeyboardMap.kValueMask;
        String utf8 = interfaceC0171n.readUtf8(shortLe5);
        if (b0.contains((CharSequence) utf8, (char) 0, false)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j6 = s7.f5688a == KeyboardMap.kValueMask ? 8 : 0L;
        if (s6.f5688a == KeyboardMap.kValueMask) {
            j6 += (long) 8;
        }
        if (s8.f5688a == KeyboardMap.kValueMask) {
            j6 += (long) 8;
        }
        long j7 = j6;
        P p6 = new P();
        c(interfaceC0171n, shortLe6, new r(p6, j7, s7, interfaceC0171n, s6, s8));
        if (j7 <= 0 || p6.f5686a) {
            return new o(V.Companion.get(PackagingURIHelper.FORWARD_SLASH_STRING, false).resolve(utf8), W.endsWith(utf8, PackagingURIHelper.FORWARD_SLASH_STRING, false), interfaceC0171n.readUtf8(shortLe7), intLe2, s6.f5688a, s7.f5688a, shortLe2, l6, s8.f5688a);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final i readEocdRecord(InterfaceC0171n interfaceC0171n) throws IOException {
        int shortLe = interfaceC0171n.readShortLe() & 65535;
        int shortLe2 = interfaceC0171n.readShortLe() & 65535;
        long shortLe3 = interfaceC0171n.readShortLe() & 65535;
        if (shortLe3 != (interfaceC0171n.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        interfaceC0171n.skip(4L);
        return new i(shortLe3, KeyboardMap.kValueMask & ((long) interfaceC0171n.readIntLe()), interfaceC0171n.readShortLe() & 65535);
    }

    public static final C0178v readLocalHeader(InterfaceC0171n interfaceC0171n, C0178v basicMetadata) throws IOException {
        E.f(interfaceC0171n, "<this>");
        E.f(basicMetadata, "basicMetadata");
        C0178v c0178vD = d(interfaceC0171n, basicMetadata);
        E.c(c0178vD);
        return c0178vD;
    }

    private static final i readZip64EocdRecord(InterfaceC0171n interfaceC0171n, i iVar) throws IOException {
        interfaceC0171n.skip(12L);
        int intLe = interfaceC0171n.readIntLe();
        int intLe2 = interfaceC0171n.readIntLe();
        long longLe = interfaceC0171n.readLongLe();
        if (longLe != interfaceC0171n.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        interfaceC0171n.skip(8L);
        return new i(longLe, interfaceC0171n.readLongLe(), iVar.c);
    }

    public static final void skipLocalHeader(InterfaceC0171n interfaceC0171n) throws IOException {
        E.f(interfaceC0171n, "<this>");
        d(interfaceC0171n, null);
    }
}
