package com.grails.ocb

class GlobalConfig {

    private static final def USER_TYPE=[
        ADMINISTRATOR:"ADMINISTRATOR",
        REGULAR_MEMBER:"REGULAR MEMBER",
    ]

    private static Integer itemsPerPage(){
        return 10;
    }

}
