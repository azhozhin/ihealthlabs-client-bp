package com.ihealthlabs.client.bp;

import com.ihealthlabs.client.bp.beans.User;
import com.ihealthlabs.client.bp.entity.AccessTokenResponse;
import com.ihealthlabs.client.bp.entity.BPDataResponse;
import com.ihealthlabs.client.bp.entity.ScSv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class ApiUtils {
    private static final Logger logger = LoggerFactory.getLogger(ApiUtils.class);

    private static final String CLIENT_ID = "9670e3c3d20e4685a3d2120108252640";
    private static final String CLIENT_SECRET = "224bf895608f4fb685b6fd205771c81d";
    private static final String REDIRECT_URI = "http://ihealthlabs-client-bp.zhozhin.com/auth";
    private static final Map<String, ScSv> apiAuth;
    private static final String API_NAME_BP = "OpenApiBP";
    static
    {
        apiAuth = new HashMap<>();
        apiAuth.put(API_NAME_BP, new ScSv("e1254734f3b547d2bf275e72d27ff629", "17028467566341999dffef4fd901c4b3"));
    }

    public static String loginUrl()
    {
        String url = new RequestBuilder("http://sandboxapi.ihealthlabs.com/OpenApiV2/OAuthv2/userauthorization/")
                .withParam("client_id", CLIENT_ID)
                .withParam("redirect_uri", REDIRECT_URI)
                .withParam("response_type", "code")
                .withParam("APIName", API_NAME_BP)
                .build();
        return url;
    }

    public static AccessTokenResponse requestAccessToken(User user) {
        String url = new RequestBuilder("http://sandboxapi.ihealthlabs.com/OpenApiV2/OAuthv2/userauthorization")
                .withParam("client_id", CLIENT_ID)
                .withParam("client_secret", CLIENT_SECRET)
                .withParam("redirect_uri", REDIRECT_URI)
                .withParam("grant_type", "authorization_code")
                .withParam("code", user.getCode())
                .build();

        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime now = LocalDateTime.now();
        AccessTokenResponse accessTokenResponse = null;
        try {
            accessTokenResponse = restTemplate.getForObject(url, AccessTokenResponse.class);

            if (accessTokenResponse.getErrorCode() == 0) {
                user.setAccessToken(accessTokenResponse.getAccessToken());
                user.setRefreshToken(accessTokenResponse.getRefreshToken());
                user.setDateTime(now);
                user.setExpires(now.plusSeconds(accessTokenResponse.getExpires()));
                user.setUserId(accessTokenResponse.getUserId());
            } else {
                logger.error("cannot refresh access token with errorCode: %d error: %s errorDescription: %s",
                        accessTokenResponse.getErrorCode(),
                        accessTokenResponse.getError(),
                        accessTokenResponse.getErrorDescription());
            }
        } catch (RestClientException e) {
            logger.error("rest client call failed", e);
        }
        return accessTokenResponse;
    }

    public static AccessTokenResponse refreshAccessToken(User user) {
        String url = new RequestBuilder("http://sandboxapi.ihealthlabs.com/OpenApiV2/OAuthv2/userauthorization")
                .withParam("client_id", CLIENT_ID)
                .withParam("client_secret", CLIENT_SECRET)
                .withParam("redirect_uri", REDIRECT_URI)
                .withParam("response_type", "refresh_token")
                .withParam("refresh_token", user.getRefreshToken())
                .withParam("UserID", user.getUserId())
                .build();

        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime now = LocalDateTime.now();
        AccessTokenResponse accessTokenResponse = null;
        try {
            accessTokenResponse = restTemplate.getForObject(url, AccessTokenResponse.class);
            if (accessTokenResponse.getErrorCode() == 0) {
                user.setAccessToken(accessTokenResponse.getAccessToken());
                user.setRefreshToken(accessTokenResponse.getRefreshToken());
                user.setDateTime(now);
                user.setExpires(now.plusSeconds(accessTokenResponse.getExpires()));
            } else {
                logger.error("cannot refresh access token with errorCode: %d error: %s errorDescription: %s",
                        accessTokenResponse.getErrorCode(),
                        accessTokenResponse.getError(),
                        accessTokenResponse.getErrorDescription());
            }
        } catch (RestClientException e) {
            logger.error("rest client call failed", e);
        }

        return accessTokenResponse;
    }

    public static BPDataResponse bloodPressureData(User user, LocalDateTime startDateTime, LocalDateTime endDateTime, int pageIndex){

        ScSv scsv = apiAuth.get(API_NAME_BP);
        RequestBuilder rb = new RequestBuilder(String.format("http://sandboxapi.ihealthlabs.com/openapiv2/user/%s/bp.json",user.getUserId()))
                .withParam("client_id", CLIENT_ID)
                .withParam("client_secret", CLIENT_SECRET)
                .withParam("access_token", user.getAccessToken())
                .withParam("sc", scsv.getSc())
                .withParam("sv", scsv.getSv());
        if (startDateTime!=null)
        {
            rb.withParam("start_time", startDateTime.toEpochSecond(ZoneOffset.UTC));
        }
        if (endDateTime!=null)
        {
            rb.withParam("end_time", endDateTime.toEpochSecond(ZoneOffset.UTC));
        }
        if (pageIndex>0)
        {
            rb.withParam("page_index", pageIndex);
        }
        String url= rb.build();

        BPDataResponse bpDataResponse = null;
        RestTemplate restTemplate = new RestTemplate();
        LocalDateTime now = LocalDateTime.now();
        try
        {
            bpDataResponse = restTemplate.getForObject(url, BPDataResponse.class);
        }
        catch (RestClientException e)
        {
            logger.error("rest client call failed", e);
        }
        return bpDataResponse;
    }
}
