package org.apache.xmlbeans.impl.regex;

import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class Op {
    static final int ANCHOR = 5;
    static final int BACKREFERENCE = 16;
    static final int CAPTURE = 15;
    static final int CHAR = 1;
    static final int CLOSURE = 7;
    static final int CONDITION = 26;
    static final boolean COUNT = false;
    static final int DOT = 0;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIER = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    static final int NONGREEDYCLOSURE = 8;
    static final int NONGREEDYQUESTION = 10;
    static final int NRANGE = 4;
    static final int QUESTION = 9;
    static final int RANGE = 3;
    static final int STRING = 6;
    static final int UNION = 11;
    static int nofinstances;
    Op next = null;
    int type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CharOp extends Op {
        int charData;

        public CharOp(int i5, int i6) {
            super(i5);
            this.charData = i6;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public int getData() {
            return this.charData;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ChildOp extends Op {
        Op child;

        public ChildOp(int i5) {
            super(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public Op getChild() {
            return this.child;
        }

        public void setChild(Op op) {
            this.child = op;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConditionOp extends Op {
        Op condition;
        Op no;
        int refNumber;
        Op yes;

        public ConditionOp(int i5, int i6, Op op, Op op2, Op op3) {
            super(i5);
            this.refNumber = i6;
            this.condition = op;
            this.yes = op2;
            this.no = op3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ModifierOp extends ChildOp {

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        int f7365v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        int f7366v2;

        public ModifierOp(int i5, int i6, int i7) {
            super(i5);
            this.f7365v1 = i6;
            this.f7366v2 = i7;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public int getData() {
            return this.f7365v1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public int getData2() {
            return this.f7366v2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RangeOp extends Op {
        Token tok;

        public RangeOp(int i5, Token token) {
            super(i5);
            this.tok = token;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public RangeToken getToken() {
            return (RangeToken) this.tok;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringOp extends Op {
        String string;

        public StringOp(int i5, String str) {
            super(i5);
            this.string = str;
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public String getString() {
            return this.string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UnionOp extends Op {
        Vector branches;

        public UnionOp(int i5, int i6) {
            super(i5);
            this.branches = new Vector(i6);
        }

        public void addElement(Op op) {
            this.branches.addElement(op);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public Op elementAt(int i5) {
            return (Op) this.branches.elementAt(i5);
        }

        @Override // org.apache.xmlbeans.impl.regex.Op
        public int size() {
            return this.branches.size();
        }
    }

    public Op(int i5) {
        this.type = i5;
    }

    public static CharOp createAnchor(int i5) {
        return new CharOp(5, i5);
    }

    public static CharOp createBackReference(int i5) {
        return new CharOp(16, i5);
    }

    public static CharOp createCapture(int i5, Op op) {
        CharOp charOp = new CharOp(15, i5);
        charOp.next = op;
        return charOp;
    }

    public static CharOp createChar(int i5) {
        return new CharOp(1, i5);
    }

    public static ChildOp createClosure(int i5) {
        return new ModifierOp(7, i5, -1);
    }

    public static ConditionOp createCondition(Op op, int i5, Op op2, Op op3, Op op4) {
        ConditionOp conditionOp = new ConditionOp(26, i5, op2, op3, op4);
        conditionOp.next = op;
        return conditionOp;
    }

    public static Op createDot() {
        return new Op(0);
    }

    public static ChildOp createIndependent(Op op, Op op2) {
        ChildOp childOp = new ChildOp(24);
        childOp.setChild(op2);
        childOp.next = op;
        return childOp;
    }

    public static ChildOp createLook(int i5, Op op, Op op2) {
        ChildOp childOp = new ChildOp(i5);
        childOp.setChild(op2);
        childOp.next = op;
        return childOp;
    }

    public static ModifierOp createModifier(Op op, Op op2, int i5, int i6) {
        ModifierOp modifierOp = new ModifierOp(25, i5, i6);
        modifierOp.setChild(op2);
        modifierOp.next = op;
        return modifierOp;
    }

    public static ChildOp createNonGreedyClosure() {
        return new ChildOp(8);
    }

    public static ChildOp createQuestion(boolean z6) {
        return new ChildOp(z6 ? 10 : 9);
    }

    public static RangeOp createRange(Token token) {
        return new RangeOp(3, token);
    }

    public static StringOp createString(String str) {
        return new StringOp(6, str);
    }

    public static UnionOp createUnion(int i5) {
        return new UnionOp(11, i5);
    }

    public Op elementAt(int i5) {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public Op getChild() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public int getData() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public int getData2() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public String getString() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public RangeToken getToken() {
        throw new RuntimeException("Internal Error: type=" + this.type);
    }

    public int size() {
        return 0;
    }
}
