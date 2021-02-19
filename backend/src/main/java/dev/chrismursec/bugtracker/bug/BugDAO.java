package dev.chrismursec.bugtracker.bug;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.chrismursec.bugtracker.project.Project;
import dev.chrismursec.bugtracker.project.ProjectRepository;

@Component
public class BugDAO {

  @Autowired
  private BugRepository repository;
  @Autowired
  private ProjectRepository projectRepository;

  public Collection<Bug> getBugs() {
    return repository.findAll();
  }

  public Bug createBug(Bug bug) {
    Project project = projectRepository.findById(bug.getProjectId()).get();
    repository.insert(bug);
    ArrayList<Long> currentBugs = project.getBugs();
    currentBugs.add(bug.getId());
    project.setBugs(currentBugs);
    projectRepository.save(project);
    return bug;
  }

  public Bug getBug(long id) {
    return repository.findById(id).get();
  }

  public Bug deleteBugById(long id) {
    Bug bug = repository.findById(id).get();
    // bug.ifPresent(b ->

    // repository.delete(b)
    // );

    Project project = projectRepository.findById(bug.getProjectId()).get();
    ArrayList<Long> projectsBugs = project.getBugs();
    projectsBugs.remove(id);
    projectRepository.save(project);
    repository.delete(bug);

    return bug;
  }

  public ArrayList<Bug> getBugByProjectId(long id) {
    return repository.findByProjectId(id);
  }

  public Bug toggleComplete(long id) {
    Bug bug = this.repository.findById(id).get();
    bug.setComplete(!bug.getComplete());
    repository.save(bug);
    return bug;
  }

}
