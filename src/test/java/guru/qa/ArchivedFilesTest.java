package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ArchivedFilesTest {

    String archiveName = "files.zip";

    private final ClassLoader classLoader = ArchivedFilesTest.class.getClassLoader();

    @Test
    @DisplayName("Read Csv file from Zip and check its content")
    void archivedCsvTest() throws Exception {
        boolean csvExists = false;
        try (InputStream inputStream = classLoader.getResourceAsStream(archiveName);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                final String fileName = entry.getName();
                if (fileName.endsWith(".csv")) {
                    csvExists = true;
                    Reader reader = new InputStreamReader(zipInputStream);
                    CSVReader csvReader = new CSVReader(reader);
                    List<String[]> content = csvReader.readAll();
                    assertThat(content.size()).isEqualTo(5);
                    assertThat(content.get(0)).containsExactly("superhero", " description");
                    assertThat(content.get(1)).containsExactly("batman", " uses technology");
                    assertThat(content.get(2)).containsExactly("superman", " flies through the air");
                    assertThat(content.get(3)).containsExactly("spiderman", " uses a web");
                    assertThat(content.get(4)).containsExactly("ghostrider", " rides a motorcycle");
                    break;
                }
            }
        }
        assertThat(csvExists).as("No Csv file in the archive").isTrue();
    }

    @Test
    @DisplayName("Read Xls file from Zip and check its content")
    void archivedXlsTest() throws Exception {
        boolean xlsExists = false;
        try (InputStream inputStream = classLoader.getResourceAsStream(archiveName);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                final String fileName = entry.getName();
                if (fileName.endsWith(".xls") | fileName.endsWith(".xlsx")) {
                    xlsExists = true;
                    XLS xls = new XLS(zipInputStream);
                    assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(3).getStringCellValue())
                            .isEqualTo("Wedding invitation tracker");
                    assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(3).getStringCellValue())
                            .isEqualTo("Isabel Gracia");
                    assertThat(xls.excel.getSheetAt(0).getRow(16).getCell(6).getCellFormula())
                            .isEqualTo("SUBTOTAL(109,tblInvites['# IN PARTY])");
                    break;
                }
            }
        }
        assertThat(xlsExists).as("No xls file in the archive").isTrue();
    }

    @Test
    @DisplayName("Read Pdf file from Zip and check its content")
    void archivedPdfTest() throws Exception {
        boolean pdfExists = false;
        try (InputStream inputStream = classLoader.getResourceAsStream(archiveName);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                final String fileName = entry.getName();
                if (fileName.endsWith(".pdf")) {
                    pdfExists = true;
                    PDF pdf = new PDF(zipInputStream);
                    String cleanedText = pdf.text.replace("\u00a0", " ");
                    assertThat(cleanedText).contains("Александр Пушкин")
                            .startsWith("В поле чистом серебрится…")
                            .endsWith("1833 г.\n");
                    break;
                }
            }
        }
        assertThat(pdfExists).as("No pdf file in the archive").isTrue();
    }

}