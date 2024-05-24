package net.javaguides.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.RandevuDto;
import net.javaguides.emsbackend.service.RandevuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/randevular")
public class RandevuController {

    @Autowired
    private RandevuService randevuService;

    @PostMapping
    public ResponseEntity<RandevuDto> createRandevu(@RequestBody RandevuDto randevuDto) {
        RandevuDto createdRandevu = randevuService.createRandevu(randevuDto);
        return new ResponseEntity<>(createdRandevu, HttpStatus.CREATED);
    }

    @GetMapping("/{randevuId}")
    public ResponseEntity<RandevuDto> getRandevuById(@PathVariable Long randevuId) {
        RandevuDto randevuDto = randevuService.getRandevuById(randevuId);
        return ResponseEntity.ok(randevuDto);
    }

    @GetMapping
    public ResponseEntity<List<RandevuDto>> getAllRandevular() {
        List<RandevuDto> randevular = randevuService.getAllRandevular();
        return ResponseEntity.ok(randevular);
    }

    @PutMapping("/{randevuId}")
    public ResponseEntity<RandevuDto> updateRandevu(@PathVariable Long randevuId, @RequestBody RandevuDto updatedRandevuDto) {
        RandevuDto updatedRandevu = randevuService.updateRandevu(randevuId, updatedRandevuDto);
        return ResponseEntity.ok(updatedRandevu);
    }

    @DeleteMapping("/{randevuId}")
    public ResponseEntity<Void> deleteRandevu(@PathVariable Long randevuId) {
        randevuService.deleteRandevu(randevuId);
        return ResponseEntity.noContent().build();
    }
}
