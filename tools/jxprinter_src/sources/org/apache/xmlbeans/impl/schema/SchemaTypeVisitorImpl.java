package org.apache.xmlbeans.impl.schema;

import java.util.Arrays;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaLocalElement;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaTypeVisitorImpl implements TypeStoreVisitor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean CHECK_VALIDITY = false;
    static final boolean PROBE_VALIDITY = true;
    private boolean _isValid;
    private SchemaParticle _matchedParticle;
    private VisitorState[] _rollback;
    private int _rollbackIndex;
    int _rollbackSize;
    private VisitorState[] _stack;
    int _stackSize;
    private VisitorState _top;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class VisitorState {
        int _childCount;
        int _curCount;
        int _curMax;
        int _curMin;
        SchemaParticle _curPart;
        int _processedChildCount;
        boolean[] _seen;

        private VisitorState() {
        }

        public void copy(VisitorState visitorState) {
            this._curPart = visitorState._curPart;
            this._curCount = visitorState._curCount;
            this._curMin = visitorState._curMin;
            this._curMax = visitorState._curMax;
            this._processedChildCount = visitorState._processedChildCount;
            this._childCount = visitorState._childCount;
            boolean[] zArr = visitorState._seen;
            if (zArr != null) {
                boolean[] zArr2 = new boolean[zArr.length];
                this._seen = zArr2;
                boolean[] zArr3 = visitorState._seen;
                System.arraycopy(zArr3, 0, zArr2, 0, zArr3.length);
            }
        }

        public void init(SchemaParticle schemaParticle) {
            this._curPart = schemaParticle;
            this._curMin = schemaParticle.getIntMinOccurs();
            this._curMax = schemaParticle.getIntMaxOccurs();
            this._curCount = 0;
            this._processedChildCount = 0;
            this._childCount = schemaParticle.countOfParticleChild();
            this._seen = schemaParticle.getParticleType() == 1 ? new boolean[this._childCount] : null;
        }
    }

    public SchemaTypeVisitorImpl(SchemaParticle schemaParticle) {
        init(schemaParticle);
    }

    public void addParticle(SchemaParticle schemaParticle) {
        VisitorState[] visitorStateArr = this._stack;
        if (visitorStateArr.length == this._stackSize) {
            this._stack = expand(visitorStateArr);
        }
        this._stack[this._stackSize].init(schemaParticle);
        this._stackSize++;
    }

    public void commit() {
        this._top = null;
        this._rollbackIndex = this._stackSize;
        this._rollbackSize = 0;
    }

    public SchemaParticle currentParticle() {
        return this._matchedParticle;
    }

    public VisitorState[] expand(VisitorState[] visitorStateArr) {
        int length = visitorStateArr == null ? 4 : visitorStateArr.length * 2;
        VisitorState[] visitorStateArr2 = new VisitorState[length];
        if (visitorStateArr != null) {
            System.arraycopy(visitorStateArr, 0, visitorStateArr2, 0, visitorStateArr.length);
        }
        for (int length2 = visitorStateArr != null ? visitorStateArr.length : 0; length2 < length; length2++) {
            visitorStateArr2[length2] = new VisitorState();
        }
        return visitorStateArr2;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public String get_default_text() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return null;
        }
        return ((SchemaLocalElement) currentParticle()).getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public int get_elementflags() {
        if (currentParticle() == null || currentParticle().getParticleType() != 4) {
            return 0;
        }
        SchemaLocalElement schemaLocalElement = (SchemaLocalElement) currentParticle();
        return (schemaLocalElement.isNillable() ? 1 : 0) | (schemaLocalElement.isDefault() ? 2 : 0) | (schemaLocalElement.isFixed() ? 4 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public SchemaField get_schema_field() {
        if (currentParticle() instanceof SchemaField) {
            return (SchemaField) currentParticle();
        }
        return null;
    }

    public void init(SchemaParticle schemaParticle) {
        if (this._stack == null) {
            this._stack = expand(null);
        }
        if (this._rollback == null) {
            this._rollback = expand(null);
        }
        this._stackSize = 0;
        this._rollbackSize = 0;
        if (schemaParticle != null) {
            push(schemaParticle);
            this._rollbackIndex = 1;
        }
    }

    public boolean isAllValid() {
        return this._isValid;
    }

    public boolean notValid() {
        this._isValid = false;
        this._matchedParticle = null;
        rollback();
        return false;
    }

    public boolean ok(SchemaParticle schemaParticle, boolean z6) {
        if (z6) {
            rollback();
            return true;
        }
        this._matchedParticle = schemaParticle;
        commit();
        return true;
    }

    public boolean pop() {
        int i5 = this._stackSize - 1;
        this._stackSize = i5;
        if (i5 <= this._rollbackIndex) {
            return prepare();
        }
        this._top = topRef();
        return true;
    }

    public boolean prepare() {
        if (this._rollbackIndex == 0) {
            this._top = null;
            return false;
        }
        VisitorState visitorState = topRef();
        this._top = visitorState;
        saveCopy(visitorState);
        this._rollbackIndex = this._stackSize - 1;
        return true;
    }

    public void push(SchemaParticle schemaParticle) {
        addParticle(schemaParticle);
        this._top = topRef();
    }

    public void rollback() {
        while (true) {
            int i5 = this._rollbackSize;
            if (i5 <= 0) {
                this._stackSize = this._rollbackIndex;
                this._top = null;
                return;
            }
            int i6 = i5 - 1;
            this._rollbackSize = i6;
            VisitorState[] visitorStateArr = this._stack;
            int i7 = this._rollbackIndex;
            VisitorState visitorState = visitorStateArr[i7];
            VisitorState[] visitorStateArr2 = this._rollback;
            visitorStateArr[i7] = visitorStateArr2[i6];
            visitorStateArr2[i6] = visitorState;
            this._rollbackIndex = i7 + 1;
        }
    }

    public void saveCopy(VisitorState visitorState) {
        VisitorState[] visitorStateArr = this._rollback;
        if (visitorStateArr.length == this._rollbackSize) {
            this._rollback = expand(visitorStateArr);
        }
        this._rollback[this._rollbackSize].copy(visitorState);
        this._rollbackSize++;
    }

    public boolean testValid(QName qName) {
        return visit(qName, true);
    }

    public VisitorState topRef() {
        return this._stack[this._stackSize - 1];
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStoreVisitor
    public boolean visit(QName qName) {
        return visit(qName, false);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0156 A[EDGE_INSN: B:112:0x0156->B:92:0x0156 BREAK  A[LOOP:0: B:7:0x000d->B:122:0x000d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x000d A[SYNTHETIC] */
    public boolean visit(QName qName, boolean z6) {
        VisitorState visitorState;
        if (!prepare()) {
            return notValid();
        }
        int i5 = -2;
        int i6 = -2;
        loop0: while (true) {
            VisitorState visitorState2 = this._top;
            if (visitorState2._curCount > visitorState2._curMin && i5 == visitorState2._processedChildCount && i6 == this._stackSize) {
                visitorState2._curCount = visitorState2._curMax;
            }
            i5 = visitorState2._processedChildCount;
            i6 = this._stackSize;
            while (true) {
                visitorState = this._top;
                if (visitorState._curCount >= visitorState._curMax) {
                    if (!pop()) {
                        break loop0;
                    }
                }
            }
            int particleType = visitorState._curPart.getParticleType();
            int i7 = 0;
            if (particleType == 1) {
                int i8 = this._top._processedChildCount;
                int i9 = 0;
                while (true) {
                    VisitorState visitorState3 = this._top;
                    int i10 = visitorState3._childCount;
                    if (i9 < i10) {
                        if (!visitorState3._seen[i9]) {
                            SchemaParticle particleChild = visitorState3._curPart.getParticleChild(i9);
                            if (particleChild.canStartWithElement(qName)) {
                                VisitorState visitorState4 = this._top;
                                visitorState4._processedChildCount++;
                                visitorState4._seen[i9] = true;
                                push(particleChild);
                            } else if (particleChild.isSkippable()) {
                                i8++;
                            }
                        }
                        i9++;
                    } else if (i8 < i10) {
                        if (visitorState3._curCount < visitorState3._curMin) {
                            return notValid();
                        }
                        if (!pop()) {
                            break;
                            break;
                        }
                    } else {
                        visitorState3._curCount++;
                        visitorState3._processedChildCount = 0;
                        Arrays.fill(visitorState3._seen, false);
                    }
                }
            } else if (particleType != 2) {
                if (particleType == 3) {
                    int i11 = this._top._processedChildCount;
                    while (true) {
                        VisitorState visitorState5 = this._top;
                        if (i11 < visitorState5._childCount) {
                            SchemaParticle particleChild2 = visitorState5._curPart.getParticleChild(i11);
                            if (particleChild2.canStartWithElement(qName)) {
                                this._top._processedChildCount = i11 + 1;
                                push(particleChild2);
                            } else if (particleChild2.isSkippable()) {
                                i11++;
                            } else {
                                VisitorState visitorState6 = this._top;
                                if (visitorState6._processedChildCount != 0 || visitorState6._curCount < visitorState6._curMin) {
                                    return notValid();
                                }
                            }
                        } else {
                            visitorState5._curCount++;
                            visitorState5._processedChildCount = 0;
                        }
                    }
                } else if (particleType != 4) {
                    if (this._top._curPart.canStartWithElement(qName)) {
                        VisitorState visitorState7 = this._top;
                        visitorState7._curCount++;
                        return ok(visitorState7._curPart, z6);
                    }
                    VisitorState visitorState8 = this._top;
                    if (visitorState8._curCount < visitorState8._curMin) {
                        return notValid();
                    }
                } else {
                    if (this._top._curPart.canStartWithElement(qName)) {
                        VisitorState visitorState9 = this._top;
                        visitorState9._curCount++;
                        return ok(visitorState9._curPart, z6);
                    }
                    VisitorState visitorState10 = this._top;
                    if (visitorState10._curCount < visitorState10._curMin) {
                        return notValid();
                    }
                }
                if (!pop()) {
                    break;
                }
            } else {
                while (true) {
                    VisitorState visitorState11 = this._top;
                    if (i7 < visitorState11._childCount) {
                        SchemaParticle particleChild3 = visitorState11._curPart.getParticleChild(i7);
                        if (particleChild3.canStartWithElement(qName)) {
                            this._top._curCount++;
                            push(particleChild3);
                        } else {
                            i7++;
                        }
                    } else {
                        if (visitorState11._curCount < visitorState11._curMin && !visitorState11._curPart.isSkippable()) {
                            return notValid();
                        }
                        if (!pop()) {
                            break;
                            break;
                        }
                    }
                }
            }
        }
        return qName == null ? ok(null, z6) : notValid();
    }

    public SchemaTypeVisitorImpl() {
    }
}
