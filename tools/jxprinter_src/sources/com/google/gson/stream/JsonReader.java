package com.google.gson.stream;

import androidx.collection.a;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private int[] pathIndices;
    private String[] pathNames;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    int peeked = 0;
    private int stackSize = 1;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int iDoPeek = jsonReader.peeked;
                if (iDoPeek == 0) {
                    iDoPeek = jsonReader.doPeek();
                }
                if (iDoPeek == 13) {
                    jsonReader.peeked = 9;
                    return;
                }
                if (iDoPeek == 12) {
                    jsonReader.peeked = 8;
                } else {
                    if (iDoPeek == 14) {
                        jsonReader.peeked = 10;
                        return;
                    }
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i5 = this.pos;
        this.pos = i5 - 1;
        if (i5 + 4 <= this.limit || fillBuffer(5)) {
            int i6 = this.pos;
            char[] cArr = this.buffer;
            if (cArr[i6] == ')' && cArr[i6 + 1] == ']' && cArr[i6 + 2] == '}' && cArr[i6 + 3] == '\'' && cArr[i6 + 4] == '\n') {
                this.pos = i6 + 5;
            }
        }
    }

    private boolean fillBuffer(int i5) throws IOException {
        int i6;
        int i7;
        char[] cArr = this.buffer;
        int i8 = this.lineStart;
        int i9 = this.pos;
        this.lineStart = i8 - i9;
        int i10 = this.limit;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.limit = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i12 = this.limit;
            int i13 = reader.read(cArr, i12, cArr.length - i12);
            if (i13 == -1) {
                return false;
            }
            i6 = this.limit + i13;
            this.limit = i6;
            if (this.lineNumber == 0 && (i7 = this.lineStart) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i7 + 1;
                i5++;
            }
        } while (i6 < i5);
        return true;
    }

    private String getPath(boolean z6) {
        StringBuilder sb = new StringBuilder("$");
        int i5 = 0;
        while (true) {
            int i6 = this.stackSize;
            if (i5 >= i6) {
                return sb.toString();
            }
            int i7 = this.stack[i5];
            if (i7 == 1 || i7 == 2) {
                int i8 = this.pathIndices[i5];
                if (z6 && i8 > 0 && i5 == i6 - 1) {
                    i8--;
                }
                sb.append('[');
                sb.append(i8);
                sb.append(']');
            } else if (i7 == 3 || i7 == 4 || i7 == 5) {
                sb.append('.');
                String str = this.pathNames[i5];
                if (str != null) {
                    sb.append(str);
                }
            }
            i5++;
        }
    }

    private boolean isLiteral(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z6) throws IOException {
        char[] cArr = this.buffer;
        int i5 = this.pos;
        int i6 = this.limit;
        while (true) {
            if (i5 == i6) {
                this.pos = i5;
                if (!fillBuffer(1)) {
                    if (!z6) {
                        return -1;
                    }
                    throw new EOFException("End of input" + locationString());
                }
                i5 = this.pos;
                i6 = this.limit;
            }
            int i7 = i5 + 1;
            char c = cArr[i5];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i7;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.pos = i7;
                    if (i7 == i6) {
                        this.pos = i5;
                        boolean zFillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!zFillBuffer) {
                        }
                        return c;
                    }
                    checkLenient();
                    int i8 = this.pos;
                    char c6 = cArr[i8];
                    if (c6 == '*') {
                        this.pos = i8 + 1;
                        if (!skipTo("*/")) {
                            throw syntaxError("Unterminated comment");
                        }
                        i5 = this.pos + 2;
                        i6 = this.limit;
                    } else {
                        if (c6 != '/') {
                            return c;
                        }
                        this.pos = i8 + 1;
                        skipToEndOfLine();
                        i5 = this.pos;
                        i6 = this.limit;
                    }
                } else {
                    if (c != '#') {
                        this.pos = i7;
                        return c;
                    }
                    this.pos = i7;
                    checkLenient();
                    skipToEndOfLine();
                    i5 = this.pos;
                    i6 = this.limit;
                }
            }
            i5 = i7;
        }
    }

    private String nextQuotedValue(char c) throws IOException {
        int i5;
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        do {
            int i6 = this.pos;
            int i7 = this.limit;
            while (true) {
                int i8 = i7;
                i5 = i6;
                while (true) {
                    if (i6 < i8) {
                        int i9 = i6 + 1;
                        char c6 = cArr[i6];
                        if (c6 == c) {
                            this.pos = i9;
                            int i10 = (i9 - i5) - 1;
                            if (sb == null) {
                                return new String(cArr, i5, i10);
                            }
                            sb.append(cArr, i5, i10);
                            return sb.toString();
                        }
                        if (c6 == '\\') {
                            this.pos = i9;
                            int i11 = i9 - i5;
                            int i12 = i11 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i11 * 2, 16));
                            }
                            sb.append(cArr, i5, i12);
                            sb.append(readEscapeCharacter());
                            i6 = this.pos;
                            i7 = this.limit;
                        } else {
                            if (c6 == '\n') {
                                this.lineNumber++;
                                this.lineStart = i9;
                            }
                            i6 = i9;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i6 - i5) * 2, 16));
            }
            sb.append(cArr, i5, i6 - i5);
            this.pos = i6;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String nextUnquotedValue() throws IOException {
        String string;
        StringBuilder sb = null;
        int i5 = 0;
        while (true) {
            int i6 = 0;
            while (true) {
                int i7 = this.pos;
                if (i7 + i6 < this.limit) {
                    char c = this.buffer[i7 + i6];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i6++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    i5 = i6;
                } else if (i6 >= this.buffer.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i6, 16));
                    }
                    sb.append(this.buffer, this.pos, i6);
                    this.pos += i6;
                    if (!fillBuffer(1)) {
                    }
                } else if (!fillBuffer(i6 + 1)) {
                    i5 = i6;
                }
                if (sb == null) {
                    string = new String(this.buffer, this.pos, i5);
                } else {
                    sb.append(this.buffer, this.pos, i5);
                    string = sb.toString();
                }
                this.pos += i5;
                return string;
            }
        }
    }

    private int peekKeyword() {
        String str;
        String str2;
        int i5;
        char c = this.buffer[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i5 = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i5 = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = AbstractC1127c.NULL;
            str2 = "NULL";
            i5 = 7;
        }
        int length = str.length();
        for (int i6 = 1; i6 < length; i6++) {
            if (this.pos + i6 >= this.limit && !fillBuffer(i6 + 1)) {
                return 0;
            }
            char c6 = this.buffer[this.pos + i6];
            if (c6 != str.charAt(i6) && c6 != str2.charAt(i6)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i5;
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0036  */
    /* JADX WARN: Code duplicated, block: B:85:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x00da  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e1  */
    private int peekNumber() {
        char c;
        int i5;
        char[] cArr = this.buffer;
        int i6 = this.pos;
        int i7 = this.limit;
        int i8 = 0;
        int i9 = 0;
        char c6 = 0;
        boolean z6 = false;
        int i10 = 1;
        long j6 = 0;
        while (true) {
            char c7 = 2;
            if (i6 + i9 != i7) {
                c = cArr[i6 + i9];
                i5 = i8;
                if (c != '+') {
                    if (c != 'E' || c == 'e') {
                        if (c6 == 2 && c6 != 4) {
                            return i5;
                        }
                        c6 = 5;
                    } else if (c == '-') {
                        c7 = 6;
                        if (c6 == 0) {
                            c6 = 1;
                            z6 = true;
                        } else if (c6 != 5) {
                            return i5;
                        }
                    } else if (c != '.') {
                        if (c < '0' || c > '9') {
                            if (!isLiteral(c)) {
                                break;
                            }
                            return i5;
                        }
                        if (c6 == 1 || c6 == 0) {
                            j6 = -(c - '0');
                        } else if (c6 == 2) {
                            if (j6 == 0) {
                                return i5;
                            }
                            long j7 = (10 * j6) - ((long) (c - '0'));
                            i10 &= (j6 > MIN_INCOMPLETE_INTEGER || (j6 == MIN_INCOMPLETE_INTEGER && j7 < j6)) ? 1 : i5;
                            j6 = j7;
                        } else if (c6 == 3) {
                            c6 = 4;
                        } else if (c6 == 5 || c6 == 6) {
                            c6 = 7;
                        }
                    } else {
                        if (c6 != 2) {
                            return i5;
                        }
                        c6 = 3;
                    }
                    i9++;
                    i8 = i5;
                } else {
                    c7 = 6;
                    if (c6 != 5) {
                        return i5;
                    }
                }
                c6 = c7;
                i9++;
                i8 = i5;
            } else {
                if (i9 == cArr.length) {
                    return i8;
                }
                if (!fillBuffer(i9 + 1)) {
                    i5 = i8;
                    break;
                }
                i6 = this.pos;
                i7 = this.limit;
                c = cArr[i6 + i9];
                i5 = i8;
                if (c != '+') {
                    if (c != 'E') {
                        if (c6 == 2) {
                        }
                        c6 = 5;
                    } else {
                        if (c6 == 2) {
                        }
                        c6 = 5;
                    }
                    i9++;
                    i8 = i5;
                } else {
                    c7 = 6;
                    if (c6 != 5) {
                        return i5;
                    }
                }
                c6 = c7;
                i9++;
                i8 = i5;
            }
        }
        if (c6 == 2 && i10 != 0 && ((j6 != Long.MIN_VALUE || z6) && (j6 != 0 || !z6))) {
            if (!z6) {
                j6 = -j6;
            }
            this.peekedLong = j6;
            this.pos += i9;
            this.peeked = 15;
            return 15;
        }
        if (c6 != 2 && c6 != 4 && c6 != 7) {
            return i5;
        }
        this.peekedNumberLength = i9;
        this.peeked = 16;
        return 16;
    }

    private void push(int i5) {
        int i6 = this.stackSize;
        int[] iArr = this.stack;
        if (i6 == iArr.length) {
            int i7 = i6 * 2;
            this.stack = Arrays.copyOf(iArr, i7);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i7);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i7);
        }
        int[] iArr2 = this.stack;
        int i8 = this.stackSize;
        this.stackSize = i8 + 1;
        iArr2[i8] = i5;
    }

    private char readEscapeCharacter() throws IOException {
        int i5;
        if (this.pos == this.limit && !fillBuffer(1)) {
            throw syntaxError("Unterminated escape sequence");
        }
        char[] cArr = this.buffer;
        int i6 = this.pos;
        int i7 = i6 + 1;
        this.pos = i7;
        char c = cArr[i6];
        if (c == '\n') {
            this.lineNumber++;
            this.lineStart = i7;
            return c;
        }
        if (c == '\"' || c == '\'' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return '\b';
        }
        if (c == 'f') {
            return '\f';
        }
        if (c == 'n') {
            return '\n';
        }
        if (c == 'r') {
            return Chars.CR;
        }
        if (c == 't') {
            return '\t';
        }
        if (c != 'u') {
            throw syntaxError("Invalid escape sequence");
        }
        if (i6 + 5 > this.limit && !fillBuffer(4)) {
            throw syntaxError("Unterminated escape sequence");
        }
        int i8 = this.pos;
        int i9 = i8 + 4;
        char c6 = 0;
        while (i8 < i9) {
            char c7 = this.buffer[i8];
            char c8 = (char) (c6 << 4);
            if (c7 >= '0' && c7 <= '9') {
                i5 = c7 - '0';
            } else if (c7 >= 'a' && c7 <= 'f') {
                i5 = c7 - 'W';
            } else {
                if (c7 < 'A' || c7 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(this.buffer, this.pos, 4)));
                }
                i5 = c7 - '7';
            }
            c6 = (char) (i5 + c8);
            i8++;
        }
        this.pos += 4;
        return c6;
    }

    private void skipQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i5 = this.pos;
            int i6 = this.limit;
            while (i5 < i6) {
                int i7 = i5 + 1;
                char c6 = cArr[i5];
                if (c6 == c) {
                    this.pos = i7;
                    return;
                }
                if (c6 == '\\') {
                    this.pos = i7;
                    readEscapeCharacter();
                    i5 = this.pos;
                    i6 = this.limit;
                } else {
                    if (c6 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i7;
                    }
                    i5 = i7;
                }
            }
            this.pos = i5;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i5 = this.pos;
            if (cArr[i5] != '\n') {
                for (int i6 = 0; i6 < length; i6++) {
                    if (this.buffer[this.pos + i6] == str.charAt(i6)) {
                    }
                }
                return true;
            }
            this.lineNumber++;
            this.lineStart = i5 + 1;
            this.pos++;
        }
    }

    private void skipToEndOfLine() {
        char c;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i5 = this.pos;
            int i6 = i5 + 1;
            this.pos = i6;
            c = cArr[i5];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i6;
                return;
            }
        } while (c != '\r');
    }

    private void skipUnquotedValue() throws IOException {
        do {
            int i5 = 0;
            while (true) {
                int i6 = this.pos;
                if (i6 + i5 < this.limit) {
                    char c = this.buffer[i6 + i5];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i5++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        checkLenient();
                    }
                    this.pos += i5;
                    return;
                }
                this.pos = i6 + i5;
            }
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws MalformedJsonException {
        StringBuilder sbR = a.r(str);
        sbR.append(locationString());
        throw new MalformedJsonException(sbR.toString());
    }

    public void beginArray() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
        }
    }

    public void beginObject() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 1) {
            push(3);
            this.peeked = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int iNextNonWhitespace;
        int[] iArr = this.stack;
        int i5 = this.stackSize;
        int i6 = iArr[i5 - 1];
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
        } else if (i6 == 2) {
            int iNextNonWhitespace2 = nextNonWhitespace(true);
            if (iNextNonWhitespace2 != 44) {
                if (iNextNonWhitespace2 != 59) {
                    if (iNextNonWhitespace2 != 93) {
                        throw syntaxError("Unterminated array");
                    }
                    this.peeked = 4;
                    return 4;
                }
                checkLenient();
            }
        } else {
            if (i6 == 3 || i6 == 5) {
                iArr[i5 - 1] = 4;
                if (i6 == 5 && (iNextNonWhitespace = nextNonWhitespace(true)) != 44) {
                    if (iNextNonWhitespace != 59) {
                        if (iNextNonWhitespace != 125) {
                            throw syntaxError("Unterminated object");
                        }
                        this.peeked = 2;
                        return 2;
                    }
                    checkLenient();
                }
                int iNextNonWhitespace3 = nextNonWhitespace(true);
                if (iNextNonWhitespace3 == 34) {
                    this.peeked = 13;
                    return 13;
                }
                if (iNextNonWhitespace3 == 39) {
                    checkLenient();
                    this.peeked = 12;
                    return 12;
                }
                if (iNextNonWhitespace3 == 125) {
                    if (i6 == 5) {
                        throw syntaxError("Expected name");
                    }
                    this.peeked = 2;
                    return 2;
                }
                checkLenient();
                this.pos--;
                if (!isLiteral((char) iNextNonWhitespace3)) {
                    throw syntaxError("Expected name");
                }
                this.peeked = 14;
                return 14;
            }
            if (i6 == 4) {
                iArr[i5 - 1] = 5;
                int iNextNonWhitespace4 = nextNonWhitespace(true);
                if (iNextNonWhitespace4 != 58) {
                    if (iNextNonWhitespace4 != 61) {
                        throw syntaxError("Expected ':'");
                    }
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i7 = this.pos;
                        if (cArr[i7] == '>') {
                            this.pos = i7 + 1;
                        }
                    }
                }
            } else if (i6 == 6) {
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = 7;
            } else if (i6 == 7) {
                if (nextNonWhitespace(false) == -1) {
                    this.peeked = 17;
                    return 17;
                }
                checkLenient();
                this.pos--;
            } else if (i6 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iNextNonWhitespace5 = nextNonWhitespace(true);
        if (iNextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        }
        if (iNextNonWhitespace5 == 39) {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
        if (iNextNonWhitespace5 != 44 && iNextNonWhitespace5 != 59) {
            if (iNextNonWhitespace5 == 91) {
                this.peeked = 3;
                return 3;
            }
            if (iNextNonWhitespace5 != 93) {
                if (iNextNonWhitespace5 == 123) {
                    this.peeked = 1;
                    return 1;
                }
                this.pos--;
                int iPeekKeyword = peekKeyword();
                if (iPeekKeyword != 0) {
                    return iPeekKeyword;
                }
                int iPeekNumber = peekNumber();
                if (iPeekNumber != 0) {
                    return iPeekNumber;
                }
                if (!isLiteral(this.buffer[this.pos])) {
                    throw syntaxError("Expected value");
                }
                checkLenient();
                this.peeked = 10;
                return 10;
            }
            if (i6 == 1) {
                this.peeked = 4;
                return 4;
            }
        }
        if (i6 != 1 && i6 != 2) {
            throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    }

    public void endArray() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
        }
        int i5 = this.stackSize;
        this.stackSize = i5 - 1;
        int[] iArr = this.pathIndices;
        int i6 = i5 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.peeked = 0;
    }

    public void endObject() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
        }
        int i5 = this.stackSize;
        int i6 = i5 - 1;
        this.stackSize = i6;
        this.pathNames[i6] = null;
        int[] iArr = this.pathIndices;
        int i7 = i5 - 2;
        iArr[i7] = iArr[i7] + 1;
        this.peeked = 0;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public boolean hasNext() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        return (iDoPeek == 2 || iDoPeek == 4 || iDoPeek == 17) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        StringBuilder sbS = a.s(" at line ", this.lineNumber + 1, (this.pos - this.lineStart) + 1, " column ", " path ");
        sbS.append(getPath());
        return sbS.toString();
    }

    public boolean nextBoolean() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        }
        if (iDoPeek != 6) {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return false;
    }

    public double nextDouble() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (iDoPeek == 8 || iDoPeek == 9) {
            this.peekedString = nextQuotedValue(iDoPeek == 8 ? Chars.QUOTE : Chars.DQUOTE);
        } else if (iDoPeek == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (iDoPeek != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        if (!this.lenient && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr2 = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return d;
    }

    public int nextInt() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            long j6 = this.peekedLong;
            int i5 = (int) j6;
            if (j6 != i5) {
                throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr[i6] = iArr[i6] + 1;
            return i5;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iDoPeek != 8 && iDoPeek != 9 && iDoPeek != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + locationString());
            }
            if (iDoPeek == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iDoPeek == 8 ? Chars.QUOTE : Chars.DQUOTE);
            }
            try {
                int i7 = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i8 = this.stackSize - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return i7;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        int i9 = (int) d;
        if (i9 != d) {
            throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i10 = this.stackSize - 1;
        iArr3[i10] = iArr3[i10] + 1;
        return i9;
    }

    public long nextLong() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i5 = this.stackSize - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.peekedLong;
        }
        if (iDoPeek == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            if (iDoPeek != 8 && iDoPeek != 9 && iDoPeek != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + locationString());
            }
            if (iDoPeek == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(iDoPeek == 8 ? Chars.QUOTE : Chars.DQUOTE);
            }
            try {
                long j6 = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i6 = this.stackSize - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return j6;
            } catch (NumberFormatException unused) {
            }
        }
        this.peeked = 11;
        double d = Double.parseDouble(this.peekedString);
        long j7 = (long) d;
        if (j7 != d) {
            throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
        }
        this.peekedString = null;
        this.peeked = 0;
        int[] iArr3 = this.pathIndices;
        int i7 = this.stackSize - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return j7;
    }

    public String nextName() throws IOException {
        String strNextQuotedValue;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 14) {
            strNextQuotedValue = nextUnquotedValue();
        } else if (iDoPeek == 12) {
            strNextQuotedValue = nextQuotedValue(Chars.QUOTE);
        } else {
            if (iDoPeek != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + locationString());
            }
            strNextQuotedValue = nextQuotedValue(Chars.DQUOTE);
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = strNextQuotedValue;
        return strNextQuotedValue;
    }

    public void nextNull() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek != 7) {
            throw new IllegalStateException("Expected null but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i5 = this.stackSize - 1;
        iArr[i5] = iArr[i5] + 1;
    }

    public String nextString() throws IOException {
        String str;
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        if (iDoPeek == 10) {
            str = nextUnquotedValue();
        } else if (iDoPeek == 8) {
            str = nextQuotedValue(Chars.QUOTE);
        } else if (iDoPeek == 9) {
            str = nextQuotedValue(Chars.DQUOTE);
        } else if (iDoPeek == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (iDoPeek == 15) {
            str = Long.toString(this.peekedLong);
        } else {
            if (iDoPeek != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + locationString());
            }
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i5 = this.stackSize - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int iDoPeek = this.peeked;
        if (iDoPeek == 0) {
            iDoPeek = doPeek();
        }
        switch (iDoPeek) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z6) {
        this.lenient = z6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void skipValue() throws IOException {
        int i5 = 0;
        do {
            int iDoPeek = this.peeked;
            if (iDoPeek == 0) {
                iDoPeek = doPeek();
            }
            switch (iDoPeek) {
                case 1:
                    push(3);
                    i5++;
                    this.peeked = 0;
                    break;
                case 2:
                    if (i5 == 0) {
                        this.pathNames[this.stackSize - 1] = null;
                    }
                    this.stackSize--;
                    i5--;
                    this.peeked = 0;
                    break;
                case 3:
                    push(1);
                    i5++;
                    this.peeked = 0;
                    break;
                case 4:
                    this.stackSize--;
                    i5--;
                    this.peeked = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.peeked = 0;
                    break;
                case 8:
                    skipQuotedValue(Chars.QUOTE);
                    this.peeked = 0;
                    break;
                case 9:
                    skipQuotedValue(Chars.DQUOTE);
                    this.peeked = 0;
                    break;
                case 10:
                    skipUnquotedValue();
                    this.peeked = 0;
                    break;
                case 12:
                    skipQuotedValue(Chars.QUOTE);
                    if (i5 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 13:
                    skipQuotedValue(Chars.DQUOTE);
                    if (i5 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 14:
                    skipUnquotedValue();
                    if (i5 == 0) {
                        this.pathNames[this.stackSize - 1] = "<skipped>";
                    }
                    this.peeked = 0;
                    break;
                case 16:
                    this.pos += this.peekedNumberLength;
                    this.peeked = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i5 > 0);
        int[] iArr = this.pathIndices;
        int i6 = this.stackSize - 1;
        iArr[i6] = iArr[i6] + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
