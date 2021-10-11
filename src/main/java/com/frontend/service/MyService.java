package com.frontend.service;

import com.frontend.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.frontend.repository.MyRepo;


@Service
public class MyService {

    @Autowired
    private MyRepo repo;

    public MyModel getClient(int id) { return repo.getClient(id); }

    public MyModel saveClient(MyModel client) { return repo.addClient(client); }

    public MyModel updateClient(MyModel client) { return repo.updateClient(client); }

    public MyModel getClientByName(String name) { return repo.getClientByName(name); }

    public Iterable<MyModel> getClients() { return repo.getClients(); }

    public void deleteClient(Integer id) { repo.deleteClient(id); }

}
