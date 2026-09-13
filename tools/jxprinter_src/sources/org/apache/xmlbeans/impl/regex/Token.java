package org.apache.xmlbeans.impl.regex;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.editing.FlutterTextUtils;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰\u2fff\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories;
    private static final Hashtable categories2;
    private static final String[] categoryNames;
    static final int[] nonBMPBlockRanges;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    private static Token token_grapheme = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_spaces = null;
    static Token token_wordchars = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;
    static Token token_empty = new Token(7);
    static Token token_linebeginning = createAnchor(94);
    static Token token_linebeginning2 = createAnchor(64);
    static Token token_lineend = createAnchor(36);
    static Token token_stringbeginning = createAnchor(65);
    static Token token_stringend = createAnchor(122);
    static Token token_stringend2 = createAnchor(90);
    static Token token_wordedge = createAnchor(98);
    static Token token_not_wordedge = createAnchor(66);
    static Token token_wordbeginning = createAnchor(60);
    static Token token_wordend = createAnchor(62);
    static Token token_dot = new Token(11);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CharToken extends Token implements Serializable {
        int chardata;

        public CharToken(int i5, int i6) {
            super(i5);
            this.chardata = i6;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public boolean match(int i5) {
            if (this.type == 0) {
                return i5 == this.chardata;
            }
            throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            int i6 = this.type;
            if (i6 != 0) {
                if (i6 != 8) {
                    return null;
                }
                if (this == Token.token_linebeginning || this == Token.token_lineend) {
                    return "" + ((char) this.chardata);
                }
                return "\\" + ((char) this.chardata);
            }
            int i7 = this.chardata;
            if (i7 == 9) {
                return "\\t";
            }
            if (i7 == 10) {
                return "\\n";
            }
            if (i7 == 12) {
                return "\\f";
            }
            if (i7 == 13) {
                return "\\r";
            }
            if (i7 == 27) {
                return "\\e";
            }
            if (i7 != 46 && i7 != 63 && i7 != 91 && i7 != 92 && i7 != 123 && i7 != 124) {
                switch (i7) {
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                        break;
                    default:
                        if (i7 < 65536) {
                            return "" + ((char) this.chardata);
                        }
                        String str = "0" + Integer.toHexString(this.chardata);
                        return "\\v" + str.substring(str.length() - 6, str.length());
                }
            }
            return "\\" + ((char) this.chardata);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        public ClosureToken(int i5, Token token) {
            super(i5);
            this.child = token;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final void setMax(int i5) {
            this.max = i5;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public final void setMin(int i5) {
            this.min = i5;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            if (this.type == 3) {
                if (getMin() < 0 && getMax() < 0) {
                    return AbstractC0157z.s(new StringBuilder(), this.child.toString(i5), ProxyConfig.MATCH_ALL_SCHEMES);
                }
                if (getMin() == getMax()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.child.toString(i5));
                    sb.append(VectorFormat.DEFAULT_PREFIX);
                    return AbstractC0157z.l(VectorFormat.DEFAULT_SUFFIX, getMin(), sb);
                }
                if (getMin() >= 0 && getMax() >= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.child.toString(i5));
                    sb2.append(VectorFormat.DEFAULT_PREFIX);
                    sb2.append(getMin());
                    sb2.append(",");
                    return AbstractC0157z.l(VectorFormat.DEFAULT_SUFFIX, getMax(), sb2);
                }
                if (getMin() >= 0 && getMax() < 0) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.child.toString(i5));
                    sb3.append(VectorFormat.DEFAULT_PREFIX);
                    return AbstractC0157z.l(",}", getMin(), sb3);
                }
                throw new RuntimeException("Token#toString(): CLOSURE " + getMin() + ", " + getMax());
            }
            if (getMin() < 0 && getMax() < 0) {
                return AbstractC0157z.s(new StringBuilder(), this.child.toString(i5), "*?");
            }
            if (getMin() == getMax()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.child.toString(i5));
                sb4.append(VectorFormat.DEFAULT_PREFIX);
                return AbstractC0157z.l("}?", getMin(), sb4);
            }
            if (getMin() >= 0 && getMax() >= 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.child.toString(i5));
                sb5.append(VectorFormat.DEFAULT_PREFIX);
                sb5.append(getMin());
                sb5.append(",");
                return AbstractC0157z.l("}?", getMax(), sb5);
            }
            if (getMin() >= 0 && getMax() < 0) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.child.toString(i5));
                sb6.append(VectorFormat.DEFAULT_PREFIX);
                return AbstractC0157z.l(",}?", getMin(), sb6);
            }
            throw new RuntimeException("Token#toString(): NONGREEDYCLOSURE " + getMin() + ", " + getMax());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        public ConcatToken(Token token, Token token2) {
            super(1);
            this.child = token;
            this.child2 = token2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            return i5 == 0 ? this.child : this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            Token token = this.child2;
            if (token.type == 3 && token.getChild(0) == this.child) {
                return AbstractC0157z.s(new StringBuilder(), this.child.toString(i5), "+");
            }
            Token token2 = this.child2;
            if (token2.type == 9 && token2.getChild(0) == this.child) {
                return AbstractC0157z.s(new StringBuilder(), this.child.toString(i5), "+?");
            }
            return this.child.toString(i5) + this.child2.toString(i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConditionToken extends Token implements Serializable {
        Token condition;
        Token no;
        int refNumber;
        Token yes;

        public ConditionToken(int i5, Token token, Token token2, Token token3) {
            super(26);
            this.refNumber = i5;
            this.condition = token;
            this.yes = token2;
            this.no = token3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            if (i5 == 0) {
                return this.yes;
            }
            if (i5 == 1) {
                return this.no;
            }
            throw new RuntimeException(AbstractC0157z.k(i5, "Internal Error: "));
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return this.no == null ? 1 : 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            String strL;
            if (this.refNumber > 0) {
                strL = AbstractC0157z.l(")", this.refNumber, new StringBuilder("(?("));
            } else if (this.condition.type == 8) {
                strL = "(?(" + this.condition + ")";
            } else {
                strL = "(?" + this.condition;
            }
            if (this.no == null) {
                StringBuilder sbR = a.r(strL);
                sbR.append(this.yes);
                sbR.append(")");
                return sbR.toString();
            }
            StringBuilder sbR2 = a.r(strL);
            sbR2.append(this.yes);
            sbR2.append("|");
            sbR2.append(this.no);
            sbR2.append(")");
            return sbR2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FixedStringContainer {
        Token token = null;
        int options = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        public ModifierToken(Token token, int i5, int i6) {
            super(25);
            this.child = token;
            this.add = i5;
            this.mask = i6;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            return this.child;
        }

        public int getOptions() {
            return this.add;
        }

        public int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            StringBuilder sb = new StringBuilder("(?");
            int i6 = this.add;
            sb.append(i6 == 0 ? "" : REUtil.createOptionString(i6));
            int i7 = this.mask;
            sb.append(i7 != 0 ? REUtil.createOptionString(i7) : "");
            sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            return AbstractC0157z.s(sb, this.child.toString(i5), ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        public ParenToken(int i5, Token token, int i6) {
            super(i5);
            this.child = token;
            this.parennumber = i6;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            int i6 = this.type;
            if (i6 == 6) {
                return this.parennumber == 0 ? AbstractC0157z.s(new StringBuilder("(?:"), this.child.toString(i5), ")") : AbstractC0157z.s(new StringBuilder("("), this.child.toString(i5), ")");
            }
            switch (i6) {
                case 20:
                    return AbstractC0157z.s(new StringBuilder("(?="), this.child.toString(i5), ")");
                case 21:
                    return AbstractC0157z.s(new StringBuilder("(?!"), this.child.toString(i5), ")");
                case 22:
                    return AbstractC0157z.s(new StringBuilder("(?<="), this.child.toString(i5), ")");
                case 23:
                    return AbstractC0157z.s(new StringBuilder("(?<!"), this.child.toString(i5), ")");
                case 24:
                    return AbstractC0157z.s(new StringBuilder("(?>"), this.child.toString(i5), ")");
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        public StringToken(int i5, String str, int i6) {
            super(i5);
            this.string = str;
            this.refNumber = i6;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            if (this.type != 12) {
                return REUtil.quoteMeta(this.string);
            }
            return "\\" + this.refNumber;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnionToken extends Token implements Serializable {
        Vector children;

        public UnionToken(int i5) {
            super(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public void addChild(Token token) {
            int i5;
            StringBuilder sb;
            if (token == null) {
                return;
            }
            if (this.children == null) {
                this.children = new Vector();
            }
            if (this.type == 2) {
                this.children.addElement(token);
                return;
            }
            if (token.type == 1) {
                for (int i6 = 0; i6 < token.size(); i6++) {
                    addChild(token.getChild(i6));
                }
                return;
            }
            int size = this.children.size();
            if (size == 0) {
                this.children.addElement(token);
                return;
            }
            int i7 = size - 1;
            Token tokenCreateString = (Token) this.children.elementAt(i7);
            int i8 = tokenCreateString.type;
            if ((i8 != 0 && i8 != 10) || ((i5 = token.type) != 0 && i5 != 10)) {
                this.children.addElement(token);
                return;
            }
            int length = i5 == 0 ? 2 : token.getString().length();
            if (tokenCreateString.type == 0) {
                sb = new StringBuilder(length + 2);
                int i9 = tokenCreateString.getChar();
                if (i9 >= 65536) {
                    sb.append(REUtil.decomposeToSurrogates(i9));
                } else {
                    sb.append((char) i9);
                }
                tokenCreateString = Token.createString(null);
                this.children.setElementAt(tokenCreateString, i7);
            } else {
                sb = new StringBuilder(tokenCreateString.getString().length() + length);
                sb.append(tokenCreateString.getString());
            }
            if (token.type == 0) {
                int i10 = token.getChar();
                if (i10 >= 65536) {
                    sb.append(REUtil.decomposeToSurrogates(i10));
                } else {
                    sb.append((char) i10);
                }
            } else {
                sb.append(token.getString());
            }
            ((StringToken) tokenCreateString).string = new String(sb);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public Token getChild(int i5) {
            return (Token) this.children.elementAt(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public int size() {
            Vector vector = this.children;
            if (vector == null) {
                return 0;
            }
            return vector.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int i5) {
            if (this.type != 1) {
                if (this.children.size() == 2 && getChild(1).type == 7) {
                    return AbstractC0157z.s(new StringBuilder(), getChild(0).toString(i5), "?");
                }
                if (this.children.size() == 2 && getChild(0).type == 7) {
                    return AbstractC0157z.s(new StringBuilder(), getChild(1).toString(i5), "??");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(((Token) this.children.elementAt(0)).toString(i5));
                for (int i6 = 1; i6 < this.children.size(); i6++) {
                    sb.append('|');
                    sb.append(((Token) this.children.elementAt(i6)).toString(i5));
                }
                return new String(sb);
            }
            if (this.children.size() != 2) {
                StringBuilder sb2 = new StringBuilder();
                for (int i7 = 0; i7 < this.children.size(); i7++) {
                    sb2.append(((Token) this.children.elementAt(i7)).toString(i5));
                }
                return new String(sb2);
            }
            Token child = getChild(0);
            Token child2 = getChild(1);
            if (child2.type == 3 && child2.getChild(0) == child) {
                return AbstractC0157z.s(new StringBuilder(), child.toString(i5), "+");
            }
            if (child2.type == 9 && child2.getChild(0) == child) {
                return AbstractC0157z.s(new StringBuilder(), child.toString(i5), "+?");
            }
            return child.toString(i5) + child2.toString(i5);
        }
    }

    static {
        RangeToken rangeTokenCreateRange = createRange();
        token_0to9 = rangeTokenCreateRange;
        rangeTokenCreateRange.addRange(48, 57);
        RangeToken rangeTokenCreateRange2 = createRange();
        token_wordchars = rangeTokenCreateRange2;
        rangeTokenCreateRange2.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken rangeTokenCreateRange3 = createRange();
        token_spaces = rangeTokenCreateRange3;
        rangeTokenCreateRange3.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", "L", "M", "N", "Z", "C", "P", ExifInterface.LATITUDE_SOUTH};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, FlutterTextUtils.CANCEL_TAG};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    public Token(int i5) {
        this.type = i5;
    }

    public static Token complementRanges(Token token) {
        return RangeToken.complementRanges(token);
    }

    private static CharToken createAnchor(int i5) {
        tokens++;
        return new CharToken(8, i5);
    }

    public static StringToken createBackReference(int i5) {
        tokens++;
        return new StringToken(12, null, i5);
    }

    public static CharToken createChar(int i5) {
        tokens++;
        return new CharToken(0, i5);
    }

    public static ClosureToken createClosure(Token token) {
        tokens++;
        return new ClosureToken(3, token);
    }

    public static ConcatToken createConcat(Token token, Token token2) {
        tokens++;
        return new ConcatToken(token, token2);
    }

    public static ConditionToken createCondition(int i5, Token token, Token token2, Token token3) {
        tokens++;
        return new ConditionToken(i5, token, token2, token3);
    }

    public static Token createEmpty() {
        return token_empty;
    }

    public static ParenToken createLook(int i5, Token token) {
        tokens++;
        return new ParenToken(i5, token, 0);
    }

    public static ModifierToken createModifierGroup(Token token, int i5, int i6) {
        tokens++;
        return new ModifierToken(token, i5, i6);
    }

    public static ClosureToken createNGClosure(Token token) {
        tokens++;
        return new ClosureToken(9, token);
    }

    public static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    public static ParenToken createParen(Token token, int i5) {
        tokens++;
        return new ParenToken(6, token, i5);
    }

    public static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    public static StringToken createString(String str) {
        tokens++;
        return new StringToken(10, str, 0);
    }

    public static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    public static synchronized Token getCombiningCharacterSequence() {
        Token token = token_ccs;
        if (token != null) {
            return token;
        }
        ConcatToken concatTokenCreateConcat = createConcat(getRange("M", false), createClosure(getRange("M", true)));
        token_ccs = concatTokenCreateConcat;
        return concatTokenCreateConcat;
    }

    public static synchronized Token getGraphemePattern() {
        try {
            Token token = token_grapheme;
            if (token != null) {
                return token;
            }
            RangeToken rangeTokenCreateRange = createRange();
            rangeTokenCreateRange.mergeRanges(getRange("ASSIGNED", true));
            rangeTokenCreateRange.subtractRanges(getRange("M", true));
            rangeTokenCreateRange.subtractRanges(getRange("C", true));
            RangeToken rangeTokenCreateRange2 = createRange();
            for (int i5 = 0; i5 < 11; i5++) {
                viramaString.charAt(i5);
                rangeTokenCreateRange2.addRange(i5, i5);
            }
            RangeToken rangeTokenCreateRange3 = createRange();
            rangeTokenCreateRange3.mergeRanges(getRange("M", true));
            rangeTokenCreateRange3.addRange(4448, 4607);
            rangeTokenCreateRange3.addRange(65438, 65439);
            UnionToken unionTokenCreateUnion = createUnion();
            unionTokenCreateUnion.addChild(rangeTokenCreateRange);
            unionTokenCreateUnion.addChild(token_empty);
            UnionToken unionTokenCreateUnion2 = createUnion();
            unionTokenCreateUnion2.addChild(createConcat(rangeTokenCreateRange2, getRange("L", true)));
            unionTokenCreateUnion2.addChild(rangeTokenCreateRange3);
            ConcatToken concatTokenCreateConcat = createConcat(unionTokenCreateUnion, createClosure(unionTokenCreateUnion2));
            token_grapheme = concatTokenCreateConcat;
            return concatTokenCreateConcat;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static RangeToken getRange(String str, boolean z6) {
        Hashtable hashtable = categories;
        if (hashtable.size() == 0) {
            synchronized (hashtable) {
                try {
                    int length = categoryNames.length;
                    Token[] tokenArr = new Token[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        tokenArr[i5] = createRange();
                    }
                    int i6 = 0;
                    while (true) {
                        char c = '#';
                        if (i6 < 65536) {
                            int type = Character.getType((char) i6);
                            if (type == 21 || type == 22) {
                                if (i6 == 171 || i6 == 8216 || i6 == 8219 || i6 == 8220 || i6 == 8223 || i6 == 8249) {
                                    type = 29;
                                }
                                if (i6 == 187 || i6 == 8217 || i6 == 8221 || i6 == 8250) {
                                    type = 30;
                                }
                            }
                            tokenArr[type].addRange(i6, i6);
                            switch (type) {
                                case 0:
                                case 15:
                                case 16:
                                case 18:
                                case 19:
                                    break;
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    c = 31;
                                    break;
                                case 6:
                                case 7:
                                case 8:
                                    c = ' ';
                                    break;
                                case 9:
                                case 10:
                                case 11:
                                    c = '!';
                                    break;
                                case 12:
                                case 13:
                                case 14:
                                    c = '\"';
                                    break;
                                case 17:
                                default:
                                    throw new RuntimeException("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: " + type);
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 29:
                                case 30:
                                    c = '$';
                                    break;
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                    c = '%';
                                    break;
                            }
                            tokenArr[c].addRange(i6, i6);
                            i6++;
                        } else {
                            tokenArr[0].addRange(65536, UTF16_MAX);
                            for (int i7 = 0; i7 < length; i7++) {
                                String[] strArr = categoryNames;
                                if (strArr[i7] != null) {
                                    if (i7 == 0) {
                                        tokenArr[i7].addRange(65536, UTF16_MAX);
                                    }
                                    categories.put(strArr[i7], tokenArr[i7]);
                                    categories2.put(strArr[i7], complementRanges(tokenArr[i7]));
                                }
                            }
                            StringBuilder sb = new StringBuilder(50);
                            int i8 = 0;
                            while (true) {
                                String[] strArr2 = blockNames;
                                if (i8 < strArr2.length) {
                                    RangeToken rangeTokenCreateRange = createRange();
                                    if (i8 < 84) {
                                        int i9 = i8 * 2;
                                        rangeTokenCreateRange.addRange(blockRanges.charAt(i9), blockRanges.charAt(i9 + 1));
                                    } else {
                                        int i10 = (i8 - 84) * 2;
                                        int[] iArr = nonBMPBlockRanges;
                                        rangeTokenCreateRange.addRange(iArr[i10], iArr[i10 + 1]);
                                    }
                                    String str2 = strArr2[i8];
                                    if (str2.equals("Specials")) {
                                        rangeTokenCreateRange.addRange(65520, 65533);
                                    }
                                    if (str2.equals("Private Use")) {
                                        rangeTokenCreateRange.addRange(983040, 1048573);
                                        rangeTokenCreateRange.addRange(1048576, 1114109);
                                    }
                                    categories.put(str2, rangeTokenCreateRange);
                                    categories2.put(str2, complementRanges(rangeTokenCreateRange));
                                    sb.setLength(0);
                                    sb.append("Is");
                                    if (str2.indexOf(32) >= 0) {
                                        for (int i11 = 0; i11 < str2.length(); i11++) {
                                            if (str2.charAt(i11) != ' ') {
                                                sb.append(str2.charAt(i11));
                                            }
                                        }
                                    } else {
                                        sb.append(str2);
                                    }
                                    setAlias(sb.toString(), str2, true);
                                    i8++;
                                } else {
                                    setAlias("ASSIGNED", "Cn", false);
                                    setAlias("UNASSIGNED", "Cn", true);
                                    RangeToken rangeTokenCreateRange2 = createRange();
                                    rangeTokenCreateRange2.addRange(0, UTF16_MAX);
                                    Hashtable hashtable2 = categories;
                                    hashtable2.put(Rule.ALL, rangeTokenCreateRange2);
                                    Hashtable hashtable3 = categories2;
                                    hashtable3.put(Rule.ALL, complementRanges(rangeTokenCreateRange2));
                                    registerNonXS("ASSIGNED");
                                    registerNonXS("UNASSIGNED");
                                    registerNonXS(Rule.ALL);
                                    RangeToken rangeTokenCreateRange3 = createRange();
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[1]);
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[2]);
                                    rangeTokenCreateRange3.mergeRanges(tokenArr[5]);
                                    hashtable2.put("IsAlpha", rangeTokenCreateRange3);
                                    hashtable3.put("IsAlpha", complementRanges(rangeTokenCreateRange3));
                                    registerNonXS("IsAlpha");
                                    RangeToken rangeTokenCreateRange4 = createRange();
                                    rangeTokenCreateRange4.mergeRanges(rangeTokenCreateRange3);
                                    rangeTokenCreateRange4.mergeRanges(tokenArr[9]);
                                    hashtable2.put("IsAlnum", rangeTokenCreateRange4);
                                    hashtable3.put("IsAlnum", complementRanges(rangeTokenCreateRange4));
                                    registerNonXS("IsAlnum");
                                    RangeToken rangeTokenCreateRange5 = createRange();
                                    rangeTokenCreateRange5.mergeRanges(token_spaces);
                                    rangeTokenCreateRange5.mergeRanges(tokenArr[34]);
                                    hashtable2.put("IsSpace", rangeTokenCreateRange5);
                                    hashtable3.put("IsSpace", complementRanges(rangeTokenCreateRange5));
                                    registerNonXS("IsSpace");
                                    RangeToken rangeTokenCreateRange6 = createRange();
                                    rangeTokenCreateRange6.mergeRanges(rangeTokenCreateRange4);
                                    rangeTokenCreateRange6.addRange(95, 95);
                                    hashtable2.put("IsWord", rangeTokenCreateRange6);
                                    hashtable3.put("IsWord", complementRanges(rangeTokenCreateRange6));
                                    registerNonXS("IsWord");
                                    RangeToken rangeTokenCreateRange7 = createRange();
                                    rangeTokenCreateRange7.addRange(0, 127);
                                    hashtable2.put("IsASCII", rangeTokenCreateRange7);
                                    hashtable3.put("IsASCII", complementRanges(rangeTokenCreateRange7));
                                    registerNonXS("IsASCII");
                                    RangeToken rangeTokenCreateRange8 = createRange();
                                    rangeTokenCreateRange8.mergeRanges(tokenArr[35]);
                                    rangeTokenCreateRange8.addRange(32, 32);
                                    hashtable2.put("IsGraph", complementRanges(rangeTokenCreateRange8));
                                    hashtable3.put("IsGraph", rangeTokenCreateRange8);
                                    registerNonXS("IsGraph");
                                    RangeToken rangeTokenCreateRange9 = createRange();
                                    rangeTokenCreateRange9.addRange(48, 57);
                                    rangeTokenCreateRange9.addRange(65, 70);
                                    rangeTokenCreateRange9.addRange(97, 102);
                                    hashtable2.put("IsXDigit", complementRanges(rangeTokenCreateRange9));
                                    hashtable3.put("IsXDigit", rangeTokenCreateRange9);
                                    registerNonXS("IsXDigit");
                                    setAlias("IsDigit", "Nd", true);
                                    setAlias("IsUpper", "Lu", true);
                                    setAlias("IsLower", "Ll", true);
                                    setAlias("IsCntrl", "C", true);
                                    setAlias("IsPrint", "C", false);
                                    setAlias("IsPunct", "P", true);
                                    registerNonXS("IsDigit");
                                    registerNonXS("IsUpper");
                                    registerNonXS("IsLower");
                                    registerNonXS("IsCntrl");
                                    registerNonXS("IsPrint");
                                    registerNonXS("IsPunct");
                                    setAlias("alpha", "IsAlpha", true);
                                    setAlias("alnum", "IsAlnum", true);
                                    setAlias("ascii", "IsASCII", true);
                                    setAlias("cntrl", "IsCntrl", true);
                                    setAlias("digit", "IsDigit", true);
                                    setAlias("graph", "IsGraph", true);
                                    setAlias("lower", "IsLower", true);
                                    setAlias("print", "IsPrint", true);
                                    setAlias("punct", "IsPunct", true);
                                    setAlias("space", "IsSpace", true);
                                    setAlias("upper", "IsUpper", true);
                                    setAlias("word", "IsWord", true);
                                    setAlias("xdigit", "IsXDigit", true);
                                    registerNonXS("alpha");
                                    registerNonXS("alnum");
                                    registerNonXS("ascii");
                                    registerNonXS("cntrl");
                                    registerNonXS("digit");
                                    registerNonXS("graph");
                                    registerNonXS("lower");
                                    registerNonXS("print");
                                    registerNonXS("punct");
                                    registerNonXS("space");
                                    registerNonXS("upper");
                                    registerNonXS("word");
                                    registerNonXS("xdigit");
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z6 ? (RangeToken) categories.get(str) : (RangeToken) categories2.get(str);
    }

    public static boolean isRegisterNonXS(String str) {
        Hashtable hashtable = nonxs;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    private static final boolean isSet(int i5, int i6) {
        return (i5 & i6) == i6;
    }

    private final boolean isShorterThan(Token token) {
        if (token == null) {
            return false;
        }
        if (this.type != 10) {
            throw new RuntimeException("Internal Error: Illegal type: " + this.type);
        }
        int length = getString().length();
        if (token.type == 10) {
            return length < token.getString().length();
        }
        throw new RuntimeException("Internal Error: Illegal type: " + token.type);
    }

    public static void registerNonXS(String str) {
        if (nonxs == null) {
            nonxs = new Hashtable();
        }
        nonxs.put(str, str);
    }

    private static void setAlias(String str, String str2, boolean z6) {
        Hashtable hashtable = categories;
        Token token = (Token) hashtable.get(str2);
        Hashtable hashtable2 = categories2;
        Token token2 = (Token) hashtable2.get(str2);
        if (z6) {
            hashtable.put(str, token);
            hashtable2.put(str, token2);
        } else {
            hashtable2.put(str, token);
            hashtable.put(str, token2);
        }
    }

    public void addChild(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public void addRange(int i5, int i6) {
        throw new RuntimeException("Not supported.");
    }

    public final int analyzeFirstCharacter(RangeToken rangeToken, int i5) {
        int i6 = this.type;
        switch (i6) {
            case 0:
                int i7 = getChar();
                rangeToken.addRange(i7, i7);
                if (i7 < 65536 && isSet(i5, 2)) {
                    char upperCase = Character.toUpperCase((char) i7);
                    rangeToken.addRange(upperCase, upperCase);
                    char lowerCase = Character.toLowerCase(upperCase);
                    rangeToken.addRange(lowerCase, lowerCase);
                }
                return 1;
            case 1:
                int iAnalyzeFirstCharacter = 0;
                for (int i8 = 0; i8 < size(); i8++) {
                    iAnalyzeFirstCharacter = getChild(i8).analyzeFirstCharacter(rangeToken, i5);
                    if (iAnalyzeFirstCharacter != 0) {
                        return iAnalyzeFirstCharacter;
                    }
                }
                return iAnalyzeFirstCharacter;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                int iAnalyzeFirstCharacter2 = 0;
                boolean z6 = false;
                for (int i9 = 0; i9 < size() && (iAnalyzeFirstCharacter2 = getChild(i9).analyzeFirstCharacter(rangeToken, i5)) != 2; i9++) {
                    if (iAnalyzeFirstCharacter2 == 0) {
                        z6 = true;
                    }
                }
                if (z6) {
                    return 0;
                }
                return iAnalyzeFirstCharacter2;
            case 3:
            case 9:
                getChild(0).analyzeFirstCharacter(rangeToken, i5);
                return 0;
            case 4:
                if (isSet(i5, 2)) {
                    rangeToken.mergeRanges(((RangeToken) this).getCaseInsensitiveToken());
                } else {
                    rangeToken.mergeRanges(this);
                }
                return 1;
            case 5:
                if (isSet(i5, 2)) {
                    rangeToken.mergeRanges(complementRanges(((RangeToken) this).getCaseInsensitiveToken()));
                } else {
                    rangeToken.mergeRanges(complementRanges(this));
                }
                return 1;
            case 6:
                break;
            case 7:
            case 8:
                return 0;
            case 10:
                int iCharAt = getString().charAt(0);
                if (REUtil.isHighSurrogate(iCharAt) && getString().length() >= 2) {
                    char cCharAt = getString().charAt(1);
                    if (REUtil.isLowSurrogate(cCharAt)) {
                        iCharAt = REUtil.composeFromSurrogates(iCharAt, cCharAt);
                    }
                }
                rangeToken.addRange(iCharAt, iCharAt);
                if (iCharAt < 65536 && isSet(i5, 2)) {
                    char upperCase2 = Character.toUpperCase((char) iCharAt);
                    rangeToken.addRange(upperCase2, upperCase2);
                    char lowerCase2 = Character.toLowerCase(upperCase2);
                    rangeToken.addRange(lowerCase2, lowerCase2);
                }
                return 1;
            case 11:
                isSet(i5, 4);
                return 0;
            case 12:
                rangeToken.addRange(0, UTF16_MAX);
                return 2;
            default:
                switch (i6) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                        break;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        return getChild(0).analyzeFirstCharacter(rangeToken, (i5 | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                    case 26:
                        int iAnalyzeFirstCharacter3 = getChild(0).analyzeFirstCharacter(rangeToken, i5);
                        if (size() == 1) {
                            return 0;
                        }
                        if (iAnalyzeFirstCharacter3 == 2) {
                            return iAnalyzeFirstCharacter3;
                        }
                        int iAnalyzeFirstCharacter4 = getChild(1).analyzeFirstCharacter(rangeToken, i5);
                        if (iAnalyzeFirstCharacter4 == 2) {
                            return iAnalyzeFirstCharacter4;
                        }
                        return (iAnalyzeFirstCharacter3 == 0 || iAnalyzeFirstCharacter4 == 0) ? 0 : 1;
                    default:
                        throw new RuntimeException("Token#analyzeHeadCharacter(): Invalid Type: " + this.type);
                }
                break;
        }
        return getChild(0).analyzeFirstCharacter(rangeToken, i5);
    }

    public void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003b  */
    /* JADX WARN: Code duplicated, block: B:13:0x0043  */
    public final void findFixedString(FixedStringContainer fixedStringContainer, int i5) {
        int i6 = this.type;
        Token token = null;
        switch (i6) {
            case 0:
                fixedStringContainer.token = null;
                return;
            case 1:
                int i7 = 0;
                for (int i8 = 0; i8 < size(); i8++) {
                    getChild(i8).findFixedString(fixedStringContainer, i5);
                    if (token == null || token.isShorterThan(fixedStringContainer.token)) {
                        token = fixedStringContainer.token;
                        i7 = fixedStringContainer.options;
                    }
                }
                fixedStringContainer.token = token;
                fixedStringContainer.options = i7;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
                fixedStringContainer.token = null;
                return;
            case 6:
                getChild(0).findFixedString(fixedStringContainer, i5);
                return;
            case 10:
                fixedStringContainer.token = this;
                fixedStringContainer.options = i5;
                return;
            default:
                switch (i6) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 26:
                        fixedStringContainer.token = null;
                        return;
                    case 24:
                        getChild(0).findFixedString(fixedStringContainer, i5);
                        return;
                    case 25:
                        ModifierToken modifierToken = (ModifierToken) this;
                        getChild(0).findFixedString(fixedStringContainer, (i5 | modifierToken.getOptions()) & (~modifierToken.getOptionsMask()));
                        return;
                    default:
                        throw new RuntimeException("Token#findFixedString(): Invalid Type: " + this.type);
                }
        }
    }

    public int getChar() {
        return -1;
    }

    public Token getChild(int i5) {
        return null;
    }

    public int getMax() {
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:21:0x004d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:25:0x005c
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final int getMaxLength() {
        /*
            r4 = this;
            int r0 = r4.type
            r1 = 1
            r2 = -1
            r3 = 0
            switch(r0) {
                case 0: goto L8d;
                case 1: goto L76;
                case 2: goto L4d;
                case 3: goto L38;
                case 4: goto L36;
                case 5: goto L36;
                case 6: goto L2d;
                case 7: goto L2c;
                case 8: goto L2c;
                case 9: goto L38;
                case 10: goto L23;
                case 11: goto L36;
                case 12: goto L22;
                default: goto L8;
            }
        L8:
            switch(r0) {
                case 20: goto L21;
                case 21: goto L21;
                case 22: goto L21;
                case 23: goto L21;
                case 24: goto L2d;
                case 25: goto L2d;
                case 26: goto L4d;
                default: goto Lb;
            }
        Lb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Token#getMaxLength(): Invalid Type: "
            r1.<init>(r2)
            int r2 = r4.type
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L21:
            return r3
        L22:
            return r2
        L23:
            java.lang.String r0 = r4.getString()
            int r0 = r0.length()
            return r0
        L2c:
            return r3
        L2d:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
            return r0
        L36:
            r0 = 2
            return r0
        L38:
            int r0 = r4.getMax()
            if (r0 < 0) goto L4c
            int r0 = r4.getMax()
            org.apache.xmlbeans.impl.regex.Token r1 = r4.getChild(r3)
            int r1 = r1.getMaxLength()
            int r0 = r0 * r1
            return r0
        L4c:
            return r2
        L4d:
            int r0 = r4.size()
            if (r0 != 0) goto L54
            return r3
        L54:
            org.apache.xmlbeans.impl.regex.Token r0 = r4.getChild(r3)
            int r0 = r0.getMaxLength()
        L5c:
            if (r0 < 0) goto L75
            int r3 = r4.size()
            if (r1 >= r3) goto L75
            org.apache.xmlbeans.impl.regex.Token r3 = r4.getChild(r1)
            int r3 = r3.getMaxLength()
            if (r3 >= 0) goto L6f
            return r2
        L6f:
            if (r3 <= r0) goto L72
            r0 = r3
        L72:
            int r1 = r1 + 1
            goto L5c
        L75:
            return r0
        L76:
            r0 = r3
        L77:
            int r1 = r4.size()
            if (r3 >= r1) goto L8c
            org.apache.xmlbeans.impl.regex.Token r1 = r4.getChild(r3)
            int r1 = r1.getMaxLength()
            if (r1 >= 0) goto L88
            return r2
        L88:
            int r0 = r0 + r1
            int r3 = r3 + 1
            goto L77
        L8c:
            return r0
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.Token.getMaxLength():int");
    }

    public int getMin() {
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0050  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020 A[RETURN] */
    public final int getMinLength() {
        int minLength;
        int minLength2;
        int i5 = this.type;
        switch (i5) {
            case 0:
            case 4:
            case 5:
            case 11:
                return 1;
            case 1:
                int minLength3 = 0;
                for (int i6 = 0; i6 < size(); i6++) {
                    minLength3 += getChild(i6).getMinLength();
                }
                return minLength3;
            case 2:
                if (size() == 0) {
                    return 0;
                }
                minLength = getChild(0).getMinLength();
                for (int i7 = 1; i7 < size(); i7++) {
                    minLength2 = getChild(i7).getMinLength();
                    if (minLength2 < minLength) {
                        minLength = minLength2;
                    }
                }
                return minLength;
            case 3:
            case 9:
                if (getMin() >= 0) {
                    return getMin() * getChild(0).getMinLength();
                }
                return 0;
            case 6:
                return getChild(0).getMinLength();
            case 7:
            case 8:
                return 0;
            case 10:
                return getString().length();
            case 12:
                return 0;
            default:
                switch (i5) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        return 0;
                    case 24:
                    case 25:
                        return getChild(0).getMinLength();
                    case 26:
                        if (size() == 0) {
                            return 0;
                        }
                        minLength = getChild(0).getMinLength();
                        while (i7 < size()) {
                            minLength2 = getChild(i7).getMinLength();
                            if (minLength2 < minLength) {
                                minLength = minLength2;
                            }
                        }
                        return minLength;
                    default:
                        throw new RuntimeException("Token#getMinLength(): Invalid Type: " + this.type);
                }
        }
    }

    public int getParenNumber() {
        return 0;
    }

    public int getReferenceNumber() {
        return 0;
    }

    public String getString() {
        return null;
    }

    public void intersectRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public boolean match(int i5) {
        throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
    }

    public void mergeRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public int size() {
        return 0;
    }

    public void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    public void subtractRanges(Token token) {
        throw new RuntimeException("Not supported.");
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int i5) {
        return this.type == 11 ? Consts.DOT : "";
    }

    public static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    public void setMax(int i5) {
    }

    public void setMin(int i5) {
    }

    public static RangeToken getRange(String str, boolean z6, boolean z7) {
        RangeToken range = getRange(str, z6);
        if (z7 && range != null && isRegisterNonXS(str)) {
            return null;
        }
        return range;
    }
}
