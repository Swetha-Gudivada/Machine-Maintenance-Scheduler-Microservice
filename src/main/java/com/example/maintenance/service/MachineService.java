package com.example.maintenance.service;

import org.springframework.stereotype.Service;
import com.example.maintenance.model.Machine;
import java.time.LocalDate;

@Service
public class MachineService {

    private static final LocalDate SYSTEM_DATE = LocalDate.of(2025, 12, 1);
    public String generateSimulationLog(Machine machine) {

    if (isOverdue(machine)) {
        return "⚠ Machine overdue. Immediate service recommended.";
    }

    if (calculateRiskScore(machine) > 40) {
        return "⚡ High wear detected based on interval trend.";
    }

    return "✔ Machine operating within normal parameters.";
}

    public LocalDate calculateNextDueDate(Machine machine) {
        return machine.getLastMaintenanceDate()
                .plusDays(machine.getMaintenanceIntervalDays());
    }

    public boolean isOverdue(Machine machine) {
        return calculateNextDueDate(machine).isBefore(SYSTEM_DATE);
    }

    public String getDynamicStatus(Machine machine) {
        if (isOverdue(machine)) {
            return "Overdue";
        }
        return machine.getStatus();
    }

    public int calculateRiskScore(Machine machine) {

        LocalDate nextDue = calculateNextDueDate(machine);
        long daysOverdue = SYSTEM_DATE.toEpochDay() - nextDue.toEpochDay();

        if (daysOverdue <= 0) {
            return 5;
        } else if (daysOverdue <= 15) {
            return 25;
        } else if (daysOverdue <= 45) {
            return 50;
        } else {
            return 80;
        }
    }

    public String getRiskLevel(int score) {
        if (score < 20) return "LOW";
        else if (score < 50) return "MEDIUM";
        else return "HIGH";
    }

    public double calculateHealthScore(Machine machine) {
        int risk = calculateRiskScore(machine);
        double health = 100 - risk;
        if (health < 0) health = 0;
        return Math.round(health);
    }
}
