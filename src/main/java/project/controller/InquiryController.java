package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.dto.InquiryDto;
import project.service.InquiryService;

@Slf4j
@RestController
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
//	@ApiOperation(value="게시판 목록 조회", notes="등록된 게시물 목록을 조회합니다.")
	@GetMapping("/api/inquiry")
	public ResponseEntity<List<InquiryDto>> inquiryList() throws Exception {
		List<InquiryDto> list = inquiryService.inquiryList();
		if (list != null && list.size() > 0 ) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@PostMapping("/api/inquiry/write")
	public ResponseEntity<String> insertInquiry(
			@RequestBody InquiryDto inquiryDto) throws Exception {
		try {
			inquiryService.insertInquiry(inquiryDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록오류");
		}
		return ResponseEntity.status(HttpStatus.OK).body("정상처리");
	}
	
	@GetMapping("/api/inquiry/{inquiryIdx}")
	public ResponseEntity<InquiryDto> openInquiryDetail(@PathVariable("inquiryIdx") int inquiryIdx) throws Exception {
		InquiryDto inquiryDto = inquiryService.inquiryDetail(inquiryIdx);
		if (inquiryDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(inquiryDto);
		}
	}
	
	@PutMapping("/api/inquiry/{inquiryIdx}")
	public void updateInquiry(@PathVariable("inquiryIdx") int inquiryIdx, @RequestBody InquiryDto inquiryDto) throws Exception {
		inquiryDto.setInquiryIdx(inquiryIdx);
		inquiryService.updateInquiry(inquiryDto);
	}
	
	@DeleteMapping("/api/inquiry/{inquiryIdx}")
	public void deleteInquiry(@PathVariable("inquiryIdx") int inquiryIdx) throws Exception {
		inquiryService.deleteInquiry(inquiryIdx);
	}

}
