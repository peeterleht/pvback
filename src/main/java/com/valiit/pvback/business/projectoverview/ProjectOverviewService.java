package com.valiit.pvback.business.projectoverview;

import com.valiit.pvback.business.projectoverview.dto.PartInfo;
import com.valiit.pvback.business.projectoverview.dto.ProcessInfo;
import com.valiit.pvback.business.projectoverview.dto.ProjectOverview;
import com.valiit.pvback.domain.process.Process;
import com.valiit.pvback.domain.process.ProcessMapper;
import com.valiit.pvback.domain.process.ProcessRepository;
import com.valiit.pvback.domain.process.part.Part;
import com.valiit.pvback.domain.process.part.PartMapper;
import com.valiit.pvback.domain.process.processpart.ProcessPartMapper;
import com.valiit.pvback.domain.process.processpart.ProcessPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectOverviewService {

    private final ProcessRepository processRepository;
    private final ProcessMapper processMapper;
    private final PartMapper partMapper;
    private final ProcessPartRepository processPartRepository;

    public ProjectOverview getProjectOverview(Integer projectId) {
        ProjectOverview projectOverview = new ProjectOverview();

        // todo: processRepository ja projectId abil leida ülesse kõik projekti protsessid 'process'
        // todo: processMapperi toProcessInfos() abil luua List<ProcessInfo> processInfos; ja panna projectOverview külge

        List<Process> processes = processRepository.findAllProcessesBy(projectId);
        List<ProcessInfo> processInfos = processMapper.toProcessInfos(processes);
        projectOverview.setProcessInfos(processInfos);

        List<Part> parts = processPartRepository.findPartsBy(projectId);
        List<PartInfo> partInfos = partMapper.toPartInfos(parts);
        projectOverview.setPartInfos(partInfos);


        // todo: processPartRepository ja findPartsBy(projectId) abil leida ülesse kõik projekti partid 'parts'
        // todo: partMapperi abil luua List<PartInfo> partInfos ja panna projectOverview külge


        // todo: for tsükkel partInfos listist
        // todo: for tsükkel partInfos listist
        // todo: igal tsüklil partInfo.getPartId() ja processPartRepository.findProcessPartsBy(partId); abil,
        //  leiame List<ProcessPart> 'processParts' listi

        // todo: ProcessPartMapper.toProcessPartInfos() abil mapime objektid ümber List<ProcessPartInfo>  'processPartInfos'
        // todo: ja paneme tulemuse partInfo külge


        // todo: FINITO, JEEEEEE!!!!!!!


        return projectOverview;
    }
}
