package fr.jeromelesaux.app.bebop.kml;

import de.micromata.opengis.kml.v_2_2_0.*;
import fr.jeromelesaux.app.bebop.entity.DetailsData;
import fr.jeromelesaux.app.bebop.entity.PUD;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */
public class KmlFile {
    private final static Logger LOG = Logger.getLogger(KmlFile.class.getName());
    private Document document;

    public void generate(PUD pud, File fileout)
            throws JAXBException, FileNotFoundException {
        Kml kml = new Kml();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        document = kml.createAndSetDocument().withName("Fly of the " + pud.getDate() + " for the drone " + pud.getProductName() + pud.getSerialNumber());

        final Placemark placemark = document.createAndAddPlacemark();
        placemark.setName("Fly of the " + pud.getDate() + " for the drone " + pud.getProductName() + pud.getSerialNumber());
        placemark.setVisibility(true);
        placemark.setOpen(false);
        final LineString line = KmlFactory.createLineString();
        line.setExtrude(false);
        line.setAltitudeMode(AltitudeMode.RELATIVE_TO_GROUND);
        for (DetailsData detailsData : pud.getDetailsData()) {
//            LOG.info("add lineString "  + detailsData.getProductGpsLongitude() + "," + detailsData.getProductGpsLatitude() +"," +detailsData.getAltitude());
            if (detailsData.getProductGpsAvailable() && !detailsData.getProductGpsLatitude().equals(500.)) {
                coordinates.add(new Coordinate(detailsData.getProductGpsLongitude(), detailsData.getProductGpsLatitude(),(detailsData.getAltitude()/1000)));
            }

        }
        line.setCoordinates(coordinates);
        placemark.setGeometry(line);
        final JAXBContext jaxbContext = JAXBContext.newInstance(Kml.class);
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(kml,new FileOutputStream(fileout));

    }
}
