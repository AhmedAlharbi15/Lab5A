package com.example.lab5a.Controller;

import com.example.lab5a.Api.ApiResponse;
import com.example.lab5a.Model.Project;
import com.example.lab5a.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> shProject(){
        return projects;
    }
    @PostMapping("/add")
    public ApiResponse addproject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("added");
    }
    @PutMapping("/update/{index}")
    public ApiResponse Upproject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("Updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("delete");
    }
    @PostMapping("/change-status/{id}")
    public ApiResponse changestatus(@PathVariable String id){
        for (Project project:projects){
            if (project.getId().equals(id)){
                project.setStatus(!project.isStatus());
                return new ApiResponse("status");
            }
        }
        return new ApiResponse("not Project");
    }
    @GetMapping("/search/{title}")
    public ArrayList<Project> search(@PathVariable String title){
        ArrayList<Project>proj =new ArrayList<>();
        for (Project project:projects){
            if (project.getTitle().equalsIgnoreCase(title)){
                proj.add(project);
            }
        }
        return proj;
    }
    @GetMapping("proj/{companyName}")
    public ArrayList<Project> company(@PathVariable String companyName){
        ArrayList<Project>proje=new ArrayList<>();
        for (Project project:projects){
            if (project.getCompanyName().equalsIgnoreCase(companyName)){
                proje.add(project);
            }
        }
        return proje;
    }
}
