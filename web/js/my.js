// JavaScript Document

$(function(){
	
    $(".item").hide();
    $(".item2").hide();
    $(".item3").hide();
    $(".selected").show();
    $(".selected2").show();
    $(".selected3").show();
    
  
    $(".regMenu").click(function(){
            
        $(".regMenu").removeClass("activeMenu");
        /*non- appointmennt submenu should remove the acctive menu from appointment
         *and its submenu */
        $(".appointment").removeClass("activeMenu");
        $(".appt_menu").removeClass("activeAppoinment");
        
        /*If it was the appointment submenu that was clicked, then it should the active menu in the \n\
            appointment*/
        $(".appt_menu").click(function(){
            $(".appointment").addClass("activeMenu");
        });
        
        $(this).addClass("activeMenu");
        show_content($(this).attr("name"));
    });
    
    //the appointment menu 
    $(".appt_menu").click(function(){
        $(".appointment").addClass("activeMenu");
        $(".appt_menu").removeClass("activeAppoinment");
        $(this).addClass("activeAppoinment");
        
    });
    
                
    $(".sub_regMenu").click(function(){
            
        $(".sub_regMenu").removeClass("activeSubMenu");
        $(this).addClass("activeSubMenu");
        show_sub_content($(this).attr("name"));
    });
          
                   
    $(".sub_sub_regMenu").click(function(){
            
        $(".sub_sub_regMenu").removeClass("activeSubSubMenu");
        $(this).addClass("activeSubSubMenu");
        show_sub_sub_content($(this).attr("name"));
    });


});

function show_content(type){
    if($("." + type).hasClass("selected")==false){
        $(".item").fadeOut();
        $("." + type).fadeIn();
        $(".selected").removeClass("selected");
        $("." + type).addClass("selected");
		
    }
}


function show_sub_content(type){
    if($("." + type).hasClass("selected")==false){
        $(".item2").fadeOut();
        $("." + type).fadeIn();
        $(".selected2").removeClass("selected2");
        $("." + type).addClass("selected2");
		
    }
}


function show_sub_sub_content(type){
    if($("." + type).hasClass("selected")==false){
        $(".item3").fadeOut();
        $("." + type).fadeIn();
        $(".selected3").removeClass("selected3");
        $("." + type).addClass("selected3");
		
    }
}

