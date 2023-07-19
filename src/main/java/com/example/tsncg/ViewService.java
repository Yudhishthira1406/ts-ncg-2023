package com.example.tsncg;

import com.example.tsncg.ViewEntity;
import com.example.tsncg.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewService {
    private final ViewRepository viewRepository;

    @Autowired
    public ViewService(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    public List<ViewEntity> getAllViews() {
        return viewRepository.findAll();
    }

    public Optional<ViewEntity> getViewById(Long id) {
        return viewRepository.findById(id);
    }

    public ViewEntity saveView(ViewEntity view) {
        return viewRepository.save(view);
    }
    
    public boolean deleteView(Long viewId) {
        if (viewRepository.existsById(viewId)) {
            viewRepository.deleteById(viewId);
            return true;
        }
        return false;
 
    }

    public ViewEntity updateView(Long viewId, ViewEntity viewRequestDTO) {


        Optional<ViewEntity> viewOptional = viewRepository.findById(viewId);
        if (!viewOptional.isPresent()) {
        return null;
        }
        
        
        ViewEntity existingView = viewOptional.get();
        existingView.setName(viewRequestDTO.getName());
        existingView.setChartType(viewRequestDTO.getChartType());
        existingView.setCountry(viewRequestDTO.getCountry());
        existingView.setIndicator(viewRequestDTO.getIndicator());
        existingView.setStartDate(viewRequestDTO.getStartDate());
        existingView.setEndDate(viewRequestDTO.getEndDate());
        
        
        return viewRepository.save(existingView);
        }
        

    public void deleteViewById(Long id) {
        viewRepository.deleteById(id);
    }

}

