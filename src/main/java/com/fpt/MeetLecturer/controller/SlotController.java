package com.fpt.MeetLecturer.controller;

import com.fpt.MeetLecturer.business.ResponseDTO;
import com.fpt.MeetLecturer.business.SlotDTO;
import com.fpt.MeetLecturer.service.SlotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/slot")
public class SlotController {
    @Autowired
    private SlotService slotService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAllSlot(){
        ResponseDTO responseDTO = slotService.getAllSlot();

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/student")
    public ResponseEntity<ResponseDTO> getSlot(@RequestParam(name="subjectCode", required = false) String code,
                                               @RequestParam(name="startDay", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                               @RequestParam(name="endDay", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){
        ResponseDTO responseDTO = slotService.getSlotByStudent(code, startDate, endDate);

        return ResponseEntity.ok().body(responseDTO);
    }

    @GetMapping("/lecturer")
    public ResponseEntity<ResponseDTO> getSlotLecturer(@RequestParam(name="id", required = false) String id){
        ResponseDTO responseDTO = slotService.getSlotByLecturerId(id);

        return ResponseEntity.ok().body(responseDTO);
    }


    @PostMapping("")
    public ResponseEntity<ResponseDTO> createNew(@RequestBody SlotDTO model){

        return ResponseEntity.ok().body(slotService.createSlot(model));
    }


    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> updateSlot(@Valid  @RequestBody SlotDTO model, @PathVariable("id") int id){

        return ResponseEntity.ok().body(slotService.updateSlot(model, id));
        //System.out.println("OK");
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
//        return ResponseEntity.ok().body(slotService.deleteSlot(id)) ;
//    }
}
