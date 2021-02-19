package dev.chrismursec.bugtracker.bug;

import java.util.ArrayList;
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
  @GetMapping(path = "{bugId}")
  public Bug getBut(@PathVariable("bugId") long id) {
    return bugService.getBug(id);
  }

  @CrossOrigin
  @PostMapping
  public void postBug(@RequestBody Bug bug) {
    bugService.createBug(bug);
  }

  @CrossOrigin
  @DeleteMapping(path = "{bugId}")
  public Bug deleteBugById(@PathVariable("bugId") long id) {
    return bugService.deleteBugById(id);
  }

  @CrossOrigin
  @GetMapping(path = "/project/{projectId}")
  public ArrayList<Bug> findByProjectId(@PathVariable("projectId") long id) {
    return bugService.getByProjectId(id);
  }

  @CrossOrigin
  @PostMapping(path = "/toggleComplete/{bugId}")
  public Bug toggleComplete(@PathVariable("bugId") long id) {
    return bugService.toggleComplete(id);
  }

}
