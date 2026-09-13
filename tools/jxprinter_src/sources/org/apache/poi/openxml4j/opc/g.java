package org.apache.poi.openxml4j.opc;

import A3.G;
import com.google.android.gms.tasks.OnSuccessListener;
import io.flutter.plugin.common.BasicMessageChannel;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.dsig.SignatureLine;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.poifs.filesystem.POIFSWriterListener;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.xssf.streaming.DeferredSXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFSignatureLine;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import p102s.C;
import p102s.r;
import p102s.s;
import p102s.t;
import p102s.u;
import p108t.B;
import p108t.D;
import p108t.F;
import p108t.S;
import p108t.U;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements Supplier, POIFSWriterListener, SXSSFWorkbook.ISheetInjector, XSSFPivotTable.PivotTableReferenceConfigurator, SignatureLine.AddPictureData, OnSuccessListener, BasicMessageChannel.MessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7137a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i5) {
        this.f7137a = i5;
        this.b = obj;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureLine.AddPictureData
    public String addPictureData(byte[] bArr, PictureType pictureType) {
        return XWPFSignatureLine.lambda$add$0((XWPFParagraph) this.b, bArr, pictureType);
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFPivotTable.PivotTableReferenceConfigurator
    public void configureReference(CTWorksheetSource cTWorksheetSource) {
        switch (this.f7137a) {
            case 5:
                XSSFSheet.lambda$createPivotTable$3((Name) this.b, cTWorksheetSource);
                break;
            case 6:
                XSSFSheet.lambda$createPivotTable$4((Table) this.b, cTWorksheetSource);
                break;
            default:
                XSSFSheet.lambda$createPivotTable$2((AreaReference) this.b, cTWorksheetSource);
                break;
        }
    }

    @Override // org.apache.logging.log4j.util.Supplier
    public Object get() {
        switch (this.f7137a) {
            case 0:
                return ZipPackage.lambda$saveImpl$3((PackagePartName) this.b);
            default:
                return ((File) this.b).getAbsolutePath();
        }
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        List listA;
        long jLongValue;
        long jLongValue2;
        List listA2;
        List listA3;
        List listA4;
        switch (this.f7137a) {
            case 10:
                B b = (B) this.b;
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj2 = ((List) obj).get(0);
                E.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                try {
                    ((r) b).c(((Boolean) obj2).booleanValue());
                    listA = G.listOf(null);
                } catch (Throwable th) {
                    listA = com.bumptech.glide.g.a(th);
                }
                reply.reply(listA);
                break;
            case 11:
                D d = (D) this.b;
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                List list = (List) obj;
                Object obj3 = list.get(0);
                E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj3;
                Object obj4 = list.get(1);
                if (obj4 instanceof Integer) {
                    jLongValue = ((Number) obj4).intValue();
                } else {
                    E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                    jLongValue = ((Long) obj4).longValue();
                }
                long j6 = jLongValue;
                Object obj5 = list.get(2);
                if (obj5 instanceof Integer) {
                    jLongValue2 = ((Number) obj5).intValue();
                } else {
                    E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                    jLongValue2 = ((Long) obj5).longValue();
                }
                ((t) d).createLabelFromImage(str, j6, jLongValue2, new S2.f(reply, 29));
                break;
            case 12:
                F f6 = (F) this.b;
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj6 = ((List) obj).get(0);
                E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                try {
                    ((u) f6).showTipText((String) obj6);
                    listA2 = G.listOf(null);
                } catch (Throwable th2) {
                    listA2 = com.bumptech.glide.g.a(th2);
                }
                reply.reply(listA2);
                break;
            case 13:
                S s6 = (S) this.b;
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj7 = ((List) obj).get(0);
                E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                try {
                    ((C) s6).show((String) obj7);
                    listA3 = G.listOf(null);
                } catch (Throwable th3) {
                    listA3 = com.bumptech.glide.g.a(th3);
                }
                reply.reply(listA3);
                break;
            default:
                U u6 = (U) this.b;
                E.f(reply, "reply");
                try {
                    listA4 = G.listOf(((p102s.D) u6).getDevices());
                } catch (Throwable th4) {
                    listA4 = com.bumptech.glide.g.a(th4);
                }
                reply.reply(listA4);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((s) this.b).invoke(obj);
    }

    @Override // org.apache.poi.poifs.filesystem.POIFSWriterListener
    public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
        ((ChunkedCipherOutputStream) this.b).processPOIFSWriterEvent(pOIFSWriterEvent);
    }

    @Override // org.apache.poi.xssf.streaming.SXSSFWorkbook.ISheetInjector
    public void writeSheetData(OutputStream outputStream) throws IOException {
        switch (this.f7137a) {
            case 3:
                ((DeferredSXSSFSheet) this.b).writeRows(outputStream);
                break;
            default:
                SXSSFWorkbook.lambda$createSheetInjector$0((SXSSFSheet) this.b, outputStream);
                break;
        }
    }
}
