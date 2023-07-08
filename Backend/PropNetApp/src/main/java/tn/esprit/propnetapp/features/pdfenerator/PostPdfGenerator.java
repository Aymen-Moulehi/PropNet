package tn.esprit.propnetapp.features.pdfenerator;

import com.google.zxing.WriterException;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import tn.esprit.propnetapp.post.Post;
import java.io.IOException;

@Component
@AllArgsConstructor
public class PostPdfGenerator extends PdfGenerator<Post> {

    private Environment env;
    @Override
    public void addContentToDocument(Document document, Post entity) throws DocumentException, IOException, WriterException {

        // Adding title
        Font font = new Font();
        font.setColor(BaseColor.BLUE);
        document.add(new Phrase(entity.getTitle(), font));

        // Adding Content
        document.add(new Paragraph(entity.getContent()));
        Image postQrcodeUrl = createQrcodeFromUrl(env.getProperty("default-front-url") + "/forume/detail;idPost=" + entity.getIdPost());
        document.add(postQrcodeUrl);
    }
}
