package F4;

import C1.g;
import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.view.View;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import com.appdev.standard.page.index.IndexFragment;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.idlefish.flutterboost.Messages;
import com.sandu.JxPrinter.config.MainApp;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.ViewUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import okhttp3.InterfaceC1349b;
import okhttp3.InterfaceC1370p;
import okhttp3.M;
import okhttp3.T;
import okhttp3.X;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.AbstractByteArrayOutputStream;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.poifs.crypt.dsig.services.TimeStampSimpleHttpClient;
import org.apache.poi.xdgf.usermodel.XDGFMasters;
import p056k0.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements IOFunction, ViewUtils.ViewVisitor, Interpolator, j, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, LibraryVersionComponent.VersionExtractor, OnFailureListener, Transformer, Messages.FlutterRouterApi.Reply, FlutterBoost.Callback, g, InterfaceC1349b, InterfaceC1370p, AbstractByteArrayOutputStream.InputStreamConstructor, TimeStampSimpleHttpClient.MethodHandler, POIXMLRelation.PackagePartConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f274a;

    public /* synthetic */ e(int i5) {
        this.f274a = i5;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // okhttp3.InterfaceC1349b
    public M authenticate(X x6, T t6) {
        return InterfaceC1349b.lambda$static$0(x6, t6);
    }

    @Override // org.apache.commons.io.output.AbstractByteArrayOutputStream.InputStreamConstructor
    public InputStream construct(byte[] bArr, int i5, int i6) {
        switch (this.f274a) {
            case 25:
                return new ByteArrayInputStream(bArr, i5, i6);
            default:
                return new UnsynchronizedByteArrayInputStream(bArr, i5, i6);
        }
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f274a) {
            case 12:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 13:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case 14:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f6) {
        switch (this.f274a) {
            case 2:
                return Transition.lambda$getInterpolator$1(f6);
            case 3:
                return Transition.lambda$getInterpolator$2(f6);
            case 4:
                return Transition.lambda$getInterpolator$3(f6);
            case 5:
                return Transition.lambda$getInterpolator$4(f6);
            case 6:
                return Transition.lambda$getInterpolator$5(f6);
            case 7:
                return Transition.lambda$getInterpolator$6(f6);
            default:
                return Transition.lambda$getInterpolator$7(f6);
        }
    }

    @Override // org.apache.poi.poifs.crypt.dsig.services.TimeStampSimpleHttpClient.MethodHandler
    public void handle(HttpURLConnection httpURLConnection) {
        TimeStampSimpleHttpClient.lambda$get$1(httpURLConnection);
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.PackagePartConstructor
    public POIXMLDocumentPart init(PackagePart packagePart) {
        return new XDGFMasters(packagePart);
    }

    @Override // C1.g
    public void log(String str) {
        Log.d(FlutterJNI.TAG, str);
    }

    @Override // okhttp3.InterfaceC1370p
    public List lookup(String str) {
        return InterfaceC1370p.lambda$static$0(str);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        FirebaseCrashlytics.lambda$init$0(exc);
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        IndexFragment.lambda$onPhotoPrintClick$5(uri);
    }

    @Override // com.idlefish.flutterboost.FlutterBoost.Callback
    public void onStart(FlutterEngine flutterEngine) {
        MainApp.lambda$onCreate$0(flutterEngine);
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public void reply(Object obj) {
        Void r6 = (Void) obj;
        switch (this.f274a) {
            case 18:
                FlutterBoostPlugin.lambda$sendEventToFlutter$1(r6);
                break;
            default:
                FlutterBoostPlugin.lambda$onContainerDestroyed$11(r6);
                break;
        }
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return view.hasFocus();
    }

    @Override // org.apache.commons.io.function.IOFunction
    public Object apply(Object obj) {
        switch (this.f274a) {
            case 0:
                return IOFunction.lambda$identity$8(obj);
            case 17:
                return DataTransportCrashlyticsReportSender.lambda$static$0((CrashlyticsReport) obj);
            default:
                return ThresholdingOutputStream.lambda$static$0((ThresholdingOutputStream) obj);
        }
    }
}
