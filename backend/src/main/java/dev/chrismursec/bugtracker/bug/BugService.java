package dev.chrismursec.bugtracker.bug;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {
  
  @Autowired
  private BugDAO bugDao;

  public Collection <Bug> getBugs() {
    return bugDao.getBugs();
  }

  public Bug createBug(Bug bug) {
    return bugDao.createBug(bug);
  }

  public Optional<Bug> deleteBugById(long id) {
      return bugDao.deleteBugById(id);
    }
}
