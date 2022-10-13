package org.iesfm.entity;

public class Comic {

    private String superHeroe;
    private String company;
    private String creator;
    private String firstAppear;
    private String dateAppear;

    public Comic(String superHeroe, String company, String creator, String firstAppear, String dateAppear) {
        this.superHeroe = superHeroe;
        this.company = company;
        this.creator = creator;
        this.firstAppear = firstAppear;
        this.dateAppear = dateAppear;
    }

    public String getSuperHeroe() {
        return superHeroe;
    }

    public void setSuperHeroe(String superHeroe) {
        this.superHeroe = superHeroe;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFirstAppear() {
        return firstAppear;
    }

    public void setFirstAppear(String firstAppear) {
        this.firstAppear = firstAppear;
    }

    public String getDateAppear() {
        return dateAppear;
    }

    public void setDateAppear(String dateAppear) {
        this.dateAppear = dateAppear;
    }
}
