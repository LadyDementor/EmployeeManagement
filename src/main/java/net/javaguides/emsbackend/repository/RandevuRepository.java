package net.javaguides.emsbackend.repository;

import net.javaguides.emsbackend.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {

   // List<Randevu> findByReservationDateAndIsActiveTrue(Date date);
   boolean existsBySeatId(Long seatId);

    @Query(value = "SELECT reservation_date FROM randevular WHERE seat_id = ?1 AND is_active = true", nativeQuery = true)
    List<Date> randevular(Long seatId);

}
