package com.valiit.pvback.business.projectoverview;

import com.valiit.pvback.business.projectoverview.dto.PartInfo;
import com.valiit.pvback.business.projectoverview.dto.ProcessInfo;
import com.valiit.pvback.business.projectoverview.dto.ProcessPartInfo;
import com.valiit.pvback.business.projectoverview.dto.ProjectOverviewInfos;
import com.valiit.pvback.domain.process.Process;
import com.valiit.pvback.domain.process.ProcessMapper;
import com.valiit.pvback.domain.process.ProcessRepository;
import com.valiit.pvback.domain.process.part.Part;
import com.valiit.pvback.domain.process.part.PartMapper;
import com.valiit.pvback.domain.process.part.PartRepository;
import com.valiit.pvback.domain.process.processpart.ProcessPart;
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
    private final PartRepository partRepository;
    private final ProcessPartRepository processPartRepository;
    private final ProcessPartMapper processPartMapper;

    public ProjectOverviewInfos getProjectOverview(Integer projectId) {
        ProjectOverviewInfos projectOverviewInfos = new ProjectOverviewInfos();

        // todo: processRepository ja projectId abil leida ülesse kõik projekti protsessid 'process'
        // todo: processMapperi toProcessInfos() abil luua List<ProcessInfo> processInfos; ja panna projectOverview külge

        List<Process> processes = processRepository.findAllProcessesBy(projectId);
        List<ProcessInfo> processInfos = processMapper.toProcessInfos(processes);
        projectOverviewInfos.setProcessInfos(processInfos);

        List<Part> parts = processPartRepository.findPartsByProjectId(projectId);
        List<PartInfo> partInfos = partMapper.toPartInfos(parts);
        projectOverviewInfos.setPartInfos(partInfos);

        for (PartInfo partInfo : partInfos) {
            List<ProcessPart> processParts = processPartRepository.findProcessPartsBy(partInfo.getPartId());
            List<ProcessPartInfo> processPartInfos = processPartMapper.toProcessPartInfos(processParts);
            partInfo.setProcessPartInfos(processPartInfos);
        }
        return projectOverviewInfos;

        // todo: processPartRepository ja findPartsBy(projectId) abil leida ülesse kõik projekti partid 'parts'
        // todo: partMapperi abil luua List<PartInfo> partInfos ja panna projectOverview külge


        // todo: for tsükkel partInfos listist
        // todo: igal tsüklil partInfo.getPartId() ja processPartRepository.findProcessPartsBy(partId); abil,
        //  leiame List<ProcessPart> 'processParts' listi

        // todo: ProcessPartMapper.toProcessPartInfos() abil mapime objektid ümber List<ProcessPartInfo>  'processPartInfos'
        // todo: ja paneme tulemuse partInfo külge


        // todo: FINITO, JEEEEEE!!!!!!!

    }
}
