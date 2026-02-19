package com.example.maintenance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.maintenance.repository.MachineTaskRepository;
import com.example.maintenance.repository.MachineRepository;
import com.example.maintenance.model.MachineTask;
import com.example.maintenance.model.Machine;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class MachineTaskController {

    @Autowired
    private MachineTaskRepository taskRepo;

    @Autowired
    private MachineRepository machineRepo;

    // View upcoming tasks
    @GetMapping("/upcoming")
    public String upcomingTasks(Model model) {
        List<MachineTask> tasks =
                taskRepo.findByScheduledDateAfter(LocalDate.now());
        model.addAttribute("tasks", tasks);
        return "upcoming";
    }

    // View tasks by machine
    @GetMapping("/machine/{id}")
    public String tasksByMachine(@PathVariable Long id, Model model) {
        List<MachineTask> tasks =
                taskRepo.findByMachine_MachineId(id);
        model.addAttribute("tasks", tasks);
        return "upcoming";
    }

    // Mark task as complete
    @GetMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {

        MachineTask task = taskRepo.findById(id).orElse(null);

        if (task != null) {
            task.setStatus("Completed");
            task.setCompletedOn(LocalDate.now());
            taskRepo.save(task);
        }

        return "redirect:/tasks/upcoming";
    }

    // Show schedule task form
    @GetMapping("/schedule")
    public String showScheduleForm(Model model) {
        model.addAttribute("task", new MachineTask());
        model.addAttribute("machines", machineRepo.findAll());
        return "schedule";
    }

    // Save new task
    @PostMapping("/save")
    public String saveTask(@ModelAttribute MachineTask task,
                           @RequestParam Long machineId) {

        Machine machine = machineRepo.findById(machineId).orElse(null);

        if (machine != null) {
            task.setMachine(machine);
            task.setStatus("Scheduled");
            taskRepo.save(task);
        }

        return "redirect:/tasks/upcoming";
    }
}
