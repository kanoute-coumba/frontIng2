package episen.pds.citizens.frontend.model;

import episen.pds.citizens.frontend.model.architectureModel.Building;

public class ObjectForModel {
    DateBeginOrEnd dateB;
    DateBeginOrEnd dateE;
    Building house;
    Users users;

    public ObjectForModel() {
    }

    public DateBeginOrEnd getDateB() {
        return dateB;
    }

    public void setDateB(DateBeginOrEnd dateB) {
        this.dateB = dateB;
    }

    public DateBeginOrEnd getDateE() {
        return dateE;
    }

    public void setDateE(DateBeginOrEnd dateE) {
        this.dateE = dateE;
    }

    public Building getHouse() {
        return house;
    }

    public void setHouse(Building house) {
        this.house = house;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
