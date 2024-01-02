package com.example.projet_sem.service;

import com.example.projet_sem.Dao.WeddingCertificateRepository;
import com.example.projet_sem.Entity.WeddingCertificate;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceWeddingCertificate implements IServiceWeddingCertificate {

    private final WeddingCertificateRepository weddingCertificateRepository;

    @Override
    public List<WeddingCertificate> getAllWedd()
    { return weddingCertificateRepository.findAll();}
    @Override
    public void saveWed(WeddingCertificate weddingCertificate) {weddingCertificateRepository.save(weddingCertificate);

    }
    @Override
    public WeddingCertificate getWedding(Long id) {
        return weddingCertificateRepository.findById(id).orElse(null);
    }

    @Override
    public void updateWedding(Long id, WeddingCertificate updatedWedding) {
        Optional<WeddingCertificate> existingWeddingOptional=weddingCertificateRepository.findById(id);
        if(existingWeddingOptional.isPresent()){
            WeddingCertificate existingWedding= existingWeddingOptional.get();
            existingWedding.setNomcouple(updatedWedding.getNomcouple());
            existingWedding.setPrenomcouple(updatedWedding.getPrenomcouple());
            weddingCertificateRepository.save(existingWedding);

        }
    }
    @Override
    public void deleteWedding(Long id){
        weddingCertificateRepository.deleteById(id);
    }

    public byte[] generatePDF(Long id) {
        WeddingCertificate weddingCertificate = getWedding(id);

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
            Image image = Image.getInstance("https://api.qrserver.com/v1/create-qr-code/?size=350x350&data="+weddingCertificate.getQrcode().getHash());
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin()) / image.getWidth()) * 20;
            image.scalePercent(scaler);
            image.setAlignment(Element.ALIGN_CENTER);

            // Espacement
            document.add(Chunk.NEWLINE);

            // Sous-titre "weddingCertificate"
            Paragraph subtitle = new Paragraph("wedding Certificate", titleFont);
            subtitle.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitle);

            // Ligne de séparation
            document.add(new Chunk(new LineSeparator()));

            // Informations weddingCertificate

            document.add(createInfoParagraph("CIN", weddingCertificate.getCin() + "", labelFont, valueFont));
            document.add(createInfoParagraph("Date CIN", weddingCertificate.getDateCin(), labelFont, valueFont));
            document.add(createInfoParagraph("Nom", weddingCertificate.getNom(), labelFont, valueFont));
            document.add(createInfoParagraph("Prenom", weddingCertificate.getPrenom(), labelFont, valueFont));
            document.add(createInfoParagraph("Nom Mere", weddingCertificate.getNommere(), labelFont, valueFont));
            document.add(createInfoParagraph("Nom Pere", weddingCertificate.getNompere(), labelFont, valueFont));
            document.add(createInfoParagraph("Sex", weddingCertificate.getSexe(), labelFont, valueFont));
            document.add(createInfoParagraph("Nom Couple", weddingCertificate.getNomcouple(), labelFont, valueFont));
            document.add(createInfoParagraph("Prenom Couple", weddingCertificate.getPrenomcouple(), labelFont, valueFont));

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
    public List<WeddingCertificate> getWedBYCIN(String cin) { return weddingCertificateRepository.findByCin(cin);}

}


