package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.feedback.SysFeedback;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysFeedback}
 */
@Data
public class SysFeedbackInfo implements Serializable {
    Integer sysFeedbackId;
    String sysFeedbackName;
    String sysFeedbackText;
}