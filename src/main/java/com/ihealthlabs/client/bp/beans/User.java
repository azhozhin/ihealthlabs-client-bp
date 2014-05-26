package com.ihealthlabs.client.bp.beans;

import com.ihealthlabs.client.bp.entity.BPDataMeasurement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope("session")
public class User {

    private String code;
    private String accessToken;
    private String refreshToken;
    private String userId;
    private LocalDateTime dateTime;
    private LocalDateTime expires;

    private final List<BPDataMeasurement> allBPData;

    public User() {
        allBPData = new LinkedList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }

    public List<BPDataMeasurement> getAllBPData() {
        return allBPData;
    }
}
