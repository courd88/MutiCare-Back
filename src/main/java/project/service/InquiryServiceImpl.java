package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.InquiryDto;
import project.mapper.InquiryMapper;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryMapper inquiryMapper;
	
	@Override
	public List<InquiryDto> inquiryList() throws Exception {
		return inquiryMapper.inquiryList();
	}

	@Override
	public void insertInquiry(InquiryDto inquiryDto) throws Exception {
		inquiryMapper.insertInquiry(inquiryDto);
	}

	@Override
	public InquiryDto inquiryDetail(int inquiryIdx) throws Exception {
		inquiryMapper.updateHitCount(inquiryIdx);
		return inquiryMapper.inquiryDetail(inquiryIdx);
	}

	@Override
	public void updateInquiry(InquiryDto inquiryDto) throws Exception {
		inquiryMapper.updateInquiry(inquiryDto);
	}

	@Override
	public void deleteInquiry(int inquiryIdx) throws Exception {
		inquiryMapper.deleteInquiry(inquiryIdx);
	}

}
