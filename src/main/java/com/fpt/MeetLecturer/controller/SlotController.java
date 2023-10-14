package com.fpt.MeetLecturer.controller;

import com.fpt.MeetLecturer.business.ResponseDTO;
import com.fpt.MeetLecturer.business.SlotDTO;
import com.fpt.MeetLecturer.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/slot")
public class SlotController {
    @Autowired
    private SlotService slotService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getSlot(){
        ResponseDTO responseDTO = slotService.getSlot();

        return ResponseEntity.ok().body(responseDTO);
    }


    @GetMapping("/get/{subjectCode}")
    public ResponseEntity<ResponseDTO> getSlotBySubject(@PathVariable("subjectCode") String code){
        return ResponseEntity.ok().body(slotService.getSlotBySubjectCode(code));
    }

    @GetMapping("/get/ByDateRange/{startDay}/{endDay}")
    public ResponseEntity<ResponseDTO> getSlotBySubject(@PathVariable("startDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                        @PathVariable("endDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        return ResponseEntity.ok().body(slotService.getSlotByDate(startDate, endDate));
    }


    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> createNew(@RequestBody SlotDTO model){

        return ResponseEntity.ok().body(slotService.createSlot(model));
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> updateSlot(@RequestBody SlotDTO model, @PathVariable("id") int id){

        return ResponseEntity.ok().body(slotService.updateSlot(model));
        //System.out.println("OK");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(slotService.deleteSlot(id)) ;
    }
}
