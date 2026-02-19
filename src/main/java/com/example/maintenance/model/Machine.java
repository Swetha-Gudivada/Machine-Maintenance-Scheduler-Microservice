package com.example.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "machines")
@Data
public class Machine {

    @Id
    @Column(name = "machine_id")
    private Long machineId;

    private String name;
    
    private String location;

    @Column(name = "last_maintenance_date")
    private LocalDate lastMaintenanceDate;

    @Column(name = "maintenance_interval_days")
    private int maintenanceIntervalDays;

    private String status;
}

