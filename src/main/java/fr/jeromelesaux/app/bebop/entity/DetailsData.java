package fr.jeromelesaux.app.bebop.entity;

import java.io.Serializable;

/**
 * Created by jlesaux on 12/11/15.
 * File ${FILE}
 */

public class DetailsData implements Serializable {


    private Double time;
    private Double batteryLevel;
    private Double controllerGpsLongitude;
    private Double controllerGpsLatitude;
    private Double flyingState;
    private Double alertState;
    private Double wifiSignal;
    private Boolean productGpsAvailable;
    private Double productGpsLongitude;
    private Double  productGpsLatitude;
    private Double productGpsPositionError;
    private Double speedVx;
    private Double speedVy;
    private Double speedVz;
    private Double anglePhi;
    private Double angleTheta;
    private Double anglePsi;
    private Double altitude;
    private Double flipType;
    private Double speed;


    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Double getControllerGpsLongitude() {
        return controllerGpsLongitude;
    }

    public void setControllerGpsLongitude(Double controllerGpsLongitude) {
        this.controllerGpsLongitude = controllerGpsLongitude;
    }

    public Double getControllerGpsLatitude() {
        return controllerGpsLatitude;
    }

    public void setControllerGpsLatitude(Double controllerGpsLatitude) {
        this.controllerGpsLatitude = controllerGpsLatitude;
    }

    public Double getFlyingState() {
        return flyingState;
    }

    public void setFlyingState(Double flyingState) {
        this.flyingState = flyingState;
    }

    public Double getAlertState() {
        return alertState;
    }

    public void setAlertState(Double alertState) {
        this.alertState = alertState;
    }

    public Double getWifiSignal() {
        return wifiSignal;
    }

    public void setWifiSignal(Double wifiSignal) {
        this.wifiSignal = wifiSignal;
    }

    public Boolean getProductGpsAvailable() {
        return productGpsAvailable;
    }

    public void setProductGpsAvailable(Boolean productGpsAvailable) {
        this.productGpsAvailable = productGpsAvailable;
    }

    public Double getProductGpsLongitude() {
        return productGpsLongitude;
    }

    public void setProductGpsLongitude(Double productGpsLongitude) {
        this.productGpsLongitude = productGpsLongitude;
    }

    public Double getProductGpsLatitude() {
        return productGpsLatitude;
    }

    public void setProductGpsLatitude(Double productGpsLatitude) {
        this.productGpsLatitude = productGpsLatitude;
    }

    public Double getProductGpsPositionError() {
        return productGpsPositionError;
    }

    public void setProductGpsPositionError(Double productGpsPositionError) {
        this.productGpsPositionError = productGpsPositionError;
    }

    public Double getSpeedVx() {
        return speedVx;
    }

    public void setSpeedVx(Double speedVx) {
        this.speedVx = speedVx;
    }

    public Double getSpeedVy() {
        return speedVy;
    }

    public void setSpeedVy(Double speedVy) {
        this.speedVy = speedVy;
    }

    public Double getSpeedVz() {
        return speedVz;
    }

    public void setSpeedVz(Double speedVz) {
        this.speedVz = speedVz;
    }

    public Double getAnglePhi() {
        return anglePhi;
    }

    public void setAnglePhi(Double anglePhi) {
        this.anglePhi = anglePhi;
    }

    public Double getAngleTheta() {
        return angleTheta;
    }

    public void setAngleTheta(Double angleTheta) {
        this.angleTheta = angleTheta;
    }

    public Double getAnglePsi() {
        return anglePsi;
    }

    public void setAnglePsi(Double anglePsi) {
        this.anglePsi = anglePsi;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getFlipType() {
        return flipType;
    }

    public void setFlipType(Double flipType) {
        this.flipType = flipType;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
