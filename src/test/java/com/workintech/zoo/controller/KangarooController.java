package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangarooMap = new HashMap<>();

    @PostMapping
    public Kangaroo saveKangaroo(@RequestBody Kangaroo kangaroo) {
        if(kangaroo.getId() == 0 || kangaroo.getName() == null) {
            throw new ZooException("Invalid Kangaroo data", HttpStatus.BAD_REQUEST);
        }
        kangarooMap.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @GetMapping
    public List<Kangaroo> findAll() {
        return new ArrayList<>(kangarooMap.values());
    }

    @GetMapping("/{id}")
    public Kangaroo findById(@PathVariable int id) {
        Kangaroo kangaroo = kangarooMap.get(id);
        if (kangaroo == null) {
            throw new ZooException("Kangaroo not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        if (!kangarooMap.containsKey(id)) {
            throw new ZooException("Kangaroo not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        kangarooMap.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable int id) {
        Kangaroo removed = kangarooMap.remove(id);
        if (removed == null) {
            throw new ZooException("Kangaroo not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return removed;
    }
}
