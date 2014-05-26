package com.ihealthlabs.client.bp.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BPDataMeasurement {
    // WHO level
    private int bpl;

    // systolic
    private double hp;

    // diastolic
    private double lp;

    // heart rate
    private int hr;

    // -1 it is null in the database
    // 1 heart rate is normal
    // 2 arrhythmia cordis
    // 3 unknown
    private int isArr;

    // the last changing time of the data
    private LocalDateTime lastChangeTime;

    // the latitude of the testing place
    private double latitude;

    // the longitude of the testing place
    private double longitude;

    // measurement date time
    private LocalDateTime measurementDate;

    // the note of this data
    private String note;

    // the unique identity
    private String dataId;

    public static BPDataMeasurement from(BPDataItem item)
    {
        BPDataMeasurement result=  new BPDataMeasurement();

        result.setBpl(item.getBpl());
        result.setHp(item.getHp());
        result.setLp(item.getLp());
        result.setHr(item.getHr());
        result.setIsArr(item.getIsArr());
        Instant changeTimeInstant = Instant.ofEpochSecond(item.getLastChangeTime());
        result.setLastChangeTime(LocalDateTime.ofInstant(changeTimeInstant, ZoneOffset.UTC));
        result.setLatitude(item.getLatitude());
        result.setLongitude(item.getLongitude());
        Instant measurementDateInstant = Instant.ofEpochSecond(item.getMeasurementDate());
        result.setMeasurementDate(LocalDateTime.ofInstant(measurementDateInstant, ZoneOffset.UTC));
        result.setNote(item.getNote());
        result.setDataId(item.getDataId());
        return result;
    }

    public int getBpl() {
        return bpl;
    }

    public void setBpl(int bpl) {
        this.bpl = bpl;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getLp() {
        return lp;
    }

    public void setLp(double lp) {
        this.lp = lp;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getIsArr() {
        return isArr;
    }

    public void setIsArr(int isArr) {
        this.isArr = isArr;
    }

    public LocalDateTime getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(LocalDateTime lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(LocalDateTime measurementDate) {
        this.measurementDate = measurementDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
}
