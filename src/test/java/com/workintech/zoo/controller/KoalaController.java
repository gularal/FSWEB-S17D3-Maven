package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Kangaroo.Koala> koalaMap = new HashMap<>();

    @PostMapping
    public Kangaroo.Koala saveKoala(@RequestBody Kangaroo.Koala koala) {
        if(koala.getId() == 0 || koala.getName() == null) {
            throw new ZooException("Invalid Koala data", HttpStatus.BAD_REQUEST);
        }
        koalaMap.put(koala.getId(), koala);
        return koala;
    }

    @GetMapping
    public List<Kangaroo.Koala> findAll() {
        return new ArrayList<>(koalaMap.values());
    }

    @GetMapping("/{id}")
    public Kangaroo.Koala findById(@PathVariable int id) {
        Kangaroo.Koala koala = koalaMap.get(id);
        if (koala == null) {
            throw new ZooException("Koala not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return koala;
    }

    @PutMapping("/{id}")
    public Kangaroo.Koala updateKoala(@PathVariable int id, @RequestBody Kangaroo.Koala koala) {
        if (!koalaMap.containsKey(id)) {
            throw new ZooException("Koala not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        koalaMap.put(id, koala);
        return koala;
    }

    @DeleteMapping("/{id}")
    public void deleteKoala(@PathVariable int id) {
        Kangaroo.Koala removed = koalaMap.remove(id);
        if (removed == null) {
            throw new ZooException("Koala not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
