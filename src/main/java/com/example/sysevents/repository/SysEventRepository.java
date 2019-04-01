package com.example.sysevents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sysevents.entity.SysEvent;

public interface SysEventRepository extends MongoRepository<SysEvent,String>{

}
