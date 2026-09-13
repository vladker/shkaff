package org.apache.xmlbeans.impl.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlWhitespace {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;
    public static final int WS_UNSPECIFIED = 0;

    public static String collapse(String str) {
        return collapse(str, 3);
    }

    public static boolean isAllSpace(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!isSpace(str.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x006a, code lost:
    
        if (r1.charAt(r4 - 1) == ' ') goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String collapse(java.lang.String r9, int r10) {
        /*
            r0 = 1
            if (r10 == r0) goto Lbf
            if (r10 != 0) goto L7
            goto Lbf
        L7:
            r1 = 10
            int r2 = r9.indexOf(r1)
            r3 = 32
            if (r2 < 0) goto L15
            java.lang.String r9 = r9.replace(r1, r3)
        L15:
            r1 = 9
            int r2 = r9.indexOf(r1)
            if (r2 < 0) goto L21
            java.lang.String r9 = r9.replace(r1, r3)
        L21:
            r1 = 13
            int r2 = r9.indexOf(r1)
            if (r2 < 0) goto L2d
            java.lang.String r9 = r9.replace(r1, r3)
        L2d:
            r1 = r9
            r9 = 2
            if (r10 != r9) goto L32
            return r1
        L32:
            int r10 = r1.length()
            if (r10 != 0) goto L39
            goto L6e
        L39:
            r2 = 0
            char r4 = r1.charAt(r2)
            if (r4 == r3) goto L6f
            r4 = r9
        L41:
            if (r4 >= r10) goto L62
            char r5 = r1.charAt(r4)
            if (r5 != r3) goto L60
            int r5 = r4 + (-1)
            char r5 = r1.charAt(r5)
            if (r5 != r3) goto L52
            goto L6c
        L52:
            int r5 = r10 + (-1)
            if (r4 != r5) goto L57
            goto L6c
        L57:
            int r4 = r4 + 1
            char r5 = r1.charAt(r4)
            if (r5 != r3) goto L60
            goto L6c
        L60:
            int r4 = r4 + r9
            goto L41
        L62:
            if (r4 != r10) goto L6e
            int r9 = r4 + (-1)
            char r9 = r1.charAt(r9)
            if (r9 != r3) goto L6e
        L6c:
            r9 = r4
            goto L81
        L6e:
            return r1
        L6f:
            r4 = r2
        L70:
            int r9 = r4 + 1
            int r5 = r1.length()
            if (r9 >= r5) goto L80
            char r5 = r1.charAt(r9)
            if (r5 != r3) goto L80
            r4 = r9
            goto L70
        L80:
            r9 = r2
        L81:
            char[] r5 = r1.toCharArray()
        L85:
            int r4 = r4 + r0
            if (r4 < r10) goto L89
            goto La7
        L89:
            char r6 = r1.charAt(r4)
            if (r6 == r3) goto L85
        L8f:
            int r6 = r9 + 1
            int r7 = r4 + 1
            char r8 = r5[r4]
            r5[r9] = r8
            if (r7 < r10) goto L9b
            r9 = r6
            goto La7
        L9b:
            char r8 = r5[r7]
            if (r8 != r3) goto Lbc
            int r9 = r9 + 2
            int r4 = r4 + 2
            r5[r6] = r8
            if (r4 < r10) goto Lb7
        La7:
            java.lang.String r10 = new java.lang.String
            if (r9 == 0) goto Lb3
            int r0 = r9 + (-1)
            char r1 = r5[r0]
            if (r1 == r3) goto Lb2
            goto Lb3
        Lb2:
            r9 = r0
        Lb3:
            r10.<init>(r5, r2, r9)
            return r10
        Lb7:
            char r6 = r5[r4]
            if (r6 != r3) goto L8f
            goto L85
        Lbc:
            r9 = r6
            r4 = r7
            goto L8f
        Lbf:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.common.XmlWhitespace.collapse(java.lang.String, int):java.lang.String");
    }

    public static boolean isAllSpace(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (!isSpace(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }
}
