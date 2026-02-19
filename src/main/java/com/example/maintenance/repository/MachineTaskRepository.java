package com.example.maintenance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import com.example.maintenance.model.MachineTask;

public interface MachineTaskRepository extends JpaRepository<MachineTask, Long> {
    List<MachineTask> findByScheduledDateAfter(LocalDate date);
    List<MachineTask> findByMachine_MachineId(Long machineId);
    List<MachineTask> findByStatus(String status);

}

