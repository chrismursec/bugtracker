package dev.chrismursec.bugtracker.bug;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {

  @Autowired
  private BugDAO bugDao;

  public Collection<Bug> getBugs() {
    return bugDao.getBugs();
  }

  public Bug createBug(Bug bug) {
    return bugDao.createBug(bug);
  }

  public Bug deleteBugById(long id) {
    return bugDao.deleteBugById(id);
  }

  public Bug getBug(long id) {
    return bugDao.getBug(id);
  }

  public ArrayList<Bug> getByProjectId(long id) {
    return bugDao.getBugByProjectId(id);
  }

  public Bug toggleComplete(long id) {
    return bugDao.toggleComplete(id);
  }
}
