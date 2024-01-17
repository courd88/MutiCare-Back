package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.InquiryDto;

@Mapper
public interface InquiryMapper {
	
	List<InquiryDto> inquiryList() throws Exception;
	void insertInquiry(InquiryDto inquiryDto) throws Exception;
	InquiryDto inquiryDetail(int inquiryIdx) throws Exception;
	void updateInquiry(InquiryDto inquiryDto) throws Exception;
	void deleteInquiry(int inquiryIdx) throws Exception;
	void updateHitCount(int inquiryIdx) throws Exception;
	
	

}
