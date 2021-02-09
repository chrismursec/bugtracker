package dev.chrismursec.bugtracker.bug;

import java.util.List;

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
@RequestMapping(path = "api/v1/bugs")
public class BugController {

  private final BugService bugService;

  @Autowired
  public BugController(BugService bugService) {
    this.bugService = bugService;
  }
  @CrossOrigin
  @GetMapping
  public List<Bug> getBugs() {
    return bugService.getBugs();
  }
  @CrossOrigin
  @PostMapping
  public void addNewBug(@RequestBody Bug bug) {
    bugService.addNewBug(bug);
  }

  @CrossOrigin
  @DeleteMapping(path = "{bugId}")
  public void deleteBug(@PathVariable Long bugId) {
    bugService.deleteBug(bugId);
  }


  
}
