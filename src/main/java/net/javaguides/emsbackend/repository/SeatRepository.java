package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Randevu;
import net.javaguides.emsbackend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {


}
