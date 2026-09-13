package p121v1;

import L3.q;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.android.billingclient.api.L0;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.ContentTypes;
import p133x1.a;
import p133x1.d;
import p133x1.e;
import p133x1.g;
import p145z1.f;
import p145z1.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final a Companion = new a();
    private static final String channelName = "com.fluttercandies/image_editor";
    private static final ExecutorService threadPool;
    private Context applicationContext;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        E.e(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        threadPool = executorServiceNewCachedThreadPool;
    }

    public static final void c(b bVar, MethodCall methodCall, g gVar, boolean z6) throws IllegalAccessException, IOException, InvocationTargetException {
        a aVarE;
        String str = (String) methodCall.argument("src");
        if (str != null) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            ExifInterface exifInterface = new ExifInterface(str);
            E.c(bitmapDecodeFile);
            aVarE = e(bitmapDecodeFile, exifInterface);
        } else {
            byte[] bArr = (byte[]) methodCall.argument("image");
            if (bArr == null) {
                throw new p139y1.a();
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            ExifInterface exifInterface2 = new ExifInterface(new ByteArrayInputStream(bArr));
            E.c(bitmapDecodeByteArray);
            aVarE = e(bitmapDecodeByteArray, exifInterface2);
        }
        d dVar = new d(aVarE.getBitmap());
        Object objArgument = methodCall.argument("options");
        E.c(objArgument);
        B1.a aVar = B1.a.INSTANCE;
        dVar.handle(aVar.convertMapOption((List) objArgument, aVarE));
        f formatOption = aVar.getFormatOption(methodCall);
        String str2 = (String) methodCall.argument(TypedValues.AttributesType.S_TARGET);
        if (z6) {
            gVar.reply(dVar.outputByteArray(formatOption));
        } else if (str2 == null) {
            gVar.reply(null);
        } else {
            dVar.outputToFile(str2, formatOption);
            gVar.reply(str2);
        }
    }

    public static final void d(b bVar, MethodCall methodCall, g gVar, boolean z6) throws IllegalAccessException, IOException, InvocationTargetException {
        Object objArgument = methodCall.argument("option");
        E.d(objArgument, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        i iVar = new i((Map) objArgument);
        byte[] bArrProcess = new e(iVar).process();
        if (bArrProcess == null) {
            p133x1.f fVar = g.Companion;
            gVar.replyError("Cannot merge image.", null, null);
            return;
        }
        if (z6) {
            gVar.reply(bArrProcess);
            return;
        }
        String str = iVar.getFormatOption().f9106a == 1 ? ContentTypes.EXTENSION_JPG_1 : ContentTypes.EXTENSION_PNG;
        Context context = bVar.applicationContext;
        E.c(context);
        File file = new File(context.getCacheDir(), System.currentTimeMillis() + '.' + str);
        q.writeBytes(file, bArrProcess);
        gVar.reply(file.getPath());
    }

    public static a e(Bitmap bitmap, ExifInterface exifInterface) {
        int i5 = 0;
        p145z1.e eVar = new p145z1.e(false, 2);
        switch (exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
            case 2:
                eVar = new p145z1.e(true, 2);
                break;
            case 3:
                i5 = 180;
                break;
            case 4:
                eVar = new p145z1.e(false, 1);
                break;
            case 5:
                eVar = new p145z1.e(true, 2);
            case 6:
                i5 = 90;
                break;
            case 7:
                eVar = new p145z1.e(true, 2);
            case 8:
                i5 = 270;
                break;
        }
        return new a(bitmap, i5, eVar);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
        E.f(binding, "binding");
        this.applicationContext = binding.getApplicationContext();
        new MethodChannel(binding.getBinaryMessenger(), channelName).setMethodCallHandler(this);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        E.f(binding, "binding");
        this.applicationContext = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        E.f(call, "call");
        E.f(result, "result");
        Companion.getThreadPool().execute(new L0(call, 4, this, new g(result)));
    }
}
