package dev.chrismursec.bugtracker.project;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectDAO projectDAO;

  public Collection<Project> getProjects() {
    return projectDAO.getProjects();
  }

  public Project getProject(long id) {
    return projectDAO.getProject(id);
  }

  public Project createProject(Project project) {
    return projectDAO.createProject(project);
  }

  public Optional<Project> deleteProject(long id) {
    return projectDAO.deleteProjectByID(id);
  }

}
