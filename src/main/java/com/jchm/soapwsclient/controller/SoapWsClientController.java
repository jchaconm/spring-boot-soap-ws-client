package com.jchm.soapwsclient.controller;

import com.jchm.soapwsclient.api.getUser.GetUserRequest;
import com.jchm.soapwsclient.api.getUser.User;
import com.jchm.soapwsclient.service.SoapClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SoapWsClientController {

    @Autowired
    private SoapClientService soapClientService;

    @PostMapping("/getUser")
    public @ResponseBody
    User getUser (@RequestBody GetUserRequest request){

       return soapClientService.getUser(request);
    }
}
