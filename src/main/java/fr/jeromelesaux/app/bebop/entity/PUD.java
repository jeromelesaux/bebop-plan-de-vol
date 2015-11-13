package fr.jeromelesaux.app.bebop.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */

public class PUD implements Serializable{

    private transient static final Logger LOG = Logger.getLogger(PUD.class.getName());

    @SerializedName("version")
    private String version;
    @SerializedName("software_version")
    private String  softwareVersion;
    @SerializedName("hardware_version" )
    private String hardwareVersion;
    @SerializedName("date")
    private String date;
    @SerializedName("product_id")
    private Integer productId;
    @SerializedName("serial_number")
    private String serialNumber;
    @SerializedName("product_name")
    private String productName;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("run_origin")
    private String runOrigin;
    @SerializedName("controller_model")
    private String controllerModel;
    @SerializedName("controller_application")
    private String controllerApplication;
    @SerializedName("product_style")
    private String productStyle;
    @SerializedName("product_accessory")
    private String productAccessory;
    @SerializedName("gps_available")
    private Boolean gpsAvailable;
    @SerializedName("gps_latitude")
    private Double gpsLatitude;
    @SerializedName("gps_longitude")
    private Double gpsLongitude;
    @SerializedName("crash")
    private Integer crash;
    @SerializedName("jump")
    private Integer jump;
    @SerializedName("run_time")
    private Integer runTime;
    @SerializedName("total_run_time")
    private Integer totalRunTime;
    @SerializedName("details_headers")
    private List<String> detailsHeaders;
    @SerializedName("details_data")
    private List<List<Object>> rawData;

    private transient Calendar calendar;
    private transient List<DetailsData> detailsData = new ArrayList<DetailsData>();




    public PUD() {
    }

    public List<List<Object>> getRawData() {
        return rawData;
    }

