package edu.miu.cs.cs425.mystudentmgmt.service.impl;

import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.mystudentmgmt.service.TranscriptService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TranscriptServiceImpl implements TranscriptService {

    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public void saveTranscript(Transcript transcript) {
        transcriptRepository.save(transcript);
    }
}
