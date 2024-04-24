package com.valiit.pvback.business.timelog;


import com.valiit.pvback.business.timelog.dto.TimeLogRequest;
import com.valiit.pvback.business.timelog.dto.TimeLogResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TimeLogController {
    private final TimeLogService timeLogService;

    @PutMapping("/timelog")
    @Operation(summary = "Konkreetse timelogi kande uuendamine")
    public void updateTimeLog(@RequestParam Integer timeLogId, @RequestBody @Valid TimeLogRequest timeLogRequest) {
        timeLogService.updateTimeLog(timeLogId, timeLogRequest);
    }

    @PostMapping("/timelog")
    @Operation(summary = "kasutajale uue timelogi kande loomi")
    public void addTimeLog(@RequestParam Integer userId, Integer projectId) {
        timeLogService.addTimeLog(userId, projectId);
    }

    @GetMapping("/timelog")
    public TimeLogResponse getTimelog(@RequestParam Integer timeLogId) {
        return timeLogService.getTimeLog(timeLogId);
    }
    @GetMapping("/timelogs")
    public List<TimeLogResponse> getAllTimeLogs(@RequestParam Integer userId){
        return timeLogService.getAllTimeLogs(userId);
    }


}