package com.dalrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewMemberDto;
import com.dalrun.service.CrewMemberService;

@RestController
public class CrewMemberController {
	
	@Autowired
	CrewMemberService service;
	
//  @PostMapping("/join")
//  public ResponseEntity<String> joinCrew(@RequestBody CrewMemberDto memberdto){
//     int crewSeq = service.getCrewSeq(memberdto);
//     
//  }
	//가입 취소
	@PostMapping("OutCrew")
	  public boolean OutCrew(CrewMemberDto dto) {
	      return service.deleteFromList(dto);
		      
		}
	
	
	//가입 신청
	@PostMapping("joinCrew")
	   public String joinCrew(CrewMemberDto dto){
	
	      if(service.joinCrew(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }

	   @GetMapping("checkWaiting")
	   public boolean checkWaiting(CrewMemberDto dto){
		   System.out.println("CrewMemberController checkWaiting");
	      return service.isWaiting(dto);
	   }

	   @PostMapping("/approve")
	   public String approve(@RequestBody CrewMemberDto dto){
	      if(service.approve(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }

	   @PostMapping("/reject")
	   public String reject(@RequestBody CrewMemberDto dto){
	      if(service.reject(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }


}
