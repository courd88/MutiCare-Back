package project.service;

import java.util.List;

import project.dto.InquiryDto;

public interface InquiryService {
	
	List<InquiryDto> inquiryList() throws Exception;
	void insertInquiry(InquiryDto inquiryDto) throws Exception;
	InquiryDto inquiryDetail(int inquiryIdx) throws Exception;
	void updateInquiry(InquiryDto inquiryDto) throws Exception;
	void deleteInquiry(int inquiryIdx) throws Exception;

}
