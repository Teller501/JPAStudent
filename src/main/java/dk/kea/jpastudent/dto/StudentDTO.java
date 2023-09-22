package dk.kea.jpastudent.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record StudentDTO(int id, String name, LocalDate bornDate, LocalTime bornTime) {
}
