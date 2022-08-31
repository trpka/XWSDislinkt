package com.example.agentApplication.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class JobOffer
{
    private Long id;
    private String position;
    private String description;
    private List<String> daily_activities;
    private List<String> qualifications;

    public JobOffer()
    {

    }
    public JobOffer(String position, String description, List<String> daily_activities, List<String> qualifications) {
        this.position = position;
        this.description = description;
        this.daily_activities = daily_activities;
        this.qualifications = qualifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription()
    {
        return  description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<String> getDaily_activities() {
        return daily_activities;
    }

    public void setDaily_activities(List<String> daily_activities) {
        this.daily_activities = daily_activities;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }
}
