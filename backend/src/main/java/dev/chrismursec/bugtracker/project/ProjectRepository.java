package dev.chrismursec.bugtracker.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, Long> {

}
