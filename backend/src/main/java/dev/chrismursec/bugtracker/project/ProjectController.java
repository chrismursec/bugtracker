package dev.chrismursec.bugtracker.project;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @CrossOrigin
  @GetMapping
  public Collection<Project> getProjects() {
    return projectService.getProjects();
  }

  @CrossOrigin
  @GetMapping(path = "{projectId}")
  public Project getProject(@PathVariable("projectId") long id) {
    return projectService.getProject(id);
  }

  @CrossOrigin
  @PostMapping
  public void postProject(@RequestBody Project project) {
    projectService.createProject(project);
  }

  @CrossOrigin
  @DeleteMapping(path = "{projectId}")
  public void deleteProject(@PathVariable("projectId") long id) {
    projectService.deleteProject(id);
  }

}
