package com.frontend.controller;

import com.frontend.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.frontend.service.MyService;
import java.util.*;


@Controller
public class MyController {

    @Autowired
    private MyService service;
    @GetMapping("/")
    public String homePage()
    {
        return "homePage";

    }
    @GetMapping("/addClient")
    public String addClient(Model model)
    {
        MyModel cl = new MyModel();
        model.addAttribute("client", cl);
        model.addAttribute("operationName", "create");
        return "addClient";

    }
    @GetMapping("/updateClient/{operation}")
    public String updateClient(Model model,@PathVariable("operation")String operation)
    {
        ArrayList<MyModel> listClients = (ArrayList<MyModel>) service.getClients();
        model.addAttribute("clients", listClients);
        model.addAttribute("client",listClients.get(0));
        model.addAttribute("operation",operation);
        return "updateClient";

    }
    @PostMapping("/crudClient/{operationName}")
    public ModelAndView crudClient(@PathVariable("operationName")String operation, @ModelAttribute MyModel client)
    {
        Iterable<MyModel> complist=service.getClients();
        Iterator itr = complist.iterator();
        MyModel lastElement = (MyModel) itr.next();
        while(itr.hasNext()) {
            lastElement = (MyModel) itr.next();
            if(client.getId()==lastElement.getId())
            {

                if(operation=="update")
                {
                    service.saveClient(client);
                    return new ModelAndView("redirect:/client/"+client.getId());
                }
                else if(operation=="delete")
                {
                    service.deleteClient(client.getId());
                    return new ModelAndView("redirect:/");
                }
            }
        }
        System.out.println("operation");
        client.setId(lastElement.getId()+1);
        service.saveClient(client);
        return new ModelAndView("redirect:/client/"+client.getId());

    }
    @GetMapping("/client/{id}")
    public String oneCompany(@PathVariable("id")int id,Model model)
    {
        MyModel client=service.getClient(id);
        model.addAttribute("client", client);
        return "theClient";

    }

    @GetMapping("/clientName/{name}")
    public String oneCompanyByName(@PathVariable("name")String name,Model model)
    {
        MyModel client=service.getClientByName(name);
        if(client!=null)
        {model.addAttribute("client", client);
            return "theClient";
        }
        else
            return "homePage";

    }
    @GetMapping("/listclients")
    public String listClients(Model model) {
        ArrayList<MyModel> listClients = (ArrayList<MyModel>) service.getClients();
        Collections.sort(listClients);
        model.addAttribute("clients", listClients);
        return "ListClients";
    }
}

