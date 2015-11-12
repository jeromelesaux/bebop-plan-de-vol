import com.google.gson.Gson;
import fr.jeromelesaux.app.bebop.entity.PUD;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */
public class TestMarshallingJson {
    private Logger LOG = Logger.getLogger(TestMarshallingJson.class.getName());

    @Test
    public void marshallingData() {
        PUD pud = new PUD();
        pud.setCrash(0);
        pud.setGpsAvailable(true);
        pud.setControllerApplication("iPad");
        pud.setDetailsHeaders(Arrays.asList("time",
                "battery_level",
                "controller_gps_longitude",
                "controller_gps_latitude",
                "flying_state",
                "alert_state",
                "wifi_signal",
                "product_gps_available",
                "product_gps_longitude",
                "product_gps_latitude",
                "product_gps_position_error",
                "speed_vx",
                "speed_vy",
                "speed_vz",
                "angle_phi",
                "angle_theta",
                "angle_psi",
                "altitude",
                "flip_type",
                "speed"));

        List<List<Object>> detailsDatas = new ArrayList<List<Object>>();
        List<Object> data = new ArrayList<Object>();
        data.add(1);
        data.add(0);
        data.add(-0.1);
        data.add(-0.2);
        data.add(-.3);
        data.add(0);
        data.add(500.0);
        data.add(500.0);
        data.add(0);
        data.add(0);
        data.add(true);
        data.add(2.48);
        data.add(42.3);
        data.add(0);
        data.add(0);
        data.add(0.000000);
        data.add(0.000000);
        data.add(0.000000);
        data.add(32);
        data.add(0);
        detailsDatas.add(data);

        pud.setRawData(detailsDatas);

        Gson gson = new Gson();
        final String jsonBody = gson.toJson(pud);
        LOG.info(jsonBody);
        org.junit.Assert.assertTrue(jsonBody.length()>0);


    }

    @Test
    public void unmarshallingData() throws FileNotFoundException {
        Gson gson = new Gson();
        final PUD pud = gson.fromJson(new FileReader(TestMarshallingJson.class.getResource("/sample.pud.json").getPath()), PUD.class);
        LOG.info(pud.getVersion());
        org.junit.Assert.assertEquals(pud.getRawData().size(), 2971);
    }


    @Test
    public void unrawData() throws FileNotFoundException {
        Gson gson = new Gson();
        final PUD pud = gson.fromJson(new FileReader(TestMarshallingJson.class.getResource("/sample.pud.json").getPath()), PUD.class);
        pud.unRawData();
        org.junit.Assert.assertTrue(pud.getDetailsData().size()==2971);
    }
}
