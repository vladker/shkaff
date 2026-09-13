package cn.sharesdk.framework.utils;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l implements Escaper {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a extends ThreadLocal<char[]> {
        private a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static final int b(CharSequence charSequence, int i5, int i6) {
        if (i5 >= i6) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        char cCharAt = charSequence.charAt(i5);
        int i7 = i5 + 1;
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i5);
        }
        if (i7 == i6) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i7);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i7);
    }

    public int a(CharSequence charSequence, int i5, int i6) {
        while (i5 < i6) {
            int iB = b(charSequence, i5, i6);
            if (iB < 0 || a(iB) != null) {
                break;
            }
            i5 += Character.isSupplementaryCodePoint(iB) ? 2 : 1;
        }
        return i5;
    }

    public abstract char[] a(int i5);

    @Override // cn.sharesdk.framework.utils.Escaper
    public String escape(String str) {
        int length = str.length();
        int iA = a(str, 0, length);
        return iA == length ? str : a(str, iA);
    }

    public final String a(String str, int i5) {
        int length = str.length();
        char[] cArrA = new a().get();
        int i6 = 0;
        int length2 = 0;
        while (i5 < length) {
            int iB = b(str, i5, length);
            if (iB >= 0) {
                char[] cArrA2 = a(iB);
                if (cArrA2 != null) {
                    int i7 = i5 - i6;
                    int i8 = length2 + i7;
                    int length3 = cArrA2.length + i8;
                    if (cArrA.length < length3) {
                        cArrA = a(cArrA, length2, (length - i5) + length3 + 32);
                    }
                    if (i7 > 0) {
                        str.getChars(i6, i5, cArrA, length2);
                        length2 = i8;
                    }
                    if (cArrA2.length > 0) {
                        System.arraycopy(cArrA2, 0, cArrA, length2, cArrA2.length);
                        length2 += cArrA2.length;
                    }
                }
                i6 = (Character.isSupplementaryCodePoint(iB) ? 2 : 1) + i5;
                i5 = a(str, i6, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i9 = length - i6;
        if (i9 > 0) {
            int i10 = i9 + length2;
            if (cArrA.length < i10) {
                cArrA = a(cArrA, length2, i10);
            }
            str.getChars(i6, length, cArrA, length2);
            length2 = i10;
        }
        return new String(cArrA, 0, length2);
    }

    @Override // cn.sharesdk.framework.utils.Escaper
    public Appendable escape(final Appendable appendable) {
        e.a(appendable);
        return new Appendable() { // from class: cn.sharesdk.framework.utils.l.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f2235a = -1;
            char[] b = new char[2];

            private void a(char[] cArr, int i5) throws IOException {
                for (int i6 = 0; i6 < i5; i6++) {
                    appendable.append(cArr[i6]);
                }
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence) {
                return append(charSequence, 0, charSequence.length());
            }

            @Override // java.lang.Appendable
            public Appendable append(CharSequence charSequence, int i5, int i6) throws IOException {
                int i7;
                if (i5 < i6) {
                    if (this.f2235a != -1) {
                        char cCharAt = charSequence.charAt(i5);
                        int i8 = i5 + 1;
                        if (!Character.isLowSurrogate(cCharAt)) {
                            throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Expected low surrogate character but got ", cCharAt));
                        }
                        char[] cArrA = l.this.a(Character.toCodePoint((char) this.f2235a, cCharAt));
                        if (cArrA != null) {
                            a(cArrA, cArrA.length);
                            i5 = i8;
                        } else {
                            appendable.append((char) this.f2235a);
                        }
                        this.f2235a = -1;
                        i7 = i5;
                        i5 = i8;
                    } else {
                        i7 = i5;
                    }
                    while (true) {
                        int iA = l.this.a(charSequence, i5, i6);
                        if (iA > i7) {
                            appendable.append(charSequence, i7, iA);
                        }
                        if (iA == i6) {
                            break;
                        }
                        int iB = l.b(charSequence, iA, i6);
                        if (iB < 0) {
                            this.f2235a = -iB;
                            return this;
                        }
                        char[] cArrA2 = l.this.a(iB);
                        if (cArrA2 != null) {
                            a(cArrA2, cArrA2.length);
                        } else {
                            a(this.b, Character.toChars(iB, this.b, 0));
                        }
                        i7 = (Character.isSupplementaryCodePoint(iB) ? 2 : 1) + iA;
                        i5 = i7;
                    }
                }
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) throws IOException {
                if (this.f2235a != -1) {
                    if (Character.isLowSurrogate(c)) {
                        char[] cArrA = l.this.a(Character.toCodePoint((char) this.f2235a, c));
                        if (cArrA != null) {
                            a(cArrA, cArrA.length);
                        } else {
                            appendable.append((char) this.f2235a);
                            appendable.append(c);
                        }
                        this.f2235a = -1;
                        return this;
                    }
                    throw new IllegalArgumentException("Expected low surrogate character but got '" + c + "' with value " + ((int) c));
                }
                if (Character.isHighSurrogate(c)) {
                    this.f2235a = c;
                    return this;
                }
                if (!Character.isLowSurrogate(c)) {
                    char[] cArrA2 = l.this.a(c);
                    if (cArrA2 != null) {
                        a(cArrA2, cArrA2.length);
                        return this;
                    }
                    appendable.append(c);
                    return this;
                }
                throw new IllegalArgumentException("Unexpected low surrogate character '" + c + "' with value " + ((int) c));
            }
        };
    }

    private static final char[] a(char[] cArr, int i5, int i6) {
        char[] cArr2 = new char[i6];
        if (i5 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i5);
        }
        return cArr2;
    }
}
