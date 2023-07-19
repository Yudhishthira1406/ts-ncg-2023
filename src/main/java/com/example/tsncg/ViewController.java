package com.example.tsncg;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tsncg.ViewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/view")
public class ViewController {
    ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping
    public ResponseEntity<ViewEntity> createView(@RequestBody ViewEntity viewRequestDTO) {
        try {
            ViewEntity savedView = viewService.saveView(viewRequestDTO);
            return new ResponseEntity<>(savedView, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<ViewEntity>> getAllViews() {
        try {
            List<ViewEntity> savedView = viewService.getAllViews();
            return new ResponseEntity<>(savedView, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{viewId}")
    public ResponseEntity<Optional<ViewEntity>> getViewById(@PathVariable Long viewId) {
        try {
            Optional<ViewEntity> view = viewService.getViewById(viewId);
            if (view != null) {
                return new ResponseEntity<>(view, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{viewId}")
    public ResponseEntity<Void> deleteViewById(@PathVariable Long viewId) {
        try {
            boolean deleted = viewService.deleteView(viewId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{viewId}")
    public ResponseEntity<ViewEntity> updateViewById(@PathVariable Long viewId,
            @RequestBody ViewEntity viewRequestDTO) {
        try {
            ViewEntity updatedView = viewService.updateView(viewId, viewRequestDTO);
            if (updatedView != null) {
                return new ResponseEntity<>(updatedView, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
