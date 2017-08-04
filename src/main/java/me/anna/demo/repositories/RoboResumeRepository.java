package me.anna.demo.repositories;

import me.anna.demo.models.User;
import org.springframework.data.repository.CrudRepository;



public interface RoboResumeRepository extends CrudRepository <User, Long> {

}
