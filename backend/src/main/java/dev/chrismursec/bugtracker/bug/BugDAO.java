package dev.chrismursec.bugtracker.bug;

import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BugDAO {

  @Autowired
  private BugRepository repository;

  public Collection<Bug> getBugs() {
    return repository.findAll();
  }

  public Bug createBug(Bug bug) {
    return repository.insert(bug);
  }

  public Optional<Bug> deleteBugById(long id) {
    Optional<Bug> bug = repository.findById(id);
    bug.ifPresent(b -> repository.delete(b));
    return bug;
  }
  
}
