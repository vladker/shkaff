package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class CharUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CHARUTIL_INITIAL_BUFSIZE = 32768;
    private static final int MAX_COPY = 64;
    private static final ThreadLocal<SoftReference<CharUtil>> tl_charUtil = ThreadLocal.withInitial(new C1440a(0));
    public int _cchSrc;
    private final int _charBufSize;
    private final CharIterator _charIter = new CharIterator();
    private char[] _currentBuffer;
    private int _currentOffset;
    public int _offSrc;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CharIterator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _cchRoot;
        private int _maxPos;
        private int _minPos;
        private int _offLeaf;
        private int _offRoot;
        private int _pos;
        private char[] _srcLeafChars;
        private String _srcLeafString;
        private Object _srcRoot;

        private char currentChar() {
            int i5 = (this._offLeaf + this._pos) - this._minPos;
            char[] cArr = this._srcLeafChars;
            return cArr == null ? this._srcLeafString.charAt(i5) : cArr[i5];
        }

        public boolean hasNext() {
            return this._pos < this._cchRoot;
        }

        public boolean hasPrev() {
            return this._pos > 0;
        }

        public void init(Object obj, int i5, int i6) {
            init(obj, i5, i6, 0);
        }

        public void movePos(int i5) {
            if (i5 < this._minPos || i5 > this._maxPos) {
                Object obj = this._srcRoot;
                int i6 = this._offRoot;
                int i7 = i6 + i5;
                int i8 = this._cchRoot;
                this._offLeaf = i6;
                while (obj instanceof CharJoin) {
                    CharJoin charJoin = (CharJoin) obj;
                    int i9 = charJoin._cchLeft;
                    if (i7 < i9) {
                        Object obj2 = charJoin._srcLeft;
                        int i10 = charJoin._offLeft;
                        this._offLeaf = i10;
                        i7 += i10;
                        obj = obj2;
                        i8 = i9;
                    } else {
                        Object obj3 = charJoin._srcRight;
                        int i11 = charJoin._offRight;
                        this._offLeaf = i11;
                        i7 -= i9 - i11;
                        i8 -= i9;
                        obj = obj3;
                    }
                }
                int i12 = i5 - (i7 - this._offLeaf);
                this._minPos = i12;
                int i13 = i12 + i8;
                this._maxPos = i13;
                if (i5 < this._cchRoot) {
                    this._maxPos = i13 - 1;
                }
                this._srcLeafChars = null;
                this._srcLeafString = null;
                if (obj instanceof char[]) {
                    this._srcLeafChars = (char[]) obj;
                } else {
                    this._srcLeafString = (String) obj;
                }
            }
            this._pos = i5;
        }

        public char next() {
            char cCurrentChar = currentChar();
            movePos(this._pos + 1);
            return cCurrentChar;
        }

        public char prev() {
            movePos(this._pos - 1);
            return currentChar();
        }

        public void release() {
            this._srcRoot = null;
            this._srcLeafString = null;
            this._srcLeafChars = null;
        }

        public void init(Object obj, int i5, int i6, int i7) {
            release();
            this._srcRoot = obj;
            this._offRoot = i5;
            this._cchRoot = i6;
            this._maxPos = -1;
            this._minPos = -1;
            movePos(i7);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CharJoin {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MAX_DEPTH = 64;
        public final int _cchLeft;
        public final int _depth;
        public final int _offLeft;
        public final int _offRight;
        public final Object _srcLeft;
        public final Object _srcRight;

        public CharJoin(Object obj, int i5, int i6, Object obj2, int i7) {
            int i8;
            this._srcLeft = obj;
            this._offLeft = i5;
            this._cchLeft = i6;
            this._srcRight = obj2;
            this._offRight = i7;
            int i9 = obj instanceof CharJoin ? ((CharJoin) obj)._depth : 0;
            if ((obj2 instanceof CharJoin) && (i8 = ((CharJoin) obj2)._depth) > i9) {
                i9 = i8;
            }
            this._depth = i9 + 1;
        }

        private int cchRight(int i5, int i6) {
            return Math.max(0, (i6 - this._cchLeft) - i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dumpChars(PrintStream printStream, int i5, int i6) {
            printStream.print("( ");
            CharUtil.dumpChars(printStream, this._srcLeft, this._offLeft, this._cchLeft);
            printStream.print(", ");
            CharUtil.dumpChars(printStream, this._srcRight, this._offRight, cchRight(i5, i6));
            printStream.print(" )");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getChars(char[] cArr, int i5, int i6, int i7) {
            int i8 = this._cchLeft;
            if (i6 >= i8) {
                CharUtil.getChars(cArr, i5, this._srcRight, (this._offRight + i6) - i8, i7);
                return;
            }
            int iMin = Math.min(i8 - i6, i7);
            CharUtil.getChars(cArr, i5, this._srcLeft, this._offLeft + i6, iMin);
            if (i7 > iMin) {
                CharUtil.getChars(cArr, i5 + iMin, this._srcRight, this._offRight, i7 - iMin);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getString(StringBuffer stringBuffer, int i5, int i6) {
            int i7 = this._cchLeft;
            if (i5 >= i7) {
                CharUtil.getString(stringBuffer, this._srcRight, (this._offRight + i5) - i7, i6);
                return;
            }
            int iMin = Math.min(i7 - i5, i6);
            CharUtil.getString(stringBuffer, this._srcLeft, this._offLeft + i5, iMin);
            if (i6 > iMin) {
                CharUtil.getString(stringBuffer, this._srcRight, this._offRight, i6 - iMin);
            }
        }

        public int depth() {
            Object obj = this._srcLeft;
            int iDepth = obj instanceof CharJoin ? ((CharJoin) obj).depth() : 0;
            Object obj2 = this._srcRight;
            if (obj2 instanceof CharJoin) {
                iDepth = Math.max(((CharJoin) obj2).depth(), iDepth);
            }
            return iDepth + 1;
        }

        public boolean isValid(int i5, int i6) {
            if (this._depth > 2) {
                return true;
            }
            if (i5 < 0 || i6 < 0 || !CharUtil.isValid(this._srcLeft, this._offLeft, this._cchLeft)) {
                return false;
            }
            return CharUtil.isValid(this._srcRight, this._offRight, cchRight(i5, i6));
        }
    }

    public CharUtil(int i5) {
        this._charBufSize = i5;
    }

    private char[] allocate(int i5) {
        if (this._currentBuffer == null) {
            this._currentBuffer = new char[Math.max(i5, this._charBufSize)];
            this._currentOffset = 0;
        }
        int i6 = this._currentOffset;
        this._offSrc = i6;
        int iMin = Math.min(this._currentBuffer.length - i6, i5);
        this._cchSrc = iMin;
        char[] cArr = this._currentBuffer;
        int i7 = this._currentOffset + iMin;
        this._currentOffset = i7;
        if (i7 == cArr.length) {
            this._currentBuffer = null;
            this._currentOffset = 0;
        }
        return cArr;
    }

    private boolean canAllocate(int i5) {
        char[] cArr = this._currentBuffer;
        return cArr == null || cArr.length - this._currentOffset >= i5;
    }

    public static void clearThreadLocals() {
        tl_charUtil.remove();
    }

    public static void dump(Object obj, int i5, int i6) {
        dumpChars(System.out, obj, i5, i6);
        System.out.println();
    }

    public static void dumpChars(PrintStream printStream, Object obj, int i5, int i6) {
        int i7;
        int i8;
        printStream.print(androidx.collection.a.m("off=", i5, i6, ", cch=", ", "));
        if (obj == null) {
            printStream.print("<null-src>");
            return;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            printStream.print("String");
            if (!(i5 == 0 && i6 == str.length()) && (i5 < 0 || i5 > str.length() || (i8 = i5 + i6) < 0 || i8 > str.length())) {
                printStream.print(" (Error)");
                return;
            } else {
                dumpText(printStream, str.substring(i5, i6 + i5));
                return;
            }
        }
        if (!(obj instanceof char[])) {
            if (!(obj instanceof CharJoin)) {
                printStream.print("Unknown text source");
                return;
            } else {
                printStream.print("CharJoin");
                ((CharJoin) obj).dumpChars(printStream, i5, i6);
                return;
            }
        }
        char[] cArr = (char[]) obj;
        printStream.print("char[]");
        if (!(i5 == 0 && i6 == cArr.length) && (i5 < 0 || i5 > cArr.length || (i7 = i5 + i6) < 0 || i7 > cArr.length)) {
            printStream.print(" (Error)");
        } else {
            dumpText(printStream, new String(cArr, i5, i6));
        }
    }

    private static void dumpText(PrintStream printStream, String str) {
        printStream.print("\"");
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (i5 == 36) {
                printStream.print("...");
                break;
            }
            if (cCharAt == '\t') {
                printStream.print("\\t");
            } else if (cCharAt == '\n') {
                printStream.print("\\n");
            } else if (cCharAt == '\f') {
                printStream.print("\\f");
            } else if (cCharAt == '\r') {
                printStream.print("\\r");
            } else if (cCharAt != '\"') {
                printStream.print(cCharAt);
            } else {
                printStream.print("\\\"");
            }
        }
        printStream.print("\"");
    }

    public static void getChars(char[] cArr, int i5, Object obj, int i6, int i7) {
        if (i7 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            System.arraycopy((char[]) obj, i6, cArr, i5, i7);
        } else if (obj instanceof String) {
            ((String) obj).getChars(i6, i7 + i6, cArr, i5);
        } else {
            ((CharJoin) obj).getChars(cArr, i5, i6, i7);
        }
    }

    public static void getString(StringBuffer stringBuffer, Object obj, int i5, int i6) {
        if (i6 == 0) {
            return;
        }
        if (obj instanceof char[]) {
            stringBuffer.append((char[]) obj, i5, i6);
            return;
        }
        if (!(obj instanceof String)) {
            ((CharJoin) obj).getString(stringBuffer, i5, i6);
            return;
        }
        String str = (String) obj;
        if (i5 == 0 && i6 == str.length()) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append((CharSequence) str, i5, i6 + i5);
        }
    }

    public static CharUtil getThreadLocalCharUtil() {
        ThreadLocal<SoftReference<CharUtil>> threadLocal = tl_charUtil;
        CharUtil charUtil = threadLocal.get().get();
        if (charUtil != null) {
            return charUtil;
        }
        CharUtil charUtil2 = new CharUtil(32768);
        threadLocal.set(new SoftReference<>(charUtil2));
        return charUtil2;
    }

    public static boolean isValid(Object obj, int i5, int i6) {
        if (i6 >= 0 && i5 >= 0) {
            if (obj == null) {
                return i5 == 0 && i6 == 0;
            }
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                return i5 <= cArr.length && i5 + i6 <= cArr.length;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                return i5 <= str.length() && i5 + i6 <= str.length();
            }
            if (obj instanceof CharJoin) {
                return ((CharJoin) obj).isValid(i5, i6);
            }
        }
        return false;
    }

    public static boolean isWhiteSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SoftReference lambda$static$0() {
        return new SoftReference(new CharUtil(32768));
    }

    public CharIterator getCharIterator(Object obj, int i5, int i6) {
        this._charIter.init(obj, i5, i6);
        return this._charIter;
    }

    public Object insertChars(int i5, Object obj, int i6, int i7, Object obj2, int i8, int i9) {
        CharJoin charJoin;
        if (i9 == 0) {
            this._cchSrc = i7;
            this._offSrc = i6;
            return obj;
        }
        if (i7 == 0) {
            this._cchSrc = i9;
            this._offSrc = i8;
            return obj2;
        }
        int i10 = i7 + i9;
        this._cchSrc = i10;
        if (i10 > 64 || !canAllocate(i10)) {
            this._offSrc = 0;
            if (i5 == 0) {
                charJoin = new CharJoin(obj2, i8, i9, obj, i6);
            } else {
                charJoin = i5 == i7 ? new CharJoin(obj, i6, i7, obj2, i8) : new CharJoin(new CharJoin(obj, i6, i5, obj2, i8), 0, i5 + i9, obj, i6 + i5);
            }
            return charJoin._depth > 64 ? saveChars(charJoin, this._offSrc, this._cchSrc) : charJoin;
        }
        char[] cArrAllocate = allocate(this._cchSrc);
        getChars(cArrAllocate, this._offSrc, obj, i6, i5);
        getChars(cArrAllocate, this._offSrc + i5, obj2, i8, i9);
        getChars(cArrAllocate, this._offSrc + i5 + i9, obj, i6 + i5, i7 - i5);
        return cArrAllocate;
    }

    public Object removeChars(int i5, int i6, Object obj, int i7, int i8) {
        int i9 = i8 - i6;
        this._cchSrc = i9;
        if (i9 == 0) {
            this._offSrc = 0;
            return null;
        }
        if (i5 == 0) {
            this._offSrc = i7 + i6;
            return obj;
        }
        if (i5 + i6 == i8) {
            this._offSrc = i7;
            return obj;
        }
        if (i9 <= 64 && canAllocate(i9)) {
            char[] cArrAllocate = allocate(i9);
            getChars(cArrAllocate, this._offSrc, obj, i7, i5);
            getChars(cArrAllocate, this._offSrc + i5, obj, i7 + i5 + i6, (i8 - i5) - i6);
            return cArrAllocate;
        }
        CharJoin charJoin = new CharJoin(obj, i7, i5, obj, i7 + i5 + i6);
        if (charJoin._depth > 64) {
            return saveChars(charJoin, 0, this._cchSrc);
        }
        this._offSrc = 0;
        return charJoin;
    }

    public Object saveChars(Object obj, int i5, int i6) {
        return saveChars(obj, i5, i6, null, 0, 0);
    }

    public Object stripLeft(Object obj, int i5, int i6) {
        if (i6 > 0) {
            if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                while (i6 > 0 && isWhiteSpace(cArr[i5])) {
                    i6--;
                    i5++;
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                while (i6 > 0 && isWhiteSpace(str.charAt(i5))) {
                    i6--;
                    i5++;
                }
            } else {
                this._charIter.init(obj, i5, i6);
                int i7 = 0;
                while (this._charIter.hasNext() && isWhiteSpace(this._charIter.next())) {
                    i7++;
                }
                this._charIter.release();
                i5 += i7;
            }
        }
        if (i6 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i5;
        this._cchSrc = i6;
        return obj;
    }

    public Object stripRight(Object obj, int i5, int i6) {
        if (i6 > 0) {
            this._charIter.init(obj, i5, i6, i6);
            while (this._charIter.hasPrev() && isWhiteSpace(this._charIter.prev())) {
                i6--;
            }
            this._charIter.release();
        }
        if (i6 == 0) {
            this._offSrc = 0;
            this._cchSrc = 0;
            return null;
        }
        this._offSrc = i5;
        this._cchSrc = i6;
        return obj;
    }

    public final boolean isWhiteSpace(Object obj, int i5, int i6) {
        boolean z6 = true;
        if (i6 <= 0) {
            return true;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            while (i6 > 0) {
                int i7 = i5 + 1;
                if (!isWhiteSpace(cArr[i5])) {
                    return false;
                }
                i6--;
                i5 = i7;
            }
            return true;
        }
        if (!(obj instanceof String)) {
            this._charIter.init(obj, i5, i6);
            while (this._charIter.hasNext()) {
                if (!isWhiteSpace(this._charIter.next())) {
                    z6 = false;
                    break;
                }
            }
            this._charIter.release();
            return z6;
        }
        String str = (String) obj;
        while (i6 > 0) {
            int i8 = i5 + 1;
            if (!isWhiteSpace(str.charAt(i5))) {
                return false;
            }
            i6--;
            i5 = i8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Multi-variable type inference failed */
    public Object saveChars(Object obj, int i5, int i6, Object obj2, int i7, int i8) {
        int i9;
        Object objSaveChars;
        Object obj3;
        Object objSaveChars2;
        char[] cArrAllocate = allocate(i6);
        int i10 = this._offSrc;
        int i11 = this._cchSrc;
        getChars(cArrAllocate, i10, obj, i5, i11);
        int i12 = i11 + i8;
        int i13 = 0;
        if (i8 == 0) {
            objSaveChars = cArrAllocate;
            i9 = i10;
        } else if (obj2 == cArrAllocate && i7 + i8 == i10) {
            i9 = i7;
            objSaveChars = obj2;
        } else {
            if (obj2 instanceof CharJoin) {
                CharJoin charJoin = (CharJoin) obj2;
                if (charJoin._srcRight == cArrAllocate && ((i7 + i8) - charJoin._cchLeft) + charJoin._offRight == i10) {
                    i9 = i7;
                    objSaveChars = obj2;
                }
            }
            CharJoin charJoin2 = new CharJoin(obj2, i7, i8, cArrAllocate, i10);
            i9 = 0;
            objSaveChars = charJoin2._depth > 64 ? saveChars(charJoin2, 0, i12) : charJoin2;
        }
        int i14 = i6 - i11;
        if (i14 > 0) {
            Object obj4 = objSaveChars;
            char[] cArrAllocate2 = allocate(i14);
            int i15 = this._offSrc;
            getChars(cArrAllocate2, i15, obj, (i6 - i14) + i5, i14);
            CharJoin charJoin3 = new CharJoin(obj4, i9, i12, cArrAllocate2, i15);
            i12 += i14;
            if (charJoin3._depth > 64) {
                objSaveChars2 = charJoin3;
                objSaveChars2 = saveChars(charJoin3, 0, i12);
            }
            objSaveChars2 = charJoin3;
            obj3 = objSaveChars2;
        } else {
            i13 = i9;
            obj3 = objSaveChars;
        }
        this._offSrc = i13;
        this._cchSrc = i12;
        return obj3;
    }

    public CharIterator getCharIterator(Object obj, int i5, int i6, int i7) {
        this._charIter.init(obj, i5, i6, i7);
        return this._charIter;
    }

    public static String getString(Object obj, int i5, int i6) {
        if (i6 == 0) {
            return "";
        }
        if (obj instanceof char[]) {
            return new String((char[]) obj, i5, i6);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (i5 == 0 && i6 == str.length()) ? str : str.substring(i5, i6 + i5);
        }
        StringBuffer stringBuffer = new StringBuffer();
        ((CharJoin) obj).getString(stringBuffer, i5, i6);
        return stringBuffer.toString();
    }
}