    public void setRawData(List<List<Object>> rawData) {
        this.rawData = rawData;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRunOrigin() {
        return runOrigin;
    }

    public void setRunOrigin(String runOrigin) {
        this.runOrigin = runOrigin;
    }

    public String getControllerModel() {
        return controllerModel;
    }

    public void setControllerModel(String controllerModel) {
        this.controllerModel = controllerModel;
    }

    public String getControllerApplication() {
        return controllerApplication;
    }

    public void setControllerApplication(String controllerApplication) {
        this.controllerApplication = controllerApplication;
    }

    public String getProductStyle() {
        return productStyle;
    }

    public void setProductStyle(String productStyle) {
        this.productStyle = productStyle;
    }

    public String getProductAccessory() {
        return productAccessory;
    }

    public void setProductAccessory(String productAccessory) {
        this.productAccessory = productAccessory;
    }

    public Boolean getGpsAvailable() {
        return gpsAvailable;
    }

    public void setGpsAvailable(Boolean gpsAvailable) {
        this.gpsAvailable = gpsAvailable;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Integer getCrash() {
        return crash;
    }

    public void setCrash(Integer crash) {
        this.crash = crash;
    }

    public Integer getJump() {
        return jump;
    }

    public void setJump(Integer jump) {
        this.jump = jump;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public Integer getTotalRunTime() {
        return totalRunTime;
    }

    public void setTotalRunTime(Integer totalRunTime) {
        this.totalRunTime = totalRunTime;
    }

    public List<String> getDetailsHeaders() {
        return detailsHeaders;
    }

    public void setDetailsHeaders(List<String> detailsHeaders) {
        this.detailsHeaders = detailsHeaders;
    }

    public List<DetailsData> getDetailsData() {
        return detailsData;
    }

    public void setDetailsData(List<DetailsData> detailsData) {
        this.detailsData = detailsData;
    }
    
    public String getFormatedDate() {
        if (calendar!=null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
            return dateFormat.format(calendar.getTime());
        }
        return "";
    }

    public void unRawData() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kkmmss+");
        calendar = new GregorianCalendar();
        calendar.setTime(dateFormat.parse(date));
        
        for (List<Object> raw : rawData) {
            int index=0;
            DetailsData data = new DetailsData();
            for (String detailsHeader : detailsHeaders) {
                if ("time".equals(detailsHeader)) {
                    data.setTime((Double) raw.get(index));
                } else if ("battery_level".equals(detailsHeader)) {
                    data.setBatteryLevel((Double) raw.get(index));
                } else if ("controller_gps_longitude".equals(detailsHeader)) {
                    data.setControllerGpsLongitude((Double) raw.get(index));
                } else if ("controller_gps_latitude".equals(detailsHeader)) {
                    data.setControllerGpsLatitude((Double) raw.get(index));
                } else if ("flying_state".equals(detailsHeader))  {
                    data.setFlyingState((Double) raw.get(index));
                }  else if ("alert_state".equals(detailsHeader)) {
                    data.setAlertState((Double) raw.get(index));
                }  else if ("wifi_signal".equals(detailsHeader)) {
                    data.setWifiSignal((Double) raw.get(index));
                } else if ("product_gps_available".equals(detailsHeader)) {
                    data.setProductGpsAvailable((Boolean) raw.get(index));
                }  else if ("product_gps_longitude".equals(detailsHeader)) {
                    data.setProductGpsLongitude((Double) raw.get(index));
                }  else if ("product_gps_latitude".equals(detailsHeader)) {
                    data.setProductGpsLatitude((Double) raw.get(index));
                } else if ("product_gps_position_error".equals(detailsHeader)) {
                    data.setProductGpsPositionError((Double) raw.get(index));
                }  else if ("speed_vx".equals(detailsHeader)) {
                    data.setSpeedVx((Double) raw.get(index));
                } else if ("speed_vy".equals(detailsHeader)) {
                    data.setSpeedVy((Double) raw.get(index));
                } else if ("speed_vz".equals(detailsHeader)) {
                    data.setSpeedVz((Double) raw.get(index));
                } else if ("angle_phi".equals(detailsHeader)) {
                    data.setAnglePhi((Double) raw.get(index));
                } else if ("angle_theta".equals(detailsHeader)) {
                    data.setAngleTheta((Double) raw.get(index));
                } else if ("angle_psi".equals(detailsHeader)) {
                    data.setAnglePsi((Double) raw.get(index));
                } else if ("altitude".equals(detailsHeader)) {
                    data.setAltitude((Double) raw.get(index));
                } else if ("flip_type".equals(detailsHeader)) {
                    data.setFlipType((Double) raw.get(index));
                } else if ("speed".equals(detailsHeader)) {
                    data.setSpeed((Double) raw.get(index));
                }  else {
                    LOG.info("Unsupported header value " + detailsHeader);
                }
                index++;
            }
            detailsData.add(data);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PUD)) return false;

        PUD pud = (PUD) o;

        if (getVersion() != null ? !getVersion().equals(pud.getVersion()) : pud.getVersion() != null) return false;
        if (getHardwareVersion() != null ? !getHardwareVersion().equals(pud.getHardwareVersion()) : pud.getHardwareVersion() != null)
            return false;
        if (getDate() != null ? !getDate().equals(pud.getDate()) : pud.getDate() != null) return false;
        if (getProductId() != null ? !getProductId().equals(pud.getProductId()) : pud.getProductId() != null)
            return false;
        if (getSerialNumber() != null ? !getSerialNumber().equals(pud.getSerialNumber()) : pud.getSerialNumber() != null)
            return false;
        return !(getUuid() != null ? !getUuid().equals(pud.getUuid()) : pud.getUuid() != null);

    }

    @Override
    public int hashCode() {
        int result = getVersion() != null ? getVersion().hashCode() : 0;
        result = 31 * result + (getHardwareVersion() != null ? getHardwareVersion().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getProductId() != null ? getProductId().hashCode() : 0);
        result = 31 * result + (getSerialNumber() != null ? getSerialNumber().hashCode() : 0);
        result = 31 * result + (getUuid() != null ? getUuid().hashCode() : 0);
        return result;
    }
}
