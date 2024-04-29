package com.aionemu.gameserver.dataholders.loadingutils;

import com.aionemu.gameserver.skillengine.model.LinkedSkill;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class LinkedSkillDATA {
    private List<LinkedSkill> linkedSkills;

    public LinkedSkillDATA() {
        loadLinkedSkillsFromXML();
    }

    private void loadLinkedSkillsFromXML() {
        try {
            // Criar o contexto JAXB para a classe LinkedSkill
            JAXBContext context = JAXBContext.newInstance(LinkedSkill.class);

            // Criar o Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Desserializar o arquivo XML
            linkedSkills = ((LinkedSkill) unmarshaller.unmarshal(new File("linked_skill.xml"))).getListLinkedSkills();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

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
}
