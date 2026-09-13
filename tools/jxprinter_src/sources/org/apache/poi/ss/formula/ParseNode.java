package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class ParseNode {
    public static final ParseNode[] EMPTY_ARRAY = new ParseNode[0];
    private final ParseNode[] _children;
    private final boolean _isIf;
    private final Ptg _token;
    private final int _tokenCount;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class TokenCollector {
        private int _offset = 0;
        private final Ptg[] _ptgs;

        public TokenCollector(int i5) {
            this._ptgs = new Ptg[i5];
        }

        public void add(Ptg ptg) {
            if (ptg == null) {
                throw new IllegalArgumentException("token must not be null");
            }
            Ptg[] ptgArr = this._ptgs;
            int i5 = this._offset;
            ptgArr[i5] = ptg;
            this._offset = i5 + 1;
        }

        public int createPlaceholder() {
            int i5 = this._offset;
            this._offset = i5 + 1;
            return i5;
        }

        public Ptg[] getResult() {
            return this._ptgs;
        }

        public void setPlaceholder(int i5, Ptg ptg) {
            Ptg[] ptgArr = this._ptgs;
            if (ptgArr[i5] != null) {
                throw new IllegalStateException(androidx.collection.a.i(i5, "Invalid placeholder index (", ")"));
            }
            ptgArr[i5] = ptg;
        }

        public int sumTokenSizes(int i5, int i6) {
            int size = 0;
            while (i5 < i6) {
                size += this._ptgs[i5].getSize();
                i5++;
            }
            return size;
        }
    }

    public ParseNode(Ptg ptg, ParseNode[] parseNodeArr) {
        if (ptg == null) {
            throw new IllegalArgumentException("token must not be null");
        }
        this._token = ptg;
        this._children = (ParseNode[]) parseNodeArr.clone();
        this._isIf = isIf(ptg);
        int tokenCount = 1;
        for (ParseNode parseNode : parseNodeArr) {
            tokenCount += parseNode.getTokenCount();
        }
        this._tokenCount = this._isIf ? tokenCount + parseNodeArr.length : tokenCount;
    }

    private void collectIfPtgs(TokenCollector tokenCollector) {
        getChildren()[0].collectPtgs(tokenCollector);
        int iCreatePlaceholder = tokenCollector.createPlaceholder();
        getChildren()[1].collectPtgs(tokenCollector);
        int iCreatePlaceholder2 = tokenCollector.createPlaceholder();
        AttrPtg attrPtgCreateIf = AttrPtg.createIf(tokenCollector.sumTokenSizes(iCreatePlaceholder + 1, iCreatePlaceholder2) + 4);
        if (getChildren().length > 2) {
            getChildren()[2].collectPtgs(tokenCollector);
            int iCreatePlaceholder3 = tokenCollector.createPlaceholder();
            AttrPtg attrPtgCreateSkip = AttrPtg.createSkip(tokenCollector.sumTokenSizes(iCreatePlaceholder2 + 1, iCreatePlaceholder3) + 7);
            AttrPtg attrPtgCreateSkip2 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(iCreatePlaceholder, attrPtgCreateIf);
            tokenCollector.setPlaceholder(iCreatePlaceholder2, attrPtgCreateSkip);
            tokenCollector.setPlaceholder(iCreatePlaceholder3, attrPtgCreateSkip2);
        } else {
            AttrPtg attrPtgCreateSkip3 = AttrPtg.createSkip(3);
            tokenCollector.setPlaceholder(iCreatePlaceholder, attrPtgCreateIf);
            tokenCollector.setPlaceholder(iCreatePlaceholder2, attrPtgCreateSkip3);
        }
        tokenCollector.add(this._token);
    }

    private void collectPtgs(TokenCollector tokenCollector) {
        if (isIf(this._token)) {
            collectIfPtgs(tokenCollector);
            return;
        }
        Ptg ptg = this._token;
        boolean z6 = (ptg instanceof MemFuncPtg) || (ptg instanceof MemAreaPtg);
        if (z6) {
            tokenCollector.add(ptg);
        }
        for (int i5 = 0; i5 < getChildren().length; i5++) {
            getChildren()[i5].collectPtgs(tokenCollector);
        }
        if (z6) {
            return;
        }
        tokenCollector.add(this._token);
    }

    private int getTokenCount() {
        return this._tokenCount;
    }

    private static boolean isIf(Ptg ptg) {
        if (ptg instanceof FuncVarPtg) {
            return "IF".equals(((FuncVarPtg) ptg).getName());
        }
        return false;
    }

    public static Ptg[] toTokenArray(ParseNode parseNode) {
        TokenCollector tokenCollector = new TokenCollector(parseNode.getTokenCount());
        parseNode.collectPtgs(tokenCollector);
        return tokenCollector.getResult();
    }

    public ParseNode[] getChildren() {
        return this._children;
    }

    public int getEncodedSize() {
        Ptg ptg = this._token;
        int size = ptg instanceof ArrayPtg ? 8 : ptg.getSize();
        for (ParseNode parseNode : this._children) {
            size += parseNode.getEncodedSize();
        }
        return size;
    }

    public Ptg getToken() {
        return this._token;
    }

    public ParseNode(Ptg ptg) {
        this(ptg, EMPTY_ARRAY);
    }

    public ParseNode(Ptg ptg, ParseNode parseNode) {
        this(ptg, new ParseNode[]{parseNode});
    }

    public ParseNode(Ptg ptg, ParseNode parseNode, ParseNode parseNode2) {
        this(ptg, new ParseNode[]{parseNode, parseNode2});
    }
}
