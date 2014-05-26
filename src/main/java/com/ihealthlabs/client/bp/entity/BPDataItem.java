package com.ihealthlabs.client.bp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BPDataItem {
    // WHO level
    @JsonProperty("BPL")
    private int bpl;

    // systolic
    @JsonProperty("HP")
    private double hp;

    // diastolic
    @JsonProperty("LP")
    private double lp;

    // heart rate
    @JsonProperty("HR")
    private int hr;

    // -1 it is null in the database
    // 1 heart rate is normal
    // 2 arrhythmia cordis
    // 3 unknown
    @JsonProperty("IsArr")
    private int isArr;

    // the last changing time of the data
    @JsonProperty("LastChangeTime")
    private long lastChangeTime;

    // the latitude of the testing place
    @JsonProperty("Lat")
    private double latitude;

    // the longitude of the testing place
    @JsonProperty("Lon")
    private double longitude;

    // measurement date time
    @JsonProperty("MDate")
    private long measurementDate;

    // the note of this data
    @JsonProperty("Note")
    private String note;

    // the unique identity
    @JsonProperty("DataID")
    private String dataId;

    // unique identity of user
    @JsonProperty("userid")
    private String userId;

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

    public long getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(long lastChangeTime) {
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

    public long getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(long measurementDate) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
