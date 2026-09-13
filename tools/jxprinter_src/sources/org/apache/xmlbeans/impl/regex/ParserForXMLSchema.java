package org.apache.xmlbeans.impl.regex;

import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class ParserForXMLSchema extends RegexParser {
    private static final String DIGITS = "09٠٩۰۹०९০৯੦੯૦૯୦୯௧௯౦౯೦೯൦൯๐๙໐໙༠༩";
    private static final String LETTERS = "AZazÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁΆΆΈΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆאתװײءغفيٱڷںھۀێېۓەەۥۦअहऽऽक़ॡঅঌএঐওনপরললশহড়ঢ়য়ৡৰৱਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹਖ਼ੜਫ਼ਫ਼ੲੴઅઋઍઍએઑઓનપરલળવહઽઽૠૠଅଌଏଐଓନପରଲଳଶହଽଽଡ଼ଢ଼ୟୡஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹఅఌఎఐఒనపళవహౠౡಅಌಎಐಒನಪಳವಹೞೞೠೡഅഌഎഐഒനപഹൠൡกฮะะาำเๅກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະະາຳຽຽເໄཀཇཉཀྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼΩΩKÅ℮℮ↀↂ〇〇〡〩ぁゔァヺㄅㄬ一龥가힣";
    private static final String NAMECHARS = "-.0:AZ__az··ÀÖØöøıĴľŁňŊžƀǃǍǰǴǵǺȗɐʨʻˁːˑ̀͠͡ͅΆΊΌΌΎΡΣώϐϖϚϚϜϜϞϞϠϠϢϳЁЌЎяёќўҁ҃҆ҐӄӇӈӋӌӐӫӮӵӸӹԱՖՙՙաֆֹֻֽֿֿׁׂ֑֣֡ׄׄאתװײءغـْ٠٩ٰڷںھۀێېۓە۪ۭۨ۰۹ँःअह़्॑॔क़ॣ०९ঁঃঅঌএঐওনপরললশহ়়াৄেৈো্ৗৗড়ঢ়য়ৣ০ৱਂਂਅਊਏਐਓਨਪਰਲਲ਼ਵਸ਼ਸਹ਼਼ਾੂੇੈੋ੍ਖ਼ੜਫ਼ਫ਼੦ੴઁઃઅઋઍઍએઑઓનપરલળવહ઼ૅેૉો્ૠૠ૦૯ଁଃଅଌଏଐଓନପରଲଳଶହ଼ୃେୈୋ୍ୖୗଡ଼ଢ଼ୟୡ୦୯ஂஃஅஊஎஐஒகஙசஜஜஞடணதநபமவஷஹாூெைொ்ௗௗ௧௯ఁఃఅఌఎఐఒనపళవహాౄెైొ్ౕౖౠౡ౦౯ಂಃಅಌಎಐಒನಪಳವಹಾೄೆೈೊ್ೕೖೞೞೠೡ೦೯ംഃഅഌഎഐഒനപഹാൃെൈൊ്ൗൗൠൡ൦൯กฮะฺเ๎๐๙ກຂຄຄງຈຊຊຍຍດທນຟມຣລລວວສຫອຮະູົຽເໄໆໆ່ໍ໐໙༘༙༠༩༹༹༵༵༷༷༾ཇཉཀྵ྄ཱ྆ྋྐྕྗྗྙྭྱྷྐྵྐྵႠჅაჶᄀᄀᄂᄃᄅᄇᄉᄉᄋᄌᄎᄒᄼᄼᄾᄾᅀᅀᅌᅌᅎᅎᅐᅐᅔᅕᅙᅙᅟᅡᅣᅣᅥᅥᅧᅧᅩᅩᅭᅮᅲᅳᅵᅵᆞᆞᆨᆨᆫᆫᆮᆯᆷᆸᆺᆺᆼᇂᇫᇫᇰᇰᇹᇹḀẛẠỹἀἕἘἝἠὅὈὍὐὗὙὙὛὛὝὝὟώᾀᾴᾶᾼιιῂῄῆῌῐΐῖΊῠῬῲῴῶῼ⃐⃜⃡⃡ΩΩKÅ℮℮ↀↂ々々〇〇〡〯〱〵ぁゔ゙゚ゝゞァヺーヾㄅㄬ一龥가힣";
    private static final String SPACES = "\t\n\r\r  ";
    private static Hashtable ranges;
    private static Hashtable ranges2;

    public ParserForXMLSchema() {
    }

    public static synchronized RangeToken getRange(String str, boolean z6) {
        try {
            if (ranges == null) {
                ranges = new Hashtable();
                ranges2 = new Hashtable();
                RangeToken rangeTokenCreateRange = Token.createRange();
                setupRange(rangeTokenCreateRange, SPACES);
                ranges.put("xml:isSpace", rangeTokenCreateRange);
                ranges2.put("xml:isSpace", Token.complementRanges(rangeTokenCreateRange));
                RangeToken rangeTokenCreateRange2 = Token.createRange();
                setupRange(rangeTokenCreateRange2, DIGITS);
                ranges.put("xml:isDigit", rangeTokenCreateRange2);
                ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange2));
                RangeToken rangeTokenCreateRange3 = Token.createRange();
                setupRange(rangeTokenCreateRange3, DIGITS);
                ranges.put("xml:isDigit", rangeTokenCreateRange3);
                ranges2.put("xml:isDigit", Token.complementRanges(rangeTokenCreateRange3));
                RangeToken rangeTokenCreateRange4 = Token.createRange();
                setupRange(rangeTokenCreateRange4, LETTERS);
                rangeTokenCreateRange4.mergeRanges((Token) ranges.get("xml:isDigit"));
                ranges.put("xml:isWord", rangeTokenCreateRange4);
                ranges2.put("xml:isWord", Token.complementRanges(rangeTokenCreateRange4));
                RangeToken rangeTokenCreateRange5 = Token.createRange();
                setupRange(rangeTokenCreateRange5, NAMECHARS);
                ranges.put("xml:isNameChar", rangeTokenCreateRange5);
                ranges2.put("xml:isNameChar", Token.complementRanges(rangeTokenCreateRange5));
                RangeToken rangeTokenCreateRange6 = Token.createRange();
                setupRange(rangeTokenCreateRange6, LETTERS);
                rangeTokenCreateRange6.addRange(95, 95);
                rangeTokenCreateRange6.addRange(58, 58);
                ranges.put("xml:isInitialNameChar", rangeTokenCreateRange6);
                ranges2.put("xml:isInitialNameChar", Token.complementRanges(rangeTokenCreateRange6));
            }
        } catch (Throwable th) {
            throw th;
        }
        return z6 ? (RangeToken) ranges.get(str) : (RangeToken) ranges2.get(str);
    }

    public static void setupRange(Token token, String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5 += 2) {
            token.addRange(str.charAt(i5), str.charAt(i5 + 1));
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public boolean checkQuestion(int i5) {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003d A[FALL_THROUGH, RETURN] */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public int decodeEscaped() {
        if (read() != 10) {
            throw ex("parser.next.1", this.offset - 1);
        }
        int i5 = this.chardata;
        if (i5 != 45 && i5 != 46 && i5 != 63) {
            if (i5 == 110) {
                return 10;
            }
            if (i5 == 114) {
                return 13;
            }
            if (i5 == 116) {
                return 9;
            }
            switch (i5) {
                default:
                    switch (i5) {
                        default:
                            switch (i5) {
                                case 123:
                                case 124:
                                case 125:
                                    break;
                                default:
                                    throw ex("parser.process.1", this.offset - 2);
                            }
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                            return i5;
                    }
                case 40:
                case 41:
                case 42:
                case 43:
                    return i5;
            }
        }
        return i5;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token getTokenForShorthand(int i5) {
        if (i5 == 67) {
            return getRange("xml:isNameChar", false);
        }
        if (i5 == 68) {
            return getRange("xml:isDigit", false);
        }
        if (i5 == 73) {
            return getRange("xml:isInitialNameChar", false);
        }
        if (i5 == 83) {
            return getRange("xml:isSpace", false);
        }
        if (i5 == 87) {
            return getRange("xml:isWord", false);
        }
        if (i5 == 105) {
            return getRange("xml:isInitialNameChar", true);
        }
        if (i5 == 115) {
            return getRange("xml:isSpace", true);
        }
        if (i5 == 119) {
            return getRange("xml:isWord", true);
        }
        if (i5 == 99) {
            return getRange("xml:isNameChar", true);
        }
        if (i5 == 100) {
            return getRange("xml:isDigit", true);
        }
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(i5, 16));
    }

    /* JADX WARN: Code duplicated, block: B:126:0x0189  */
    /* JADX WARN: Code duplicated, block: B:139:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e6  */
    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public RangeToken parseCharacterClass(boolean z6) {
        RangeToken rangeTokenCreateRange;
        RangeToken rangeTokenCreateRange2;
        boolean z7;
        boolean z8;
        setContext(1);
        next();
        boolean z9 = false;
        if (read() == 0 && this.chardata == 94) {
            next();
            rangeTokenCreateRange2 = Token.createRange();
            rangeTokenCreateRange2.addRange(0, 1114111);
            rangeTokenCreateRange = Token.createRange();
            z7 = true;
        } else {
            rangeTokenCreateRange = Token.createRange();
            rangeTokenCreateRange2 = null;
            z7 = false;
        }
        boolean z10 = true;
        while (true) {
            int i5 = read();
            if (i5 != 1) {
                if (i5 != 0 || this.chardata != 93 || z10) {
                    int iProcessCIinCharacterClass = this.chardata;
                    if (i5 != 10) {
                        if (i5 == 24 && !z10) {
                            if (z7) {
                                rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                            } else {
                                rangeTokenCreateRange2 = rangeTokenCreateRange;
                            }
                            rangeTokenCreateRange2.subtractRanges(parseCharacterClass(z9));
                            if (read() == 0 && this.chardata == 93) {
                                break;
                            }
                            throw ex("parser.cc.5", this.offset);
                        }
                    } else {
                        if (iProcessCIinCharacterClass == 67) {
                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                            if (iProcessCIinCharacterClass < 0) {
                                z8 = true;
                            }
                        } else {
                            if (iProcessCIinCharacterClass == 68) {
                                rangeTokenCreateRange.mergeRanges(getTokenForShorthand(iProcessCIinCharacterClass));
                            } else if (iProcessCIinCharacterClass == 73) {
                                iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                if (iProcessCIinCharacterClass < 0) {
                                }
                            } else {
                                if (iProcessCIinCharacterClass != 80) {
                                    if (iProcessCIinCharacterClass != 83 && iProcessCIinCharacterClass != 87) {
                                        if (iProcessCIinCharacterClass == 105) {
                                            iProcessCIinCharacterClass = processCIinCharacterClass(rangeTokenCreateRange, iProcessCIinCharacterClass);
                                            if (iProcessCIinCharacterClass < 0) {
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
                            z8 = true;
                        }
                        next();
                        if (z8) {
                            if (i5 == 0) {
                                if (iProcessCIinCharacterClass != 91) {
                                    throw ex("parser.cc.6", this.offset - 2);
                                }
                                if (iProcessCIinCharacterClass != 93) {
                                    throw ex("parser.cc.7", this.offset - 2);
                                }
                                if (iProcessCIinCharacterClass == 45 && !z10 && this.chardata != 93) {
                                    throw ex("parser.cc.8", this.offset - 2);
                                }
                            }
                            if (read() == 0 || this.chardata != 45) {
                                rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                            } else {
                                next();
                                int i7 = read();
                                if (i7 == 1) {
                                    throw ex("parser.cc.2", this.offset);
                                }
                                if (i7 == 24) {
                                    throw ex("parser.cc.8", this.offset - 1);
                                }
                                if (i7 == 0 && this.chardata == 93) {
                                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                                    rangeTokenCreateRange.addRange(45, 45);
                                } else {
                                    int iDecodeEscaped = this.chardata;
                                    if (i7 == 0) {
                                        if (iDecodeEscaped == 91) {
                                            throw ex("parser.cc.6", this.offset - 1);
                                        }
                                        if (iDecodeEscaped == 93) {
                                            throw ex("parser.cc.7", this.offset - 1);
                                        }
                                        if (iDecodeEscaped == 45) {
                                            next();
                                            if (this.chardata != 93) {
                                                throw ex("parser.cc.8", this.offset - 2);
                                            }
                                        }
                                    } else if (i7 == 10) {
                                        iDecodeEscaped = decodeEscaped();
                                    }
                                    if (iDecodeEscaped != 45 || this.chardata != 93) {
                                        next();
                                    }
                                    if (iProcessCIinCharacterClass > iDecodeEscaped) {
                                        throw ex("parser.ope.3", this.offset - 1);
                                    }
                                    rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iDecodeEscaped);
                                }
                            }
                        }
                        z9 = false;
                        z10 = false;
                    }
                    z8 = z9;
                    next();
                    if (z8) {
                        if (i5 == 0) {
                            if (iProcessCIinCharacterClass != 91) {
                                throw ex("parser.cc.6", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass != 93) {
                                throw ex("parser.cc.7", this.offset - 2);
                            }
                            if (iProcessCIinCharacterClass == 45) {
                                throw ex("parser.cc.8", this.offset - 2);
                            }
                        }
                        if (read() == 0) {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        } else {
                            rangeTokenCreateRange.addRange(iProcessCIinCharacterClass, iProcessCIinCharacterClass);
                        }
                    }
                    z9 = false;
                    z10 = false;
                } else if (z7) {
                    rangeTokenCreateRange2.subtractRanges(rangeTokenCreateRange);
                    break;
                }
            }
            rangeTokenCreateRange2 = rangeTokenCreateRange;
            break;
        }
        if (read() == 1) {
            throw ex("parser.cc.2", this.offset);
        }
        rangeTokenCreateRange2.sortRanges();
        rangeTokenCreateRange2.compactRanges();
        setContext(0);
        next();
        return rangeTokenCreateRange2;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public RangeToken parseSetOperations() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBackreference() {
        throw ex("parser.process.1", this.offset - 4);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_A() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_B() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_C() {
        next();
        return getTokenForShorthand(67);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_I() {
        next();
        return getTokenForShorthand(73);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_X() {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_Z() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_b() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_c() {
        next();
        return getTokenForShorthand(99);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_g() {
        throw ex("parser.process.1", this.offset - 2);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_gt() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_i() {
        next();
        return getTokenForShorthand(105);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_lt() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processBacksolidus_z() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public int processCIinCharacterClass(RangeToken rangeToken, int i5) {
        rangeToken.mergeRanges(getTokenForShorthand(i5));
        return -1;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processCaret() {
        next();
        return Token.createChar(94);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processCondition() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processDollar() {
        next();
        return Token.createChar(36);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processIndependent() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processLookahead() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processLookbehind() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processModifiers() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processNegativelookahead() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processNegativelookbehind() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processParen() {
        next();
        Token.ParenToken parenTokenCreateParen = Token.createParen(parseRegex(), 0);
        if (read() != 7) {
            throw ex("parser.factor.1", this.offset - 1);
        }
        next();
        return parenTokenCreateParen;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processParen2() {
        throw ex("parser.process.1", this.offset);
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processPlus(Token token) {
        next();
        return Token.createConcat(token, Token.createClosure(token));
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processQuestion(Token token) {
        next();
        Token.UnionToken unionTokenCreateUnion = Token.createUnion();
        unionTokenCreateUnion.addChild(token);
        unionTokenCreateUnion.addChild(Token.createEmpty());
        return unionTokenCreateUnion;
    }

    @Override // org.apache.xmlbeans.impl.regex.RegexParser
    public Token processStar(Token token) {
        next();
        return Token.createClosure(token);
    }

    public ParserForXMLSchema(Locale locale) {
    }
}
