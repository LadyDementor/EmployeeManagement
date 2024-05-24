package net.javaguides.emsbackend.service.impl;


import lombok.AllArgsConstructor;
import net.javaguides.emsbackend.dto.RandevuDto;
import net.javaguides.emsbackend.entity.Randevu;
import net.javaguides.emsbackend.entity.Seat;
import net.javaguides.emsbackend.exception.SeatAlreadyBookedException;
import net.javaguides.emsbackend.repository.RandevuRepository;
import net.javaguides.emsbackend.repository.SeatRepository;
import net.javaguides.emsbackend.service.RandevuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RandevuServiceImpl implements RandevuService {
    @Autowired
    private RandevuRepository randevuRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public RandevuDto createRandevu(RandevuDto randevuDto) {
        Long seatId = randevuDto.getSeat().getId();
        Optional<Seat> seat = seatRepository.findById(seatId);

        if (seat.isPresent() && randevuRepository.existsBySeatId(seatId)) { // Koltuğun mevcut olup olmadığını ve zaten rezerve edilip edilmediğini kontrol edin
            throw new SeatAlreadyBookedException("This seat is already booked");
        }
        Seat actualSeat = seat.orElseThrow(() -> new RuntimeException("Seat not found with id: " + seatId));
        actualSeat.setIsOccupied(true);
        seatRepository.save(actualSeat);

        Randevu randevu = modelMapper.map(randevuDto, Randevu.class);
        randevu.setSeat(actualSeat);
        Randevu savedRandevu = randevuRepository.save(randevu);
        return modelMapper.map(savedRandevu, RandevuDto.class);
    }
    @Override
    public RandevuDto getRandevuById(Long randevuId) {
        Optional<Randevu> optionalRandevu = randevuRepository.findById(randevuId);
        if (optionalRandevu.isPresent()) {
            Randevu randevu = optionalRandevu.get();
            return modelMapper.map(randevu,RandevuDto.class);
        }
        throw new RuntimeException("Randevu not found with id: " + randevuId);
    }

    @Override
    public List<RandevuDto> getAllRandevular() {
        List<Randevu> randevular = randevuRepository.findAll();
        List<RandevuDto> randevuDtoList= randevular.stream().map(randevu -> modelMapper.map(randevu, RandevuDto.class)).toList();
        return randevuDtoList;
    }

    @Override
    public RandevuDto updateRandevu(Long randevuId, RandevuDto updatedRandevuDto) {
        Optional<Randevu> optionalRandevu = randevuRepository.findById(randevuId);
        if (optionalRandevu.isPresent()) {
           Seat emptySeat = optionalRandevu.get().getSeat();
            emptySeat.setIsOccupied(false);
            seatRepository.save(emptySeat);
            Randevu updatedRandevu = randevuRepository.save(modelMapper.map(updatedRandevuDto,Randevu.class));
          Seat occupiedSeat = seatRepository.findById(updatedRandevuDto.getSeat().getId())
                    .orElseThrow(() -> new RuntimeException("Seat not found with id: " + updatedRandevuDto.getSeat().getId()));
            occupiedSeat.setIsOccupied(true);
            seatRepository.save(occupiedSeat);

           return modelMapper.map(updatedRandevu,RandevuDto.class);
        }
        throw new RuntimeException("Randevu not found with id: " + randevuId);
    }

    @Override
    public void deleteRandevu(Long randevuId) {
        Optional<Randevu> optionalRandevu = randevuRepository.findById(randevuId);
        if (optionalRandevu.isPresent()) {
            Randevu randevu = optionalRandevu.get();
            randevu.setIsActive(Boolean.FALSE);
            randevuRepository.save(randevu);
           Seat actualSeat = randevu.getSeat();
            actualSeat.setIsOccupied(false);
            seatRepository.save(actualSeat);
        } else {
            throw new RuntimeException("Randevu not found with id: " + randevuId);
        }
    }
}
