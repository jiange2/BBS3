package com.gdut.bbs.domain;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

public class JsonResult {

    private boolean status = true;
    private Map<String,String> errors = null;
    private Map<String,Object> info = null;

    public JsonResult(){

    }

    public JsonResult(boolean status){
        this.status = status;
    }

    public void setStatus(){
        status = errors == null || errors.size() == 0;
    }

    public void addError(String field, String message){
        this.getErrorsMap().put(field,message);
    }

    public void addErrors(BindingResult result){
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, String> map = this.getErrorsMap();
        for(FieldError error : fieldErrors){
            map.put(error.getField(), error.getDefaultMessage());
        }
    }

    public void addInfo(String field, Object obj){
        this.getInfoMap().put(field, obj);
    }

    private Map<String, String> getErrorsMap(){
        return errors == null ? (errors = new HashMap<>()) : errors;
    }

    private Map<String, Object> getInfoMap(){
        return info == null ? (info = new HashMap<>()) : info;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public boolean isStatus() {
        return status;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfos(Map<String, Object> info) {
        this.info = info;
    }
}