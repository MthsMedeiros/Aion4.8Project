package com.aionemu.gameserver.skillengine.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class LinkedSkill {

   @XmlAttribute(name="minLevel", required = true)
    private int minLevel;

    @XmlAttribute(name="race", required = true)
    private String race;

    @XmlAttribute
    private Boolean stigma=false;

    @XmlAttribute(name="name", required = true)
    private String name;

    @XmlAttribute(name="skillLevel", required = true)
    private int skillLevel;

    @XmlAttribute(name="skillId", required = true)
    private int skillId;

    @XmlAttribute(name="classId", required = true)
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