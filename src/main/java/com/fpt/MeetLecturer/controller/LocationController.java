package com.fpt.MeetLecturer.controller;

import com.fpt.MeetLecturer.business.LocationDTO;
import com.fpt.MeetLecturer.business.ResponseDTO;
import com.fpt.MeetLecturer.service.LocationService;
import com.fpt.MeetLecturer.util.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @GetMapping("")
    public ResponseEntity<ResponseDTO> getAllLocation(){
        return ResponseEntity.ok().body(locationService.getAllLocation());
    }
    @GetMapping("/public")
    public ResponseEntity<ResponseDTO> getAllPublicLocation(/*@RequestParam(value = "token") String token*/){
//        if(token.equals(Utility.getkey())){
//            return ResponseEntity.ok().body(locationService.getAllPublicLocation());
//        }
        return ResponseEntity.ok().body(locationService.getAllPublicLocation());
        //return null;
    }
    @GetMapping("/personal")
    public ResponseEntity<ResponseDTO> getAllPersonalLocation(@RequestParam(value = "Lecturer-id") String id){
        return ResponseEntity.ok().body(locationService.getAllPersonalLocation(id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLocation(@RequestParam(value = "id")int id){
        return ResponseEntity.ok().body(locationService.deleteLocation(id));
    }
    @PostMapping("/new-location")
    public ResponseEntity<ResponseDTO> createLocation(@Valid @RequestBody LocationDTO locationDTO){
       return ResponseEntity.ok().body(locationService.createLocation(locationDTO));
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public  ResponseEntity<ResponseDTO> updateLocation(@Valid @RequestBody LocationDTO locationDTO, @PathVariable("id") int id){
        return ResponseEntity.ok().body(locationService.updateLocation1(locationDTO));
    }

}
