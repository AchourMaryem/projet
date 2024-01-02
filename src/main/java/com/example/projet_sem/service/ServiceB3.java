package com.example.projet_sem.service;

import com.example.projet_sem.Dao.B3Repository;
import com.example.projet_sem.Entity.B3;
import com.itextpdf.text.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import com.itextpdf.text.pdf.draw.LineSeparator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceB3 implements IServiceB3 {

    public B3Repository b3repository;

    @Override
    public List<B3> getAllB3() {
        return b3repository.findAll();
    }

    @Override
    public void saveB3(B3 b3) {b3repository.save(b3);
    }

    @Override
    public B3 getB3(Long id) {
        return b3repository.findById(id).orElse(null);
    }
    @Override
    public void updateB3(Long id, B3 updatedB3) {
        Optional<B3> existingB3Optional=b3repository.findById(id);
        if(existingB3Optional.isPresent()){
            B3 existingB3= existingB3Optional.get();
            existingB3.setRemarque(updatedB3.getRemarque());
            b3repository.save(existingB3);
        }
    }
@Override
    public void deleteB3(Long id){
     b3repository.deleteById(id);
}

/*  mta3 pdf w bach  tzid  trak7oou  */

    public byte[] generatePDF(Long id) {
        B3 b3 = getB3(id);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.DARK_GRAY);
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            // Titre
            Paragraph title = new Paragraph("louzara loula", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            Image image = Image.getInstance("https://api.qrserver.com/v1/create-qr-code/?size=350x350&data="+b3.getQrcode().getHash());
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin()) / image.getWidth()) * 20;
            image.scalePercent(scaler);
            image.setAlignment(Element.ALIGN_CENTER);
            // Espacement
            document.add(Chunk.NEWLINE);


            // Sous-titre "B3"
            Paragraph subtitle = new Paragraph("B3", titleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle);

            // Ligne de séparation
            document.add(new Chunk(new LineSeparator()));

            // Informations B3

            document.add(createInfoParagraph("CIN", b3.getCin() + "", labelFont, valueFont));
            document.add(createInfoParagraph("Date CIN", b3.getDateCin(), labelFont, valueFont));
            document.add(createInfoParagraph("Nom", b3.getNom(), labelFont, valueFont));
            document.add(createInfoParagraph("Prenom", b3.getPrenom(), labelFont, valueFont));
            document.add(createInfoParagraph("Remarque", b3.getRemarque(), labelFont, valueFont));


            // Ligne de séparation
            document.add(new Chunk(new LineSeparator()));

            // Date de génération
            Paragraph generationDate = new Paragraph("Date de génération: " + java.time.LocalDate.now(), labelFont);
            generationDate.setAlignment(Element.ALIGN_RIGHT);
            document.add(generationDate);
            document.add(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            document.close();
        }

        return outputStream.toByteArray();
    }

    private Paragraph createInfoParagraph(String label, String value, Font labelFont, Font valueFont) {
        Paragraph infoParagraph = new Paragraph();
        infoParagraph.add(new Chunk(label + ": ", labelFont));
        infoParagraph.add(new Chunk(value, valueFont));
        return infoParagraph;
    }


    @Override
    public Page<B3> getB3BYCIN(String cin, Pageable p) {
        return b3repository.findByCin(cin, p);
    }

}