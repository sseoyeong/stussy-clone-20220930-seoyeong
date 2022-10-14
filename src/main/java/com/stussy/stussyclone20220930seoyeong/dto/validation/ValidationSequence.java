package com.stussy.stussyclone20220930seoyeong.dto.validation;


import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeGroup.class,
        ValidationGroups.PatterCheckGroup.class,
        Default.class
})
public interface ValidationSequence {

}
