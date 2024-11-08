package com.example.backend.service.borrowers;

import com.example.backend.model.Borrower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService implements IBorrowerService {
    @Autowired
    private
    @Override
    public List<Borrower> getBorrowers() {
        return List.of();
    }
}