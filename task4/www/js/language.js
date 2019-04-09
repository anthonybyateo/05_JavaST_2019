$(document).ready(function(){
    filter_data();    
    
    function filter_data(language){
        var lang = language;
        $.ajax({
            url:"/webTask4/data",
            method:"POST",
            data:{parser:parser},
            success:function(data){
            }
        });    
    }  
    $('#en').click(function(){
    filter_data("en");
    });
    $('#ru').click(function(){
    filter_data("ru");
    });
    $('#by').click(function(){
    filter_data("by");
    });
});