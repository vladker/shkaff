package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class a implements Map.Entry, Cloneable {
    public static final String[] b = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", CellUtil.HIDDEN, "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    public static final Pattern c = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
    public static final Pattern d = Pattern.compile("[^-a-zA-Z0-9_:.]");
    public static final Pattern e = Pattern.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f7464f = Pattern.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7465a;
    c parent;
    private String val;

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public static String getValidKey(String str, g gVar) {
        if (gVar == g.b) {
            Pattern pattern = c;
            if (!pattern.matcher(str).matches()) {
                String strReplaceAll = d.matcher(str).replaceAll("");
                if (pattern.matcher(strReplaceAll).matches()) {
                    return strReplaceAll;
                }
                return null;
            }
        }
        if (gVar == g.f7468a) {
            Pattern pattern2 = e;
            if (!pattern2.matcher(str).matches()) {
                String strReplaceAll2 = f7464f.matcher(str).replaceAll("");
                if (pattern2.matcher(strReplaceAll2).matches()) {
                    return strReplaceAll2;
                }
                return null;
            }
        }
        return str;
    }

    public static void htmlNoValidate(String str, String str2, Appendable appendable, h hVar) throws IOException {
        appendable.append(str);
        if (shouldCollapseAttribute(str, str2, hVar)) {
            return;
        }
        appendable.append("=\"");
        p.escape(appendable, c.checkNotNull(str2), hVar, true, false, false);
        appendable.append(Chars.DQUOTE);
    }

    public static boolean shouldCollapseAttribute(String str, String str2, h hVar) {
        if (hVar.f7470f != g.f7468a) {
            return false;
        }
        if (str2 != null) {
            return (str2.isEmpty() || str2.equalsIgnoreCase(str)) && Arrays.binarySearch(b, str) >= 0;
        }
        return true;
    }

    public final String a() {
        return c.checkNotNull(this.val);
    }

    public Object clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            String str = aVar.f7465a;
            String str2 = this.f7465a;
            if (str2 == null ? str != null : !str2.equals(str)) {
                return false;
            }
            String str3 = this.val;
            String str4 = aVar.val;
            if (str3 != null) {
                return str3.equals(str4);
            }
            if (str4 == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f7465a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return c.checkNotNull(this.val);
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        String str = this.f7465a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.val;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void html(Appendable appendable, h hVar) throws IOException {
        html(this.f7465a, this.val, appendable, hVar);
    }

    public final String toString() {
        StringBuilder sbB = W4.b.b();
        try {
            html(sbB, new i("").f7471g);
            return W4.b.g(sbB);
        } catch (IOException e6) {
            throw new U4.i(e6);
        }
    }

    public a(String str, String str2, c cVar) {
        V4.h.notNull(str);
        String strTrim = str.trim();
        V4.h.notEmpty(strTrim);
        this.f7465a = strTrim;
        this.val = str2;
        this.parent = cVar;
    }

    public static void html(String str, String str2, Appendable appendable, h hVar) throws IOException {
        String validKey = getValidKey(str, hVar.f7470f);
        if (validKey == null) {
            return;
        }
        htmlNoValidate(validKey, str2, appendable, hVar);
    }

    @Override // java.util.Map.Entry
    public String setValue(String str) {
        String str2;
        int iJ;
        String strH = this.val;
        c cVar = this.parent;
        if (cVar != null && (iJ = cVar.j((str2 = this.f7465a))) != -1) {
            strH = this.parent.h(str2);
            this.parent.c[iJ] = str;
        }
        this.val = str;
        return c.checkNotNull(strH);
    }
}
