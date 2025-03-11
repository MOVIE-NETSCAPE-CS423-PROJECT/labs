package edu.miu.cs.cs425.mystudentmgmt.service.impl;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.mystudentmgmt.service.ClassroomService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }


    @Override
    public void saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
