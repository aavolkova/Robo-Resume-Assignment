package me.anna.demo.models;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    @Size(min=1, max=50)
    private String name;


    @NotNull
    @Size(min=1, max=50)
    private String emailAddress;


    @NotNull
    @Size
    private String organisation;

    @NotNull
    private LocalDate startDate;


    private LocalDate endDate;




    // private Date endDate = LocalDate.now();
    //private LocalDate endDate = null;



    private long employedDays;

    public long getEmployedDays()
    {
        return employedDays;
    }
    public void setEmployedDays(long employedDays) {
        this.employedDays = employedDays;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }



    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) { this.startDate = LocalDate.parse(startDate); }


    public LocalDate getEndDate()  {  return endDate;    }

    public void setEndDate(String endDate) {
        this.endDate = LocalDate.parse(endDate);
    }


    //public void setEndDate(LocalDate endDate) { this.endDate = endDate; }



}
