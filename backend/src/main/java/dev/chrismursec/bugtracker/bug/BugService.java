package dev.chrismursec.bugtracker.bug;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugService {
  
  private static final String Optional = null;
  private final BugRepository bugRepository;

  @Autowired
  public BugService(BugRepository bugRepository) {
    this.bugRepository = bugRepository;
  }

  public List<Bug> getBugs() {
    return bugRepository.findAll();
  }

  public void addNewBug(Bug bug) {
    bugRepository.save(bug);
  }

  public void deleteBug(Long bugId) {
    bugRepository.deleteById(bugId);
  }

}
