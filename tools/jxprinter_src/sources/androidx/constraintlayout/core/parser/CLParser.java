package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i5, TYPE type, boolean z6, char[] cArr) {
        CLElement cLElementAllocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i5]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i5++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i5++;
                break;
            case 3:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.mLineNumber);
        if (z6) {
            cLElementAllocate.setStart(i5);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i5, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
            if (c == '\"' || c == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i5, TYPE.KEY, true, cArr) : createElement(cLElement, i5, TYPE.STRING, true, cArr);
            }
            if (c == '[') {
                return createElement(cLElement, i5, TYPE.ARRAY, true, cArr);
            }
            if (c != ']') {
                if (c == '{') {
                    return createElement(cLElement, i5, TYPE.OBJECT, true, cArr);
                }
                if (c != '}') {
                    switch (c) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i5, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i6 = i5 + 1;
                            if (i6 >= cArr.length || cArr[i6] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i5, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementCreateElement = createElement(cLElement, i5, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementCreateElement;
                            if (cLToken.validate(c, i5)) {
                                return cLElementCreateElement;
                            }
                            throw new CLParsingException("incorrect token <" + c + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i5 - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i5);
            return container;
        }
        return cLElement;
    }

    public static CLObject parse(String str) {
        return new CLParser(str).parse();
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0050 A[EDGE_INSN: B:108:0x0050->B:24:0x0050 BREAK  A[LOOP:1: B:14:0x0036->B:89:0x014b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x014b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x0120  */
    /* JADX WARN: Code duplicated, block: B:81:0x012b  */
    /* JADX WARN: Code duplicated, block: B:84:0x0138  */
    public CLObject parse() throws CLParsingException {
        boolean z6;
        long j6;
        char c;
        long j7;
        CLToken cLToken;
        long j8;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i5 = 1;
        this.mLineNumber = 1;
        boolean z7 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                i6 = -1;
                break;
            }
            char c6 = charArray[i6];
            if (c6 == '{') {
                break;
            }
            if (c6 == '\n') {
                this.mLineNumber++;
            }
            i6++;
        }
        if (i6 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.mLineNumber);
        cLObjectAllocate.setStart(i6);
        int i7 = i6 + 1;
        CLElement container = cLObjectAllocate;
        while (i7 < length) {
            char c7 = charArray[i7];
            if (c7 == '\n') {
                this.mLineNumber += i5;
            }
            if (this.mHasComment) {
                if (c7 == '\n') {
                    this.mHasComment = z7;
                    if (container == null) {
                        break;
                        break;
                    }
                    if (container.isDone()) {
                        container = getNextJsonElement(i7, c7, container, charArray);
                    } else if (container instanceof CLObject) {
                        if (c7 == '}') {
                            container.setEnd(i7 - 1);
                        } else {
                            container = getNextJsonElement(i7, c7, container, charArray);
                        }
                    } else if (container instanceof CLArray) {
                        z6 = container instanceof CLString;
                        if (z6) {
                            j8 = container.mStart;
                            if (charArray[(int) j8] == c7) {
                                container.setStart(j8 + 1);
                                container.setEnd(i7 - 1);
                            }
                        } else {
                            if (container instanceof CLToken) {
                                cLToken = (CLToken) container;
                                if (!cLToken.validate(c7, i7)) {
                                    throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                                }
                            }
                            if (container instanceof CLKey) {
                                j6 = container.mStart;
                                c = charArray[(int) j6];
                                if (c != '\'') {
                                    container.setStart(j6 + 1);
                                    container.setEnd(i7 - 1);
                                } else {
                                    container.setStart(j6 + 1);
                                    container.setEnd(i7 - 1);
                                }
                            } else {
                                j6 = container.mStart;
                                c = charArray[(int) j6];
                                if (c != '\'') {
                                    container.setStart(j6 + 1);
                                    container.setEnd(i7 - 1);
                                } else {
                                    container.setStart(j6 + 1);
                                    container.setEnd(i7 - 1);
                                }
                            }
                            if (!container.isDone()) {
                                j7 = i7 - 1;
                                container.setEnd(j7);
                                if (c7 != '}') {
                                    container = container.getContainer();
                                    container.setEnd(j7);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j7);
                                    }
                                } else {
                                    container = container.getContainer();
                                    container.setEnd(j7);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j7);
                                    }
                                }
                            }
                        }
                        if (!container.isDone()) {
                        }
                    } else if (c7 == ']') {
                        container.setEnd(i7 - 1);
                    } else {
                        container = getNextJsonElement(i7, c7, container, charArray);
                    }
                    i5 = i5;
                    if (!container.isDone()) {
                    }
                } else {
                    i5 = i5;
                }
            } else {
                if (container == null) {
                    break;
                }
                if (container.isDone()) {
                    container = getNextJsonElement(i7, c7, container, charArray);
                } else if (container instanceof CLObject) {
                    if (c7 == '}') {
                        container.setEnd(i7 - 1);
                    } else {
                        container = getNextJsonElement(i7, c7, container, charArray);
                    }
                } else if (container instanceof CLArray) {
                    z6 = container instanceof CLString;
                    if (z6) {
                        j8 = container.mStart;
                        if (charArray[(int) j8] == c7) {
                            container.setStart(j8 + 1);
                            container.setEnd(i7 - 1);
                        }
                    } else {
                        if (container instanceof CLToken) {
                            cLToken = (CLToken) container;
                            if (!cLToken.validate(c7, i7)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                            }
                        }
                        if ((container instanceof CLKey) || z6) {
                            j6 = container.mStart;
                            c = charArray[(int) j6];
                            if ((c != '\'' || c == '\"') && c == c7) {
                                container.setStart(j6 + 1);
                                container.setEnd(i7 - 1);
                            }
                        }
                        if (!container.isDone() && (c7 == '}' || c7 == ']' || c7 == ',' || c7 == ' ' || c7 == '\t' || c7 == '\r' || c7 == '\n' || c7 == ':')) {
                            j7 = i7 - 1;
                            container.setEnd(j7);
                            if (c7 != '}' || c7 == ']') {
                                container = container.getContainer();
                                container.setEnd(j7);
                                if (container instanceof CLKey) {
                                    container = container.getContainer();
                                    container.setEnd(j7);
                                }
                            }
                        }
                    }
                    if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                        container = container.getContainer();
                    }
                } else if (c7 == ']') {
                    container.setEnd(i7 - 1);
                } else {
                    container = getNextJsonElement(i7, c7, container, charArray);
                }
                i5 = i5;
                if (!container.isDone()) {
                }
            }
            i7++;
            i5 = i5;
            z7 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.mStart) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }
}
