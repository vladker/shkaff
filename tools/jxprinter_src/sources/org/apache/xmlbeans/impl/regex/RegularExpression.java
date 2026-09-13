package org.apache.xmlbeans.impl.regex;

import java.io.Serializable;
import java.text.CharacterIterator;
import java.util.Locale;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    private static final long serialVersionUID = 6242499334195006401L;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient Op operations;
    int options;
    String regex;
    Token tokentree;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ClosureContext {
        int[] offsets = new int[4];
        int currentIndex = 0;

        private int[] expandOffsets() {
            int[] iArr = this.offsets;
            int[] iArr2 = new int[iArr.length << 1];
            System.arraycopy(iArr, 0, iArr2, 0, this.currentIndex);
            return iArr2;
        }

        public void addOffset(int i5) {
            if (this.currentIndex == this.offsets.length) {
                this.offsets = expandOffsets();
            }
            int[] iArr = this.offsets;
            int i6 = this.currentIndex;
            this.currentIndex = i6 + 1;
            iArr[i6] = i5;
        }

        public boolean contains(int i5) {
            for (int i6 = 0; i6 < this.currentIndex; i6++) {
                if (this.offsets[i6] == i5) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            this.currentIndex = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class ExpressionTarget {
        public abstract char charAt(int i5);

        public abstract boolean regionMatches(boolean z6, int i5, int i6, int i7, int i8);

        public abstract boolean regionMatches(boolean z6, int i5, int i6, String str, int i7);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class StringTarget extends ExpressionTarget {
        private String target;

        public StringTarget(String str) {
            this.target = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public char charAt(int i5) {
            return this.target.charAt(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, String str, int i7) {
            if (i6 - i5 < i7) {
                return false;
            }
            return z6 ? this.target.regionMatches(true, i5, str, 0, i7) : this.target.regionMatches(i5, str, 0, i7);
        }

        public void resetTarget(String str) {
            this.target = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, int i7, int i8) {
            if (i6 - i5 < i8) {
                return false;
            }
            if (z6) {
                String str = this.target;
                return str.regionMatches(true, i5, str, i7, i8);
            }
            String str2 = this.target;
            return str2.regionMatches(i5, str2, i7, i8);
        }
    }

    public RegularExpression(String str) {
        this(str, null);
    }

    private synchronized void compile(Token token) {
        if (this.operations != null) {
            return;
        }
        this.numberOfClosures = 0;
        this.operations = compile(token, null, false);
    }

    private static final int getPreviousWordType(ExpressionTarget expressionTarget, int i5, int i6, int i7, int i8) {
        int i9 = i7 - 1;
        int wordType = getWordType(expressionTarget, i5, i6, i9, i8);
        while (wordType == 0) {
            i9--;
            wordType = getWordType(expressionTarget, i5, i6, i9, i8);
        }
        return wordType;
    }

    private static final int getWordType(ExpressionTarget expressionTarget, int i5, int i6, int i7, int i8) {
        if (i7 < i5 || i7 >= i6) {
            return 2;
        }
        return getWordType0(expressionTarget.charAt(i7), i8);
    }

    private static int getWordType0(char c, int i5) {
        if (!isSet(i5, 64)) {
            if (isSet(i5, 32)) {
                return Token.getRange("IsWord", true).match(c) ? 1 : 2;
            }
            return isWordChar(c) ? 1 : 2;
        }
        int type = Character.getType(c);
        if (type == 15) {
            switch (c) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    return 2;
                default:
                    return 0;
            }
        }
        if (type != 16) {
            switch (type) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 1;
                case 6:
                case 7:
                    break;
                default:
                    return 2;
            }
        }
        return 0;
    }

    private static boolean isEOLChar(int i5) {
        return i5 == 10 || i5 == 13 || i5 == LINE_SEPARATOR || i5 == PARAGRAPH_SEPARATOR;
    }

    private static boolean isSet(int i5, int i6) {
        return (i5 & i6) == i6;
    }

    private static boolean isWordChar(int i5) {
        if (i5 == 95) {
            return true;
        }
        if (i5 < 48 || i5 > 122) {
            return false;
        }
        if (i5 <= 57) {
            return true;
        }
        if (i5 < 65) {
            return false;
        }
        return i5 <= 90 || i5 >= 97;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:183:0x0362  */
    /* JADX WARN: Code duplicated, block: B:186:0x0369  */
    /* JADX WARN: Code duplicated, block: B:193:0x0383  */
    /* JADX WARN: Code duplicated, block: B:194:0x0386  */
    /* JADX WARN: Code duplicated, block: B:197:0x038b  */
    /* JADX WARN: Code duplicated, block: B:204:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:208:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:213:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:230:0x0368 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x03f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x03af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x037f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:237:0x0390 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x039a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x037b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x03ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x0378 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:260:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x010c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0192 A[PHI: r2 r4 r5 r6 r8 r9 r12 r13 r14 r15
  0x0192: PHI (r2v6 org.apache.xmlbeans.impl.regex.Op) = 
  (r2v10 org.apache.xmlbeans.impl.regex.Op)
  (r2v11 org.apache.xmlbeans.impl.regex.Op)
  (r2v10 org.apache.xmlbeans.impl.regex.Op)
  (r2v10 org.apache.xmlbeans.impl.regex.Op)
  (r2v23 org.apache.xmlbeans.impl.regex.Op)
  (r2v39 org.apache.xmlbeans.impl.regex.Op)
  (r2v40 org.apache.xmlbeans.impl.regex.Op)
 binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r4v3 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget) = 
  (r4v4 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v4 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v4 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v4 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v5 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v17 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v1 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
 binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r5v3 boolean) = (r5v4 boolean), (r5v4 boolean), (r5v4 boolean), (r5v4 boolean), (r5v8 boolean), (r5v28 boolean), (r5v31 boolean) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r6v4 int) = (r6v5 int), (r6v5 int), (r6v5 int), (r6v5 int), (r6v10 int), (r6v19 int), (r6v23 int) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r8v2 int) = (r8v5 int), (r8v5 int), (r8v5 int), (r8v5 int), (r8v13 int), (r8v31 int), (r8v34 int) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r9v2 org.apache.xmlbeans.impl.regex.RegularExpression) = 
  (r9v3 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v3 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v3 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v3 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v9 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v25 org.apache.xmlbeans.impl.regex.RegularExpression)
  (r9v29 org.apache.xmlbeans.impl.regex.RegularExpression)
 binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r12v4 org.apache.xmlbeans.impl.regex.RegularExpression$Context) = 
  (r12v5 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v5 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v5 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v5 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v10 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v25 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r12v27 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
 binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r13v2 int) = (r13v4 int), (r13v5 int), (r13v6 int), (r13v3 int), (r13v1 int), (r13v1 int), (r13v1 int) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r14v4 int) = (r14v6 int), (r14v6 int), (r14v6 int), (r14v6 int), (r14v13 int), (r14v22 int), (r14v1 int) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x0192: PHI (r15v3 boolean) = (r15v5 boolean), (r15v6 boolean), (r15v5 boolean), (r15v5 boolean), (r15v1 boolean), (r15v11 boolean), (r15v1 boolean) binds: [B:207:0x03aa, B:205:0x03a2, B:203:0x039e, B:241:0x0192, B:122:0x0280, B:70:0x0191, B:72:0x0196] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x01b0 A[PHI: r1 r2 r4 r5 r6 r9 r14 r17
  0x01b0: PHI (r1v40 org.apache.xmlbeans.impl.regex.RegularExpression$Context) = 
  (r1v39 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r1v39 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r1v39 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
  (r1v42 org.apache.xmlbeans.impl.regex.RegularExpression$Context)
 binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r2v35 int) = (r2v32 int), (r2v32 int), (r2v32 int), (r2v37 int) binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r4v14 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget) = 
  (r4v1 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v1 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v1 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
  (r4v16 org.apache.xmlbeans.impl.regex.RegularExpression$ExpressionTarget)
 binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r5v26 int) = (r5v23 int), (r5v23 int), (r5v23 int), (r5v27 int) binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r6v17 int) = (r6v15 int), (r6v15 int), (r6v15 int), (r6v18 int) binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r9v23 boolean) = (r9v21 boolean), (r9v21 boolean), (r9v21 boolean), (r9v24 boolean) binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r14v20 org.apache.xmlbeans.impl.regex.Op) = 
  (r14v18 org.apache.xmlbeans.impl.regex.Op)
  (r14v18 org.apache.xmlbeans.impl.regex.Op)
  (r14v18 org.apache.xmlbeans.impl.regex.Op)
  (r14v21 org.apache.xmlbeans.impl.regex.Op)
 binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]
  0x01b0: PHI (r17v9 boolean) = (r17v8 boolean), (r17v8 boolean), (r17v8 boolean), (r17v10 boolean) binds: [B:82:0x01cd, B:83:0x01cf, B:92:0x01f5, B:74:0x01ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:188:0x0378. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:189:0x037b. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:182:0x0360 for B:188:0x0378 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:182:0x0360 for B:189:0x037b already processed. Defaulting to fallback option. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0192 -> B:182:0x0360). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    private int match(org.apache.xmlbeans.impl.regex.RegularExpression.Context r21, org.apache.xmlbeans.impl.regex.Op r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 1090
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.match(org.apache.xmlbeans.impl.regex.RegularExpression$Context, org.apache.xmlbeans.impl.regex.Op, int, int, int):int");
    }

    private boolean matchChar(int i5, int i6, boolean z6) {
        if (z6) {
            return matchIgnoreCase(i5, i6);
        }
        return i5 == i6;
    }

    private static boolean matchIgnoreCase(int i5, int i6) {
        char upperCase;
        char upperCase2;
        if (i5 == i6) {
            return true;
        }
        return i5 <= 65535 && i6 <= 65535 && ((upperCase = Character.toUpperCase((char) i5)) == (upperCase2 = Character.toUpperCase((char) i6)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RegularExpression)) {
            return false;
        }
        RegularExpression regularExpression = (RegularExpression) obj;
        return this.regex.equals(regularExpression.regex) && this.options == regularExpression.options;
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    public String getOptions() {
        return REUtil.createOptionString(this.options);
    }

    public String getPattern() {
        return this.regex;
    }

    public int hashCode() {
        return (this.regex + PackagingURIHelper.FORWARD_SLASH_STRING + getOptions()).hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean matchAnchor(ExpressionTarget expressionTarget, Op op, Context context, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int wordType;
        int wordType2;
        int data = op.getData();
        if (data != 36) {
            if (data != 60) {
                if (data != 62) {
                    if (data == 90) {
                        int i11 = context.limit;
                        if (i5 != i11 && (((i10 = i5 + 1) != i11 || !isEOLChar(expressionTarget.charAt(i5))) && (i5 + 2 != context.limit || expressionTarget.charAt(i5) != '\r' || expressionTarget.charAt(i10) != '\n'))) {
                            return false;
                        }
                    } else if (data != 94) {
                        if (data != 98) {
                            if (data != 122) {
                                switch (data) {
                                    case 64:
                                        int i12 = context.start;
                                        if (i5 != i12 && (i5 <= i12 || !isEOLChar(expressionTarget.charAt(i5 - 1)))) {
                                            return false;
                                        }
                                        break;
                                    case 65:
                                        if (i5 != context.start) {
                                            return false;
                                        }
                                        break;
                                    case 66:
                                        if (context.length != 0 && (wordType2 = getWordType(expressionTarget, context.start, context.limit, i5, i6)) != 0 && wordType2 != getPreviousWordType(expressionTarget, context.start, context.limit, i5, i6)) {
                                            return false;
                                        }
                                        break;
                                }
                            } else if (i5 != context.limit) {
                                return false;
                            }
                        } else if (context.length == 0 || (wordType = getWordType(expressionTarget, context.start, context.limit, i5, i6)) == 0 || wordType == getPreviousWordType(expressionTarget, context.start, context.limit, i5, i6)) {
                            return false;
                        }
                    } else if (isSet(i6, 8)) {
                        int i13 = context.start;
                        if (i5 != i13 && (i5 <= i13 || i5 >= context.limit || !isEOLChar(expressionTarget.charAt(i5 - 1)))) {
                            return false;
                        }
                    } else if (i5 != context.start) {
                        return false;
                    }
                } else if (context.length == 0 || i5 == (i9 = context.start) || getWordType(expressionTarget, i9, context.limit, i5, i6) != 2 || getPreviousWordType(expressionTarget, context.start, context.limit, i5, i6) != 1) {
                    return false;
                }
            } else if (context.length == 0 || i5 == (i8 = context.limit) || getWordType(expressionTarget, context.start, i8, i5, i6) != 1 || getPreviousWordType(expressionTarget, context.start, context.limit, i5, i6) != 2) {
                return false;
            }
        } else if (isSet(i6, 8)) {
            int i14 = context.limit;
            if (i5 != i14 && (i5 >= i14 || !isEOLChar(expressionTarget.charAt(i5)))) {
                return false;
            }
        } else {
            int i15 = context.limit;
            if (i5 != i15 && (((i7 = i5 + 1) != i15 || !isEOLChar(expressionTarget.charAt(i5))) && (i5 + 2 != context.limit || expressionTarget.charAt(i5) != '\r' || expressionTarget.charAt(i7) != '\n'))) {
                return false;
            }
        }
        return true;
    }

    public boolean matches(char[] cArr) {
        return matches(cArr, 0, cArr.length, (Match) null);
    }

    public void prepare() {
        int i5;
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (!isSet(this.options, 128) && !isSet(this.options, 512)) {
            RangeToken rangeTokenCreateRange = Token.createRange();
            if (this.tokentree.analyzeFirstCharacter(rangeTokenCreateRange, this.options) == 1) {
                rangeTokenCreateRange.compactRanges();
                this.firstChar = rangeTokenCreateRange;
            }
        }
        Op op = this.operations;
        if (op != null && (((i5 = op.type) == 6 || i5 == 1) && op.next == null)) {
            this.fixedStringOnly = true;
            if (i5 == 6) {
                this.fixedString = op.getString();
            } else if (op.getData() >= 65536) {
                this.fixedString = REUtil.decomposeToSurrogates(this.operations.getData());
            } else {
                this.fixedString = new String(new char[]{(char) this.operations.getData()});
            }
            int i6 = this.options;
            this.fixedStringOptions = i6;
            this.fixedStringTable = new BMPattern(this.fixedString, 256, isSet(i6, 2));
            return;
        }
        if (isSet(this.options, 256) || isSet(this.options, 512)) {
            return;
        }
        Token.FixedStringContainer fixedStringContainer = new Token.FixedStringContainer();
        this.tokentree.findFixedString(fixedStringContainer, this.options);
        Token token = fixedStringContainer.token;
        String string = token == null ? null : token.getString();
        this.fixedString = string;
        this.fixedStringOptions = fixedStringContainer.options;
        if (string != null && string.length() < 2) {
            this.fixedString = null;
        }
        String str = this.fixedString;
        if (str != null) {
            this.fixedStringTable = new BMPattern(str, 256, isSet(this.fixedStringOptions, 2));
        }
    }

    public void setPattern(String str) {
        setPattern(str, Locale.getDefault());
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CharArrayTarget extends ExpressionTarget {
        char[] target;

        public CharArrayTarget(char[] cArr) {
            this.target = cArr;
        }

        private boolean regionMatchesIgnoreCase(int i5, int i6, String str, int i7) {
            char upperCase;
            char upperCase2;
            int i8 = 0;
            while (true) {
                int i9 = i7 - 1;
                if (i7 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                char c = this.target[i5];
                int i11 = i8 + 1;
                char cCharAt = str.charAt(i8);
                if (c != cCharAt && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i8 = i11;
                i7 = i9;
                i5 = i10;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public char charAt(int i5) {
            return this.target[i5];
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, String str, int i7) {
            if (i5 < 0 || i6 - i5 < i7) {
                return false;
            }
            return z6 ? regionMatchesIgnoreCase(i5, i6, str, i7) : regionMatches(i5, i6, str, i7);
        }

        public void resetTarget(char[] cArr) {
            this.target = cArr;
        }

        private boolean regionMatches(int i5, int i6, String str, int i7) {
            int i8 = 0;
            while (true) {
                int i9 = i7 - 1;
                if (i7 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                int i11 = i8 + 1;
                if (this.target[i5] != str.charAt(i8)) {
                    return false;
                }
                i8 = i11;
                i7 = i9;
                i5 = i10;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, int i7, int i8) {
            if (i5 < 0 || i6 - i5 < i8) {
                return false;
            }
            if (z6) {
                return regionMatchesIgnoreCase(i5, i6, i7, i8);
            }
            return regionMatches(i5, i6, i7, i8);
        }

        private boolean regionMatches(int i5, int i6, int i7, int i8) {
            while (true) {
                int i9 = i8 - 1;
                if (i8 <= 0) {
                    return true;
                }
                char[] cArr = this.target;
                int i10 = i5 + 1;
                int i11 = i7 + 1;
                if (cArr[i5] != cArr[i7]) {
                    return false;
                }
                i8 = i9;
                i5 = i10;
                i7 = i11;
            }
        }

        private boolean regionMatchesIgnoreCase(int i5, int i6, int i7, int i8) {
            char upperCase;
            char upperCase2;
            while (true) {
                int i9 = i8 - 1;
                if (i8 <= 0) {
                    return true;
                }
                char[] cArr = this.target;
                int i10 = i5 + 1;
                char c = cArr[i5];
                int i11 = i7 + 1;
                char c6 = cArr[i7];
                if (c != c6 && (upperCase = Character.toUpperCase(c)) != (upperCase2 = Character.toUpperCase(c6)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i8 = i9;
                i5 = i10;
                i7 = i11;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CharacterIteratorTarget extends ExpressionTarget {
        CharacterIterator target;

        public CharacterIteratorTarget(CharacterIterator characterIterator) {
            this.target = characterIterator;
        }

        private boolean regionMatchesIgnoreCase(int i5, int i6, String str, int i7) {
            char upperCase;
            char upperCase2;
            int i8 = 0;
            while (true) {
                int i9 = i7 - 1;
                if (i7 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                char index = this.target.setIndex(i5);
                int i11 = i8 + 1;
                char cCharAt = str.charAt(i8);
                if (index != cCharAt && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(cCharAt)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i8 = i11;
                i7 = i9;
                i5 = i10;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public char charAt(int i5) {
            return this.target.setIndex(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, String str, int i7) {
            if (i5 < 0 || i6 - i5 < i7) {
                return false;
            }
            return z6 ? regionMatchesIgnoreCase(i5, i6, str, i7) : regionMatches(i5, i6, str, i7);
        }

        public void resetTarget(CharacterIterator characterIterator) {
            this.target = characterIterator;
        }

        private boolean regionMatches(int i5, int i6, String str, int i7) {
            int i8 = 0;
            while (true) {
                int i9 = i7 - 1;
                if (i7 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                int i11 = i8 + 1;
                if (this.target.setIndex(i5) != str.charAt(i8)) {
                    return false;
                }
                i8 = i11;
                i7 = i9;
                i5 = i10;
            }
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        public boolean regionMatches(boolean z6, int i5, int i6, int i7, int i8) {
            if (i5 < 0 || i6 - i5 < i8) {
                return false;
            }
            if (z6) {
                return regionMatchesIgnoreCase(i5, i6, i7, i8);
            }
            return regionMatches(i5, i6, i7, i8);
        }

        private boolean regionMatches(int i5, int i6, int i7, int i8) {
            while (true) {
                int i9 = i8 - 1;
                if (i8 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                int i11 = i7 + 1;
                if (this.target.setIndex(i5) != this.target.setIndex(i7)) {
                    return false;
                }
                i8 = i9;
                i5 = i10;
                i7 = i11;
            }
        }

        private boolean regionMatchesIgnoreCase(int i5, int i6, int i7, int i8) {
            char upperCase;
            char upperCase2;
            while (true) {
                int i9 = i8 - 1;
                if (i8 <= 0) {
                    return true;
                }
                int i10 = i5 + 1;
                char index = this.target.setIndex(i5);
                int i11 = i7 + 1;
                char index2 = this.target.setIndex(i7);
                if (index != index2 && (upperCase = Character.toUpperCase(index)) != (upperCase2 = Character.toUpperCase(index2)) && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
                i8 = i9;
                i5 = i10;
                i7 = i11;
            }
        }
    }

    public RegularExpression(String str, String str2) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2);
    }

    public boolean matches(char[] cArr, int i5, int i6) {
        return matches(cArr, i5, i6, (Match) null);
    }

    public void setPattern(String str, Locale locale) {
        setPattern(str, this.options, locale);
    }

    private void setPattern(String str, int i5, Locale locale) {
        this.regex = str;
        this.options = i5;
        RegexParser parserForXMLSchema = isSet(i5, 512) ? new ParserForXMLSchema(locale) : new RegexParser(locale);
        this.tokentree = parserForXMLSchema.parse(this.regex, this.options);
        this.nofparen = parserForXMLSchema.parennumber;
        this.hasBackReferences = parserForXMLSchema.hasBackReferences;
        this.operations = null;
        this.context = null;
    }

    public boolean matches(char[] cArr, Match match) {
        return matches(cArr, 0, cArr.length, match);
    }

    public boolean equals(String str, int i5) {
        return this.regex.equals(str) && this.options == i5;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0168  */
    /* JADX WARN: Code duplicated, block: B:98:0x0158  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:110:0x0171
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public boolean matches(char[] r9, int r10, int r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(char[], int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.xmlbeans.impl.regex.Op, org.apache.xmlbeans.impl.regex.Op$ChildOp] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v3, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v4, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [org.apache.xmlbeans.impl.regex.Op] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [org.apache.xmlbeans.impl.regex.RegularExpression] */
    private Op compile(Token token, Op op, boolean z6) {
        Op.ChildOp childOpCreateClosure;
        ?? Compile;
        int i5 = token.type;
        int i6 = 0;
        switch (i5) {
            case 0:
                Op.CharOp charOpCreateChar = Op.createChar(token.getChar());
                charOpCreateChar.next = op;
                return charOpCreateChar;
            case 1:
                if (!z6) {
                    for (int size = token.size() - 1; size >= 0; size--) {
                        op = compile(token.getChild(size), op, false);
                    }
                    return op;
                }
                while (i6 < token.size()) {
                    op = compile(token.getChild(i6), op, true);
                    i6++;
                }
                return op;
            case 2:
                Op.UnionOp unionOpCreateUnion = Op.createUnion(token.size());
                while (i6 < token.size()) {
                    unionOpCreateUnion.addElement(compile(token.getChild(i6), op, z6));
                    i6++;
                }
                return unionOpCreateUnion;
            case 3:
            case 9:
                Token child = token.getChild(0);
                int min = token.getMin();
                int max = token.getMax();
                if (min >= 0 && min == max) {
                    while (i6 < min) {
                        op = compile(child, op, z6);
                        i6++;
                    }
                    return op;
                }
                if (min > 0 && max > 0) {
                    max -= min;
                }
                if (max > 0) {
                    Compile = op;
                    int i7 = 0;
                    while (i7 < max) {
                        Op.ChildOp childOpCreateQuestion = Op.createQuestion(token.type == 9);
                        childOpCreateQuestion.next = op;
                        childOpCreateQuestion.setChild(compile(child, Compile, z6));
                        i7++;
                        Compile = childOpCreateQuestion;
                    }
                } else {
                    if (token.type == 9) {
                        childOpCreateClosure = Op.createNonGreedyClosure();
                    } else {
                        int i8 = this.numberOfClosures;
                        this.numberOfClosures = i8 + 1;
                        childOpCreateClosure = Op.createClosure(i8);
                    }
                    Compile = childOpCreateClosure;
                    Compile.next = op;
                    Compile.setChild(compile(child, Compile, z6));
                }
                if (min > 0) {
                    while (i6 < min) {
                        Compile = compile(child, Compile, z6);
                        i6++;
                    }
                }
                return Compile;
            case 4:
            case 5:
                Op.RangeOp rangeOpCreateRange = Op.createRange(token);
                rangeOpCreateRange.next = op;
                return rangeOpCreateRange;
            case 6:
                if (token.getParenNumber() == 0) {
                    return compile(token.getChild(0), op, z6);
                }
                if (z6) {
                    return Op.createCapture(-token.getParenNumber(), compile(token.getChild(0), Op.createCapture(token.getParenNumber(), op), z6));
                }
                return Op.createCapture(token.getParenNumber(), compile(token.getChild(0), Op.createCapture(-token.getParenNumber(), op), z6));
            case 7:
                return op;
            case 8:
                Op.CharOp charOpCreateAnchor = Op.createAnchor(token.getChar());
                charOpCreateAnchor.next = op;
                return charOpCreateAnchor;
            case 10:
                Op.StringOp stringOpCreateString = Op.createString(token.getString());
                stringOpCreateString.next = op;
                return stringOpCreateString;
            case 11:
                Op opCreateDot = Op.createDot();
                opCreateDot.next = op;
                return opCreateDot;
            case 12:
                Op.CharOp charOpCreateBackReference = Op.createBackReference(token.getReferenceNumber());
                charOpCreateBackReference.next = op;
                return charOpCreateBackReference;
            default:
                switch (i5) {
                    case 20:
                        return Op.createLook(20, op, compile(token.getChild(0), null, false));
                    case 21:
                        return Op.createLook(21, op, compile(token.getChild(0), null, false));
                    case 22:
                        return Op.createLook(22, op, compile(token.getChild(0), null, true));
                    case 23:
                        return Op.createLook(23, op, compile(token.getChild(0), null, true));
                    case 24:
                        return Op.createIndependent(op, compile(token.getChild(0), null, z6));
                    case 25:
                        Op opCompile = compile(token.getChild(0), null, z6);
                        Token.ModifierToken modifierToken = (Token.ModifierToken) token;
                        return Op.createModifier(op, opCompile, modifierToken.getOptions(), modifierToken.getOptionsMask());
                    case 26:
                        Token.ConditionToken conditionToken = (Token.ConditionToken) token;
                        int i9 = conditionToken.refNumber;
                        Token token2 = conditionToken.condition;
                        Op opCompile2 = token2 == null ? null : compile(token2, null, z6);
                        Op opCompile3 = compile(conditionToken.yes, op, z6);
                        Token token3 = conditionToken.no;
                        return Op.createCondition(op, i9, opCompile2, opCompile3, token3 != null ? compile(token3, op, z6) : null);
                    default:
                        throw new RuntimeException("Unknown token type: " + token.type);
                }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Context {
        private CharArrayTarget charArrayTarget;
        private CharacterIteratorTarget characterIteratorTarget;
        ClosureContext[] closureContexts;
        boolean inuse = false;
        int length;
        int limit;
        Match match;
        int start;
        private StringTarget stringTarget;
        ExpressionTarget target;

        private void resetCommon(int i5) {
            this.length = this.limit - this.start;
            setInUse(true);
            this.match = null;
            ClosureContext[] closureContextArr = this.closureContexts;
            if (closureContextArr == null || closureContextArr.length != i5) {
                this.closureContexts = new ClosureContext[i5];
            }
            for (int i6 = 0; i6 < i5; i6++) {
                ClosureContext[] closureContextArr2 = this.closureContexts;
                ClosureContext closureContext = closureContextArr2[i6];
                if (closureContext == null) {
                    closureContextArr2[i6] = new ClosureContext();
                } else {
                    closureContext.reset();
                }
            }
        }

        public void reset(CharacterIterator characterIterator, int i5, int i6, int i7) {
            CharacterIteratorTarget characterIteratorTarget = this.characterIteratorTarget;
            if (characterIteratorTarget == null) {
                this.characterIteratorTarget = new CharacterIteratorTarget(characterIterator);
            } else {
                characterIteratorTarget.resetTarget(characterIterator);
            }
            this.target = this.characterIteratorTarget;
            this.start = i5;
            this.limit = i6;
            resetCommon(i7);
        }

        public synchronized void setInUse(boolean z6) {
            this.inuse = z6;
        }

        public void reset(String str, int i5, int i6, int i7) {
            StringTarget stringTarget = this.stringTarget;
            if (stringTarget == null) {
                this.stringTarget = new StringTarget(str);
            } else {
                stringTarget.resetTarget(str);
            }
            this.target = this.stringTarget;
            this.start = i5;
            this.limit = i6;
            resetCommon(i7);
        }

        public void reset(char[] cArr, int i5, int i6, int i7) {
            CharArrayTarget charArrayTarget = this.charArrayTarget;
            if (charArrayTarget == null) {
                this.charArrayTarget = new CharArrayTarget(cArr);
            } else {
                charArrayTarget.resetTarget(cArr);
            }
            this.target = this.charArrayTarget;
            this.start = i5;
            this.limit = i6;
            resetCommon(i7);
        }
    }

    public RegularExpression(String str, String str2, Locale locale) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(str, str2, locale);
    }

    public void setPattern(String str, String str2) {
        setPattern(str, str2, Locale.getDefault());
    }

    public void setPattern(String str, String str2, Locale locale) {
        setPattern(str, REUtil.parseOptions(str2), locale);
    }

    public RegularExpression(String str, Token token, int i5, boolean z6, int i6) {
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        this.regex = str;
        this.tokentree = token;
        this.nofparen = i5;
        this.options = i6;
        this.hasBackReferences = z6;
    }

    public boolean matches(String str) {
        return matches(str, 0, str.length(), (Match) null);
    }

    public boolean matches(String str, int i5, int i6) {
        return matches(str, i5, i6, (Match) null);
    }

    public boolean matches(String str, Match match) {
        return matches(str, 0, str.length(), match);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0162  */
    /* JADX WARN: Code duplicated, block: B:103:0x016e  */
    /* JADX WARN: Code duplicated, block: B:98:0x015e  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:110:0x0177
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public boolean matches(java.lang.String r9, int r10, int r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.lang.String, int, int, org.apache.xmlbeans.impl.regex.Match):boolean");
    }

    public boolean matches(CharacterIterator characterIterator) {
        return matches(characterIterator, (Match) null);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0169  */
    /* JADX WARN: Code duplicated, block: B:104:0x0175  */
    /* JADX WARN: Code duplicated, block: B:99:0x0165  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:118:0x0185
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public boolean matches(java.text.CharacterIterator r11, org.apache.xmlbeans.impl.regex.Match r12) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.RegularExpression.matches(java.text.CharacterIterator, org.apache.xmlbeans.impl.regex.Match):boolean");
    }
}
