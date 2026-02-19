package com.example.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.maintenance.repository.MachineRepository;
import com.example.maintenance.service.MachineService;
import com.example.maintenance.model.Machine;

import java.util.List;

@Controller
public class MachineController {

    @Autowired
    private MachineRepository machineRepo;

    @Autowired
    private MachineService machineService;

    @GetMapping("/")
public String viewMachines(Model model) {

    List<Machine> machines = machineRepo.findAll();

    long totalMachines = machines.size();

    long lowRisk = machines.stream()
            .filter(m -> machineService.getRiskLevel(
                    machineService.calculateRiskScore(m)).equals("LOW"))
            .count();

    long mediumRisk = machines.stream()
            .filter(m -> machineService.getRiskLevel(
                    machineService.calculateRiskScore(m)).equals("MEDIUM"))
            .count();

    long highRisk = machines.stream()
            .filter(m -> machineService.getRiskLevel(
                    machineService.calculateRiskScore(m)).equals("HIGH"))
            .count();

    long overdue = machines.stream()
            .filter(machineService::isOverdue)
            .count();

    model.addAttribute("machines", machines);
    model.addAttribute("service", machineService);
    model.addAttribute("totalMachines", totalMachines);
    model.addAttribute("lowRisk", lowRisk);
    model.addAttribute("mediumRisk", mediumRisk);
    model.addAttribute("highRisk", highRisk);
    model.addAttribute("overdue", overdue);
    

    return "dashboard";
}

    
}
