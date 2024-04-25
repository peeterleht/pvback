package com.valiit.pvback.business.projectoverview;

import com.valiit.pvback.business.projectoverview.dto.ProjectOverview;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectOverviewService {

    public ProjectOverview getProjectOverview(Integer projectId) {
        ProjectOverview projectOverview = new ProjectOverview();

        // todo: processRepository ja projectId abil leida ülesse kõik projekti protsessid 'proccess'
        // todo: processMapperi toProcessInfos() abil luua List<ProcessInfo> processInfos; ja panna projectOverview külge


        // todo: processPartRepository ja findPartsBy(projectId) abil leida ülesse kõik projekti partid 'parts'
        // todo: partMapperi abil luua List<PartInfo> partInfos ja panna projectOverview külge


        // todo: for tsykkel partInfos listist
        // todo: for tsykkel partInfos listist
        // todo: igal tsyklil partInfo.getPartId() ja processPartRepository.findProcessPartsBy(partId); abil,
        //  leiame List<ProcessPart> 'processParts' listi

        // todo: ProcessPartMapper.toProcessPartInfos() abil mapime objektid ymber List<ProcessPartInfo>  'processPartInfos'
        // todo: ja paneme tulemuse partInfo kylge


        // todo: FINITO, JEEEEEE!!!!!!!




        return projectOverview;
    }
}
