package com.frontend.repository;

import com.frontend.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;
import com.frontend.FrontProperties;


@Slf4j
@Component
public class MyRepo {

    @Autowired
    private FrontProperties props;

    public MyModel getClient(int id)
    {
        String clientUrl=props.getApiUrl()+"/client/"+id;
        RestTemplate temp=new RestTemplate();
        ResponseEntity<MyModel> resp=temp.exchange(clientUrl,HttpMethod.GET,null,new ParameterizedTypeReference<MyModel>() {});
        return resp.getBody();
    }
    public MyModel getClientByName(String name)
    {
        String clientUrl=props.getApiUrl()+"/clientName/"+name;
        RestTemplate temp=new RestTemplate();
        ResponseEntity<MyModel> resp=temp.exchange(clientUrl,HttpMethod.GET,null,new ParameterizedTypeReference<MyModel>() {});
        return resp.getBody();
    }

    public Iterable<MyModel> getClients() {
        String clientUrl=props.getApiUrl()+"/listclients";
        RestTemplate temp=new RestTemplate();
        ResponseEntity<Iterable<MyModel>> resp=temp.exchange(clientUrl,HttpMethod.GET,null,new ParameterizedTypeReference<Iterable<MyModel>>() {});
        return resp.getBody();
    }
    public MyModel addClient(MyModel client)
    {
        String clientUrl=props.getApiUrl()+"/addclient";
        HttpEntity<MyModel> request=new HttpEntity<MyModel>(client);
        RestTemplate temp=new RestTemplate();
        ResponseEntity<MyModel> resp=temp.exchange(clientUrl,HttpMethod.POST,request,MyModel.class);
        return resp.getBody();
    }
    public MyModel updateClient(MyModel client)
    {
        String clientUrl=props.getApiUrl()+"/updateclient";
        HttpEntity<MyModel> request=new HttpEntity<MyModel>(client);
        RestTemplate temp=new RestTemplate();
        ResponseEntity<MyModel> resp=temp.exchange(clientUrl,HttpMethod.POST,request,MyModel.class);
        return resp.getBody();
    }
    public void deleteClient(Integer id) {
        String clientUrl=props.getApiUrl()+"/deleteclient/"+id;
        RestTemplate temp=new RestTemplate();
        ResponseEntity<Void> resp=temp.exchange(clientUrl,HttpMethod.DELETE,null,Void.class);

    }
}
