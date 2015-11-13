package fr.jeromelesaux.app.bebop;

import com.google.gson.Gson;
import fr.jeromelesaux.app.bebop.csv.CsvFile;
import fr.jeromelesaux.app.bebop.entity.PUD;
import fr.jeromelesaux.app.bebop.kml.KmlFile;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */
public class Main {
    private final static Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        if ( args.length != 1) {
            LOG.info("Usage : bebop-plan-de-vol <PUD Json file>");
        } else {

            final File pudFile = new File(args[0]);
            LOG.info("Reading of pud file " + pudFile.getAbsolutePath());
            Gson gson = new Gson();
            try {
                final PUD pud = gson.fromJson(new FileReader(pudFile),PUD.class);
                LOG.info("Unraw data.");
                pud.unRawData();
                LOG.info("Generate csv file.");
                CsvFile csvFile = new CsvFile();
                csvFile.generate(pud,new File(pud.getProductId() + pud.getFormatedDate() +".csv"));
                LOG.info("Generate KML file.");
                KmlFile kmlFile = new KmlFile();
                kmlFile.generate(pud,new File(pud.getProductId() + pud.getFormatedDate() +".kml"));
                LOG.info("Files " + pud.getProductId() + pud.getFormatedDate() +".csv " + pud.getProductId() + pud.getFormatedDate() +".kml generated.");
            } catch (FileNotFoundException e) {
               LOG.severe("Cannot find pud file " + pudFile.getAbsolutePath());
            } catch (IOException e) {
                LOG.severe("Cannot create Csv file.");
            } catch (JAXBException e) {
                LOG.severe("Cannot create kml file.");
            } catch (ParseException e) {
                LOG.severe("Cannot parse date of the pud file.");
            }

        }
    }
}
