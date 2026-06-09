package com.grails.ocb

class CourseController {

    CourseService courseService

    def index() {
        def response = courseService.list(params)
        [courses:response.list, total:response.count]
    }

    def details(Integer id){
        def response = courseService.getById(id)
        if(!response){
            flash.message=AppUtil.infoMessage(g.message(code:"course.not.present"),false)
            redirect(controller:"course",action:"index")
        }else{
            [contact:"response"]
        }
    }

    def create(){
        [contact:flash.redirectParams]
    }

    def save(){
        def response = courseService.save(params)
        if(response.isSuccess){
            flash.message = AppUtil.infoMessage("saved",true)
            redirect(controller: "course",action: "index")
        }else{
            flash.message = AppUtil.infoMessage("unable.to.save",false)
            redirect(controller: "course", action: "create")
        }
    }

    def edit(Integer id){
        if(flash.redirectParams){
            [course:flash.redirectParams]
        }
        else{
            def response = courseService.getById(id)
            if(!response){
                flash.message = AppUtil.infoMessage("invalid.entity",false)
                redirect(controller: "course", action: "index")
            }
            else{
                [course: response]
            }
        }
    }

    def update(){
        def response = courseService.getById(params.id)
        if(!response){
            flash.message = AppUtil.infoMessage("invalid.entity",false)
            redirect(controller: "course", action: "index")
        }else{
            response = courseService.update(response,params)
            if(!response.isSuccess){
                flash.redirectParams = response.model
                flash.message = AppUtil.infoMessage(g.message(code:"unable.to.update"),false)
                redirect(controller: "course", action: "create")
            }else{
                flash.message = AppUtil.infoMessage(g.message(code:"updated"),true)

            }
        }
    }

    def delete(Integer id){
        def response = courseService.getById(id)
        if(!response){
            flash.message = AppUtil.infoMessage("invalid.entity",false)
        }else{
            response = courseService.delete(response)
            if(!response){
                flash.message = AppUtil.infoMessage("unable.to.delete",false)
            }else{
                flash.message = AppUtil.infoMessage("deleted",true)
            }
        }
        redirect(controller: "course",action: "index")
    }
}
