package com.valiit.pvback.business.timelog;


import com.valiit.pvback.business.timelog.dto.TimeLogInfo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TimeLogController {
    private final TimeLogService timeLogService;

    @PostMapping("/timelog")
    public void postUserWorkHours(@RequestBody @Valid TimeLogInfo timeLogInfo) {
        timeLogService.saveUserWorkHours(timeLogInfo);
    }
}