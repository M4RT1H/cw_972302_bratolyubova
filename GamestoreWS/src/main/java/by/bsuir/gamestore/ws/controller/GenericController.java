package by.bsuir.gamestore.ws.controller;

import by.bsuir.gamestore.ws.service.GenericService;
import by.bsuir.gamestore.ws.tool.Searchable;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

public abstract class GenericController<T extends Searchable<K>, K extends Serializable> {

    private GenericService<T, K> service;
    private final Logger LOGGER;

    GenericController(GenericService<T, K> service, Logger logger) {
        this.service = service;
        this.LOGGER = logger;
    }

    GenericService<T, K> getService() {
        return service;
    }

    Logger getLogger() {
        return LOGGER;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<T> addEntity(@RequestBody T entity) {
        if (!service.isAlreadyExist(entity)) {
            return new ResponseEntity<>(service.add(entity), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    public ResponseEntity<T> getEntity(@PathVariable("key") K key) {
        T entity = service.find(key);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<T> updateEntity(@RequestBody T newEntity) {
        T entity = service.find(newEntity.getId());
        if (entity != null && !service.isAlreadyExist(newEntity)) {
            return new ResponseEntity<>(service.update(newEntity), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "delete/{key}", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteEntity(@PathVariable("key") K key) {
        if (service.deleteById(key)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<T>> getCountrySet() {
        List<T> entities = service.findAll();
        if (!entities.isEmpty()) {
            return new ResponseEntity<>(entities, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}