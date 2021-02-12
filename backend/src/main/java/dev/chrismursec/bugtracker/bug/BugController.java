package dev.chrismursec.bugtracker.bug;

import java.util.Collection;
import java.util.Optional;

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

  @Autowired
  private BugService bugService;

  @CrossOrigin
  @GetMapping
    public Collection<Bug> getBugs() {
      return bugService.getBugs();
    }

  @CrossOrigin
  @PostMapping
  public void postBug(@RequestBody Bug bug) {
    bugService.createBug(bug);
  }

  @CrossOrigin
  @DeleteMapping(path ="{bugId}")
  public Optional<Bug> deleteBugById(@PathVariable("bugId") long id) {
      return bugService.deleteBugById(id);
  }
}
