package org.apache.xmlbeans.impl.regex;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class RegexParser {
    private static final String BUNDLE_PKG = "org.apache.xmlbeans.impl.regex.message";
    protected static final int S_INBRACKETS = 1;
    protected static final int S_INXBRACKETS = 2;
    protected static final int S_NORMAL = 0;
    static final int T_BACKSOLIDUS = 10;
    static final int T_CARET = 11;
    static final int T_CHAR = 0;
    static final int T_COMMENT = 21;
    static final int T_CONDITION = 23;
    static final int T_DOLLAR = 12;
    static final int T_DOT = 8;
    static final int T_EOF = 1;
    static final int T_INDEPENDENT = 18;
    static final int T_LBRACKET = 9;
    static final int T_LOOKAHEAD = 14;
    static final int T_LOOKBEHIND = 16;
    static final int T_LPAREN = 6;
    static final int T_LPAREN2 = 13;
    static final int T_MODIFIERS = 22;
    static final int T_NEGATIVELOOKAHEAD = 15;
    static final int T_NEGATIVELOOKBEHIND = 17;
    static final int T_OR = 2;
    static final int T_PLUS = 4;
    static final int T_POSIX_CHARCLASS_START = 20;
    static final int T_QUESTION = 5;
    static final int T_RPAREN = 7;
    static final int T_SET_OPERATIONS = 19;
    static final int T_STAR = 3;
    static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
    int chardata;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    String regex;
    int regexlen;
    ResourceBundle resources;
    int context = 0;
    int parennumber = 1;
    Vector references = null;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ReferencePosition {
        int position;
        int refNumber;

        public ReferencePosition(int i5, int i6) {
            this.refNumber = i5;
            this.position = i6;
        }
    }

    public RegexParser() {
        setLocale(Locale.getDefault());
    }

    private static final int hexChar(int i5) {
        if (i5 < 48 || i5 > 102) {
            return -1;
        }
        if (i5 <= 57) {
            return i5 - 48;
        }
        if (i5 < 65) {
            return -1;
        }
        if (i5 <= 70) {
            return i5 - 55;
        }
        if (i5 < 97) {
            return -1;
        }
        return i5 - 87;
    }

    private boolean isSet(int i5) {
        return (this.options & i5) == i5;
    }

    public boolean checkQuestion(int i5) {
        return i5 < this.regexlen && this.regex.charAt(i5) == '?';
    }

    public int decodeEscaped() {
        int iHexChar;
        int iHexChar2;
        int iHexChar3;
        int iHexChar4;
        int iHexChar5;
        int iHexChar6;
        int iHexChar7;
        int iHexChar8;
        int iHexChar9;
        int iHexChar10;
        int iHexChar11;
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i5 = this.chardata;
        if (i5 != 65 && i5 != 90) {
            if (i5 == 110) {
                return 10;
            }
            if (i5 == 114) {
                return 13;
            }
            if (i5 == 120) {
                next();
                if (read() != 0) {
                    throw ex("parser.descape.1", this.offset - 1);
                }
                if (this.chardata == 123) {
                    int i6 = 0;
                    while (true) {
                        next();
                        if (read() != 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int iHexChar12 = hexChar(this.chardata);
                        if (iHexChar12 < 0) {
                            if (this.chardata != 125) {
                                throw ex("parser.descape.3", this.offset - 1);
                            }
                            if (i6 <= 1114111) {
                                return i6;
                            }
                            throw ex("parser.descape.4", this.offset - 1);
                        }
                        int i7 = i6 * 16;
                        if (i6 > i7) {
                            throw ex("parser.descape.2", this.offset - 1);
                        }
                        i6 = i7 + iHexChar12;
                    }
                } else {
                    if (read() != 0 || (iHexChar = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                    next();
                    if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                        throw ex("parser.descape.1", this.offset - 1);
                    }
                }
            } else if (i5 != 122) {
                if (i5 == 101) {
                    return 27;
                }
                if (i5 == 102) {
                    return 12;
                }
                switch (i5) {
                    case 116:
                        return 9;
                    case 117:
                        next();
                        if (read() != 0 || (iHexChar3 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar4 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i8 = (iHexChar3 * 16) + iHexChar4;
                        next();
                        if (read() != 0 || (iHexChar5 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        iHexChar = (i8 * 16) + iHexChar5;
                        next();
                        if (read() != 0 || (iHexChar2 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        break;
                    case 118:
                        next();
                        if (read() != 0 || (iHexChar6 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        next();
                        if (read() != 0 || (iHexChar7 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i9 = (iHexChar6 * 16) + iHexChar7;
                        next();
                        if (read() != 0 || (iHexChar8 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i10 = (i9 * 16) + iHexChar8;
                        next();
                        if (read() != 0 || (iHexChar9 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i11 = (i10 * 16) + iHexChar9;
                        next();
                        if (read() != 0 || (iHexChar10 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i12 = (i11 * 16) + iHexChar10;
                        next();
                        if (read() != 0 || (iHexChar11 = hexChar(this.chardata)) < 0) {
                            throw ex("parser.descape.1", this.offset - 1);
                        }
                        int i13 = (i12 * 16) + iHexChar11;
                        if (i13 <= 1114111) {
                            return i13;
                        }
                        throw ex("parser.descappe.4", this.offset - 1);
                    default:
                        return i5;
                }
            }
            return (iHexChar * 16) + iHexChar2;
        }
        throw ex("parser.descape.5", this.offset - 2);
    }

    public final ParseException ex(String str, int i5) {
        return new ParseException(this.resources.getString(str), i5);
    }

    public Token getTokenForShorthand(int i5) {
        if (i5 == 68) {
            return isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9;
        }
        if (i5 == 83) {
            return isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces;
        }
        if (i5 == 87) {
            return isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars;
        }
        if (i5 == 100) {
            return isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
        }
        if (i5 == 115) {
            return isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces;
        }
        if (i5 == 119) {
            return isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars;
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i5, 16));
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0185  */
    /* JADX WARN: Code duplicated, block: B:111:0x0188  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Code duplicated, block: B:31:0x0080  */
    public final void next() {
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8 = this.offset;
        if (i8 >= this.regexlen) {
            this.chardata = -1;
            this.nexttoken = 1;
            return;
        }
        String str = this.regex;
        this.offset = i8 + 1;
        char cCharAt2 = str.charAt(i8);
        this.chardata = cCharAt2;
        int i9 = 10;
        if (this.context == 1) {
            if (cCharAt2 != '-') {
                if (cCharAt2 != '[') {
                    if (cCharAt2 != '\\') {
                        if (REUtil.isHighSurrogate(cCharAt2) && (i7 = this.offset) < this.regexlen) {
                            cCharAt = this.regex.charAt(i7);
                            if (REUtil.isLowSurrogate(cCharAt)) {
                                this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                                this.offset++;
                            }
                        }
                        i9 = 0;
                    } else {
                        int i10 = this.offset;
                        if (i10 >= this.regexlen) {
                            throw ex("parser.next.1", i10 - 1);
                        }
                        String str2 = this.regex;
                        this.offset = i10 + 1;
                        this.chardata = str2.charAt(i10);
                    }
                } else if (isSet(512) || (i6 = this.offset) >= this.regexlen || this.regex.charAt(i6) != ':') {
                    if (REUtil.isHighSurrogate(cCharAt2)) {
                        cCharAt = this.regex.charAt(i7);
                        if (REUtil.isLowSurrogate(cCharAt)) {
                            this.chardata = REUtil.composeFromSurrogates(cCharAt2, cCharAt);
                            this.offset++;
                        }
                    }
                    i9 = 0;
                } else {
                    this.offset++;
                    i9 = 20;
                }
            } else if (isSet(512) && (i5 = this.offset) < this.regexlen && this.regex.charAt(i5) == '[') {
                this.offset++;
                i9 = 24;
            } else {
                i9 = 0;
            }
            this.nexttoken = i9;
            return;
        }
        if (cCharAt2 == '$') {
            i9 = 12;
        } else if (cCharAt2 == '.') {
            i9 = 8;
        } else if (cCharAt2 == '?') {
            i9 = 5;
        } else if (cCharAt2 == '^') {
            i9 = 11;
        } else if (cCharAt2 == '|') {
            i9 = 2;
        } else if (cCharAt2 == '[') {
            i9 = 9;
        } else if (cCharAt2 != '\\') {
            i9 = 3;
            switch (cCharAt2) {
                case '(':
                    int i11 = this.offset;
                    if (i11 < this.regexlen && this.regex.charAt(i11) == '?') {
                        int i12 = this.offset;
                        int i13 = i12 + 1;
                        this.offset = i13;
                        if (i13 >= this.regexlen) {
                            throw ex("parser.next.2", i12);
                        }
                        String str3 = this.regex;
                        this.offset = i12 + 2;
                        char cCharAt3 = str3.charAt(i13);
                        if (cCharAt3 != '!') {
                            if (cCharAt3 != '#') {
                                if (cCharAt3 != ':') {
                                    if (cCharAt3 != '[') {
                                        switch (cCharAt3) {
                                            case '<':
                                                int i14 = this.offset;
                                                if (i14 >= this.regexlen) {
                                                    throw ex("parser.next.2", i14 - 3);
                                                }
                                                String str4 = this.regex;
                                                this.offset = i14 + 1;
                                                char cCharAt4 = str4.charAt(i14);
                                                if (cCharAt4 == '=') {
                                                    i9 = 16;
                                                } else {
                                                    if (cCharAt4 != '!') {
                                                        throw ex("parser.next.3", this.offset - 3);
                                                    }
                                                    i9 = 17;
                                                }
                                                break;
                                                break;
                                            case '=':
                                                i9 = 14;
                                                break;
                                            case '>':
                                                i9 = 18;
                                                break;
                                            default:
                                                if (cCharAt3 == '-' || (('a' <= cCharAt3 && cCharAt3 <= 'z') || ('A' <= cCharAt3 && cCharAt3 <= 'Z'))) {
                                                    this.offset--;
                                                    i9 = 22;
                                                } else {
                                                    if (cCharAt3 != '(') {
                                                        throw ex("parser.next.2", this.offset - 2);
                                                    }
                                                    i9 = 23;
                                                }
                                                break;
                                        }
                                    } else {
                                        i9 = 19;
                                        break;
                                    }
                                } else {
                                    i9 = 13;
                                    break;
                                }
                            } else {
                                do {
                                    int i15 = this.offset;
                                    if (i15 < this.regexlen) {
                                        String str5 = this.regex;
                                        this.offset = i15 + 1;
                                        cCharAt3 = str5.charAt(i15);
                                    }
                                    if (cCharAt3 == ')') {
                                        throw ex("parser.next.4", this.offset - 1);
                                    }
                                    i9 = 21;
                                    break;
                                } while (cCharAt3 != ')');
                                if (cCharAt3 == ')') {
                                    throw ex("parser.next.4", this.offset - 1);
                                }
                                i9 = 21;
                                break;
                            }
                        } else {
                            i9 = 15;
                            break;
                        }
                    } else {
                        i9 = 6;
                        break;
                    }
                    break;
                case ')':
                    i9 = 7;
                    break;
                case '*':
                    break;
                case '+':
                    i9 = 4;
                    break;
                default:
                    i9 = 0;
                    break;
            }
        } else {
            int i16 = this.offset;
            if (i16 >= this.regexlen) {
                throw ex("parser.next.1", i16 - 1);
            }
            String str6 = this.regex;
            this.offset = i16 + 1;
            this.chardata = str6.charAt(i16);
        }
        this.nexttoken = i9;
    }

    public synchronized Token parse(String str, int i5) {
        Token regex;
        try {
            this.options = i5;
            this.offset = 0;
            setContext(0);
            this.parennumber = 1;
            this.hasBackReferences = false;
            this.regex = str;
            if (isSet(16)) {
                this.regex = REUtil.stripExtendedComment(this.regex);
            }
            this.regexlen = this.regex.length();
            next();
            regex = parseRegex();
            int i6 = this.offset;
            if (i6 != this.regexlen) {
                throw ex("parser.parse.1", i6);
            }
            if (this.references != null) {
                for (int i7 = 0; i7 < this.references.size(); i7++) {
                    ReferencePosition referencePosition = (ReferencePosition) this.references.elementAt(i7);
                    if (this.parennumber <= referencePosition.refNumber) {
                        throw ex("parser.parse.2", referencePosition.position);
                    }
                }
                this.references.removeAllElements();
            }
        } catch (Throwable th) {
            throw th;
        }
        return regex;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0077  */
    /* JADX WARN: Code duplicated, block: B:53:0x007f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0084  */
    /* JADX WARN: Code duplicated, block: B:57:0x0092  */
    /* JADX WARN: Code duplicated, block: B:61:0x009e  */
    public Token parseAtom() {
        int i5;
        Token tokenProcessBacksolidus_pP;
        int iDecodeEscaped;
        int i6 = read();
        if (i6 == 0) {
            int i7 = this.chardata;
            if (i7 == 93 || i7 == 123 || i7 == 125) {
                throw ex("parser.atom.4", this.offset - 1);
            }
            Token.CharToken charTokenCreateChar = Token.createChar(i7);
            int i8 = this.chardata;
            next();
            if (!REUtil.isHighSurrogate(i8) || read() != 0 || !REUtil.isLowSurrogate(this.chardata)) {
                return charTokenCreateChar;
            }
            Token.ParenToken parenTokenCreateParen = Token.createParen(Token.createString(new String(new char[]{(char) i8, (char) this.chardata})), 0);
            next();
            return parenTokenCreateParen;
        }
        if (i6 == 6) {
            return processParen();
        }
        if (i6 == 13) {
            return processParen2();
        }
        if (i6 == 18) {
            return processIndependent();
        }
        if (i6 == 19) {
            return parseSetOperations();
        }
        if (i6 == 22) {
            return processModifiers();
        }
        if (i6 == 23) {
            return processCondition();
        }
        switch (i6) {
            case 8:
                next();
                return Token.token_dot;
            case 9:
                return parseCharacterClass(true);
            case 10:
                int i9 = this.chardata;
                if (i9 == 67) {
                    return processBacksolidus_C();
                }
                if (i9 != 68) {
                    if (i9 == 73) {
                        return processBacksolidus_I();
                    }
                    if (i9 != 80) {
                        if (i9 != 83) {
                            if (i9 == 105) {
                                return processBacksolidus_i();
                            }
                            if (i9 != 110) {
                                if (i9 != 112) {
                                    if (i9 != 87) {
                                        if (i9 == 88) {
                                            return processBacksolidus_X();
                                        }
                                        switch (i9) {
                                            case 49:
                                            case 50:
                                            case 51:
                                            case 52:
                                            case 53:
                                            case 54:
                                            case 55:
                                            case 56:
                                            case 57:
                                                return processBackreference();
                                            default:
                                                switch (i9) {
                                                    case 99:
                                                        return processBacksolidus_c();
                                                    case 100:
                                                        break;
                                                    case 101:
                                                    case 102:
                                                        iDecodeEscaped = decodeEscaped();
                                                        if (iDecodeEscaped < 65536) {
                                                            tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                                        } else {
                                                            tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                                        }
                                                        break;
                                                    case 103:
                                                        return processBacksolidus_g();
                                                    default:
                                                        switch (i9) {
                                                            case 114:
                                                            case 116:
                                                            case 117:
                                                            case 118:
                                                            case 120:
                                                                iDecodeEscaped = decodeEscaped();
                                                                if (iDecodeEscaped < 65536) {
                                                                    tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                                                } else {
                                                                    tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                                                }
                                                                break;
                                                            case 115:
                                                            case 119:
                                                                break;
                                                            default:
                                                                tokenProcessBacksolidus_pP = Token.createChar(i9);
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    i5 = this.offset;
                                    tokenProcessBacksolidus_pP = processBacksolidus_pP(i9);
                                    if (tokenProcessBacksolidus_pP == null) {
                                        throw ex("parser.atom.5", i5);
                                    }
                                }
                            } else {
                                iDecodeEscaped = decodeEscaped();
                                if (iDecodeEscaped < 65536) {
                                    tokenProcessBacksolidus_pP = Token.createChar(iDecodeEscaped);
                                } else {
                                    tokenProcessBacksolidus_pP = Token.createString(REUtil.decomposeToSurrogates(iDecodeEscaped));
                                }
                            }
                        }
                    } else {
                        i5 = this.offset;
                        tokenProcessBacksolidus_pP = processBacksolidus_pP(i9);
                        if (tokenProcessBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i5);
                        }
                    }
                    next();
                    return tokenProcessBacksolidus_pP;
                }
                Token tokenForShorthand = getTokenForShorthand(i9);
                next();
                return tokenForShorthand;
            default:
                throw ex("parser.atom.4", this.offset - 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0085 A[PHI: r7
  0x0085: PHI (r7v10 int) = (r7v2 int), (r7v11 int), (r7v12 int) binds: [B:60:0x00ae, B:57:0x00a9, B:47:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    public RangeToken parseCharacterClass(boolean z6) {
        RangeToken rangeTokenCreateRange;
        boolean z7;
        boolean z8;
        boolean z9;
        setContext(1);
        next();
        RangeToken rangeTokenCreateRange2 = null;
        if (read() == 0 && this.chardata == 94) {
            next();
            if (z6) {
                rangeTokenCreateRange = Token.createNRange();
            } else {
                rangeTokenCreateRange2 = Token.createRange();
                rangeTokenCreateRange2.addRange(0, 1114111);
                rangeTokenCreateRange = Token.createRange();
            }
            z7 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            z7 = false;
        }
        boolean z10 = true;
        while (true) {
            int i5 = read();
            if (i5 == 1 || (i5 == 0 && this.chardata == 93 && !z10)) {
                break;
            }
            int iProcessCIinCharacterClass = this.chardata;
            if (i5 == 10) {
                if (iProcessCIinCharacterClass == 67) {
                    iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                    if (iProcessCIinCharacterClass < 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                } else {
                    if (iProcessCIinCharacterClass == 68) {
                        rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                    } else if (iProcessCIinCharacterClass == 73) {
                        iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                        if (iProcessCIinCharacterClass < 0) {
                            z9 = false;
                        }
                    } else {
                        if (iProcessCIinCharacterClass != 80) {
                            if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                                if (iProcessCIinCharacterClass == 105) {
                                    iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                    if (iProcessCIinCharacterClass < 0) {
                                        z9 = false;
                                    }
                                } else if (iProcessCIinCharacterClass != 112) {
                                    if (iProcessCIinCharacterClass != 115 && iProcessCIinCharacterClass != 119) {
                                        if (iProcessCIinCharacterClass == 99) {
                                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                            if (iProcessCIinCharacterClass < 0) {
                                            }
                                        } else if (iProcessCIinCharacterClass != 100) {
                                            iProcessCIinCharacterClass = decodeEscaped();
                                        }
                                        z9 = false;
                                    }
                                }
                            }
                            rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                        }
                        int i6 = this.offset;
                        RangeToken rangeTokenProcessBacksolidus_pP = processBacksolidus_pP(iProcessCIinCharacterClass);
                        if (rangeTokenProcessBacksolidus_pP == null) {
                            throw ex("parser.atom.5", i6);
                        }
                        rangeTokenCreateRange.mergeRanges(rangeTokenProcessBacksolidus_pP);
                    }
                    z9 = true;
                }
            } else if (i5 == 20) {
                int iIndexOf = this.regex.indexOf(58, this.offset);
                if (iIndexOf < 0) {
                    throw ex("parser.cc.1", this.offset);
                }
                if (this.regex.charAt(this.offset) == '^') {
                    this.offset++;
                    z8 = false;
                } else {
                    z8 = true;
                }
                RangeToken range = Token.getRange(this.regex.substring(this.offset, iIndexOf), z8, isSet(512));
                if (range == null) {
                    throw ex("parser.cc.3", this.offset);
                }
                rangeTokenCreateRange.mergeRanges(range);
                int i7 = iIndexOf + 1;
                if (i7 >= this.regexlen || this.regex.charAt(i7) != ']') {
                    throw ex("parser.cc.1", iIndexOf);
                }
                this.offset = iIndexOf + 2;
                z9 = true;
            } else {
                z9 = false;
            }
            next();
            if (!z9) {
                if (read() == 0 && this.chardata == 45) {
                    next();
                    int i8 = read();
                    if (i8 == 1) {
                        throw ex("parser.cc.2", this.offset);
                    }
                    if (i8 == 0 && this.chardata == 93) {
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        rangeTokenCreateRange.addRange(45, 45);
                    } else {
                        int iDecodeEscaped = this.chardata;
                        if (i8 == 10) {
                            iDecodeEscaped = decodeEscaped();
                        }
                        next();
                        rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                    }
                } else {
                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                }
            }
            if (isSet(1024) && read() == 0 && this.chardata == 44) {
                next();
            }
            z10 = false;
        }
        if (read() == 1) {
            throw ex("parser.cc.2", this.offset);
        }
        if (!z6 && z7) {
            rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
            rangeTokenCreateRange = rangeTokenCreateRange2;
        }
        rangeTokenCreateRange.sortRanges();
        rangeTokenCreateRange.compactRanges();
        setContext(0);
        next();
        return rangeTokenCreateRange;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0113  */
    /* JADX WARN: Code duplicated, block: B:103:0x0123  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:89:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:94:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:97:0x0104  */
    /* JADX WARN: Code duplicated, block: B:99:0x010a  */
    public Token parseFactor() {
        int i5;
        int i6;
        Token.ClosureToken closureTokenCreateClosure;
        int i7;
        switch (read()) {
            case 10:
                int i8 = this.chardata;
                if (i8 == 60) {
                    return processBacksolidus_lt();
                }
                if (i8 == 62) {
                    return processBacksolidus_gt();
                }
                if (i8 == 90) {
                    return processBacksolidus_Z();
                }
                if (i8 == 98) {
                    return processBacksolidus_b();
                }
                if (i8 == 122) {
                    return processBacksolidus_z();
                }
                if (i8 == 65) {
                    return processBacksolidus_A();
                }
                if (i8 == 66) {
                    return processBacksolidus_B();
                }
                break;
            case 11:
                return processCaret();
            case 12:
                return processDollar();
            case 14:
                return processLookahead();
            case 15:
                return processNegativelookahead();
            case 16:
                return processLookbehind();
            case 17:
                return processNegativelookbehind();
            case 21:
                next();
                return Token.createEmpty();
        }
        Token atom = parseAtom();
        int i9 = read();
        if (i9 != 0) {
            if (i9 == 3) {
                return processStar(atom);
            }
            if (i9 == 4) {
                return processPlus(atom);
            }
            if (i9 == 5) {
                return processQuestion(atom);
            }
        } else if (this.chardata == 123 && (i5 = this.offset) < this.regexlen) {
            int i10 = i5 + 1;
            char cCharAt = this.regex.charAt(i5);
            if (cCharAt < '0' || cCharAt > '9') {
                throw ex("parser.quantifier.1", this.offset);
            }
            int i11 = cCharAt - '0';
            while (i10 < this.regexlen) {
                int i12 = i10 + 1;
                cCharAt = this.regex.charAt(i10);
                if (cCharAt < '0' || cCharAt > '9') {
                    i10 = i12;
                    if (cCharAt == ',') {
                        i6 = i11;
                    } else {
                        if (i10 < this.regexlen) {
                            throw ex("parser.quantifier.3", this.offset);
                        }
                        int i13 = i10 + 1;
                        cCharAt = this.regex.charAt(i10);
                        if (cCharAt >= '0' || cCharAt > '9') {
                            i7 = -1;
                        } else {
                            i7 = cCharAt - '0';
                            while (i13 < this.regexlen) {
                                int i14 = i13 + 1;
                                cCharAt = this.regex.charAt(i13);
                                if (cCharAt < '0' || cCharAt > '9') {
                                    i13 = i14;
                                    if (i11 > i7) {
                                        throw ex("parser.quantifier.4", this.offset);
                                    }
                                } else {
                                    i7 = ((i7 * 10) + cCharAt) - 48;
                                    if (i7 < 0) {
                                        throw ex("parser.quantifier.5", this.offset);
                                    }
                                    i13 = i14;
                                }
                            }
                            if (i11 > i7) {
                                throw ex("parser.quantifier.4", this.offset);
                            }
                        }
                        i6 = i7;
                        i10 = i13;
                    }
                    if (cCharAt == '}') {
                        throw ex("parser.quantifier.2", this.offset);
                    }
                    if (checkQuestion(i10)) {
                        closureTokenCreateClosure = Token.createNGClosure(atom);
                        this.offset = i10 + 1;
                    } else {
                        closureTokenCreateClosure = Token.createClosure(atom);
                        this.offset = i10;
                    }
                    closureTokenCreateClosure.setMin(i11);
                    closureTokenCreateClosure.setMax(i6);
                    next();
                    return closureTokenCreateClosure;
                }
                i11 = ((i11 * 10) + cCharAt) - 48;
                if (i11 < 0) {
                    throw ex("parser.quantifier.5", this.offset);
                }
                i10 = i12;
            }
            if (cCharAt == ',') {
                i6 = i11;
            } else {
                if (i10 < this.regexlen) {
                    throw ex("parser.quantifier.3", this.offset);
                }
                int i15 = i10 + 1;
                cCharAt = this.regex.charAt(i10);
                if (cCharAt >= '0') {
                    i7 = -1;
                } else {
                    i7 = -1;
                }
                i6 = i7;
                i10 = i15;
            }
            if (cCharAt == '}') {
                throw ex("parser.quantifier.2", this.offset);
            }
            if (checkQuestion(i10)) {
                closureTokenCreateClosure = Token.createNGClosure(atom);
                this.offset = i10 + 1;
            } else {
                closureTokenCreateClosure = Token.createClosure(atom);
                this.offset = i10;
            }
            closureTokenCreateClosure.setMin(i11);
            closureTokenCreateClosure.setMax(i6);
            next();
            return closureTokenCreateClosure;
        }
        return atom;
    }

    public Token parseRegex() {
        Token term = parseTerm();
        Token.UnionToken unionTokenCreateUnion = null;
        while (read() == 2) {
            next();
            if (unionTokenCreateUnion == null) {
                unionTokenCreateUnion = Token.createUnion();
                unionTokenCreateUnion.addChild(term);
                term = unionTokenCreateUnion;
            }
            term.addChild(parseTerm());
        }
        return term;
    }

    public RangeToken parseSetOperations() {
        RangeToken characterClass = parseCharacterClass(false);
        while (true) {
            int i5 = read();
            if (i5 == 7) {
                next();
                return characterClass;
            }
            int i6 = this.chardata;
            if ((i5 != 0 || (i6 != 45 && i6 != 38)) && i5 != 4) {
                throw ex("parser.ope.2", this.offset - 1);
            }
            next();
            if (read() != 9) {
                throw ex("parser.ope.1", this.offset - 1);
            }
            RangeToken characterClass2 = parseCharacterClass(false);
            if (i5 == 4) {
                characterClass.mergeRanges(characterClass2);
            } else if (i6 == 45) {
                characterClass.subtractRanges(characterClass2);
            } else {
                if (i6 != 38) {
                    throw new RuntimeException("ASSERT");
                }
                characterClass.intersectRanges(characterClass2);
            }
        }
    }

    public Token parseTerm() {
        int i5 = read();
        if (i5 == 2 || i5 == 7 || i5 == 1) {
            return Token.createEmpty();
        }
        Token factor = parseFactor();
        Token.UnionToken unionTokenCreateConcat = null;
        while (true) {
            int i6 = read();
            if (i6 == 2 || i6 == 7 || i6 == 1) {
                break;
            }
            if (unionTokenCreateConcat == null) {
                unionTokenCreateConcat = Token.createConcat();
                unionTokenCreateConcat.addChild(factor);
                factor = unionTokenCreateConcat;
            }
            unionTokenCreateConcat.addChild(parseFactor());
        }
        return factor;
    }

    public Token processBackreference() {
        int i5 = this.chardata - 48;
        Token.StringToken stringTokenCreateBackReference = Token.createBackReference(i5);
        this.hasBackReferences = true;
        if (this.references == null) {
            this.references = new Vector();
        }
        this.references.addElement(new ReferencePosition(i5, this.offset - 2));
        next();
        return stringTokenCreateBackReference;
    }

    public Token processBacksolidus_A() {
        next();
        return Token.token_stringbeginning;
    }

    public Token processBacksolidus_B() {
        next();
        return Token.token_not_wordedge;
    }

    public Token processBacksolidus_C() {
        throw ex("parser.process.1", this.offset);
    }

    public Token processBacksolidus_I() {
        throw ex("parser.process.1", this.offset);
    }

    public Token processBacksolidus_X() {
        next();
        return Token.getCombiningCharacterSequence();
    }

    public Token processBacksolidus_Z() {
        next();
        return Token.token_stringend2;
    }

    public Token processBacksolidus_b() {
        next();
        return Token.token_wordedge;
    }

    public Token processBacksolidus_c() {
        int i5 = this.offset;
        if (i5 < this.regexlen) {
            String str = this.regex;
            this.offset = i5 + 1;
            char cCharAt = str.charAt(i5);
            if ((65504 & cCharAt) == 64) {
                next();
                return Token.createChar(cCharAt - '@');
            }
        }
        throw ex("parser.atom.1", this.offset - 1);
    }

    public Token processBacksolidus_g() {
        next();
        return Token.getGraphemePattern();
    }

    public Token processBacksolidus_gt() {
        next();
        return Token.token_wordend;
    }

    public Token processBacksolidus_i() {
        Token.CharToken charTokenCreateChar = Token.createChar(105);
        next();
        return charTokenCreateChar;
    }

    public Token processBacksolidus_lt() {
        next();
        return Token.token_wordbeginning;
    }

    public RangeToken processBacksolidus_pP(int i5) {
        next();
        if (read() != 0 || this.chardata != 123) {
            throw ex("parser.atom.2", this.offset - 1);
        }
        boolean z6 = i5 == 112;
        int i6 = this.offset;
        int iIndexOf = this.regex.indexOf(125, i6);
        if (iIndexOf < 0) {
            throw ex("parser.atom.3", this.offset);
        }
        String strSubstring = this.regex.substring(i6, iIndexOf);
        this.offset = iIndexOf + 1;
        return Token.getRange(strSubstring, z6, isSet(512));
    }

    public Token processBacksolidus_z() {
        next();
        return Token.token_stringend;
    }

    public int processCIinCharacterClass(RangeToken rangeToken, int i5) {
        return decodeEscaped();
    }

    public Token processCaret() {
        next();
        return Token.token_linebeginning;
    }

    public Token processCondition() {
        Token token;
        int i5;
        int i6 = this.offset;
        if (i6 + 1 >= this.regexlen) {
            throw ex("parser.factor.4", i6);
        }
        char cCharAt = this.regex.charAt(i6);
        Token child = null;
        if ('1' > cCharAt || cCharAt > '9') {
            if (cCharAt == '?') {
                this.offset--;
            }
            next();
            Token factor = parseFactor();
            int i7 = factor.type;
            if (i7 != 8) {
                switch (i7) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ex("parser.factor.5", this.offset);
                }
            } else if (read() != 7) {
                throw ex("parser.factor.1", this.offset - 1);
            }
            token = factor;
            i5 = -1;
        } else {
            i5 = cCharAt - '0';
            this.hasBackReferences = true;
            if (this.references == null) {
                this.references = new Vector();
            }
            this.references.addElement(new ReferencePosition(i5, this.offset));
            int i8 = this.offset + 1;
            this.offset = i8;
            if (this.regex.charAt(i8) != ')') {
                throw ex("parser.factor.1", this.offset);
            }
            this.offset++;
            token = null;
        }
        next();
        Token regex = parseRegex();
        if (regex.type == 2) {
            if (regex.size() != 2) {
                throw ex("parser.factor.6", this.offset);
            }
            child = regex.getChild(1);
            regex = regex.getChild(0);
        }
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return Token.createCondition(i5, token, regex, child);
    }

    public Token processDollar() {
        next();
        return Token.token_lineend;
    }

    public Token processIndependent() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(24, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processLookahead() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(20, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processLookbehind() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(22, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processModifiers() {
        int optionValue;
        int optionValue2;
        int i5 = 0;
        byte bCharAt = -1;
        int i6 = 0;
        while (true) {
            int i7 = this.offset;
            if (i7 >= this.regexlen || (optionValue2 = REUtil.getOptionValue((bCharAt = this.regex.charAt(i7)))) == 0) {
                break;
            }
            i6 |= optionValue2;
            this.offset++;
        }
        int i8 = this.offset;
        if (i8 >= this.regexlen) {
            throw ex("parser.factor.2", i8 - 1);
        }
        if (bCharAt == 45) {
            this.offset = i8 + 1;
            while (true) {
                int i9 = this.offset;
                if (i9 >= this.regexlen || (optionValue = REUtil.getOptionValue((bCharAt = this.regex.charAt(i9)))) == 0) {
                    break;
                }
                i5 |= optionValue;
                this.offset++;
            }
            int i10 = this.offset;
            if (i10 >= this.regexlen) {
                throw ex("parser.factor.2", i10 - 1);
            }
        }
        if (bCharAt != 58) {
            if (bCharAt != 41) {
                throw ex("parser.factor.3", this.offset);
            }
            this.offset++;
            next();
            return Token.createModifierGroup(parseRegex(), i6, i5);
        }
        this.offset++;
        next();
        Token.ModifierToken modifierTokenCreateModifierGroup = Token.createModifierGroup(parseRegex(), i6, i5);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return modifierTokenCreateModifierGroup;
    }

    public Token processNegativelookahead() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(21, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processNegativelookbehind() {
        next();
        Token.ParenToken parenTokenCreateLook = Token.createLook(23, parseRegex());
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateLook;
    }

    public Token processParen() {
        next();
        int i5 = this.parennumber;
        this.parennumber = i5 + 1;
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), i5);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    public Token processParen2() {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    public Token processPlus(Token token) {
        next();
        if (read() != 5) {
            return Token.createConcat(token, Token.createClosure(token));
        }
        next();
        return Token.createConcat(token, Token.createNGClosure(token));
    }

    public Token processQuestion(Token token) {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        if (read() != 5) {
            unionTokenCreateUnion.addChild(token);
            unionTokenCreateUnion.addChild(Token.createEmpty());
            return unionTokenCreateUnion;
        }
        next();
        unionTokenCreateUnion.addChild(Token.createEmpty());
        unionTokenCreateUnion.addChild(token);
        return unionTokenCreateUnion;
    }

    public Token processStar(Token token) {
        next();
        if (read() != 5) {
            return Token.createClosure(token);
        }
        next();
        return Token.createNGClosure(token);
    }

    public final int read() {
        return this.nexttoken;
    }

    public final void setContext(int i5) {
        this.context = i5;
    }

    public void setLocale(Locale locale) {
        this.resources = ResourceBundle.getBundle(BUNDLE_PKG, locale, RegexParser.class.getClassLoader());
    }

    public RegexParser(Locale locale) {
        setLocale(locale);
    }
}
