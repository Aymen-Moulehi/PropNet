package tn.esprit.propnetapp.features.pdfenerator;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.propnetapp.post.IPostService;
import tn.esprit.propnetapp.post.Post;
import java.io.ByteArrayOutputStream;


@RestController
@RequestMapping("/pdf-generator")
@AllArgsConstructor
public class PdfGeneratorRestController {

    private PostPdfGenerator postPdfGenerator;
    private IPostService postService;

    @GetMapping(value = "/post/{postId}", produces = MediaType.APPLICATION_PDF_VALUE)
    @CrossOrigin
    public ResponseEntity<byte[]> generatePDFWithQRCode(@PathVariable Integer postId) {
        Post post = postService.getPostById(postId);
        if(post == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        try {
            ByteArrayOutputStream baos = postPdfGenerator.generatePdfFromEntity(post);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "forum_post.pdf");
            return ResponseEntity.ok().headers(headers).body(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
