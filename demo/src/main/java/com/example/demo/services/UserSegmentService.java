package com.example.demo.services;

import com.example.demo.model.SegmentGift;
import com.example.demo.model.UserSegment;
import com.example.demo.repository.SegmentGiftRepository;
import com.example.demo.repository.UserSegmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserSegmentService {


    private final UserSegmentRepository userSegmentRepository;
    private final SegmentGiftRepository segmentGiftRepository;

public UserSegmentService(UserSegmentRepository userSegmentRepository, SegmentGiftRepository segmentGiftRepository) {
    this.userSegmentRepository = userSegmentRepository;
    this.segmentGiftRepository = segmentGiftRepository;
}

public List<UserSegment> getAllUserSegments() {
    return (List<UserSegment>) userSegmentRepository.findAll();
}

    @Transactional
    public void setSegmentToUser(Integer userId, String dial, String segment) {
        userSegmentRepository.setSegmentToUser(userId, dial, segment);
    }


    @Transactional
    public void updateUserSegment(Integer userId, String dial, String segment) {
        userSegmentRepository.updateUserSegment(userId, dial, segment);
    }

    @Transactional
    public SegmentGift getSegmentGiftBySegment(String segment) {
        return segmentGiftRepository.findSegmentGiftBySegment(segment);
    }

    @Transactional
    public Optional<UserSegment> findUserByDial(String dial) {
        return userSegmentRepository.findUserByDial(dial);

    }
}
