package net.javaguides.emsbackend.controller;


import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.SeatDto;
import net.javaguides.emsbackend.entity.Seat;
import net.javaguides.emsbackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatDto>createSeat(@RequestBody SeatDto seatDto){
        SeatDto createdSeat=seatService.createSeat(seatDto);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

   /* public ResponseEntity<SeatDto>deleteSeat(@PathVariable Long seatId){
        seatService.deleteSeat()

    }

    */


}
