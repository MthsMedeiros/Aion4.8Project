package com.aionemu.gameserver.dataholders.loadingutils;

import com.aionemu.gameserver.dataholders.DataManager;
import com.aionemu.gameserver.skillengine.model.LinkedSkill;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "linked_skill")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkedSkillDATA {

    @XmlElement(name = "skill")
    private List<LinkedSkill> linkedSkills;


    public boolean doesSkillExist(int skillIdToSearch) {
        // Verificar se a lista de habilidades está vazia
        if (linkedSkills == null || linkedSkills.isEmpty()) {
            return false;
        }

        // Iterar sobre cada habilidade e verificar se o ID corresponde
        for (LinkedSkill skill : linkedSkills) {
            if (skill.getSkillId() == skillIdToSearch) {
                return true;
            }
        }

        // Se não encontrou o ID da habilidade
        return false;
    }

    public List<LinkedSkill> getLinkedSkillsByName(String skillName) {
        List<LinkedSkill> resultSkills = new ArrayList<>();

        if (linkedSkills == null || linkedSkills.isEmpty()) {
            return resultSkills;
        }
        for (LinkedSkill skill : linkedSkills) {
            if (skill.getName().equals(skillName)) {
                resultSkills.add(skill);
                //break;
            }
        }

        return resultSkills;

    }
}