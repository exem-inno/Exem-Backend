package com.backend.controller;

import com.backend.controller.dto.NamespaceDto;
import com.backend.controller.dto.NodeDto;
import com.backend.model.Domain;
import com.backend.model.FromTo;
import com.backend.model.dao.DomainDAO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DomainController {

    @Autowired
    private DomainDAO domainDAO;

    @PostMapping("/api/sample")
    public void saveData(@RequestBody List<Domain> domain) {
            domainDAO.saveAll(domain);
    }

    @GetMapping("/api/clusters/{cluster_id}/namespaces")
    public ResponseEntity getAllNodePodCount(@ApiParam(value = "5sznUu5z49IasTL9dN-6fx") @PathVariable String cluster_id) {

        List<String> list = domainDAO.findNamespaceAll(cluster_id);
        List<NamespaceDto> namespaceDtoList = new ArrayList<>();
        for (String s : list) {
            List<Integer> temp = domainDAO.countNamespaceElementNum(s);
            namespaceDtoList.add(new NamespaceDto(s, temp.get(0), temp.get(1)));
        }
        return ResponseEntity.ok().body(namespaceDtoList);
    }

    @GetMapping("/api/nodes")
    public ResponseEntity getNodeAllPodCount() {
        List<String> list = domainDAO.findNodeAll();
        List<NodeDto> nodeDtoList = new ArrayList<>();
        for (String s : list) {
            nodeDtoList.add(new NodeDto(s, domainDAO.findPodNum(s)));
        }
        return ResponseEntity.ok().body(nodeDtoList);
    }

    @GetMapping("/api/fromTo")
    public ResponseEntity getFromTo() {
        List<FromTo> fromToList = domainDAO.findAllFromTo();
        return ResponseEntity.ok().body(domainDAO.findFromToDto(fromToList));
    }

    @GetMapping("/api/clusters/{cluster_id}/namespaces/{namespace_id}/services/{service_id}/request")
    public ResponseEntity getTimeService(@PathVariable String cluster_id, @PathVariable String namespace_id, @PathVariable String service_id) {

        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/total")
    public ResponseEntity getAllGraph(@RequestParam("page") Long page, @RequestParam("limit") int limit) {
        return ResponseEntity.ok().body(domainDAO.findAllTotalGraph(page, limit));
    }
}
