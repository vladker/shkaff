package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements Cloneable {
    n coreCharset;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f7469a = o.base;
    public Charset b = V4.c.b;
    public final ThreadLocal c = new ThreadLocal();
    public boolean d = true;
    public final int e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f7470f = g.f7468a;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final h clone() {
        try {
            h hVar = (h) super.clone();
            String strName = this.b.name();
            hVar.getClass();
            hVar.b = Charset.forName(strName);
            hVar.f7469a = o.valueOf(this.f7469a.name());
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final CharsetEncoder e() {
        n nVar;
        CharsetEncoder charsetEncoderNewEncoder = this.b.newEncoder();
        this.c.set(charsetEncoderNewEncoder);
        String strName = charsetEncoderNewEncoder.charset().name();
        if (strName.equals("US-ASCII")) {
            nVar = n.f7477a;
        } else {
            nVar = strName.startsWith("UTF-") ? n.b : n.c;
        }
        this.coreCharset = nVar;
        return charsetEncoderNewEncoder;
    }
}
