package com.aionemu.gameserver.skillengine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LinkedSkill {

    public List<LinkedSkill> getListLinkedSkills() {
        return listLinkedSkills;
    }

    public void setListLinkedSkills(List<LinkedSkill> listLinkedSkills) {
        this.listLinkedSkills = listLinkedSkills;
    }

    List<LinkedSkill> listLinkedSkills;

    private int minLevel;

    private String race;

    private Boolean stigma;

    private String name;

    private int skillLevel;

    private int skillId;

    private String classID;

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Boolean getStigma() {
        return stigma;
    }

    public void setStigma(Boolean stigma) {
        this.stigma = stigma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
