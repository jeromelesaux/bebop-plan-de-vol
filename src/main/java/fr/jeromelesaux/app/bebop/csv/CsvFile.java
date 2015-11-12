package fr.jeromelesaux.app.bebop.csv;

import fr.jeromelesaux.app.bebop.entity.PUD;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */
public class CsvFile {
    private static final Logger LOG = Logger.getLogger(CsvFile.class.getName());

    public void generate(PUD pud, File fileout) throws IOException {
        final FileWriter fileWriter = new FileWriter(fileout);
        final List<String> headers = pud.getDetailsHeaders();
        for (String header : headers) {
            fileWriter.append(header)
                    .append(";");
        }
        fileWriter.append("\n");
        for (List<Object> objects : pud.getRawData()) {
            for (Object object : objects) {
                fileWriter.append(object.toString())
                        .append(";");
            }
            fileWriter.append("\n");
        }
        fileWriter.close();


    }
}
