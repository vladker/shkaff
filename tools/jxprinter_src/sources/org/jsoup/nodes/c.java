package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.logging.log4j.util.Chars;
import org.jsoup.parser.D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements Iterable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7467a = 0;
    public String[] b = new String[3];
    public String[] c = new String[3];

    public static String checkNotNull(String str) {
        return str == null ? "" : str;
    }

    public static boolean l(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    public final void a(c cVar) {
        int i5 = cVar.f7467a;
        if (i5 == 0) {
            return;
        }
        e(this.f7467a + i5);
        int i6 = 0;
        while (true) {
            if (i6 < cVar.f7467a && l(cVar.b[i6])) {
                i6++;
            } else {
                if (i6 >= cVar.f7467a) {
                    return;
                }
                a aVar = new a(cVar.b[i6], cVar.c[i6], cVar);
                i6++;
                m(aVar);
            }
        }
    }

    public c add(String str, String str2) {
        e(this.f7467a + 1);
        String[] strArr = this.b;
        int i5 = this.f7467a;
        strArr[i5] = str;
        this.c[i5] = str2;
        this.f7467a = i5 + 1;
        return this;
    }

    public final void e(int i5) {
        V4.h.b(i5 >= this.f7467a);
        String[] strArr = this.b;
        int length = strArr.length;
        if (length >= i5) {
            return;
        }
        int i6 = length >= 3 ? this.f7467a * 2 : 3;
        if (i5 <= i6) {
            i5 = i6;
        }
        this.b = (String[]) Arrays.copyOf(strArr, i5);
        this.c = (String[]) Arrays.copyOf(this.c, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f7467a != cVar.f7467a) {
            return false;
        }
        for (int i5 = 0; i5 < this.f7467a; i5++) {
            int iJ = cVar.j(this.b[i5]);
            if (iJ == -1) {
                return false;
            }
            String str = this.c[i5];
            String str2 = cVar.c[iJ];
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final c clone() {
        try {
            c cVar = (c) super.clone();
            cVar.f7467a = this.f7467a;
            this.b = (String[]) Arrays.copyOf(this.b, this.f7467a);
            this.c = (String[]) Arrays.copyOf(this.c, this.f7467a);
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    public final int g(D d) {
        String str;
        int i5 = 0;
        if (this.f7467a == 0) {
            return 0;
        }
        boolean z6 = d.b;
        int i6 = 0;
        while (i5 < this.b.length) {
            int i7 = i5 + 1;
            int i8 = i7;
            while (true) {
                String[] strArr = this.b;
                if (i8 >= strArr.length || (str = strArr[i8]) == null) {
                    break;
                }
                if (z6 && strArr[i5].equals(str)) {
                    i6++;
                    n(i8);
                    i8--;
                } else if (!z6) {
                    String[] strArr2 = this.b;
                    if (strArr2[i5].equalsIgnoreCase(strArr2[i8])) {
                        i6++;
                        n(i8);
                        i8--;
                    }
                }
                i8++;
            }
            i5 = i7;
        }
        return i6;
    }

    public final String h(String str) {
        int iJ = j(str);
        return iJ == -1 ? "" : checkNotNull(this.c[iJ]);
    }

    public final int hashCode() {
        return (((this.f7467a * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c);
    }

    public final void html(Appendable appendable, h hVar) {
        String validKey;
        int i5 = this.f7467a;
        for (int i6 = 0; i6 < i5; i6++) {
            if (!l(this.b[i6]) && (validKey = a.getValidKey(this.b[i6], hVar.f7470f)) != null) {
                a.htmlNoValidate(validKey, this.c[i6], appendable.append(Chars.SPACE), hVar);
            }
        }
    }

    public final String i(String str) {
        int iK = k(str);
        return iK == -1 ? "" : checkNotNull(this.c[iK]);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this);
    }

    public final int j(String str) {
        V4.h.notNull(str);
        for (int i5 = 0; i5 < this.f7467a; i5++) {
            if (str.equals(this.b[i5])) {
                return i5;
            }
        }
        return -1;
    }

    public final int k(String str) {
        V4.h.notNull(str);
        for (int i5 = 0; i5 < this.f7467a; i5++) {
            if (str.equalsIgnoreCase(this.b[i5])) {
                return i5;
            }
        }
        return -1;
    }

    public final void m(a aVar) {
        V4.h.notNull(aVar);
        put(aVar.f7465a, aVar.a());
        aVar.parent = this;
    }

    public final void n(int i5) {
        int i6 = this.f7467a;
        if (i5 >= i6) {
            throw new IllegalArgumentException("Must be false");
        }
        int i7 = (i6 - i5) - 1;
        if (i7 > 0) {
            String[] strArr = this.b;
            int i8 = i5 + 1;
            System.arraycopy(strArr, i8, strArr, i5, i7);
            String[] strArr2 = this.c;
            System.arraycopy(strArr2, i8, strArr2, i5, i7);
        }
        int i9 = this.f7467a - 1;
        this.f7467a = i9;
        this.b[i9] = null;
        this.c[i9] = null;
    }

    public c put(String str, String str2) {
        V4.h.notNull(str);
        int iJ = j(str);
        if (iJ != -1) {
            this.c[iJ] = str2;
            return this;
        }
        add(str, str2);
        return this;
    }

    public void putIgnoreCase(String str, String str2) {
        int iK = k(str);
        if (iK == -1) {
            add(str, str2);
            return;
        }
        this.c[iK] = str2;
        if (this.b[iK].equals(str)) {
            return;
        }
        this.b[iK] = str;
    }

    public final String toString() {
        StringBuilder sbB = W4.b.b();
        try {
            html(sbB, new i("").f7471g);
            return W4.b.g(sbB);
        } catch (IOException e) {
            throw new U4.i(e);
        }
    }
}
