package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
