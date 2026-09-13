package p067m;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.TimeZone;
import p050j.a;
import p050j.d;
import p096r.c;
import p096r.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f6102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f6103r;

    public g(String str) {
        this(str, a.f5373f);
    }

    public static boolean N(int i5, String str, char[] cArr) {
        int length = cArr.length;
        if (length + i5 > str.length()) {
            return false;
        }
        for (int i6 = 0; i6 < length; i6++) {
            if (cArr[i6] != str.charAt(i5 + i6)) {
                return false;
            }
        }
        return true;
    }

    public static boolean O(char c, char c6, char c7, char c8, char c9, char c10, int i5, int i6) {
        if ((c == '1' || c == '2') && c6 >= '0' && c6 <= '9' && c7 >= '0' && c7 <= '9' && c8 >= '0' && c8 <= '9') {
            if (c9 == '0') {
                if (c10 < '1' || c10 > '9') {
                    return false;
                }
            } else if (c9 != '1' || (c10 != '0' && c10 != '1' && c10 != '2')) {
                return false;
            }
            if (i5 == 48) {
                return i6 >= 49 && i6 <= 57;
            }
            if (i5 != 49 && i5 != 50) {
                return i5 == 51 && (i6 == 48 || i6 == 49);
            }
            if (i6 >= 48 && i6 <= 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean P(char c, char c6, char c7, char c8, char c9, char c10) {
        if (c == '0') {
            if (c6 < '0' || c6 > '9') {
                return false;
            }
        } else if (c == '1') {
            if (c6 < '0' || c6 > '9') {
                return false;
            }
        } else if (c != '2' || c6 < '0' || c6 > '4') {
            return false;
        }
        if (c7 < '0' || c7 > '5') {
            if (c7 != '6' || c8 != '0') {
                return false;
            }
        } else if (c8 < '0' || c8 > '9') {
            return false;
        }
        if (c9 < '0' || c9 > '5') {
            return c9 == '6' && c10 == '0';
        }
        return c10 >= '0' && c10 <= '9';
    }

    @Override // p067m.e
    public final String A(char[] cArr) {
        String str = this.f6101n;
        this.f6100m = 0;
        int i5 = this.e;
        char c = this.d;
        String str2 = this.f6102q;
        if (!N(i5, str2, cArr)) {
            this.f6100m = -2;
            return str;
        }
        int length = this.e + cArr.length;
        int i6 = length + 1;
        if (b(length) != '\"') {
            this.f6100m = -1;
            return str;
        }
        int iIndexOf = str2.indexOf(34, i6);
        if (iIndexOf == -1) {
            throw new d("unclosed str");
        }
        String strK = K(i6, iIndexOf - i6);
        if (strK.indexOf(92) != -1) {
            while (true) {
                int i7 = 0;
                for (int i8 = iIndexOf - 1; i8 >= 0 && b(i8) == '\\'; i8--) {
                    i7++;
                }
                if (i7 % 2 == 0) {
                    break;
                }
                iIndexOf = str2.indexOf(34, iIndexOf + 1);
            }
            int i9 = this.e;
            int length2 = iIndexOf - ((cArr.length + i9) + 1);
            strK = e.r(L(i9 + cArr.length + 1, length2), length2);
        }
        char cB = b(iIndexOf + 1);
        while (cB != ',' && cB != '}') {
            if (!e.j(cB)) {
                this.f6100m = -1;
                return str;
            }
            char cB2 = b(iIndexOf + 2);
            iIndexOf++;
            cB = cB2;
        }
        this.e = iIndexOf + 1;
        this.d = cB;
        if (cB == ',') {
            int i10 = iIndexOf + 2;
            this.e = i10;
            this.d = b(i10);
            this.f6100m = 3;
            return strK;
        }
        int i11 = iIndexOf + 2;
        this.e = i11;
        char cB3 = b(i11);
        if (cB3 == ',') {
            this.f6092a = 16;
            int i12 = this.e + 1;
            this.e = i12;
            this.d = b(i12);
        } else if (cB3 == ']') {
            this.f6092a = 15;
            int i13 = this.e + 1;
            this.e = i13;
            this.d = b(i13);
        } else if (cB3 == '}') {
            this.f6092a = 13;
            int i14 = this.e + 1;
            this.e = i14;
            this.d = b(i14);
        } else {
            if (cB3 != 26) {
                this.e = i5;
                this.d = c;
                this.f6100m = -1;
                return str;
            }
            this.f6092a = 20;
        }
        this.f6100m = 4;
        return strK;
    }

    @Override // p067m.e
    public final String J() {
        return !this.f6096i ? K(this.f6095h + 1, this.f6094g) : new String(this.f6093f, 0, this.f6094g);
    }

    @Override // p067m.e
    public final String K(int i5, int i6) {
        boolean z6 = c.f7883a;
        String str = this.f6102q;
        if (!z6) {
            return str.substring(i5, i6 + i5);
        }
        char[] cArr = this.f6093f;
        if (i6 < cArr.length) {
            str.getChars(i5, i5 + i6, cArr, 0);
            return new String(this.f6093f, 0, i6);
        }
        char[] cArr2 = new char[i6];
        str.getChars(i5, i6 + i5, cArr2, 0);
        return new String(cArr2);
    }

    @Override // p067m.e
    public final char[] L(int i5, int i6) {
        boolean z6 = c.f7883a;
        String str = this.f6102q;
        if (z6) {
            char[] cArr = this.f6093f;
            if (i6 < cArr.length) {
                str.getChars(i5, i6 + i5, cArr, 0);
                return this.f6093f;
            }
        }
        char[] cArr2 = new char[i6];
        str.getChars(i5, i6 + i5, cArr2, 0);
        return cArr2;
    }

    public final byte[] M() {
        String str;
        int i5;
        int i6;
        boolean z6 = true;
        int i7 = this.f6095h + 1;
        int i8 = this.f6094g;
        int[] iArr = e.f7910q;
        if (i8 == 0) {
            return new byte[0];
        }
        int i9 = (i7 + i8) - 1;
        while (true) {
            str = this.f6102q;
            if (i7 >= i9 || iArr[str.charAt(i7)] >= 0) {
                break;
            }
            i7++;
        }
        while (i9 > 0 && iArr[str.charAt(i9)] < 0) {
            i9--;
        }
        if (str.charAt(i9) == '=') {
            i5 = str.charAt(i9 + (-1)) == '=' ? 2 : 1;
        } else {
            i5 = 0;
        }
        int i10 = (i9 - i7) + 1;
        if (i8 > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i5;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            boolean z7 = z6;
            int i15 = i7 + 4;
            int i16 = (iArr[str.charAt(i7 + 2)] << 6) | (iArr[str.charAt(i7 + 1)] << 12) | (iArr[str.charAt(i7)] << 18) | iArr[str.charAt(i7 + 3)];
            bArr[i13] = (byte) (i16 >> 16);
            int i17 = i13 + 2;
            bArr[i13 + 1] = (byte) (i16 >> 8);
            i13 += 3;
            bArr[i17] = (byte) i16;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i7 = i15;
            } else {
                i7 += 6;
                i14 = 0;
            }
            z6 = z7;
        }
        if (i13 < i11) {
            int i18 = 0;
            int i19 = 0;
            while (i7 <= i9 - i5) {
                i18 |= iArr[str.charAt(i7)] << (18 - (i19 * 6));
                i19++;
                i7++;
            }
            int i20 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i18 >> i20);
                i20 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:128:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:137:0x0368  */
    /* JADX WARN: Code duplicated, block: B:139:0x0383  */
    /* JADX WARN: Code duplicated, block: B:142:0x0389  */
    /* JADX WARN: Code duplicated, block: B:149:0x039e  */
    /* JADX WARN: Code duplicated, block: B:153:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:155:0x03be  */
    /* JADX WARN: Code duplicated, block: B:162:0x03ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:172:0x0414  */
    /* JADX WARN: Code duplicated, block: B:174:0x0423  */
    /* JADX WARN: Code duplicated, block: B:199:0x049d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:203:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:205:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:209:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:249:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x023c  */
    /* JADX WARN: Code duplicated, block: B:99:0x025d  */
    public final boolean Q(boolean z6) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        char c;
        int i11;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        char c11;
        char c12;
        char c13;
        int i12;
        int i13;
        char cB;
        int i14;
        char cB2;
        char cB3;
        char cB4;
        char cB5;
        char cB6;
        char cB7;
        char cB8;
        String[] availableIDs;
        int i15;
        char cB9;
        int i16;
        int i17;
        int i18;
        int i19;
        char cB10;
        char cB11;
        char cB12;
        int i20;
        char cB13;
        char cB14;
        char cB15;
        int i21 = this.e;
        int i22 = this.f6103r;
        int i23 = i22 - i21;
        if (!z6 && i23 > 13) {
            char cB16 = b(i21);
            char cB17 = b(this.e + 1);
            char cB18 = b(this.e + 2);
            i5 = 2;
            char cB19 = b(this.e + 3);
            char cB20 = b(this.e + 4);
            i7 = 6;
            char cB21 = b(this.e + 5);
            i6 = 3;
            char cB22 = b((this.e + i23) - 1);
            char cB23 = b((this.e + i23) - 2);
            if (cB16 == '/' && cB17 == 'D' && cB18 == 'a' && cB19 == 't' && cB20 == 'e' && cB21 == '(' && cB22 == '/' && cB23 == ')') {
                int i24 = -1;
                for (int i25 = 6; i25 < i23; i25++) {
                    char cB24 = b(this.e + i25);
                    if (cB24 != '+') {
                        if (cB24 < '0' || cB24 > '9') {
                            break;
                        }
                    } else {
                        i24 = i25;
                    }
                }
                if (i24 != -1) {
                    int i26 = this.e + 6;
                    long j6 = Long.parseLong(K(i26, i24 - i26));
                    Calendar calendar = Calendar.getInstance(this.f6098k, this.f6099l);
                    this.f6097j = calendar;
                    calendar.setTimeInMillis(j6);
                    this.f6092a = 5;
                    return true;
                }
            }
            return false;
        }
        i5 = 2;
        i6 = 3;
        i7 = 6;
        if (i23 == 8 || i23 == 14 || (i23 == 17 && b(this.e + 6) != '-')) {
            int i27 = 0;
            if (z6) {
                return false;
            }
            char cB25 = b(this.e);
            char cB26 = b(this.e + 1);
            char cB27 = b(this.e + 2);
            char cB28 = b(this.e + 3);
            char cB29 = b(this.e + 4);
            char cB30 = b(this.e + 5);
            char cB31 = b(this.e + 6);
            char cB32 = b(this.e + 7);
            if (!O(cB25, cB26, cB27, cB28, cB29, cB30, cB31, cB32)) {
                return false;
            }
            T(cB25, cB26, cB27, cB28, cB29, cB30, cB31, cB32);
            if (i23 != 8) {
                char cB33 = b(this.e + 8);
                char cB34 = b(this.e + 9);
                char cB35 = b(this.e + 10);
                char cB36 = b(this.e + 11);
                char cB37 = b(this.e + 12);
                char cB38 = b(this.e + 13);
                if (!P(cB33, cB34, cB35, cB36, cB37, cB38)) {
                    return false;
                }
                if (i23 == 17) {
                    char cB39 = b(this.e + 14);
                    char cB40 = b(this.e + 15);
                    char cB41 = b(this.e + 16);
                    if (cB39 < '0' || cB39 > '9' || cB40 < '0' || cB40 > '9' || cB41 < '0' || cB41 > '9') {
                        return false;
                    }
                    i27 = (cB41 - '0') + ((cB40 - '0') * 10) + ((cB39 - '0') * 100);
                }
                int i28 = (cB36 - '0') + ((cB35 - '0') * 10);
                i9 = (cB38 - '0') + ((cB37 - '0') * 10);
                i10 = (cB34 - '0') + ((cB33 - '0') * 10);
                i8 = i27;
                i27 = i28;
            } else {
                i8 = 0;
                i9 = 0;
                i10 = 0;
            }
            this.f6097j.set(11, i10);
            this.f6097j.set(12, i27);
            this.f6097j.set(13, i9);
            this.f6097j.set(14, i8);
            this.f6092a = 5;
            return true;
        }
        if (i23 >= 9) {
            char cB42 = b(this.e);
            char cB43 = b(this.e + 1);
            char cB44 = b(this.e + 2);
            char cB45 = b(this.e + 3);
            char cB46 = b(this.e + 4);
            char cB47 = b(this.e + 5);
            char cB48 = b(this.e + 6);
            char cB49 = b(this.e + 7);
            cB49 = b(this.e + 8);
            char cB50 = b(this.e + 9);
            if ((cB46 == '-' && cB49 == '-') || (cB46 == '/' && cB49 == '/')) {
                cB44 = cB44;
                cB45 = cB45;
                c = cB47;
                cB47 = cB48;
                cB42 = cB42;
                cB43 = cB43;
                cB49 = cB49;
                cB49 = cB50;
            } else if (cB46 == '-' && cB48 == '-') {
                if (cB49 == ' ') {
                    i11 = 8;
                    c = '0';
                    cB49 = '0';
                    c6 = cB42;
                    c7 = cB43;
                    c8 = cB44;
                    c9 = cB45;
                    c10 = c;
                    c11 = cB47;
                    c12 = cB49;
                    c13 = cB49;
                    if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                        i12 = i5;
                        i13 = i11;
                        T(c6, c7, c8, c9, c10, c11, c12, c13);
                        cB = b(this.e + i13);
                        if (cB == 'T') {
                        }
                        i14 = i13 + 9;
                        if (i23 >= i14) {
                            return false;
                        }
                        cB2 = b(this.e + i13 + 1);
                        cB3 = b(this.e + i13 + 2);
                        cB4 = b(this.e + i13 + 4);
                        cB5 = b(this.e + i13 + 5);
                        cB6 = b(this.e + i13 + 7);
                        cB7 = b(this.e + i13 + 8);
                        if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                            return false;
                        }
                        U(cB2, cB3, cB4, cB5, cB6, cB7);
                        cB8 = b(this.e + i13 + 9);
                        if (cB8 != '.') {
                            this.f6097j.set(14, 0);
                            int i29 = this.e + i14;
                            this.e = i29;
                            this.d = b(i29);
                            this.f6092a = 5;
                            if (cB8 == 'Z') {
                                availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            return true;
                        }
                        i15 = i13 + 11;
                        if (i23 >= i15) {
                            return false;
                        }
                        i16 = cB9 - '0';
                        if (i23 > i15) {
                            i17 = i16;
                            i18 = 1;
                            i19 = i12;
                        } else {
                            i17 = i16;
                            i18 = 1;
                            i19 = i12;
                        }
                        if (i18 == i19) {
                            i17 = (i17 * 10) + (cB14 - '0');
                            i18 = i6;
                        }
                        this.f6097j.set(14, i17);
                        cB10 = b(this.e + i13 + 10 + i18);
                        if (cB10 != '+') {
                            cB11 = b(this.e + i13 + 10 + i18 + 1);
                            if (cB11 >= '0') {
                                return false;
                            }
                            return false;
                        }
                        cB11 = b(this.e + i13 + 10 + i18 + 1);
                        if (cB11 >= '0') {
                            return false;
                        }
                        return false;
                        int i30 = i13 + 10 + i18 + i20;
                        cB13 = b(this.e + i30);
                        if (cB13 == 26) {
                        }
                        int i31 = this.e + i30;
                        this.e = i31;
                        this.d = b(i31);
                        this.f6092a = 5;
                        return true;
                    }
                } else {
                    i11 = 9;
                    c = '0';
                    c6 = cB42;
                    c7 = cB43;
                    c8 = cB44;
                    c9 = cB45;
                    c10 = c;
                    c11 = cB47;
                    c12 = cB49;
                    c13 = cB49;
                    if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                        i12 = i5;
                        i13 = i11;
                        T(c6, c7, c8, c9, c10, c11, c12, c13);
                        cB = b(this.e + i13);
                        if (cB == 'T') {
                        }
                        i14 = i13 + 9;
                        if (i23 >= i14) {
                            return false;
                        }
                        cB2 = b(this.e + i13 + 1);
                        cB3 = b(this.e + i13 + 2);
                        cB4 = b(this.e + i13 + 4);
                        cB5 = b(this.e + i13 + 5);
                        cB6 = b(this.e + i13 + 7);
                        cB7 = b(this.e + i13 + 8);
                        if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                            return false;
                        }
                        U(cB2, cB3, cB4, cB5, cB6, cB7);
                        cB8 = b(this.e + i13 + 9);
                        if (cB8 != '.') {
                            this.f6097j.set(14, 0);
                            int i210 = this.e + i14;
                            this.e = i210;
                            this.d = b(i210);
                            this.f6092a = 5;
                            if (cB8 == 'Z') {
                                availableIDs = TimeZone.getAvailableIDs(0);
                                if (availableIDs.length > 0) {
                                    this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                }
                            }
                            return true;
                        }
                        i15 = i13 + 11;
                        if (i23 >= i15) {
                            return false;
                        }
                        i16 = cB9 - '0';
                        if (i23 > i15) {
                            i17 = i16;
                            i18 = 1;
                            i19 = i12;
                        } else {
                            i17 = i16;
                            i18 = 1;
                            i19 = i12;
                        }
                        if (i18 == i19) {
                            i17 = (i17 * 10) + (cB14 - '0');
                            i18 = i6;
                        }
                        this.f6097j.set(14, i17);
                        cB10 = b(this.e + i13 + 10 + i18);
                        if (cB10 != '+') {
                            cB11 = b(this.e + i13 + 10 + i18 + 1);
                            if (cB11 >= '0') {
                                return false;
                            }
                            return false;
                        }
                        cB11 = b(this.e + i13 + 10 + i18 + 1);
                        if (cB11 >= '0') {
                            return false;
                        }
                        return false;
                        int i32 = i13 + 10 + i18 + i20;
                        cB13 = b(this.e + i32);
                        if (cB13 == 26) {
                        }
                        int i33 = this.e + i32;
                        this.e = i33;
                        this.d = b(i33);
                        this.f6092a = 5;
                        return true;
                    }
                }
            } else if ((cB44 == '.' && cB47 == '.') || (cB44 == '-' && cB47 == '-')) {
                c = cB45;
                cB47 = cB46;
                cB42 = cB48;
                cB49 = cB42;
                cB49 = cB43;
                cB43 = cB49;
                cB44 = cB49;
                cB45 = cB50;
            } else if (cB46 == 24180 || cB46 == 45380) {
                if (cB49 == 26376 || cB49 == 50900) {
                    if (cB50 == 26085 || cB50 == 51068) {
                        cB44 = cB44;
                        cB45 = cB45;
                        c = cB47;
                        cB47 = cB48;
                        cB42 = cB42;
                        cB43 = cB43;
                        cB49 = cB49;
                        i11 = 10;
                        cB49 = '0';
                        c6 = cB42;
                        c7 = cB43;
                        c8 = cB44;
                        c9 = cB45;
                        c10 = c;
                        c11 = cB47;
                        c12 = cB49;
                        c13 = cB49;
                        if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                            i12 = i5;
                            i13 = i11;
                            T(c6, c7, c8, c9, c10, c11, c12, c13);
                            cB = b(this.e + i13);
                            if (cB == 'T' && (cB != ' ' || z6)) {
                                if (cB == '\"' || cB == 26 || cB == 26085 || cB == 51068) {
                                    this.f6097j.set(11, 0);
                                    this.f6097j.set(12, 0);
                                    this.f6097j.set(13, 0);
                                    this.f6097j.set(14, 0);
                                    int i34 = this.e + i13;
                                    this.e = i34;
                                    this.d = b(i34);
                                    this.f6092a = 5;
                                    return true;
                                }
                                if ((cB != '+' && cB != '-') || i22 != i13 + 6 || b(this.e + i13 + 3) != ':' || b(this.e + i13 + 4) != '0' || b(this.e + i13 + 5) != '0') {
                                    return false;
                                }
                                U('0', '0', '0', '0', '0', '0');
                                this.f6097j.set(14, 0);
                                V(cB, b(this.e + i13 + 1), b(this.e + i13 + 2));
                                return true;
                            }
                            i14 = i13 + 9;
                            if (i23 >= i14 || b(this.e + i13 + 3) != ':' || b(this.e + i13 + 6) != ':') {
                                return false;
                            }
                            cB2 = b(this.e + i13 + 1);
                            cB3 = b(this.e + i13 + 2);
                            cB4 = b(this.e + i13 + 4);
                            cB5 = b(this.e + i13 + 5);
                            cB6 = b(this.e + i13 + 7);
                            cB7 = b(this.e + i13 + 8);
                            if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                                return false;
                            }
                            U(cB2, cB3, cB4, cB5, cB6, cB7);
                            cB8 = b(this.e + i13 + 9);
                            if (cB8 != '.') {
                                this.f6097j.set(14, 0);
                                int i211 = this.e + i14;
                                this.e = i211;
                                this.d = b(i211);
                                this.f6092a = 5;
                                if (cB8 == 'Z' && this.f6097j.getTimeZone().getRawOffset() != 0) {
                                    availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                return true;
                            }
                            i15 = i13 + 11;
                            if (i23 >= i15 || (cB9 = b(this.e + i13 + 10)) < '0' || cB9 > '9') {
                                return false;
                            }
                            i16 = cB9 - '0';
                            if (i23 > i15 || (cB15 = b(this.e + i13 + 11)) < '0' || cB15 > '9') {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            } else {
                                i17 = (i16 * 10) + (cB15 - '0');
                                i18 = i12;
                                i19 = i18;
                            }
                            if (i18 == i19 && (cB14 = b(this.e + i13 + 12)) >= '0' && cB14 <= '9') {
                                i17 = (i17 * 10) + (cB14 - '0');
                                i18 = i6;
                            }
                            this.f6097j.set(14, i17);
                            cB10 = b(this.e + i13 + 10 + i18);
                            if (cB10 != '+' || cB10 == '-') {
                                cB11 = b(this.e + i13 + 10 + i18 + 1);
                                if (cB11 >= '0' || cB11 > '1' || (cB12 = b(this.e + i13 + 10 + i18 + 2)) < '0' || cB12 > '9') {
                                    return false;
                                }
                                char cB51 = b(this.e + i13 + 10 + i18 + 3);
                                if (cB51 == ':') {
                                    if (b(this.e + i13 + 10 + i18 + 4) != '0' || b(this.e + i13 + 10 + i18 + 5) != '0') {
                                        return false;
                                    }
                                } else if (cB51 != '0') {
                                    i7 = i6;
                                } else {
                                    if (b(this.e + i13 + 10 + i18 + 4) != '0') {
                                        return false;
                                    }
                                    i7 = 5;
                                }
                                V(cB10, cB11, cB12);
                                i20 = i7;
                            } else if (cB10 == 'Z') {
                                if (this.f6097j.getTimeZone().getRawOffset() != 0) {
                                    String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                                    if (availableIDs2.length > 0) {
                                        this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                                    }
                                }
                                i20 = 1;
                            } else {
                                i20 = 0;
                            }
                            int i35 = i13 + 10 + i18 + i20;
                            cB13 = b(this.e + i35);
                            if (cB13 == 26 && cB13 != '\"') {
                                return false;
                            }
                            int i36 = this.e + i35;
                            this.e = i36;
                            this.d = b(i36);
                            this.f6092a = 5;
                            return true;
                        }
                    } else if (b(this.e + 10) == 26085 || b(this.e + 10) == 51068) {
                        cB44 = cB44;
                        cB45 = cB45;
                        c = cB47;
                        cB47 = cB48;
                        cB42 = cB42;
                        cB43 = cB43;
                        cB49 = cB49;
                        cB49 = cB50;
                        i11 = 11;
                        c6 = cB42;
                        c7 = cB43;
                        c8 = cB44;
                        c9 = cB45;
                        c10 = c;
                        c11 = cB47;
                        c12 = cB49;
                        c13 = cB49;
                        if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                            i12 = i5;
                            i13 = i11;
                            T(c6, c7, c8, c9, c10, c11, c12, c13);
                            cB = b(this.e + i13);
                            if (cB == 'T') {
                            }
                            i14 = i13 + 9;
                            if (i23 >= i14) {
                                return false;
                            }
                            cB2 = b(this.e + i13 + 1);
                            cB3 = b(this.e + i13 + 2);
                            cB4 = b(this.e + i13 + 4);
                            cB5 = b(this.e + i13 + 5);
                            cB6 = b(this.e + i13 + 7);
                            cB7 = b(this.e + i13 + 8);
                            if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                                return false;
                            }
                            U(cB2, cB3, cB4, cB5, cB6, cB7);
                            cB8 = b(this.e + i13 + 9);
                            if (cB8 != '.') {
                                this.f6097j.set(14, 0);
                                int i212 = this.e + i14;
                                this.e = i212;
                                this.d = b(i212);
                                this.f6092a = 5;
                                if (cB8 == 'Z') {
                                    availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                return true;
                            }
                            i15 = i13 + 11;
                            if (i23 >= i15) {
                                return false;
                            }
                            i16 = cB9 - '0';
                            if (i23 > i15) {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            } else {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            }
                            if (i18 == i19) {
                                i17 = (i17 * 10) + (cB14 - '0');
                                i18 = i6;
                            }
                            this.f6097j.set(14, i17);
                            cB10 = b(this.e + i13 + 10 + i18);
                            if (cB10 != '+') {
                                cB11 = b(this.e + i13 + 10 + i18 + 1);
                                if (cB11 >= '0') {
                                    return false;
                                }
                                return false;
                            }
                            cB11 = b(this.e + i13 + 10 + i18 + 1);
                            if (cB11 >= '0') {
                                return false;
                            }
                            return false;
                            int i37 = i13 + 10 + i18 + i20;
                            cB13 = b(this.e + i37);
                            if (cB13 == 26) {
                            }
                            int i38 = this.e + i37;
                            this.e = i38;
                            this.d = b(i38);
                            this.f6092a = 5;
                            return true;
                        }
                    }
                } else if (cB48 == 26376 || cB48 == 50900) {
                    if (cB49 == 26085 || cB49 == 51068) {
                        i11 = 10;
                        c = '0';
                        cB49 = '0';
                        c6 = cB42;
                        c7 = cB43;
                        c8 = cB44;
                        c9 = cB45;
                        c10 = c;
                        c11 = cB47;
                        c12 = cB49;
                        c13 = cB49;
                        if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                            i12 = i5;
                            i13 = i11;
                            T(c6, c7, c8, c9, c10, c11, c12, c13);
                            cB = b(this.e + i13);
                            if (cB == 'T') {
                            }
                            i14 = i13 + 9;
                            if (i23 >= i14) {
                                return false;
                            }
                            cB2 = b(this.e + i13 + 1);
                            cB3 = b(this.e + i13 + 2);
                            cB4 = b(this.e + i13 + 4);
                            cB5 = b(this.e + i13 + 5);
                            cB6 = b(this.e + i13 + 7);
                            cB7 = b(this.e + i13 + 8);
                            if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                                return false;
                            }
                            U(cB2, cB3, cB4, cB5, cB6, cB7);
                            cB8 = b(this.e + i13 + 9);
                            if (cB8 != '.') {
                                this.f6097j.set(14, 0);
                                int i213 = this.e + i14;
                                this.e = i213;
                                this.d = b(i213);
                                this.f6092a = 5;
                                if (cB8 == 'Z') {
                                    availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                return true;
                            }
                            i15 = i13 + 11;
                            if (i23 >= i15) {
                                return false;
                            }
                            i16 = cB9 - '0';
                            if (i23 > i15) {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            } else {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            }
                            if (i18 == i19) {
                                i17 = (i17 * 10) + (cB14 - '0');
                                i18 = i6;
                            }
                            this.f6097j.set(14, i17);
                            cB10 = b(this.e + i13 + 10 + i18);
                            if (cB10 != '+') {
                                cB11 = b(this.e + i13 + 10 + i18 + 1);
                                if (cB11 >= '0') {
                                    return false;
                                }
                                return false;
                            }
                            cB11 = b(this.e + i13 + 10 + i18 + 1);
                            if (cB11 >= '0') {
                                return false;
                            }
                            return false;
                            int i39 = i13 + 10 + i18 + i20;
                            cB13 = b(this.e + i39);
                            if (cB13 == 26) {
                            }
                            int i310 = this.e + i39;
                            this.e = i310;
                            this.d = b(i310);
                            this.f6092a = 5;
                            return true;
                        }
                    } else if (cB50 == 26085 || cB50 == 51068) {
                        i11 = 10;
                        c = '0';
                        c6 = cB42;
                        c7 = cB43;
                        c8 = cB44;
                        c9 = cB45;
                        c10 = c;
                        c11 = cB47;
                        c12 = cB49;
                        c13 = cB49;
                        if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                            i12 = i5;
                            i13 = i11;
                            T(c6, c7, c8, c9, c10, c11, c12, c13);
                            cB = b(this.e + i13);
                            if (cB == 'T') {
                            }
                            i14 = i13 + 9;
                            if (i23 >= i14) {
                                return false;
                            }
                            cB2 = b(this.e + i13 + 1);
                            cB3 = b(this.e + i13 + 2);
                            cB4 = b(this.e + i13 + 4);
                            cB5 = b(this.e + i13 + 5);
                            cB6 = b(this.e + i13 + 7);
                            cB7 = b(this.e + i13 + 8);
                            if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                                return false;
                            }
                            U(cB2, cB3, cB4, cB5, cB6, cB7);
                            cB8 = b(this.e + i13 + 9);
                            if (cB8 != '.') {
                                this.f6097j.set(14, 0);
                                int i214 = this.e + i14;
                                this.e = i214;
                                this.d = b(i214);
                                this.f6092a = 5;
                                if (cB8 == 'Z') {
                                    availableIDs = TimeZone.getAvailableIDs(0);
                                    if (availableIDs.length > 0) {
                                        this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                                    }
                                }
                                return true;
                            }
                            i15 = i13 + 11;
                            if (i23 >= i15) {
                                return false;
                            }
                            i16 = cB9 - '0';
                            if (i23 > i15) {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            } else {
                                i17 = i16;
                                i18 = 1;
                                i19 = i12;
                            }
                            if (i18 == i19) {
                                i17 = (i17 * 10) + (cB14 - '0');
                                i18 = i6;
                            }
                            this.f6097j.set(14, i17);
                            cB10 = b(this.e + i13 + 10 + i18);
                            if (cB10 != '+') {
                                cB11 = b(this.e + i13 + 10 + i18 + 1);
                                if (cB11 >= '0') {
                                    return false;
                                }
                                return false;
                            }
                            cB11 = b(this.e + i13 + 10 + i18 + 1);
                            if (cB11 >= '0') {
                                return false;
                            }
                            return false;
                            int i311 = i13 + 10 + i18 + i20;
                            cB13 = b(this.e + i311);
                            if (cB13 == 26) {
                            }
                            int i312 = this.e + i311;
                            this.e = i312;
                            this.d = b(i312);
                            this.f6092a = 5;
                            return true;
                        }
                    }
                }
            }
            i11 = 10;
            c6 = cB42;
            c7 = cB43;
            c8 = cB44;
            c9 = cB45;
            c10 = c;
            c11 = cB47;
            c12 = cB49;
            c13 = cB49;
            if (O(cB42, cB43, cB44, cB45, c, cB47, cB49, cB49)) {
                i12 = i5;
                i13 = i11;
                T(c6, c7, c8, c9, c10, c11, c12, c13);
                cB = b(this.e + i13);
                if (cB == 'T') {
                }
                i14 = i13 + 9;
                if (i23 >= i14) {
                    return false;
                }
                cB2 = b(this.e + i13 + 1);
                cB3 = b(this.e + i13 + 2);
                cB4 = b(this.e + i13 + 4);
                cB5 = b(this.e + i13 + 5);
                cB6 = b(this.e + i13 + 7);
                cB7 = b(this.e + i13 + 8);
                if (!P(cB2, cB3, cB4, cB5, cB6, cB7)) {
                    return false;
                }
                U(cB2, cB3, cB4, cB5, cB6, cB7);
                cB8 = b(this.e + i13 + 9);
                if (cB8 != '.') {
                    this.f6097j.set(14, 0);
                    int i215 = this.e + i14;
                    this.e = i215;
                    this.d = b(i215);
                    this.f6092a = 5;
                    if (cB8 == 'Z') {
                        availableIDs = TimeZone.getAvailableIDs(0);
                        if (availableIDs.length > 0) {
                            this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                        }
                    }
                    return true;
                }
                i15 = i13 + 11;
                if (i23 >= i15) {
                    return false;
                }
                i16 = cB9 - '0';
                if (i23 > i15) {
                    i17 = i16;
                    i18 = 1;
                    i19 = i12;
                } else {
                    i17 = i16;
                    i18 = 1;
                    i19 = i12;
                }
                if (i18 == i19) {
                    i17 = (i17 * 10) + (cB14 - '0');
                    i18 = i6;
                }
                this.f6097j.set(14, i17);
                cB10 = b(this.e + i13 + 10 + i18);
                if (cB10 != '+') {
                    cB11 = b(this.e + i13 + 10 + i18 + 1);
                    if (cB11 >= '0') {
                        return false;
                    }
                    return false;
                }
                cB11 = b(this.e + i13 + 10 + i18 + 1);
                if (cB11 >= '0') {
                    return false;
                }
                return false;
                int i313 = i13 + 10 + i18 + i20;
                cB13 = b(this.e + i313);
                if (cB13 == 26) {
                }
                int i314 = this.e + i313;
                this.e = i314;
                this.d = b(i314);
                this.f6092a = 5;
                return true;
            }
        }
        return false;
    }

    public final int R(char c) {
        int i5;
        char cB;
        this.f6100m = 0;
        int i6 = this.e;
        int i7 = i6 + 1;
        char cB2 = b(i6);
        boolean z6 = cB2 == '-';
        if (z6) {
            cB2 = b(i7);
            i7 = i6 + 2;
        }
        if (cB2 < '0' || cB2 > '9') {
            this.f6100m = -1;
            return 0;
        }
        int i8 = cB2 - '0';
        while (true) {
            i5 = i7 + 1;
            cB = b(i7);
            if (cB < '0' || cB > '9') {
                break;
            }
            i8 = (i8 * 10) + (cB - '0');
            i7 = i5;
        }
        if (cB == '.') {
            this.f6100m = -1;
            return 0;
        }
        if (i8 < 0) {
            this.f6100m = -1;
            return 0;
        }
        while (cB != c) {
            if (!e.j(cB)) {
                this.f6100m = -1;
                if (z6) {
                    return -i8;
                }
                return i8;
            }
            cB = b(i5);
            i5++;
        }
        this.e = i5;
        this.d = b(i5);
        this.f6100m = 3;
        this.f6092a = 16;
        if (z6) {
            return -i8;
        }
        return i8;
    }

    public final long S(char c) {
        int i5;
        char cB;
        this.f6100m = 0;
        int i6 = this.e;
        int i7 = i6 + 1;
        char cB2 = b(i6);
        boolean z6 = cB2 == '-';
        if (z6) {
            cB2 = b(i7);
            i7 = i6 + 2;
        }
        if (cB2 < '0' || cB2 > '9') {
            this.f6100m = -1;
            return 0L;
        }
        long j6 = cB2 - '0';
        while (true) {
            i5 = i7 + 1;
            cB = b(i7);
            if (cB < '0' || cB > '9') {
                break;
            }
            j6 = (j6 * 10) + ((long) (cB - '0'));
            i7 = i5;
        }
        if (cB == '.') {
            this.f6100m = -1;
            return 0L;
        }
        if (j6 < 0) {
            this.f6100m = -1;
            return 0L;
        }
        while (cB != c) {
            if (!e.j(cB)) {
                this.f6100m = -1;
                return j6;
            }
            int i8 = i5 + 1;
            char cB3 = b(i5);
            i5 = i8;
            cB = cB3;
        }
        this.e = i5;
        this.d = b(i5);
        this.f6100m = 3;
        this.f6092a = 16;
        return z6 ? -j6 : j6;
    }

    public final void T(char c, char c6, char c7, char c8, char c9, char c10, char c11, char c12) {
        Calendar calendar = Calendar.getInstance(this.f6098k, this.f6099l);
        this.f6097j = calendar;
        int i5 = c8 - '0';
        calendar.set(1, i5 + ((c7 - '0') * 10) + ((c6 - '0') * 100) + ((c - '0') * 1000));
        this.f6097j.set(2, ((c10 - '0') + ((c9 - '0') * 10)) - 1);
        this.f6097j.set(5, (c12 - '0') + ((c11 - '0') * 10));
    }

    public final void U(char c, char c6, char c7, char c8, char c9, char c10) {
        this.f6097j.set(11, (c6 - '0') + ((c - '0') * 10));
        this.f6097j.set(12, (c8 - '0') + ((c7 - '0') * 10));
        this.f6097j.set(13, (c10 - '0') + ((c9 - '0') * 10));
    }

    public final void V(char c, char c6, char c7) {
        int i5 = ((c7 - '0') + ((c6 - '0') * 10)) * 3600000;
        if (c == '-') {
            i5 = -i5;
        }
        if (this.f6097j.getTimeZone().getRawOffset() != i5) {
            String[] availableIDs = TimeZone.getAvailableIDs(i5);
            if (availableIDs.length > 0) {
                this.f6097j.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // p067m.e
    public final boolean a(char[] cArr) {
        return N(this.e, this.f6102q, cArr);
    }

    @Override // p067m.e
    public final char b(int i5) {
        if (i5 >= this.f6103r) {
            return (char) 26;
        }
        return this.f6102q.charAt(i5);
    }

    @Override // p067m.e
    public final BigDecimal d() {
        char cB = b((this.f6095h + this.f6094g) - 1);
        int i5 = this.f6094g;
        if (cB == 'L' || cB == 'S' || cB == 'B' || cB == 'F' || cB == 'D') {
            i5--;
        }
        int i6 = this.f6095h;
        char[] cArr = this.f6093f;
        int length = cArr.length;
        String str = this.f6102q;
        if (i5 < length) {
            str.getChars(i6, i6 + i5, cArr, 0);
            return new BigDecimal(this.f6093f, 0, i5);
        }
        char[] cArr2 = new char[i5];
        str.getChars(i6, i5 + i6, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // p067m.e
    public final String f() {
        StringBuilder sb = new StringBuilder("pos ");
        sb.append(this.e);
        sb.append(", json : ");
        String strSubstring = this.f6102q;
        if (strSubstring.length() >= 65536) {
            strSubstring = strSubstring.substring(0, 65536);
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // p067m.e
    public final boolean h() {
        int i5 = this.e;
        int i6 = this.f6103r;
        return i5 == i6 || (this.d == 26 && i5 + 1 == i6);
    }

    @Override // p067m.e
    public final char l() {
        int i5 = this.e + 1;
        this.e = i5;
        char cCharAt = i5 >= this.f6103r ? (char) 26 : this.f6102q.charAt(i5);
        this.d = cCharAt;
        return cCharAt;
    }

    @Override // p067m.e
    public final String p() {
        char cB = b((this.f6095h + this.f6094g) - 1);
        int i5 = this.f6094g;
        if (cB == 'L' || cB == 'S' || cB == 'B' || cB == 'F' || cB == 'D') {
            i5--;
        }
        return K(this.f6095h, i5);
    }

    @Override // p067m.e
    public final boolean s(char[] cArr) {
        char cB;
        boolean z6;
        this.f6100m = 0;
        if (!N(this.e, this.f6102q, cArr)) {
            this.f6100m = -2;
            return false;
        }
        int length = this.e + cArr.length;
        int i5 = length + 1;
        char cB2 = b(length);
        if (cB2 == 't') {
            int i6 = length + 2;
            if (b(i5) != 'r') {
                this.f6100m = -1;
                return false;
            }
            int i7 = length + 3;
            if (b(i6) != 'u') {
                this.f6100m = -1;
                return false;
            }
            int i8 = length + 4;
            if (b(i7) != 'e') {
                this.f6100m = -1;
                return false;
            }
            this.e = i8;
            cB = b(i8);
            z6 = true;
        } else {
            if (cB2 != 'f') {
                this.f6100m = -1;
                return false;
            }
            int i9 = length + 2;
            if (b(i5) != 'a') {
                this.f6100m = -1;
                return false;
            }
            int i10 = length + 3;
            if (b(i9) != 'l') {
                this.f6100m = -1;
                return false;
            }
            int i11 = length + 4;
            if (b(i10) != 's') {
                this.f6100m = -1;
                return false;
            }
            int i12 = length + 5;
            if (b(i11) != 'e') {
                this.f6100m = -1;
                return false;
            }
            this.e = i12;
            cB = b(i12);
            z6 = false;
        }
        while (cB != ',') {
            if (cB == '}') {
                int i13 = this.e + 1;
                this.e = i13;
                char cB3 = b(i13);
                while (cB3 != ',') {
                    if (cB3 == ']') {
                        this.f6092a = 15;
                        int i14 = this.e + 1;
                        this.e = i14;
                        this.d = b(i14);
                    } else if (cB3 == '}') {
                        this.f6092a = 13;
                        int i15 = this.e + 1;
                        this.e = i15;
                        this.d = b(i15);
                    } else if (cB3 == 26) {
                        this.f6092a = 20;
                    } else {
                        if (!e.j(cB3)) {
                            this.f6100m = -1;
                            return false;
                        }
                        int i16 = this.e + 1;
                        this.e = i16;
                        cB3 = b(i16);
                    }
                    this.f6100m = 4;
                    return z6;
                }
                this.f6092a = 16;
                int i17 = this.e + 1;
                this.e = i17;
                this.d = b(i17);
                this.f6100m = 4;
                return z6;
            }
            if (!e.j(cB)) {
                this.f6100m = -1;
                return false;
            }
            int i18 = this.e + 1;
            this.e = i18;
            cB = b(i18);
        }
        int i19 = this.e + 1;
        this.e = i19;
        this.d = b(i19);
        this.f6100m = 3;
        this.f6092a = 16;
        return z6;
    }

    @Override // p067m.e
    public final int x(char[] cArr) {
        boolean z6;
        int i5;
        char cB;
        this.f6100m = 0;
        int i6 = this.e;
        char c = this.d;
        if (!N(i6, this.f6102q, cArr)) {
            this.f6100m = -2;
            return 0;
        }
        int length = this.e + cArr.length;
        int i7 = length + 1;
        char cB2 = b(length);
        if (cB2 == '-') {
            cB2 = b(i7);
            i7 = length + 2;
            z6 = true;
        } else {
            z6 = false;
        }
        if (cB2 < '0' || cB2 > '9') {
            this.f6100m = -1;
            return 0;
        }
        int i8 = cB2 - '0';
        while (true) {
            i5 = i7 + 1;
            cB = b(i7);
            if (cB < '0' || cB > '9') {
                break;
            }
            i8 = (i8 * 10) + (cB - '0');
            i7 = i5;
        }
        if (cB == '.') {
            this.f6100m = -1;
            return 0;
        }
        if (i8 < 0) {
            this.f6100m = -1;
            return 0;
        }
        while (cB != ',' && cB != '}') {
            if (!e.j(cB)) {
                this.f6100m = -1;
                return 0;
            }
            char cB3 = b(i5);
            i5++;
            cB = cB3;
        }
        this.e = i5 - 1;
        if (cB == ',') {
            this.e = i5;
            this.d = b(i5);
            this.f6100m = 3;
            this.f6092a = 16;
            if (z6) {
                return -i8;
            }
        } else {
            if (cB == '}') {
                this.e = i5;
                char cB4 = b(i5);
                while (true) {
                    if (cB4 == ',') {
                        this.f6092a = 16;
                        int i9 = this.e + 1;
                        this.e = i9;
                        this.d = b(i9);
                        break;
                    }
                    if (cB4 == ']') {
                        this.f6092a = 15;
                        int i10 = this.e + 1;
                        this.e = i10;
                        this.d = b(i10);
                        break;
                    }
                    if (cB4 == '}') {
                        this.f6092a = 13;
                        int i11 = this.e + 1;
                        this.e = i11;
                        this.d = b(i11);
                        break;
                    }
                    if (cB4 == 26) {
                        this.f6092a = 20;
                        break;
                    }
                    if (!e.j(cB4)) {
                        this.e = i6;
                        this.d = c;
                        this.f6100m = -1;
                        return 0;
                    }
                    int i12 = this.e + 1;
                    this.e = i12;
                    cB4 = b(i12);
                }
                this.f6100m = 4;
            }
            if (z6) {
                return -i8;
            }
        }
        return i8;
    }

    @Override // p067m.e
    public final long z(char[] cArr) {
        int i5;
        char cB;
        boolean z6 = false;
        this.f6100m = 0;
        int i6 = this.e;
        char c = this.d;
        if (!N(i6, this.f6102q, cArr)) {
            this.f6100m = -2;
            return 0L;
        }
        int length = this.e + cArr.length;
        int i7 = length + 1;
        char cB2 = b(length);
        if (cB2 == '-') {
            cB2 = b(i7);
            i7 = length + 2;
            z6 = true;
        }
        if (cB2 < '0' || cB2 > '9') {
            this.e = i6;
            this.d = c;
            this.f6100m = -1;
            return 0L;
        }
        long j6 = cB2 - '0';
        while (true) {
            i5 = i7 + 1;
            cB = b(i7);
            if (cB < '0' || cB > '9') {
                break;
            }
            j6 = (j6 * 10) + ((long) (cB - '0'));
            i7 = i5;
        }
        if (cB == '.') {
            this.f6100m = -1;
            return 0L;
        }
        if (cB == ',' || cB == '}') {
            this.e = i7;
        }
        if (j6 < 0) {
            this.e = i6;
            this.d = c;
            this.f6100m = -1;
            return 0L;
        }
        while (cB != ',') {
            if (cB == '}') {
                int i8 = this.e + 1;
                this.e = i8;
                char cB3 = b(i8);
                while (true) {
                    if (cB3 == ',') {
                        this.f6092a = 16;
                        int i9 = this.e + 1;
                        this.e = i9;
                        this.d = b(i9);
                        break;
                    }
                    if (cB3 == ']') {
                        this.f6092a = 15;
                        int i10 = this.e + 1;
                        this.e = i10;
                        this.d = b(i10);
                        break;
                    }
                    if (cB3 == '}') {
                        this.f6092a = 13;
                        int i11 = this.e + 1;
                        this.e = i11;
                        this.d = b(i11);
                        break;
                    }
                    if (cB3 == 26) {
                        this.f6092a = 20;
                        break;
                    }
                    if (!e.j(cB3)) {
                        this.e = i6;
                        this.d = c;
                        this.f6100m = -1;
                        return 0L;
                    }
                    int i12 = this.e + 1;
                    this.e = i12;
                    cB3 = b(i12);
                }
                this.f6100m = 4;
                if (z6) {
                    return -j6;
                }
                return j6;
            }
            if (!e.j(cB)) {
                this.f6100m = -1;
                return 0L;
            }
            this.e = i5;
            cB = b(i5);
            i5++;
        }
        int i13 = this.e + 1;
        this.e = i13;
        this.d = b(i13);
        this.f6100m = 3;
        this.f6092a = 16;
        if (z6) {
            return -j6;
        }
        return j6;
    }

    public g(String str, int i5) {
        this.f6097j = null;
        this.f6098k = a.f5372a;
        this.f6099l = a.b;
        this.f6100m = 0;
        this.f6101n = null;
        this.c = i5;
        if ((i5 & c.InitStringFieldAsEmpty.f6089a) != 0) {
            this.f6101n = "";
        }
        char[] cArr = (char[]) e.f6090o.get();
        this.f6093f = cArr;
        if (cArr == null) {
            this.f6093f = new char[512];
        }
        this.f6102q = str;
        this.f6103r = str.length();
        this.e = -1;
        l();
        if (this.d == 65279) {
            l();
        }
    }
}
