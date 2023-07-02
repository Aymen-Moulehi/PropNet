package tn.esprit.propnetapp.features.pdfenerator;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public abstract class PdfGenerator<EntityType> {

    public ByteArrayOutputStream generatePdfFromEntity(EntityType entity) throws DocumentException, IOException, WriterException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Document document = createDocument(byteArrayOutputStream);
            addContentToDocument(document, entity);
            closeDocument(document);
            return byteArrayOutputStream;
    }
    public abstract void addContentToDocument(Document document, EntityType entity) throws DocumentException, IOException, WriterException;

    private Document createDocument(ByteArrayOutputStream byteArrayOutputStream) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        return  document;
    }

    protected Image createQrcodeFromUrl(String url) throws BadElementException, IOException, WriterException {
        String DEFAULT_QRCODE_PATH = "src/main/resources/images/";
        String qrcodeFileName = DEFAULT_QRCODE_PATH + generateRandomQrcodeFileName();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 200, 200);
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", Files.newOutputStream(Paths.get(qrcodeFileName)));
        Image qrCodeImage = Image.getInstance(qrcodeFileName);
        File f = new File(qrcodeFileName);
        f.delete();
        return qrCodeImage;
    }

    private void closeDocument(Document document) {
        document.close();
    }

    private String generateRandomQrcodeFileName() {
        Date currentDate = new Date();
        return "qrcode" + currentDate.getTime() + ".png";
    }

}

