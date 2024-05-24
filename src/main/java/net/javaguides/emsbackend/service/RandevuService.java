package net.javaguides.emsbackend.service;

import net.javaguides.emsbackend.dto.RandevuDto;

import java.util.Date;
import java.util.List;

public interface RandevuService {
    RandevuDto createRandevu(RandevuDto randevuDto);
    RandevuDto getRandevuById(Long randevuId);
    List<RandevuDto> getAllRandevular();
    RandevuDto updateRandevu(Long randevuId, RandevuDto updatedRandevuDto);
    void deleteRandevu(Long randevuId);
}
