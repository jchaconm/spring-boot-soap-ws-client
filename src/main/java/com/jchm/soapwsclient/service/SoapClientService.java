package com.jchm.soapwsclient.service;

import com.jchm.soapwsclient.api.getUser.GetUserRequest;
import com.jchm.soapwsclient.api.getUser.GetUserResponse;
import com.jchm.soapwsclient.api.getUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.validation.constraints.Null;

@Service
public class SoapClientService {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;


    public User getUser(GetUserRequest request){
        template = new WebServiceTemplate(marshaller);
        // user =  (User)
        Object obj = template.marshalSendAndReceive("http://localhost:8090/soapWS", request);
        User user = GetUserResponse.class.cast(obj).getUser();

        return user;
    }



}
