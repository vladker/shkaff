package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class OperandClassTransformer {
    private final FormulaType _formulaType;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.OperandClassTransformer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$FormulaType;

        static {
            int[] iArr = new int[FormulaType.values().length];
            $SwitchMap$org$apache$poi$ss$formula$FormulaType = iArr;
            try {
                iArr[FormulaType.CELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.NAMEDRANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaType[FormulaType.DATAVALIDATION_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public OperandClassTransformer(FormulaType formulaType) {
        this._formulaType = formulaType;
    }

    private static boolean isSimpleValueFunction(Ptg ptg) {
        if (!(ptg instanceof AbstractFunctionPtg)) {
            return false;
        }
        AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg) ptg;
        if (abstractFunctionPtg.getDefaultOperandClass() != 32) {
            return false;
        }
        for (int numberOfOperands = abstractFunctionPtg.getNumberOfOperands() - 1; numberOfOperands >= 0; numberOfOperands--) {
            if (abstractFunctionPtg.getParameterClass(numberOfOperands) != 32) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSingleArgSum(Ptg ptg) {
        if (ptg instanceof AttrPtg) {
            return ((AttrPtg) ptg).isSum();
        }
        return false;
    }

    private void setSimpleValueFuncClass(AbstractFunctionPtg abstractFunctionPtg, byte b, boolean z6) {
        if (z6 || b == 64) {
            abstractFunctionPtg.setClass((byte) 64);
        } else {
            abstractFunctionPtg.setClass((byte) 32);
        }
    }

    private byte transformClass(byte b, byte b6, boolean z6) {
        if (b6 == 0) {
            if (z6) {
                return (byte) 0;
            }
            return b;
        }
        if (b6 != 32) {
            if (b6 != 64) {
                throw new IllegalStateException(androidx.collection.a.i(b6, "Unexpected operand class (", ")"));
            }
        } else if (!z6) {
            return (byte) 32;
        }
        return (byte) 64;
    }

    private void transformFunctionNode(AbstractFunctionPtg abstractFunctionPtg, ParseNode[] parseNodeArr, byte b, boolean z6) {
        byte defaultOperandClass = abstractFunctionPtg.getDefaultOperandClass();
        boolean z7 = true;
        if (z6) {
            if (defaultOperandClass != 0) {
                if (defaultOperandClass == 32) {
                    abstractFunctionPtg.setClass((byte) 64);
                } else {
                    if (defaultOperandClass != 64) {
                        throw new IllegalStateException(androidx.collection.a.i(defaultOperandClass, "Unexpected operand class (", ")"));
                    }
                    abstractFunctionPtg.setClass((byte) 64);
                }
            } else if (b == 0) {
                abstractFunctionPtg.setClass((byte) 0);
            } else {
                abstractFunctionPtg.setClass((byte) 64);
            }
            z7 = false;
        } else {
            if (defaultOperandClass == b) {
                abstractFunctionPtg.setClass(defaultOperandClass);
            } else if (b != 0) {
                if (b == 32) {
                    abstractFunctionPtg.setClass((byte) 32);
                } else {
                    if (b != 64) {
                        throw new IllegalStateException(androidx.collection.a.i(b, "Unexpected operand class (", ")"));
                    }
                    if (defaultOperandClass == 0) {
                        abstractFunctionPtg.setClass((byte) 0);
                    } else {
                        if (defaultOperandClass != 32) {
                            throw new IllegalStateException(androidx.collection.a.i(defaultOperandClass, "Unexpected operand class (", ")"));
                        }
                        abstractFunctionPtg.setClass((byte) 64);
                    }
                    if (defaultOperandClass != 32) {
                    }
                }
            } else if (defaultOperandClass == 32) {
                abstractFunctionPtg.setClass((byte) 32);
            } else {
                if (defaultOperandClass != 64) {
                    throw new IllegalStateException(androidx.collection.a.i(defaultOperandClass, "Unexpected operand class (", ")"));
                }
                abstractFunctionPtg.setClass((byte) 64);
            }
            z7 = false;
        }
        for (int i5 = 0; i5 < parseNodeArr.length; i5++) {
            transformNode(parseNodeArr[i5], abstractFunctionPtg.getParameterClass(i5), z7);
        }
    }

    private void transformNode(ParseNode parseNode, byte b, boolean z6) {
        Ptg token = parseNode.getToken();
        ParseNode[] children = parseNode.getChildren();
        int i5 = 0;
        if (isSimpleValueFunction(token)) {
            boolean z7 = b == 64;
            int length = children.length;
            while (i5 < length) {
                transformNode(children[i5], b, z7);
                i5++;
            }
            setSimpleValueFuncClass((AbstractFunctionPtg) token, b, z6);
            return;
        }
        if (isSingleArgSum(token)) {
            token = FuncVarPtg.SUM;
        }
        if ((token instanceof ValueOperatorPtg) || (token instanceof ControlPtg) || (token instanceof MemFuncPtg) || (token instanceof MemAreaPtg) || (token instanceof UnionPtg) || (token instanceof IntersectionPtg)) {
            if (b == 0) {
                b = 32;
            }
            int length2 = children.length;
            while (i5 < length2) {
                transformNode(children[i5], b, z6);
                i5++;
            }
            return;
        }
        if (token instanceof AbstractFunctionPtg) {
            transformFunctionNode((AbstractFunctionPtg) token, children, b, z6);
            return;
        }
        if (children.length > 0) {
            if (token != RangePtg.instance) {
                throw new IllegalStateException("Node should not have any children");
            }
        } else {
            if (token.isBaseToken()) {
                return;
            }
            token.setClass(transformClass(token.getPtgClass(), b, z6));
        }
    }

    public void transformFormula(ParseNode parseNode) {
        byte b;
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$FormulaType[this._formulaType.ordinal()];
        if (i5 == 1) {
            b = 32;
        } else if (i5 == 2) {
            b = 64;
        } else {
            if (i5 != 3 && i5 != 4) {
                throw new RuntimeException("Incomplete code - formula type (" + this._formulaType + ") not supported yet");
            }
            b = 0;
        }
        transformNode(parseNode, b, false);
    }
}
