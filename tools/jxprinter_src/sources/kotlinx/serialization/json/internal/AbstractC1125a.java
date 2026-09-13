package kotlinx.serialization.json.internal;

import A4.InterfaceC0171n;
import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;
import p147z3.C1929i;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC1125a {
    public static /* synthetic */ byte a(int i5) {
        if (i5 == 1) {
            return (byte) 1;
        }
        if (i5 == 2) {
            return (byte) 2;
        }
        throw null;
    }

    public static /* synthetic */ int b(int i5) {
        if (i5 == 1) {
            return 16;
        }
        if (i5 == 2) {
            return 32;
        }
        throw null;
    }

    public static double c(Array2DRowRealMatrix array2DRowRealMatrix, int i5, int i6, double d, double d6) {
        return (array2DRowRealMatrix.getEntry(i5, i6) * d) + d6;
    }

    public static double d(ArrayRealVector arrayRealVector, int i5, double d) {
        double entry = arrayRealVector.getEntry(i5);
        return (entry * entry) + d;
    }

    public static double e(ArrayRealVector arrayRealVector, int i5, double d, double d6) {
        return (arrayRealVector.getEntry(i5) * d) + d6;
    }

    public static int f(StringBuilder sb, String str, String str2, p073n.a aVar) {
        sb.append(str);
        sb.append(str2);
        return aVar.b(sb.toString());
    }

    public static ClassCastException g(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String h(StringBuilder sb, int i5, String str, int i6, String str2) {
        sb.append(i5);
        sb.append(str);
        sb.append(CvType.channels(i6));
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder i(OutputStream outputStream, byte[] bArr, String str) {
        outputStream.write(bArr);
        return new StringBuilder(str);
    }

    public static StringBuilder j(p061l.e eVar, int i5, String str, String str2, String str3) {
        eVar.g(i5, str, str2, str3);
        return new StringBuilder();
    }

    public static C1929i k(AbstractC1126b abstractC1126b, String str, int i5, String str2, int i6) {
        AbstractC1126b.n(abstractC1126b, str, i5, str2, i6);
        return new C1929i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(InterfaceC0171n interfaceC0171n) throws Exception {
        boolean zIsTerminated;
        if (interfaceC0171n instanceof AutoCloseable) {
            interfaceC0171n.close();
            return;
        }
        if (!(interfaceC0171n instanceof ExecutorService)) {
            if (interfaceC0171n instanceof TypedArray) {
                ((TypedArray) interfaceC0171n).recycle();
                return;
            } else if (interfaceC0171n instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) interfaceC0171n).release();
                return;
            } else {
                if (!(interfaceC0171n instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) interfaceC0171n).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) interfaceC0171n;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z6 = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z6) {
                    executorService.shutdownNow();
                    z6 = true;
                }
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
    }

    public static void m(String str, int i5, StringBuilder sb) {
        sb.append(i5);
        sb.append(str);
        PackingUtils.log(sb.toString());
    }

    public static void n(StringBuilder sb, int i5, String str, int i6, String str2) {
        sb.append(i5);
        sb.append(str);
        sb.append(i6);
        sb.append(str2);
        PackingUtils.log(sb.toString());
    }

    public static void o(List list, StringBuilder sb, String str) {
        sb.append(list.size());
        sb.append(str);
        PackingUtils.log(sb.toString());
    }

    public static void p(Mat mat, List list, Mat mat2, List list2) {
        Converters.Mat_to_vector_Mat(mat, list);
        mat.release();
        Converters.Mat_to_vector_Mat(mat2, list2);
        mat2.release();
    }

    public static void q(p147z3.Q q6, O3.l lVar) {
        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(q6)));
    }
}
