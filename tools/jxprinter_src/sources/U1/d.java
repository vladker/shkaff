package U1;

import com.alibaba.android.arouter.core.InterceptorServiceImpl;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.thread.CancelableCountDownLatch;
import p050j.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements InterceptorCallback, p050j.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f709a;
    public int b;
    public Object c;
    public Object d;

    public d(int i5) {
        this.f709a = i5;
        switch (i5) {
            case 1:
                this.c = null;
                this.d = null;
                this.b = 0;
                break;
        }
    }

    @Override // p050j.h
    public boolean a(r rVar, Object obj) {
        String str = (String) this.d;
        Object objD = rVar.d(obj, (String) this.c);
        int i5 = this.b;
        if (i5 == 1) {
            return str.equals(objD);
        }
        if (i5 == 2) {
            return !str.equals(objD);
        }
        if (objD == null) {
            return false;
        }
        int iCompareTo = str.compareTo(objD.toString());
        if (i5 == 4) {
            if (iCompareTo > 0) {
                return false;
            }
        } else if (i5 == 3) {
            if (iCompareTo >= 0) {
                return false;
            }
        } else if (i5 == 6) {
            if (iCompareTo < 0) {
                return false;
            }
        } else if (i5 != 5 || iCompareTo <= 0) {
            return false;
        }
        return true;
    }

    public void b(Object obj) {
        W1.a aVar = (W1.a) this.d;
        W1.a aVar2 = new W1.a();
        aVar2.f784a = null;
        aVar2.b = null;
        aVar2.c = obj;
        int i5 = this.b;
        if (i5 == 0) {
            this.c = aVar2;
            this.d = aVar2;
        } else {
            aVar2.b = aVar;
            aVar.f784a = aVar2;
            this.d = aVar2;
        }
        this.b = i5 + 1;
    }

    public void c(Object obj) {
        W1.a aVar = (W1.a) this.c;
        W1.a aVar2 = new W1.a();
        aVar2.f784a = null;
        aVar2.b = null;
        aVar2.c = obj;
        int i5 = this.b;
        if (i5 == 0) {
            this.c = aVar2;
            this.d = aVar2;
        } else {
            aVar2.f784a = aVar;
            aVar.b = aVar2;
            this.c = aVar2;
        }
        this.b = i5 + 1;
    }

    public Object d(W1.a aVar) {
        int i5 = this.b;
        if (i5 == 0) {
            return null;
        }
        Object obj = aVar.c;
        W1.a aVar2 = (W1.a) this.c;
        if (aVar == aVar2) {
            W1.a aVar3 = (W1.a) aVar2.f784a;
            this.c = aVar3;
            if (aVar3 == null) {
                this.d = null;
            } else {
                aVar3.b = null;
            }
        } else {
            W1.a aVar4 = (W1.a) this.d;
            if (aVar == aVar4) {
                W1.a aVar5 = (W1.a) aVar4.b;
                this.d = aVar5;
                aVar5.f784a = null;
            } else {
                W1.a aVar6 = (W1.a) aVar.b;
                aVar6.f784a = (W1.a) aVar.f784a;
                ((W1.a) aVar.f784a).b = aVar6;
            }
        }
        this.b = i5 - 1;
        return obj;
    }

    public void e(String str, V1.a aVar) {
        int i5 = 0;
        while (true) {
            int i6 = this.b;
            if (i5 >= i6) {
                if (i6 == ((String[]) this.c).length) {
                    int i7 = i6 * 2;
                    String[] strArr = new String[i7];
                    V1.a[] aVarArr = new V1.a[i7];
                    for (int i8 = 0; i8 < this.b; i8++) {
                        strArr[i8] = ((String[]) this.c)[i8];
                        aVarArr[i8] = ((V1.a[]) this.d)[i8];
                    }
                    this.c = strArr;
                    this.d = aVarArr;
                }
                String[] strArr2 = (String[]) this.c;
                int i9 = this.b;
                strArr2[i9] = str;
                ((V1.a[]) this.d)[i9] = aVar;
                this.b = i9 + 1;
                return;
            }
            if (((String[]) this.c)[i5].equalsIgnoreCase(str)) {
                ((V1.a[]) this.d)[i5] = aVar;
                return;
            }
            i5++;
        }
    }

    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
    public void onContinue(Postcard postcard) {
        CancelableCountDownLatch cancelableCountDownLatch = (CancelableCountDownLatch) this.c;
        cancelableCountDownLatch.countDown();
        InterceptorServiceImpl._execute(this.b + 1, cancelableCountDownLatch, postcard);
    }

    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
    public void onInterrupt(Throwable th) {
        Postcard postcard = (Postcard) this.d;
        if (th == null) {
            th = new HandlerException("No message.");
        }
        postcard.setTag(th);
        ((CancelableCountDownLatch) this.c).cancel();
    }

    public String toString() {
        switch (this.f709a) {
            case 1:
                StringBuffer stringBuffer = new StringBuffer(this.b * 6);
                stringBuffer.append("[");
                W1.a aVar = (W1.a) this.c;
                if (aVar != null) {
                    stringBuffer.append(aVar.c);
                    aVar = (W1.a) aVar.f784a;
                }
                while (aVar != null) {
                    stringBuffer.append(", ");
                    stringBuffer.append(aVar.c);
                    aVar = (W1.a) aVar.f784a;
                }
                stringBuffer.append("]");
                return stringBuffer.toString();
            default:
                return super.toString();
        }
    }

    public d(int i5, CancelableCountDownLatch cancelableCountDownLatch, Postcard postcard) {
        this.f709a = 2;
        this.c = cancelableCountDownLatch;
        this.b = i5;
        this.d = postcard;
    }

    public d(String str, String str2, int i5) {
        this.f709a = 3;
        this.c = str;
        this.d = str2;
        this.b = i5;
    }
}
