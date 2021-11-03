package balzhunter.insidetrack.controller;

import balzhunter.insidetrack.model.Line;
import balzhunter.insidetrack.repo.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lines")
public class LineController {

    @Autowired
    private LineRepository lineRepository;

    @GetMapping("")
    List<Line> index() {
        return lineRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Line create(@RequestBody Line line) {
        return lineRepository.save(line);
    }

    @PutMapping("{id}")
    Line update(@PathVariable String id, @RequestBody Line line) {
        Line lineFromDb = lineRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        lineFromDb.setInvoiceNumber(line.getInvoiceNumber());
        lineFromDb.setInvoiceDate(line.getInvoiceDate());
        lineFromDb.setDistributorName(line.getDistributorName());
        lineFromDb.setDistributorAddress(line.getDistributorAddress());
        lineFromDb.setCustomerName(line.getCustomerName());
        lineFromDb.setCustomerAddress(line.getCustomerAddress());
        lineFromDb.setManufacturerName(line.getManufacturerName());
        lineFromDb.setManufacturerAddress(line.getManufacturerAddress());
        lineFromDb.setProductCode(line.getProductCode());
        lineFromDb.setProductDescription(line.getProductDescription());
        lineFromDb.setUnitOfMeasure(line.getUnitOfMeasure());
        lineFromDb.setQuantity(line.getQuantity());
        lineFromDb.setWeight(line.getWeight());
        lineFromDb.setUnitPrice(line.getUnitPrice());
        lineFromDb.setTotalPrice(line.getTotalPrice());

        return lineRepository.save(lineFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Line line = lineRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        lineRepository.delete(line);
    }
}
