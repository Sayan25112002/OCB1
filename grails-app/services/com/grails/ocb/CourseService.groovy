package com.grails.ocb

import grails.web.servlet.mvc.GrailsParameterMap
import ocb.Course

class CourseService {

    def save(GrailsParameterMap params){
        Course course=new Course(params)
        def response=AppUtil.saveResponse(false,course)
        if(course.validate()){
            course.save(flush:true)
            if(!course.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def update(Course course, GrailsParameterMap params){
        course.properties=params
        def response = AppUtil.saveResponse(false,course)
        if(course.validate()){
            course.save(flush:true)
            if(!course.hasErrors()){
                response.isSuccess=true
            }
        }
        return response
    }

    def getById(Serializable id){
        return Course.get(id)
    }

    def list(GrailsParameterMap params){
        params.max = params.max?:GlobalConfig.itemsPerPage()
        List<Course> courseList = Course.createCriteria().list {
            if(params?.colName && params?.colValue){
                ilike(params.colName,"%"+params.colValue+"%")
            }
            if(!params.sort()){
                order("id","desc")
            }
        }
        return [list:courseList,count:Course.count()]
    }

    def delete(Course course){
        try{
            course.delete(flush:true)
        }catch (Exception e){
            println(e.getMessage())
            return false
        }
        return true
    }

}
