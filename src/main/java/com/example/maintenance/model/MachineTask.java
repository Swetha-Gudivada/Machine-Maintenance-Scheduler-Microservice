package com.example.maintenance.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "machine_tasks")
@Data
public class MachineTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @Column(name = "task_description")
    private String taskDescription;

    @Column(name = "scheduled_date")
    private LocalDate scheduledDate;

    @Column(name = "status")
    private String status;

    @Column(name = "completed_on")
    private LocalDate completedOn;
}
