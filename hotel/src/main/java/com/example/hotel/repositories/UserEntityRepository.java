package com.example.hotel.repositories;

import com.example.hotel.dto.UserRoomDto;
import com.example.hotel.model.Rooms;
import com.example.hotel.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);

    @Query("SELECT new com.example.hotel.dto.UserRoomDto(U.username, U.firstName, U.lastName, COALESCE(SUM(R.amount), 0)) " +
            "FROM UserEntity U LEFT JOIN Rooms R ON U.id = R.user.id " +
            "GROUP BY U.id " +
            "HAVING COALESCE(SUM(R.amount), 0) > ?1")
    List<UserRoomDto> findUsersNeedToPayMoreThanAmount(double amount);

    default Double calculateTotalAmount(List<Rooms> rooms) {
        if (rooms != null) {
            return rooms.stream()
                    .mapToDouble(Rooms::getAmount)
                    .sum();
        }
        return 0.0;
    }

}
