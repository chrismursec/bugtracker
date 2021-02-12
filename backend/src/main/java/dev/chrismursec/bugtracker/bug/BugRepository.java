package dev.chrismursec.bugtracker.bug;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BugRepository extends MongoRepository<Bug, Long> {
  
}
