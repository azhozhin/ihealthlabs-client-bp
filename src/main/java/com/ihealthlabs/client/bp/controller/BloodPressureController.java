package com.ihealthlabs.client.bp.controller;

import com.ihealthlabs.client.bp.ApiUtils;
import com.ihealthlabs.client.bp.beans.User;
import com.ihealthlabs.client.bp.entity.BPDataItem;
import com.ihealthlabs.client.bp.entity.BPDataMeasurement;
import com.ihealthlabs.client.bp.entity.BPDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@Scope("request")
@RequestMapping("/bp")
public class BloodPressureController {

    private static final Logger logger = LoggerFactory.getLogger(BloodPressureController.class);

    @Autowired
    private User user;

    @RequestMapping("/")
    public ModelAndView index()
    {
        return new ModelAndView("bp/index");
    }

    @RequestMapping("/data")
    public ModelAndView data()
    {
        ModelAndView mav = new ModelAndView("bp/data");
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/load")
    public ModelAndView load()
    {
        LocalDateTime from = LocalDateTime.of(1970, 1, 1, 0, 0, 1);
        LocalDateTime to = LocalDateTime.now();

        user.getAllBPData().clear();

        int page=1;
        BPDataResponse response = ApiUtils.bloodPressureData(user, from, to, page);

        if (response!=null && response.getErrorCode()==0)
        {
            for(BPDataItem item : response.getBpDataList()) {
                user.getAllBPData().add(BPDataMeasurement.from(item));
            }

            while(response.getNextPageUrl()!=null && !response.getNextPageUrl().isEmpty())
            {
                page++;
                response = ApiUtils.bloodPressureData(user, from, to, page);
                if (response==null || response.getErrorCode()!=0)
                {
                    break;
                }
                for(BPDataItem item : response.getBpDataList()) {
                    user.getAllBPData().add(BPDataMeasurement.from(item));
                }
            }
        }

        ModelAndView mav = new ModelAndView("bp/loaded");

        mav.addObject("count", user.getAllBPData().size());
        return mav;
    }
}
