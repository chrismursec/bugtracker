package dev.chrismursec.bugtracker.bug;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BugRepository extends MongoRepository<Bug, Long> {

  public ArrayList<Bug> findByProjectId(long id);

}
