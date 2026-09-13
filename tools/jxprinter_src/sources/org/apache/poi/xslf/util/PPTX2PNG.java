package org.apache.poi.xslf.util;

import A3.AbstractC0157z;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Dimension2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.openxml4j.opc.ContentTypes;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.sl.draw.Drawable;
import org.apache.poi.sl.draw.EmbeddedExtractor;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PPTX2PNG {
    private static final String OUTPUT_PAT_REGEX = "${basename}-${slideno}.${format}";
    private static final Logger LOG = LogManager.getLogger((Class<?>) PPTX2PNG.class);
    private static final String INPUT_PAT_REGEX = "(?<slideno>[^|]+)\\|(?<format>[^|]+)\\|(?<basename>.+)\\.(?<ext>[^.]++)";
    private static final Pattern INPUT_PATTERN = Pattern.compile(INPUT_PAT_REGEX);
    private String slidenumStr = StructuredDataId.RESERVED;
    private float scale = 1.0f;
    private File file = null;
    private String format = ContentTypes.EXTENSION_PNG;
    private File outdir = null;
    private String outfile = null;
    private boolean quiet = false;
    private String outPattern = OUTPUT_PAT_REGEX;
    private File dumpfile = null;
    private String fixSide = "scale";
    private boolean ignoreParse = false;
    private boolean extractEmbedded = false;
    private FileMagic defaultFileType = FileMagic.OLE2;
    private boolean textAsShapes = false;
    private Charset charset = LocaleUtil.CHARSET_1252;
    private boolean emfHeaderBounds = false;
    private String fontDir = null;
    private String fontTtf = null;
    private String fontMap = null;

    /* JADX INFO: renamed from: org.apache.poi.xslf.util.PPTX2PNG$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic;

        static {
            int[] iArr = new int[FileMagic.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic = iArr;
            try {
                iArr[FileMagic.EMF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[FileMagic.WMF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NoScratchpadException extends IOException {
        public NoScratchpadException() {
        }

        public NoScratchpadException(Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface ProxyConsumer {
        void parse(MFProxy mFProxy);
    }

    private PPTX2PNG() {
    }

    private String calcOutFile(MFProxy mFProxy, int i5) {
        String str = this.outfile;
        if (str != null) {
            return str;
        }
        String name = this.file.getName();
        if ("stdin".equals(name)) {
            name = androidx.collection.a.n(name, ".ext");
        }
        return INPUT_PATTERN.matcher(String.format(Locale.ROOT, "%04d|%s|%s", Integer.valueOf(i5), this.format, name)).replaceAll((mFProxy.getSlideCount() <= 1 || i5 <= 0) ? this.outPattern.replaceAll("-?\\$\\{slideno}", "") : this.outPattern);
    }

    private void dumpRecords(MFProxy mFProxy) {
        File file = this.dumpfile;
        if (file == null || AbstractC1127c.NULL.equals(file.getPath())) {
            return;
        }
        GenericRecord root = mFProxy.getRoot();
        GenericRecordJsonWriter genericRecordJsonWriter = new GenericRecordJsonWriter(this.dumpfile) { // from class: org.apache.poi.xslf.util.PPTX2PNG.1
            @Override // org.apache.poi.util.GenericRecordJsonWriter
            public boolean printBytes(String str, Object obj) {
                return false;
            }
        };
        try {
            if (root == null) {
                genericRecordJsonWriter.writeError(this.file.getName() + " doesn't support GenericRecord interface and can't be dumped to a file.");
            } else {
                genericRecordJsonWriter.write(root);
            }
            genericRecordJsonWriter.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    genericRecordJsonWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void extractEmbedded(MFProxy mFProxy, int i5) throws IOException {
        if (this.extractEmbedded) {
            for (EmbeddedExtractor.EmbeddedPart embeddedPart : mFProxy.getEmbeddings(i5)) {
                String name = embeddedPart.getName();
                if (name == null) {
                    name = "dummy.dat";
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.outdir, calcOutFile(mFProxy, i5).replaceFirst("\\.\\w+$", "") + "_" + new File(name).getName()));
                try {
                    fileOutputStream.write(embeddedPart.getData().get());
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private Charset getDefaultCharset() {
        return this.charset;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0059  */
    private double getDimensions(MFProxy mFProxy, Dimension2D dimension2D) {
        double height;
        Dimension2D size = mFProxy.getSize();
        String str = this.fixSide;
        switch (str.hashCode()) {
            case -1221029593:
                if (!str.equals("height")) {
                    height = 1.0d;
                } else {
                    height = size.getHeight();
                }
                break;
            case 3327612:
                if (!str.equals(XmlErrorCodes.LONG)) {
                    height = 1.0d;
                } else {
                    height = Math.max(size.getWidth(), size.getHeight());
                }
                break;
            case 109250890:
                str.equals("scale");
                height = 1.0d;
                break;
            case 109413500:
                if (!str.equals("short")) {
                    height = 1.0d;
                } else {
                    height = Math.min(size.getWidth(), size.getHeight());
                }
                break;
            case 113126854:
                if (!str.equals("width")) {
                    height = 1.0d;
                } else {
                    height = size.getWidth();
                }
                break;
            default:
                height = 1.0d;
                break;
        }
        dimension2D.setSize((size.getWidth() * ((double) this.scale)) / height, (size.getHeight() * ((double) this.scale)) / height);
        return height;
    }

    private OutputFormat getOutput() {
        String str = this.format;
        str.getClass();
        switch (str) {
            case "log":
                return new DummyFormat();
            case "pdf":
                return new PDFFormat(this.textAsShapes, this.fontDir, this.fontTtf);
            case "svg":
                try {
                    return new SVGFormat(this.textAsShapes);
                } catch (Exception | NoClassDefFoundError e) {
                    LOG.atError().withThrowable(e).log("Batik is not not added to/working on the module-path. Use classpath mode instead of JPMS. Fallback to PNG.");
                    return new BitmapFormat(ContentTypes.EXTENSION_PNG);
                }
            default:
                return new BitmapFormat(this.format);
        }
    }

    private MFProxy initProxy(final File file) {
        FileMagic fileMagicValueOf;
        ProxyConsumer proxyConsumer;
        MFProxy eMFHandler;
        if ("stdin".equals(file.getName().toLowerCase(Locale.ROOT))) {
            final InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(System.in);
            fileMagicValueOf = FileMagic.valueOf(inputStreamPrepareToCheckMagic);
            final int i5 = 0;
            proxyConsumer = new ProxyConsumer() { // from class: org.apache.poi.xslf.util.k
                @Override // org.apache.poi.xslf.util.PPTX2PNG.ProxyConsumer
                public final void parse(MFProxy mFProxy) {
                    switch (i5) {
                        case 0:
                            mFProxy.parse((InputStream) inputStreamPrepareToCheckMagic);
                            break;
                        default:
                            mFProxy.parse((File) inputStreamPrepareToCheckMagic);
                            break;
                    }
                }
            };
        } else {
            fileMagicValueOf = FileMagic.valueOf(file);
            final int i6 = 1;
            proxyConsumer = new ProxyConsumer() { // from class: org.apache.poi.xslf.util.k
                @Override // org.apache.poi.xslf.util.PPTX2PNG.ProxyConsumer
                public final void parse(MFProxy mFProxy) {
                    switch (i6) {
                        case 0:
                            mFProxy.parse((InputStream) file);
                            break;
                        default:
                            mFProxy.parse((File) file);
                            break;
                    }
                }
            };
        }
        if (fileMagicValueOf == FileMagic.UNKNOWN) {
            fileMagicValueOf = this.defaultFileType;
        }
        int i7 = AnonymousClass2.$SwitchMap$org$apache$poi$poifs$filesystem$FileMagic[fileMagicValueOf.ordinal()];
        if (i7 != 1) {
            eMFHandler = i7 != 2 ? new PPTHandler() : new WMFHandler();
        } else {
            eMFHandler = new EMFHandler();
        }
        eMFHandler.setIgnoreParse(this.ignoreParse);
        eMFHandler.setQuiet(this.quiet);
        proxyConsumer.parse(eMFHandler);
        eMFHandler.setDefaultCharset(this.charset);
        return eMFHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$processFile$0(String str) {
        return str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$processFile$1(String[] strArr) {
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$processFile$2(String[] strArr) {
        return strArr[1];
    }

    public static void main(String[] strArr) throws IOException {
        PPTX2PNG pptx2png = new PPTX2PNG();
        if (pptx2png.parseCommandLine(strArr)) {
            pptx2png.processFile();
        }
    }

    private boolean parseCommandLine(String[] strArr) {
        File file;
        File file2;
        if (strArr.length == 0) {
            usage(null);
            return false;
        }
        int i5 = 0;
        while (i5 < strArr.length) {
            int i6 = i5 + 1;
            String str = i6 < strArr.length ? strArr[i6] : null;
            String str2 = strArr[i5];
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            lowerCase.getClass();
            switch (lowerCase) {
                case "-ignoreparse":
                    this.ignoreParse = true;
                    continue;
                    i5++;
                    break;
                case "-extractembedded":
                    this.extractEmbedded = true;
                    continue;
                    i5++;
                    break;
                case "-textasshapes":
                    this.textAsShapes = true;
                    continue;
                    i5++;
                    break;
                case "-emfheaderbounds":
                    this.emfHeaderBounds = true;
                    continue;
                    i5++;
                    break;
                case "-outfile":
                    this.outfile = str;
                    break;
                case "-format":
                    this.format = str;
                    break;
                case "-dump":
                    if (str != null) {
                        this.dumpfile = new File(str);
                        break;
                    } else {
                        this.dumpfile = new File("pptx2png.dump");
                    }
                    i5++;
                    break;
                case "-fixside":
                    if (str != null) {
                        this.fixSide = str.toLowerCase(locale);
                        break;
                    } else {
                        this.fixSide = XmlErrorCodes.LONG;
                    }
                    i5++;
                    break;
                case "-outdir":
                    if (str != null) {
                        this.outdir = new File(str);
                        break;
                    }
                    i5++;
                    break;
                case "-outpat":
                    this.outPattern = str;
                    break;
                case "-fontdir":
                    if (str != null) {
                        this.fontDir = str;
                        break;
                    } else {
                        this.fontDir = null;
                    }
                    i5++;
                    break;
                case "-fontmap":
                    if (str != null) {
                        this.fontMap = str;
                        break;
                    } else {
                        this.fontMap = null;
                    }
                    i5++;
                    break;
                case "-fontttf":
                    if (str != null) {
                        this.fontTtf = str;
                        break;
                    } else {
                        this.fontTtf = null;
                    }
                    i5++;
                    break;
                case "-quiet":
                    this.quiet = true;
                    continue;
                    i5++;
                    break;
                case "-scale":
                    if (str != null) {
                        this.scale = Float.parseFloat(str);
                        break;
                    }
                    i5++;
                    break;
                case "-slide":
                    this.slidenumStr = str;
                    break;
                case "-inputtype":
                    if (str != null) {
                        this.defaultFileType = FileMagic.valueOf(str);
                        break;
                    } else {
                        this.defaultFileType = FileMagic.OLE2;
                    }
                    i5++;
                    break;
                case "-charset":
                    if (str != null) {
                        this.charset = Charset.forName(str);
                        break;
                    } else {
                        this.charset = LocaleUtil.CHARSET_1252;
                    }
                    i5++;
                    break;
                default:
                    this.file = new File(strArr[i5]);
                    continue;
                    i5++;
                    break;
            }
            i5 = i6;
            i5++;
        }
        File file3 = this.file;
        boolean z6 = file3 != null && "stdin".equalsIgnoreCase(file3.getName());
        if (!z6 && ((file2 = this.file) == null || !file2.exists())) {
            usage("File not specified or it doesn't exist");
            return false;
        }
        String str3 = this.format;
        if (str3 == null || !str3.matches("^(png|gif|jpg|null|svg|pdf|log)$")) {
            usage("Invalid format given");
            return false;
        }
        if (this.outdir == null) {
            if (z6) {
                usage("When reading from STDIN, you need to specify an outdir.");
                return false;
            }
            this.outdir = this.file.getAbsoluteFile().getParentFile();
        }
        if (!this.outdir.exists()) {
            usage("Outdir doesn't exist");
            return false;
        }
        if (!AbstractC1127c.NULL.equals(this.format) && ((file = this.outdir) == null || !file.exists() || !this.outdir.isDirectory())) {
            usage("Output directory doesn't exist");
            return false;
        }
        if (this.scale < 0.0f) {
            usage("Invalid scale given");
            return false;
        }
        if ("long,short,width,height,scale".contains(this.fixSide)) {
            return true;
        }
        usage("<fixside> must be one of long / short / width / height / scale");
        return false;
    }

    private void processFile() throws IOException {
        String str;
        if (!this.quiet) {
            System.out.println("Processing " + this.file);
        }
        try {
            MFProxy mFProxyInitProxy = initProxy(this.file);
            try {
                Set<Integer> setSlideIndexes = mFProxyInitProxy.slideIndexes(this.slidenumStr);
                if (setSlideIndexes.isEmpty()) {
                    usage("slidenum must be either -1 (for all) or within range: [1.." + mFProxyInitProxy.getSlideCount() + "] for " + this.file);
                    mFProxyInitProxy.close();
                    return;
                }
                Dimension2DDouble dimension2DDouble = new Dimension2DDouble();
                double dimensions = getDimensions(mFProxyInitProxy, dimension2DDouble);
                int iMax = Math.max((int) Math.rint(dimension2DDouble.getWidth()), 1);
                int iMax2 = Math.max((int) Math.rint(dimension2DDouble.getHeight()), 1);
                OutputFormat output = getOutput();
                try {
                    Iterator<Integer> it = setSlideIndexes.iterator();
                    while (it.hasNext()) {
                        int iIntValue = it.next().intValue();
                        mFProxyInitProxy.setSlideNo(iIntValue);
                        if (!this.quiet) {
                            String title = mFProxyInitProxy.getTitle();
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Rendering slide ");
                            sb.append(iIntValue);
                            if (title == null) {
                                str = "";
                            } else {
                                str = ": " + title.trim();
                            }
                            sb.append(str);
                            printStream.println(sb.toString());
                        }
                        dumpRecords(mFProxyInitProxy);
                        extractEmbedded(mFProxyInitProxy, iIntValue);
                        Graphics2D graphics2DAddSlide = output.addSlide(iMax, iMax2);
                        graphics2DAddSlide.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        graphics2DAddSlide.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                        graphics2DAddSlide.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                        graphics2DAddSlide.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                        graphics2DAddSlide.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                        graphics2DAddSlide.setRenderingHint(Drawable.DEFAULT_CHARSET, getDefaultCharset());
                        graphics2DAddSlide.setRenderingHint(Drawable.EMF_FORCE_HEADER_BOUNDS, Boolean.valueOf(this.emfHeaderBounds));
                        String str2 = this.fontMap;
                        if (str2 != null) {
                            graphics2DAddSlide.setRenderingHint(Drawable.FONT_MAP, (Map) Arrays.stream(str2.split(";")).map(new h(3)).collect(Collectors.toMap(new h(4), new h(5))));
                        }
                        float f6 = this.scale;
                        graphics2DAddSlide.scale(((double) f6) / dimensions, ((double) f6) / dimensions);
                        graphics2DAddSlide.setComposite(AlphaComposite.Clear);
                        graphics2DAddSlide.fillRect(0, 0, iMax, iMax2);
                        graphics2DAddSlide.setComposite(AlphaComposite.SrcOver);
                        mFProxyInitProxy.draw(graphics2DAddSlide);
                        output.writeSlide(mFProxyInitProxy, new File(this.outdir, calcOutFile(mFProxyInitProxy, iIntValue)));
                    }
                    output.writeDocument(mFProxyInitProxy, new File(this.outdir, calcOutFile(mFProxyInitProxy, 0)));
                    output.close();
                    mFProxyInitProxy.close();
                    if (this.quiet) {
                        return;
                    }
                    System.out.println("Done");
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (output != null) {
                            try {
                                output.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (mFProxyInitProxy != null) {
                        try {
                            mFProxyInitProxy.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (NoScratchpadException unused) {
            usage("'" + this.file.getName() + "': Format not supported - try to include poi-scratchpad.jar into the CLASSPATH.");
        }
        usage("'" + this.file.getName() + "': Format not supported - try to include poi-scratchpad.jar into the CLASSPATH.");
    }

    private static void usage(String str) {
        System.out.println(AbstractC0157z.s(new StringBuilder("Usage: PPTX2PNG [options] <.ppt/.pptx/.emf/.wmf file or 'stdin'>\n"), str == null ? "" : AbstractC0157z.o("Error: ", str, "\n"), "Options:\n    -scale <float>    scale factor\n    -fixSide <side>   specify side (long,short,width,height) to fix - use <scale> as amount of pixels\n    -slide <integer>  1-based index of a slide to render\n    -format <type>    png,gif,jpg,svg,pdf (,log,null for testing)\n    -outdir <dir>     output directory, defaults to origin of the ppt/pptx file\n    -outfile <file>   output filename, defaults to '${basename}-${slideno}.${format}'\n    -outpat <pattern> output filename pattern, defaults to '${basename}-${slideno}.${format}'\n                      patterns: basename, slideno, format, ext\n    -dump <file>      dump the annotated records to a file\n    -quiet            do not write to console (for normal processing)\n    -ignoreParse      ignore parsing error and continue with the records read until the error\n    -extractEmbedded  extract embedded parts\n    -inputType <type> default input file type (OLE2,WMF,EMF), default is OLE2 = Powerpoint\n                      some files (usually wmf) don't have a header, i.e. an identifiable file magic\n    -textAsShapes     text elements are saved as shapes in SVG, necessary for variable spacing\n                      often found in math formulas\n    -charset <cs>     sets the default charset to be used, defaults to Windows-1252\n    -emfHeaderBounds  force the usage of the emf header bounds to calculate the bounding box\n    -fontdir <dir>    (PDF only) font directories separated by \";\" - use $HOME for current users home dir\n                      defaults to the usual plattform directories\n    -fontTtf <regex>  (PDF only) regex to match the .ttf filenames\n    -fontMap <map>    \";\"-separated list of font mappings <typeface from>:<typeface to>"));
    }
}
