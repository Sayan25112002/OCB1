OCB.ajax=(function (){
    return{
        call:function (settings){
            var defaults={
                url:null,
                method:"POST",
                datatype: "json",
                afterComplete:null,
                beforeSubmit:null,
                success:null,
                beforeDefault:undefined,
                complete:undefined,
                data:null
            }

            if(settings){
                jQuery.extend(defaults,settings);
            }

            jQuery.ajax({
                url:defaults.url,
                type:defaults.method,
                datatype:defaults.datatype,
                data: defaults.data,
                beforeSend:function (){
                    if(defaults.beforeSend!==undefined){
                        defaults.beforeSend();
                    }
                },
                success: function (content){
                    defaults.success(content);
                },
                complete: function (){
                    if(defaults.complete!==undefined){
                        defaults.complete();
                    }
                }
            });
        }
    }
}());