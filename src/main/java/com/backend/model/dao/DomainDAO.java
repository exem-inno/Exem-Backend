package com.backend.model.dao;

import com.backend.controller.dto.FromToDto;
import com.backend.model.Domain;
import com.backend.model.FromTo;
import com.backend.model.ServiceID;
import com.backend.model.TotalGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DomainDAO {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveAll(List<Domain> domain) {
        mongoTemplate.insertAll(domain);
    }

    public List<String> findNamespaceAll(String cluster_id) {
        return mongoTemplate.findDistinct(new Query(), "_source.namespace", Domain.class, String.class);
    }

    public List<Integer> countNamespaceElementNum(String namespace) {
        Query query = new Query(Criteria.where("_source.namespace").is(namespace));
        List<Integer> array = new ArrayList<>();
        array.add(mongoTemplate.findDistinct(query,"_source.node", Domain.class, String.class).size());
        array.add(mongoTemplate.findDistinct(query,"_source.pod", Domain.class, String.class).size());
        return array;
    }

    public List<String> findNodeAll() {
        return mongoTemplate.findDistinct(new Query(), "_source.node", Domain.class, String.class);
    }

    public Integer findPodNum(String node_id) {
        Query query = new Query(Criteria.where("_source.node").is(node_id));

        return mongoTemplate.findDistinct(query, "_source.pod", Domain.class, String.class).size();
    }

    public List<FromToDto> findServiceFromTo(List<String> service) {
        List<FromToDto> fromToDtoList = new ArrayList<>();
        for (String from : service) {
            List<Domain> list = mongoTemplate.find(new Query(Criteria.where("_source.service").is(from)), Domain.class);

        }
        return fromToDtoList;
    }

    public List<ServiceID> findServiceArray() {
        return mongoTemplate.findAll(ServiceID.class);
    }

    public List<FromToDto> findFromToDto(List<FromTo> sourceList) {
        List<FromToDto> fromToDtoList = new LinkedList<>();
        List<ServiceID> serviceIDList = findServiceArray();

        for (FromTo e : sourceList) {
            String from_s = "";
            String to_s = "";
            for (int i = 0; i < serviceIDList.size(); i++) {
                if (serviceIDList.get(i).getService_id().contains(e.getFrom())) {
                    from_s = serviceIDList.get(i).get_id();
                }
                if (serviceIDList.get(i).getService_id().contains(e.getTo())) {
                    to_s = serviceIDList.get(i).get_id();
                }
            }
            if (from_s == "" || to_s == "")
                continue;
            FromToDto dto = new FromToDto(from_s, to_s, 1);
            boolean check = false;
            if (fromToDtoList.size() != 0) {
                for (int j = 0; j < fromToDtoList.size(); j++) {
                    if (fromToDtoList.get(j).equals(dto)) {
                        fromToDtoList.get(j).plusCount();
                        check = true;
                    }
                }
                if (!check)
                    fromToDtoList.add(dto);
            } else
                fromToDtoList.add(dto);
        }
        return fromToDtoList;
    }

    public List<FromTo> findAllFromTo() {
        return mongoTemplate.findAll(FromTo.class);
    }

    public List<TotalGraph> findAllTotalGraph(Long page, int limit) {
        Query query = new Query().skip(page * limit).limit(limit);
        return mongoTemplate.find(query, TotalGraph.class);
    }
}
