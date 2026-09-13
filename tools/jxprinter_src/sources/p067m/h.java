package p067m;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0985s;
import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.O;
import io.reactivex.V;
import io.reactivex.y;
import java.util.concurrent.Callable;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.XmlErrorCodes;
import p017c3.d;
import p027e3.o;
import p033f3.e;
import p039g3.A;
import p059k3.F0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static String a(int i5) {
        switch (i5) {
            case 1:
                return "error";
            case 2:
                return XmlErrorCodes.INT;
            case 3:
                return "float";
            case 4:
                return TypedValues.Custom.S_STRING;
            case 5:
                return "iso8601";
            case 6:
                return "true";
            case 7:
                return "false";
            case 8:
                return AbstractC1127c.NULL;
            case 9:
                return "new";
            case 10:
                return "(";
            case 11:
                return ")";
            case 12:
                return VectorFormat.DEFAULT_PREFIX;
            case 13:
                return VectorFormat.DEFAULT_SUFFIX;
            case 14:
                return "[";
            case 15:
                return "]";
            case 16:
                return ",";
            case 17:
                return ParameterizedMessage.ERROR_MSG_SEPARATOR;
            case 18:
                return "ident";
            case 19:
                return "fieldName";
            case 20:
                return "EOF";
            case 21:
                return "Set";
            case 22:
                return "TreeSet";
            case 23:
                return "undefined";
            case 24:
                return ";";
            case 25:
                return Consts.DOT;
            default:
                return "Unknown";
        }
    }

    public static boolean c(Object obj, o oVar, InterfaceC0679f interfaceC0679f) {
        InterfaceC0682i interfaceC0682i;
        e eVar = e.f3970a;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            if (objCall != null) {
                Object objApply = oVar.apply(objCall);
                A.b(objApply, "The mapper returned a null CompletableSource");
                interfaceC0682i = (InterfaceC0682i) objApply;
            } else {
                interfaceC0682i = null;
            }
            if (interfaceC0682i != null) {
                ((AbstractC0676c) interfaceC0682i).subscribe(interfaceC0679f);
                return true;
            }
            interfaceC0679f.onSubscribe(eVar);
            interfaceC0679f.onComplete();
            return true;
        } catch (Throwable th) {
            d.throwIfFatal(th);
            interfaceC0679f.onSubscribe(eVar);
            interfaceC0679f.onError(th);
            return true;
        }
    }

    public static boolean d(Object obj, o oVar, I i5) {
        y yVar;
        e eVar = e.f3970a;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            if (objCall != null) {
                Object objApply = oVar.apply(objCall);
                A.b(objApply, "The mapper returned a null MaybeSource");
                yVar = (y) objApply;
            } else {
                yVar = null;
            }
            if (yVar == null) {
                i5.onSubscribe(eVar);
                i5.onComplete();
                return true;
            }
            ((AbstractC0985s) yVar).subscribe(new F0(i5));
            return true;
        } catch (Throwable th) {
            d.throwIfFatal(th);
            i5.onSubscribe(eVar);
            i5.onError(th);
            return true;
        }
    }

    public static boolean e(Object obj, o oVar, I i5) {
        V v6;
        e eVar = e.f3970a;
        if (!(obj instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) obj).call();
            if (objCall != null) {
                Object objApply = oVar.apply(objCall);
                A.b(objApply, "The mapper returned a null SingleSource");
                v6 = (V) objApply;
            } else {
                v6 = null;
            }
            if (v6 == null) {
                i5.onSubscribe(eVar);
                i5.onComplete();
                return true;
            }
            ((O) v6).subscribe(new p077n3.V(i5));
            return true;
        } catch (Throwable th) {
            d.throwIfFatal(th);
            i5.onSubscribe(eVar);
            i5.onError(th);
            return true;
        }
    }

    public abstract String b(String str);
}
