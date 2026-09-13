package cn.fly.commons.cc;

import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1407a;
    private int b;
    private s c;
    private int d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private w f1408f;

    public static class a implements t<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Throwable f1409a;
        public Object b;

        public boolean a() {
            return this.f1409a != null;
        }

        @Override // cn.fly.commons.cc.t
        public boolean a(a aVar, Class<a> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
            if ("isError".equals(str) && objArr.length == 0) {
                objArr2[0] = Boolean.valueOf(aVar.a());
                return true;
            }
            if ("getError".equals(str) && objArr.length == 0) {
                objArr2[0] = aVar.f1409a;
                return true;
            }
            if (!"getResult".equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = aVar.b;
            return true;
        }
    }

    public z(String str, int i5, ArrayList<y> arrayList, ArrayList<Object> arrayList2, int i6, int i7, s sVar) {
        this.f1407a = str;
        this.b = i5;
        this.f1408f = new w(arrayList, arrayList2);
        this.d = i6;
        this.e = i7;
        this.c = sVar;
    }

    public z a(s sVar, String str, int i5) {
        if (this.b <= 1) {
            return this;
        }
        ArrayList<y> arrayList = new ArrayList<>();
        a(str, i5, arrayList, 0);
        return new z(null, 1, arrayList, new ArrayList(), 0, arrayList.size(), sVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public LinkedList<Object> b(Object... objArr) {
        s sVarB = this.c.b();
        int i5 = this.b;
        if (i5 != 0) {
            if (objArr.length == i5) {
                for (int length = objArr.length - 1; length >= 0; length--) {
                    sVarB.a(objArr[length]);
                }
            } else if (objArr.length < i5) {
                for (int length2 = objArr.length; length2 < this.b; length2++) {
                    sVarB.a((Object) null);
                }
                for (int length3 = objArr.length - 1; length3 >= 0; length3--) {
                    sVarB.a(objArr[length3]);
                }
            } else {
                ArrayList arrayList = new ArrayList(0);
                for (int i6 = this.b - 1; i6 < objArr.length; i6++) {
                    arrayList.add(objArr[i6]);
                }
                sVarB.a(arrayList);
                for (int i7 = this.b - 2; i7 >= 0; i7--) {
                    sVarB.a(objArr[i7]);
                }
            }
        }
        LinkedList<Object> linkedList = new LinkedList<>();
        this.f1408f.a(this.d, this.e, sVarB, linkedList);
        return linkedList;
    }

    private void a(String str, int i5, ArrayList<y> arrayList, int i6) {
        if (i6 != 0) {
            y yVar = new y(29);
            yVar.b = str;
            yVar.c = i5;
            yVar.f1393i = 1;
            arrayList.add(yVar);
        }
        y yVar2 = new y(1);
        yVar2.b = str;
        yVar2.c = i5;
        StringBuilder sb = new StringBuilder("arg");
        int i7 = i6 + 1;
        sb.append(i7);
        yVar2.f1392h = sb.toString();
        arrayList.add(yVar2);
        int i8 = this.b;
        if (i6 < i8 - 1) {
            a(str, i5, arrayList, i7);
            y yVar3 = new y(28);
            yVar3.b = str;
            yVar3.c = i5;
            arrayList.add(yVar3);
        } else {
            for (int i9 = i8 - 1; i9 >= 0; i9 += -1) {
                y yVar4 = new y(3);
                yVar4.b = str;
                yVar4.c = i5;
                yVar4.f1392h = "arg" + (i9 + 1);
                arrayList.add(yVar4);
            }
            if (this.f1407a == null) {
                y yVar5 = new y(2);
                yVar5.b = str;
                yVar5.c = i5;
                yVar5.f1401q = this;
                arrayList.add(yVar5);
                y yVar6 = new y(32);
                yVar6.b = str;
                yVar6.c = i5;
                yVar6.f1393i = this.b;
                arrayList.add(yVar6);
            } else {
                y yVar7 = new y(31);
                yVar7.b = str;
                yVar7.c = i5;
                yVar7.f1392h = this.f1407a;
                yVar7.f1393i = this.b;
                arrayList.add(yVar7);
            }
            ArrayList<y> arrayListA = this.f1408f.a();
            int size = arrayListA.size();
            int i10 = 0;
            while (i10 < size) {
                y yVar8 = arrayListA.get(i10);
                i10++;
                if (yVar8.f1389a == 28) {
                    y yVar9 = new y(28);
                    yVar9.b = str;
                    yVar9.c = i5;
                    arrayList.add(yVar9);
                    break;
                }
            }
        }
        if (i6 != 0) {
            y yVar10 = new y(30);
            yVar10.b = str;
            yVar10.c = i5;
            arrayList.add(yVar10);
        }
    }

    public a a(Object... objArr) {
        a aVar = new a();
        try {
            LinkedList<Object> linkedListB = b(objArr);
            if (linkedListB.isEmpty()) {
                return aVar;
            }
            aVar.b = linkedListB.get(0);
            return aVar;
        } catch (Throwable th) {
            aVar.f1409a = th;
            return aVar;
        }
    }

    public static z a(String str, int i5, ArrayList<y> arrayList, ArrayList<Object> arrayList2, int i6, int i7, s sVar) {
        return new z(str, i5, arrayList, arrayList2, i6, i7, sVar) { // from class: cn.fly.commons.cc.z.1
            @Override // cn.fly.commons.cc.z
            public LinkedList<Object> b(Object... objArr) {
                return new LinkedList<>();
            }
        };
    }
}
