package dev.chrismursec.bugtracker.project;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectDAO {

  @Autowired
  private ProjectRepository repository;

  public Collection<Project> getProjects() {
    return repository.findAll();
  }

  public Project getProject(long id) {
    return repository.findById(id).get();
  }

  public Project createProject(Project project) {
    return repository.insert(project);
  }

  public Optional<Project> deleteProjectByID(long id) {
    Optional<Project> project = repository.findById(id);
    project.ifPresent(p -> repository.delete(p));
    return project;
  }

}
