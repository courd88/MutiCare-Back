package project.dto;

import lombok.Data;

@Data
public class InquiryDto {

	int InquiryIdx;
	String title;
	String contents;
	int hitCnt;
	String createdDt;
	String createdId;
	String updatedDt;
	String updatedId;
}
