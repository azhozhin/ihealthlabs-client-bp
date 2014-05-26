package com.ihealthlabs.client.bp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessTokenResponse extends ResponseBase {

    @JsonProperty("APIName")
    private String apiName;

    @JsonProperty("AccessToken")
    private String accessToken;

    @JsonProperty("Expires")
    private long expires;

    @JsonProperty("RefreshToken")
    private String refreshToken;

    @JsonProperty("UserID")
    private String userId;

    @JsonProperty("client_para")
    private String clientPara;


    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClientPara() {
        return clientPara;
    }

    public void setClientPara(String clientPara) {
        this.clientPara = clientPara;
    }


}
