package com.valiit.pvback.business.system.dto;

import com.valiit.pvback.domain.system.feedback.SysFeedback;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link SysFeedback}
 */
@Value
public class SysFeedbackInfo implements Serializable {
    String sysFeedbackName;
    String sysFeedbackText;
}